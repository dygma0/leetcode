class Solution {
    public int minCapability(int[] nums, int k) {
        int left = 0;
        int right = 0;
        
        // 이진 탐색 범위 설정: 배열의 최소값과 최대값
        for (int num : nums) {
            right = Math.max(right, num);
        }
        
        // 이진 탐색
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (canRobKHouses(nums, k, mid)) {
                right = mid; // 더 작은 값 탐색
            } else {
                left = mid + 1; // 더 큰 값 탐색
            }
        }
        
        return left;
    }
    
    private boolean canRobKHouses(int[] nums, int k, int maxAmount) {
        int count = 0; // 털 수 있는 집의 개수
        int i = 0;
        
        // Greedy 방식으로 최대한 많은 집을 털되, maxAmount 이하로 제한
        while (i < nums.length) {
            if (nums[i] <= maxAmount) {
                count++; // 현재 집을 털기
                i += 2;  // 인접한 집은 건너뜀
            } else {
                i++; // 털 수 없으면 다음 집으로 이동
            }
        }
        
        return count >= k; // k개 이상 털 수 있는지 확인
    }
}