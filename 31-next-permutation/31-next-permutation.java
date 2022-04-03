class Solution {
    public void nextPermutation(int[] nums) {
        
        // Step 1: Find the first decreasing sequence starting from end
        int i = nums.length - 2;
        
        while(i >= 0 && nums[i] >= nums[i+1]) i--;
        
        
        // Step 2: Find the number for substitution and swap
        if(i >= 0) {
            int j = nums.length - 1;
            while(j >= 0 && nums[j] <= nums[i]) j--;
            swap(nums, i, j);
        }
        
        // Step 3: Rearrange remaining array by reversing it
        reverse(nums, i+1);
        
    }
    
    public void reverse(int[] nums, int start) {
        int end = nums.length - 1;
        while(start < end) {
            swap(nums, start, end);
            start++;
            end--;
        }
    }
    
    public void swap(int[] nums, int i, int j) {
     
         int temp = nums[i];
         nums[i] = nums[j];
         nums[j] = temp;
    }
}