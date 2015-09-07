package datatypes;

public class Enums {

	private enum DIGIT{
		UNIT{
			public int getWords(int i){
				return 0;
			}
		}
	}
	

	public static void main(String[] args) {
		Enums.DIGIT.UNIT;
	}
}
