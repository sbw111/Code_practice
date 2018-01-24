class Solution
{
	public int NextGreaterElement(int n)
	{
		string s = Convert.ToString(n);
		int len = s.Length;
		int i, j;
		int[] nums = new int[len];
		for (i = 0; i < len; i++) nums[i] = s[i] - '0';
		for (j = len - 1; j > 0; j--)
			if (nums[j] > nums[j - 1]) break;
		if (j == 0) return -1;
		j--;
		for (i = j + 1; i < len; i++) if (nums[i] <= nums[j]) break;
		i--;
		int tmp = nums[i]; nums[i] = nums[j]; nums[j] = tmp;
		Array.Reverse(nums, j + 1, len - j - 1);
		long ans = 0;
		for (i = 0; i < len; i++) ans = ans * 10 + nums[i];
		if (ans > int.MaxValue) return -1;
		else return (int)ans;
	}
}