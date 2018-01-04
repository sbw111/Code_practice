using System;
using System.Collections;
using System.Collections.Generic;

public class Solution
{
	public string substring(string s, int i)
	{
		if (s.Length <= i) return "";
		else return s.Substring(i);
	}
	public bool IsMatch(string s, string p)
	{
		if (p.Length == 0) return s.Length == 0;
		if (p.Length > 1 && p[1] == '*')
		{
			return IsMatch(s, substring(p, 2)) || (s.Length > 0 && ((s[0] == p[0]) || (p[0] == '.')) && IsMatch(substring(s, 1), p));
		}
		else return (s.Length > 0) && ((s[0] == p[0]) || (p[0] == '.')) && IsMatch(substring(s, 1), substring(p, 1));
	}
}