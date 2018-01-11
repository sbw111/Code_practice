public class Solution
{
	public int CalculateMinimumHP(int[,] dungeon)
	{
		int n = dungeon.GetLength(0);
		int m = dungeon.GetLength(1);
		int[,] maxhealth = new int[n + 1, m + 1];
		for (int i = 0; i < n; i++) maxhealth[i, m] = int.MaxValue;
		for (int j = 0; j < m; j++) maxhealth[n, j] = int.MaxValue;
		maxhealth[n, m - 1] = maxhealth[n - 1, m] = 1;
		for (int i = n - 1; i >= 0; i--)
			for (int j = m - 1; j >= 0; j--)
			{
				int p = Math.Min(maxhealth[i + 1, j], maxhealth[i, j + 1]) - dungeon[i, j];
				maxhealth[i, j] = p <= 0 ? 1 : p;
			}
		return maxhealth[0, 0];
	}
}