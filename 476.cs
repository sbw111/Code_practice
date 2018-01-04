public class Solution {
    public int FindSubstringInWraproundString(string p) {
        int[] a = new int[26];
        int max=1;
        for (int i=0;i<p.Length;i++){
            if (i>0 && (p[i]-p[i-1]==1 || p[i-1]-p[i]==25)){
                max++;
            }
            else{
                max=1;
            }
            int index='z'-p[i];
            a[index]=Math.Max(a[index],max); 
        }
        int ans=0;
        for (int i=0;i<26;i++) ans+=a[i];
        return ans;
    }
}