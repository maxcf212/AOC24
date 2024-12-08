// Advent of Code
// Day 2
// Max CF @maxcf212

package Day2;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Scanner;

public class RedNosedReports {
    public static void main(String[] args) {
        int safeCount = 0;
        
        try (Scanner scanner = new Scanner(Paths.get("Day2/numbers.txt"))) {
            while (scanner.hasNextLine()) {
                ArrayList<Integer> report = new ArrayList<Integer>();
                String row = scanner.nextLine();
                String[] splits = row.split(" ");
                for (int i = 0; i < splits.length; i++) {
                    report.add(Integer.parseInt(splits[i]));
                }

                boolean inc = true;
                boolean dec = true;
                for (int i = 0; i < report.size(); i++) {
                    if (i > 0) {

                        int diff = report.get(i) - report.get(i - 1);
                        if (Math.abs(diff) < 1 || Math.abs(diff) > 3) {
                            inc = false;
                            dec = false;
                            break;
                        }
                        
                        if (diff > 0) {
                            dec = false;
                        }
                        else if (diff < 0) {
                            inc = false;
                        }
                        else {
                            break;
                        }

                        if (!inc && !dec) {
                            break;
                        }
                    }
                }
                if (inc || dec) {
                    safeCount++;
                }
            }
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }

        System.out.println("Safe count: " + safeCount);
    }
}
