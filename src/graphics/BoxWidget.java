package graphics;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.util.ArrayList;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

import data.BoxNode;
import data.Datahandler;
import data.MyQueue;
import data.algo1;

public class BoxWidget extends JFrame {

	private JTextArea textArea;

	private JScrollPane pane;

	protected String datapath;
	
	protected Datahandler Datahandler;
	
	private JLabel imageLabel;

	public BoxWidget(String title) {
		super(title); // TODO Har olle detta?
		this.setLayout(new BoxLayout(this.getContentPane(), BoxLayout.Y_AXIS));

		createImageBox();

		createButtBox();

		createTextPanel();

		this.pack();
		this.setVisible(true);
	}

	private void createTextPanel() {
		Box b = new Box(BoxLayout.X_AXIS);
		textArea = new JTextArea();
		pane = new JScrollPane(textArea, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
				JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		pane.setPreferredSize(new Dimension(0, 100));
		b.add(pane);
		this.add(b);

	}

	private void createButtBox() {

		Box b = new Box(BoxLayout.X_AXIS);

		createOpenButton(b);
		createAlgorithmButtons(b);

		this.add(b);

	}

	private void createAlgorithmButtons(Box b) {

		JButton buttonAlgo1 = new JButton("Algo1");
		buttonAlgo1.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				
				algo1 solver1 = new algo1(Datahandler.getDataTree());
				
				MyQueue<ArrayList<BoxNode>> sortedQueue = solver1.returnSortedQueue();
				
				print(sortedQueue);

			}
		});
		JButton buttonAlgo2 = new JButton("Algo2");
		buttonAlgo2.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub

			}
		});
		JButton buttonAlgo3 = new JButton("Algo3");
		buttonAlgo3.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub

			}
		});

		b.add(buttonAlgo1);
		b.add(buttonAlgo2);
		b.add(buttonAlgo3);

	}
	
	private void print(MyQueue<ArrayList<BoxNode>> printQueue){
		
		System.out.println("Boxarna ska tas av i följande ordning: ");
		
		for(int i=0; i<printQueue.size();i++){
			
			ArrayList<BoxNode> boxesToPrint = printQueue.dequeue();
			
			System.out.println("I omgång " + (i+1) + " ska dessa lådor tas bort: ");
			
			for(int j=0; j<boxesToPrint.size(); j++) {
				
				System.out.println(boxesToPrint.get(j).getBoxName());
				
			}
			
		}
		
	}

	private void createOpenButton(Box b) {
		JButton buttonOpen = new JButton("Öppna");

		buttonOpen.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				datapath = getDataPath();
				
				if (datapath != null) {

					String imagepath = datapath.replaceAll("txt", "gif");
					ImageIcon icon = new ImageIcon(imagepath);
					imageLabel.setIcon(icon);
					imageLabel.setText("");


				Datahandler = new Datahandler(datapath);

				textArea.setText("Välj en algoritm");

			}

		}});

		b.add(buttonOpen);

	}

	private String getDataPath() {

		JFileChooser chooser = new JFileChooser("./boxconfigs");
		int abortOrOpen = chooser.showOpenDialog(this);

		if (JFileChooser.CANCEL_OPTION == abortOrOpen) {

			textArea.setText("Ingen fil valdes, testa igen");
			return null;

		} else {

			return chooser.getSelectedFile().getPath();

		}

	}

	private void createImageBox() {

		imageLabel = new JLabel("Öppna en lådfil");
		Box b = new Box(BoxLayout.X_AXIS);
		b.setPreferredSize(new Dimension(800, 400));
		this.add(b);

		b.add(imageLabel);
		this.add(Box.createVerticalGlue());

	}

}
