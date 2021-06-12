package P25_20210612100.A08;

/**
 * @author : ZWH 6/12/21
 * @version : 1.0
 */
public class Test {
    public static void main(String[] args) {
        int[][] m1 = {
                {14, 11, 13, 12},
                {18, 15, 13, 13},
                {19, 16, 15, 17}
        };

        int[][] m2 = {
                {54, 53, 51, 52},
                {51, 59, 52, 56},
                {53, 54, 52, 58}
        };
        System.out.println("First array:");
        displayArray(m1);
        System.out.println("Second array:");
        displayArray(m2);
     /* write simple code to test your method and use
        displayArray to display the result if applicable  */
        System.out.println();
        System.out.println("The addition of the above two arrays is");
        displayArray(addMatrix(m1,m2));

        System.out.println();
        System.out.print("The sum of the first column in the first array is: ");
        System.out.println(sumCol(m1,1));
    }

    //write your methods code here.
    public static int sumCol(int[][] m, int colIdx) {
        int sum = 0;
        for (int i = 0; i < m.length; i++) {
            sum += m[i][colIdx - 1];
        }
        return sum;
    }

    public static int[][] addMatrix(int[][] a, int[][] b) {
        int height,width;
        if (a.length == b.length && a[0].length == b[0].length) {
            height = a.length;
            width = a[0].length;
        } else {
            System.out.println("Matrixs can't add");
            return null;
        }

        int[][] ans = new int[height][width];
        for (int i = 0; i < height ; i++) {
            for (int j = 0; j < width ; j++) {
                ans[i][j] = a[i][j] + b[i][j];
            }
        }
        return ans;
    }

    public static void displayArray(int[][] m) {
        for (int r = 0; r < m.length; r++) {
            for (int c = 0; c < m[r].length; c++)
                System.out.print(m[r][c] + " ");
            System.out.println();
        }
    }
}