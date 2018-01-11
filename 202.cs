public class Solution
{
	public int update(int n)
	{
		int sum = 0;
		while (n > 0)
		{
			sum = sum + (n % 10) * (n % 10);
			n = n / 10;
		}
		return sum;
	}
	public bool IsHappy(int n)
	{
		HashSet<int> a = new HashSet<int>();
		while (!a.Contains(n))
		{
			if (n == 1) return true;
			a.Add(n);
			n = update(n);
		}
		return false;
	}
}