public class Solution
{
	public int RepeatedStringMatch(string A, string B)
	{
		string s = "";
		int ans = 0;
		foreach (char str in B)
		{
			if (A.IndexOf(str) < 0) return -1;
		}
		while (!s.Contains(B))
		{
			if (s.Length >= B.Length * 5) return -1;
			s = s + A; ans++;
		}
		return ans;
	}
}