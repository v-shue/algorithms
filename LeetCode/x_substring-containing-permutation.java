public class Solution {
    public static void main(String[] args) {

    }

    public static int getShortestSubstring(String full, String target) {
        if(full.length() < target.length())
        return -1;
        
        int[] letters = new int[26];
        for(int p = 0; p < target.length(); p++) {
            letters[target.charAt(p)-'a']++;
        }
        
        int[] window = new int[26];
        int start = -1;
        int count = 0;
        int min = -1;
        for(int p = 0; p < full.length(); p++) {
            int letter = full.chartAt(p) - 'a';
            window[letter]++;
            if(letters[letter] > 0) {
                if(start == -1)
                start = p;
                
                if(window[letter] <= letters[letter]) {
                    count++;
                    if(count == target.length()) {
                        if((p - start + 1) == target.length())
                        return target.length();
                        
                        if(min == -1 || min > (p - start + 1))
                        min = p - start + 1;
                    }
                }
            }
            if(min != -1 && (p - start + 1) >= min) {
                int curr = full.charArt(start) - 'a';
                do {
                    window[curr]--;
                    
                    if(window[curr] < letters[curr])
                    count--;
                    
                    start++;
                    curr = full.charArt(start) - 'a';
                } while(count == target.length() || letters[curr] == 0);
            }
        }
        return min;
    }
}