package simple;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class Example1 {

	public static void main(String[] args) {
		final int sreenwidth = 800;
		final int streenHeigth = 300;
		
		JFrame jf = new JFrame();
		jf.setSize(sreenwidth, streenHeigth);
		jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		Button button = new Button("PRESS ME");
//		button.addActionListener(new ActionListener() {
//			
//			@Override
//			public void actionPerformed(ActionEvent e) {
//				JOptionPane.showMessageDialog(null, "Hello");
//			}
//		});
		
		button.addActionListener(e->JOptionPane.showMessageDialog(null, "Hello"));
		
		BorderLayout layout = new BorderLayout();
		jf.getContentPane().setLayout(layout);
		jf.getContentPane().add(button, BorderLayout.CENTER);
		
		jf.setVisible(true);
		
	}
}
