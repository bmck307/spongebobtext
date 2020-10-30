package spongebob;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class spongebob {

	@SuppressWarnings("deprecation")
	public static void main(String[] args) {
		JFrame frame = new JFrame("Spongebob");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JPanel panel = new JPanel();
		
		JLabel title = new JLabel("Put the words in that you want to be put into Spongebob meme text:");
		JTextArea user_input = new JTextArea(5, 40);
		
		JButton button = new JButton("Compile");
		
		button.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent ae)
            {
            	String user_input_string = user_input.getText();
            	user_input_string = spongebobText(user_input_string);
            	JTextArea response = new JTextArea(user_input_string);
            	panel.add(response);
            	frame.add(panel);
            	frame.show();
            }
        });
		panel.add(title);
		panel.add(new JScrollPane(user_input, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, 
				JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS));
		panel.add(button);
		
		panel.setLayout(new GridLayout(4,1));
		
		frame.add(panel);
		
		frame.setSize(600,600);
		frame.show();
	}
	
	public static String spongebobText(String user_input)
	{
		String spongebob = "";
		boolean previous_capital = true;
		for(int i = 0; i < user_input.length(); ++i)
		{
			char j = user_input.charAt(i);
			if (j == ' ' | j == '.' | j == '!' | j == '?')
			{
				spongebob += j;
			}
			else if (previous_capital)
			{
				spongebob += j;
				previous_capital = false;
			}
			else
			{
				if (j >= 65 && j <= 90)
				{
					spongebob += (char)(j + 32);
				}
				else if (j >= 97 && j <= 122)
				{
					spongebob += (char)(j - 32);
				}
				else 
				{
					spongebob += j;
				}
				
				previous_capital = true;
			}
		}
		return spongebob;
	}

}
