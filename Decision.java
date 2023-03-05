import java.awt.*;
import javax.swing.*;


import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


/* TO DO:
 * make Textfields for each constraint 
 */


public class Decision {

    class Frame implements ActionListener {

        JButton button;
        JFrame frame;
        Panel p;
        JPanel clearP;

        Frame() {
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

        int vars;
        int consts;
        String of;

        @Override
		public void actionPerformed(ActionEvent e) {
            if (e.getSource() == button) {
                menu();
            } else if (e.getSource() == max) {
                isMax = true;
                mMbutton = true;
            } else if (e.getSource() == min) {
                isMax = false;
                mMbutton = true;
            } else if (e.getSource() == field1) {
                vars = Integer.valueOf(field1.getText());
                vButton = true;
                field1.setEnabled(false);
            } else if (e.getSource() == field2) { 
                consts = Integer.valueOf(field2.getText());
                cButton = true;
                field2.setEnabled(false);
            } else if (e.getSource() == field3) { 
                of = field3.getText();
                ofButton = true;
                field3.setEnabled(false);
            } else if (e.getSource() == continueButton) {
                Matrix m = new Matrix(vars, consts, of);

                m.fillMatrix();
                m.findSolution();
            }
            // check if all 3 boxed are filled
            if (mMbutton && vButton && cButton && ofButton) {
                continueButton.setEnabled(true);
            }
		}

        JRadioButton max;
        JRadioButton min;
        boolean isMax;
        boolean mMbutton;
        boolean vButton;
        boolean cButton;
        boolean ofButton;
        JTextField field1;
        JTextField field2;
        JTextField field3;
        JButton continueButton;
        // Menu(problem registration)
        public void menu() {
            frame.setContentPane(clearP);
            JLabel label = new JLabel();
            label.setText("Register your problem:");
            label.setBounds(140, 0, 301, 301);
            label.setFont(new Font("Arial", Font.PLAIN, 30));
            max = new JRadioButton("maximazation");
            min = new JRadioButton("minimazation(coming soon)");
            min.setEnabled(false); // currently unavailble
            max.setFocusable(false);
            min.setFocusable(false);
            max.setBounds(40, 250, 110, 20);
            min.setBounds(40, 280, 200, 20);
            max.setBackground(new Color(130, 209, 121));
            min.setBackground(new Color(130, 209, 121));
            max.addActionListener(this);
            min.addActionListener(this);
            ButtonGroup group = new ButtonGroup();
            group.add(max);
            group.add(min);
            field1 = new JTextField("how many variables?");
            field1.setBounds(400, 230, 140,30);
            field1.addActionListener(this);
            field2 = new JTextField("how many constraints?");
            field2.setBounds(400, 270, 140,30);
            field2.addActionListener(this);
            field3 = new JTextField("Objective Function");
            field3.setBounds(200, 340, 140, 30);
            field3.addActionListener(this);
            continueButton = new JButton("CONTINUE");
            continueButton.setBounds(200, 375, 140, 30);
            continueButton.setFont(new Font("Anton", Font.PLAIN, 20));
            continueButton.setFocusable(false);
            continueButton.setBackground(Color.GRAY);
            continueButton.setBorder(BorderFactory.createRaisedSoftBevelBorder());
            continueButton.setEnabled(false);
            continueButton.addActionListener(this);

            frame.add(max);
            frame.add(min);
            frame.add(label);
            frame.add(field1);
            frame.add(field2);
            frame.add(field3);
            frame.add(continueButton);

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
        new Decision().new Frame();
	}
	
}
