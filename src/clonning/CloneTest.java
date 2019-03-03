package clonning;

public class CloneTest implements Cloneable {

//	TODO	Try this too.	
//	private int i;
//	
//	public int getI() {
//		return i;
//	}
//
//	public void setI(int i) {
//		this.i = i;
//	}

    private CloneTest2 cTest2 = new CloneTest2();

    {
        System.out.println("clone IndexAt1Starts");
    }

    public Integer getI() {
        return this.cTest2.getI();
    }

    public void setI(int i) {
        this.cTest2.setI(i);
    }

    public Object clone() {
        try {
            return super.clone();
        } catch (CloneNotSupportedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            return null;
        }
    }

}
