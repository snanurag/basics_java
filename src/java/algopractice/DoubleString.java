package algopractice;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class DoubleString {

    public static void main(String[] args) throws IOException {

        String fileName = args[0];

        FileReader fr = new FileReader(fileName);

        BufferedReader bfr = new BufferedReader(fr);

        String firstLine = bfr.readLine();

        int noOfInputs = Integer.parseInt(firstLine);

        int counter = 0;

        while (counter != noOfInputs) {
            String nextLine = bfr.readLine();
            Long input = Long.parseLong(nextLine);
            if (input % 2 == 0) {

            } else {
                System.out.println(input - 1);
            }

            counter++;
        }

    }
}
