package TestHTMLtoXML;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StrClass {
	public static void change(String regex,String regax,String fileName) {
        FileReader fr;
        String content =null;
        try
        {
            fr = new FileReader(fileName);
            BufferedReader br = new BufferedReader(fr);
            String str = null;
            StringBuffer sb = new StringBuffer();
            while((str = br.readLine()) != null)
            {
                sb.append(str+"\n");
            }
            content = sb.toString();
            br.close();
             
        } catch (FileNotFoundException e)
        {
            e.printStackTrace();
        } catch (IOException e)
        {
            e.printStackTrace();
        }
        
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(content);
        StringBuffer sb1 = new StringBuffer();
        
        boolean flag = true;
        while(matcher.find())
        {
        	flag = false;
            sb1.append(matcher.replaceAll(regax));
        }
        if(flag)
        	sb1 = new StringBuffer(content);
        
        try
        {
            FileWriter fw = new FileWriter(fileName);
            BufferedWriter bw = new BufferedWriter(fw);
            bw.write(sb1.toString());
            bw.close();
        } catch (IOException e)
        {
            e.printStackTrace();
        }
    }
	
	public static String changeStr(String regex,String regax,String content){
		Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(content);
        StringBuffer sb1 = new StringBuffer();
        
        boolean flag = true;
        while(matcher.find())
        {
        	flag = false;
            sb1.append(matcher.replaceAll(regax));
        }
        if(flag)
        	sb1 = new StringBuffer(content);
        return sb1.toString();
	}
	
	public static String file2Str(String file){
		FileReader fr;
		String content =null;
		try
		{
			fr = new FileReader(file);
			BufferedReader br = new BufferedReader(fr);
			String str = null;
			StringBuffer sb = new StringBuffer();
			while((str = br.readLine()) != null)
			{
				sb.append(str+"\n");
			}
			content = sb.toString();
			br.close();
		}catch (FileNotFoundException e)
        {
            e.printStackTrace();
        } catch (IOException e)
        {
            e.printStackTrace();
        }
		return content;
	}
	
	public static void writeFile(String tag){
		try{
			FileWriter fw = new FileWriter("config.txt",true);
			BufferedWriter bw = new BufferedWriter(fw);
			bw.write(", " + tag);
			bw.close();
		} catch (IOException e)
        {
            e.printStackTrace();
        }
	}
}
