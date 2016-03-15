package chapter_2;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;

/**
 * Question 2.6: Implement a function to check if a linked list is a palindrome.
 * 
 * @author Sudharsanan Muralidharan
 *
 */
public class Palindrome {
  public static void main(String[] args) throws FileNotFoundException {
    Palindrome palindrome = new Palindrome();
    FileReader fileReader = new FileReader(new File("input_files/chapter_2/palindome"));
    Scanner scanner = new Scanner(fileReader);
  }
}
