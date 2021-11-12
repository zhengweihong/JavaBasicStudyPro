package P00_NeedClassify;

/**
 * 
 * @author zwh
 *
 * 累加和问题
 * （1）生成矩阵，分别算出从i-j的和
 * （2）前缀和数组：根据原数组生成一个Help数组，H[i]=arr[0]+…+arr[i]
 * 					  求3～7原数组的累加和：H[7]-H[2]
 * 
 * 占空间：矩阵n方，数组n
 * 		  但是当查询次数非常非常大，用矩阵，因为数组还要减一下
 */

public class Code02_SumiToj {
	
	private static int[][] arrSumMatrix;//矩阵
	private static int[] arrSumArray;//前缀和数组

	public static void main(String[] args) {
		int[] arr = {22,3,4,11,4,35,555,40,33};
		
		arrSumMatrix = new int[arr.length][arr.length];
		arrSum(arr);//构造
		printMatrix(arrSumMatrix);
		System.out.println(sumiTojMatrix(2,6));//使用
		
		arrSumArray = new int[arr.length];
		arrSumArray(arr);//构造
		printArray(arrSumArray);
		System.out.println(sumiTojArray(2,6));
	}
	
	public static void printMatrix(int[][] arrSum) {
		for(int i=0;i<arrSum.length;i++) {
			for(int j=0;j<arrSum[i].length;j++) {
				System.out.print(arrSum[i][j]+"\t");
			}
			System.out.println();
		}
	}
	
	public static void arrSum(int[] arr) {
		//i~j\line~row
		for(int i=0;i<arr.length;i++) {
			for(int j=i;j<arr.length;j++) {//上三角
				arrSumMatrix[i][j] = (i==j) ? arr[i] : arrSumMatrix[i][j-1] + arr[j];
			}
		}
	}
	
	public static int sumiTojMatrix(int i,int j) {
		return (i<=j) ? arrSumMatrix[i][j] : arrSumMatrix[j][i];
	}

	
	
	public static void printArray(int[] arr) {
		for(int a:arr) {
			System.out.print(a + "\t");
		}
		System.out.println();
	}
	
	public static void arrSumArray(int[] arr) {
		arrSumArray[0] = arr[0];
		for(int i=1;i<arr.length;i++) {
			arrSumArray[i] = arrSumArray[i-1] + arr[i];
		}
	}
	
	public static int sumiTojArray(int i,int j) {
		return i==0 ? arrSumArray[j] : arrSumArray[j] - arrSumArray[i-1];
	}
}
