import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Day05_02 {
    public static void main(String[] args) {
        ArrayList<String> rules = getFileData("src/input.txt");
        ArrayList<String> update = getFileData("src/input2.txt");
        int count = 0;

        for (int i = 0; i < update.size(); i++) {
            boolean incorrect = false;
            String[] currentList = update.get(i).split(",");
            ArrayList<String> rulesRight = new ArrayList<>();
            for (int x = 0; x < rules.size(); x++) {
                String[] splitRules = rules.get(x).split("\\|");
                String numOne = splitRules[0];
                String numTwo = splitRules[1];
                if (update.get(i).contains(numOne) && update.get(i).contains(numTwo)) {
                    rulesRight.add(numTwo);
                    if (update.get(i).indexOf(numOne) > update.get(i).indexOf(numTwo)) {
                        incorrect = true;
                    }
                }
            }
            if (incorrect) {
                int middleIndex = currentList.length/2;
                for (int y = 0; y < rulesRight.size(); y++) {
                    if (Collections.frequency(rulesRight, rulesRight.get(y)) == middleIndex) {
                        count+=Integer.parseInt(rulesRight.get(y));
                        y = rulesRight.size();
                    }
                }
            }
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
