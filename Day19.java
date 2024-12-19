import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Day19 {
    public static void main(String[] args) {
        int total = 0;
        ArrayList<String> input = getFileData("src/input.txt");
        String[] available = input.get(0).split(", ");
        ArrayList<String> combos = getFileData("src/input2.txt");
        for (int i = 0; i < combos.size(); i++) { //iterate list of combos
            String current = combos.get(i);
                for  (int y = 0; y < available.length; y++) { //iterate through available
                    if (current.length() == 0) {
                        total++;
                        y = available.length;
                    }
                    String avCur = available[y];
                    System.out.println(avCur);
                    System.out.println(current);
                    if (avCur.substring(0, 1).equals(current.substring(0, 1))) {
                        if (current.substring(0, avCur.length()).equals(avCur)) {
                            current = current.substring(avCur.length());
                            y = 0;
                        }
                    }
                }
        }
    }

    public static ArrayList<String> getFileData(String fileName) {
        ArrayList<String> fileData = new ArrayList<String>();
        try {
            File f = new File(fileName);
            Scanner s = new Scanner(f);
            while (s.hasNextLine()) {
                String line = s.nextLine();
                if (!line.equals(""))
                    fileData.add(line);
            }
            return fileData;
        }
        catch (FileNotFoundException e) {
            return fileData;
        }
    }
}
