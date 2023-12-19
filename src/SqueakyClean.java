public class SqueakyClean {
    public static void main(String[] args) {
        String cleanedString = SqueakyClean.cleanSpaces("my   Id");
        System.out.printf("Replace any spaces encountered with underscores: %s%n",cleanedString);
        cleanedString = SqueakyClean.cleanControlChars("my\0Id");
        System.out.printf("Replace control characters with the upper case string \"CTRL\": %s%n",cleanedString);
        cleanedString = SqueakyClean.cleanKebabCase("à-ḃç");
        System.out.printf("Convert kebab-case to camelCase: %s%n",cleanedString);
        cleanedString = SqueakyClean.cleanNotLetters("a1😀2😀3😀b");
        System.out.printf("Omit characters that are not letters: %s%n",cleanedString);
        cleanedString = SqueakyClean.cleanOmitGreekLowerCaseLetters("MyΟβιεγτFinder");
        System.out.printf("Omit Greek lower case letters: %s%n",cleanedString);
    }
    public static String cleanSpaces(String string){
        StringBuilder transformString = new StringBuilder(string);
        String[] splitString = string.split("");
        for(int i = 0; i < string.length(); i++){
            if(splitString[i].equals(" ")){
                transformString.replace(i, i+1,"_");
            }
        }
        return transformString.toString();
    }

    public static String cleanControlChars(String string){
        return string.replaceAll("\0", "CTRL");
    }

    public static String cleanKebabCase(String string){
        StringBuilder transformString = new StringBuilder(string);
        String[] splitString =  string.split("");
        for(int i=0; i < string.length(); i++ ){
            if(splitString[i].equals("-")){
                transformString.replace(i, i+2, splitString[i+1].toUpperCase());
            }
        }
        return transformString.toString();
    }

    public static String cleanNotLetters(String string){
        StringBuilder transformString = new StringBuilder();
        String[] splitString =  string.split("");
        for(int i=0; i < string.length(); i++ ){
            if(splitString[i].matches("[a-z, A-Z]")){
                transformString.append(splitString[i]);
            }
        }
        return transformString.toString();
    }

    public static String cleanOmitGreekLowerCaseLetters(String string){
        StringBuilder transformString = new StringBuilder(string);
        String[] splitString =  string.split("");
        for(int i=0; i < string.length(); i++){
            if(splitString[i].matches("[α-ω]")){
               int index = transformString.indexOf(splitString[i]);
                transformString.deleteCharAt(index);
            }
        }
        return transformString.toString();
    }

}
