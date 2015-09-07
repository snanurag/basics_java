package iniliatization.constructorcompletionfailure;

public class TestIPCCARMSession {

	public static void main(String[] args) {
		try {
			IPCCARMSession ipccARMSession = new IPCCARMSession();
			System.out.println(ipccARMSession.i);
		} catch (Exception e) {
			// TODO Auto-generated catch block

		}
		System.out.println(IPCCARMSession.sessionList.get(0).i);

	}
}
