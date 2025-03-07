package Search.Review;

import java.util.*;
import java.io.*;

public class n14502 {
	static int N,M;
	static int[][] lab;
	static boolean[][] visited;
	static int[] dx = {-1, 1, 0, 0};
	static int[] dy = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException{
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	StringTokenizer st = new StringTokenizer(br.readLine());
    	
    	N = Integer.parseInt(st.nextToken());
    	M = Integer.parseInt(st.nextToken());
    	
    	lab = new int[N][M];
    	visited = new boolean[N][M];
    	
    	for(int i=0; i<N; i++) {
    		st = new StringTokenizer(br.readLine());
    		for(int j=0; j<M; j++) {
    			lab[i][j] = Integer.parseInt(st.nextToken());
    		}
    	}
    	
    	//1. 3개의 벽 세우기
    	setWalls();
    	//2. 바이러스 퍼뜨리기(dfs)
    	//3. 안전 영역 크기 카운트

    	
    }//main

    //백트레킹: 모든 좌표 방문해서 벽 3개 세우기
    public static void setWalls() {
    	int wallCnt = 0;
    	
    	for(int i=0; i<N; i++) {
    		for(int j=0; j<M; j++) {
	    		if(wallCnt == 3) {
	    			dfs();
	    		}
	    		
	    		if(lab[i][j] == 0) {
	    			lab[i][j] = 1;
	    			wallCnt++;
	    		}
    		}
    	}
    	
    	
    }
    	
    
    
    //완전탐색: 바이러스 퍼뜨리기
    public static void dfs() {
		
	}
}//class



