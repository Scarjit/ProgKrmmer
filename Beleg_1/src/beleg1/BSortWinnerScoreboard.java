package beleg1;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;
 
public class BSortWinnerScoreboard {
	public static TreeMap<String, Integer> generateScoreboard(int[] points){
		HashMap<String, Integer> map = new HashMap<String, Integer>();
		for(int i=0;i<points.length;i++){
			map.put(""+i, points[i]);
		}
 
		TreeMap<String, Integer> sortedMap = SortByValue(map);  
		return sortedMap;
	}
 
	public static TreeMap<String, Integer> SortByValue 
			(HashMap<String, Integer> map) {
		ValueComparator vc =  new ValueComparator(map);
		TreeMap<String,Integer> sortedMap = new TreeMap<String,Integer>(vc);
		sortedMap.putAll(map);
		return sortedMap;
	}
}
 
class ValueComparator implements Comparator<String> {
 
    Map<String, Integer> map;
 
    public ValueComparator(Map<String, Integer> base) {
        this.map = base;
    }
 
    public int compare(String a, String b) {
        if (map.get(a) >= map.get(b)) {
            return -1;
        } else {
            return 1;
        } // returning 0 would merge keys 
    }
}
