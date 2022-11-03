public class RemoveDuplicateII80 {
    public static void main(String[] args) {
        RemoveDuplicateII80 rdII = new RemoveDuplicateII80();
        int[] nums = {0,0,1,1,1,2};
        System.out.println(rdII.removeDuplicate2(nums));
    }

    public int removeDuplicate2(int[] nums){
        if (nums.length==0||nums.length==1){
            return nums.length;
        }
        int j=2;    //从第二个位置开始放
        for (int i = 2; i < nums.length; i++) {     //从第三个元素开始遍历
            if (nums[i]!=nums[j-2]){    //如果元素和前两位元素的第一个不同，则把元素放到该位置
                nums[j]=nums[i];
                j++;
            }
        }
        return j;
    }
}
