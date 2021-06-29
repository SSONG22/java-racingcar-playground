package practice;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StringAddCalculator {
    private final static int INITIAL_NUM = 0;

    public static List<Integer> changeIntoNum(String text) {
        if (text.isEmpty() || text == null) return new ArrayList<>();
        return Stream.of(text.split(""))
                .filter(string -> !string.equals(",") && !string.equals(":"))
                .map(Integer::parseInt)
                .collect(Collectors.toList());
    }

    public static int sumList(List<Integer> asList) {
        return asList.stream()
                .reduce(INITIAL_NUM, (a, b) -> a + b);
    }

    public static int addValue(String text) {
        if (text.isEmpty() || text == null) return INITIAL_NUM;
        return Stream.of(text.split(""))
                .filter(string -> !string.equals(",") && !string.equals(":"))
                .map(Integer::parseInt)
                .reduce(INITIAL_NUM, (a, b) -> a + b);
    }

    public static int splitAndSum(String text) {
        if (text == null || text.isEmpty()) return INITIAL_NUM;
        int sum = INITIAL_NUM;
        Matcher m = Pattern.compile("//(.)\n(.*)").matcher(text);
        String[] tokens = text.split(" |,|:");
        if (m.find()) {
            String customDelimiter = m.group(1);
            tokens = m.group(2).split(customDelimiter);
        }
        for (String number : tokens) {
            if (Integer.parseInt(number) < 0) throw new RuntimeException();
            sum += Integer.parseInt(number);
        }
        return sum;
    }
}
