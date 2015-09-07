package typecasting;

import java.math.BigDecimal;

public class BigDecimalToLong {

	/**
	 * @param args
	 */
	
	
	private void passBigDecimalToLong(long l){
		System.out.println(new Long(1));
	}
	
	public static void main(String[] args) {
		
		BigDecimal bd = new BigDecimal(3);
		
		BigDecimalToLong bdtolg = new BigDecimalToLong();
		bdtolg.passBigDecimalToLong(bd.longValue());

	}

}
