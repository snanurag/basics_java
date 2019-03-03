package exceptions;

import java.io.FileNotFoundException;

public class TestFinallyBlockWithoutCatch {


    public static void main(String[] args) {
        TestFinallyBlockWithoutCatch t = new TestFinallyBlockWithoutCatch();
        System.out.println(t.setName());
    }

    public int setName() {
        try {
            throw new FileNotFoundException();
        } finally {
            return 4;
        }
    }
}
