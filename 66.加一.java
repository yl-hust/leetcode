import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/*
 * @lc app=leetcode.cn id=66 lang=java
 *
 * [66] 加一
 */

// @lc code=start
class Solution {
    // first version
    // public int[] plusOne(int[] digits) {
    //     List<Integer> result = new ArrayList<>();
    //     int x = digits[digits.length - 1] + 1;
    //     result.add(x % 10);
    //     int carry = x / 10;
    //     for (int i = digits.length - 2; i >= 0; i--) {
    //         int plus1 = digits[i] + carry;
    //         result.add(plus1 % 10);
    //         carry = plus1 / 10;         
    //     }
    //     if (carry == 1) {
    //         result.add(carry);
    //     }
        
    //     int[] ans = new int[result.size()];
    //     int i = ans.length - 1;
    //     for (Integer integer : result) {
    //         ans[i--] = integer.intValue();
    //     }     
    //     return ans;
    // }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("======");
        System.out.println(scanner.next());
    }
    public int[] plusOne(int[] digits) {
        if (digits == null || digits.length == 0) return digits;
        for (int i = digits.length - 1; i >= 0; i--) {
            digits[i]++;
            digits[i] = digits[i] % 10;
            if (digits[i] != 0) {//末位不是9
                return digits;           
            }
        }
        //处理[9,9,9...,9]的情况
        digits = new int[digits.length + 1];
        digits[0] = 1;
        return digits;
    }

}
// @lc code=end

