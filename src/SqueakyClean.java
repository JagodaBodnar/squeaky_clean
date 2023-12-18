public class SqueakyClean {
    public static void main(String[] args) {
        String cleanedString = SqueakyClean.cleanSpaces("my   Id");
        System.out.printf("Encountered spaces has been replaced with underscores: %s%n",cleanedString);
        cleanedString = SqueakyClean.cleanControlChars("my\0Id");
        System.out.printf("Encountered spaces has been replaced with underscores: %s%n",cleanedString);
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

}
