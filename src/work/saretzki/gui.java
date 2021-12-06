package work.saretzki;

import java.awt.Color;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;




public class gui extends JFrame{
	private JLabel p1,p2,p3,p1c;
	private JButton p1B,p2B,p3B,p1CB;
	private Font font = new Font("Segoe Ui", Font.PLAIN, 20);
	public gui() {

		setUndecorated(false);
		setVisible(true);
		setSize(370, 110);
		setResizable(false);
		setLayout(null);
		setAlwaysOnTop(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		getContentPane().setBackground(Color.WHITE);
		setTitle("Printer");
		setSize(370 + getInsets().left + getInsets().right, 110 + getInsets().bottom + getInsets().top);
		setLocation(Toolkit.getDefaultToolkit().getScreenSize().width-(370+getInsets().left + getInsets().right), Toolkit.getDefaultToolkit().getScreenSize().height-(150+getInsets().bottom + getInsets().top));
		p1=new JLabel("Drucker 224SW: "+main.p1.getD());
		p1.setBounds(10, 5, 170, 20);
		p1.setFont(font);
		add(p1);
		p1c=new JLabel("Drucker 224C: "+main.p1.getDC());
		p1c.setBounds(10, 30, 170, 20);
		p1c.setFont(font);
		add(p1c);
		p2=new JLabel("Drucker 220: "+main.p2.getD());
		p2.setBounds(10, 60, 170, 20);
		p2.setFont(font);
		add(p2);
		p3=new JLabel("Drucker 552: "+main.p3.getD());
		p3.setBounds(10, 85, 170, 20);
		p3.setFont(font);
		add(p3);
		
		p1B=new JButton("Reset");
		p1B.setBounds(265, 5, 100, 20);
		p1B.addActionListener(new p1BH());
		add(p1B);
		p1CB=new JButton("Reset");
		p1CB.setBounds(265, 30, 100, 20);
		p1CB.addActionListener(new p1CBH());
		add(p1CB);
		p2B=new JButton("Reset");
		p2B.setBounds(265, 60, 100, 20);
		p2B.addActionListener(new p2BH());
		add(p2B);
		p3B=new JButton("Reset");
		p3B.setBounds(265, 85, 100, 20);
		p3B.addActionListener(new p3BH());
		add(p3B);
		
		
		
		repaint();
	}
	public void re() {
		p1.setText("Drucker 224SW: "+main.p1.getD());
		p1c.setText("Drucker 224C: "+main.p1.getDC());
		p2.setText("Drucker 220: "+main.p2.getD());
		p3.setText("Drucker 552: "+main.p3.getD());
	}
	
	
	
	private class p1BH implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent e) {
			main.p1.reset();
			re();
		}
	}
	private class p1CBH implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent e) {
			main.p1.resetC();
			re();
		}
	}
	private class p2BH implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent e) {
			main.p2.reset();
			re();
		}
	}
	private class p3BH implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent e) {
			main.p3.reset();
			re();
		}
	}
}
