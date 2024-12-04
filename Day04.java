import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Day04 {
    public static void main(String[] args) {
        ArrayList<String> fileData = getFileData("src/input.txt");
        int count = 0;
        for(int i = 0; i < fileData.size(); i++) {
            String currentWord = fileData.get(i);
            for (int x = 0; x < currentWord.length(); x++) {
                if (x + 3 < currentWord.length()) {
                    if (xmasCheck(currentWord.substring(x, x + 4))) {
                        count++;
                    }
                }
                if ((currentWord.charAt(x) == 'X' || currentWord.charAt(x) == 'S') && (i + 3 < fileData.size())) {
                    String verticalWord = "";
                    for(int y = 0; y < 4; y++) {
                        verticalWord+=fileData.get(i + y).substring(x, x+1);
                    }
                    if (xmasCheck(verticalWord)) {
                        count++;
                    }
                    if (x < 4) {
                        String left = "";
                        for(int z = 0; z < 4; z++) {
                            left+=fileData.get(i + z).substring(x + z, x + z + 1);
                        }
                        if (xmasCheck(left)) {
                            count++;
                        }

                    } else {
                        String right = "";
                        for(int z = 0; z < 4; z++) {
                            right+=fileData.get(i + z).substring(x - z, x - z + 1);
                        }
                        System.out.println(right);
                        if (xmasCheck(right)) {
                            count++;
                            System.out.println(right);
                        }

                    }
                }

            }
        }
        System.out.println(count);
    }
    public static boolean xmasCheck(String word) {
        return (word.contains("XMAS") || word.contains("SAMX"));
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
