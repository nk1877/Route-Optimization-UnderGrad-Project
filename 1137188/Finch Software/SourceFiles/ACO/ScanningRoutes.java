package ACO;

import java.io.BufferedReader;



import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;


import server.FinchClient;




public class ScanningRoutes{
	//Finch myFinch=new Finch();
	FinchClient dir = new FinchClient();
	public static String pathdata="";
	ArrayList<Integer> arraysize = new ArrayList<Integer>();
	ArrayList<Integer> arraysizestring = new ArrayList<Integer>();
	ArrayList<Double> sumdistance = new ArrayList<Double>();
	ArrayList<Double> len = new ArrayList<Double>();
	ArrayList<String> direct = new ArrayList<String>();
	public void robo2path(){
		
	}
	public void getdir() throws IOException{
		updatedphromone a = new updatedphromone();
		BufferedReader br = new BufferedReader(new FileReader("pheroall.txt"));
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
		int count=0;
		for(int l=0;l<z.length();l++){
			if(z.charAt(l)=='/'){
				count++;
			}
		}
		System.out.println(count);
		k=z.split("/",count);
		System.out.println(z);
	   for(int i=0;i<k.length;i++){
		System.out.println("This is a string array"+i +" "+k[i]);
		}
		int n=0;
		
		while(n<count){	
		if(n%2==0){
		System.out.println(n);
		for(int j=0;j<=k[n].toCharArray().length;j++){
			String temp="";
			while(k[n].charAt(j)!=','){
			if(k[n].charAt(j)=='.'){break;}
			temp+=k[n].charAt(j);	
			j++;
			}
			String nk=temp;
			direct.add(nk);
			if(k[n].charAt(j)=='.'){break;}
	}
		int u=direct.size();
		arraysizestring.add(u);
		System.out.println(arraysize);
		if(n>0){
			for(int j=0;j<arraysizestring.get(arraysizestring.size()-2);j++){
				direct.remove(0);
			}
			arraysizestring.set(arraysizestring.size()-1, direct.size());
		
		}
		
		System.out.println("This is the direction"+direct);
		}
		else{
			System.out.println(n);
		for(int j=0;j<=k[n].toCharArray().length;j++){
			//System.out.println(o.length + "equals"+j);
			String temp="";
			while(k[n].charAt(j)!=','){
			if(k[n].charAt(j)=='+'){break;}
			temp+=k[n].charAt(j);	
			j++;
			}
			double b=Double.parseDouble(temp);
			len.add(b);
			if(k[n].charAt(j)=='+'){break;}
	}
		int u=len.size();
		arraysize.add(u);
		System.out.println(arraysize);
		if(n>1){
			for(int j=0;j<arraysize.get(arraysize.size()-2);j++){
				len.remove(0);
			}
			arraysize.set(arraysize.size()-1, len.size());
		}
		System.out.println("This is the distace"+len);
		double sum=0;
		for(int i=0;i<len.size();i++){
			sum+=len.get(i);
		}
		sumdistance.add(sum);
		System.out.println("This is the sum"+sum);
		}
		n++;
		}
		a.shortestdistance(sumdistance);
		sendingdata(k[(2*a.shortestdistance(sumdistance))+1],k[2*a.shortestdistance(sumdistance)]);
		
}
	public ArrayList<Double> sumofdistance(){
		System.out.println("This is total distance covered"+sumdistance);
		return sumdistance;
	}

	public void sendingdata(String a,String c){
		try {
	        BufferedWriter out = new BufferedWriter(new FileWriter("shortestdistance.txt"));
	    
	    	  out.write(c); 
        	out.write("/");
 	    	   out.write(a);  
 	       
        	
	            out.close();
	        } catch (IOException e) {}
	}
}