package dsa.strings;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class LongestSubstring {

    public static void longestSubstring(String s){
        String maxStr="";
        String curr="";
        for(char ch: s.toCharArray()){
            if(curr.contains(String.valueOf(ch))){
                if(maxStr.length()<curr.length()){
                    maxStr=curr;
                }
                curr=curr.substring(curr.indexOf(ch)+1)+ch;
            }else{
                curr+=ch;

            }
        }
        if(maxStr.length()< curr.length())
            maxStr=curr;
        System.out.println("LongestString : "+maxStr);
    }




    public static void main(String[] args) {
        String s="ABCDEFGABEF";
        longestSubstring(s);
    }
}
