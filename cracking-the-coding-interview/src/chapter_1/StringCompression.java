/**
 *
 */
package chapter_1;

/**
 * Question 1.6: Implement a method to perform basic string compression using
 * the counts of repeated characters. For example, the string aabcccccaaa would
 * become a2b1c5a3. If the "compressed" string would not become smaller than the
 * original string, your method should return the original string. You can
 * assume the string has only uppercase and lowercase letters (a-z).
 *
 * @author Sudharsanan Muralidharan
 */
public class StringCompression {

    /**
     * Compresses the input string and returns the shorter of the two strings
     * <p>
     * Complexity: O(n), Additional Space: O(1)
     *
     * @param input
     * @return compressedString
     */
    public String compressString(String input) {
        StringBuilder builder = new StringBuilder();
        int i = 0, counter = 1;

        for (i = 0; i < input.length() - 1; i++) {
            if (input.charAt(i) == input.charAt(i + 1)) {
                counter++;
            } else {
                builder.append(input.charAt(i)).append(counter);
                counter = 1;
            }
        }

        // append the counter value for the last sequence of characters
        builder.append(input.charAt(i)).append(counter);

        // return the shorter of the compressed and original string
        return (builder.length() < input.length()) ? builder.toString() : input;
    }

}
