public class Solution
{
	public int FindMinDifference(IList<string> timePoints)
	{
		int[] time = new int[timePoints.Count];
		for (int i = 0; i < timePoints.Count; i++)
		{
			time[i] = Convert.ToInt32(timePoints[i].Substring(0, 2)) * 60 + Convert.ToInt32(timePoints[i].Substring(3, 2));
		}
		Array.Sort(time);
		int ans = 20000;
		for (int i = 1; i < time.Length; i++) ans = Math.Min(ans, time[i] - time[i - 1]);
		ans = Math.Min(ans, -time[time.Length - 1] + time[0] + 1440);
		return ans;
	}
}