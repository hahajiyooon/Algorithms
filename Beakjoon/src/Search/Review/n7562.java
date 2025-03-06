package Search.Review;

import java.util.*;
import java.io.*;

/*나이트의이동*/
public class n7562 {
	static boolean[][] visited;
	static int[] dx = {1,2,1,2,  -1,-2,-1,-2};
	static int[] dy = {2,1,-2,-1, 2, 1,-2,-1};

	//최소몇번 > bfs?
    public static void main(String[] args) throws IOException{
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	StringTokenizer st; 
    	StringBuilder sb = new StringBuilder();
    	int cx,cy,rx,ry,L;
    	
    	int T = Integer.parseInt(br.readLine());//테스트 케이스 수
    	
    	while(T-- > 0) {
    		L = Integer.parseInt(br.readLine());//체스판 크기
    		st = new StringTokenizer(br.readLine());
    		cx = Integer.parseInt(st.nextToken());
    		cy = Integer.parseInt(st.nextToken());
    		st = new StringTokenizer(br.readLine());
    		rx = Integer.parseInt(st.nextToken());
    		ry = Integer.parseInt(st.nextToken());
    		
    		//리셋
    		
    		sb.append(bfs(cx,cy,rx,ry,L)).append("\n");
    	}
    	
    	System.out.println(sb);
    	
    }//main
    
    public static int bfs(int start, int end, int rx, int ry,int L) {
    	if(start == rx && end == ry) return 0;
    	
    	Queue<int[]> queue = new LinkedList<>();
    	boolean[][] visited = new boolean[L][L];
    	visited[start][end] = true;
    	queue.add(new int[] {start,end,0}); //위치당 몇번이동했는지도 넣어줘야함
    	
    	while(!queue.isEmpty()) {
    		int[] current = queue.poll();
    		int cx = current[0];
    		int cy = current[1];
    		int cnt = current[2];
    		
    		for(int i=0; i<8; i++) {
    			int nx = cx+dx[i];
    			int ny = cy+dy[i];
    			
    			//전값, 후값 반복해서 미니멈값 비교 > 큐에다 행적 넣기
    			//cnt++ 랑 cnt+1이랑 결과값 다르게나옴
    			if(nx >= 0 && ny >= 0 && nx < L && ny < L && !visited[nx][ny]) {
    				if(nx == rx && ny == ry) {
    					return cnt+1;
    				}
    				visited[nx][ny] = true;
    				queue.add(new int[] {nx,ny,cnt+1});
    			}
    		}
    		
    	}
    	
    	
		return -1;
	}
}//class
