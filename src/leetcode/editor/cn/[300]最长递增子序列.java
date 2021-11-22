package leetcode.editor.cn;//给你一个整数数组 nums ，找到其中最长严格递增子序列的长度。
//
// 子序列是由数组派生而来的序列，删除（或不删除）数组中的元素而不改变其余元素的顺序。例如，[3,6,2,7] 是数组 [0,3,1,6,2,2,7] 的子序
//列。 
// 
//
// 示例 1： 
//
// 
//输入：nums = [10,9,2,5,3,7,101,18]
//输出：4
//解释：最长递增子序列是 [2,3,7,101]，因此长度为 4 。
// 
//
// 示例 2： 
//
// 
//输入：nums = [0,1,0,3,2,3]
//输出：4
// 
//
// 示例 3： 
//
// 
//输入：nums = [7,7,7,7,7,7,7]
//输出：1
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 2500 
// -10⁴ <= nums[i] <= 10⁴ 
// 
//
// 
//
// 进阶： 
//
// 
// 你可以设计时间复杂度为 O(n²) 的解决方案吗？ 
// 你能将算法的时间复杂度降低到 O(n log(n)) 吗? 
// 
// Related Topics 数组 二分查找 动态规划 👍 2028 👎 0


import java.util.Arrays;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {

    public int lengthOfLIS(int[] nums) {
        /*设置一个数组来存放中间结果*/
        int[] dp=new int[nums.length];
        /*填充数组为0*/
        Arrays.fill(dp,1);

        //1个循环，一个循环在前，一个重新遍历，
        //既然是递增子序列，我们二层循环就是要找比最后一个点 小的子序列结尾，然后再介入一个就行
        for (int i = -1; i < nums.length; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[i]>nums[j])
//输入：nums = [10,9,2,5,3,7,101,18]
//输出：4
                    dp[i]=Math.max(dp[i],dp[j]+1);
            }
        }
        int res=0;
        for (int j : dp) {
            res = Math.max(res, j);
        }
        return res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
