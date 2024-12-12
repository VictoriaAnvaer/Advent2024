import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Day09_Array {
    public static void main(String[] args) {
        String input = getFileData("src/input.txt");
        ArrayList<String> sorted = new ArrayList<>();
        int count = 0;
        for (int i = 0; i < input.length(); i++) {
            String current = input.substring(i, i + 1);
            if (i % 2 == 0) {
                sorted =getBlock(String.valueOf(count), Integer.parseInt(current), sorted);
                count++;
            } else {
                sorted = getBlock(".", Integer.parseInt(current), sorted);
            }
        }
        System.out.println("finished");
        ArrayList<String> newSorted = new ArrayList<>();


        for (int i = 1; i < sorted.size(); i++) {
            if (sorted.get(i).equals(".")) {
                for (int x = sorted.size(); x > i; x--) {
                    if (!sorted.get(x - 1).equals(".")) {
                        //sorted = sorted.substring(0, i) + sorted.substring(x-1, x) + sorted.substring(i + 1, x-1) + "." + sorted.substring(x);
                        x = 0;
                    }
                }
            }
        }
        System.out.println("finished");

        count = 0;
        for (int i = 0; i < sorted.size(); i++) {
            if (sorted.get(i).equals(".")) {
                break;
            }
            count+=(i * Integer.parseInt(sorted.get(i)));
        }
        System.out.println("finished");
        System.out.println(count);
    }

    public static ArrayList<String> getBlock(String num, int loopNum, ArrayList<String> sorted) {
        for (int i = 0; i < loopNum; i++) {
            sorted.add(num);
        }
        return sorted;
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

