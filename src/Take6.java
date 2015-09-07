
public class Take6 extends Take5{

	/**
	 * @param args
	 */
	
	static Take6 t = new Take6();
	public static Take6 getInstance(){
		if(t!=null){
			return t;
		}
		else
			return null;
			
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
	//	t.setS("hey");
		System.out.println(t.getS());
	}
	public void setS(String s)throws Exception{
//		this.s = s;
	}

}
