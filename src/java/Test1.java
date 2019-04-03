import java.util.ArrayList;
import java.util.List;

public class Test1 {
    public static void main(String[] args) {
        List<Integer> wheels = new ArrayList<>();
        List<Integer> l = new ArrayList<>();
        wheels.add(3);
        wheels.add(6);
        for(int i=1;i<wheels.size(); i++){
            l.add(wheels.get(i)/4 +1);
        }
        System.out.println(l);

    }
}
