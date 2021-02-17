import java.util.Arrays;
import java.util.Scanner;

public class 단지번호붙이기 {
	//델타 이용
	static int []dr = {-1,1,0,0};
	static int []dc = {0,0,-1,1};
	static int [][]map;
	static int cnt=0;
	static int []home;
	
	static void change(int w, int h) {
		map[w][h]=0;
		for(int d=0;d<4;d++) {
			int nr = w+dr[d];
			int nc = h+dc[d];
			
			if(map[nr][nc]==1) {
				home[cnt]++;
				change(nr,nc);
			}
		}
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n =sc.nextInt();
		//테두리0
		map = new int[n+2][n+2];
		home = new int[n*n];

		for(int i=1;i<=n;i++) {
			String s = sc.next();
			for(int j=1;j<=n;j++) {
				map[i][j] = s.charAt(j-1)-'0';
			}
		}

		//1이면 카운트하고
		for(int i=1;i<=n;i++) {
			for(int j=1;j<=n;j++) {
				if(map[i][j]==1) {
					//호출
					change(i,j);
					cnt++;
				}
			}
		}
		System.out.println(cnt);//총 단지수
		int []newhome = new int[cnt];
		for(int i=0;i<cnt;i++) {//집의 수
			newhome[i] = home[i]+1;
		}
		
		Arrays.sort(newhome);
		
		for(int i=0;i<cnt;i++) {
			System.out.println(newhome[i]);
		}
		
	}
}
