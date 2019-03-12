package testPkg;

import java.io.File;
import java.io.IOException;

public class Take1 {

    public static void main(String[] args) throws IOException {
        System.out.println("Take1 is executed");
        String FS = File.separator;
        String[] cmd = new String[3];
        cmd[0] = "D:" + FS + "workspaces" + FS + "workspace_old" + FS + "LearnJava" + FS + "take2.bat";
        cmd[1] = ">>";
        cmd[2] = "out.txt";
        System.out.println(cmd[0]);
        Process process = Runtime.getRuntime().exec(cmd);


    }

}

