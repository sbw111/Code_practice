public class Solution
{
	public string AddBinary(string a, string b)
	{
		int i = a.Length - 1;
		int j = b.Length - 1;
		string ans = "";
		int sum = 0;
		while (i >= 0 || j >= 0 || sum > 0)
		{
			if (i >= 0)
			{
				sum = sum + a[i] - '0';
				i--;
			}
			if (j >= 0)
			{
				sum = sum + b[j] - '0';
				j--;
			}
			ans = ans + sum % 2;
			sum = sum / 2;
		}
		char[] array = ans.ToCharArray();
		Array.Reverse(array);
		return new String(array);
	}
}