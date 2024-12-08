// Advent of Code
// Day 2
// Max CF @maxcf212

package Day2;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Scanner;

public class RedNosedReports {
    public static void main(String[] args) {
        int safeCount = 0;  // safe immediately
        int dampSafeCount = 0; // safe after dampening
        
        try (Scanner scanner = new Scanner(Paths.get("Day2/numbers.txt"))) {
            while (scanner.hasNextLine()) {
                ArrayList<Integer> report = new ArrayList<Integer>();
                String row = scanner.nextLine();
                String[] splits = row.split(" ");
                for (int i = 0; i < splits.length; i++) {
                    report.add(Integer.parseInt(splits[i]));
                }
                
                if (checkSafe(report)) {
                    safeCount++;
                } else {
                    for (int i = 0; i < report.size(); i++) {
                        ArrayList<Integer> tempReport = new ArrayList<Integer>(report);
                        tempReport.remove(i);
                        if (checkSafe(tempReport)) {
                            dampSafeCount++;
                            break;
                        }
                    }
                }
            }
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }

        System.out.println("Safe count: " + safeCount);
        System.out.println("Safe count after dampening allowed: " + (safeCount + dampSafeCount));
    }

    public static boolean checkSafe(ArrayList<Integer> report) {
        boolean inc = true;
        boolean dec = true;
        for (int i = 0; i < report.size(); i++) {
            if (i > 0) {
                int diff = report.get(i) - report.get(i - 1);
                if (Math.abs(diff) < 1 || Math.abs(diff) > 3) {
                    return false;
                }
                if (diff > 0) {
                    dec = false;
                }
                else if (diff < 0) {
                    inc = false;
                }
                else {
                    return false;
                }

                if (!inc && !dec) {
                    return false;
                }
            }
        }
        return true;
    }
}
