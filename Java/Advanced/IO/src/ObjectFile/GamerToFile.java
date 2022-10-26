package ObjectFile;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class GamerToFile {

    public static void main(String[] args) {

        Gamer gamer = new Gamer("arpat",100,"AK47");


        FileOutputStream fileOutputStream = null;
        try {
            fileOutputStream = new FileOutputStream("IO\\src\\ObjectFile\\Gamer2.txt");
            ObjectOutputStream os = new ObjectOutputStream(fileOutputStream);

            os.writeObject(gamer);

            os.close();

        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
