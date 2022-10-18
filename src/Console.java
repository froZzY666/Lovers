import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Scanner;

public class Console {
    public static void main(String[] args) throws FileNotFoundException {
        File peoples = new File("NameOfPeople");
        MutualSympathy(peoples);
    }

    public static void MutualSympathy(File file) throws FileNotFoundException {
        Scanner scanner = new Scanner(file);
        PrintWriter pw = new PrintWriter("LoveCouples");
        String lineNames = scanner.nextLine();
        String[] names = lineNames.split(",");
        int counter = 1;
        for (String name : names) {
            while (counter < names.length) {
                if (!name.equals(names[counter])) {
                    if (getRandomNumber(1, 2) == 2 && getRandomNumber(1,2) == 2) {
                        Scanner scanner1 = new Scanner("LoveCouples");
                        while (scanner1.hasNext()){
                            String line = scanner1.nextLine();
                            if (!line.equals(name + " and " + names[counter] + " = ♡") && !line.equals(names[counter] + " and " + name + " = ♡")) {
                                pw.println(name + " and " + names[counter] + " = ♡");
                            }
                        }
                        scanner1.close();
                    }
                }

                counter = counter + 2;
            }
            if (Arrays.asList(names).indexOf(name)%2 == 0 || Arrays.asList(names).indexOf(name) == 0) {
                counter = 0;
            } else if (Arrays.asList(names).indexOf(name)%2 != 0) {
                counter = 1;
            }

        }
        pw.close();
        scanner.close();

    }

    public static int getRandomNumber(int min, int max) {
        return (int) Math.round(Math.random() * (max - min) + min);
    }

}

