package Jet.themes.defaultTheme;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class DefaultFrame extends JFrame {

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
					DefaultFrame frame = new DefaultFrame();
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
	public DefaultFrame() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
//		contentPane = new JPanel();
		contentPane = (JPanel) getContentPane();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		
		JPanel leftSidebar = new JPanel();
		getContentPane().add(leftSidebar, BorderLayout.WEST);
		
		JPanel rightSidebar = new JPanel();
		getContentPane().add(rightSidebar, BorderLayout.EAST);
		
		JPanel footer = new JPanel();
		getContentPane().add(footer, BorderLayout.SOUTH);
		
		JPanel content = new JPanel();
		getContentPane().add(content, BorderLayout.CENTER);
		
		JPanel header = new JPanel();
		getContentPane().add(header, BorderLayout.NORTH);
//		setContentPane(contentPane);
	}
	
	public void showThis() {
//		System.out.println("in show");
		EventQueue.invokeLater(new Runnable() {
			
			@Override
			public void run() {
				pack();
				setVisible(true);
			}
		});
	}

}
