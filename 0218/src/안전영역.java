import java.util.Arrays;
import java.util.Scanner;

public class 안전영역 {
	static int []dr = {-1,1,0,0};
	static int []dc = {0,0,-1,1};
	static int [][]map;
	static int []he;
	static int water;
	static int max=1;
	static void change(int w, int h, int wa) {
		map[w][h]=0;
		
		for(int d=0;d<4;d++) {
			int nr = w+dr[d];
			int nc = h+dc[d];
			
			if(map[nr][nc]!=0) {
				he[wa]++;
				change(nr,nc,wa);
			}
		}
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n =sc.nextInt();
		//테두리0
		map = new int[n+2][n+2];
		he = new int[101];
		for(int i=1;i<=n;i++) {
			for(int j=1;j<=n;j++) {
				map[i][j] = sc.nextInt();
			}
		}

		//water=1;
		for(int i=1;i<=n;i++) {
			for(int j=1;j<=n;j++) {
				if(map[i][j]>=water) {
					//호출
					water++;
					change(i,j,water);
				}
			}
		}
		
		System.out.println(Arrays.toString(he));
		
	}
}
