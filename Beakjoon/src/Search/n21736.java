package Search;

import java.io.*;
import java.util.*;

public class n21736 {
	static int N,M;
	static char[][] campus;
	static boolean[][] visited;
	static int[] dx = {-1, 1, 0, 0};
	static int[] dy = {0, 0, -1, 1};
	static int startX, startY, meetCnt;
//O는 빈 공간, X는 벽, I는 도연이, P는 사람
	//아무도 만나지 못한 경우 TT를 출력
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		campus = new char[N][M];
		visited = new boolean[N][M];
		String tmp;
		for(int i=0; i<N; i++) {
			tmp= br.readLine();
			for(int j=0; j<M ; j++) {
				campus[i][j] = tmp.charAt(j);
				if(campus[i][j] == 'I') {
					startX = i; startY = j;
				}
			}
		}
		
		dfs(startX, startY);
		System.out.println(meetCnt == 0 ? "TT" : meetCnt);

	}
	
	public static void dfs(int x, int y) {
		visited[x][y] = true;
		
		for(int i=0; i<4; i++) {
			int nx = x + dx[i];
			int ny = y + dy[i];
			
			//캠퍼스 범위 안에 있으면서, 방문하지 않은 곳
			if(nx >= 0 && ny >= 0 && nx < N && ny < M && !visited[nx][ny]) {
				if(campus[nx][ny] == 'X') {
					continue;
				}
				if(campus[nx][ny] == 'P') {
					meetCnt = meetCnt+1;
				}
				dfs(nx,ny);
			}
		}
	}

}
