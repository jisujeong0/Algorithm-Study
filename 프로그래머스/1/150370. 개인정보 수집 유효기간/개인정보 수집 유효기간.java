import java.util.*;

class Solution {
    public int[] solution(String today, String[] terms, String[] privacies) {
        List<Integer> answer = new ArrayList<>();
        // 문자열 .으로 split
        String[] date = today.split("\\.");
        int year = Integer.parseInt(date[0]);
        int month = Integer.parseInt(date[1]);
        int day = Integer.parseInt(date[2]);
        // 일수로 변환
        int todayDate = (year*12*28) + (month*28) + day;
        // terms를 hashMap으로 저장: 약관 종류로 유효기간을 찾기 위함 
        Map<String, Integer> tMap = new HashMap<>();
        for (String term : terms) {
            String[] t = term.split(" ");
            tMap.put(t[0], Integer.parseInt(t[1]));
        }
    
        int idx = 1;  // privacies의 번호(인덱스 + 1)
        for (String privacy : privacies) {
            String[] pv = privacy.split(" ");
            String pDate = pv[0];
            String pTerm = pv[1];
            
            String[] p = pDate.split("\\.");
            int yy = Integer.parseInt(p[0]);
            int mm = Integer.parseInt(p[1]);
            int dd = Integer.parseInt(p[2]);
            
            int sum = mm + tMap.get(pTerm); 
            yy += (sum / 12);   // 12 이상이면 몫을 yy(년도)에 더함
            mm = sum % 12;      // 나머지는 mm으로 다시 저장
            
            int targetDate = (yy*12*28) + (mm*28) + dd;
            
            if (targetDate <= todayDate)  {
                answer.add(idx);
            }
            idx++;
        }
        Collections.sort(answer);
        return answer.stream()
            .mapToInt(i -> i)
            .toArray();
    }
}