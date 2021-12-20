package LeetCode;


import javax.print.DocFlavor;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

// Keyboard Row
// https://leetcode.com/problems/keyboard-row/
public class Leet500 {

    public String[] findWords(String[] words) {

        // qweryt <- words
        String[] hierachy = { "qwertyuiop", "asdfghjkl", "zxcvbnm" };
        List<String> result = new ArrayList<>();

        for (int i = 0; i < words.length; i++) {
            boolean isMatch = false;
            for (int j = 0; j < hierachy.length; j++) {
                for (int k = 0; k < words[i].length(); k++) {
                    if (!hierachy[j].contains(String.valueOf(words[i].charAt(k)).toLowerCase())) {
                        isMatch = false;
                        break;
                    } else {
                        isMatch = true;
                    }
                }
                if (isMatch) result.add(words[i]);
            }
        }

        return result.toArray(new String[0]);
    }


}
