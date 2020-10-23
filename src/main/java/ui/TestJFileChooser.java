package ui;

import java.awt.Component;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.File;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.border.EmptyBorder;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.awt.Color;

public class TestJFileChooser extends JFrame implements ActionListener, MouseListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JLabel lblImg;
	private JPanel pnlImg;
	private JButton btnChon;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TestJFileChooser frame = new TestJFileChooser();
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
	public TestJFileChooser() {
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setBounds(100, 100, 900, 600);
		getContentPane().setLayout(new BoxLayout(getContentPane(), BoxLayout.X_AXIS));

		Box verticalBox = Box.createVerticalBox();
		getContentPane().add(verticalBox);

		Box horizontalBox = Box.createHorizontalBox();
		verticalBox.add(horizontalBox);

		Component horizontalGlue = Box.createHorizontalGlue();
		horizontalBox.add(horizontalGlue);

		btnChon = new JButton("Chọn tệp");
		btnChon.setBackground(Color.WHITE);
		horizontalBox.add(btnChon);

		Component horizontalGlue_1 = Box.createHorizontalGlue();
		horizontalBox.add(horizontalGlue_1);

		Component rigidArea = Box.createRigidArea(new Dimension(20, 20));
		verticalBox.add(rigidArea);

		Box horizontalBox_1 = Box.createHorizontalBox();
		verticalBox.add(horizontalBox_1);

		pnlImg = new JPanel();
		pnlImg.setPreferredSize(new Dimension(900, 500));
		horizontalBox_1.add(pnlImg);
		pnlImg.setLayout(new BoxLayout(pnlImg, BoxLayout.X_AXIS));

		lblImg = new JLabel("");
		lblImg.setMaximumSize(new Dimension(37217, 37217));
//		lblImg.setMaximumSize(pnlImg.getMaximumSize());
		lblImg.setPreferredSize(new Dimension(900, 500));
		pnlImg.add(lblImg);

		Component verticalGlue = Box.createVerticalGlue();
		verticalBox.add(verticalGlue);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
//		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		btnChon.addActionListener(this);
		btnChon.addMouseListener(this);

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub

		try {
			UIManager.setLookAndFeel("com.sun.java.swing.plaf.nimbus.NimbusLookAndFeel");
			JFileChooser fileChooser = new JFileChooser();

			FileNameExtensionFilter imgFilter = new FileNameExtensionFilter("jpg", "png", "jpg");
			fileChooser.setFileFilter(imgFilter);
			fileChooser.setMultiSelectionEnabled(false);
			
			int x = fileChooser.showDialog(this, "Open");
			if (x == JFileChooser.APPROVE_OPTION) {
				File f = fileChooser.getSelectedFile();
				lblImg.setIcon(new ImageIcon(
						new ImageIcon(f.getAbsolutePath()).getImage().getScaledInstance(pnlImg.getWidth(), pnlImg.getHeight(), Image.SCALE_DEFAULT)));
			}
		} catch (ClassNotFoundException | InstantiationException | IllegalAccessException
				| UnsupportedLookAndFeelException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		btnChon.setBackground(Color.CYAN);
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
	}
}
