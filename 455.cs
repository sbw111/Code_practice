public class Solution
{
	public int FindContentChildren(int[] g, int[] s)
	{
		Array.Sort(g);
		Array.Sort(s);
		int j = 0;
		int n = s.Length;
		int ans = 0;
		for (int i = 0; i < g.Length; i++)
		{
			if (j >= n) break;
			while (s[j] < g[i] && j < n - 1) j++;
			if (s[j] >= g[i])
			{
				ans++; j++;
			}
		}
		return ans;
	}
}