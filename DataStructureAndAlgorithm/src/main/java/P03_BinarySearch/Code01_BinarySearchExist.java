package P03_BinarySearch;

/**
 * @author : ZWH 2021/5/17
 * @version : 1.0
 */
public class Code01_BinarySearchExist {
    public boolean binarySearchExist(int[] sortedArr, int num) {
        if (sortedArr == null || sortedArr.length == 0) return false;

        int L = 0;
        int R = sortedArr.length - 1;
        int mid;
        //L...mid...R
        //L..R
        //       L..R
        while (L <= R) {
            //mid = (L + R)/2;//直接加会越界
            mid = L + ((R - L) >> 1);//L + (R - L)/2
            if (sortedArr[mid] == num) {
                return true;
            } else if (sortedArr[mid] > num) {
                R = mid - 1;
            } else {
                L = mid + 1;
            }
        }

        return false;
        //sortedArr[L] == num;
        //如果while(L<R)，L==R的时候停止循环，需要单独判断L位置的
    }

    public static void main(String[] args) {
        //System.out.println(binarySearchExist(new int[]{1, 2, 3, 4, 5, 6},0));
    }
}
