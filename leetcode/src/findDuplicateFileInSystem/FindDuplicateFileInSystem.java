package findDuplicateFileInSystem;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FindDuplicateFileInSystem {
    public List<List<String>> findDuplicate(String[] paths) {
        List<List<String>> listOfList = new ArrayList<>();
        if (paths == null || paths.length == 0) {
            return listOfList;
        }
        Map<String, List<String>> map = new HashMap<>();
        for (String path : paths) {
            //String[] strs = path.split("//s+");
            String[] strs = path.split(" ");
            for (int i = 1; i < strs.length; ++i) {
                int leftIndex = strs[i].indexOf("(");
                int rightIndex = strs[i].indexOf(")");
                String content = strs[i].substring(leftIndex + 1, rightIndex);
                if (!map.containsKey(content)) {
                    List<String> list = new ArrayList<>();
                    map.put(content, list);
                }
                map.get(content).add(strs[0] + "/" + strs[i].substring(0, leftIndex));
            }
        }
        for(List<String> list : map.values()) {
            if (list.size() > 1) {
                listOfList.add(new ArrayList<>(list));
            }
        }
        return listOfList;
    }

    public static void main(String[] args) {
        FindDuplicateFileInSystem obj = new FindDuplicateFileInSystem();
        String[] paths = new String[]{"root/a 1.txt(abcd) 2.txt(efgh)","root/c 3.txt(abcd)","root/c/d 4.txt(efgh)","root 4.txt(efgh)"};
        String[] paths2 = new String[]{"root/a 1.txt(abcd)", "root/c/d 4.txt(efgh)"};

        List<List<String>> res;
        int count = 1;
        for (String[] path : new String[][]{paths, paths2}) {
            System.out.println(String.format("\nCase %s:", count));
            res = obj.findDuplicate(path);
            for (List<String> list : res) {
                System.out.println("[");
                for (String str : list) {
                    System.out.println(str);
                }
                System.out.println("}");
            }
        }
    }
}
