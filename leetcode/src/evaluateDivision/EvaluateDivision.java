package evaluateDivision;

import com.sun.tools.corba.se.idl.constExpr.EvaluationException;

import java.util.*;

public class EvaluateDivision {
    public double[] calcEquation(String[][] equations, double[] values, String[][] queries) {
        Map<String, List<Edge>> graph = new HashMap<>();
        int i = 0;
        for (String[] equation : equations) {
            if (!graph.containsKey(equation[0])) {
                graph.put(equation[0], new ArrayList<>());
            }
            graph.get(equation[0]).add(new Edge(equation[1], values[i]));

            if (!graph.containsKey(equation[1])) {
                graph.put(equation[1], new ArrayList<>());
            }
            graph.get(equation[1]).add(new Edge(equation[0], 1.0 / values[i]));
            i++;
        }
        double[] res = new double[queries.length];
        i = 0;
        for (String[] query : queries) {
            Set<String> visited = new HashSet<>();
            res[i] = helper(graph, visited, query[0], query[1],1.0);
            i++;
        }
        return res;
    }
    private double helper(Map<String, List<Edge>> graph, Set<String> visited, String start, String end, double dis) {
        if (!graph.containsKey(start)) {
            return -1.0;
        }
        if (start.equals(end)) {
            return dis;
        }

        for (Edge edge : graph.get(start)) {
            if (!visited.contains(edge.to)) {
                visited.add(edge.to);
                double res = helper(graph, visited, edge.to, end, dis * edge.weight);
                if (res != -1.0) {
                    return res;
                }
            }
        }
        return -1.0;
    }

    class Edge {
        double weight;
        String to;
        Edge(String t, double w) {
            to = t;
            weight = w;
        }
    }

    public static void main(String[] args) {
        String[][] equations = {{"a", "b"}, {"b", "c"}};
        double[] values = {2.0, 3.0};
        String[][] queries = {{"a", "c"}, {"b", "a"}, {"a", "e"}, {"a", "a"}, {"x", "x"}};
        EvaluateDivision obj = new EvaluateDivision();
        Arrays.stream(obj.calcEquation(equations, values, queries)).forEach(System.out::println);

    }
}
