package LeetCode;

import java.util.*;

public class Leet692 {
    public List<String> topKFrequent(String[] words, int k) {

        Map<String, Integer> map = new HashMap<>();

        for (String element : words) {
            map.put(element, 0);
        }
        
        for (String element : words) {
            if (map.containsKey(element)) {
                int val = map.get(element);
                map.put(element, val+1);
            }
        }

        List<Map.Entry<String, Integer>> entries = new ArrayList<>(map.entrySet());
        Collections.sort(entries, (o1, o2) -> {
           if (o1.getValue().equals(o2.getValue())) {
               return o1.getKey().compareTo(o2.getKey());
           }
           return o2.getValue().compareTo(o1.getValue());
        });

        List<String> result = new ArrayList<>();

        for (int i = 0; i < k; i++) {
            result.add(entries.get(i).getKey());
        }

        return result;
    }

    public static void main(String[] args) {
        System.out.println(new Leet692().topKFrequent(new String[]{"i","love","leetcode","i","love","coding"}, 2));
        System.out.println(new Leet692().topKFrequent(new String[]{"the","day","is","sunny","the","the","the","sunny","is","is"}, 4));
    }
}
