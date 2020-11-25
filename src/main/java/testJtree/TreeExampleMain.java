package testJtree;


import java.awt.BorderLayout;
import java.awt.Dimension;
import java.util.function.BiPredicate;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.JTree;
import javax.swing.tree.TreeNode;

public class TreeExampleMain {
    public static void main(String[] args) {
    	JTextField field = new JTextField();
    	
        TreeNode projectHierarchyTreeNode =
                TradingProjectDataService.instance.getProjectHierarchy();
        JTree tree = new JTree(projectHierarchyTreeNode);
        
        JTreeUtil.setTreeExpandedState(tree, true);
        
        TreeFilterDecorator filterDecorator = TreeFilterDecorator.decorate(tree, createUserObjectMatcher(), field);
        tree.setCellRenderer(new TradingProjectTreeRenderer(() -> filterDecorator.getFilterField().getText()));
        
        
        JFrame frame = createFrame();
        frame.add(new JScrollPane(tree));
        frame.add(filterDecorator.getFilterField(), BorderLayout.NORTH);
        frame.add(field, BorderLayout.SOUTH);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    private static BiPredicate<Object, String> createUserObjectMatcher() {
        return (userObject, textToFilter) -> {
                return userObject.toString().toLowerCase().contains(textToFilter);
        };
    }

    private static JFrame createFrame() {
        JFrame frame = new JFrame("JTree Filtering example");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(new Dimension(500, 400));
        return frame;
    }
}