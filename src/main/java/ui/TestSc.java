package ui;

import java.awt.EventQueue;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import com.toedter.calendar.JDateChooser;
import keeptoo.KGradientPanel;
import java.awt.Color;

public class TestSc extends JFrame implements PropertyChangeListener {

	private JPanel contentPane;
	private JDateChooser dateChooser;
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TestSc frame = new TestSc();
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
	public TestSc() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 858, 514);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		dateChooser = new JDateChooser();
		dateChooser.setDateFormatString("dd-MM-yyyy");
		dateChooser.setBounds(379, 55, 248, 50);
		dateChooser.setDate(Calendar.getInstance().getTime());
		contentPane.add(dateChooser);

		textField = new JTextField();
		textField.setBounds(110, 37, 171, 68);
		contentPane.add(textField);
		textField.setColumns(10);
		dateChooser.addPropertyChangeListener(this);
		SimpleDateFormat df = new SimpleDateFormat("dd-MM-yyyy");
		textField.setText(df.format(dateChooser.getDate()));
		
		KGradientPanel gradientPanel = new KGradientPanel();
		gradientPanel.kEndColor = new Color(102, 153, 255);
		gradientPanel.setkStartColor(new Color(186, 24, 27));
		gradientPanel.setkEndColor(new Color(247, 178, 103));
		gradientPanel.setBounds(65, 167, 676, 100);
		contentPane.add(gradientPanel);

	}

	@Override
	public void propertyChange(PropertyChangeEvent evt) {
		SimpleDateFormat df = new SimpleDateFormat("dd-MM-yyyy");
		textField.setText(df.format(dateChooser.getDate()));
	}
}
