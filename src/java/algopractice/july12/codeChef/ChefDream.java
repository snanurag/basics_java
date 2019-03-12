package algopractice.july12.codeChef;

import java.io.IOException;
import java.io.InputStream;
import java.util.LinkedList;

public class ChefDream {

    private static int counter = 0;

    private static InputStream inputStream;

    private static byte[] b = new byte[8192];

    private static StringBuffer buff = new StringBuffer();

    public static void main(String[] args) throws IOException {

        inputStream = System.in;

        long time = System.currentTimeMillis();

        int totalAssistants = 0;
        boolean haveBeenInside = false;

        int n = 0;
        int k = 0;

        String tempString = readLine();
        String[] dishArray = tempString.split(" ");

        n = Integer.valueOf(dishArray[0]);
        k = Integer.valueOf(dishArray[1].trim());

        tempString = readLine();
        dishArray = tempString.split(" ");

        LinkedList list = new LinkedList();

        for (int i = 0; i < n; i++) {
            if (i >= k) {
                list.removeFirst();

            }
            if (list.contains(dishArray[i].trim())) {
                list.add(dishArray[i].trim());
                continue;
            } else {
                totalAssistants++;
                list.add(dishArray[i].trim());
            }
        }
        System.out.println(totalAssistants);

    }

    private static String readLine() throws IOException {

        String str = null;

        if (counter == 8192 || counter == 0) {
            b = new byte[8192];
            inputStream.read(b);
        }

        while (true) {

            if (counter != 8192) {
                char c = (char) b[counter];
                counter++;
                if (c != '\n' && c != 0) {
                    buff.append(c);
                } else {

                    str = buff.toString();
                    buff = new StringBuffer();
                    return str;
                }
            } else {
                b = new byte[8192];
                inputStream.read(b);
                counter = 0;
            }
        }
    }
}
