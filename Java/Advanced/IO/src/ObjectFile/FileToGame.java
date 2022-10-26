package ObjectFile;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;

public class FileToGame {

    public static void main(String[] args) {

        try {
            FileInputStream fileInputStream = new FileInputStream("IO\\src\\ObjectFile\\Gamer.ser");
            ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
            Object one = objectInputStream.readObject();
            Gamer gamer = (Gamer)one;
            System.out.println(gamer.getName() + gamer.getWeapon());

        } catch (IOException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }



    }
}
