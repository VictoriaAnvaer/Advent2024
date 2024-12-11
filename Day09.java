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
                sorted+=getBlock(String.valueOf(i/2), Integer.parseInt(current));
            } else {
                sorted+=getBlock(".", Integer.parseInt(current));
            }
        }
        System.out.println(sorted);

        String sortedNew = "";
        int countEnd = 0;
        for (int i = 0; i < sorted.length()/2; i++) {
            if (sorted.substring(i, i+1).equals(".")) {
                for (int x = sorted.length() - countEnd; x > 0; x--) {
                    if (!sorted.substring(x - 1, x).equals(".")) {
                        sortedNew+=sorted.substring(x-1, x);
                        x = 0;
                        countEnd++;
                    }
                }
            } else {
                sortedNew+=sorted.substring(i, i+1);
            }
            System.out.println(sortedNew);

        }
    }

    public static String getBlock(String num, int loopNum) {
        String finalVal = "";
        for (int i = 0; i < loopNum; i++) {
            finalVal+=num;
        }
        return finalVal;
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