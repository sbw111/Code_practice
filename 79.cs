public class Solution {
	public bool find(char[,] board, int i, int j, int index, bool[,] map, string word)
	{
		if (index == word.Length) return true;
		bool flag = false;
		//up
		if (i > 0 && board[i - 1, j] == word[index] && map[i - 1, j] == false)
		{
			map[i, j] = true;
			flag = find(board, i - 1, j, index + 1, map, word);
			if (flag) return true;
			map[i, j] = false;
		}
		//right
		if (j < board.GetLength(1)-1 && board[i, j + 1] == word[index] && map[i, j + 1] == false)
		{
			map[i, j] = true;
			flag = find(board, i, j + 1, index + 1, map, word);
			if (flag) return true;
			map[i, j] = false;
		}
		//down
		if (i < board.GetLength(0)-1 && board[i + 1, j] == word[index] && map[i + 1, j] == false)
		{
			map[i, j] = true;
			flag = find(board, i + 1, j, index + 1, map, word);
			if (flag) return true;
			map[i, j] = false;
		}
		//left
		if (j > 0 && board[i, j - 1] == word[index] && map[i, j - 1] == false)
		{
			map[i, j] = true;
			flag = find(board, i, j - 1, index + 1, map, word);
			if (flag) return true;
			map[i, j] = false;
		}

		return flag;
	}
	public bool Exist(char[,] board, string word)
	{
		bool flag = false;
		bool[,] map = new bool[board.GetLength(0), board.GetLength(1)];
		for (int i = 0; i < board.GetLength(0); i++)
			for (int j = 0; j < board.GetLength(1); j++)
			{
				if (word[0] == board[i, j])
				{
					map[i, j] = true;
					flag = find(board, i, j, 1, map, word);
					map[i, j] = false;
				}
				if (flag) return true;
			}
		return flag;
	}
}