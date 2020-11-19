package ui.HuongDanSuDung;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JInternalFrame;
import javax.swing.JLayeredPane;
import javax.swing.JScrollBar;
import javax.swing.JTree;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JToolBar;
import javax.swing.tree.DefaultTreeModel;
import javax.swing.tree.DefaultMutableTreeNode;

public class GD_HuongDanSuDung extends JFrame {

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
		
		JTree tree = new JTree();
		tree.setRowHeight(30);
		tree.setModel(new DefaultTreeModel(
			new DefaultMutableTreeNode("Hướng dẫn sử dụng") {
				{
					DefaultMutableTreeNode node_1;
					node_1 = new DefaultMutableTreeNode("Xe máy\t");
						node_1.add(new DefaultMutableTreeNode("Thêm xe máy"));
						node_1.add(new DefaultMutableTreeNode("Sửa thông tin xe máy"));
						node_1.add(new DefaultMutableTreeNode("Thêm xe máy bằng excel"));
						node_1.add(new DefaultMutableTreeNode("Thêm, xóa, sửa hãng xe"));
						node_1.add(new DefaultMutableTreeNode("Thêm, xóa, sửa dòng xe"));
						node_1.add(new DefaultMutableTreeNode("Thêm, xóa, sửa loại xe"));
						node_1.add(new DefaultMutableTreeNode("Thêm, xóa, sửa xuất xứ xe"));
					add(node_1);
					node_1 = new DefaultMutableTreeNode("jhsj");
						node_1.add(new DefaultMutableTreeNode("jáhja"));
					add(node_1);
				}
			}
		));
		tree.setVisibleRowCount(25);
		tree.setFont(new Font("Tahoma", Font.PLAIN, 20));
		tree.setBounds(0, 0, 309, 546);
		contentPane.add(tree);
		
	}

}
