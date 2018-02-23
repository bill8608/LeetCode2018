package twoSum;

import java.util.HashMap;
import java.util.Map;

public class TwoSumIIIDataStuctureDesign {
    private Map<Integer, Integer> map;
    /** Initialize your data structure here. */
    public TwoSumIIIDataStuctureDesign() {
        map = new HashMap<>();
    }

    /** Add the number to an internal data structure.. */
    public void add(int number) {
        map.put(number, map.getOrDefault(number, 0) + 1);
    }

    /** Find if there exists any pair of numbers which sum is equal to the value. */
    public boolean find(int value) {
        for (int key : map.keySet()) {
            if (key != value - key) {
                if (map.containsKey(value - key)) {
                    return true;
                }
            } else if (map.get(key) >= 2) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        TwoSumIIIDataStuctureDesign twoSum = new TwoSumIIIDataStuctureDesign();
        System.out.println(twoSum.find(4) == false);
        twoSum.add(1);
        twoSum.add(3);
        twoSum.add(4);
        System.out.println(twoSum.find(4) == true);
        System.out.println(twoSum.find(7) == true);
        System.out.println(twoSum.find(8) == false);
    }
}
