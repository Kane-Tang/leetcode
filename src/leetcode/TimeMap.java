package leetcode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javafx.*;
import javafx.util.Pair;

class TimeMap {
    Map<String, List<Pair<Integer, String>>> M;

    public TimeMap() {
        M = new HashMap();
    }

    public void set(String key, String value, int timestamp) {
        if (!M.containsKey(key))
            M.put(key, new ArrayList<Pair<Integer, String>>());

        M.get(key).add(new Pair(timestamp, value));
    }

    public String get(String key, int timestamp) {
        if (!M.containsKey(key)) return "";

        List<Pair<Integer, String>> A = M.get(key);
        int i = Collections.binarySearch(A, new Pair<Integer, String>(timestamp, "{"),
                (a, b) -> Integer.compare(a.getKey(), b.getKey()));

        if (i >= 0)//find it
            return A.get(i).getValue();
        else if (i == -1)//not found
            return "";
        else
            return A.get(-i-2).getValue();
    }
}

/**
 * Your TimeMap object will be instantiated and called as such:
 * TimeMap obj = new TimeMap();
 * obj.set(key,value,timestamp);
 * String param_2 = obj.get(key,timestamp);
 */