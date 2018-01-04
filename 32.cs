using System;
using System.Collections;
using System.Collections.Generic;

public class Solution
{
	public int LongestValidParentheses(string s)
	{
		SortedList a = new SortedList();
		for (int i = 0; i < s.Length - 1; i++)
		{
			if (s[i] == '(' && s[i + 1] == ')') a.Add(i, i + 1);
		}
		bool combine = true;
		while (combine)
		{
			combine = false;
			int i = 0;
			//expand
			while (i < a.Count)
			{
				int left = (int)a.GetKey(i);
				int right = (int)a[left];
				bool expand = false;
				while (left > 0 && right < s.Length - 1 && s[left - 1] == '(' && s[right + 1] == ')')
				{
					left--; right++; expand = true;
				}
				if (expand)
				{
					a.RemoveAt(i);
					a.Add(left, right);
				}
				i++;
			}
			i = 0;
			//combine
			while (i < a.Count)
			{
				int left = (int)a.GetKey(i);
				int right = (int)a[left];
				while (i < a.Count - 1 && right + 1 == (int)a.GetKey(i + 1))
				{
					a[left] = a[a.GetKey(i + 1)];
					a.RemoveAt(i + 1);
					combine = true;
				}
				i++;
			}
		}
		int max = 0;
		for (int i = 0; i < a.Count; i++)
		{
			int left = (int)a.GetKey(i);
			int right = (int)a[left];
			max = Math.Max(max, right - left + 1);
		}
		return max;
	}
}