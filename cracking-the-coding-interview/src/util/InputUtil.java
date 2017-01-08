package util;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;

import chapter_2.list.CustomLinkedList;

public class InputUtil {

  private static final String INPUT = "input_files/chapter_";

  public static String[] readContents(int chapter, String fileName) throws FileNotFoundException {
    StringBuffer buffer = new StringBuffer();
    StringBuilder fileBuilder = new StringBuilder(INPUT);

    File inputFile = new File(fileBuilder.append(chapter).append("/").append(fileName).toString());
    FileReader fileReader = new FileReader(inputFile);
    Scanner scanner = new Scanner(fileReader);

    while (scanner.hasNextLine()) {
      String line = scanner.nextLine().trim();
      if (line != null && !line.isEmpty()) {
        buffer.append(line).append("\n");
      }
    }
    scanner.close();

    return buffer.toString().split("\n");
  }

  public static CustomLinkedList<String> parseLinkedList(String line) {
    String[] elements = line.split(":");
    CustomLinkedList<String> list = new CustomLinkedList<String>();

    for (String e : elements) {
      if (e != null && !e.trim().isEmpty()) {
        list.add(e.toString());
      }
    }

    return list;
  }
}
