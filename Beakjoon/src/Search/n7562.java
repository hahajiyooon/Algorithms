package Search;


import java.util.*;


import java.io.*;

public class n7562 {
    static int[] dx = {-2, -1, 1, 2, 2, 1, -1, -2};
    static int[] dy = {1, 2, 2, 1, -1, -2, -2, -1};

    public static void main(String[] args) throws IOException{
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	StringBuilder sb = new StringBuilder();
    	StringTokenizer st;
    	int T = Integer.parseInt(br.readLine());
    	int startX, startY, endX, endY, L;
    	
    	
    	while (T-- > 0) {
			L = Integer.parseInt(br.readLine());
			st = new StringTokenizer(br.readLine());
			startX = Integer.parseInt(st.nextToken());
			startY = Integer.parseInt(st.nextToken());
			st = new StringTokenizer(br.readLine());
			endX = Integer.parseInt(st.nextToken());
			endY = Integer.parseInt(st.nextToken());
			
			sb.append(bfs(L,startX,startY,endX,endY)).append("\n");
		}
    	
    	System.out.println(sb);
    	
    }//main
    
    public static int bfs(int L, int startX, int startY, int endX, int endY) {
    	if(startX == endX && startY == endY) return 0;
    	
    	Queue<int[]> queue = new LinkedList<>();
    	boolean[][] visited = new boolean[L][L];
    	visited[startX][startY] = true;
    	queue.add(new int[] {startX,startY,0});
    	
    	while(!queue.isEmpty()) {
    		int[] current = queue.poll();
    		int x = current[0], y = current[1], moves = current[2];
    		
    		for(int i=0; i<8; i++) {
    			int nx = x + dx[i];
    			int ny = y + dy[i];
    			
    			//판 안에 있고, 방문하지 않은 곳 
    			if(nx >= 0 && ny >= 0 && nx < L && ny < L && !visited[nx][ny]) {
    				if(nx == endX && ny == endY) return moves+1;
    				visited[nx][ny] = true;
    				queue.add(new int[] {nx, ny, moves+1});
    			}
    		}
    	}
    	
    	return -1;
    }
}//class