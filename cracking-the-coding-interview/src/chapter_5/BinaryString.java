package chapter_5;

public class BinaryString {
    public String toBinaryString(double num) {
        if (num <= 0 || num >= 1) {
            return "ERROR";
        }

        StringBuilder builder = new StringBuilder();
        builder.append("0.");
        int counter = 0;
        while (num > 0) {
            if (counter >= 32) {
                return "ERROR";
            }
            num = num * 2;
            if (num >= 1) {
                builder.append(1);
                num -= 1;
            } else {
                builder.append(0);
            }
            counter++;
        }
        return builder.toString();
    }

    public String toBinaryString2(double num) {
        if (num <= 0 || num >= 1) {
            return "ERROR";
        }
        StringBuilder builder = new StringBuilder();
        builder.append("0.");
        int counter = 0;
        double base = 0.5;
        while (num > 0) {
            if (counter >= 32) {
                return "ERROR";
            }

            if (num >= base) {
                builder.append(1);
                num -= base;
            } else {
                builder.append(0);
            }
            base /= 2;
            counter++;
        }

        return builder.toString();
    }
}
