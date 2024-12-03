import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Day01 {
    public static void main(String[] args) {
        ArrayList<String> fileData = getFileData("src/index01.txt");
        ArrayList<String> listOne = new ArrayList<>();
        ArrayList<String> listTwo = new ArrayList<>();
        for (int i = 0; i < fileData.size(); i++) {
            String[] split = fileData.get(i).split(" {3}");
            listOne.add(split[0]);
            listTwo.add(split[1]);
        }
        Collections.sort(listOne);
        Collections.sort(listTwo);
        int sum = 0;
        for (int i = 0; i < listOne.size(); i++) {
            sum = sum + Math.abs(Integer.parseInt(listOne.get(i)) - Integer.parseInt(listTwo.get(i)));
        }

        System.out.println(sum);
        int sumOne = 0;
        int sumCurrent = 0;
        for (int i = 0; i < listOne.size(); i++) {
            int current = Integer.parseInt(listOne.get(i));
            for (int x = 0; x < listTwo.size(); x++) {
                if (Integer.parseInt(listTwo.get(x)) == current) {
                    sumCurrent++;
                }
            }
            sumOne = sumOne + (sumCurrent * current);
            sumCurrent = 0;
        }
        System.out.println(sumOne);
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