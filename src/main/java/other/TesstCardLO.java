package other;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.CardLayout;
import java.awt.Color;
import javax.swing.JButton;
import javax.swing.JTextField;
import keeptoo.KGradientPanel;

public class TesstCardLO extends JFrame implements ActionListener{

	private JPanel contentPane;
	private JTextField txtXanh;
	private JTextField txtCam;
	private JPanel xanh;
	private JPanel cam;
	private JButton btnCam;
	private JButton btnXanh;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TesstCardLO frame = new TesstCardLO();
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
	public TesstCardLO() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 949, 464);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel Contain = new JPanel();
		Contain.setBounds(165, 74, 475, 243);
		contentPane.add(Contain);
		Contain.setLayout(new CardLayout(0, 0));
		
		 cam = new JPanel();
		cam.setBackground(Color.ORANGE);
		Contain.add(cam, "name_524256573540400");
		cam.setLayout(null);
		
		txtCam = new JTextField();
		txtCam.setBounds(205, 127, 116, 22);
		cam.add(txtCam);
		txtCam.setColumns(10);
		
		btnCam = new JButton("Chuyển panel");
		btnCam.setBounds(86, 27, 156, 25);
		cam.add(btnCam);
		
		 xanh = new JPanel();
		xanh.setBackground(Color.GREEN);
		Contain.add(xanh, "name_524260312044500");
		xanh.setLayout(null);
		
		txtXanh = new JTextField();
		txtXanh.setBounds(146, 102, 116, 22);
		xanh.add(txtXanh);
		txtXanh.setColumns(10);
		
		btnXanh = new JButton("Chuyển panel");
		btnXanh.setBounds(86, 27, 156, 25);
		xanh.add(btnXanh);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.GREEN);
		panel.setBounds(711, 92, 137, 178);
		contentPane.add(panel);
		cam.setVisible(false);
		btnCam.addActionListener(this);
		btnXanh.addActionListener(this);
		
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(cam.isVisible()) {
			cam.setVisible(false);
			txtXanh.setText(txtCam.getText().trim());
			xanh.setVisible(true);
		}else {
			cam.setVisible(true);
			txtCam.setText(txtXanh.getText().trim());
			xanh.setVisible(false);
		}
	}
}
