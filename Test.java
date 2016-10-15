import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by ChenTian on 2016/10/15.
 */
public class Test {
    public static void main(String[] args){
        System.out.println(isTree("((2 3) 2)"));
        System.out.println(isTree("(1 (2 3))"));
        System.out.println(isTree("((1 2) (3 4))"));
        System.out.println(isTree("(1 2)"));
        //isTree("(1 (2 3))");
        //testString("(1 2)");
        //int i = "((1 2) (2 3))".length();
        //System.out.println(i);
    }

    public static boolean isTree(String s){
        Pattern pattern = Pattern.compile("\\((.*)(\\s\\([0-9]+\\s[0-9]+\\)|\\s[0-9]+)\\)");//5

        Matcher isTre = pattern.matcher(s);

        if( !isTre.matches() ){
            return false;
        }
        for(int i=1;i<=2;i++){
            System.out.println(isTre.group(i).trim());
        }
        return true;
    }

    public static void testString(String s){
        System.out.println(s.substring(1,2));
        System.out.println(s.substring(3,4));
    }

    public static boolean isNumeric(String str){
        Pattern pattern = Pattern.compile("[0-9]*");
        Matcher isNum = pattern.matcher(str);
        if( !isNum.matches() ){
            return false;
        }
        return true;
    }


}
