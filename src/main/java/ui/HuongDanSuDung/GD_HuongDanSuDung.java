package ui.HuongDanSuDung;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.function.BiPredicate;

import javax.swing.JButton;
import javax.swing.JEditorPane;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.JTree;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.border.EmptyBorder;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.TreeNode;
import javax.swing.tree.TreePath;

import constant.HuongDanSuDungConstant;
import testJtree.JTreeUtil;
import testJtree.TradingProjectDataService;
import testJtree.TradingProjectTreeRenderer;
import testJtree.TreeFilterDecorator;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;

public class GD_HuongDanSuDung extends JFrame implements ActionListener, MouseListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTree tree;
	private JTextField txtTimKiem;
	private JButton btnDong;
	private JButton btnHome;
	private JEditorPane txtText;
	private JButton btnMo;

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
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setBounds(100, 100, 1140, 647);
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		setTitle("Hướng dẫn sử dụng");

		JPanel pnlTimKiem = new JPanel();
		pnlTimKiem.setBackground(Color.WHITE);
		pnlTimKiem.setBounds(0, 0, 1122, 54);
		contentPane.add(pnlTimKiem);
		pnlTimKiem.setLayout(null);

		JLabel lblNewLabel = new JLabel("Tìm kiếm:");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNewLabel.setBounds(12, 8, 105, 35);
		pnlTimKiem.add(lblNewLabel);

		txtTimKiem = new JTextField();
		txtTimKiem.setFont(new Font("Tahoma", Font.PLAIN, 20));
		txtTimKiem.setBounds(129, 13, 405, 30);
		pnlTimKiem.add(txtTimKiem);
		txtTimKiem.setColumns(10);

		btnDong = new JButton("");
		btnDong.setIcon(new ImageIcon(GD_HuongDanSuDung.class.getResource("/img/minus_30px.png")));
		btnDong.setBounds(966, 13, 40, 30);
		pnlTimKiem.add(btnDong);

		btnHome = new JButton("");
		btnHome.setIcon(new ImageIcon(GD_HuongDanSuDung.class.getResource("/img/home_page_30px.png")));
		btnHome.setBounds(1070, 13, 40, 30);
		pnlTimKiem.add(btnHome);

		JPanel pnlTree = new JPanel();
		pnlTree.setBackground(Color.WHITE);
		pnlTree.setBounds(0, 56, 300, 544);
		contentPane.add(pnlTree);
		pnlTree.setLayout(new BoxLayout(pnlTree, BoxLayout.X_AXIS));

		JScrollPane scrollPaneTree = new JScrollPane();
		pnlTree.add(scrollPaneTree);

		TreeNode projectHierarchyTreeNode = TradingProjectDataService.instance.getProjectHierarchy();
		tree = new JTree(projectHierarchyTreeNode);
		JTreeUtil.setTreeExpandedState(tree, true);
		TreeFilterDecorator filterDecorator = TreeFilterDecorator.decorate(tree, createUserObjectMatcher(), txtTimKiem);

		btnMo = new JButton("");
		btnMo.setIcon(new ImageIcon(GD_HuongDanSuDung.class.getResource("/img/plus_30px.png")));
		btnMo.setBounds(1018, 13, 40, 30);
		pnlTimKiem.add(btnMo);
		tree.setCellRenderer(new TradingProjectTreeRenderer(() -> filterDecorator.getFilterField().getText()));

		tree.setRowHeight(25);
		tree.setFont(new Font("Tahoma", Font.PLAIN, 20));
//		tree.setBounds(0, 0, 300, 490);
		scrollPaneTree.setViewportView(tree);

		JPanel pnlHDSD = new JPanel();
		pnlHDSD.setBackground(Color.WHITE);
		pnlHDSD.setBounds(299, 56, 823, 544);
		contentPane.add(pnlHDSD);
		pnlHDSD.setLayout(new BoxLayout(pnlHDSD, BoxLayout.X_AXIS));

		JScrollPane scrollPane = new JScrollPane();
		pnlHDSD.add(scrollPane);

		txtText = new JEditorPane();
		txtText.setContentType("text/html");
		txtText.setText(HuongDanSuDungConstant.GIOI_THIEU);
		txtText.setEditable(false);
		txtText.setFont(new Font("Tahoma", Font.PLAIN, 20));
		scrollPane.setViewportView(txtText);

		dangKySuKien();
	}

	private static BiPredicate<Object, String> createUserObjectMatcher() {
		return (userObject, textToFilter) -> {
			return userObject.toString().toLowerCase().contains(textToFilter);
		};
	}

	/**
	 * Mở rộng/ đóng jtree
	 * 
	 * @param tree
	 * @param expanded
	 */
	public static void moRongTree(JTree tree, boolean expanded) {
		DefaultMutableTreeNode node = (DefaultMutableTreeNode) tree.getModel().getRoot();
		moRongNode(tree, node, expanded);
	}

	/**
	 * Mở rộng/ đóng tất cả các node
	 * 
	 * @param tree
	 * @param node
	 * @param expanded
	 */
	@SuppressWarnings("unchecked")
	public static void moRongNode(JTree tree, DefaultMutableTreeNode node, boolean expanded) {
		ArrayList<DefaultMutableTreeNode> list = Collections.list(node.children());
		for (DefaultMutableTreeNode treeNode : list) {
			moRongNode(tree, treeNode, expanded);
		}
		if (!expanded && node.isRoot()) {
			return;
		}
		TreePath path = new TreePath(node.getPath());
		if (expanded) {
			tree.expandPath(path);
		} else {
			tree.collapsePath(path);
		}
	}

	/**
	 * Đăng ký sự kiện
	 */
	private void dangKySuKien() {
		btnHome.addActionListener(this);
		btnDong.addActionListener(this);
		btnMo.addActionListener(this);
		tree.addMouseListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Object o = e.getSource();
		if (o.equals(btnHome)) {
			txtText.setText(HuongDanSuDungConstant.GIOI_THIEU);
			tree.clearSelection();
			txtTimKiem.setText("");
		}
		if (o.equals(btnDong)) {
			moRongTree(tree, false);
		}
		if (o.equals(btnMo)) {
			moRongTree(tree, true);
		}
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		DefaultMutableTreeNode selectedNode = (DefaultMutableTreeNode) tree.getSelectionPath().getLastPathComponent();
		if(selectedNode.getUserObject().toString().equals("Lập hóa đơn")) {
			txtText.setText(HuongDanSuDungConstant.TEST);
		}
		else {
			txtText.setText(selectedNode.getUserObject().toString());
		}
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub

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
