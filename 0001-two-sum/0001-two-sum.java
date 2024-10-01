class Solution {
    public int[] twoSum(int[] nums, int target) {
        for (int i = 0; i < nums.length; i++) { // nums.length() -> nums.length 로 수정
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] + nums[j] == target) {
                    return new int[] { i, j };
                }
            }
        }
        // 두 수의 합이 target인 경우가 없는 경우를 대비해 예외를 던짐
        throw new IllegalArgumentException("No two sum solution");
    }
}
