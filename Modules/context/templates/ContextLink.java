package Jet.Modules.context.templates;

import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class ContextLink extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	
	/**
	 * Create the panel.
	 */
	public ContextLink() {
		
		JLabel lblGfdsgfdsg = new JLabel("gfdsgfdsg");
		lblGfdsgfdsg.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
			}
		});
		lblGfdsgfdsg.setForeground(Color.BLUE);
		add(lblGfdsgfdsg);

	}

}
