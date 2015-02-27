package data;

import java.util.ArrayList;
import java.util.TreeMap;

public class algo1 {

	private TreeMap<String, BoxNode> dataTree;

	private int numberOfRemovedBoxes;

	private int availableWorkers;

	private int originalTreeSize;

	public algo1(TreeMap<String, BoxNode> boxes) {

		this.dataTree = boxes;

		numberOfRemovedBoxes = 0;

		availableWorkers = 15;

		originalTreeSize = dataTree.size();

	}

	public MyQueue<ArrayList<BoxNode>> returnSortedQueue() {

		MyQueue<ArrayList<BoxNode>> sortedQueue = new MyQueue<ArrayList<BoxNode>>();

		ArrayList<BoxNode> availableToRemove = new ArrayList<BoxNode>();

		availableToRemove = initializeAvailableToRemove();

		// for(int i=0; i<=availableToRemove.size()-1; i++){
		//
		// availableToRemove.get(i).printBoxNode();
		//
		// }

		while (numberOfRemovedBoxes < originalTreeSize) {

			sortedQueue.enqueue(availableToRemove);

			availableToRemove = removeAndUpdate(availableToRemove);

			 for(int i=0; i<=availableToRemove.size()-1; i++){
			
			 availableToRemove.get(i).printBoxNode();
			
			 }

		}
		return sortedQueue;
	}

	private ArrayList<BoxNode> removeAndUpdate(
			ArrayList<BoxNode> availableToRemove) {

		ArrayList<BoxNode> newAvailableToRemove = new ArrayList<BoxNode>();

		for (int i = 0; i <= availableToRemove.size() - 1; i++) {

			dataTree.remove(availableToRemove.get(i).getBoxName());
			numberOfRemovedBoxes++;

			for (BoxNode b : availableToRemove.get(i).getBoxesBelow().values()) {

				if (dataTree.get(b.getBoxName()).getBoxesAbove()
						.containsKey(availableToRemove.get(i).getBoxName()) == true) {

					dataTree.get(b.getBoxName()).getBoxesAbove()
							.remove(availableToRemove.get(i).getBoxName());

				}

				if (dataTree.get(b.getBoxName()).getBoxesAbove().size() == 0) {

					newAvailableToRemove.add(dataTree.get(b.getBoxName()));

				}

			}
		}

		return newAvailableToRemove;
	}

	private ArrayList<BoxNode> initializeAvailableToRemove() {

		ArrayList<BoxNode> availableToRemove = new ArrayList<BoxNode>();

		// Checks all the boxnodes and adds those who have no above
		for (BoxNode b : dataTree.values()) {

			if (b.getBoxesAbove().size() == 0) {

				availableToRemove.add(b);

			}

		}
		return availableToRemove;

	}

}
