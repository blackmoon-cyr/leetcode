//给定两个以字符串形式表示的非负整数 num1 和 num2，返回 num1 和 num2 的乘积，它们的乘积也表示为字符串形式。
//
// 示例 1:
//
// 输入: num1 = "2", num2 = "3"
//输出: "6"
//
// 示例 2:
//
// 输入: num1 = "123", num2 = "456"
//输出: "56088"
//
// 说明：
//
//
// num1 和 num2 的长度小于110。
// num1 和 num2 只包含数字 0-9。
// num1 和 num2 均不以零开头，除非是数字 0 本身。
// 不能使用任何标准库的大数类型（比如 BigInteger）或直接将输入转换为整数来处理。
//
// Related Topics 数学 字符串
// 👍 531 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    /*
    * 这道题需要注意以下几点
    * 1、字符串比较时候需要用equals 函数
    * 2、建模很重要
    *           1 2 3       index i
    *             4 5       index j
    * ------------------
    *             1 5
    *           1 0 .
    *         0 5   .
    * -----------------
    *           1 2 .
    *         0 8   .      indices[i+j,i+j+1]
    *       0 4     .
    * ----------------
    *     [ 0 1 2 3 4 ]
    *
    * 3、ans[i+j+1] = sum % 10;
    *    ans[i+j] += sum / 10;
    *
    *
    * */
    public String multiply(String num1, String num2) {
        if(num1.equals("0") || num2.equals("0"))return "0";
        int[] ans = new int[num1.length() + num2.length()];
        for (int i = num1.length()-1; i >= 0; i--) {
            int x = num1.charAt(i) - '0';
            for (int j = num2.length()-1; j >= 0; j--) {
                int y = num2.charAt(j) - '0';
                int sum = ans[i+j+1] + x * y;
                ans[i+j+1] = sum % 10;
                ans[i+j] += sum / 10;
            }
        }
        StringBuilder res = new StringBuilder();
        for (int i = 0; i < ans.length; i++) {
            if(i ==0 && ans[i] == 0)continue;
            res.append(ans[i]);
        }
        return res.toString();
    }
}
//leetcode submit region end(Prohibit modification and deletion)
