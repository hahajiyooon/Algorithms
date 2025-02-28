package Search;

import java.util.*;
import java.io.*;

/*토마토*/
public class n7576 {
	static int M, N;//가로, 세로
	static int cnt; //모든 토마토 익는 날짜
	static int[][] box;
	static boolean[][] visited;
	static int[] dx = {-1, 1, 0, 0};
	static int[] dy = {0 ,0, -1, 1};

    public static void main(String[] args) throws IOException{
    	Scanner sc = new Scanner(System.in);
    	N = sc.nextInt();
    	M = sc.nextInt();
    	
    	box = new int[M][N];
    	visited= new boolean[M][N];
    	
    	for(int i=0; i<M; i++) {
    		for(int j=0; j<N; j++) {
    			box[i][j] = sc.nextInt();
    		}
    	}
    	
    	
    	for(int i=0; i<M; i++) {
    		for(int j=0; j<N; j++) {
    			dfs(i,j);
    			//끝날때까지 0이 남아있으면 return -1 
    			//처음부터 모든 토마토가 1이면 return 0
    		}
    	}
    	
    	System.out.println(cnt);
    	
    }//main
    
    public static void dfs(int cx, int cy) {
    	//-1:없음 0:안익음 1:익음
    	visited[cx][cy] = true;
    	
    	for(int i=0; i<4; i++) {
    		int nx = cx + dx[i];
    		int ny = cy + dy[i];
    		
    		if(nx >= 0 && ny >= 0 && nx < M && ny < N && !visited[nx][ny]) {
    			if(box[nx][ny] == 0) {
    				dfs(nx,ny);
    			}
    		}
    	}
    	
    }
}//class