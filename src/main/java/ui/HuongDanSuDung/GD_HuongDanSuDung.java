package ui.HuongDanSuDung;

import java.awt.EventQueue;
import java.awt.Font;
import java.io.File;
import java.io.IOException;
import java.nio.file.Paths;

import javax.swing.JEditorPane;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTree;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.border.EmptyBorder;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;

import org.jfree.chart.servlet.ServletUtilities;

import java.awt.Color;
import javax.swing.JTextPane;
import javax.swing.JScrollPane;

public class GD_HuongDanSuDung extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GD_HuongDanSuDung frame = new GD_HuongDanSuDung();
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
	public GD_HuongDanSuDung() {
		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		} catch (ClassNotFoundException | InstantiationException | IllegalAccessException
				| UnsupportedLookAndFeelException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1140, 593);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JPanel panel = new JPanel();
		panel.setBackground(Color.PINK);
		panel.setBounds(0, 0, 300, 546);
		contentPane.add(panel);
		panel.setLayout(null);

		JTree tree = new JTree();
		tree.setRowHeight(25);
		tree.setFont(new Font("Tahoma", Font.PLAIN, 20));
		tree.setBounds(0, 0, 300, 546);
		panel.add(tree);

		JPanel panel_1 = new JPanel();
		panel_1.setBounds(299, 0, 823, 546);
		contentPane.add(panel_1);
		panel_1.setLayout(null);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(0, 0, 823, 546);
		panel_1.add(scrollPane);

		JEditorPane txtText;
//			txtText = new JEditorPane("https://economyandgrowth.herokuapp.com/");
			txtText = new JEditorPane();
			txtText.setContentType("text/html");
			txtText.setText("<!DOCTYPE html>\r\n" + 
					"<html>\r\n" + 
					"<head>\r\n" + 
					"	<title>Bài 7</title>\r\n" + 
					"</head>\r\n" + 
					"<body>\r\n" + 
					"	<p><img src='" +"file:/"+ Paths.get("Img/img7.png").toAbsolutePath()+ "' width=\"70\" height=\"70\" alt=\"img\">A smile is a facial expression formed primarily by flexing the muscles at the sides of the mouth. It is  believed it takes about 80 muscles to smile. Some smiles include a contraction of the muscles at the corner of the eyes, an action known as a \"Duchenne smile\". Smiles performed without the eye contraction may be perceived as insincere.</p>\r\n" + 
					"	<hr>\r\n" + 
					"	<p><img src='" +"file:/"+ Paths.get("Img/img7.png").toAbsolutePath()+ "' align=\"middle\" width=\"70\" height=\"70\" alt=\"img\">A smile is a facial expression formed primarily by flexing the muscles at the sides of the mouth. It is  believed it takes about 80 muscles to smile. Some smiles include a contraction of the muscles at the corner of the eyes, an action known as a \"Duchenne smile\". Smiles performed without the eye contraction may be perceived as insincere.</p>\r\n" + 
					"	<hr>\r\n" + 
					"	<p><img src='"+"file:/"+ Paths.get("Img/img7.png").toAbsolutePath()+"' align=\"top\" width=\"70\" height=\"70\" alt=\"img\">A smile is a facial expression formed primarily by flexing the muscles at the sides of the mouth. It is  believed it takes about 80 muscles to smile. Some smiles include a contraction of the muscles at the corner of the eyes, an action known as a \"Duchenne smile\". Smiles performed without the eye contraction may be perceived as insincere.</p>\r\n" + 
					"	<hr>\r\n" + 
					"	<img src='"+"file:/"+ Paths.get("Img/img7.png").toAbsolutePath()+"' align=\"right\" width=\"70\" height=\"70\" alt=\"img\">\r\n" + 
					"	<p>A smile is a facial expression formed primarily by flexing the muscles at the sides of the mouth. It is  believed it takes about 80 muscles to smile. Some smiles include a contraction of the muscles at the corner of the eyes, an action known as a \"Duchenne smile\". Smiles performed without the eye contraction may be perceived as insincere.</p>\r\n" + 
					"	<hr>\r\n" + 
					"	<img src='"+"file:/"+ Paths.get("Img/img7.png").toAbsolutePath()+"' align=\"left\" width=\"70\" height=\"70\" alt=\"img\">\r\n" + 
					"	<p>A smile is a facial expression formed primarily by flexing the muscles at the sides of the mouth. It is  believed it takes about 80 muscles to smile. Some smiles include a contraction of the muscles at the corner of the eyes, an action known as a \"Duchenne smile\". Smiles performed without the eye contraction may be perceived as insincere.</p>\r\n" + 
					"	<hr>\r\n" + 
					"	\r\n" + 
					"</body>\r\n" + 
					"</html>");
			
			
			
