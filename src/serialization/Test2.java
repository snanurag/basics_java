package serialization;

import java.io.Serializable;


public class Test2 implements Serializable {


    // while saving, don't use field serialVersionUID. But when loading, use any
    // arbitrary serialVersionUID. It should give InvalidClassException and will
    // show the serialVersionUID that jvm generated at the time of saving.

    //	private static final long serialVersionUID = 7526472295622776147L;
    Integer i = 90;

    {
        System.out.println("anutag in IndexAt1Starts 2 initialization block.");
    }

    public void mai(String[] args) {

    }
}