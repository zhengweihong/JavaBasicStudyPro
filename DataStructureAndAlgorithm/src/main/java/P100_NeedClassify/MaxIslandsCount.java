package P100_NeedClassify;
import java.util.Scanner;

/**
 * 最大岛屿问题
 */
public class MaxIslandsCount {
    static int[][] net;

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        int m = scan.nextInt();
        net = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                net[i][j] = scan.nextInt();
            }
        }

        int maxNum = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if(net[i][j]==1){
                    int maxTemp = dfs(i,j);
                    if(maxTemp>maxNum){
                        maxNum = maxTemp;
                    }
                }
            }
        }

        System.out.println(maxNum);
    }

    public static int dfs(int n,int m){
        if(n<0 || n>net.length-1 || m<0 || m>net[0].length-1 || net[n][m]==0){
            return 0;
        }
        net[n][m]=0;
        int a = 1+ dfs(n,m-1)+dfs(n-1,m)+dfs(n,m+1)+dfs(n+1,m);
        return a;
    }
}
