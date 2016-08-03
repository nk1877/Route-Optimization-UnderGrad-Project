package ACO;

import java.util.ArrayList;

public class updatedphromone {
	
	public int shortestdistance(ArrayList<Double> data){
		double min = Double.MAX_VALUE;
	    int index = -1;
	    for (int i = 0; i < data.size(); i++) {
	        Double f = data.get(i);
	        if (Double.compare(f.floatValue(), min) < 0) {
	            min = f.floatValue();
	            index = i;
	        }
	    }
	    System.out.println("index is:"+index);
	    return index;
	}

}
