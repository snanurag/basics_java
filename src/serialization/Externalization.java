package serialization;

// : c12:Blip3.java
// Reconstructing an externalizable object.
// From 'Thinking in Java, 3rd ed.' (c) Bruce Eckel 2002
// www.BruceEckel.com. See copyright notice in CopyRight.txt.

import java.io.*;

/**
 * Only the identity of the class of an Externalizable instance is written in
 * the serialization stream and it is the responsibility of the class to save
 * and restore the contents of its instances. The writeExternal and readExternal
 * methods of the Externalizable interface are implemented by a class to give
 * the class complete control over the format and contents of the stream for an
 * object and its supertypes.
 * <p>
 * When an Externalizable object is reconstructed, an instance is created using
 * the public no-arg constructor, then the readExternal method called.
 * Serializable objects are restored by reading them from an ObjectInputStream.
 * An Externalizable instance can designate a substitution object via the
 * writeReplace and readResolve methods documented in the Serializable
 * interface.
 *
 * @author anurag
 */

public class Externalization implements Externalizable { // TODO Try the same
    // thing with
    // Serializable
    // interface
    private int i;

    private String s; // No initialization

//	public Externalization() {				// TODO : try with commenting out this constructor also.
//		// s, i not initialized
//	}

    {
        System.out.println("In initialization block");
    }

    public Externalization(String x, int a) {
        s = x;
        i = a;
        // s & i initialized only in nondefault constructor.
    }

    public static void main(String[] args) throws IOException,
            ClassNotFoundException {
        Externalization b3;

        b3 = new Externalization("A String ", 47);
        ObjectOutputStream o = new ObjectOutputStream(new FileOutputStream(
                "/home/anurag/Desktop/output.txt"));
        o.writeObject(b3);
        o.close();

        // Now get it back:
        ObjectInputStream in = new ObjectInputStream(new FileInputStream(
                "/home/anurag/Desktop/output.txt"));
        b3 = (Externalization) in.readObject();            //At the time of reading, the class is initialized again.
        System.out.println(b3);
    }

    public String toString() {
        return s + i;
    }

    public void writeExternal(ObjectOutput out) throws IOException {
        // You must do this:
        // out.writeObject(s);
        out.writeInt(i);
    }

    public void readExternal(ObjectInput in) throws IOException,
            ClassNotFoundException {
        // You must do this:
        // s = (String) in.readObject();
        i = in.readInt();
    }
}