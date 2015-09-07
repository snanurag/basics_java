package datastructures;

import java.util.HashMap;
import java.util.concurrent.ConcurrentHashMap;

public class ConcurrentHashMapvsHashMap {

    public static void main(String[] args) {
	
	ConcurrentHashMap<String, String> map = new ConcurrentHashMap<String, String>();

	map.put("1","1");
	map.put("2", "2");
	map.put("3", "3");
	map.put("4", "4");
	
//	for(String key : map.values())
//	{
//	    map.remove(key);
//	}

	for(String key : map.values())
	{
	    String k = ""+Math.random();
	    map.put(k, k);
	}
	
	
	System.out.println(map.values().size());
	
	HashMap<String, String> map1 = new HashMap<String, String>();

	map1.put("1","1");
	map1.put("2", "2");
	map1.put("3", "3");
	map1.put("4", "4");

	for(String key : map1.values())
	{
	    String k = ""+Math.random();
	    map1.put(k, k);
	}

//	for(String key : map1.values())
//	{
//	    map1.remove(key);
//	}
	
    }
}
