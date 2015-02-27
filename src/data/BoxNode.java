package data;

import java.util.TreeMap;

public class BoxNode {
	
	private String boxName;
	
	private int amountOfWorkers;
	
	/**
	 * All the boxes that is under the Box
	 */

	private TreeMap<String, BoxNode> BoxesBelow = new TreeMap<String, BoxNode>();

	/**
	 * All the boxes that is above the Box
	 */
	private TreeMap<String, BoxNode> BoxesAbove = new TreeMap<String, BoxNode>();

	public BoxNode(String boxName, int weight) {
		
		this.boxName = boxName;
		this.amountOfWorkers = weight;
		
	}

	public TreeMap<String, BoxNode> getBoxesBelow() {
		return BoxesBelow;
	}

	public void setBoxesBelow(TreeMap<String, BoxNode> boxesBelow) {
		BoxesBelow = boxesBelow;
	}

	public TreeMap<String, BoxNode> getBoxesAbove() {
		return BoxesAbove;
	}

	public void setBoxesAbove(TreeMap<String, BoxNode> boxesAbove) {
		BoxesAbove = boxesAbove;
	}

	public String getBoxName() {
		return boxName;
	}

	public void setBoxName(String boxName) {
		this.boxName = boxName;
	}

	public void printBoxNode() {

		// prints the box
		System.out.print("Boxens namn: " + boxName + " ");
		System.out.println(amountOfWorkers);

		// prints the boxes underneath the box
		System.out.println("Lådor som boxen står på: ");
		if (BoxesBelow.size() == 0) {
			System.out.println("Inga");
		} else {
			
			for (BoxNode b : BoxesBelow.values()) {
				System.out.print("Boxens namn: " + b.boxName + " ");
				System.out.println(b.amountOfWorkers);
			}
		}

		// prints the boxes above the box
		System.out.println("Lådor som boxen står under: ");
		if (BoxesAbove.size() == 0) {
			System.out.println("Inga");
		} else {
			for (BoxNode b : BoxesAbove.values()) {
				System.out.print("Boxens namn: " + b.boxName + " ");
				System.out.println(b.amountOfWorkers);
			}
		}

	}

}
