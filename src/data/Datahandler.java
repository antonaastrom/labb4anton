package data;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.TreeMap;

public class Datahandler {

	private String datapath;

	private int numberOfBoxes;
	
	private int numberOfStapledBoxes;

	private TreeMap<String, BoxNode> dataTree = new TreeMap<String, BoxNode>();

	public Datahandler(String datapath) {
		this.datapath = datapath;

		Scanner scandata = null;
		try {
			scandata = new Scanner(new File(datapath));
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		createBoxTree(scandata);
		
		mapTree(scandata);

	}

	private void mapTree(Scanner scandata) {
		
		numberOfStapledBoxes = scandata.nextInt();
		
		for (int i=0; i<numberOfStapledBoxes;i++) {
			
			String boxNameAbove = scandata.next();
			String boxNameBelow = scandata.next();
			
//			// Set the pointers for the above and under.. testing right now
			dataTree.get(boxNameAbove).getBoxesBelow().put(boxNameBelow, dataTree.get(boxNameBelow));
			dataTree.get(boxNameBelow).getBoxesAbove().put(boxNameAbove, dataTree.get(boxNameAbove));
			
		}
		
	}

	public TreeMap<String, BoxNode> getDataTree() {
		return dataTree;
	}

	public void setDataTree(TreeMap<String, BoxNode> dataTree) {
		this.dataTree = dataTree;
	}

	private void createBoxTree(Scanner scandata) {

		numberOfBoxes = scandata.nextInt();

		for (int i = 0; i < numberOfBoxes; i++) {

			String boxName = scandata.next();
			Integer boxWeight = scandata.nextInt();
			dataTree.put(boxName, new BoxNode(boxName, boxWeight));

		}

	}

}
