import java.util.Arrays;

public class MoveZero283 {
    /*将数组中所有的0移动到数组的末尾*/
    public static void main(String[] args) {
        MoveZero283 mz = new MoveZero283();
        int[] nums = {0, 0, 1, 2, 3, 4};
        mz.moveZeros(nums);
        for (int num : nums) {
            System.out.print(num);
        }
    }

    public void moveZeros(int[] nums) {
        /*逆向思维，将非零的元素向前移动*/
        int j = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {        //如果第i个数不是0
                nums[j] = nums[i];    //则把第i个数放到j位置
                j++;
            }
        }
        for (int i = j; i < nums.length; i++) {
            nums[i] = 0;
        }
    }
}
