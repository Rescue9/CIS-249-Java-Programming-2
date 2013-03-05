package Ch17.Lab4;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import javax.swing.ImageIcon;
import javax.swing.UIManager;
import javax.swing.JScrollPane;
import java.awt.Insets;
import java.awt.Font;
import java.awt.BorderLayout;


public class DescriptionPanel extends JPanel {

	private static final long serialVersionUID = 1L; // eclipse complains

	/** label for displaying an image icon and a text */
	private JLabel jlblImageTitle = new JLabel();
	
	/** text are for displaying text */
	private JTextArea jtaDescription;
	
	public DescriptionPanel(){
		
		UIManager.put("TextArea.margin", new Insets(0,20,0,20));
		
		jtaDescription = new JTextArea();
		
		// center the icon and the text and place the text under the icon
		jlblImageTitle.setHorizontalAlignment(JLabel.CENTER);
		jlblImageTitle.setHorizontalTextPosition(JLabel.CENTER);
		jlblImageTitle.setVerticalTextPosition(JLabel.BOTTOM);
		
		// set the font in the label and the text field
		jlblImageTitle.setFont(new Font("SansSerif", Font.BOLD, 16));
		jtaDescription.setFont(new Font("Serif", Font.PLAIN, 14));
		
		// set lineWrap and wrap StyleWord true for text area
		jtaDescription.setLineWrap(true);
		jtaDescription.setWrapStyleWord(true);
		jtaDescription.setEditable(false);
		
		// create a scroll pane to hold the text area
		JScrollPane scrollPane = new JScrollPane(jtaDescription);
		
		// set BorderLayout for the panel, add label and scrollpane
		setLayout(new BorderLayout(5, 5));
		add(scrollPane, BorderLayout.CENTER);
		add(jlblImageTitle, BorderLayout.NORTH);
	}
	
	/** set the title */
	public void setTitle(String title){
		jlblImageTitle.setText(title);
	}
	
	/** set the image icon */
	public void setImageIcon(ImageIcon icon){
		jlblImageTitle.setIcon(icon);
	}
	
	/** set the text description */
	public void setDescription(String text){
		jtaDescription.setText(text);
	}
}

