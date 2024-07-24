package dsa;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class BitGO {
    public static String StringChallenge(String str) {
        // code goes here
        if(str.length()<=7 || str.length()>31)
            return "false";
        if("password".equals(str))
            return "false";
        boolean res=false;
        String regex="^(?=.*[A-Z])(?=.*\\d)(?=.*[-+_!@#$%^&*.,?]).+$";
        /*Pattern p = Pattern.compile(regex);
        Matcher m=p.matcher(str);
        res=m.matches();*/
        res=str.matches(regex);
        return String.valueOf(res);
    }
    public static void main(String[] args) {
        String s="password123!!!";
        System.out.println(StringChallenge(s));
    }
}
