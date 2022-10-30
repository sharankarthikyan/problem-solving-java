package strings;

// Importing required functions
import java.util.*;

class StringSegmentation {
    public static boolean canSegmentString(String inputString, Set<String> dictionary) {
        for (int i = 1; i < inputString.length(); i++) {
            String first = inputString.substring(0, i);

            if (dictionary.contains(first)) {
                String second = inputString.substring(i);

                if (dictionary.contains(second))
                    return true;

                if (canSegmentString(second, dictionary))
                    return true;
            }
        }
        return false;
    }

    // private boolean wordBreakRecur(String s, Set < String > wordDict, int start)
    // {
    // if (start == s.length()) {
    // return true;
    // }
    // for (int end = start + 1; end <= s.length(); end++) {
    // if (wordDict.contains(s.substring(start, end)) && wordBreakRecur(s, wordDict,
    // end)) {
    // return true;
    // }
    // }
    // return false;
    // }

    // Dynamic Programming
    // public boolean wordBreak(String s, List < String > wordDict) {
    // Set < String > wordDictSet = new HashSet < > (wordDict);
    // boolean[] dp = new boolean[s.length() + 1];
    // dp[0] = true;
    // for (int i = 1; i <= s.length(); i++) {
    // for (int j = 0; j < i; j++) {
    // if (dp[j] && wordDictSet.contains(s.substring(j, i))) {
    // dp[i] = true;
    // break;
    // }
    // }
    // }
    // return dp[s.length()];
    // }

    public static void main(String[] args) {
        String[] inputStr = { "catsanddog", "nowok", "applepie", "applejuice" };
        String[][] wordsDictionary = { { "cats", "dog", "sand", "and", "cat" }, { "hello", "hell", "on", "now" },
                { "apple", "pear", "pier", "pie" }, { "apple", "pear", "pier", "pie" } };
        for (int i = 0; i < inputStr.length; i++) {
            Set<String> dict = new HashSet<String>(Arrays.asList(wordsDictionary[i]));

            // Custom function to print a set of strings
            System.out.println("   Input string: \"" + inputStr[i] + "\"");
            if (canSegmentString(inputStr[i], dict))
                System.out.println("   Result: String can be segmented");
            else
                System.out.println("   Result: String can not be segmented");
            System.out.println(
                    "---------------------------------------------------------------------------------------------------\n");
        }

    }
}
