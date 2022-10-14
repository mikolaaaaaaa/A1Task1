package org.mikola;

public class Main {

    private static final int[] powers = {24, 16, 8, 0};
    private static final String IP_REGEX =
            "^((25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)\\.){3}(25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)$";

    public static int ipToInt(String ip) {
        if (!ip.matches(IP_REGEX)) {
            System.out.println("Please, enter the correct ip");
            return -1;
        }
        int result = 0;
        int i = 0;
        for (String s : ip.split("\\.")) {
            result += Integer.parseInt(s) << powers[i];
            i++;
        }
        return result;
    }

    public static String intToIp(int number) {
        StringBuilder result = new StringBuilder();
        int i = 0;
        if (number < 0) {
            result.append("255.");
            number -= (number >> powers[i]) * (2 << (powers[i] - 1));
            i++;
        }
        while (i < 4) {
            int oct = number >> powers[i];
            result.append(oct);
            number -= oct * (2 << (powers[i] - 1));
            result.append('.');
            i++;
        }
        result.delete(result.length() - 1, result.length());
        return result.toString();

    }


    public static void main(String[] args) {
    }
}