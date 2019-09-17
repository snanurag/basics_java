package interviews.amazon;

import java.util.*;

/**
 * Case 1
 * Input : List has
 * superman
 * supersuperman
 * super
 * super
 * man
 * Output :
 * supersuperman -> super,super,man
 * superman -> super, man
 *
 * <p>
 * <p>
 *
 * Case 2
 * Input : List has
 * habit
 * hab it
 * ha bit
 * Output :
 * habit -> (hab, it), (ha,bit)
 *
 */
public class DetectSubstrings {

    static Map<String, Integer> map = null;

    public static Map<String, List<List<String>>> detectSubstrings(List<String> list) {
        map = new HashMap<>();
        list.stream().forEach(n -> map.put(n, map.get(n) == null ? 1 : map.get(n) + 1));

        Map<String, List<List<String>>> fm = new HashMap<>();
        for (String s : list) {
            List<List<String>> l = getListOfListsOfSubString(s);
            if (l != null)
                fm.put(s, l);
        }
        return fm;
    }


    public static List<List<String>> getListOfListsOfSubString(String s) {
        String tmp = "";

        List<List<String>> fl = null;
        for (int i = 0; i < s.length(); i++) {
            if (i == s.length() - 1)
                return fl;
            tmp += s.charAt(i);
            if (map.containsKey(tmp) && map.get(tmp) > 0) {
                List<String> l = new ArrayList<>();
                doFoundWordOperation(tmp, l);

                boolean foundSubstrs = addAllSubstrToList(s.substring(i + 1), l);
                if (foundSubstrs) {
                    if (fl == null)
                        fl = new ArrayList<>();
                    fl.add(l);
                }
                repairMap(l);
            }
        }
        return fl;

    }


    private static boolean addAllSubstrToList(String s, List<String> l) {
        String tmp = "";
        for (int i = 0; i < s.length(); i++) {
            tmp += s.charAt(i);
            if (map.containsKey(tmp) && map.get(tmp) > 0) {
                doFoundWordOperation(tmp, l);
                if (i == s.length() - 1)
                    return true;
                else
                    return addAllSubstrToList(s.substring(i + 1), l);
            }
        }
        return false;
    }

    private static void doFoundWordOperation(String tmp, List<String> l) {
        l.add(tmp);
        map.put(tmp, map.get(tmp) - 1);
    }

    private static void repairMap(List<String> l) {
        l.stream().forEach(n -> map.put(n, map.get(n) == null ? 1 : map.get(n) + 1));
    }

    public static void main(String[] args) {
        Map<String, List<List<String>>> m = detectSubstrings(Arrays.asList("superman", "supersuperman", "super", "super", "man"));
        System.out.println(m.get("supersuperman").get(0).containsAll(Arrays.asList("super", "super", "man"))
                && m.get("superman").get(0).containsAll(Arrays.asList("super", "man")));

        m = detectSubstrings(Arrays.asList("habit", "ha", "bit", "hab", "it", "natural", "order"));
        System.out.println(m.get("habit").get(0).containsAll(Arrays.asList("ha", "bit")) && m.get("habit").get(1).containsAll(Arrays.asList("hab", "it")));
    }
}