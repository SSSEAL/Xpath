package TestHTMLtoXML;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;

import javax.xml.transform.Result;
import javax.xml.transform.Source;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import java.io.IOException;

public class xmloxsl {
	private static void Transform(String xmlFileName, String xslFileName,
            String htmlFileName) {
        try {
            TransformerFactory tFac = TransformerFactory.newInstance();
            Source xslSource = new StreamSource(xslFileName);
            Transformer t = tFac.newTransformer(xslSource);
            File xmlFile = new File(xmlFileName);
            File htmlFile = new File(htmlFileName);
            Source source = new StreamSource(xmlFile);
            Result result = new StreamResult(htmlFile);
            t.transform(source, result);
        } catch (TransformerConfigurationException e) {
            e.printStackTrace();
        } catch (TransformerException e) {
            e.printStackTrace();
        }
    }
	
	private static void WriteXslPart(String outFileName,String tag)
	{
		try
		{
			String s1 = "<?xml version=\"1.0\" encoding=\"utf-8\"?>";
			String s2 = "<xsl:stylesheet xmlns:xsl=\"http://www.w3.org/1999/XSL/Transform\" version=\"1.0\">";
			String s3 = "<xsl:output method=\"html\" indent=\"yes\" encoding=\"UTF-8\"/>";
			String s4 = "<xsl:template match=\"/\">";
			String s41 = "{";
			String s42 = "";
			String s43 = "}";
			String s5 = "</xsl:template></xsl:stylesheet>";
			s42 += "\"" + tag + "\":[<xsl:for-each select=\"//" + tag + "\">\n" +
			"<xsl:if test=\"text()!=''\">\n" +
			"<xsl:if test=\"text()!= '&#x000A;'\">\n" +
			"<xsl:if test=\"position()!=last()\">\n" +
			"<xsl:choose>\n" +
				"<xsl:when test=\"contains(text(),'&#x000A;')\">\n" +
				"\"<xsl:value-of select=\"normalize-space()\" disable-output-escaping=\"yes\"/>\",</xsl:when>\n" +
				"<xsl:otherwise>\n" +
				"\"<xsl:value-of select=\"text()\" disable-output-escaping=\"yes\" />\",</xsl:otherwise>\n" +
			"</xsl:choose>\n" +
			"</xsl:if>\n" +
			"<xsl:if test=\"position()=last()\">\n" +
			"<xsl:choose>\n" +
				"<xsl:when test=\"contains(text(),'&#x000A;')\">\n" +
				"\"<xsl:value-of select=\"normalize-space()\" disable-output-escaping=\"yes\"/>\",</xsl:when>\n" +
				"<xsl:otherwise>\n" +
				"\"<xsl:value-of select=\"text()\" disable-output-escaping=\"yes\" />\"</xsl:otherwise>\n" +
			"</xsl:choose>\n" +
			"</xsl:if>\n" +
			"</xsl:if>\n" +
			"</xsl:if>\n" +
			"</xsl:for-each>]";
			StringBuffer sb2 = new StringBuffer(s1 + "\n" + s2 + "\n" + s3 + "\n" + s4 + "\n" + s41 + "\n" + s42 + "\n" + s43 + "\n" + s5);
			FileWriter fw = new FileWriter(outFileName);
			BufferedWriter bw = new BufferedWriter(fw);
			bw.write(sb2.toString());
			bw.close();
		}
		catch (IOException e)
        {
            e.printStackTrace();
        }
		
	}
	
