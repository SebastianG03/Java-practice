package most_used_words;

import java.util.*;

public class TopWords {

    public static List<String> top3(String s) {
        String[] str = s.replaceAll("[^A-Za-z']", "").split(" ");
        Map<String, Integer> map = new HashMap<>();
        Arrays.stream(str).sorted();
        for(String word : str) {
            if(map.containsKey(word)) {
                map.put(word, map.get(word) + 1);
            } else
                map.put(word, 1);
        }

        List<Map.Entry<String, Integer>> list = new LinkedList<>(map.entrySet());
        Collections.sort(list, new Comparator<Map.Entry<String, Integer>>() {
            @Override
            public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2) {
                return o2.getValue().compareTo(o1.getValue());
            }
        });
        List<String> top3 = new ArrayList<>();
        top3.add(list.get(0).getKey());
        top3.add(list.get(1).getKey());
        top3.add(list.get(2).getKey());
        return top3;




    }
}
