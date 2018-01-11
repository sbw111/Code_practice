public class Solution
{
	public int CountPrimes(int n)
	{
		bool[] a = new bool[n + 1];
		int ans = 0;
		for (int i = 2; i <= n; i++)
		{
			if (a[i] == false)
			{
				ans++;
				for (int j = 2; i * j <= n; j++)
				{
					a[i * j] = true;
				}
			}
		}
		return ans;
	}
}