//给定一个数组 candidates 和一个目标数 target ，找出 candidates 中所有可以使数字和为 target 的组合。
//
// candidates 中的每个数字在每个组合中只能使用一次。
//
// 说明：
//
//
// 所有数字（包括目标数）都是正整数。
// 解集不能包含重复的组合。
//
//
// 示例 1:
//
// 输入: candidates = [10,1,2,7,6,1,5], target = 8,
//所求解集为:
//[
//  [1, 7],
//  [1, 2, 5],
//  [2, 6],
//  [1, 1, 6]
//]
//
//
// 示例 2:
//
// 输入: candidates = [2,5,2,1,2], target = 5,
//所求解集为:
//[
//  [1,2,2],
//  [5]
//]
// Related Topics 数组 回溯算法
// 👍 455 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    /*
    * 组合总和与全排列应该属于同一类型的题目，就区别而言组合是C排列是A
    * 组合对顺序没有要求而排列对顺序有要求。但就我个人来看，这两类题型
    * 并没有找到解释得通的逻辑，这能记住 组合 用index 排列用 visited
    *
    * */
    List<List<Integer>> lists = new ArrayList<>();
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);

        dfs(candidates,target,0,new ArrayDeque<>());
        return lists;

    }

    private void dfs(int[] candidates, int target, int start, Deque<Integer> deque){
        if(target==0){
            lists.add(new ArrayList<>(deque));
            return;
        }
        if(target<0)return;

        for (int i = start; i < candidates.length; i++) {
            if(i>start && candidates[i]==candidates[i-1])continue;//#$%
            deque.addLast(candidates[i]);
            dfs(candidates,target-candidates[i],i+1,deque);
            deque.removeLast();

        }
    }
}

//leetcode submit region end(Prohibit modification and deletion)
