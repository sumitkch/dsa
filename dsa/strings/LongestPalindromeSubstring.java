package dsa.strings;

public class LongestPalindromeSubstring {

    public static void longestPalindromeSubstring(String s){

        int start=0, end=0;
        for(int i=0;i<s.length();i++){
            int len1=expandAround(s, i, i);
            int len2=expandAround(s, i, i+1);
            int len = Math.max(len1, len2);
            if(len > end - start){
                start = i - (len-1)/2;
                end = i + len/2;
            }
        }
        System.out.println("Longest palindrome is "+s.substring(start, end-start+2 > s.length() ? end-start+1 : end-start+2));
    }

    private static int expandAround(String s,int left, int right){
        int L=left, R=right;
        while(L>=0 && R<s.length() && s.charAt(L)==s.charAt(R)){
            L--;
            R++;
        }
        return R-L-1;
    }


    public static void main(String[] args) {
        String s="babcbad";
        longestPalindromeSubstring(s);
    }
}
