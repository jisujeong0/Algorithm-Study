import java.util.*;

class Solution {
    public int solution(String[][] clothes) {
        // 1. 의상 종류별 개수를 HashMap에 저장
        // 2. 각 종류의 개수에 + 1(아무것도 선택하지 않는 경우 포함)
        // 3. 경우의 수를 곱
        // 4. 결과에 - 1(모두 입지 않는 경우 제외)
        HashMap<String, Integer> map = new HashMap<>();
        for (String[] c : clothes) {
            map.put(c[1], map.getOrDefault(c[1], 0) + 1);
        }
        
        int answer = 1;
        for (String m : map.keySet()) {
            answer *= map.get(m) + 1;
        }
        return answer - 1;
    }
}