
/*
    双指针删除数组中的元素,返回新数组的长度
 */

public class Code001 {

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 3, 5};
        int target = 3;

        System.out.println(getRes(arr, target));
    }

    private static int getRes(int[] arr, int target) {

        int slow = 0;
        for (int fast = 0; fast < arr.length; fast++) {
            if (arr[fast] != target) {
                arr[slow] = arr[fast];
                slow++;
            }
        }
        // 新数组的长度
        return slow;
    }
}