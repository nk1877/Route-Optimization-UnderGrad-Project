package SecondRobo;

import edu.cmu.ri.createlab.terk.robot.finch.Finch;

public class coordinatesystem {
	
	public void moveto(int x1,int y1,int x2,int y2){
		Finch myFinch= new Finch();
		StringConverter co = new StringConverter(); 
		if(co.ycoord().get(co.ycoord().size())>=0){
			myFinch.setWheelVelocities(250, 250, co.ycoord().get(co.ycoord().size()));
			
		}
		else if(co.ycoord().get(co.ycoord().size())<0){
			myFinch.setWheelVelocities(-250,-250, 200);
            myFinch.setWheelVelocities(-250, 250, 500); 
			myFinch.setWheelVelocities(250, 250, co.ycoord().get(co.ycoord().size()));
			
		}
		else if(co.xcoord().get(co.xcoord().size())>=0){
			myFinch.setWheelVelocities(250, 250, co.xcoord().get(co.xcoord().size()));
			}
		else if(co.ycoord().get(co.ycoord().size())<0){
			myFinch.setWheelVelocities(-250,-250, 200);
            myFinch.setWheelVelocities(-250, 250, 500); 
			myFinch.setWheelVelocities(250, 250, co.ycoord().get(co.ycoord().size()));
			
		}
		
	}

}
