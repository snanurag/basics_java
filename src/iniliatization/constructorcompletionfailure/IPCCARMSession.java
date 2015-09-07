package iniliatization.constructorcompletionfailure;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class IPCCARMSession {

	public static final List<IPCCARMSession> sessionList = Collections
			.synchronizedList(new ArrayList<IPCCARMSession>());
	int i = 0;

	IPCCARMSession() throws Exception {
		sessionList.add(this);
		i = 10;
		throw new Exception();
	}
}
