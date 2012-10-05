package Jet.themes.defaultTheme.templates;

import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Color;
import javax.swing.border.LineBorder;
import java.awt.Component;
import java.awt.BorderLayout;

public class DefaultHeader extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Create the panel.
	 */
	public DefaultHeader() {
		setBorder(new LineBorder(new Color(0, 0, 0), 3));
		setLayout(new BorderLayout(0, 0));
		
		JLabel lblDefaultHeader = new JLabel("Default Header");
		lblDefaultHeader.setAlignmentX(Component.CENTER_ALIGNMENT);
		add(lblDefaultHeader, BorderLayout.CENTER);

	}

}
