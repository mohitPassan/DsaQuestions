# Problem statement

A phrase is a **palindrome** if, after converting all uppercase letters into lowercase letters and removing all non-alphanumeric characters, it reads the same forward and backward. Alphanumeric characters include letters and numbers.

Given a string `s`, return `true` _if it is a **palindrome**, or_ `false` _otherwise_.

**Example 1:**

**Input:** s = "A man, a plan, a canal: Panama"
**Output:** true
**Explanation:** "amanaplanacanalpanama" is a palindrome.

**Example 2:**

**Input:** s = "race a car"
**Output:** false
**Explanation:** "raceacar" is not a palindrome.

**Example 3:**

**Input:** s = " "
**Output:** true
**Explanation:** s is an empty string "" after removing non-alphanumeric characters.
Since an empty string reads the same forward and backward, it is a palindrome.

**Constraints:**

- `1 <= s.length <= 2 * 105`
- `s` consists only of printable ASCII characters.


# Solution 1

1. Convert the string to lowercase.
2. Replace every non-alphanumeric digit with blank.
3. Point one reference to starting of the string and one to end of the string.
4. If they are not equal, return false.
5. If the loop reaches it's end, return true.

## Code

```java
class Solution {
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
```

# Solution 2

1. Start one reference from start and one from end `(i and j)`
2. If character at `i` is not alpha-numeric, just continue and increment `i`.
3. If character at `j` is not alpha-numeric, just continue and decrement `j`.
4. If characters at `i` and `j` are not equal return `false`.
5. Otherwise increment `i` and decrement `j`.
6. If the loop reached its end, return `true`.

## Code

```java
class Solution {
    private boolean isAlphaNumeric(char ch) {
        if((ch >= '0' && ch <= '9') || (ch >= 'a' && ch <= 'z')) {
            return true;
        }
        return false;
    }

    public boolean isPalindrome(String s) {
        char[] c = s.toCharArray();

        int i=0, j=c.length-1;
        while(i<c.length && j>=0) {
            char ic = Character.toLowerCase(c[i]);
            char jc = Character.toLowerCase(c[j]);

            if(!isAlphaNumeric(ic)) {
                i++;
                continue;
            }
            
            if(!isAlphaNumeric(jc)) {
                j--;
                continue;
            }

            if(ic != jc) {
                return false;
            }

            i++;
            j--;
        }

        return true;
    }
}
```
