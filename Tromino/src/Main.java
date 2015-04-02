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

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JPanel;


public class Main extends JFrame implements ActionListener
{
	private JButton solveButton;
	private String[] selectionBoxStrings = {"8x8", "16x16", "24x24", "32x32"};
	
	public static void main(String[] args)
	{
		Main myMain = new Main();
		myMain.setVisible(true);
		
	}
	public Main()
	{
		setSize(300,300); 
		
		//Create Container with contentPane so we can use BorderLayout.
		Container contentPane = getContentPane();
		contentPane.setLayout(new BorderLayout());
		
		JPanel panel = new JPanel();
		panel.setLayout(new FlowLayout());
		
		//Create combo box for selection of size of Tromino. 
		JComboBox mySelectionBox = new JComboBox(selectionBoxStrings);
		mySelectionBox.setSelectedIndex(0);
		mySelectionBox.addActionListener(this);
		
		//Create the solve button.
		solveButton = new JButton("Solve");
		
		panel.add(mySelectionBox, FlowLayout.LEFT);
		panel.add(solveButton, FlowLayout.CENTER);
		
		
		
		contentPane.add(new BlackAndWhiteBoard(), BorderLayout.CENTER);
		contentPane.add(panel, BorderLayout.NORTH);
		
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		setVisible(true);
	}
	public class BlackAndWhiteBoard extends JPanel
	{
		public BlackAndWhiteBoard()
		{
			int index = 0;
			setLayout(new GridBagLayout());
			GridBagConstraints gbc = new GridBagConstraints();
			for(int row = 0; row < 8; row++)
			{
				for(int col = 0; col < 8; col++)
				{
					Color myColor = index % 2 == 0 ? Color.BLACK : Color.WHITE;
					gbc.gridx = col;
					gbc.gridy = row;
					add(new Cell(myColor), gbc);
					index++;
				}
				index++;
			}
		}
	}
	
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

	@Override
	public void actionPerformed(ActionEvent e) {
		JComboBox mySelectionBox = (JComboBox) e.getSource();
		String mySelectionString = (String) mySelectionBox.getSelectedItem();
		
	}

}
