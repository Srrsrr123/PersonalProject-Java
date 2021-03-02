package wordcount;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Statistic {
	Statistic(){
		
	}
	//ͳ���ַ�����ֻ��Ҫͳ��Ascii�룬���ֲ��迼�ǿո�ˮƽ�Ʊ�������з��������ַ�
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
    //ͳ�Ƶ�����
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
    //ͳ������
    public int lineNum() {
    	return 0;
    }
}