//			txtText.setText(
//					"<!DOCTYPE html>\r\n<html>\r\n<head>\r\n\t<title>Bài 15</title>\r\n</head>\r\n<body>\r\n\t<p><font size=\"6\"><b>Contact Us</b></font></p>\r\n\t<fieldset>\r\n\t\t<legend>Your message:</legend>\r\n\t\t<table>\r\n\t\t\t<tr>\r\n\t\t\t\t<td>To</td>\r\n\t\t\t\t<td><input type=\"text\" name=\"txtTo\"></td>\r\n\t\t\t</tr>\r\n\t\t\t<tr>\r\n\t\t\t\t<td>Your email</td>\r\n\t\t\t\t<td><input type=\"text\" name=\"txtYourEmail\"></td>\r\n\t\t\t</tr>\r\n\t\t\t<tr>\r\n\t\t\t\t<td>Message</td>\r\n\t\t\t\t<td><textarea rows=\"7\" cols=\"40\"></textarea></td>\r\n\t\t\t</tr>\r\n\t\t</table>\r\n\t</fieldset>\r\n\t<fieldset>\r\n\t\t<legend>How you found us:</legend>\r\n\t\t<table>\r\n\t\t\t<tr>\r\n\t\t\t\t<td>How did you hear of us?</td>\r\n\t\t\t\t<td>\r\n\t\t\t\t\t<select>\r\n\t\t\t\t\t\t<option>Google</option>\r\n\t\t\t\t\t\t<option>FaceBook</option>\r\n\t\t\t\t\t\t<option>Twitter</option>\r\n\t\t\t\t</select>\r\n\t\t\t\t</td>\r\n\t\t\t</tr>\r\n\t\t\t<tr>\r\n\t\t\t\t<td>Newsletter</td>\r\n\t\t\t\t<td><input type=\"checkbox\" name=\"chkNewsletter\"> Ensure this box is checked if you would like to receive email updates</td>\r\n\t\t\t</tr>\r\n\t\t</table>\r\n\t</fieldset>\r\n\t<p><input type=\"submit\" value=\"Send Message\"></p>\r\n\t<fieldset>\r\n\t\t<legend><i>Contact Information</i></legend>\r\n\t\t<table>\r\n\t\t\t<tr>\r\n\t\t\t\t<td>First name</td>\r\n\t\t\t\t<td><input type=\"text\" name=\"txtFirstName\"></td>\r\n\t\t\t</tr>\r\n\t\t\t<tr>\r\n\t\t\t\t<td>Last name</td>\r\n\t\t\t\t<td><input type=\"text\" name=\"txtLastName\"></td>\r\n\t\t\t</tr>\r\n\t\t\t<tr>\r\n\t\t\t\t<td>E-Mail</td>\r\n\t\t\t\t<td><input type=\"text\" name=\"txtEmail\"></td>\r\n\t\t\t</tr>\r\n\t\t</table>\r\n\t</fieldset>\r\n\t<fieldset>\r\n\t\t<legend><i>Competition Question</i></legend>\r\n\t\t<p>How tall is the Eiffel Tower in Paris, France?</p>\r\n\t\t<input type=\"radio\" id=\"a\" name=\"tall\" value=\"584 ft\">\r\n\t\t<label for=\"a\">584 ft</label><br>\r\n\t\t<input type=\"radio\" id=\"b\" name=\"tall\" value=\"784 ft\">\r\n\t\t<label for=\"b\">784 ft</label><br>\r\n\t\t<input type=\"radio\" id=\"c\" name=\"tall\" value=\"984 ft\">\r\n\t\t<label for=\"c\">984 ft</label><br>\r\n\t\t<input type=\"radio\" id=\"d\" name=\"tall\" value=\"1184 ft\">\r\n\t\t<label for=\"d\">1184 ft</label>\r\n\t</fieldset>\r\n\t<fieldset>\r\n\t\t<legend><i>Tiebreaker Question</i></legend>\r\n\t\t<p>In 25 words or less, say why you would like to win $10,000:</p>\r\n\t\t<textarea rows=\"10\" cols=\"70\"></textarea>\r\n\t</fieldset>\r\n\t<fieldset>\r\n\t\t<legend><i>Enter Competition</i></legend>\r\n\t\t<input type=\"submit\" value=\"Enter Competition\">\r\n\t</fieldset>\r\n\r\n</body>\r\n</html>");
			txtText.setEditable(false);
			txtText.setFont(new Font("Tahoma", Font.PLAIN, 20));
			scrollPane.setViewportView(txtText);
		

//		txtText.setText("<html><img src='" + GD_HuongDanSuDung.class.getClassLoader().getResource("img/arctic-cat.jpg").toString() + "'/>"
//				+ "<hr>"
//				+ "<p>HIHIH</p></html>");
		
//		System.out.println(GD_HuongDanSuDung.class.getClassLoader().getResource("img/arctic-cat.jpg").toString());
		
	  }

}
