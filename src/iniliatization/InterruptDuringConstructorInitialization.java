package iniliatization;

public class InterruptDuringConstructorInitialization {

	public static void main(String[] args) {
		ARMSessionCreator armSessionCreator = new ARMSessionCreator();
		armSessionCreator.start();
	}

}

class ARMSessionCreator extends Thread {
	@Override
	public void run() {
		IPCCARMSession ipccARMSession = null;
		ipccARMSession = new IPCCARMSession(this);
		System.out.println(ipccARMSession);
		// TODO Auto-generated method stub

	}

}

class OpenReqRegulator implements Runnable {

	private IPCCARMSession session = null;

	public OpenReqRegulator(IPCCARMSession session) {
		this.session = session;
	}

	@Override
	public void run() {
		System.out.println(session);
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(session);
	}
}

class IPCCARMSession {

	public IPCCARMSession(ARMSessionCreator armSessionCreator) {
		OpenReqRegulator openReqRegulator = new OpenReqRegulator(this);
		Thread openRegThread = new Thread(openReqRegulator);
		openRegThread.start();
		try {
			Thread.sleep(500);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		armSessionCreator.interrupt();
		System.out.println("interrupt is done in ipccarmsession constructor");
		// TODO Auto-generated constructor stub
	}
}
