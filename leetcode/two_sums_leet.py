class Solution(object):
    def twoSum(self, nums, target):
        """
        :type nums: List[int]
        :type target: int
        :rtype: List[int]
        """
        
        # # nums = map(int,raw_input().split())
        # try:
        #     nums = map(int,raw_input().split())
        #     # nums = [int(nums) for number in input().split()]
        # except EOFError:
        #     #do nothing
        #     a=5;
           
        n = len(nums)
        for i in range(n):
            dif = target-nums[i]
            if dif in nums:
                a = nums.index(dif)
                if a != i:
                    return [i ,a]