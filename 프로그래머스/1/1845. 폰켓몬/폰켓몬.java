import java.util.*;

class Solution {
    public int solution(int[] nums) {
        Set<Integer> pockets = new HashSet<>();
        for (int n : nums) {
            pockets.add(n);
        }
        int len = nums.length/2;
        if (pockets.size() >= len) {
            return len;
        } else {
            return pockets.size();
        }
    }
}