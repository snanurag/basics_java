package generics;

import java.util.Iterator;
import java.util.List;

public class TemplateInFunction {

    public static <T extends String> T max(T t){
        return t;
    }



}
