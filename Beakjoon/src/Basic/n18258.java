package Basic;


import java.util.*;
import java.io.*;

/* 큐2 */
public class n18258 {

    public static void main(String[] args) throws IOException{
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	StringTokenizer st;
    	StringBuilder sb = new StringBuilder();
    	Queue<Integer> queue = new LinkedList<>();
    	String command;
    	int push, lastQue = 0;
    	
    	int N = Integer.parseInt(br.readLine());
    	for(int i=0; i<N; i++) {
    		st = new StringTokenizer(br.readLine());
    		command = st.nextToken();
    		if(command.equals("push")) {
    			push = Integer.parseInt(st.nextToken());
    			queue.add(push);
    			lastQue = push;
    			continue;
    		}else if(command.equals("pop") && !queue.isEmpty()) {
    			sb.append(queue.poll());
    		}else if(command.equals("size")) {
    			sb.append(queue.size());
    		}else if(command.equals("empty")) {
    			sb.append(queue.isEmpty()? 1 : 0);
    		}else if(command.equals("front") && !queue.isEmpty()) {
    			sb.append(queue.peek());
    		}else if(command.equals("back")  && !queue.isEmpty()){
    			sb.append(lastQue);
    		}else {
    			sb.append(-1);
    		}
    		
    		sb.append("\n");
    	}
    	
    	System.out.println(sb);
    	
    }//main
}//class
