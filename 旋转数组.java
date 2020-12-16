//给定一个包含 m x n 个元素的矩阵（m 行, n 列），请按照顺时针螺旋顺序，返回矩阵中的所有元素。
//
// 示例 1:
//
// 输入:
//[
// [ 1, 2, 3 ],
// [ 4, 5, 6 ],
// [ 7, 8, 9 ]
//]
//输出: [1,2,3,6,9,8,7,4,5]
//
//
// 示例 2:
//
// 输入:
//[
//  [1, 2, 3, 4],
//  [5, 6, 7, 8],
//  [9,10,11,12]
//]
//输出: [1,2,3,4,8,12,11,10,9,5,6,7]
//
// Related Topics 数组
// 👍 563 👎 0


import java.util.ArrayList;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        int u = 0;
        int d = matrix.length - 1;
        int l = 0;
        int r = matrix[0].length - 1;
        List<Integer> ans = new ArrayList<>();

        while(true){
            /*容易出错的地方
            * 边界问题：i <= r and ++u > d
            * 思路不难，边界容易出错
            * */
            for(int i = l;i <= r;i++){
                ans.add(matrix[u][i]);
            }
            if(++u > d)break;
            for(int i = u;i <= d;i++){
                ans.add(matrix[i][r]);
            }
            if(--r < l)break;
            for(int i = r; i >= l;i--){
                ans.add(matrix[d][i]);
            }
            if(--d < u)break;
            for(int i = d;i >= u;i--){
                ans.add(matrix[i][l]);
            }
            if(++l > r)break;
        }
        return ans;
    }
}