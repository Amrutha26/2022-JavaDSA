class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        
        List<Integer> result = new ArrayList();
        
        if(s.length() == 0 || s == null) return result;
        
        int[] char_count = new int[26];
        for(char c : p.toCharArray()) {
            char_count[c - 'a']++;
        }
        
        int left = 0;
        int right = 0;
        int count = p.length();
        
        while(right < s.length()) {
            if(char_count[s.charAt(right++) - 'a']-- >= 1) count--;
            
            if(count == 0) result.add(left);
            
            // cbae -> sliding window: cba
            // sliding window: bae 
            // so left pointer should be incremented and the counter for the character c
            // should be incremented as it was decremented before
            if(right - left == p.length() && char_count[s.charAt(left++) - 'a']++ >= 0) count++;
        }
        
        return result;
    }
}
