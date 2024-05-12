import java.io.*;
import java.util.*;
/*
접두사가 된다는 것.
1. 지나치는 노드에서 isEnd가 true를 만났을 경우,
2. 한번도 새로운 노드를 생성하지 않았을 경우,


*/
class TrieNode{
    TrieNode[] children = new TrieNode[10]; // 26개의 노드 정보 
    boolean isEnd; // 끝인지 아닌지

    TrieNode(){
        isEnd = false;


        for(int i=0; i<10; ++i){ 
            children[i] = null;
        }
    }
}
public class Main {

    static int n;
    static String[] words;
    static TrieNode root = new TrieNode(); // 루트 노드
    static boolean isPrefix;
    static boolean notCreateNode = true;
    static boolean insertWord(String s){
        TrieNode t = root;
        boolean isMeetEnd = false;
        for(int i=0; i<s.length(); ++i){
            int idx = s.charAt(i)-'0'; // 0 ~ 25까지 인덱스 맵핑
            if(t.children[idx] == null){
                t.children[idx] = new TrieNode();
                notCreateNode = false;
            }

            t = t.children[idx];
            if(t.isEnd == true){
                isMeetEnd = true;
            }
        }

        t.isEnd = true;

        return isMeetEnd || notCreateNode;
    }
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        n = Integer.parseInt(br.readLine());
        words = new String[n];

        for(int i=0; i<n; ++i){
            words[i] = br.readLine();
        }

        for(int i=0; i<n; ++i){
            isPrefix = insertWord(words[i]);
            if(isPrefix) break;
        }

        System.out.println(isPrefix ? 0 : 1);
    }
}