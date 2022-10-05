package Algorithm;
import java.util.Scanner;
public class FormatText {
    public static String getNextLine(String text) {
        Scanner scan = new Scanner(text);
        String newText = "";
        while (scan.hasNextLine()) {
            newText = newText.concat(scan.nextLine() + "\n");
        }
        return newText;
    }
}
