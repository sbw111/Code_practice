class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, Integer> map = new HashMap<>();
        List<List<String>> ans = new ArrayList<>();
        int index = -1;
        for (String s: strs){
            char[] ch = s.toCharArray();
            Arrays.sort(ch);
            String newS = String.valueOf(ch);
            if (map.containsKey(newS)) ans.get(map.get(newS)).add(s);
            else{
                List<String> l = new ArrayList<>();
                l.add(s);
                map.put(newS, ans.size());
                ans.add(l);
            }
        }
        return ans;
    }
}