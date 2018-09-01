import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextPane;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import java.awt.Color;
import java.awt.Toolkit;

public class GUI2 extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = -2311325531073783462L;
	private JPanel contentPane;

	/**
	 * Create the frame.
	 */
	public GUI2(String profit) {
		setIconImage(Toolkit.getDefaultToolkit().getImage("MainIcon.png"));
		setTitle("AucProfit");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JTextPane textPane = new JTextPane();
		textPane.setEditable(false);

		textPane.setText(profit);
		
		textPane.setBackground(new Color(240, 240, 240));
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addComponent(textPane, GroupLayout.DEFAULT_SIZE, 424, Short.MAX_VALUE)
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addComponent(textPane, GroupLayout.DEFAULT_SIZE, 251, Short.MAX_VALUE)
		);
		contentPane.setLayout(gl_contentPane);
	}

}
