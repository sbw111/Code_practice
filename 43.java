class Solution {
    public int[] helper(String num){
        char[] ch = num.toCharArray();
        int n = ch.length;
        int[] a = new int[n];
        for (int i = 0; i < n; i++){
            a[n - 1 - i] = ch[i] - '0';
        }
        return a;
    }
    
    public String multiply(String num1, String num2) {
        int[] n1 = helper(num1);
        int[] n2 = helper(num2);
        int[] ans = new int[n1.length + n2.length + 2];
        for (int i = 0; i < n1.length; i++)
            for (int j = 0; j < n2.length; j++){
                int mul = n1[i] * n2[j];
                ans[i + j] += mul % 10;
                ans[i + j + 1] += mul / 10;
            }
        for (int i = 0; i < n1.length + n2.length + 1; i++){
            ans[i + 1] += ans[i] / 10;
            ans[i] = ans[i] % 10;
        }
        int len = n1.length + n2.length + 1;
        while (ans[len] == 0 && len > 0) len--;
        String a = "";
        for (int i = 0; i <= len; i++) a = ans[i] + a;
        return a;
    }
}
