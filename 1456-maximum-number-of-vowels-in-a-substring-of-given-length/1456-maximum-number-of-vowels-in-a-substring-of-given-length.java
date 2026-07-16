class Solution {
    public int maxVowels(String s, int k) {
        int freq = 0;
        for (int i = 0; i < k; i++) {
            char ch = s.charAt(i);
            if (ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u')
                freq++;
        }
        int maxfreq = freq;
        int i = 0, j = k;
        while (j < s.length()) {
            char ch = s.charAt(i++);
            if (ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u')
                freq--;
            char c = s.charAt(j++);
            if (c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u')
                freq++;
            maxfreq = Math.max(freq, maxfreq);
        }
        return maxfreq;
    }
}