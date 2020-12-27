package greedyAlgorithm;

import java.util.*;

//集合覆盖
public class GreedyAlgorithm {


    public static void main(String[] args) {

        Map<String,Set<String>> map = new HashMap<>();

        Set set1 = new HashSet();
        set1.add("北京");
        set1.add("上海");
        set1.add("天津");

        Set set2 = new HashSet();
        set2.add("广州");
        set2.add("北京");
        set2.add("深圳");

        Set set3 = new HashSet();
        set3.add("成都");
        set3.add("上海");
        set3.add("杭州");

        Set set4 = new HashSet();
        set4.add("上海");
        set4.add("天津");

        Set set5 = new HashSet();
        set5.add("杭州");
        set5.add("大连");

        map.put("k1",set1);
        map.put("k2",set2);
        map.put("k3",set3);
        map.put("k4",set4);
        map.put("k5",set5);
        Set<String> selectKeys = greedyAlgorithm(map);
        System.out.println(selectKeys);

    }

    public static Set<String> greedyAlgorithm(Map<String,Set<String>> map){

        Set<String> allCity = new HashSet<>();

        for(Map.Entry<String,Set<String>> entry  : map.entrySet()){
            for(String str : entry.getValue()){
                allCity.add(str);
            }
        }

        Set<String> selects = new HashSet<>();

        String maxKey = null;

        Set<String> tempSet = new HashSet<>();

        while(allCity.size() >0){
            maxKey = null;
            for(String key  : map.keySet()){
                tempSet.clear();
                Set<String> set = map.get(key);
                tempSet.addAll(set);
                tempSet.retainAll(allCity);

                if(tempSet.size() > 0 && (maxKey == null || tempSet.size() > map.get(maxKey).size())){
                    maxKey = key;
                }
            }
            if(maxKey != null){
                selects.add(maxKey);
                allCity.removeAll(map.get(maxKey));
            }
        }
        return selects;
    }
}
