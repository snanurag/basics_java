package rmipackage.activation;

/*
 * Copyright &#169; 2003, 2010 Oracle and/or its affiliates. All  Rights Reserved.
 *
 * Redistribution and use in source and binary forms, with or
 * without modification, are permitted provided that the following
 * conditions are met:
 *
 * -Redistributions of source code must retain the above copyright
 *  notice, this list of conditions and the following disclaimer.
 *
 * -Redistribution in binary form must reproduce the above copyright
 *  notice, this list of conditions and the following disclaimer in
 *  the documentation and/or other materials provided with the
 *  distribution.
 *
 * Neither the name of Oracle and/or its affiliates. or the names of
 * contributors may be used to endorse or promote products derived
 * from this software without specific prior written permission.
 *
 * This software is provided "AS IS," without a warranty of any
 * kind. ALL EXPRESS OR IMPLIED CONDITIONS, REPRESENTATIONS AND
 * WARRANTIES, INCLUDING ANY IMPLIED WARRANTY OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE OR NON-INFRINGEMENT, ARE HEREBY
 * EXCLUDED. SUN AND ITS LICENSORS SHALL NOT BE LIABLE FOR ANY
 * DAMAGES OR LIABILITIES  SUFFERED BY LICENSEE AS A RESULT OF OR
 * RELATING TO USE, MODIFICATION OR DISTRIBUTION OF THE SOFTWARE OR
 * ITS DERIVATIVES. IN NO EVENT WILL SUN OR ITS LICENSORS BE LIABLE
 * FOR ANY LOST REVENUE, PROFIT OR DATA, OR FOR DIRECT, INDIRECT,
 * SPECIAL, CONSEQUENTIAL, INCIDENTAL OR PUNITIVE DAMAGES, HOWEVER
 * CAUSED AND REGARDLESS OF THE THEORY OF LIABILITY, ARISING OUT OF
 * THE USE OF OR INABILITY TO USE SOFTWARE, EVEN IF SUN HAS BEEN
 * ADVISED OF THE POSSIBILITY OF SUCH DAMAGES.
 *
 * You acknowledge that Software is not designed, licensed or
 * intended for use in the design, construction, operation or
 * maintenance of any nuclear facility.
 */

import java.net.MalformedURLException;
import java.rmi.MarshalledObject;
import java.rmi.Naming;
import java.rmi.RMISecurityManager;
import java.rmi.RemoteException;
import java.rmi.activation.*;
import java.util.Properties;

public class Setup {

    // This class registers information about the ActivatableImplementation
    // class with rmid and the rmiregistry
    //

    /**
     * Use this to run:
     * <p>
     * -J-Djava.security.policy=f:\workspace\LearnJava\src\rmipackage\activation
     * \policy
     */
    public static void main(String[] args) throws Exception {

        System.setProperty("java.security.policy",
                "D:\\workspaces\\workspace_old\\LearnJava\\src\\rmipackage\\activation\\policy");

        // Because of the 1.2 security model, a security policy should
        // be specified for the ActivationGroup VM. The first argument
        // to the Properties put method, inherited from Hashtable, is
        // the key and the second is the value
        //
        Properties props = new Properties();
        props.put("java.security.policy",
                "D:\\workspaces\\workspace_old\\LearnJava\\src\\rmipackage\\activation\\policy");

//		ActivationGroupDesc.CommandEnvironment ace = new java.rmi.activation.ActivationGroupDesc.CommandEnvironment(
//				"C:\\Program Files\\Java\\jdk1.6.0_21\\bin\\java", new String[] {});
        ActivationGroupDesc.CommandEnvironment ace = new java.rmi.activation.ActivationGroupDesc.CommandEnvironment(null, new String[]{});

        ActivationGroupDesc exampleGroup = new ActivationGroupDesc(props, ace);

        // Once the ActivationGroupDesc has been created, register it
        // with the activation system to obtain its ID
        //
        ActivationGroupID agi = ActivationGroup.getSystem().registerGroup(
                exampleGroup);

        //For one activation group id one jvm is launched. So all the Activatable objects associated with one activation group id through
        //ActivationDesc, would be instantiated in one jvm only.
        registerActivatableImplementation(agi);
        registerActivatableImplementation2(agi);

//		registerActivatableImplementation(null);
//		registerActivatableImplementation2(null);


    }

