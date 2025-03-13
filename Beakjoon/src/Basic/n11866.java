package Basic;


import java.util.*;


import java.io.*;

public class n11866 {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		Queue<Integer> queue = new LinkedList<>();
		
		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		int num = 0;
		
		sb.append("<");
		
		//스택에 숫자 넣기
		while(n-- > 0) {
			queue.add(++num);
		}
		
		
		
		//k번째 숫자 빼기
		int tmp;
		while(!queue.isEmpty()) {
			for(int i=1; i<k; i++) {
				tmp = queue.poll();
				queue.add(tmp);
			}
			sb.append(queue.poll()).append(queue.size()== 0 ? "" : ", ");
		}

		sb.append(">");
		
		System.out.println(sb);
	}//main
	

}
