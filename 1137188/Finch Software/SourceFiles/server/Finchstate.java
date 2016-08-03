package server;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import ACO.pheromone;
public class Finchstate {

	 pheromone co =new pheromone();
	 
 
 	public String processInput2() throws IOException {
 		String liststringy="";
 		BufferedReader br = new BufferedReader(new FileReader("shortestdistance.txt"));
 	    try {
 	        StringBuilder sb = new StringBuilder();
 	        String line = br.readLine();

 	        while (line != null) {
 	            sb.append(line);
 	            sb.append(System.lineSeparator());
 	            line = br.readLine();
 	        }
 	        String everything = sb.toString();
 	        liststringy=everything;
 	    } catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
 	        br.close();
 	    }
 		
 		return liststringy;
 	}	
 	
}