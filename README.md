B.3	Running Program Instruction
Please make sure you have imported all the correct Finch libraries before running the project. Check running finch instructions at http://www.finchrobot.com.
For making finch explore new paths and collect data.
•	Run ACO main class and finch will start exploring.
•	Once finch ran enough time to collect travel data go back to ACO main class and uncomment following codes
	o	ScanningRoutes k = new ScanningRoutes();	
	o	k.getdir();	
	o	k.sumofdistance(); 
•	Now comment out the following code and run the program.	
	o	path p = new path();	
	o	p.start();
•	Once program writes the shortest distance file in the computer run server 	class from server package.
•	While server class running, run client file.
•	Next go to second robo package and run robo2main class and finch will just 	follow the shortest route.
