package wordcount;

import java.io.InputStream;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.LineNumberReader;
import java.io.InputStreamReader;
import java.io.File;

public class WordCount {
	public static void main(String[] args) {
		String contend=null;//�ļ�����
		int charNumber;//�ַ���
		int wordNumber;//������
		int lineNumber;//�ļ�����
		String inputtext;
		String outputtext;
		contend=readFile();
		writeFile(contend);
	}
	public static String readFile() {
		BufferedReader bReader =null;
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
	public static void writeFile(String temp) {
		
	}
}
