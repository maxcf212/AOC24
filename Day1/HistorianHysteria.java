// Advent of Code
// Day 1
// Max CF @maxcf212

package Day1;
import java.util.Scanner;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Collections;
import java.lang.Math;

public class HistorianHysteria
{
    public static void main(String[] args) {
        ArrayList<Integer> left = new ArrayList<Integer>(); 
        ArrayList<Integer> right = new ArrayList<Integer>();
        
        // read numbers file
        try (Scanner scanner = new Scanner(Paths.get("Day1/numbers.txt"))) {
            while (scanner.hasNextLine()) {
                String row = scanner.nextLine();
                String[] splits = row.split("[\\s\\xA0]+");
                left.add(Integer.parseInt(splits[0]));
                right.add(Integer.parseInt(splits[1]));
            }
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
        
        Collections.sort(left); //sort both lists
        Collections.sort(right);
        
        int totalDist = 0;
        int totalSim = 0;

        //compute distances and similarities in one go
        for (int i = 0; i < left.size(); i++) {
            totalDist += Math.abs(left.get(i) - right.get(i));
            int subtotalSim = 0;
            for (int j = 0; j < right.size(); j++) {
                if (left.get(i).equals(right.get(j))) {
                    subtotalSim += 1;
                }
            }
            totalSim += subtotalSim * left.get(i);
        }
        
         System.out.println("total distance: " + totalDist);
         System.out.println("similarity score: " + totalSim);
    }
}
