import java.net.*;
import java.util.*;
import java.io.*;

import org.json.*;

public class TocHw3 {

	public static void main(String[] args)throws Exception {
		if(args.length<4){
			System.out.println("參數錯誤");
			return;
		}
		JSONArray input = null;
		int output=0;
		int total=0;
		JSONObject json;
		try {
			input=getJSONFromURL(args[0]);
		} catch (Exception e) {
		}
		int length=input.length();
		for(int a=0;a<length;a++){
			json= new JSONObject(new JSONTokener(input.get(a).toString()));
			if(json.getString("鄉鎮市區").equals(args[1])&&json.getString("土地區段位置或建物區門牌").indexOf(args[2])!=-1&&json.getInt("交易年月")>=Integer.parseInt(args[3])*100){
				//System.out.println(json.getString("鄉鎮市區")+"\t"+json.getString("土地區段位置或建物區門牌")+"\t"+json.getInt("交易年月")+"\t"+json.getInt("總價元"));
				output+=json.getInt("總價元");
				total++;
			}
		}
		if(total==0){
			total=1;
		}
		System.out.println(output/total);
	}
	
	public static JSONArray getJSONFromURL(String url) throws Exception{
		URL website = new URL(url);
        URLConnection connection = website.openConnection();
		JSONArray json=new JSONArray(new JSONTokener(connection.getInputStream()));
		return json;
    }
}
7
8
9
10
11
12
13
14
15
16
17
18
19
20
21
22
23
24
25
26
27
28
29
30
31
32
33
34
35
36
37
38
39
40
41
42
43
44
public class TocHw3 {
  public static void main(String[] args)throws Exception {
    if(args.length<4){
      System.out.println("參數錯誤");
      return;
    }
    JSONArray input = null;
    int output=0;
    int total=0;
    JSONObject json;
    try {
      input=getJSONFromURL(args[0]);
    } catch (Exception e) {
    }
    int length=input.length();
    for(int a=0;a<length;a++){
      json= new JSONObject(new JSONTokener(input.get(a).toString()));
      if(json.getString("鄉鎮市區").equals(args[1])&&json.getString("土地區段位置或建物區門牌").indexOf(args[2])!=-1&&json.getInt("交易年月")>=Integer.parseInt(args[3])*100){
        //System.out.println(json.getString("鄉鎮市區")+"\t"+json.getString("土地區段位置或建物區門牌")+"\t"+json.getInt("交易年月")+"\t"+json.getInt("總價元"));
        output+=json.getInt("總價元");
        total++;
      }
    }
    if(total==0){
      total=1;
    }
    System.out.println(output/total);
  }
  
  public static JSONArray getJSONFromURL(String url) throws Exception{
    URL website = new URL(url);
        URLConnection connection = website.openConnection();
    JSONArray json=new JSONArray(new JSONTokener(connection.getInputStream()));
    return json;
    }
}
