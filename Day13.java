
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Day13 {
    public static void main(String[] args) {
        ArrayList<String> input = getFileData("src/input.txt");
        for (int i = 2; i < input.size(); i+=3) {
            String A = input.get(i - 2);
            String B = input.get(i - 1);
            String prize = input.get(i);
            int AX = Integer.parseInt(A.substring(12, 14));
            int AY = Integer.parseInt(A.substring(18));
            int BX = Integer.parseInt(B.substring(12, 14));
            int BY = Integer.parseInt(B.substring(18));
            int prizeX = Integer.parseInt(prize.substring(prize.indexOf("X") + 2, prize.indexOf(",")));
            int prizeY = Integer.parseInt(prize.substring(prize.indexOf("Y") + 2));
            System.out.println(times(AX, BX, 0, prizeX));
        }
    }

    public static ArrayList<Integer> times(int A, int B, int start, int prize) {

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
