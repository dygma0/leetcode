class Solution {
    public int maxArea(int[] height) {
        int l = 0;
        int r = height.length - 1;  // 수정: 마지막 인덱스로 초기화
        int result = 0;

        while (l < r) {
            result = Math.max(result, calcArea(l, r, height));

            if (height[l] < height[r]) {
                l++;
            } else {
                r--;
            }
        }

        return result;
    }

    private int calcArea(int lhs, int rhs, int[] height) {
        int width = rhs - lhs;  // 수정: Math.abs 제거 (항상 rhs > lhs)
        int h = Math.min(height[lhs], height[rhs]);

        return width * h;
    }
}