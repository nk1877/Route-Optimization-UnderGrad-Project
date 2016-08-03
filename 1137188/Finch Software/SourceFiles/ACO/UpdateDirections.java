package ACO;

import java.util.ArrayList;


public class UpdateDirections {
	
	public String update(ArrayList<String>k,ArrayList<String>m){
		String state="null";
		System.out.println(k.size());
		if(k.get(k.size()-1).equals("Straight")){
			if(m.get(m.size()-1).equals("RIGHT")){
				state = "Right";
				}
			else if(m.get(m.size()-1).equals("LEFT")){
				state="Left";
			}
			else if(m.get(m.size()-1).equals("NOWAY")){
				state="Back";
			}
			else{
				state="Straight";
			}
			
		}
		else if(k.get(k.size()-1).equals("Left")){
			if(m.get(m.size()-1).equals("RIGHT")){
				state = "Straight";
				}
			else if(m.get(m.size()-1).equals("LEFT")){
				state="Back";
			}
			else if(m.get(m.size()-1).equals("NOWAY")){
				state="Right";
			}
			else{
				state="Left";
			}
			
		}
		else if(k.get(k.size()-1).equals("Right")){
			if(m.get(m.size()-1).equals("RIGHT")){
				state = "Back";
				}
			else if(m.get(m.size()-1).equals("LEFT")){
				state="Straight";
			}
			else if(m.get(m.size()-1).equals("NOWAY")){
				state="Left";
			}
			else{
				state="Left";
			}
			
		}
		else if(k.get(k.size()-1).equals("Back")){
			if(m.get(m.size()-1).equals("RIGHT")){
				state = "Left";
				}
			else if(m.get(m.size()-1).equals("LEFT")){
				state="Right";
			}
			else if(m.get(m.size()-1).equals("NOWAY")){
				state="Straight";
			}
			else{
				state="Back";
			}
			
		}
		
		return state;
	}

}
