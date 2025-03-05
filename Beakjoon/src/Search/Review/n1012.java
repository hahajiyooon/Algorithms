package Search.Review;

import java.util.*;
import java.io.*;

/*유기농배추*/
public class n1012 {
	static int T,M,N,K;
	static int[][] field;
	static boolean[][] visited;
	static int[] dx = {-1, 1, 0 ,0};
	static int[] dy = {0, 0, -1, 1};
	static int worm; //최소한의 배추흰지렁이 마리 수

    public static void main(String[] args) throws IOException{
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	StringTokenizer st;
    	StringBuilder sb = new StringBuilder();
    	int x,y;
    	
    	T = Integer.parseInt(br.readLine());
    	
    	for(int i=0; i<T; i++) {
    		st = new StringTokenizer(br.readLine());
    		N = Integer.parseInt(st.nextToken());
    		M = Integer.parseInt(st.nextToken());
    		K = Integer.parseInt(st.nextToken());
    		
    		//리셋
    		field = new int[N][M];
    		visited = new boolean[N][M];
    		worm = 0; 
    		
    		for(int j=0; j<K; j++) {
    			st = new StringTokenizer(br.readLine());
    			x = Integer.parseInt(st.nextToken());
    			y = Integer.parseInt(st.nextToken());
    			
    			field[x][y] = 1;
    		}
    		
    		//배추벌레 카운트
    		for(int a=0; a<N; a++) {
    			for(int b=0; b<M; b++) {
    				if(field[a][b] == 1&& !visited[a][b]) {
    					dfs(a,b);
    					worm ++;
    				}
    			}
    		}
    		
    		sb.append(worm).append("\n");
    		
    	}//for
    	
    	System.out.println(sb);
    	
    }//main
    
    //연속성 체크를 어떻게 하지
    public static void dfs(int x, int y) {
		visited[x][y] = true;
		
		for(int i=0; i<4; i++) {
			int nx = x+dx[i];
			int ny = y+dy[i];
			
			if(nx >= 0 && ny >= 0 && nx < N && ny < M && !visited[nx][ny]) {
				if(field[nx][ny] == 1) {
					dfs(nx,ny);
				}
			}
		}//for
		
	}
}//class
