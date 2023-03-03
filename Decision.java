import java.awt.*;
import javax.swing.*;


import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


/* TO DO:
 * start menu(insertion of problem, with checkboxes for max, min)
 */


public class Decision implements ActionListener {

		JButton button;
		JFrame frame;
		Panel p;
		JPanel clearP;

		Decision() {

			frame = new JFrame("SIMPLEX");
			
			// set frame
			frame.setLayout(null);
			frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);			
			frame.setResizable(false);
			frame.setSize(new Dimension(560, 650));
			frame.setLocationRelativeTo(null);
			frame.getContentPane().setBackground(new Color(130, 209, 121)); // background color
			
			// create the panel & logo
			p = new Panel();
	
			p.setBounds(0,0,560, 650);

			// set a new panel for clearing the screen each time(without the components)
			clearP = new JPanel();
			clearP.setBounds(0,0,560, 650);
			clearP.setBackground(new Color(130, 209, 121));

			button = new JButton("DECIDE");

			// set decide button
			button.addActionListener(this);
			button.setBounds(200,375 , 125, 35);
			button.setFont(new Font("Anton", Font.PLAIN, 20));
			button.setFocusable(false);
			button.setBackground(Color.GRAY);
			button.setBorder(BorderFactory.createRaisedSoftBevelBorder());
			
			
			frame.add(button);
			
			frame.add(p);
			 
			frame.setVisible(true);
		}
		
		@Override
		public void actionPerformed(ActionEvent e) {
			if (e.getSource() == button) {
				frame.setContentPane(clearP);
				JLabel label = new JLabel();
				label.setText("Register your problem:");
				label.setBounds(140, 0, 301, 301);
				label.setFont(new Font("Arial", Font.PLAIN, 30));
				frame.add(label);
			}
		}

		class Panel extends JComponent {
			
			// logo(main screen)
			public void paint(Graphics g) {
				Graphics2D g2d = (Graphics2D) g;
				g2d.setFont(new Font(Font.MONOSPACED, Font.TRUETYPE_FONT, 100));
				g2d.setColor(Color.ORANGE);
				g2d.drawString("SIMPLEX", 65, 200);
			}
		}
		public static void main(String[] args) {
			new Decision();
		}
	
}
