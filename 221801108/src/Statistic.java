package wordcount;

public class Statistic {
	Statistic(){
		
	}
    public int charNum(String str) {//ͳ���ַ���
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
    public int wordNum() {//ͳ�Ƶ�����
    	return 0;
    }
    public int lineNum() {//ͳ������
    	return 0;
    }
}
