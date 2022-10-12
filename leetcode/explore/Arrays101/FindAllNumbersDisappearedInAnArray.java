class Solution {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            int num = Math.abs(nums[i]) - 1;
            nums[num] = -Math.abs(nums[num]);
        }

        for (Integer i = 0; i < nums.length; i++) {
            if (nums[i] > 0){
                result.add(i+1);
            }
        }

        return result;
    }
}