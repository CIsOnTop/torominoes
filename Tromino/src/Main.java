import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Panel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.AbstractAction;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JPanel;


public class Main extends JFrame implements ActionListener
{
	private JButton solveButton;
	private String[] selectionBoxStrings = {"Select Size", "8x8", "16x16", "24x24", "32x32"};
	private JComboBox mySelectionBox;
	private Container contentPane;
	private JPanel panel;
	
	public static void main(String[] args)
	{
		Main myMain = new Main();
		myMain.setVisible(true);
		
	}
	public Main()
	{
		 
		setSize(150, 70);
		//Create Container with contentPane so we can use BorderLayout.
		contentPane = getContentPane();
		contentPane.setLayout(new BorderLayout());
		
		panel = new JPanel();
		panel.setLayout(new FlowLayout());
		
		//Create combo box for selection of size of Tromino. 
		 mySelectionBox = new JComboBox(selectionBoxStrings);
		mySelectionBox.setSelectedIndex(0);
		mySelectionBox.addActionListener(this);
		
		//Create the solve button.
		solveButton = new JButton(new AbstractAction("Solve"){
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				System.out.println("Need to add solving method to this function");
				
			}
		});
		
		
		panel.add(mySelectionBox, FlowLayout.LEFT);
		panel.add(solveButton, FlowLayout.CENTER);
		
		contentPane.add(panel, BorderLayout.NORTH);
		
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		setVisible(true);
	}
	/**
	 * Method creates the Grey and Black board dependent on the size which is passed in through the method call in actionPreformed.
	 * @author ChristianValderrama
	 *
	 */
	public class GreyAndBlackBoard extends JPanel
	{
		public GreyAndBlackBoard(int size)
		{
			int index = 0;
			setLayout(new GridBagLayout());
			GridBagConstraints gbc = new GridBagConstraints();
			for(int row = 0; row < size; row++)
			{
				for(int col = 0; col < size; col++)
				{
					Color myColor = index % 2 == 0 ? Color.GRAY : Color.BLACK;
					gbc.gridx = col;
					gbc.gridy = row;
					add(new Cell(myColor), gbc);
					index++;
				}
				index++;
			}
		}
	}
	/**
	 * Method creates the cells in the center box with the colors from the GreyAndBlackBoard. 
	 * @author ChristianValderrama
	 *
	 */
	public class Cell extends JButton 
	{
		public Cell(Color background)
		{
		setContentAreaFilled(false);
		setBorderPainted(false);
		setBackground(background);
		setOpaque(true);
		}
		
		@Override
		public Dimension getPreferredSize()
		{
			return new Dimension(25, 25);
		}
		
	}
	/**
	 * Method is used to handle the Action events of the Combo Box.
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		JComboBox mySelectionBox = (JComboBox) e.getSource();
		String mySelectionString = (String) mySelectionBox.getSelectedItem();
		
		//If user selects 8x8 in combo box.
		if(mySelectionBox.getSelectedIndex() == 1)
		{
			//System.out.println("Is it getting here?");
			contentPane.removeAll();
			contentPane.add(new GreyAndBlackBoard(8), BorderLayout.CENTER);
			contentPane.add(panel, BorderLayout.NORTH);
			setSize(300,300);
			contentPane.validate();
			setLocationRelativeTo(null);
			validate();
		}
		//If user selects 16x16 in combo box.
		if(mySelectionBox.getSelectedIndex() == 2)
		{
			contentPane.removeAll();
			contentPane.add(new GreyAndBlackBoard(16), BorderLayout.CENTER);
			contentPane.add(panel, BorderLayout.NORTH);
			setSize(500,500);
			contentPane.validate();
			setLocationRelativeTo(null);
			validate();
		}
		//If user selects 24x24 in combo box.
		if(mySelectionBox.getSelectedIndex() == 3)
		{
			contentPane.removeAll();
			contentPane.add(new GreyAndBlackBoard(24), BorderLayout.CENTER);
			contentPane.add(panel, BorderLayout.NORTH);
			setSize(700,700);
			contentPane.validate();
			setLocationRelativeTo(null);
			validate();
		}
		//If the user selects 32x32 in combo box. 
		if(mySelectionBox.getSelectedIndex() == 4)
		{
			contentPane.removeAll();
			contentPane.add(new GreyAndBlackBoard(32), BorderLayout.CENTER);
			contentPane.add(panel, BorderLayout.NORTH);
			setSize(900,900);
			contentPane.validate();
			setLocationRelativeTo(null);
			validate();
		}
		
		
	}

}
