package random;

public class SecondSmallest {
    public int fetchSecondSmallest(int[] arr) {
        if (arr.length < 2) {
            return -1;
        }

        int smallest, smallest2;

        smallest = Math.min(arr[0], arr[1]);
        smallest2 = Math.max(arr[0], arr[1]);

        for (int i = 2; i < arr.length; i++) {
            if (arr[i] < smallest) {
                smallest2 = smallest;
                smallest = arr[i];
            } else if (arr[i] < smallest2) {
                smallest2 = arr[i];
            }
        }

        return smallest2;
    }
}
