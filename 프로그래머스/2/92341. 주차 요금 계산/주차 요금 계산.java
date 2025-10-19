import java.util.*;

class Solution {
    static int baseTime, baseFee, unitTime, unitFee;
    static int limit = 23 * 60 + 59;

    public int[] solution(int[] fees, String[] records) {
        this.baseTime = fees[0];
        this.baseFee = fees[1];
        this.unitTime = fees[2];
        this.unitFee = fees[3];
        
        // 차 번호, 입차시간(:를 제외한 숫자)
        Map<String, Integer> map = new HashMap<>();
        // 차 번호, 누적 주차 시간
        Map<String, Integer> result = new HashMap<>();
        for (String rec : records) {
            String[] parts = rec.split(" ");
            String[] input = (parts[0].split(":"));
            int sec = Integer.parseInt(input[0]) * 60 + Integer.parseInt(input[1]);   
            String carId = parts[1];
            if (map.containsKey(carId)) {
                int t = sec - map.get(carId);
                result.put(carId, result.getOrDefault(carId, 0) + t);
                map.remove(carId);
            } else map.put(carId, sec);
        }
        
        // map에 남아있는 차량의 주차 시간 계산 - 23:59 출차한 것으로 간주
        for (String carId : map.keySet()) {
            int t = limit - map.get(carId);
            result.put(carId, result.getOrDefault(carId, 0) + t);
        }
                
        List<Map.Entry<String, Integer>> list = new ArrayList<>(result.entrySet());
        list.sort(Map.Entry.comparingByKey());
        
        int[] answer = calculateFee(list);
        return answer;
    }
    
    private int[] calculateFee(List<Map.Entry<String, Integer>> list) {
        int[] answer = new int[list.size()];
        for (int i=0; i<list.size(); i++) {
            int remainTime = (list.get(i).getValue()) - baseTime;
            if (remainTime > 0) {
                answer[i] = baseFee + (remainTime / unitTime) * unitFee;
                if (remainTime % unitTime > 0) answer[i] += unitFee;
            } else answer[i] = baseFee;
    
        }
        return answer;
    }
    
}