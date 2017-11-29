public class Solution
{
	public IList<string> FindRepeatedDnaSequences(string s)
	{
		HashSet<string> a = new HashSet<string>();
		IList<string> ans = new List<string>();
		for (int i = 0; i < s.Length - 9; i++)
		{
			string st = s.Substring(i, 10);
			if (a.Contains(st))
			{
				if (!ans.Contains(st)) ans.Add(st);
			}
			else a.Add(st);
		}
		return ans;
	}
}