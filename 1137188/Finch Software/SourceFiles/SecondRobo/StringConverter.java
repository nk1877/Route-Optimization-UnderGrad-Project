package SecondRobo;

import java.io.BufferedReader;



import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

import server.FinchClient;




public class StringConverter{
	//Finch myFinch=new Finch();
	FinchClient dir = new FinchClient();
	public static String pathdata="";
	ArrayList<Integer> xco = new ArrayList<Integer>();
	ArrayList<Integer> yco = new ArrayList<Integer>();
	ArrayList<Double> len = new ArrayList<Double>();
	ArrayList<String> direct = new ArrayList<String>();
	public void robo2path(){
		
	}
	public void getdir() throws IOException{
		BufferedReader br = new BufferedReader(new FileReader("/Users/nikhilkishore/Documents/Clientfile1.txt"));
 	    try {
 	        StringBuilder sb = new StringBuilder();
 	        String line = br.readLine();

 	        while (line != null) {
 	            sb.append(line);
 	            sb.append(System.lineSeparator());
 	            line = br.readLine();
 	        }
 	        String everything = sb.toString();
 	        pathdata=everything;
 	    } catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
 	        br.close();
 	    }
 	 //RoboFollows follow = new RoboFollows();
		System.out.println(pathdata);
		String z=pathdata;
		String[] k = {};
		
		k=z.split("/",2);
		System.out.println(z);
	   
		System.out.println("This is a string array a"+k[0]);
		System.out.println("This is a string array b"+k[1]);
		
		
		char[] o={};
		char[] p={};
		p=k[0].toCharArray();
		o=k[1].toCharArray();
		System.out.println(p);
		System.out.println(p.length);
	
		for(int j=0;j<=o.length;j++){
			//System.out.println(o.length + "equals"+j);
			String temp="";
			while(k[1].charAt(j)!=','){
			if(k[1].charAt(j)=='+'){break;}
			temp+=k[1].charAt(j);	
			j++;
			}
			double b=Double.parseDouble(temp);
			len.add(b);
			if(k[1].charAt(j)=='+'){break;}
	}
		System.out.println("This is the distace"+len);	
		for(int j=0;j<=p.length;j++){
			String temp="";
			while(k[0].charAt(j)!=','){
			if(k[0].charAt(j)=='.'){break;}
			temp+=k[0].charAt(j);	
			j++;
			}
			String nk=temp;
			direct.add(nk);
			if(k[0].charAt(j)=='.'){break;}
	}
		System.out.println("This is the direction"+direct);
		
}
	public ArrayList<Integer> xcoord(){
		System.out.println(xco);
		return xco;
	}
	public ArrayList<Integer> ycoord(){
		System.out.println(yco);
		return yco;
	}
	public ArrayList<Double> length(){
		System.out.println("This is distance moved"+len);
		return len;
	}
	public ArrayList<String> motion(){
		System.out.println("This is motion"+direct);
		return direct;
	}
	
}