import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

/*
 벽, 제초제, 나무 
 
 내가 문제를 제대로 이해했는지 보자ㅑ
 문제 이해하고 틀짜는데 1시간
 구현하기까지 2시간 
 
 배열복사할 때, 참조형인거 복사방법 
 N과 M
 
 
 1. 성장 - 나무에서 인접한 나무개수만큼 증가 
 2. 번식 - 나무에서 빈칸으로 => 내거 개수 / 빈칸개수만큼 
 3. 제초제 뿌릴 칸 선택(행이 작은 순서, 열이 작은 칸)
 4. 제초제 대각선으로 퍼지기 (다시 뿌려질 경우, c년으로 유지)
  
  * */
public class Main {
	static final int WALL = -1;

	static int[] dy = { -1, -1, 0, 1, 1, 1, 0, -1 };
	static int[] dx = { 0, 1, 1, 1, 0, -1, -1, -1 };

	static int[] sd = { 0, 2, 4, 6 };
	static int[] dd = { 1, 3, 5, 7 };

	static int N, M, K, C;

	static int[][] map;
	static int[][] tree;
	static int[][] killer;
	static int[][] spreadTree;

	static int ans;

	static class Pos {
		int y, x;

		public Pos(int y, int x) {
			this.y = y;
			this.x = x;
		}

	}

	public static void main(String[] args) throws Exception {

		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

		String[] inputStrings = bufferedReader.readLine().split(" ");
		N = Integer.parseInt(inputStrings[0]);
		M = Integer.parseInt(inputStrings[1]);
		K = Integer.parseInt(inputStrings[2]);
		C = Integer.parseInt(inputStrings[3]);

		map = new int[N][N];
		tree = new int[N][N];
		killer = new int[N][N];
		spreadTree = new int[N][N];

		for (int y = 0; y < N; y++) {
			inputStrings = bufferedReader.readLine().split(" ");
			for (int x = 0; x < N; ++x) {
				int val = Integer.parseInt(inputStrings[x]);
				map[y][x] = val;
				if (val == WALL)
					continue;
				tree[y][x] = val;

			}
		}

//		if 나무가 없다면.. ?
		for (int m = 0; m < M; ++m) {
//			pM(tree);
//			성장  - 인접한 나무개수만큼 증가
			grow();
//			p("성장후");
//			pM(tree);

//			번식 - spreadTree 초기화 후
			spread();
//			p("번식후");
//			pM(tree);
//			p("제초제도");
//			pM(killer);
//			제초제 뿌릴 칸 선택();
			Pos pickPos = pickKiller();
//			System.out.println(pickPos.y + " " + pickPos.x);
//			제초제 확산
			spreadKiller(pickPos);
			decreaseKiller();
//			p("제초제뿌린후 나부");
//			pM(tree);
//			p("제초제뿌린후 제초제");
//			pM(killer);
		}

		System.out.println(ans);
	}

	private static void decreaseKiller() {
		for (int y = 0; y < N; y++) {
			for (int x = 0; x < N; x++) {
				if (killer[y][x] > 0)
					killer[y][x]--;

			}
		}
	}

	private static void spreadKiller(Pos pickPos) {

		int y = pickPos.y;
		int x = pickPos.x;
//		System.out.println("중심" + y + " " + x + " " + tree[y][x]);
		ans += tree[y][x];
		tree[y][x] = 0;
		killer[y][x] = C + 1;
		int k = 1;
		for (int i = 0; i < dd.length; k++) {
			int ny = y + dy[dd[i]] * k;
			int nx = x + dx[dd[i]] * k;
			if (!(inRange(ny, nx) && map[ny][nx] != WALL && tree[ny][nx] > 0)) {
				i++;
				k = 0;
				continue;
			}
			ans += tree[ny][nx];
			tree[ny][nx] = 0;
			killer[ny][nx] = C + 1;
		}
	}

