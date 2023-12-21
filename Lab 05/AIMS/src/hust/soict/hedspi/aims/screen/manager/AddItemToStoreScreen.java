package hust.soict.hedspi.aims.screen.manager;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;


public class AddItemToStoreScreen extends JFrame{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTextField tfId;
	private JTextField tfCategory;
	private JTextField tfCost;
	private JTextField tfTitle;
	private JButton btnDone = new JButton("Add");
	private JButton btnCancel = new JButton("Cancel");
	
	
	public JTextField getTfId() {
		return tfId;
	}

	public JTextField getTfCategory() {
		return tfCategory;
	}

	public JTextField getTfCost() {
		return tfCost;
	}

	public JTextField getTfTitle() {
		return tfTitle;
	}

	public void setTfId(JTextField tfId) {
		this.tfId = tfId;
	}

	public void setTfCategory(JTextField tfCategory) {
		this.tfCategory = tfCategory;
	}

	public void setTfCost(JTextField tfCost) {
		this.tfCost = tfCost;
	}

	public void setTfTitle(JTextField tfTitle) {
		this.tfTitle = tfTitle;
	}

	public AddItemToStoreScreen() {
		Container cp = getContentPane();
		cp.setLayout(new GridLayout(5,2));
		cp.add(new JLabel("ID:"));
		tfId = new JTextField(10);
		cp.add(tfId);
		cp.add(new JLabel("Title:"));
		tfTitle = new JTextField(10);
		cp.add(tfTitle);
		cp.add(new JLabel("Category: "));
		tfCategory = new JTextField(10);
		cp.add(tfCategory);
		cp.add(new JLabel("Cost: "));
		tfCost = new JTextField(10);
		cp.add(tfCost);
		
		ButtonListener btnListener = new ButtonListener();
		cp.add(btnDone);
		btnDone.addActionListener(btnListener);
		cp.add(btnCancel);
		btnCancel.addActionListener(btnListener);
		
		setSize(512,384);
		setLocationRelativeTo(null);
		setVisible(true);
	}
	public void add() {
		
	}
	
public class ButtonListener implements ActionListener{
		
		public void actionPerformed(ActionEvent e) {
			String button = e.getActionCommand();
			if(button.equals("Cancel")) System.exit(0);
			else {
				add();
				System.exit(0);
			}
		}
	}
}
