package hust.soict.hedspi.swing;
import java.awt.*;
import java.awt.event.*;

public class AWTAccumulator extends Frame{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private TextField tfInput;
	private TextField tfOutput;
	private int sum = 0;
	
	public AWTAccumulator() {
		// TODO Auto-generated constructor stub
		setLayout(new GridLayout(2, 2));
		
		add(new Label("Enter an integer: "));
		
		tfInput = new TextField(10);
		add(tfInput);
		tfInput.addActionListener(new TFInputListener());
		
		add(new Label("The accumulated sum is: "));
		
		tfOutput = new TextField(10);
		tfOutput.setEditable(false);
		add(tfOutput);
		
		setTitle("AWT Calculator");
		setSize(350, 120);
		setVisible(true);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new AWTAccumulator();
	}

	private class TFInputListener implements ActionListener{
		
		public void actionPerformed(ActionEvent evt){
			int numberIn = Integer.parseInt(tfInput.getText());
			sum += numberIn;
			tfInput.setText("");
			tfOutput.setText(sum + "");
		}
	}
}
