public class Solution
{
	Dictionary<int, int> map = new Dictionary<int, int>();

	public int find(string s, int index)
	{
		if (index == s.Length) return 1;
		int answer = 0;
		if (s[index] == '0') return 0;
		if (!map.ContainsKey(index + 1)) map.Add(index + 1, find(s, index + 1));
		answer = answer + map[index + 1];
		if (s[index] == '1' && index < s.Length - 1)
		{
			if (!map.ContainsKey(index + 2)) map.Add(index + 2, find(s, index + 2));
			answer = answer + map[index + 2];
		}
		else if (s[index] == '2' && index < s.Length - 1 && (s[index + 1] >= '0' && s[index + 1] <= '6'))
		{
			if (!map.ContainsKey(index + 2)) map.Add(index + 2, find(s, index + 2));
			answer = answer + map[index + 2];
		}
		return answer;
	}

	public int NumDecodings(string s)
	{
		if (s == "") return 0;
		else return find(s, 0);
	}
}