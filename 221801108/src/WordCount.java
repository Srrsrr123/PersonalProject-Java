package wordcount;


import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.File;

public class WordCount {
	public static void main(String[] args) {
		String content = null;//文件内容
		int charNumber = 0;//字符数
		int wordNumber = 0;//单词数
		int lineNumber = 0;//文件有效行数
		String inputtext;
		String outputtext;
		Statistic tool = new Statistic();
		content = readFile();
		charNumber = tool.charNum(content);
		wordNumber = tool.wordNum(content);
		writeFile(charNumber,wordNumber,content);
	}
	//将文件内容读出到字符串
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
            System.out.println("文件不存在");
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
	//将统计结果输出到文件中
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
            System.out.println("文件不存在");
            e.printStackTrace();
        }
	}
}
