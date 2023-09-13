import java.util.*;

class Solution {

  // Problem 1
  class TimeMap {

    Map<String, TreeMap<Integer, String>> map;

    public TimeMap() {
      map = new HashMap<>();
    }

    public void set(String key, String value, int timestamp) {
      map.putIfAbsent(key, new TreeMap<>());
      TreeMap<Integer, String> tv = map.get(key);
      tv.put(timestamp, value);
    }

    public String get(String key, int timestamp) {
      if (!map.containsKey(key)) return "";
      TreeMap<Integer, String> tv = map.get(key);
      Integer prev = tv.floorKey(timestamp);
      return prev == null ? "" : tv.get(prev);
    }
  }
}


/**
 * Your TimeMap object will be instantiated and called as such:
 * TimeMap obj = new TimeMap();
 * obj.set(key,value,timestamp);
 * String param_2 = obj.get(key,timestamp);
 */
