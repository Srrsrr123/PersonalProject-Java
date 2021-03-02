package wordcount;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Statistic {
	Statistic(){
		
	}
	//统计字符串，只需要统计Ascii码，汉字不需考虑空格，水平制表符，换行符，均算字符
    public int charNum(String text) {
    	int num = 0;
    	char [] list = text.toCharArray();
    	for (int i = 0; i < list.length; i++) {
            if (list[i] >= 0 && list[i] <= 127) {
                num++;
            }
            else continue;
        }
    	return num;
    }
    //统计单词数
    public int wordNum(String text) {
    	int num = 0;
    	String[] words = text.split("\\W+");
    	for (int i = 0; i <words.length; i++) {
    		String str = words[i].toLowerCase();
    		Pattern pattern = Pattern.compile("[a-zA-Z]{4}([a-zA-Z0-9])*");
    		Matcher matcher = pattern.matcher(str);
    		if(matcher.find()) {
    			 num++;
    		}
    	}
    	return num;
    }
    //统计行数
    public int lineNum() {
    	return 0;
    }
}
