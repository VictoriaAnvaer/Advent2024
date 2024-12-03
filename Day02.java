import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Day02 {
    public static void main(String[] args) {
        ArrayList<String> fileData = getFileData("src/index02.txt");
        int safe = fileData.size();
        for (int i = 0; i < fileData.size(); i++) {
            String[] split = fileData.get(i).split(" ");
            for (int x = 1; x < split.length - 1; x++) {
                int digit1 = Integer.parseInt(split[x - 1]);
                int digit2 = Integer.parseInt(split[x]);
                int digit3 = Integer.parseInt(split[x + 1]);
                if (digit1 == digit2 || digit1 == digit3 || digit2 == digit3) {
                    safe--;
                    x = split.length;
                } else if (digit1 - 3 > digit2 || digit1 + 3 < digit2) {
                    safe--;
                    x = split.length;
                }
            }
        }
        System.out.println(safe);
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
