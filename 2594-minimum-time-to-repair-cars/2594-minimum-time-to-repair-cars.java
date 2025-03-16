public class Solution {
    public long repairCars(int[] ranks, int cars) {
        Map<Integer, Integer> rankCount = new HashMap<>();
        for (int rank : ranks) {
            rankCount.put(rank, rankCount.getOrDefault(rank, 0) + 1);
        }
        
        long left = 1;
        long right = 0;
        
        for (int rank : ranks) {
            right = Math.max(right, (long) rank * cars * cars);
        }
        
        while (left < right) {
            long mid = left + (right - left) / 2;
            if (canRepairAllCars(rankCount, cars, mid)) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        
        return left;
    }
    
    private boolean canRepairAllCars(Map<Integer, Integer> rankCount, int cars, long time) {
        long totalCarsRepaired = 0;
        for (Map.Entry<Integer, Integer> entry : rankCount.entrySet()) {
            int rank = entry.getKey();
            int count = entry.getValue();
            totalCarsRepaired += count * (long) Math.floor(Math.sqrt((double) time / rank));
        }
        return totalCarsRepaired >= cars;
    }
}
