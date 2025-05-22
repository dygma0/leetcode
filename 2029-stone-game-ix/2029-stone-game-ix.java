class Solution {
    public boolean stoneGameIX(int[] stones) {
        int s0 = 0, s1 = 0, s2 = 0;

        for (int stone : stones) {
            int remainder = stone % 3;
            if (remainder == 0)
                s0++;
            else if (remainder == 1)
                s1++;
            else
                s2++;
        }

        if (s0 % 2 == 0) {
            return s1 >= 1 && s2 >= 1;
        }

        return Math.abs(s1 - s2) > 2;
    }
}