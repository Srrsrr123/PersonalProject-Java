package wordcount;

public class Statistic {
	Statistic(){
		
	}
    public int charNum(String str) {//统计字符数
    	int num = 0;
    	char [] list = str.toCharArray();
    	for(int i = 0; i < list.length; i++) {
            if(list[i] >= 0 && list[i] <= 127) {
                num++;
            }
            else continue;
        }
    	return num;
    }
    public int wordNum() {//统计单词数
    	return 0;
    }
    public int lineNum() {//统计行数
    	return 0;
    }
}
