import java.util.Arrays;
import java.util.Scanner;

public class 섬의개수 {
	static int []dr = {-1,-1,-1,0,0,1,1,1};
	static int []dc = {-1,0,1,-1,1,-1,0,1};
	static int [][]map;
	static void change(int w, int h) {
		map[w][h]=0;
		
		for(int d=0;d<8;d++) {
			int nr = w+dr[d];
			int nc = h+dc[d];
			
			if(map[nr][nc]==1) {
				change(nr,nc);
			}
		}
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int w = 1;
		int h = 1;
		while(true) {
			h = sc.nextInt();
			w = sc.nextInt();
			if(w==0 && h==0) break;
			//테두리0
			map = new int[w+2][h+2];
			//섬과 바다 지도
			for(int i=1;i<=w;i++) {
				for(int j=1;j<=h;j++) {
					map[i][j] = sc.nextInt();
				}
			}
			System.out.println(Arrays.toString(map));
			int cnt=0;
			//1이면 카운트하고
			for(int i=1;i<=w;i++) {
				for(int j=1;j<=h;j++) {
					if(map[i][j]==1) {
						cnt++;
						//호출
						change(i,j);
					}
				}
			}
			System.out.println(cnt);
		}
		
	}
}
