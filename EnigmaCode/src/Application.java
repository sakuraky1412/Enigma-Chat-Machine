import javax.swing.JFrame;

/**
 * This application enables the user to input a message and encode it with a
 * password. Then after the user sends the message to another user, the second
 * user can decode the message with the password
 *
 */
public class Application {
	/** the frame width **/
	public static int FRAME_WIDTH = 470;
	/** the frame height **/
	public static int FRAME_HEIGHT = 470;

	/**
	 * Main method sets up the JFrame that holds our view
	 * 
	 * @param args
	 *            message from user
	 */
	public static void main(String[] args) {

		JFrame tetrisFrame = new JFrame("Encoding and Decoding");

		tetrisFrame.add(new View());

		tetrisFrame.setSize(FRAME_WIDTH, FRAME_HEIGHT);

		tetrisFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		tetrisFrame.setVisible(true);
	}
}
