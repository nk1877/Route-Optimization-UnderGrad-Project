package SecondRobo;

import java.io.IOException;


public class robo2main {

	/**
	 * @param args
	 * @throws IOException 
	 */
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		//once server and client classes are executed, next run this class, else last shortest route will be followed
		StringConverter z= new StringConverter();
		RoboFollows my = new RoboFollows();
		z.getdir();
		my.finchfollow(z.length(), z.motion());

	}

}
