// Advent of Code
// Day 4
// Max CF @maxcf212

package Day4;
import java.util.Scanner;
import java.nio.file.Paths;
import java.util.ArrayList;

public class CeresSearch
{
    public static void main(String[] args) {
        ArrayList<ArrayList<Character>> grid = new ArrayList<ArrayList<Character>>(); // 2d arraylist
        
        // read letters file into 2d array
        try (Scanner scanner = new Scanner(Paths.get("Day4/letters.txt"))) {
            while (scanner.hasNextLine()) {
                String row = scanner.nextLine();
                char[] cArray = row.toCharArray();
                
                ArrayList<Character> alRow = new ArrayList<Character>();
                for (int i = 0; i < cArray.length; i++) {
                    alRow.add(cArray[i]);
                }
                grid.add(alRow);
            }
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
        
        int cols = grid.get(0).size();
        int rows = grid.size();

        int count = 0; // count of xmas

        // this is gross but works
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (grid.get(i).get(j) == 'X') {
                    //s
                    if ((i <= rows - 4) && grid.get(i+1).get(j) == 'M' && grid.get(i+2).get(j) == 'A' && grid.get(i+3).get(j) == 'S') {
                        count += 1;
                    }
                    //SE
                    if ((i <= rows - 4) && (j <= cols - 4) && grid.get(i+1).get(j+1) == 'M' && grid.get(i+2).get(j+2) == 'A' && grid.get(i+3).get(j+3) == 'S') {
                        count += 1;
                    }
                    //E
                    if ((j <= cols - 4) && grid.get(i).get(j+1) == 'M' && grid.get(i).get(j+2) == 'A' && grid.get(i).get(j+3) == 'S') {
                        count += 1;
                    }
                    //NE
                    if ((j <= cols - 4) && (i - 3 >= 0) && grid.get(i-1).get(j+1) == 'M' && grid.get(i-2).get(j+2) == 'A' && grid.get(i-3).get(j+3) == 'S') {
                        count += 1;
                    }
                    //N
                    if ((i - 3 >= 0) && grid.get(i-1).get(j) == 'M' && grid.get(i-2).get(j) == 'A' && grid.get(i-3).get(j) == 'S') {
                        count += 1;
                    }
                    //NW
                    if ((i - 3 >= 0) && (j - 3 >= 0) && grid.get(i-1).get(j-1) == 'M' && grid.get(i-2).get(j-2) == 'A' && grid.get(i-3).get(j-3) == 'S') {
                        count += 1;
                    }
                    //W
                    if ((j - 3 >= 0) && grid.get(i).get(j-1) == 'M' && grid.get(i).get(j-2) == 'A' && grid.get(i).get(j-3) == 'S') {
                        count += 1;
                    }
                    //SW
                    if ((j - 3 >= 0) && (i <= rows - 4) && grid.get(i+1).get(j-1) == 'M' && grid.get(i+2).get(j-2) == 'A' && grid.get(i+3).get(j-3) == 'S') {
                        count += 1;
                    }
                } 
            }
        }
        System.out.println("Count: " + count);
    }
}
