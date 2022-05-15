import java.util.Arrays;

/*
 * @lc app=leetcode.cn id=204 lang=java
 *
 * [204] 计数质数
 */

// @lc code=start
class Solution {
    public int countPrimes(int n) {
        // 埃氏筛，排除法
        // 所有素数的倍数都是合数
        boolean[] isPrime = new boolean[n];
        Arrays.fill(isPrime, true);
        int ans = 0;
        for (int i = 2; i * i < n; i++) {
            if (isPrime[i]) {
                for (int j = i * i; j < n; j += i) {
                    isPrime[j] = false;
                }
            }
        }
        for (int i = 2; i < n; i++) {
            if (isPrime[i]) {
                ans++;
            }            
        }
        return ans;
    }
    // // 暴力解法，超时！！！！n=5000000
    // public int countPrimes(int n) {
    //     int count = 0;
    //     for (int i = 2; i < n; i++) {
    //         if (isPrime(i)) {
    //             count++;
    //         }
    //     }
    //     return count;
    // }

    // private boolean isPrime(int n) {
    //     for (int i = 2; i * i <= n; i++) {
    //         if (n % i == 0) {
    //             return false;
    //         }            
    //     }
    //     return true;
    // }
}
// @lc code=end

