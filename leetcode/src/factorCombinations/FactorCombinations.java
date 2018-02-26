package factorCombinations;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class FactorCombinations {
    public List<List<Integer>> getFactors(int n) {
        List<List<Integer>> res = new ArrayList<>();
        helper(res, new ArrayList<>(), n, 2);
        return res;
    }
    private void helper(List<List<Integer>> res, List<Integer> item, int n, int start) {
        if (n <= 1) {
            if (item.size() > 1) {
                res.add(new ArrayList<>(item));
            }
            return;
        }
        for (int i = start; i <= n; ++i) {
            if (n % i == 0) {
                item.add(i);
                helper(res, item, n / i, i);
                item.remove(item.size() - 1);
            }
        }
    }

    // TLE
/*    public List<List<Integer>> getFactors(int n) {
        List<List<Integer>> res = new ArrayList<>();
        if (n <= 1) {
            return res;
        }
        List<Integer> item = new ArrayList<>();
        Set<List<Integer>> set = new HashSet<>();
        helper(res, item, set, n, 1);
        return res;
    }
    private void helper(List<List<Integer>> res, List<Integer> item, Set<List<Integer>> set, int n, int product) {
        if (product == n && !set.contains(item)) {
            res.add(new ArrayList<>(item));
        }
        if (product > n) {
            return;
        }
        boolean isAdd = false;
        for (int i = 2; i <= n / 2; ++i) {
            if (n % i == 0 && (item.size() == 0 || i >= item.get(item.size() - 1))) {
                item.add(i);
                isAdd = true;
            }
            if (isAdd) {
                isAdd = false;
                helper(res, item, set, n, i * product);
                item.remove(item.size() - 1);
            }
        }
    }*/

    public static void main(String[] args) {
        FactorCombinations obj = new FactorCombinations();
        obj.getFactors(1).stream().forEach(System.out::print);
        System.out.print("\n");
        obj.getFactors(16).stream().forEach(System.out::print);
        System.out.print("\n");
        obj.getFactors(9).stream().forEach(System.out::print);
        System.out.print("\n");
        obj.getFactors(32).stream().forEach(System.out::print);

    }
}
