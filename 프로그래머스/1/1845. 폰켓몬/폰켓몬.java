import java.io.*;
import java.util.*;

class Solution {
    public int solution(int[] nums) {
        Set<Integer> pocket = new HashSet<>();
		for (int i=0; i<nums.length; i++) {
			pocket.add(nums[i]);
		}
		
		int answer = 0;
		if (pocket.size() > nums.length/2) {
			answer = nums.length/2;
		} else {
			answer = pocket.size();
		}
        return answer;
    }
}