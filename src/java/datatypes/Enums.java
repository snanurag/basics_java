package datatypes;

public class Enums {

    public static void main(String[] args) {
//		Enums.DIGIT.UNIT;
    }


    private enum DIGIT {
        UNIT {
            public int getWords(int i) {
                return 0;
            }
        }
    }
}