	private static void WriteXslAll(String outFileName,String tag)
	{
		try
		{
			String s1 = "<?xml version=\"1.0\" encoding=\"utf-8\"?>";
			String s2 = "<xsl:stylesheet xmlns:xsl=\"http://www.w3.org/1999/XSL/Transform\" version=\"1.0\">";
			String s3 = "<xsl:output method=\"html\" indent=\"yes\" encoding=\"UTF-8\"/>";
			String s4 = "<xsl:template match=\"/\">";
			String s41 = "{";
			String s42 = "";
			String s43 = "}";
			String s5 = "</xsl:template></xsl:stylesheet>";
			s42 += "\"" + tag + "\":[<xsl:for-each select=\"//" + tag + "\">\n" +
			"<xsl:if test=\".!=''\">\n" +
			"<xsl:if test=\".!= '&#x000A;'\">\n" +
			"<xsl:if test=\"position()!=last()\">\n" +
			"<xsl:choose>\n" +
				"<xsl:when test=\"contains(.,'&#x000A;')\">\n" +
				"\"<xsl:value-of select=\"normalize-space()\" disable-output-escaping=\"yes\"/>\",</xsl:when>\n" +
				"<xsl:otherwise>\n" +
				"\"<xsl:value-of select=\".\" disable-output-escaping=\"yes\" />\",</xsl:otherwise>\n" +
			"</xsl:choose>\n" +
			"</xsl:if>\n" +
			"<xsl:if test=\"position()=last()\">\n" +
			"<xsl:choose>\n" +
				"<xsl:when test=\"contains(.,'&#x000A;')\">\n" +
				"\"<xsl:value-of select=\"normalize-space()\" disable-output-escaping=\"yes\"/>\",</xsl:when>\n" +
				"<xsl:otherwise>\n" +
				"\"<xsl:value-of select=\".\" disable-output-escaping=\"yes\" />\"</xsl:otherwise>\n" +
			"</xsl:choose>\n" +
			"</xsl:if>\n" +
			"</xsl:if>\n" +
			"</xsl:if>\n" +
			"</xsl:for-each>]";
			StringBuffer sb2 = new StringBuffer(s1 + "\n" + s2 + "\n" + s3 + "\n" + s4 + "\n" + s41 + "\n" + s42 + "\n" + s43 + "\n" + s5);
			FileWriter fw = new FileWriter(outFileName);
			BufferedWriter bw = new BufferedWriter(fw);
			bw.write(sb2.toString());
			bw.close();
		}
		catch (IOException e)
        {
            e.printStackTrace();
        }
		
	}
	
	public static void Xml2Json(String xml,String json,String tag,boolean flag)
	{
		if(xml == "" || json == "" || tag == "")
			System.out.println("输入字符串不能为空！！");
		else{
			File file = new File("xsl");
    		if(!file.exists())
    			file.mkdir();
			String xmlFileName = xml;
			String xslFileName = "xsl/default.xsl";
			String jsonFileName = json;
			if(flag)
				WriteXslAll(xslFileName,tag);
			else
				WriteXslPart(xslFileName,tag);
			Transform(xmlFileName, xslFileName, jsonFileName);
			
	        
			try
	        {
				String content = StrClass.file2Str(jsonFileName);
	            
	            content = StrClass.changeStr("(,])|(,\n\"\"])","]",content);
				content = StrClass.changeStr("\n\"\",","",content);
	        
				content = StrClass.changeStr("\"","'",content);//将所有"换成'
				content = StrClass.changeStr("\n'","\n\"",content);//将所有的\n'换成\n"
				content = StrClass.changeStr("',\n","\",\n",content);//将所有的’,\n换成",\n
				content = StrClass.changeStr("']\n","\"]\n",content);//将']\n换成"]\n
				content = StrClass.changeStr("\"" + tag + "'","\"" + tag + "\"",content);//将"a'换成"a"
				
				FileWriter fw = new FileWriter(jsonFileName);
	            BufferedWriter bw = new BufferedWriter(fw);
	            bw.write(content.toString());
	            bw.close();
	             
	        } catch (FileNotFoundException e)
	        {
	            e.printStackTrace();
	        } catch (IOException e)
	        {
	            e.printStackTrace();
	        }
		}
	}
	
