package exceptions;


public class Take4 {
    public static void main(String[] args) throws Exception {
        new Take4().setIt2();

    }

    public void setIt2() throws Exception            //TODO : try with commenting throws Exception.
    {
        try {
            int i = 1 / 0;
        } catch (ArithmeticException e) {
            System.out.println(2);
            //	System.exit(0);						//TODO : try with removing this comment
            throw new Exception();
        } catch (Throwable e) {
            System.out.println(3);
            // TODO: handle exception
        } finally {
            System.out.println(4);
        }
        System.out.println(5);
    }

}