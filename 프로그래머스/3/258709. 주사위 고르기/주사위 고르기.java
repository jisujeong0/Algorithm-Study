import java.util.*;

class Solution {
    int n, half;
    int maxWins = 0;
    int[] bestChoice;
    int[][] dice;

    public int[] solution(int[][] dice) {
        this.n = dice.length;
        this.half = n / 2;
        this.dice = dice;

        comb(0, 0, new int[half]);
        Arrays.sort(bestChoice);
        for (int i = 0; i < bestChoice.length; i++) {
            bestChoice[i]++;
        }
        return bestChoice;
    }

    private void comb(int start, int depth, int[] picked) {
        if (depth == half) {
            boolean[] used = new boolean[n];
            for (int x : picked) used[x] = true;
            List<Integer> aList = new ArrayList<>();
            List<Integer> bList = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                if (used[i]) aList.add(i);
                else bList.add(i);
            }

            int wins = countWins(aList, bList);
            if (wins > maxWins) {
                maxWins = wins;
                bestChoice = picked.clone();
            }
            return;
        }
        for (int i = start; i < n; i++) {
            picked[depth] = i;
            comb(i + 1, depth + 1, picked);
        }
    }
    
    private int countWins(List<Integer> aList, List<Integer> bList) {
        int wins = 0;
        List<Integer> aSums = new ArrayList<>();
        makeSums(0, 0, aList, aSums);
        List<Integer> bSums = new ArrayList<>();
        makeSums(0, 0, bList, bSums);
        
        Collections.sort(bSums);
        for (int a : aSums) {
            int cnt = upperBound(bSums, a - 1); 
            wins += cnt;
        }
        return wins;
    }

    private int upperBound(List<Integer> list, int value) {
        int left = 0, right = list.size();
        while (left < right) {
            int mid = (left + right) / 2;
            if (list.get(mid) <= value) left = mid + 1;
            else right = mid;
        }
        return left; 
    }

    private void makeSums(int depth, int sum, List<Integer> list, List<Integer> result) {
        if (depth == list.size()) {
            result.add(sum);
            return;
        }
        int idx = list.get(depth);
        for (int x : dice[idx]) {
            makeSums(depth + 1, sum + x, list, result);
        }
    }
}
