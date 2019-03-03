package multithreading;

public class ThreadInterruptWorking {

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
        try {
            this.sleep(1000);
        } catch (InterruptedException e) {
            System.out.println("Sleep interrupted: " + e);
        }
        try {
            synchronized (this) {
                this.wait(100);

            }
        } catch (InterruptedException e) {
            System.out.println("Wait interrupted: " + e);
        }
        System.out.println("hi");
    }
}

class IPCCARMSession {

    public IPCCARMSession(ARMSessionCreator armSessionCreator) {
        armSessionCreator.interrupt();
        System.out.println("interrupt is done in ipccarmsession constructor");
        System.out.println(armSessionCreator.isInterrupted());
    }
}
