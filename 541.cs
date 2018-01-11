public class Solution {  
    public string ReverseStr(string s, int k) {
        int n = s.Length - 1;
        char[] str = s.ToCharArray();
        int i = 0;
        char tmp;
        while (i < n){
            int j = Math.Min(i + k - 1, n);
            int next = j + k + 1;
            while (i < j){
                tmp = str[i]; str[i] = str[j]; str[j] = tmp;
                i++; j--;
            }
            i = next;
        }
        return new string(str);
    }
}