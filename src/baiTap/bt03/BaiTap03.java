package baiTap.bt03;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class BaiTap03 {
    public static void main(String[] args) {
        User u1 = new User(1, "U1", "P1", true);
        write(u1);
    }

    public static void write(User u) {
        File file = new File("src/baiTap/bt03/output.txt");

        try (
                FileOutputStream outputFile = new FileOutputStream(file);
                ObjectOutputStream output = new ObjectOutputStream(outputFile);
        ) {
            output.writeObject(u);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
