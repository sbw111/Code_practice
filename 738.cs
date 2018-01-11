public class Solution
{
	public int MonotoneIncreasingDigits(int N)
	{
		char[] s = N.ToString().ToCharArray();
		int index = s.Length;
		for (int i = s.Length - 1; i > 0; i--)
		{
			if (s[i] < s[i - 1])
			{
				index = i;
				s[i - 1] = (char)((int)s[i - 1] - 1);
			}
		}
		for (int i = index; i < s.Length; i++) s[i] = '9';
		return Convert.ToInt32(new string(s));
	}
}