	private static Pos pickKiller() {
		int maxCnt = 0;
		Pos pickPos = new Pos(0, 0);
		int[][] sum = new int[N][N];
		for (int y = 0; y < N; y++) {
			for (int x = 0; x < N; x++) {
				if (tree[y][x] == 0)
					continue;
				sum[y][x] = simul(y, x);
				if (maxCnt < sum[y][x]) {
					pickPos = new Pos(y, x);
					maxCnt = sum[y][x];
				}
			}
		}
//		p("pickerkiller sum");
//		pM(sum);

		return pickPos;
	}

	/**
	 * 해당 좌표부터 대각선으로 시뮬을 돌려서 먹을 수 있는 !!
	 * 
	 * @param y
	 * @param x
	 * @return
	 */

	private static int simul(int y, int x) {
		int[][] sum = new int[N][N];
		int cnt = tree[y][x];
		sum[y][x] = tree[y][x];
		for (int i = 0; i < dd.length; i++) {
			for (int k = 1; k <= K; k++) {
				int ny = y + dy[dd[i]] * k;
				int nx = x + dx[dd[i]] * k;
				if (!(inRange(ny, nx) && map[ny][nx] != WALL && tree[ny][nx] > 0)) {
					break;
				}
				cnt += tree[ny][nx];
//				p(tree[ny][nx] + " ");
			}
		}
//		p("simul");
//		pM(sum);

		return cnt;
	}

	/**
	 * - spreadTree 초기화 0으로 - 나무가 있는 칸일 경우, 진행 - 벽, 다른 나무, 제초제 없는 칸 수 카운팅 - 자신의 나무 수
	 * / 갈 수 있는 칸 구함 - spreadTree에 저장 + 로 해야함 - 마지막에 tree랑 spreadTree랑 합해서 tree에 저장
	 */
	private static void spread() {
		for (int y = 0; y < N; y++) {
			for (int x = 0; x < N; x++) {
				spreadTree[y][x] = 0;
			}
		}

		for (int y = 0; y < N; y++) {
			for (int x = 0; x < N; x++) {
				if (tree[y][x] == 0)
					continue;
				int canGoCnt = 0;
				for (int i = 0; i < sd.length; i++) {
					int ny = y + dy[sd[i]];
					int nx = x + dx[sd[i]];

					if (inRange(ny, nx) && tree[ny][nx] == 0 && map[ny][nx] != WALL && killer[ny][nx] == 0) {
						canGoCnt++;
					}
				}
				if (canGoCnt == 0)
					continue;
				int spreadVal = tree[y][x] / canGoCnt;
				for (int i = 0; i < sd.length; i++) {
					int ny = y + dy[sd[i]];
					int nx = x + dx[sd[i]];

					if (inRange(ny, nx) && tree[ny][nx] == 0 && map[ny][nx] != WALL && killer[ny][nx] == 0) {
						spreadTree[ny][nx] += spreadVal;
					}
				}
			}
		}

		for (int y = 0; y < N; y++) {
			for (int x = 0; x < N; x++) {
				tree[y][x] += spreadTree[y][x];
			}
		}

	}

	/**
	 * - 인접한 나무의 수만큼 성장 - 4방향 확인 - 범위 안에 있고, 나무가 있어야 함 - 그만큼 자신의 나무 수 증가
	 */
	private static void grow() {
		for (int y = 0; y < N; y++) {
			for (int x = 0; x < N; x++) {
				if (tree[y][x] == 0)
					continue;
				int growCnt = 0;
				for (int i = 0; i < sd.length; i++) {
					int ny = y + dy[sd[i]];
					int nx = x + dx[sd[i]];
					if (inRange(ny, nx) && tree[ny][nx] > 0)
						growCnt++;
				}
				tree[y][x] += growCnt;

			}

		}

	}

	private static boolean inRange(int y, int x) {
		return 0 <= y && y < N && 0 <= x && x < N;
	}

	static void pr() {
		p("map");

	}

	static void pM(int[][] map) {
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				System.out.printf("%2d ", map[i][j]);
			}
			p("");
		}
	}

	static void p(String string) {
		System.out.println(string);
	}

}