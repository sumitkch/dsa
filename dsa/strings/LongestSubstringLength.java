package dsa.strings;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class LongestSubstringLength {
    //Solution1
    // Complexity O(n^3)
    public static void longestSubstringLengthCount(String s){

        int len = s.length();
        int res = 0;
        int i = 0;
        Map<Character, Integer> lastPos=new HashMap<>();
        for(int j=0;j<len;j++){
            if(lastPos.containsKey(s.charAt(j))){
                i=Math.max(i, lastPos.get(s.charAt(j)+1));
            }
            res=Math.max(res, j-i+1);
            lastPos.put(s.charAt(j), j);
        }
        System.out.println("LongestSubstirngcount : "+res);
    }

    //Solution2
    //Complexity O(n)
    public static void longestSubstringLengthCount2ndSolution(String s){

        int n=s.length();
        int res=0;
        int left=0, right=0;
        boolean visited[]=new boolean[256];
        while(right<n){
            if(visited[s.charAt(right)]){
                while (visited[s.charAt(right)]){
                    visited[s.charAt(left)]=false;
                    left++;
                }
            }
            visited[s.charAt(right)]=true;
            res=Math.max(res, (right-left+1));
            right++;
        }
        System.out.println("LongestSubstirngcount : "+res);
    }

    //Solution3
    //Complexity O(n), Space Complexity O(1)
    public static void longestSubstringLengthCount3rdSolution(String s){

        int n=s.length();
        int res=0;
        int lastIndex[]=new int[256];
        Arrays.fill(lastIndex, -1);
        int i=0;
        for (int j=0;j<n;j++){
            i=Math.max(i, lastIndex[s.charAt(j)]+1);
            res=Math.max(res, (j-i+1));
            lastIndex[s.charAt(j)]=j;
        }
        System.out.println("LongestSubstirngcount : "+res);
    }
}
