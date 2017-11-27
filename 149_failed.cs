using System;
using System.Collections;
using System.Collections.Generic;

//Hash Dict seems not work, because double can not tell difference about 0.000000001 when it used as the KEY

public class Point
{
	public int x;
	public int y;
	public Point() { x = 0; y = 0; }
	public Point(int a, int b) { x = a; y = b; }
}

public class Solution
{
	public int MaxPoints(Point[] points)
	{
		int n = points.Length;
		if (n < 2) return n;
		int ans = 0;
		for (int i = 0; i < n; i++)
		{
			int p = 0;
			int dup = 0;
			int ver = 1;
			var a = new Dictionary<string, int>();
			for (int j = i + 1; j < n; j++)
			{
				if (points[i].x == points[j].x)
				{
					if (points[i].y == points[j].y) dup++;
					else ver++;
				}
				else
				{
					double slop = (points[i].y - points[j].y) * 1.0 / (points[i].x - points[j].x);
					string s = slop.ToString();
					if (a.ContainsKey(s)) a[s]++;
					else a.Add(s, 2);
					p = Math.Max(a[s], p);
				}
			}
			p = Math.Max(p + dup, ver + dup);
			ans = Math.Max(p, ans);
		}
		return ans;
	}
}