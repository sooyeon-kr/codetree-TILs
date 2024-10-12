import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;

/**
 * 7시 시작 k초 동안 모든 참가자들의 이동 거리 합과 출구 좌표를 출력하는 문제, K초 전에 모두 탈출하면 게임은 끝남 - 1,1 부터
 * 시작 - 빈칸, 벽, 출구
 * 
 * - 벽은 회전할 때마다 내구도가 1씩 깎임 - 내구도가 0일 경우, 빈칸으로 변경됨
 * 
 * - 출구 칸에 도달하자마자, 즉시 탈출 되는 것 - STEP1. 탈출구 쪽으로 움직임 - 상하좌우 - 현재 머물러 있는 칸보다, 이동하는
 * 곳이 더 가까워야함 - 아니라면 정지 - 움직일 수 있는 칸이 2개 이상이라면, 상 하 순 - 움직일 수 없다면 정지 - 한 칸에 2명
 * 이상의 참가자 존재 가능 - 이동하게 될 경우, 이동 ++ - 참가자가 남아있는지 이 때 확인해야함 - STEP 추가 - 남아있는 참가자가
 * 있는지 확인 - STEP2. 가장 작은 정사각형 선택 - 출구와 한 명 이상의 참가자가 포함되어야 함 - 조건에 부합하는 정사각형이 2개
 * 이상이라면, 좌상단 r좌표가 작은 것이 우선이 되고, 그래도 같으면 c좌표가 작은 것이 우선이 됨 - STEP3. 정사각형 회전 - 90도
 * 회전 - STEP4. 내구도 감소 - 정사각형 안에 있는 벽 내구도 감소 시킴 - -
 */
public class Main {
	static final int RUNNER = -1;
	static final int EXIT = 99;
	static boolean DEBUG = false;
	static int[] dy = { -1, 1, 0, 0 };
	static int[] dx = { 0, 0, -1, 1 };
	static int[] ld = { 1, 3, 0, 2 };
	static int N, M, K;
	static int[][] maze;
	static int[][] walls;
	static int[][] runners;

	static int sumDist;

	static class Pos {
		int y, x;

		Pos(int y, int x) {
			this.y = y;
			this.x = x;
		}
	}

	static Pos exitPos;
	static ArrayList<Integer>[] numbers;

	public static void main(String[] args) throws Exception {
		init();
//      pMaze();
		pWalls();
		pRunners();
		for (int k = 1; k <= K; ++k) {
			pr("=============k : " + k + "초 ===============");
//         참가자들 이동
			pr("이동 전 ");
			pM(runners);
			moveRunner();
			pr("이동 후 sumDist=" + " " + sumDist);
			pM(runners);
			pWalls();
//         mergeMap();
//         pr("maze");
//         pM(maze);
			// 모두 다 탈출했는지 확인
			if (!isExistRunner())
				break; // 정사각형 찾기
			pr("selecte전 러너 ");
			pM(runners);
			Pos[] selectedPos = selectRectangle();
			// 정사각형 회전
			pr(selectedPos[0].y + " " + selectedPos[0].x + "    " + selectedPos[1].y + " " + selectedPos[1].x);
//         2시간 11분 걸림, 23시 31분 다시 시작
			pr("rotateRectange 시작 전");
			pM(walls);
			rotateRectangle(selectedPos[0], selectedPos[1]);

			pr("rotateRectange 시작 후");
			pM(walls);

//          벽 내구도 감소
			decreaseWall(selectedPos[0], selectedPos[1]);
			// * 다시 합치기
			mergeMap();
			pr("merMap");
			pM(maze);
		}

		System.out.println(sumDist);
		System.out.println((exitPos.y + 1) + " " + (exitPos.x + 1));
	}

	private static void mergeMap() {
		for (int y = 0; y < N; y++) {
			for (int x = 0; x < N; x++) {
				maze[y][x] = 0;
				maze[y][x] = runners[y][x] + walls[y][x];
			}
		}
		maze[exitPos.y][exitPos.x] = EXIT;
	}

	private static void decreaseWall(Pos stPos, Pos endPos) {
		pr("####decreaseWall####");
		for (int y = stPos.y; y <= endPos.y; y++) {
			for (int x = stPos.x; x <= endPos.x; x++) {
				if (walls[y][x] != EXIT && walls[y][x] > 0)
					walls[y][x]--;
			}
		}
		pM(walls);
	}

	private static void rotateRectangle(Pos stPos, Pos endPos) {

		int rotateCnt = (endPos.y - stPos.y + 1) / 2; // 2
		int len = (endPos.y - stPos.y) + 1;
		int[][] rotatedWalls = new int[N][N];
		int[][] rotatedRunners = new int[N][N];

		walls[exitPos.y][exitPos.x] = EXIT;
		for (int y = 0; y < N; ++y) {
			for (int x = 0; x < N; ++x) {
				rotatedWalls[y][x] = walls[y][x];
				rotatedRunners[y][x] = runners[y][x];
			}
		}

		for (int y = stPos.y; y <= endPos.y; ++y) {
			for (int x = stPos.x; x <= endPos.x; ++x) {
				rotatedWalls[stPos.y - stPos.x + x][endPos.x + stPos.y - y] = walls[y][x];
				rotatedRunners[stPos.y - stPos.x + x][endPos.x + stPos.y - y] = runners[y][x];
			}
		}

		pr("rotatedW");
		pM(rotatedWalls);
		pr("rotatedRunners");
		pM(rotatedRunners);

		for (int y = stPos.y; y <= endPos.y; ++y) {
			for (int x = stPos.x; x <= endPos.x; ++x) {
				walls[y][x] = 0;
				runners[y][x] = 0;
				walls[y][x] = rotatedWalls[y][x];
				runners[y][x] = rotatedRunners[y][x];
				maze[y][x] = walls[y][x] + runners[y][x];
				if (maze[y][x] == EXIT) {
					exitPos = new Pos(y, x);
				}
			}
		}

	}

