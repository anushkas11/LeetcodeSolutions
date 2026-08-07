class Solution {

    class Pair {
        String variable;
        double value;

        Pair(String variable, double value) {
            this.variable = variable;
            this.value = value;
        }
    }

    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {

        Map<String, List<Pair>> graph = new HashMap<>();

        for (int i = 0; i < equations.size(); i++) {

            String u = equations.get(i).get(0);
            String v = equations.get(i).get(1);

            double val = values[i];

            graph.putIfAbsent(u, new ArrayList<>());
            graph.putIfAbsent(v, new ArrayList<>());

            graph.get(u).add(new Pair(v, val));
            graph.get(v).add(new Pair(u, 1.0 / val));
        }

        double[] answer = new double[queries.size()];

        for (int i = 0; i < queries.size(); i++) {

            String source = queries.get(i).get(0);
            String destination = queries.get(i).get(1);

            if (!graph.containsKey(source) || !graph.containsKey(destination)) {
                answer[i] = -1.0;
            } else {
                Set<String> visited = new HashSet<>();
                answer[i] = dfs(source, destination, graph, visited);
            }
        }

        return answer;
    }

    private double dfs(String current,
                       String destination,
                       Map<String, List<Pair>> graph,
                       Set<String> visited) {

        if (current.equals(destination))
            return 1.0;

        visited.add(current);

        for (Pair neighbor : graph.get(current)) {

            if (!visited.contains(neighbor.variable)) {

                double result = dfs(neighbor.variable,
                                    destination,
                                    graph,
                                    visited);

                if (result != -1.0)
                    return neighbor.value * result;
            }
        }

        return -1.0;
    }
}