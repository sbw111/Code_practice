public class Solution {
	public IList<Interval> EmployeeFreeTime(IList<IList<Interval>> schedule)
	{
		IList<Interval> ans = new List<Interval>();
		List<Interval> l = new List<Interval>();
		if (schedule == null) return ans;
		foreach (IList<Interval> emp in schedule)
			foreach (Interval k in emp)
				l.Add(k);
		l.Sort((x, y) => { return x.start.CompareTo(y.start); });
		int end = l[0].end;
		foreach (Interval time in l)
		{
			if (time.start > end) ans.Add(new Interval(end, time.start));
			end = Math.Max(end, time.end);
		}
		return ans;
	}
}