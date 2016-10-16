import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by ChenTian on 2016/10/16.
 */
public class Calculate {
    private static Matcher isTre;

    public static void main(String[] args){
        System.out.println("==>"+cal("(+ 1 2)"));
        System.out.println("==>"+cal("(* 2 3)"));
        System.out.println("==>"+cal("(* (+ 1 2) (+ 3 4))"));
        System.out.println("==>"+cal("(* (+ 2 3) 1)"));
        System.out.println("==>"+cal("(* 1 (+ 2 3))"));
    }

    public static int cal(String s){


        if(isNumeric(s)){
            return Integer.parseInt(s);
        }else if(isTree(s)){
            String s1,s2,s3;
            s1 = isTre.group(1).trim();
            s2 = isTre.group(2).trim();
            s3 = isTre.group(3).trim();

            int v1 = cal(s2);
            int v2 = cal(s3);

            switch (s1){
                case "*":
                    return v1*v2;
                case "+":
                    return v1+v2;
                case "-":
                    return v1-v2;
                case "/":
                    return v1/v2;
            }
        }

        return 0;
    }

    //判断是否为一棵二叉树,然后拆分
    public static boolean isTree(String s){
        Pattern pattern = Pattern.compile("\\((\\*|-|/|\\+)(.*)(\\s\\([\\*|-|/|\\+]\\s[0-9]+\\s[0-9]+\\)|\\s[0-9]+)\\)");
        isTre = pattern.matcher(s);

        if( !isTre.matches() ){
            return false;
        }

        return true;
    }

    //判断字符串是否为数字
    public static boolean isNumeric(String str){
        Pattern pattern = Pattern.compile("[0-9]*");
        Matcher isNum = pattern.matcher(str);
        if( !isNum.matches() ){
            return false;
        }
        return true;
    }



}
