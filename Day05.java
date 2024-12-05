import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Day04 {
    public static void main(String[] args) {
        ArrayList<String> rules = getFileData("src/input.txt");
        ArrayList<String> update = getFileData("src/input2.txt");
        System.out.println(rules);
        System.out.println(update);
        int count = 0;
        for (int i = 0; i < rules.size(); i++) {
            String[] split = rules.get(i).split("|");
            for (int x = 0; x < update.size(); x++) {
                if (update.contains(split[0]) && update.contains(split[1])) {
                    if (true) {
                        count++;
                    } else {
                        update.remove(x);
                        x--;
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
                if (!line.equals("")) {
                    fileData.add(line);
                }
            }
            return fileData;
        }
        catch (FileNotFoundException e) {
            return fileData;
        }
    }
}
