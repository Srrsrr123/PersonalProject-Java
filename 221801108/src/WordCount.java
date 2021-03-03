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
		String content = null;//存放文件内容
		int charNumber = 0;//字符数
		int wordNumber = 0;//单词数
		int lineNumber = 0;//文件有效行数
		List<Map.Entry<String,Integer>> list ;//存放输出频率最高的10个的单词
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
	//将文件内容读出到字符串
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
	public static void writeFile(int charNum,int wordNum,int lineNum,List<Map.Entry<String,Integer>> list,String output) {
		try {
			FileWriter fout = new FileWriter(output);
			fout.write("characters: "+charNum+"\n");
			fout.write("words: "+wordNum+"\n");
			fout.write("lines: "+lineNum+"\n");
			for (int i = 0; i < list.size(); i++) {
				if (i >= 10) break;
				Map.Entry<String,Integer> entry = list.get(i);
	            fout.write(entry.getKey() + "：" + entry.getValue()+"\n"); 
			}
			fout.flush();
			fout.close();
		}
		catch (IOException e) {
            System.out.println("文件不存在");
            e.printStackTrace();
        }
	}
}
