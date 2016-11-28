import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

/**
 * The View class handles the user interface
 *
 */
@SuppressWarnings("serial")
public class View extends JPanel {
	/** JComponents that we are using **/
	private JTextArea input;
	private JTextArea output;
	private JTextField field;
	private JButton encode;
	private JButton decode;
	/** String input and output **/
	private String original;
	private String translated;
	private LogicEncode logic;
	private LogicDecode logicDecode;

	/**
	 * Constructs the view
	 */
	public View() {
		// View uses BorderLayout
		super(new BorderLayout());
		// Instantiate input and output messages
		original = new String("Please input here.");
		translated = new String("This is output.");
		// Create input and output areas
		input = new JTextArea(original, 50, 100);
		input.setLineWrap(true);
		input.setWrapStyleWord(true);
		output = new JTextArea(translated, 50, 100);
		output.setLineWrap(true);
		output.setWrapStyleWord(true);
		JPanel textAreas = new JPanel();
		textAreas.add(new JScrollPane(input));
		textAreas.add(new JScrollPane(output));
		textAreas.setLayout(new BoxLayout(textAreas, BoxLayout.Y_AXIS));
		this.add(textAreas, BorderLayout.CENTER);
		// Create password input area
		JLabel label = new JLabel("Enter Password First:");
		field = new JTextField(10);
		JPanel fieldPanel = new JPanel();
		fieldPanel.add(label);
		fieldPanel.add(field);
		this.add(fieldPanel, BorderLayout.NORTH);
		// Create encode and decode buttons and implement their functions
		encode = new JButton("encode");
		encode.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String inputValue = input.getText();
				String passValue = field.getText();
				int passW = Integer.parseInt(passValue);
				logic = new LogicEncode(inputValue, passW);
				int[] input1 = logic.getEmoji();
				StringBuffer sb = new StringBuffer();
				for (int i = 0; i < input1.length; i++) {
					sb.append(Character.toChars(input1[i]));
				}
				output.setText(sb.toString());
			}
		});
		decode = new JButton("decode");
		decode.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String inputValue = input.getText();
				String passValue = field.getText();
				int passW = Integer.parseInt(passValue);
				logicDecode = new LogicDecode(inputValue, passW);
				int[] input2 = logicDecode.getOriginal();
				StringBuffer sb = new StringBuffer();
				for (int i = 0; i < input2.length; i++) {
					sb.append(Character.toChars(input2[i]));
				}
				output.setText(sb.toString());
			}
		});
		JPanel buttons = new JPanel(new FlowLayout());
		buttons.add(encode);
		buttons.add(decode);
		this.add(buttons, BorderLayout.SOUTH);
	}
}
