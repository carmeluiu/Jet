package Jet.themes.defaultTheme.templates;

import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.border.LineBorder;
import java.awt.Color;
import java.awt.BorderLayout;
import java.awt.Dimension;

public class DefaultContent extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Create the panel.
	 */
	public DefaultContent() {
		setMinimumSize(new Dimension(800, 10));
		setBorder(new LineBorder(new Color(0, 0, 0), 4));
		setLayout(new BorderLayout(0, 0));
		
		JLabel lblDefaultContentText = new JLabel("Default content text");
		lblDefaultContentText.setFont(new Font("Tahoma", Font.PLAIN, 35));
		add(lblDefaultContentText);

	}
}
