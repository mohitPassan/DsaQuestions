package Blind75.ValidAnagram.Solutions;

import java.util.Arrays;

public class SortingSolution implements ISolution {

    @Override
    public boolean isAnagram(String s, String t) {
        if(s.length() != t.length()) {
            return false;
        }

        char[] sA = s.toCharArray();
        char[] tA = t.toCharArray();

        Arrays.sort(sA);
        Arrays.sort(tA);

        s = new String(sA);
        t = new String(tA);

        return s.equals(t);
    }

}
