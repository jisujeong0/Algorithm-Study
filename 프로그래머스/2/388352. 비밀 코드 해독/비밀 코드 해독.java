import java.util.*;

class Solution {
    static int[][] q;
    static int[] ans;
    static int n;
    static int result;

    public int solution(int n, int[][] q, int[] ans) {
        this.q = q;
        this.ans = ans;
        this.n = n;
        result = 0;
        
        // ans가 가장 큰 숫자 리스트 찾기
        int max = -1, idx = -1;
        for (int i = 0; i < ans.length; i++) {
            if (ans[i] == 5) return 1;
            if (ans[i] > max) {
                max = ans[i];
                idx = i;
            }
        }

        // q[idx]에서 max개 숫자 조합하기
        combEssential(0, q[idx], max, new ArrayList<>());

        return result;
    }

    // 필수로 들어가야 하는 숫자 조합 만들기
    private void combEssential(int start, int[] numbers, int r, List<Integer> base) {
        if (base.size() == r) {
            fillPassword(base, numbers);
            return;
        }
        for (int i = start; i < numbers.length; i++) {
            base.add(numbers[i]);
            combEssential(i + 1, numbers, r, base);
            base.remove(base.size() - 1);
        }
    }

    // base 포함해서 5자리 숫자 만들기
    private void fillPassword(List<Integer> base, int[] numbers) {
        Set<Integer> ban = new HashSet<>();

        // ans == 0인 경우 숫자 5개 사용 금지
        for (int i = 0; i < ans.length; i++) {
            if (ans[i] == 0) {
                for (int x : q[i]) ban.add(x);
            }
        }
        
        // q[idx]에서 선택되지 않은 나머지 수를 ban에 추가
        for (int x : numbers) {
            if (!base.contains(x)) ban.add(x);
        }
        
        // base와 ban에 없는 숫자를 후보로 추가
        List<Integer> cand = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            if (!base.contains(i) && !ban.contains(i)) cand.add(i);
        }

        combPassword(0, cand, 5 - base.size(), new ArrayList<>(base));
    }

    private void combPassword(int start, List<Integer> cand, int r, List<Integer> cur) {
        if (r == 0) {
            if (check(cur)) result++;
            return;
        }
        
        for (int i = start; i < cand.size(); i++) {
            cur.add(cand.get(i));
            combPassword(i + 1, cand, r - 1, cur);
            cur.remove(cur.size() - 1);
        }
    }

    private boolean check(List<Integer> password) {
        for (int i = 0; i < q.length; i++) {
            int cnt = 0;
            for (int x : password)
                for (int y : q[i])
                    if (x == y) cnt++;
            if (cnt != ans[i]) return false;
        }
        return true;
    }
}
