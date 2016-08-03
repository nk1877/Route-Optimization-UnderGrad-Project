package ACO;

import java.util.ArrayList;

public class pheromone {
	 ArrayList<Integer> x = new ArrayList<Integer>(); 
	 ArrayList<Integer> y = new ArrayList<Integer>(); 
	
	public ArrayList<String> getdirection(ArrayList<String> motion){
			System.out.println(motion);
			
			return motion;
}
	public void trialphero (ArrayList<Double>p,ArrayList<String>d){
		
		if(d.get(d.size()-1).equals("Straight")){
			System.out.println("straight recognized");
			double num = p.get(d.size()-1);
		//Integer l = (int) (long) num;
		//int l = (int) num.MAX_VALUE;
			int z = (int)num;
			x.add(x.get(d.size()-1));
			y.add(y.get(d.size()-1)+z);
			
			//System.out.println(x);
			//System.out.println(y);
		}
		else if(d.get(d.size()-1).equals("Right")){
			System.out.println("Right Recognised");
			double num = p.get(d.size()-1);
			//Integer l = (int) (long) num;
			int z = (int)num;
			x.add(x.get(d.size()-1)+z);
			y.add(y.get(d.size()-1));
			//System.out.println(x);
			//System.out.println(y);
		}
		else if(d.get(d.size()-1).equals("Left")){
			System.out.println("Left Recognised");
			double num = p.get(d.size()-1);
			//Integer l = (int) (long) num;
			int z = (int)num;
			x.add(x.get(d.size()-1)-z);
			y.add(y.get(d.size()-1));
			//System.out.println(x);
			//System.out.println(y);
		}
		else if(d.get(d.size()-1).equals("Back")){
			System.out.println("Back Recognised");
			double num = p.get(d.size()-1);
			//Integer l = (int) (long) num;
			int z = (int)num;
			x.add(x.get(d.size()-1));
			y.add(y.get(d.size()-1)-z);
			//System.out.println(x);
			//System.out.println(y);
		}
		else{
			
		}
		System.out.println(x);
		System.out.println(y);
		System.out.println(x.size());
		System.out.println(y.size());

	}
	public ArrayList<Integer> xco(){
		return x;
	}
	public ArrayList<Integer> yco(){
		return y;
	}
		
	public void startingval(){
		x.add(0);
		y.add(0);
	}
	
}
