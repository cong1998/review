package StringTest;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringTest01 {

    public static void main(String[] args) {
        String text = "sssss14770952403fffffff0795-6594725bbbbbb150aaaa18000";
        //查找出该字符串中出现的号码并打印
        parseTelPhone(text).stream().forEach(System.out::println);
        parsePhone(text).stream().forEach(System.out::println);
    }


    public static List<String> parseTelPhone(String text){
        List<String> list = new ArrayList<>();
        Pattern pattern = Pattern.compile("[0-9]{11}");
        Matcher matcher = pattern.matcher(text);
        while(matcher.find()){
            list.add(matcher.group());
        }
        return list;
    }

    public static List<String> parsePhone(String text){
        List<String> list = new ArrayList<>();
        Pattern pattern = Pattern.compile("[0-9]{4}-[0-9]{7}");
        Matcher matcher = pattern.matcher(text);
        while(matcher.find()){
            list.add(matcher.group());
        }
        return list;
    }
}
