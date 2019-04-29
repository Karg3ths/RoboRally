package tmxLoader;
 /**
  * list of all possible robot types; 
  */
public enum ROBOT {
	  ROBOT1("/Layout/Tiles/robotPlayer.png"), 
	  ROBOT2("/Layout/Tiles/robotAI.png"), 
	  ROBOT3("/Layout/Tiles/robotAI2.png"), 
	  ROBOT4("/Layout/Tiles/robotAI3.png");
	  
	private  String urlRobot;
	
	private ROBOT(String urlRobot) {
		this.urlRobot = urlRobot;
	}
	
	public String getUrl() {
		return this.urlRobot;
	}
}
