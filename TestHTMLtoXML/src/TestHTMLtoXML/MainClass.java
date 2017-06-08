package TestHTMLtoXML;


public class MainClass {
	public static void main(String [] args)
	{
		htox.Html2Xml("https://www.baidu.com/","result000.xml");
		xmloxsl.Xml2JsonAll("result000.xml", "111.json", "li");
		//xmloxsl.Xml2JsonWithXsl("result000.xml","new000.xsl","result000.json");

//		htox.Post2Xml("http://www.japanparts.it/blocks/search-content/search-by-vehicle/vehicle-versions.jsp?type=1&model_id=7672","result.xml");
//		//htox.Post2Xml("http://www.japanparts.it/blocks/search-content/search-by-engine/engine-versions.jsp?manufacturer=35&code=223+A9.000", "result.xml");
//		xmloxsl.Xml2JsonWithXsl("result.xml","xsl/all.xsl","result.json");
//		
//		
//		FileReader fr;
//		String content =null;
//		try
//		{
//			fr = new FileReader("result.json");
//			BufferedReader br = new BufferedReader(fr);
//			String str = null;
//			StringBuffer sb = new StringBuffer();
//			while((str = br.readLine()) != null)
//			{
//				sb.append(str+"\n");
//			}
//			content = sb.toString();
//			br.close();
//		} catch (FileNotFoundException e)
//        {
//            e.printStackTrace();
//        } catch (IOException e)
//        {
//            e.printStackTrace();
//        }
//        JSONObject jsonObject = JSONObject.fromObject(content);
//        JSONArray jsonArray = JSONArray.fromObject(jsonObject.getString("a"));
//        for(int i=1;i<jsonArray.size();i++){
//        	System.out.println(jsonArray.get(i));
//        	htox.Html2Xml("http://www.japanparts.it/item.jsp?code=" + jsonArray.get(i), "result/result-" + jsonArray.get(i) + ".xml");
//        	
//        	
////        	Tidy tidy = new Tidy();
////            tidy.setXmlOut(true); 
////            tidy.setXmlPi(true);   //添加 <?xml?> 标签 为输出的 XML 文件， 这些参数是可选的。
////            tidy.setXmlSpace(true);
////            tidy.setQuoteNbsp(false);
////            tidy.setXmlSpace(false);
////            tidy.setCharEncoding(Configuration.UTF8);
////            try
////            {
////            tidy.setConfigurationFromFile("config.txt");
////            StrClass.change("(<script[\\s\\S]*?</script>)|(rel=\"[\\s\\S]*?\")|(<!DOCTYPE[\\s\\S]*?>)|(xmlns=\"[\\s\\S]*?\")|(<svg[\\s\\S]*?</svg>)|(<cache[\\s\\S]*?>)|(</cache[\\s\\S]*?>)","","output.html");
////            StrClass.change("<span class=\"lang it[\\s\\S]*?</span>","","output.html");
////        	StrClass.change("<span class=\"lang de[\\s\\S]*?</span>","","output.html");
////        	StrClass.change("<span class=\"lang fr[\\s\\S]*?</span>","","output.html");
////        	StrClass.change("<span class=\"lang es[\\s\\S]*?</span>","","output.html");
////        	StrClass.change("<span class=\"lang pt[\\s\\S]*?</span>","","output.html");
////        	StrClass.change("<span class=\"lang ru[\\s\\S]*?</span>","","output.html");
////        	StrClass.change("<span class=\"lang pl[\\s\\S]*?</span>","","output.html");
////        	StrClass.change("<span class=\"lang gr[\\s\\S]*?</span>","","output.html");
////            FileInputStream in = new FileInputStream("output.html");
////            FileOutputStream out = new FileOutputStream("result-" + jsonArray.get(i) + ".xml"); 
////            tidy.parse(in, out);
////            in.close();
////            out.close();
////            }catch (IOException e) {
////                System.out.println(e.toString());
////            }
//            
//            
//            
//        	
//        	xmloxsl.Xml2JsonWithXsl("result/result-" + jsonArray.get(i) + ".xml","xsl/part.xsl","result/result-" + jsonArray.get(i) + ".json");
//        	System.out.println(jsonArray.get(i) + "---end");
//        }
//		//xmloxsl.Xml2JsonWithXsl("result-KDD-416.xml","xsl/part.xsl","1111111.json");
	}
}
