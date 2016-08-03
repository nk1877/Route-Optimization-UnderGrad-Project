package ACO;
import edu.cmu.ri.createlab.terk.robot.finch.Finch;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Random;
public class path {
	double inipos = 0;
	private static final int WAITING = 0;
	private static final int GOBOY = 1;
	 private static final int NOWAY = 2;
	 private static final int RIGHT = 3;
	 private static final int LEFT = 4;
	// private static final int BACK=5;
	 private static final int OPENWAY = 5;
	 private static int state = GOBOY;
	 ArrayList<Double> pher = new ArrayList<Double>(); 
	 ArrayList<String>direction= new ArrayList<String>();
	 ArrayList<String>currentstate=new ArrayList<String>();
	
	public ArrayList<Double> start()
	{
		Finch myFinch = new Finch();
		long x=System.currentTimeMillis();
		pheromone hello = new pheromone();
		UpdateDirections update= new UpdateDirections();
		hello.startingval();
		//System.out.println("Hola");
		while(myFinch.isBeakUp()!=true) {
		switch(state){
		case NOWAY:
			if(myFinch.getLeftLightSensor()<5 && myFinch.getRightLightSensor()<5){state= WAITING;break;}
			currentstate.add("NOWAY");
		//	for(int i=0;i<myFinch.getLightSensors().length;i++){
				
			//}
			double nws=System.currentTimeMillis();
			System.out.println("No way reached");
			 // myFinch.setLED(250,0,250);
        	while(myFinch.isObstacleLeftSide()== true && myFinch.isObstacleRightSide()== true){
        		myFinch.setWheelVelocities(-250,-250);
        	}
        	double nwe=System.currentTimeMillis();
        	double dis3= (nwe-nws)/250;
        	pher.add(dis3);
        	System.out.println("entering update");
        	direction.add(update.update(direction,currentstate));
        	//getdir(direction);
        	hello.getdirection(direction);
        	recpath(pher);
        	hello.trialphero(pher,direction);
        	if(myFinch.getLeftLightSensor()<5 && myFinch.getRightLightSensor()<5){state= WAITING;}
        if(myFinch.isObstacle()== false){
        	state=OPENWAY;
        }
        else{
        	state=WAITING;
        }
         break;
		
		case RIGHT:
			if(myFinch.getLeftLightSensor()<5 && myFinch.getRightLightSensor()<5){state= WAITING;break;}
			currentstate.add("RIGHT");
			//for(int i=0;i<myFinch.getLightSensors().length;i++){
				
			//}
			long nls=System.currentTimeMillis();
			System.out.println("turn right reached");
           // myFinch.setLED(255,0,0);
			
			myFinch.setWheelVelocities(-250,-250, 200);
		
            myFinch.setWheelVelocities(150,-150, 500);
           // myFinch.buzz(440, 500);
            System.out.println(myFinch.isObstacleLeftSide());
            while(myFinch.isObstacleLeftSide()== false || myFinch.isObstacleRightSide()==false){
				//myFinch.setLED(255,255,0);
	            myFinch.setWheelVelocities(250,250);
			}
            double nle=System.currentTimeMillis();
            double dis2 = (nle-nls)/250;
            pher.add(dis2);
            direction.add(update.update(direction,currentstate));
            hello.getdirection(direction);
            recpath(pher);
            hello.trialphero(pher,direction);
            System.out.println("Leaving Now");
            if(myFinch.getLeftLightSensor()<5 && myFinch.getRightLightSensor()<5){state= WAITING;}
            
            state=WAITING;	
            
        	break;
        	
		case LEFT:
			if(myFinch.getLeftLightSensor()<5 && myFinch.getRightLightSensor()<5){state= WAITING;break;}
			currentstate.add("LEFT");
			//for(int i=0;i<myFinch.getLightSensors().length;i++){
			//}
			double nrs=System.currentTimeMillis();
			System.out.println("Left reached");
          //  myFinch.setLED(0,0,255);
			 myFinch.setWheelVelocities(-250,-250, 200);
            myFinch.setWheelVelocities(-150, 150, 500);   
            double nre=System.currentTimeMillis();
            double dis1 = (nre-nrs)/250;
            direction.add(update.update(direction,currentstate));
            pher.add(dis1);
            hello.getdirection(direction);
            recpath(pher);
            hello.trialphero(pher,direction);
            if(myFinch.getLeftLightSensor()<5 && myFinch.getRightLightSensor()<5){state= WAITING;break;}
                state=WAITING;	
                
        	
        break;
        // Else, robot goes straight, LED is green
		case GOBOY:
			if(myFinch.getLeftLightSensor()<5 && myFinch.getRightLightSensor()<5){state= WAITING;break;}
			currentstate.add("GOBOY");
			//for(int i=0;i<myFinch.getLightSensors().length;i++){
			
			//}
			System.out.println("BOY is in");
			double gbs=System.currentTimeMillis();
			while(myFinch.isObstacleLeftSide()== false || myFinch.isObstacleRightSide()==false){
				if(myFinch.getLeftLightSensor()<5 && myFinch.getRightLightSensor()<5){state= WAITING; break;}
				myFinch.setLED(255,255,0);
	            myFinch.setWheelVelocities(250,250);
				
			}
			
			double gbe=System.currentTimeMillis();
			double dis = (gbe-gbs)/250;
				pher.add(dis);
				if(direction.size()>0){
					direction.add(update.update(direction,currentstate));
					hello.getdirection(direction);
					recpath(pher);
					hello.trialphero(pher,direction);
				}
				else{
				direction.add("Straight");
				//getdir(direction);
				hello.getdirection(direction);
				recpath(pher);
				hello.trialphero(pher,direction);
				//System.out.println("move straight");
				}
				if(myFinch.getLeftLightSensor()<5 && myFinch.getRightLightSensor()<5){state= WAITING;}
				
				state= WAITING;
			
			//ArrayList<Long> pher = new ArrayList<Long>();
			
			break;
		
		case OPENWAY:
			System.out.println("Inside Openway");
			 if(myFinch.isObstacleLeftSide()== true && myFinch.isObstacleRightSide()== true) {
					state=NOWAY;
					System.out.println("Going for no way");
					}
			else if(myFinch.isObstacleRightSide()==true){
				  System.out.println("Leaving Now");
		              state=LEFT;
		         }
		         
		         else if(myFinch.isObstacleLeftSide()==true){
		        	 System.out.println("Leaving Now");  
		               state=RIGHT;
		            }
		        
		         else{System.out.println("Leaving Now"); state=WAITING;}
			break;
		case WAITING:
			if(myFinch.getLeftLightSensor()<5 && myFinch.getRightLightSensor()<5){
			//if(myFinch.isBeakDown()==true){
			try(PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("pheroall.txt", true)))) {
				   for(int i=0;i<direction.size();i++){
		        		if(i==direction.size()-1){
		        			 out.write(direction.get(i)+ ".");
		        		}
		        		else{
		                out.write(direction.get(i) + ",");}
		        	}
		        	out.write("/");
		        	for(int i=0;i<pher.size();i++){
		        		if(i==pher.size()-1){
		        			 out.write(pher.get(i)+ "+");
		        		}
		        		else{
		                out.write(pher.get(i) + ",");}
		        	}
		        	out.write("/");
			}catch (IOException e) {
			    //exception handling left as an exercise for the reader
			}
			myFinch.quit();
		     System.exit(0);
			break;
			}
			if(myFinch.isObstacle()==true){
				state=OPENWAY;
				System.out.println("Going for no left");
			}
		
			else{
				Random r2 = new Random();
				int coin = r2.nextInt(2);
				if(coin==0){
					int coin1 = r2.nextInt(2);
					if(coin1==0){
						state=LEFT;
					}
					else{
						state=RIGHT;
					}
				}
				else{
				state=GOBOY;
				System.out.println("boy is moving straight");
				}
			}
			
			System.out.println("now");
            break;
		}
		}
		long y=System.currentTimeMillis();
	      long z= (y-x)/250;
	      hello.trialphero(pher,direction);
	      System.out.println("Total Distance"+z);
	      System.out.println(direction.size()+" pher "+ pher.size());
	      
	    //  FinchClient p =new FinchClient();
	      
		return pher;
		}
	

	public ArrayList<Double> recpath(ArrayList<Double>route){
		
		System.out.println(route);
		return route;
	}

}