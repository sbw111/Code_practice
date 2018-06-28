class Solution {
    public boolean buddyStrings(String A, String B) {
        if (A.length() < 2 || B.length() < 2 || A.length() != B.length()) return false;
        boolean diff = false;
        boolean two = false;
        int[] a = new int[26];
        char vala = '1';
        char valb = '1';
        for (int i = 0; i < A.length(); i++){
            if (A.charAt(i) != B.charAt(i)){
                if (!diff){
                    vala = A.charAt(i);
                    valb = B.charAt(i);
                    diff = true;
                }
                else{
                    if (vala == B.charAt(i) && valb == A.charAt(i)) return true;
                    else return false;
                }
                
            }
            else{
                a[A.charAt(i) - 'a']++;
                if (a[A.charAt(i) - 'a'] == 2) two = true;
            }
            
        }
        return two;
    }
}
