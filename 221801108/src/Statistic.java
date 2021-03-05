import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Statistic {
    /*定义一个map集合保存单词和单词出现的个数*/
    TreeMap<String,Integer> map = new TreeMap<String,Integer>();

    Statistic(){
    }
    /*统计字符串，只需要统计Ascii码，汉字，不需考虑空格，水平制表符，换行符，均算字符*/
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
    /*统计单词数，单词：至少以4个英文字母开头，跟上字母数字符号，单词以分隔符分割，不区分大小写。*/
    public int wordNum(String text) {
        int num = 0;
        String[] words = text.split("\\W+");
        for (int i = 0; i < words.length; i++) {
            String str = words[i].toLowerCase();
            Pattern r = Pattern.compile("^[a-zA-Z]{4}([a-zA-Z0-9])*");
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
    /*统计文件有效行数，任何包含非空白字符的行，都需要统计。*/
    public int lineNum(String text) {
        int num = 0;
        String[] lines = text.split("\\n");
        for (int i = 0; i < lines.length; i++) {
            Pattern r = Pattern.compile("\\S+");
            Matcher m = r.matcher(lines[i]);
            if (m.find()) {
                num++;
            }
        }
        return num;
    }
    /*统计文件中各单词的出现次数（对应输出接下来10行），最终只输出频率最高的10个。*/
    public List<Map.Entry<String,Integer>> maxNum() {
        List<Map.Entry<String,Integer>> list;
        list = new ArrayList<Map.Entry<String,Integer>>(map.entrySet());
        Collections.sort(list, new Comparator<Map.Entry<String, Integer>>() {
            public int compare(Map.Entry<String, Integer> pre, Map.Entry<String, Integer> last) {
                if (pre.getValue().equals(last.getValue())) {
                    return pre.getKey().compareTo(last.getKey());
                }
                else {
                    return last.getValue().compareTo(pre.getValue());
                }
            }
        });
        return list;
    }
}