	public static void Xml2JsonAll(String xml,String jsonall, String tag)
	{
		if(xml == "" || jsonall == "" || tag == "")
			System.out.println("输入字符串不能为空！！");
		else
		{
			try
			{
				String s1 = "<?xml version=\"1.0\" encoding=\"utf-8\"?>";
				String s2 = "<xsl:stylesheet xmlns:xsl=\"http://www.w3.org/1999/XSL/Transform\" version=\"1.0\">";
				String s3 = "<xsl:output method=\"html\" indent=\"yes\" encoding=\"UTF-8\"/>";
				String s4 = "<xsl:template match=\"/\">";
				String s41 = "{";
				String s42 = "";
				String s43 = "}";
				String s5 = "</xsl:template></xsl:stylesheet>\n";
				s42 += "\"" + tag + "\":[<xsl:for-each select=\"//a\">\n" +
				"<xsl:if test=\"position()!=last()\">\n" +
				"\"<xsl:value-of select=\"@href\"/>\",</xsl:if>\n" +
				"<xsl:if test=\"position()=last()\">\n" +
				"\"<xsl:value-of select=\"@href\"/>\"</xsl:if>\n" +
				"</xsl:for-each>]";
				StringBuffer sb2 = new StringBuffer(s1 + "\n" + s2 + "\n" + s3 + "\n" + s4 + "\n" + s41 + "\n" + s42 + "\n" + s43 + "\n" + s5);
				File file = new File("xsl");
	    		if(!file.exists())
	    			file.mkdir();
				FileWriter fw = new FileWriter("xsl/defaultall.xsl");
				BufferedWriter bw = new BufferedWriter(fw);
				bw.write(sb2.toString());
				bw.close();
			}
			catch (IOException e)
	        {
	            e.printStackTrace();
	        }
			
			
			xmloxsl.Xml2JsonWithXsl(xml,"xsl/defaultall.xsl",jsonall);
			String content = StrClass.file2Str(jsonall);
			JSONObject jsonObject = JSONObject.fromObject(content);
			JSONArray jsonArray = JSONArray.fromObject(jsonObject.getString(tag));
			String result = "{\"" + tag + "\":[";
			for(int i=1;i<jsonArray.size();i++){
				String ss = jsonArray.get(i).toString();
				if(ss.length() >= 4 && ss.substring(0,4).equals("http"))
				{
					result += "\"" + jsonArray.get(i).toString() + "\",\n";
					File file = new File("xml");
		    		if(!file.exists())
		    			file.mkdir();
					htox.Html2Xml(jsonArray.get(i).toString(),"xml/defult---" + i + ".xml");
					File file1 = new File("result-jsonall");
		    		if(!file1.exists())
		    			file1.mkdir();
					xmloxsl.Xml2Json("xml/defult---" + i + ".xml", "result-jsonall/jsonall--" + i + ".json", tag, false);
				}
			}
			result += "]}";
			result= StrClass.changeStr(",\n]","]",result);
			try
			{
				FileWriter fw = new FileWriter(jsonall);
				BufferedWriter bw = new BufferedWriter(fw);
				bw.write(result);
				bw.close();
			} catch (IOException e)
	        {
	            e.printStackTrace();
	        }
			
		}
	}
	
	public static void Xml2JsonWithXsl(String xml,String xsl,String json)
	{
		if(xml == "" || json == "" || xsl == "")
			System.out.println("输入字符串不能为空！！");
		else{
			String xmlFileName = xml;
			String jsonFileName = json;
			Transform(xmlFileName, xsl, jsonFileName);
			
			try
	        {
				String content = StrClass.file2Str(jsonFileName);
	            
	            content = StrClass.changeStr("(,])|(,\n\"\"])","]",content);
	            content = StrClass.changeStr("\n\"\",","",content);
	        
	            content = StrClass.changeStr("\n","",content);
	            content = StrClass.changeStr(",\"",",\n\"",content);
	        
//				StrClass.change("\\{","\\{\n",jsonFileName);
//				StrClass.change("\\}","\n\\}",jsonFileName);
	        
//	        	StrClass.change("\"","'",jsonFileName);//将所有"换成'
//	        	StrClass.change("\n'","\n\"",jsonFileName);//将所有的\n'换成\n"
//	        	StrClass.change("',\n","\",\n",jsonFileName);//将所有的’,\n换成",\n
//	        	StrClass.change("']\n","\"]\n",jsonFileName);//将']\n换成"]\n
//	        //StrClass.change("\"" + tag + "'","\"" + tag + "\"",jsonFileName);//将"a'换成"a"
				
				FileWriter fw = new FileWriter(jsonFileName);
	            BufferedWriter bw = new BufferedWriter(fw);
	            bw.write(content.toString());
	            bw.close();
	             
	        } catch (FileNotFoundException e)
	        {
	            e.printStackTrace();
	        } catch (IOException e)
	        {
	            e.printStackTrace();
	        }
		}
	}
}
