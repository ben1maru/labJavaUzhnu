import java.io.FileNotFoundException;
import java.util.Scanner;

public class CheckChampion {
    public static int gamer = 0, comp = 0;
    public CheckChampion() throws FileNotFoundException {
        Scanner scanner = new Scanner(Main.file);
            while (scanner.hasNextLine()) {
                if (scanner.nextLine().equals("1")) {
                    gamer++;
                }
                else {
                    comp++;
                }
            }
        }
    }