import java.util.Scanner;
import java.util.Stack;

public class �踷��� {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String s = sc.next();
		//�ϴ� ()��  o�� �ٲٱ�
		s = s.replace("()", "o");
		
		Stack<Character> st = new Stack<Character>();
		
		int sum=1;
		for(int i=0;i<s.length()-1;i++) {
			char c = s.charAt(i);

			if(c=='o') {
				sum+=st.size();
			}
			else if(c=='(') {
				st.push(c);
			}
			else if(c==')') {
				sum+=1;
				st.pop();
			}
			
		}
		System.out.println(sum);
		
	}
}
