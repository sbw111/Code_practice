class Solution {
    public int scoreOfParentheses(String S) {
        int[] deep = new int[50];
        int count = -1;
        for (int i = 0; i < S.length(); i++){
            if (S.charAt(i) == '(') count++;
            else{
                if (deep[count + 1] > 0){
                    deep[count] = deep[count] + 2 * deep[count + 1];
                    deep[count + 1] = 0;
                }
                else deep[count]++;
                count--;
            }
        }
        return deep[0];
    }
}
