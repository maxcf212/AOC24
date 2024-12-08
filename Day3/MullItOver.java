// Advent of Code
// Day 3
// Max CF @maxcf212

package Day3;
import java.nio.file.Paths;
import java.util.Scanner;
import java.util.regex.Pattern;
import java.util.regex.Matcher;

public class MullItOver {
    public static void main(String[] args) {
        int mulTotal = 0;
        String regex = "mul\\(\\d{1,3},\\d{1,3}\\)"; 
        Pattern pattern = Pattern.compile(regex); 
  
        try (Scanner scanner = new Scanner(Paths.get("Day3/corrupted.txt"))) {
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                Matcher matcher = pattern.matcher(line);
                while (matcher.find()) { 
                    String[] splits = matcher.group().split("[mul(),\\s)]"); // easy separation, integers go into index 4 and 5
                    mulTotal += Integer.parseInt(splits[4]) * Integer.parseInt(splits[5]);
                } 
            }
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }

        System.out.println("Total: " + mulTotal);
    }
}
