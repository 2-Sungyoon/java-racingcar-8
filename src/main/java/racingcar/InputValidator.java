package racingcar;

import java.util.ArrayList;
import java.util.List;

final class InputValidator {
    private static final int MIN_LEN = 1;
    private static final int MAX_LEN = 5;

    private InputValidator() { }

    static List<String> parseAndValidateNames(String input) {
        if (input == null || input.isEmpty()) {
            throw new IllegalArgumentException("names required");
        }
        String[] tokens = input.split(",", -1);
        List<String> names = new ArrayList<>(tokens.length);
        for (String raw : tokens) {
            String name = raw;
            if (name.isEmpty()) {
                throw new IllegalArgumentException("empty name");
            }
            if (containsWhitespace(name)) {
                throw new IllegalArgumentException("whitespace not allowed in name");
            }
            int len = name.length();
            if (len < MIN_LEN || len > MAX_LEN) {
                throw new IllegalArgumentException("name length out of range");
            }
            names.add(name);
        }
        return names;
    }

    static int parseAndValidateAttempts(String input) {
        if (input == null || input.isEmpty()) {
            throw new IllegalArgumentException("attempts required");
        }
        if (!isAllDigits(input)) {
            throw new IllegalArgumentException("attempts must be digits");
        }
        int value = Integer.parseInt(input);
        if (value <= 0) {
            throw new IllegalArgumentException("attempts must be positive");
        }
        return value;
    }

    private static boolean isAllDigits(String s) {
        for (int i = 0; i < s.length(); i++) {
            if (!Character.isDigit(s.charAt(i))) {
                return false;
            }
        }
        return true;
    }

    private static boolean containsWhitespace(String s) {
        for (int i = 0; i < s.length(); i++) {
            if (Character.isWhitespace(s.charAt(i))) {
                return true;
            }
        }
        return false;
    }
}
