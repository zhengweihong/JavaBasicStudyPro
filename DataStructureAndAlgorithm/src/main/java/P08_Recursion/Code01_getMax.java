package P08_Recursion;

/**
 * @author : ZWH 2021/5/27
 * @version : 1.0
 */
public class Code01_getMax {
    public int getMax(int[] arr) {
        return getMaxRange(arr,0,arr.length-1);
    }

    public int getMaxRange(int[] arr,int L,int R) {
        if (L == R)
            return arr[L];

        int mid = L + ((R - L) >> 1);
        int leftMax = getMaxRange(arr,L,mid);
        int rightMax = getMaxRange(arr,mid+1,R);
        return Math.max(leftMax,rightMax);
    }
}
