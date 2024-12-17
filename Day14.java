import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Day14 {
    public static void main(String[] args) {
        int width = 11; //101
        int length = 7; //103
        String[][] arr = new String[width][length];
        ArrayList<String> positions = getFileData("src/input.txt");
        System.out.println(positions);
        int[][] pos = new int[3][2];
        pos[0][0] = 0;
        pos[0][1] = 4;
        pos[1][0] = 6;
        pos[1][1] = 3;
        pos[2][0] = 6;
        pos[2][1] = 3;
        int[][] movement = new int[3][2];
        movement[0][0] = 3;
        movement[0][1] = -3;
        movement[1][0] = -1;
        movement[1][1] = 2;
        movement[2][0] = -1;
        movement[2][1] = 2;
        for (int x = 0; x < pos.length; x++) {
            int xPos = pos[x][0];
            int yPos = pos[x][1];
            if (arr[xPos][yPos] != null) {
                int amount = Integer.parseInt((arr[xPos][yPos]));
                arr[xPos][yPos] = String.valueOf(amount + 1);
            } else {
                arr[xPos][yPos] = "1";
            }
        }
        for (int i = 0; i < arr.length; i++) {
            for (int x=0; x < arr[0].length; x++) {
                if (arr[i][x] == null) {
                    System.out.print(".");
                } else {
                    System.out.print(arr[i][x]);
                }
            }
            System.out.println();
        }


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
