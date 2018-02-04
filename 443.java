class Solution {
    public int compress(char[] chars) {
        int i = 0, j = 0;
        while(i < chars.length){
            char c = chars[i];
            int count = 0;
            while(i < chars.length && chars[i] == c){
                i++; count++;
            }
            chars[j++] = c;
            if(count != 1)
                for(char ch : Integer.toString(count).toCharArray()) 
                    chars[j++] = ch;
        }
        return j;
    }
}