/**
 * Program: CIS249Final.java
 * Programmer: Andrew Buskov
 * Class: CIS 249
 * Date: May 3, 2013
 * Purpose: To create a horse betting system that logs the information to a data file.
 */

package Final;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GraphicsEnvironment;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.text.DecimalFormat;
import java.util.Arrays;
import java.util.List;

import javax.swing.JApplet;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class CIS249Final extends JApplet {

	private static final long serialVersionUID = 1L; // eclipse complains

	private static final String WELCOME_TEXT = "Welcome to Racing at Churchill Downs";
	private static final String DISPLAY_TEXT = "Choose the post position of the horse in Race 1, "
			+ "enter bet in the lower box, and press 'Place a Bet'";

	private JLabel jlblWelcome = new JLabel();

	private JTextField jtfDisplay = new JTextField();
	private JTextField jtfBet = new JTextField();

	private JButton jbtPlaceBet = new JButton("Place a Bet");
	private JButton[] jbtPosition = new JButton[4];

	private JPanel panel[] = new JPanel[5];

	DecimalFormat df = new DecimalFormat("$###.00");

	public CIS249Final() {
		// set out layout
		setLayout(new GridLayout(5, 1));

		// add menubar to the app
		addMenuBar();

		// create panels
		createPanels();

		// create buttons
		createButtons();

		// add the welcome message & set the font
		jlblWelcome.setText(WELCOME_TEXT);
		panel[0].setLayout(new GridBagLayout());
		panel[0].add(jlblWelcome);
		jlblWelcome.setFont(new Font(determineFont("welcome"), Font.PLAIN, 20));

		// add the display textfield
		panel[1].setLayout(new BorderLayout());
		jtfDisplay.setFont(new Font(determineFont("textField"), Font.PLAIN, 14));
		jtfDisplay.setHorizontalAlignment(SwingConstants.CENTER);
		jtfDisplay.setEditable(false);
		jtfDisplay.setBackground(Color.white);
		panel[1].add(jtfDisplay);

		// add button panel
		panel[2].setLayout(new GridLayout(1, 4));
		for (int i = 0; i < jbtPosition.length; i++) {
			panel[2].add(jbtPosition[i]);
		}

		// add the betting textfield
		panel[3].setLayout(new BorderLayout());
		panel[3].add(jtfBet);

		// add bet button to text field
		panel[4].setLayout(new BorderLayout());
		panel[4].add(jbtPlaceBet);

		for (int i = 0; i < panel.length; i++) {
			add(panel[i]);
		}
	}

	public static void main(String[] args) {
		CIS249Final applet = new CIS249Final();
		JFrame frame = new JFrame();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setTitle("CIS-249 Final");
		frame.add(applet, BorderLayout.CENTER);
		applet.init();
		applet.start();
		frame.setSize(700,200);
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
	}

	public void addMenuBar() {
		JMenuBar mb = new JMenuBar();
		this.setJMenuBar(mb);

		// add menus to our menubar & set mnemonics
		JMenu jmFile = new JMenu("File");
		JMenu jmEdit = new JMenu("Edit");
		jmFile.setMnemonic('F');
		jmEdit.setMnemonic('E');

		// add items to the menus & set mnemonics
		JMenuItem jmiDisplay = new JMenuItem("Display");
		JMenuItem jmiExit = new JMenuItem("Exit Program");
		JMenuItem jmiClear = new JMenuItem("Clear");

		jmiDisplay.setMnemonic('D');
		jmiExit.setMnemonic('P');
		jmiClear.setMnemonic('C');

		jmFile.add(jmiDisplay);
		jmFile.add(jmiExit);
		jmEdit.add(jmiClear);

		// add everything to menubar
		mb.add(jmFile);
		mb.add(jmEdit);

		// set actionListeners for menuItems
		jmiDisplay.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				jtfDisplay.setText(DISPLAY_TEXT);
			}

		});

		jmiExit.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				System.exit(1);
			}
		});

		jmiClear.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				jtfBet.setText("");
				jtfDisplay.setText("");
				System.out.println("Reset Program");
			}
		});
	}

	public void createPanels() {
		int i = 0;
		while (i < panel.length) {
			panel[i] = new JPanel();
			i++;
		}
	}

	public void createButtons() {
		for (int i = 0; i < jbtPosition.length; i++) {
			jbtPosition[i] = new JButton("Post Position " + (i + 1));
			jbtPosition[i].setBackground(Color.YELLOW);
			jbtPosition[i].addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					jtfDisplay.setText(e.getActionCommand());
				}
			});
		}

		// creating place bets button
		jbtPlaceBet.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					jtfDisplay.setText("You have placed " + determineBet() + " on the horse in " + e.getActionCommand()
							+ ". " + " Hope your horse wins!");
					writeData(jtfDisplay.getText());
				} catch (IOException ex) {
					System.out.println(ex);
				}
			}
		});
	}

	private String determineBet() {
		double holding = Integer.parseInt(jtfBet.getText());
		String betAmount = df.format(holding);

		return betAmount;
	}

	public String determineFont(String id) {
		GraphicsEnvironment e = GraphicsEnvironment.getLocalGraphicsEnvironment();
		String[] fontNames = e.getAvailableFontFamilyNames();

		// convert to list for easier use
		List<String> fontList = Arrays.asList(fontNames);
		// System.out.println(fontList); // used for testing
		String useFont;
		if (id.equals("welcome")) {
			if (fontList.contains("Roboto Lt")) {
				useFont = "Roboto Lt";
				return useFont;
			} else {
				useFont = "Serif";
			}
			return useFont;
		}
		useFont = "Arial";
		return useFont;
	}

	public void writeData(String output) throws IOException {
		try {
			@SuppressWarnings("unused")
			HandleData outputData = new HandleData(output);
		} catch (IOException ex) {
			System.out.println(ex);
		}
	}
}
