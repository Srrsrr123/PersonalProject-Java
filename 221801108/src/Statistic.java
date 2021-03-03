package wordcount;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
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
    		Pattern r = Pattern.compile("[a-zA-Z]{4}([a-zA-Z0-9])*");
    		Matcher m = r.matcher(str);  		
    		if (m.find()) {	
    			 num++;
    			 if (!map.containsKey(str)) {
    				 map.put(str,1);
    			 }
    			 else {
    				 map.put(str,map.get(str)+1);
    			 }
    		}
    	}
    	return num;
    }
    //ͳ���ļ���Ч�������κΰ����ǿհ��ַ����У�����Ҫͳ�ơ�
    public int lineNum(String text) {
    	int num = 0;
    	String[] lines = text.split("\\n");
    	for (int i=0; i<lines.length; i++) {
    		Pattern r = Pattern.compile("\\S+");
    		Matcher m = r.matcher(lines[i]);
    		if (m.find()) {
    			num++;
    		}
    	}
    	return num;
    }
    //ͳ���ļ��и����ʵĳ��ִ�������Ӧ���������10�У�������ֻ���Ƶ����ߵ�10����
    public void maxtenNum() {
        List<Map.Entry<String,Integer>> list = new ArrayList<Map.Entry<String,Integer>>(map.entrySet());
        Collections.sort(list, new Comparator<Map.Entry<String, Integer>>() {
            public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2) {
                
            }
        });
    }
}
