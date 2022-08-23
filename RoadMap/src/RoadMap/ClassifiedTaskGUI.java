package RoadMap;

import java.awt.Color;

public class ClassifiedTaskGUI extends TaskGUI {
 // (background, boarder
	private static final Color[][] COLOR_SCHEME = {
			{new Color(177,221,161), new Color(102, 141, 60)},  
			{new Color(255, 134, 66), new Color(196, 54, 44)},
			{new Color(0, 151, 172), new Color(6, 194, 244)},
			{new Color(129, 108, 91), new Color(195, 183, 172)}
	};
	
	private int type;
	private int prio;
	
	public ClassifiedTaskGUI(int width, int height, String title, String desc, int type, int prio) {
		super(width, height, title, desc, COLOR_SCHEME[type]);
		this.type = type;
		this.prio = prio;
	}
	
	public String toString() {
		String s = String.valueOf(super.width) + " " + String.valueOf(super.height) + " \"" + title + "\" \"" + desc
				+ "\" " + String.valueOf(type) + " " + String.valueOf(prio) + " " + String.valueOf(super.percentage);
		return s;
	}
	
	public static Color[][] getColorScheme() {
		return COLOR_SCHEME;
	}
}
