package RoadMap;

public class TaskObject {

	protected String title;
	protected String desc;
	protected int percentage;
	
	
	
	public TaskObject(String title, String desc) {
		
		this.title = title;
		this.desc = desc;
		percentage = 0;
		
	}
	
	public String getTitle() {
		return title;
	}
	
	public String getDesc() {
		return desc;
	}
	
	public int getPercentage() {
		return percentage;
	}
	
	public void updatePercentage(int perc) {
		percentage += perc;
	}
	
}
