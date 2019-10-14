import java.util.*;
public class Solution 
{
    // DO NOT MODIFY THE ARGUMENTS WITH "final" PREFIX. IT IS READ ONLY
    public int lengthOfLastWord(final String str) {
        String str1=str.trim();
        int l=str1.lastIndexOf(" ");
        return str1.length()-l-1;
    }
}
