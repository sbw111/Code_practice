class Solution {
    Map<String, List<Integer>> map = new HashMap<String, List<Integer>>();

    public List<Integer> diffWaysToCompute(String input) {
        List<Integer> ans = new ArrayList<>();
        for (int i = 0; i < input.length(); i++) {
            char ch = input.charAt(i);
            if (ch == '-' || ch == '+' || ch == '*') {
                String st1 = input.substring(0, i);
                String st2 = input.substring(i + 1);
                List<Integer> l1 = map.getOrDefault(st1, diffWaysToCompute(st1));
                List<Integer> l2 = map.getOrDefault(st2, diffWaysToCompute(st2));
                for (Integer num1 : l1)
                    for (Integer num2 : l2) {
                        int p = 0;
                        if (ch == '+') p = num1 + num2;
                        else if (ch == '*') p = num1 * num2;
                        else if (ch == '-') p = num1 - num2;
                        ans.add(p);
                    }
            }
        }
        if (ans.size() == 0) ans.add(Integer.valueOf(input));
        map.put(input, ans);
        return ans;
    }
}