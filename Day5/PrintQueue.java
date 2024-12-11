// Advent of Code
// Day 5
// Max CF @maxcf212

package Day5;
import java.util.Scanner;
import java.nio.file.Paths;
import java.util.ArrayList;
public class PrintQueue
{
    public static void main(String[] args) {
        ArrayList<Integer> leftPages = new ArrayList<Integer>(); 
        ArrayList<Integer> rightPages = new ArrayList<Integer>();
        int midTotal = 0;

        try (Scanner scanner = new Scanner(Paths.get("Day5/numbers.txt"))) {
            Boolean breakLine = false;
            while (scanner.hasNextLine()) {
                String row = scanner.nextLine();
                if (breakLine == true) {
                    //parse row into arraylist
                    String[] splits = row.split("\\,");
                    ArrayList<Integer> update = new ArrayList<Integer>();
                    for (int i = 0; i < splits.length; i++) {
                        update.add(Integer.parseInt(splits[i]));
                    }
                    
                    Boolean valid = true;
                    for (int i = 0; i < leftPages.size(); i++) {
                        //check if left page is before right page
                        int leftVal = update.indexOf(leftPages.get(i));
                        int rightVal = update.indexOf(rightPages.get(i));
                        if (leftVal != -1 && rightVal != -1) {
                            if (leftVal > rightVal) {
                                valid = false;
                                break;
                            }
                        }
                    }
                    if (valid) {
                        int midVal = update.get((update.size()/2));
                        midTotal += midVal;
                    }
                        
                
                }
                else if (!row.equals("")) { //check newline
                    String[] splits = row.split("\\|");
                    leftPages.add(Integer.parseInt(splits[0]));
                    rightPages.add(Integer.parseInt(splits[1]));
                } else {
                    breakLine = true;
                }
            }
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }

        System.out.println("Total of Mid Values: " + midTotal);
    }
}