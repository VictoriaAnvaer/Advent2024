import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Day09 {
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

        ArrayList<String> newList = new ArrayList<>();
        for (int i = sorted.size(); i > 0; i--) {
            if (!sorted.get(i).equals(".")) {
                int y = 0;
                while (sorted.get(i - y).equals(sorted.get(i))) {
                    y++;
                }
                for (int x = 1; x < i; i++) {
                    if (sorted.get(i).equals(".")) {
                        int z = 0;
                        while (sorted.get(x + z).equals(sorted.get(x))) {
                            z++;
                        }
                        if (y <= z) {
                            for (int a = 0; a < x; a++) {

                            }
                        }
                    }
                }
            }
        }
        System.out.println("finished");


        long sum = 0;
        for (int i = 0; i < sorted.size(); i++) {
            if (sorted.get(i).equals(".")) {
                break;
            }
            System.out.println(sum);
            sum+=(i * Integer.parseInt(sorted.get(i)));
        }
        System.out.println("finished");
        System.out.println(sum);
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

