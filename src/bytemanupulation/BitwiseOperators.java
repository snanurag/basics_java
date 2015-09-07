package bytemanupulation;

public class BitwiseOperators {
	public static void main(String[] args) {

		byte  j = -8<<0x1d;			//shifting left by 29 digits.  -8 = 11111111111111111111111111111000
		//	byte l = -8 << 0x1c;	//Error: Giving error because at compile time calculating that int is going out of the range of byte.
		// -1 = 11111111111111111111111111111111
		byte k = -1<<96;			//It is not giving an error because it shifts the digits by the remainder of 96 to 32. 
		//	byte m = -1 << 95		//Error: Giving error because it shifts the digit left by the remainder of 95 to 32 i.e. 31.
		//	byte n = -8 & 0xfff;	//Error: Because going out of byte range.
		
		System.out.println(Integer.toBinaryString(-1));
	}
}
