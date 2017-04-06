package random;

/**
 * Question: http://www.geeksforgeeks.org/check-frequency-digit-less-digit/
 * 
 * @author Sudharsanan Muralidharan
 */
public class IsDigitFrequencyLessThanDigit {

  public boolean isFrequencyLessThanDigit(int n) {
    if (n == 0) {
      return false;
    }

    int digit = 0;
    int[] arr = new int[10];
    while (n > 0) {
      digit = (n % 10);
      n /= 10;
      arr[digit]++;
      if (arr[digit] > digit) {
        return false;
      }
    }

    return true;
  }
}
