package datastructures.util;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class InputUtil {
    public static String[] readContents(String filePath) {
        FileReader fileReader = null;
        List<String> inputList = null;
        try {
            fileReader = new FileReader(new File(filePath));
            Scanner scanner = new Scanner(fileReader);
            inputList = new ArrayList<String>();

            while (scanner.hasNextLine()) {
                String line = scanner.nextLine().trim();
                if (line != null && !line.isEmpty()) {
                    inputList.add(line);
                }
            }
            scanner.close();
            return (String[]) inputList.toArray(new String[inputList.size()]);
        } catch (FileNotFoundException e) {
            System.out.println("File Not Found " + e.getMessage());
        }

        return null;
    }
}