	private static Pos[] selectRectangle() {

		Pos[] selectedPos = new Pos[2];
		int minRectSize = 2147000000;
		for (int i = 1; i < N; ++i) {
			for (int y = 0; y < N; y++) {
				for (int x = 0; x < N; x++) {
					if (!inRange(y + i, x + i))
						continue;
					if (isInvolved(y, x, y + i, x + i)) {
						selectedPos[0] = new Pos(y, x);
						selectedPos[1] = new Pos(y + i, x + i);
						return selectedPos;
					}

				}
			}
		}
		return selectedPos;

	}

	private static boolean isInvolved(int sy, int sx, int ey, int ex) {
		boolean isExistExit = false;
		boolean isExistRunner = false;
		for (int y = sy; y <= ey; y++) {
			for (int x = sx; x <= ex; x++) {
				if (runners[y][x] == RUNNER)
					isExistRunner = true;
				if (y == exitPos.y && x == exitPos.x)
					isExistExit = true;
			}
		}
		return isExistExit && isExistRunner;
	}

	private static boolean isExistRunner() {
		for (int y = 0; y < N; y++) {
			for (int x = 0; x < N; x++) {
				if (runners[y][x] == RUNNER)
					return true;
			}
		}
		return false;

	}

	private static void moveRunner() {
		int[][] newRunners = new int[N][N];
		for (int y = 0; y < N; y++) {
			for (int x = 0; x < N; x++) {
				if (runners[y][x] != RUNNER)
					continue;
				int originDist = getDist(y, x);
				int minDist = originDist;
				int minDir = 0;
				Pos targetPos = new Pos(y, x);
				int ny = y, nx = x;

				for (int i = 0; i < 4; i++) {
					ny = y + dy[i];
					nx = x + dx[i];
					if (!inRange(ny, nx) || (walls[ny][nx] != EXIT && walls[ny][nx] > 0))
						continue;
					int dist = getDist(ny, nx);
					if (dist < minDist) {
						minDist = dist;
						minDir = i;
						targetPos = new Pos(ny, nx);
					}
				}

				if (originDist == minDist) {
					newRunners[y][x] = RUNNER;
				} else {
					newRunners[targetPos.y][targetPos.x] = RUNNER;
					sumDist++;
				}

				if (newRunners[targetPos.y][targetPos.x] == EXIT) {
					newRunners[targetPos.y][targetPos.x] = 0;
				}
			}
		}

		for (int y = 0; y < N; ++y) {
			for (int x = 0; x < N; ++x) {
				runners[y][x] = newRunners[y][x];
				if (y == exitPos.y && x == exitPos.x) {
					runners[y][x] = 0;
				}
			}
		}

	}

	private static boolean inRange(int y, int x) {
		return 0 <= y && y < N && 0 <= x && x < N;
	}

	private static int getDist(int y, int x) {
		return Math.abs(y - exitPos.y) + Math.abs(x - exitPos.x);
	}

	static void pr(String str) {
		if (!DEBUG)
			return;
		System.out.println(str);
	}

	static void pM(int[][] map) {
		if (!DEBUG) {
			return;
		}
		for (int y = 0; y < N; y++) {
			for (int x = 0; x < N; x++) {
				System.out.printf("%2d ", map[y][x]);
			}
			System.out.println();
		}
	}

	static void pMaze() {
		pr("__________maze__________");
		pM(maze);
	}

	static void pRunners() {
		pr("__________runners__________");
		pM(runners);
	}

	static void pWalls() {
		pr("__________walls__________");
		pM(walls);
	}

	private static void init() throws IOException {
		// System.setIn(new FileInputStream("./src/ss/input.txt"));
		BufferedReader bReader = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bWriter = new BufferedWriter(new OutputStreamWriter(System.out));

		String[] inputStrings = bReader.readLine().split(" ");
		N = Integer.parseInt(inputStrings[0]);
		M = Integer.parseInt(inputStrings[1]);
		K = Integer.parseInt(inputStrings[2]);

		maze = new int[N][N];
		walls = new int[N][N];
		runners = new int[N][N];

		for (int y = 0; y < N; y++) {
			inputStrings = bReader.readLine().split(" ");
			for (int x = 0; x < N; x++) {
				walls[y][x] = Integer.parseInt(inputStrings[x]);
				maze[y][x] = walls[y][x];
			}
		}

		for (int m = 0; m < M; m++) {
			inputStrings = bReader.readLine().split(" ");
			int y = Integer.parseInt(inputStrings[0]) - 1;
			int x = Integer.parseInt(inputStrings[1]) - 1;
			runners[y][x] = RUNNER;
			maze[y][x] = RUNNER;
		}

		inputStrings = bReader.readLine().split(" ");
		int y = Integer.parseInt(inputStrings[0]) - 1;
		int x = Integer.parseInt(inputStrings[1]) - 1;
		exitPos = new Pos(y, x);
		maze[y][x] = EXIT;
		walls[y][x] = EXIT;
	}
}