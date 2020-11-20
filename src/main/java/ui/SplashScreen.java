package ui;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JProgressBar;
import javax.swing.border.EmptyBorder;

import keeptoo.KGradientPanel;

public class SplashScreen extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	public JLabel lblLoading;
	public JProgressBar progressBar;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SplashScreen frame = new SplashScreen();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 * @throws InterruptedException 
	 */
	public SplashScreen() {
		setUndecorated(true);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setBounds(100, 100, 858, 514);
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		KGradientPanel gradientPanel = new KGradientPanel();
		gradientPanel.kGradientFocus = 800;
		gradientPanel.setBackground(new Color(153, 102, 153));
		gradientPanel.kEndColor = new Color(102, 153, 255);
		gradientPanel.setkStartColor(new Color(255, 0, 0));
		gradientPanel.setkEndColor(new Color(0, 51, 255));
		gradientPanel.setBounds(0, 0, 858, 514);
		contentPane.add(gradientPanel);
		gradientPanel.setLayout(null);

		progressBar = new JProgressBar();
		progressBar.setForeground(new Color(255, 69, 0));
		progressBar.setBounds(39, 445, 787, 30);
		gradientPanel.add(progressBar);

		lblLoading = new JLabel("");
		lblLoading.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblLoading.setForeground(Color.WHITE);
		lblLoading.setBackground(Color.WHITE);
		lblLoading.setBounds(372, 384, 212, 48);
		gradientPanel.add(lblLoading);
		
	}
	public void name() {
		for(int i = 0; i<=100; i++) {
			try {
				Thread.sleep(20);
				this.setVisible(true);
				this.lblLoading.setText("Loading "+i+"%");
				this.progressBar.setValue(i);
				if(i==100)
					new App().setVisible(true);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		this.setVisible(false);
	}
	
}
