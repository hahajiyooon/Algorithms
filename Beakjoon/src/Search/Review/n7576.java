package Search.Review;

import java.util.*;
import java.io.*;

/*토마토*/
public class n7576 {
	static int N,M;
	static int[][] box;
	static boolean[][] visited;
	static int[] dx = {0, 0, -1 ,1};
	static int[] dy = {-1 ,1, 0, 0};

    public static void main(String[] args) throws IOException{
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	StringTokenizer st = new StringTokenizer(br.readLine());
    	
    	N = Integer.parseInt(st.nextToken());
    	M = Integer.parseInt(st.nextToken());
    	
    	box = new int [N][M];
    	visited = new boolean[N][M];
    	
    	Queue<int[]> queue = new LinkedList<>();
    	
    	//값 입력 받을때 
    	for(int i=0; i<N; i++) {
    		st = new StringTokenizer(br.readLine());
    		for(int j=0; j<M; j++) {
    			box[i][j] = Integer.parseInt(st.nextToken());
    			//바로 queue에 add > 토마토1A & 토마토1B가 동시에 진행돼야 최소날짜 구할수있음
    			if(box[i][j] == 1) {
    				visited[i][j] = true;
    				queue.add(new int[] {i,j,0});    			
    			}
    		}
    	}
    	//int result = bfs(queue);
    	//System.out.println(result);
    	
    }//main
    

    public static int bfs(Queue<int[]> queue) {
    	int days = 0;
    	System.out.println("dha");
    	while(!queue.isEmpty()) {
    		System.out.println("~~`");
    		int[] current = queue.poll();
    		int cx = current[0], cy = current[1], day = current[2];
    		
    		days = Math.max(days, day);
    		
    		for(int i=0; i<4; i++) {
    			int nx = cx + dx[i];
    			int ny = cy + dy[i];
    			
    			if(nx >= 0 && ny >= 0 && nx < N && ny < M && !visited[nx][ny] && box[nx][ny] == 0) {
    					visited[nx][ny] = true;
    					box[nx][ny] = 1;     				
    					queue.add(new int[] {nx,ny,day+1});
    			}
    		}
    	}
    	
    	//안익은 토마토 찾기
    	for(int i=0; i<N; i++) {
    		for(int j=0; j<M; j++) {
    			if(box[i][j] == 0) return -1;
    		}
    	}
    	
		return days;
	}
}//class
