public class Solution
{
	public bool IsMatch(string s, string p)
	{
		if (s == null || p == null) return false;
		bool[,] a = new bool[s.Length + 1, p.Length + 1];
		a[0, 0] = true;
		for (int i = 0; i < p.Length; i++)
		{
			if (p[i] == '*' && a[0, i]) a[0, i + 1] = true;
		}
		for (int i = 0; i < s.Length; i++)
		{
			for (int j = 0; j < p.Length; j++)
			{
				if (p[j] == '?' || s[i] == p[j]) a[i + 1, j + 1] = a[i, j];
				if (p[j] == '*')
				{
					a[i + 1, j + 1] = a[i + 1, j] || a[i, j + 1] || a[i, j];
				}
			}
		}
		return a[s.Length, p.Length];
	}
}