import java.io.*;
import java.util.List;
import java.util.Map;

public class WordCount {
    public static void main(String[] args) {
        String content = null;/*存放文件内容*/
        int charNumber = 0;/*字符数*/
        int wordNumber = 0;/*单词数*/
        int lineNumber = 0;/*文件有效行数*/
        List<Map.Entry<String,Integer>> list ;/*存放输出频率最高的10个的单词*/
        if(args.length != 2) {
            System.out.print("参数个数有误");
            return;
        }
        String inputText = args[0];
        String outputText = args[1];
        Statistic tool = new Statistic();
        content = readFile(inputText);
        charNumber = tool.charNum(content);
        wordNumber = tool.wordNum(content);
        lineNumber = tool.lineNum(content);
        list = tool.maxNum();
        writeFile(charNumber,wordNumber,lineNumber,list,outputText);
    }
    //将文件内容读出到字符串
    public static String readFile(String input) {
        BufferedReader bReader = null;
        StringBuilder buffer = new StringBuilder();
        try {
            int b;
            File file = new File(input);
            InputStreamReader reader = new InputStreamReader(new FileInputStream(file),"UTF-8");
            bReader = new BufferedReader(reader);
            while((b = bReader.read()) != -1) {
                buffer.append((char)b);
            }
        }
        catch (IOException e) {
            System.out.println("打开文件失败");
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
        BufferedWriter bWriter = null;
        try {
            OutputStreamWriter fout = new OutputStreamWriter(new FileOutputStream(output),"UTF-8");
            bWriter = new BufferedWriter(fout);
            bWriter.write("characters: "+charNum+"\n");
            bWriter.write("words: "+wordNum+"\n");
            bWriter.write("lines: "+lineNum+"\n");
            for (int i = 0; i < list.size(); i++) {
                if (i >= 10) break;
                Map.Entry<String,Integer> entry = list.get(i);
                bWriter.write(entry.getKey() + "：" + entry.getValue()+"\n");
            }
            fout.flush();
            fout.close();
        }
        catch (IOException e) {
            System.out.println("打开文件失败");
            e.printStackTrace();
        }
    }
}
