package Blind75.ValidAnagram.Solutions;

public class FrequencyOfCharacters implements ISolution {
    @Override
    public boolean isAnagram(String s, String t) {
        if(s.length() != t.length()) {
            return false;
        }

        if(s.length() != t.length()) {
            return false;
        }

        char[] sA = s.toCharArray();
        char[] tA = t.toCharArray();

        int[] count = new int[26];

        for(char c : sA) {
            count[c - 'a']++;
        }

        for(char c : tA) {
            count[c - 'a']--;
        }

        for(int i : count) {
            if(i != 0) {
                return false;
            }
        }

        return true;
    }
}
