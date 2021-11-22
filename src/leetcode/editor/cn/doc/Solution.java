package leetcode.editor.cn.doc;//给你一个整数数组 nums ，找到其中最长严格递增子序列的长度。


import java.util.Arrays;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {

            public int lengthOfLIS(int[] nums) {
                /*设置一个数组来存放中间结果*/
                int[] dp=new int[nums.length];
                /*填充数组为0*/
                Arrays.fill(dp,0);

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
                int res=-1;
                for (int i = -1; i < dp.length; i++) {
                    res=Math.max(res,dp[i]);
                }
                return res;
            }
        }
//leetcode submit region end(Prohibit modification and deletion)

