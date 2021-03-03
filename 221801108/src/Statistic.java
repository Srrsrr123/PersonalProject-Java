package wordcount;

import java.util.TreeMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Statistic {
	//����һ��map���ϱ��浥�ʺ͵��ʳ��ֵĸ���
    TreeMap<String,Integer> map = new TreeMap<String,Integer>();
    
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
        }
    	return num;
    }
    //ͳ�Ƶ����������ʣ�������4��Ӣ����ĸ��ͷ��������ĸ���ַ��ţ������Էָ����ָ�����ִ�Сд��
    public int wordNum(String text) {
    	int num = 0;
    	String[] words = text.split("\\W+");
    	for (int i = 0; i <words.length; i++) {
    		String str = words[i].toLowerCase();
    		if(str.matches("[a-zA-Z]{4}([a-zA-Z0-9])*")) {	
    			 num++;
    			 if(!map.containsKey(str)) {
    				 map.put(str,1);
    			 }
    			 else {
    				 map.put(str,map.get(str)+1);
    			 }
    		}
    	}
    	return num;
    }
    //ͳ���ļ���Ч����
    public int lineNum() {
    	return 0;
    }
}
