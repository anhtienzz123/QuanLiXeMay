package ui;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.CardLayout;
import java.awt.Color;
import javax.swing.JTextField;

public class TestCardLayout extends JFrame implements ActionListener {

	private JPanel contentPane;
	private JButton btnNewButton;
	private JPanel panel;
	private JPanel panel_1;
	private JPanel panel_2;
	private JButton btnNewButton_1;
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TestCardLayout frame = new TestCardLayout();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public TestCardLayout() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 870, 517);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		btnNewButton = new JButton("New button");
		btnNewButton.setBounds(266, 34, 97, 25);
		contentPane.add(btnNewButton);

		panel = new JPanel();
		panel.setBounds(83, 97, 661, 255);
		contentPane.add(panel);
		panel.setLayout(new CardLayout(0, 0));

		panel_1 = new JPanel();
		panel_1.setBackground(Color.DARK_GRAY);
		panel.add(panel_1, "1");
		panel_1.setLayout(null);
		
		JButton btnNewButton_2 = new JButton("New button");
		btnNewButton_2.setBounds(303, 140, 97, 25);
		panel_1.add(btnNewButton_2);

		panel_2 = new JPanel();
		panel_2.setBackground(Color.MAGENTA);
		panel.add(panel_2, "2");
		panel_2.setLayout(null);
		
		textField = new JTextField();
		textField.setBounds(196, 83, 116, 22);
		panel_2.add(textField);
		textField.setColumns(10);
		
		btnNewButton_1 = new JButton("New button");
		btnNewButton_1.setBounds(392, 34, 97, 25);
		contentPane.add(btnNewButton_1);
		btnNewButton.addActionListener(this);
		btnNewButton_1.addActionListener(this);

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		CardLayout cardLayout = (CardLayout) panel.getLayout();
		Object o = e.getSource();
		if(o.equals(btnNewButton)) {
			panel.removeAll();
			panel.add(panel_1);
			panel.repaint();
			panel.invalidate();
		}
		else if (o.equals(btnNewButton_1)) {
			panel.removeAll();
			panel.add(panel_2);
			panel.repaint();
			panel.revalidate();
			}
	}
}
