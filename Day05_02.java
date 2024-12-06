import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Day05_02 {
    public static void main(String[] args) {
        ArrayList<String> rules = getFileData("src/input.txt");
        ArrayList<String> update = getFileData("src/input2.txt");
        ArrayList<String> incorrect = new ArrayList<>();
        for (int i = 0; i < rules.size(); i++) {
            String[] splitRules = rules.get(i).split("\\|");
            String numOne = splitRules[0];
            String numTwo = splitRules[1];
            for (int x = 0; x < update.size(); x++) {
                String current = update.get(x);
                if (current.contains(numOne) && current.contains(numTwo)) {
                    if (current.indexOf(numOne) > current.indexOf(numTwo)) {
                        incorrect.add(update.get(x));
                        update.remove(x);
                        x--;
                    }
                }
            }
        }
        System.out.println(incorrect);
        int count = 0;
        for (int x = 0; x < incorrect.size(); x++) {
            String[] split = incorrect.get(x).split(",");
            int middle = (split.length/2);
            count+=Integer.parseInt(split[middle]);
        }
        System.out.println(count);
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