    private static void registerActivatableImplementation(ActivationGroupID agi) throws RemoteException, ActivationException, MalformedURLException {
        System.setSecurityManager(new RMISecurityManager());

        agi = getActivationGroupId(agi);

        System.out.println("The activation group id is: " + agi);
        // The "location" String specifies a URL from where the class
        // definition will come when this object is requested (activated).
        // Don't forget the trailing slash at the end of the URL
        // or your classes won't be found.
        //
        String location = "file:/D:\\workspaces\\workspace_old\\LearnJava\\bin\\";

        // Create the rest of the parameters that will be passed to
        // the ActivationDesc constructor
        //
        MarshalledObject data = null;

        // The location argument to the ActivationDesc constructor will be used
        // to uniquely identify this class; it's location is relative to the
        // URL-formatted String, location.
        //
        ActivationDesc desc = new ActivationDesc(agi,
                "rmipackage.activation.ActivatableImplementation", location,
                data);

        // Register with rmid
        //
        MyRemoteInterface mri = (MyRemoteInterface) Activatable.register(desc);
        System.out.println("Got the stub for the ActivatableImplementation");

        // Bind the stub to a name in the registry running on 1099
        //
        Naming.rebind("ActivatableImplementation", mri);
        System.out.println("Exported ActivatableImplementation");

    }


    private static void registerActivatableImplementation2(ActivationGroupID agi) throws RemoteException, ActivationException, MalformedURLException {
        System.setSecurityManager(new RMISecurityManager());

        agi = getActivationGroupId(agi);
        System.out.println("The activation group id is: " + agi);

        String location = "file:/D:\\workspaces\\workspace_old\\LearnJava\\bin\\";

        MarshalledObject data = null;

        ActivationDesc desc = new ActivationDesc(agi,
                "rmipackage.activation.ActivatableImplementation2", location,
                data);

        MyRemoteInterface mri = (MyRemoteInterface) Activatable.register(desc);
        System.out.println("Got the stub for the ActivatableImplementation2");

        Naming.rebind("ActivatableImplementation2", mri);
        System.out.println("Exported ActivatableImplementation2");

    }

    private static ActivationGroupID getActivationGroupId(ActivationGroupID agi) throws ActivationException, RemoteException {
        if (agi == null) {
            // Because of the 1.2 security model, a security policy should
            // be specified for the ActivationGroup VM. The first argument
            // to the Properties put method, inherited from Hashtable, is
            // the key and the second is the value
            Properties props = new Properties();
            props.put("java.security.policy",
                    "D:\\workspaces\\workspace_old\\LearnJava\\src\\rmipackage\\activation\\policy");

            ActivationGroupDesc.CommandEnvironment ace = new java.rmi.activation.ActivationGroupDesc.CommandEnvironment(null, new String[]{});

            ActivationGroupDesc exampleGroup = new ActivationGroupDesc(props, ace);

            agi = ActivationGroup.getSystem().registerGroup(
                    exampleGroup);

            //Trying to create an UniqueActivationGroupId when the same activation group id is not passed from main function
//			agi = new UniqueActivationGroupId(ActivationGroup.getSystem()); 
//			ActivationGroup.createGroup(agi,exampleGroup,1L);

        }


        return agi;
    }

}

class UniqueActivationGroupId extends ActivationGroupID {

    /**
     *
     */
    private static final long serialVersionUID = 1L;

    public UniqueActivationGroupId(ActivationSystem system) {
        super(system);
    }

    public boolean equals(Object o) {
        if (o instanceof ActivationGroupID)
            return true;
        else
            return false;
    }

    public int hashCode() {
        return 123423522;
    }


}
	