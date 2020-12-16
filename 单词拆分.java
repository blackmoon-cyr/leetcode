//给定一个非空字符串 s 和一个包含非空单词的列表 wordDict，判定 s 是否可以被空格拆分为一个或多个在字典中出现的单词。
//
// 说明：
//
//
// 拆分时可以重复使用字典中的单词。
// 你可以假设字典中没有重复的单词。
//
//
// 示例 1：
//
// 输入: s = "leetcode", wordDict = ["leet", "code"]
//输出: true
//解释: 返回 true 因为 "leetcode" 可以被拆分成 "leet code"。
//
//
// 示例 2：
//
// 输入: s = "applepenapple", wordDict = ["apple", "pen"]
//输出: true
//解释: 返回 true 因为 "applepenapple" 可以被拆分成 "apple pen apple"。
//     注意你可以重复使用字典中的单词。
//
//
// 示例 3：
//
// 输入: s = "catsandog", wordDict = ["cats", "dog", "sand", "and", "cat"]
//输出: false
//
// Related Topics 动态规划
// 👍 784 👎 0


import java.util.HashMap;
import java.util.HashSet;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    /*
    * 这道是一道很正常的动态规划算法题，但是substring截取的是j 到 i-1的
    * 的长度，所以ans的长度得是s.length()+1
    *
    * */
    public boolean wordBreak(String s, List<String> wordDict) {
        int[] ans = new int[s.length()+1];
        HashSet<String> set = new HashSet<>(wordDict);
        ans[0] = 1;
        for (int i = 0; i < s.length()+1; i++) {
            for (int j = 0; j < i; j++) {

                if(ans[j] == 1 && set.contains(s.substring(j,i))){
                    ans[i] = 1;
                    break;
                }
            }
        }
        return ans[s.length()] == 1;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
