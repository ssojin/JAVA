import java.util.Arrays;
import java.util.Scanner;

public class ������ȣ���̱� {
	//��Ÿ �̿�
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
		//�׵θ�0
		map = new int[n+2][n+2];
		home = new int[n*n];

		for(int i=1;i<=n;i++) {
			String s = sc.next();
			for(int j=1;j<=n;j++) {
				map[i][j] = s.charAt(j-1)-'0';
			}
		}

		//1�̸� ī��Ʈ�ϰ�
		for(int i=1;i<=n;i++) {
			for(int j=1;j<=n;j++) {
				if(map[i][j]==1) {
					//ȣ��
					change(i,j);
					cnt++;
				}
			}
		}
		System.out.println(cnt);//�� ������
		int []newhome = new int[cnt];
		for(int i=0;i<cnt;i++) {//���� ��
			newhome[i] = home[i]+1;
		}
		
		Arrays.sort(newhome);
		
		for(int i=0;i<cnt;i++) {
			System.out.println(newhome[i]);
		}
		
	}
}
