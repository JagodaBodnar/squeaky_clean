public class SqueakyClean {
    public static void main(String[] args) {
        String cleanedString = SqueakyClean.cleanSpaces("my   Id");
        System.out.printf("Replace any spaces encountered with underscores: %s%n", cleanedString);
        cleanedString = SqueakyClean.cleanSpaces(" myId ");
        System.out.printf("Replace any spaces encountered with underscores: %s%n", cleanedString);
        cleanedString = SqueakyClean.cleanControlChars("my\0\r\u007FId");
        System.out.printf("Replace control characters with the upper case string \"CTRL\": %s%n", cleanedString);
        cleanedString = SqueakyClean.cleanKebabCase("à-ḃç");
        System.out.printf("Convert kebab-case to camelCase: %s%n", cleanedString);
        cleanedString = SqueakyClean.cleanKebabCase("a-1C");
        System.out.printf("Convert kebab-case to camelCase: %s%n", cleanedString);
        cleanedString = SqueakyClean.cleanNotLetters("\uD83D\uDE00\uD83D\uDE00\uD83D\uDE00");
        System.out.printf("Omit characters that are not letters: %s%n", cleanedString);
        cleanedString = SqueakyClean.cleanOmitGreekLowerCaseLetters("MyΟβιεγτFinder");
        System.out.printf("Omit Greek lower case letters: %s%n", cleanedString);
        cleanedString = SqueakyClean.clean("9 -abcĐ\uD83D\uDE00ω\0");
        System.out.printf("Performed few cleaning operations: %s%n", cleanedString);
    }

    public static String cleanSpaces(String string) {
        return string.replaceAll(" ", "_");
    }

    public static String cleanControlChars(String string) {
        return string.replaceAll("\\p{Cntrl}", "CTRL");
    }

    public static String cleanKebabCase(String string) {
        StringBuilder transformString = new StringBuilder(string);
        String[] splitString = string.split("");
        for (int i = 0; i < string.length(); i++) {
            if (splitString[i].equals("-")) {
                transformString.replace(i, i + 2, splitString[i + 1].toUpperCase());
            }
        }
        return transformString.toString().replaceAll("[- || 0-9]", "");
    }

    public static String cleanNotLetters(String string) {
        return string.replaceAll("[^a-zA-Z]", "");
    }

    public static String cleanOmitGreekLowerCaseLetters(String string) {
        return string.replaceAll("[α-ω]", "");
    }

    static String clean(String identifier) {
        StringBuilder transformString = new StringBuilder(identifier);
        String[] splitString = identifier.split("");
        for (int i = 0; i < identifier.length(); i++) {
            if (splitString[i].matches("[α-ω]")) {
                int index = transformString.indexOf(splitString[i]);
                transformString.deleteCharAt(index);
            }
            if (splitString[i].equals("-")) {
                transformString.replace(i, i + 2, splitString[i + 1].toUpperCase());
            }
            if (splitString[i].equals(" ")) {
                transformString.replace(i, i + 1, "_");
            }
            if (identifier.matches("[^- ||^_]")) {
                if (splitString[i].matches("[^a-zA-Z]")) {
                    transformString.replace(i, i + 1, "");
                }
            }
        }
        return transformString.toString().replaceAll("\\p{C}", "CTRL").replaceAll("[- || 0-9]", "").replaceAll("\\p{So}+", "");
    }
}
