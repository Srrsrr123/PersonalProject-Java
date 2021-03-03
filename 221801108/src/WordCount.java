package wordcount;


import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.File;

public class WordCount {
	public static void main(String[] args) {
		String content = null;//�ļ�����
		int charNumber = 0;//�ַ���
		int wordNumber = 0;//������
		int lineNumber = 0;//�ļ���Ч����
		String inputtext;
		String outputtext;
		Statistic tool = new Statistic();
		content = readFile();
		charNumber = tool.charNum(content);
		wordNumber = tool.wordNum(content);
		writeFile(charNumber,wordNumber,content);
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
	public static void writeFile(int charNum,int wordNum,String str) {
		try {
			FileWriter fout = new FileWriter("testt.txt");
			fout.write(charNum+"\n");
			fout.write(wordNum+"\n");
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
