import java.awt.*;
import javax.swing.*;
import java.awt.Graphics;
import java.awt.Font;
import java.awt.Color;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Test extends Canvas implements ActionListener {
    
	static JFrame frame;
    static JPanel panel;
    static JLabel label;
	
	Test() {
		frame = new JFrame("SIMPLEX");
		frame.getContentPane().setBackground(new Color(130, 209, 121));
		frame.setBounds(500, 200, 0, 0);
		frame.setResizable(false);
	//	panel = new JPanel();
		JButton button = new JButton("DECIDE");
		//JPanel buttonPane = new JPanel();
		//button.addActionListener(this);
	//	panel.setBounds(0, 50, 550, 160);

		//buttonPane.add(button);
		button.setBounds(195,350 , 120, 35);
		//button.setPreferredSize(new Dimension(120, 35));
		button.setFont(new Font("Anton", Font.PLAIN, 20));

		//frame.add(buttonPane, BorderLayout.SOUTH);
		//frame.pack();
		//frame.setLocationRelativeTo(null);
		frame.add(button);
	//	frame.add(panel);
		frame.setLayout(new BorderLayout());
		frame.add(this, BorderLayout.CENTER);
		//panel.add(buttonPane, BorderLayout.SOUTH);
		frame.setSize(560, 650);
		frame.setLayout(null);
		frame.setVisible(true);
	}
    public static void main(String[] args) {
		new Test();
 	}

	public void paint(Graphics g) {
		g.setFont(new Font(Font.SANS_SERIF, Font.ITALIC, 14));
		g.setColor(Color.ORANGE);
		g.drawString("SIMPLEX", 200, 200);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
	}
}