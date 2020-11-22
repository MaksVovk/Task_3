import java.util.ArrayList;
import java.util.regex.*;

public class Task_3{

    static char[] vowels = new char[]{
        'a', 'o', 'e', 'i', 'u', 'y',
        'A', 'O', 'E', 'I', 'U', 'Y' 
    };

    public static void main(String[] arg){

        System.out.print(seperateStr("stringyluluuf"));
        System.out.println();
    }

    public static String seperateStr(String string){

        int lengthStr = string.length();
        searchIndexVowels(string, 0);  
        
        return pasteBetweenWovels(string, searchIndexVowels(string, 0));
    }

    public static String searchIndexVowels(String string, int index){
        String out;
        if(string.length() <= index)
            return out = "";
        if(equalsChar(string, index)){
            out = (index) + " " + searchIndexVowels(string, index+1);
        }else{
            out = searchIndexVowels(string, index+1);
        }
        return out;
    }

    public static boolean equalsChar(String string, int index){
        for(char vowel: vowels){
            if(vowel == string.charAt(index)){
                return true;
            }
        }
        return false;
    }

    public static String pasteBetweenWovels(String string, String vowelsIndex){
        String[] arrayStr = new String[string.length()];
        for(int i = 0; i < string.length(); i++){
            arrayStr[i] = Character.toString(string.charAt(i));
        }
        for(String vowIndex : vowelsIndex.split(" ")){
            arrayStr[Integer.parseInt(vowIndex)] = "*" + arrayStr[Integer.parseInt(vowIndex)] + "*";
        }
        String outJoinedString = String.join("", arrayStr);
        outJoinedString = outJoinedString.replace("**", "*");
        Pattern pattern = Pattern.compile(outJoinedString);
        Matcher matcher = pattern.matcher("\\^\\*");
        if(matcher.find())
            outJoinedString = outJoinedString.substring(1);
        pattern = Pattern.compile("\\*\\$");
        matcher = pattern.matcher(outJoinedString);
        if(matcher.find())
            outJoinedString = outJoinedString.substring(0, outJoinedString.length() - 1);
        
        return outJoinedString;
    }

}