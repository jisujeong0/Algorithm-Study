import java.util.*;

class Solution {
    static Map<String, List<Integer>> infoMap = new HashMap<>();

    public int[] solution(String[] info, String[] query) {
        for (String i : info) {
            String[] parts = i.split(" ");
            String lang = parts[0];
            String job = parts[1];
            String career = parts[2];
            String food = parts[3];
            int score = Integer.parseInt(parts[4]);

            String[] attrs = {lang, job, career, food};
            for (int mask = 0; mask < (1 << 4); mask++) {
                StringBuilder key = new StringBuilder();
                for (int j = 0; j < 4; j++) {
                    if ((mask & (1 << j)) != 0) key.append(attrs[j]);
                    else key.append("-");
                    if (j < 3) key.append("-");
                }
                infoMap.computeIfAbsent(key.toString(), k -> new ArrayList<>()).add(score);
            }
        }

        for (List<Integer> scores : infoMap.values()) {
            Collections.sort(scores);
        }

        int[] answer = new int[query.length];
        for (int i = 0; i < query.length; i++) {
            answer[i] = countQuery(query[i]);
        }
        return answer;
    }

    private int countQuery(String q) {
        String[] parts = q.split(" and ");
        String[] last = parts[3].split(" ");
        String key = parts[0] + "-" + parts[1] + "-" + parts[2] + "-" + last[0];
        int minScore = Integer.parseInt(last[1]);

        List<Integer> scores = infoMap.getOrDefault(key, new ArrayList<>());
        int left = 0, right = scores.size();
        while (left < right) {
            int mid = (left + right) / 2;
            if (scores.get(mid) >= minScore) right = mid;
            else left = mid + 1;
        }
        return scores.size() - left;
    }
}