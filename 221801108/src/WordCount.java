package wordcount;


import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.io.File;

public class WordCount {
	public static void main(String[] args) {
		String content = null;//�ļ�����
		int charNumber = 0;//�ַ���
		int wordNumber = 0;//������
		int lineNumber = 0;//�ļ���Ч����
		List<Map.Entry<String,Integer>> list ;
		String inputtext;
		String outputtext;
		Statistic tool = new Statistic();
		content = readFile();
		charNumber = tool.charNum(content);
		wordNumber = tool.wordNum(content);
		lineNumber = tool.lineNum(content);
		list = tool.maxtenNum();
		writeFile(charNumber,wordNumber,lineNumber,list,content);
	}
	//���ļ����ݶ������ַ���
	public static String readFile() {
		BufferedReader bReader = null;
		StringBuilder buffer = new StringBuilder();
		try {
			int b;
			File file = new File("test.txt");
	        FileReader reader = new FileReader(file);
	        bReader = new BufferedReader(reader);
	        while((b = bReader.read()) != -1) {
                buffer.append((char)b);
            }
		}
		catch (IOException e) {
            System.out.println("�ļ�������");
            e.printStackTrace();
        }
		finally {
			try {
                bReader.close();
            }catch(IOException e) {
                e.printStackTrace();
            }
		}
		 return buffer.toString();
	}
	//��ͳ�ƽ��������ļ���
	public static void writeFile(int charNum,int wordNum,int lineNum,List<Map.Entry<String,Integer>> list,String str) {
		try {
			FileWriter fout = new FileWriter("testt.txt");
			fout.write("characters: "+charNum+"\n");
			fout.write("words: "+wordNum+"\n");
			fout.write("lines: "+lineNum+"\n");
			for (int i = 0; i < 10; i++) {
				Map.Entry<String,Integer> entry = list.get(i);
	            if (entry == null) {
	                return;
	            }
	            fout.write(entry.getKey() + "��" + entry.getValue()+"\n");
			}
			fout.write(str);
			fout.flush();
			fout.close();
		}
		catch (IOException e) {
            System.out.println("�ļ�������");
            e.printStackTrace();
        }
	}
}
