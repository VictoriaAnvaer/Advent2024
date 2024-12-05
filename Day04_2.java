import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Day04_2 {
    public static void main(String[] args) {
        ArrayList<String> fileData = getFileData("src/input.txt");
        int count = 0;
        for(int i = 0; i < fileData.size(); i++) {
            String currentWord = fileData.get(i);
            for (int x = 0; x < currentWord.length(); x++) {
                if ((currentWord.charAt(x) == 'M' || currentWord.charAt(x) == 'S') && (i + 2 < fileData.size())) {

                    if (x < currentWord.length() - 2) {
                        String left = "";
                        for(int z = 0; z < 3; z++) {
                            left+=fileData.get(i + z).substring(x + z, x + z + 1);
                        }
                        if (xmasCheck(left)) {
                            String right = "";
                            for (int y = 0; y < 3; y++) {
                                right+=fileData.get(i + y).substring(x - y + 2, x - y + 3);
                            }
                            if (xmasCheck(right)) {
                                count++;
                            }
                        }
                    }
                }

            }
        }
        System.out.println(count);
    }
    public static boolean xmasCheck(String word) {
        return (word.equals("SAM") || word.equals("MAS"));
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
