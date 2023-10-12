package baiTap.bt02;

import java.io.*;
import java.util.Arrays;

public class BaiTap02 {
    public static void main(String[] args) {
        try {
            writeInputToOutput();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void writeInputToOutput() throws IOException {
        File inputFile = new File("src/baiTap/bt02/input.txt");
        File outputFile = new File("src/baiTap/bt02/otuput.txt");

        if(outputFile.exists()) {
            System.out.println("Đã tồn tại file output!");
            return;
        }

        if(!inputFile.exists()) {
            System.err.println("Không tồn tại file input!");
            return;
        }

        FileInputStream input = new FileInputStream(inputFile);
        FileOutputStream output = new FileOutputStream(outputFile);
        int c;

        while((c = input.read()) != -1) {
            output.write(c);
        }

        System.out.println(outputFile.length());
    }
}
