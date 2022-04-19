import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
 * @lc app=leetcode.cn id=17 lang=java
 *
 * [17] 电话号码的字母组合
 */

// @lc code=start
class Solution {    
    
    HashMap<Character, String[]> mappings = new HashMap<>();
    public Solution() {
        mappings.put('2', new String[]{"a","b","c"});
        mappings.put('3', new String[]{"d","e","f"});
        mappings.put('4', new String[]{"g","h","i"});
        mappings.put('5', new String[]{"j","k","l"});
        mappings.put('6', new String[]{"m","n","o"});
        mappings.put('7', new String[]{"p","q","r","s"});
        mappings.put('8', new String[]{"t","u","v"});
        mappings.put('9', new String[]{"w","x","y","z"});
    }
    
    
    public List<String> letterCombinations(String digits) {        
        List<String> res = new ArrayList<>();
        if (digits.length() == 0) {
            return res;
        }
        backtrack(res, digits, 0, new StringBuilder());
        return res;
    }

    private void backtrack(List<String> result, String digits, int index, StringBuilder sb) {
        if (index == digits.length()) {
            result.add(sb.toString());
        } else {
            char digit = digits.charAt(index);
            String[] letters = mappings.get(digit);
            for (String letter : letters) {
                sb.append(letter);
                backtrack(result, digits, index + 1, sb);
                sb.deleteCharAt(index);
            }
        }
    }
    
}
// @lc code=end

