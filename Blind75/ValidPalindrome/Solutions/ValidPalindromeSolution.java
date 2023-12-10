package Blind75.ValidPalindrome.Solutions;

public class ValidPalindromeSolution implements ISolution {
    @Override
    public boolean isPalindrome(String s) {
        String lowercaseS = s.toLowerCase();
        String withoutASpecialCharacters = lowercaseS.replaceAll("[^a-z0-9]", "");
        char[] finalChars = withoutASpecialCharacters.toCharArray();

        int size = finalChars.length;
        for(int i=0, j=size-1; i<size && j>=0; i++, j--) {
            if(finalChars[i] != finalChars[j]) {
                return false;
            }
        }

        return true;
    }
}
