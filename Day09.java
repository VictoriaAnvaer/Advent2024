import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Day09 {
    public static void main(String[] args) {
        String input = getFileData("src/input.txt");
        String sorted = "";
        int count = 0;
        for (int i = 0; i < input.length(); i++) {
            String current = input.substring(i, i + 1);
            if (i % 2 == 0) {
                sorted+=getBlock(String.valueOf(count), Integer.parseInt(current));
                count++;
            } else {
                sorted+=getBlock(".", Integer.parseInt(current));
            }
        }
        System.out.println("finished");


        for (int i = 1; i < sorted.length(); i++) {
            if (sorted.substring(i, i+1).equals(".")) {
                for (int x = sorted.length(); x > i; x--) {
                    if (!sorted.substring(x - 1, x).equals(".")) {
                        sorted = sorted.substring(0, i) + sorted.substring(x-1, x) + sorted.substring(i + 1, x-1) + "." + sorted.substring(x);
                        x = 0;
                    }
                }
            }
        }
        System.out.println("finished");

        count = 0;
        for (int i = 0; i < sorted.length(); i++) {
            if (sorted.substring(i, i+1).equals(".")) {
                break;
            }
            count+=(i * Integer.parseInt(sorted.substring(i, i+1)));
        }
        System.out.println("finished");
        System.out.println(count);
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
