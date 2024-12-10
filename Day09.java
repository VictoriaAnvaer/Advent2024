import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Day09 {
    public static void main(String[] args) {
        String input = getFileData("src/input.txt");
        String sorted = "";
        for (int i = 0; i < input.length(); i++) {
            String current = input.substring(i, i + 1);
            if (i % 2 == 0) {
                sorted+=input.substring(i, i + 1);
            }
        }
        System.out.println(sorted);
    }
    public static String getFileData(String fileName) {
        ArrayList<String> fileData = new ArrayList<String>();
        try {
            File f = new File(fileName);
            Scanner s = new Scanner(f);
            while (s.hasNextLine()) {
                String line = s.nextLine();
                if (!line.equals("")) {
                    fileData.add(line);
                }
            }
            return fileData.get(0);
        }
        catch (FileNotFoundException e) {
            return fileData.get(0);
        }
    }
}
