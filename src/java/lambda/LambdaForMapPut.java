package lambda;

import java.util.HashMap;
import java.util.Map;

public class LambdaForMapPut {
    public void testMapPut(){
        Map<String, String> m = new HashMap<>();
        MapPut mp = (a,b) ->  m.put(a,b);
        mp = m::put;
    }
}

interface MapPut{
    public void m(String a,String b);
}