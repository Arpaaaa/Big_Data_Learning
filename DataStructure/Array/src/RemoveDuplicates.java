/*Given an integer array nums sorted in non-decreasing order, remove the duplicates in-place such that each unique element appears only once. The relative order of the elements should be kept the same.
Since it is impossible to change the length of the array in some languages, you must instead have the result be placed in the first part of the array nums. More formally, if there are k elements after removing the duplicates,
then the first k elements of nums should hold the final result. It does not matter what you leave beyond the first k elements.
Return k after placing the final result in the first k slots of nums. Do not allocate extra space for another array. You must do this by modifying the input array in-place with O(1) extra memory.*/


import java.util.Arrays;

public class RemoveDuplicates {

    public static void main(String[] args) {
        //test remove duplicates
        int[] nums = {0, 0, 1, 1, 1, 2, 2, 3, 3, 4};
        RemoveDuplicates rd = new RemoveDuplicates();
        System.out.println(rd.removeDup(nums));
    }

    public int removeDup(int[] nums) {
        //判空
        if (nums.length == 0 || nums.length == 1) {
            return nums.length;
        }
        //双指针思想
        int j = 1;  //
        //变量i用来遍历数组
        for (int i = 1; i < nums.length; i++) {
            //判断第i个数和i-1个数是否相同，若相同则重复，若不相同则右移
            if (nums[i]!=nums[j-1]){    //如果两个指针指向的数不相同，则说明nums[j]没有重复
                nums[j]=nums[i];    //将nums[j]移动到nums[i]位置并且i指向下一个元素
                j++;
            }
        }
        return j;
    }

}
