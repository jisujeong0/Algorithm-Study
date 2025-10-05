import java.util.*;

class Solution {
    public int[] solution(int[][] edges) {
        Map<Integer, List<Integer>> graph = new HashMap<>();
        Map<Integer, Integer> inDegree = new HashMap<>();
        Map<Integer, Integer> outDegree = new HashMap<>();
        Set<Integer> nodes = new HashSet<>();

        for (int[] e : edges) {
            int from = e[0], to = e[1];
            if (!graph.containsKey(from)) {
                graph.put(from, new ArrayList<>());
            }
            graph.get(from).add(to);
            outDegree.put(from, outDegree.getOrDefault(from, 0) + 1);
            inDegree.put(to, inDegree.getOrDefault(to, 0) + 1);
            nodes.add(from);
            nodes.add(to);
        }

        int newNode = -1;
        for (int node : nodes) {
            int out = outDegree.getOrDefault(node, 0);
            int in = inDegree.getOrDefault(node, 0);
            if (in == 0 && out >= 2) {
                newNode = node;
                break;
            }
        }

        int donut = 0, stick = 0, eight = 0;
        Set<Integer> visited = new HashSet<>();
        
        for (int next : graph.get(newNode)) {
            if (visited.contains(next)) continue;
            Set<Integer> component = new HashSet<>();
            Queue<Integer> q = new LinkedList<>();
            q.add(next);
            visited.add(next);

            while (!q.isEmpty()) {
                int cur = q.poll();
                component.add(cur);
                for (int nxt : graph.getOrDefault(cur, new ArrayList<>())) {
                    if (!visited.contains(nxt)) {
                        visited.add(nxt);
                        q.add(nxt);
                    }
                }
            }

            // 그래프 유형 판별
            boolean hasZeroOut = false;       
            boolean hasInDegreeTwo = false; 

            for (int node : component) {
                int in = inDegree.getOrDefault(node, 0);
                int out = outDegree.getOrDefault(node, 0);

                if (node == next) in--;  // 생성한 정점과 연결된 노드라면 in--;
                
                if (out == 0) hasZeroOut = true;
                if (in >= 2) hasInDegreeTwo = true;
            }
            
            if (hasInDegreeTwo) eight++;
            else if (hasZeroOut) stick++;
            else donut++;
        }
        return new int[]{newNode, donut, stick, eight};
    }
}
