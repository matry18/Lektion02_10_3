package lektion02_10_3;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 *
 * @author Mathias
 */
public class Lektion02_10_3 {

    public static void main(String[] args) {
        System.out.println("Enter file name: ");
        Scanner keyboard = new Scanner(System.in);
        String fileName = keyboard.next();
        Scanner inputStream = null;
        System.out.println("The file " + fileName + "\ncontains the following lines:\n");
        try {
            inputStream = new Scanner(new File(fileName));
        } catch (FileNotFoundException e) {
            System.out.println("Error opening the file " + fileName);
            System.exit(0);
        }
        while (inputStream.hasNextLine()) {
            String line = inputStream.nextLine();
            System.out.println(line);
            File fileObject = new File(fileName);
            boolean fileOK = false;
            while (!fileOK) {
                if (!fileObject.exists()) {
                    System.out.println("No such file");
                } else if (!fileObject.canRead()) {
                    System.out.println("That file is not readable.");
                } else {
                    fileOK = true;
                }
                if (!fileOK) {
                    System.out.println("Enter file name again:");
                    fileName = keyboard.next();
                    fileObject = new File(fileName);
                }
            }
        }
        inputStream.close();
    }
}
