package SecondRobo;

import java.util.ArrayList;

import edu.cmu.ri.createlab.terk.robot.finch.Finch;

public class RoboFollows {
	StringConverter p = new StringConverter();
	public void finchfollow(ArrayList <Double> length,ArrayList <String> direct){
		ArrayList <String>currentstate = new ArrayList <String>();
		//ArrayList <Double> r = new ArrayList <Double>();
		//ArrayList <String>l = new ArrayList <String>();
		//r=p.length();
		//l=p.motion();
		Finch myFinch = new Finch();
		System.out.println("asdfasdf");
		//myFinch.setWheelVelocities(250, 250,300);
		int o = length.get(0).intValue()*250;
		myFinch.setWheelVelocities(250, 250,o);
		int i=1;
		while(i<length.size()){
			if(direct.get(i).equals("Straight")){
			if(direct.get(i-1).equals("Left"))
			{
				currentstate.add("turning right");
				myFinch.setWheelVelocities(-250,-250,200);
				myFinch.setWheelVelocities(250,-250,500);
				int k = length.get(i).intValue()*250;
				myFinch.setWheelVelocities(250, 250,k);
			}
			else if(direct.get(i-1).equals("Right"))
			{
				currentstate.add("Turning Left");
				myFinch.setWheelVelocities(-250, 250,500);
				int k = length.get(i).intValue()*250;
				myFinch.setWheelVelocities(250, 250,k);
			}
			else if(direct.get(i-1).equals("Back"))
			{
				int k = length.get(i).intValue()*250;
				myFinch.setWheelVelocities(-250,-250,k);
			}
			else{
			currentstate.add("Straight");
			int k = length.get(i).intValue()*250;
			myFinch.setWheelVelocities(250, 250,k);
			}
		
		}
			else if(direct.get(i).equals("Back")){
			currentstate.add("Back");
			if(direct.get(i-1).equals("Left"))
			{
				myFinch.setWheelVelocities(-250, 250,500);
				int k = length.get(i).intValue()*250;
				myFinch.setWheelVelocities(250, 250,k);
			}
			else if(direct.get(i-1).equals("Right"))
			{
				myFinch.setWheelVelocities(250,-250,500);
				int k = length.get(i).intValue()*250;
				myFinch.setWheelVelocities(250, 250,k);
			}
			else if(direct.get(i-1).equals("Back"))
			{
				int k = length.get(i).intValue()*250;
				myFinch.setWheelVelocities(250, 250,k);
			}
			else
			{
			int k = length.get(i).intValue()*250;
			myFinch.setWheelVelocities(-250,-250,k);
			}
			
			}
			else if(direct.get(i).equals("Left")){
			currentstate.add("Left");
			if(direct.get(i-1).equals("Left")){
				currentstate.add("Straight");
				int k = length.get(i).intValue()*250;
				myFinch.setWheelVelocities(250, 250,k);
			}
			else if(direct.get(i-1).equals("Right")){
				int k = length.get(i).intValue()*250;
				myFinch.setWheelVelocities(-250,-250,k);
			}
			else if(direct.get(i-1).equals("Back")){
				myFinch.setWheelVelocities(-250, -250,200);
				myFinch.setWheelVelocities(-250, 250,500);
				int k = length.get(i).intValue()*250;
				myFinch.setWheelVelocities(250, 250,k);
			}
			else{
			myFinch.setWheelVelocities(-250, 250,500);
			int k = length.get(i).intValue()*250;
			myFinch.setWheelVelocities(250, 250,k);
			}
			}
			else if(direct.get(i).equals("Right")){
			if(direct.get(i-1).equals("Left")){
				currentstate.add("Back");
				int k = length.get(i).intValue()*250;
				myFinch.setWheelVelocities(-250,-250,k);
			}
			else if(direct.get(i-1).equals("Right")){
				currentstate.add("Straight");
				int k = length.get(i).intValue()*250;
				myFinch.setWheelVelocities(250,250,k);
			}
			else if(direct.get(i-1).equals("Back")){
				currentstate.add("Straight");
				myFinch.setWheelVelocities(250, -250,500);
				int k = length.get(i).intValue()*250;
				myFinch.setWheelVelocities(250, 250,k);
			}
			else{
			currentstate.add("Right");
			myFinch.setWheelVelocities(250,-250,500);
			int k = length.get(i).intValue()*250;
			myFinch.setWheelVelocities(250, 250,k);
			}
		
		}
			i++;
		
		}
		
	}

}
