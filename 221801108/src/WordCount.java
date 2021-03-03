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
		String content = null;//����ļ�����
		int charNumber = 0;//�ַ���
		int wordNumber = 0;//������
		int lineNumber = 0;//�ļ���Ч����
		List<Map.Entry<String,Integer>> list ;//������Ƶ����ߵ�10���ĵ���
		String inputtext = "test.txt";
		String outputtext = "testt.txt";
		Statistic tool = new Statistic();
		content = readFile(inputtext);
		charNumber = tool.charNum(content);
		wordNumber = tool.wordNum(content);
		lineNumber = tool.lineNum(content);
		list = tool.maxtenNum();
		writeFile(charNumber,wordNumber,lineNumber,list,outputtext);
	}
	//���ļ����ݶ������ַ���
	public static String readFile(String input) {
		BufferedReader bReader = null;
		StringBuilder buffer = new StringBuilder();
		try {
			int b;
			File file = new File(input);
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
	public static void writeFile(int charNum,int wordNum,int lineNum,List<Map.Entry<String,Integer>> list,String output) {
		try {
			FileWriter fout = new FileWriter(output);
			fout.write("characters: "+charNum+"\n");
			fout.write("words: "+wordNum+"\n");
			fout.write("lines: "+lineNum+"\n");
			for (int i = 0; i < list.size(); i++) {
				if (i >= 10) break;
				Map.Entry<String,Integer> entry = list.get(i);
	            fout.write(entry.getKey() + "��" + entry.getValue()+"\n"); 
			}
			fout.flush();
			fout.close();
		}
		catch (IOException e) {
            System.out.println("�ļ�������");
            e.printStackTrace();
        }
	}
}
