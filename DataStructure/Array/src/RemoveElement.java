/*Leetcode 27 */

import java.util.ArrayList;

public class RemoveElement {
    public static void main(String[] args) {
        RemoveElement re = new RemoveElement();
        //测试用例
        int[] nums = {3,2,2,3};
        int val = 3;
        System.out.println(re.removeElement(nums, val));

    }

    public int removeElement(int[] nums,int val){
        /*逆向思维，如果需要去掉val值的元素，那就让非val值的元素占定数组前面的位置
        * 有点双指针的意思了*/
        int j = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i]!=val){
                nums[j] = nums[i];  //将第j个位置复制为nums[i]
                j++;    //  j移动到下一个元素位置
            }
        }
        return j;
    }
}
