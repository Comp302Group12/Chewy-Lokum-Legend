import javax.swing.JButton;
import javax.swing.JPanel;

@SuppressWarnings("serial")
public class GameWindow extends JPanel {

	AnimationWindow animationWindow;
	InformationWindow informationWindow;
	JButton pauseGameButton;

	public GameWindow() {
		// TODO Auto-generated constructor stub
		super();

		setLayout(null);

		animationWindow = new AnimationWindow(431, 431);
		setLocation(0, 0);

		add(animationWindow);

		informationWindow = new InformationWindow(180, 120);
		informationWindow.setLocation(441, 0);

		add(informationWindow);

		pauseGameButton = new JButton("Pause Game");

		pauseGameButton.setBounds(461, 130, 120, 35);
		add(pauseGameButton);
	}

}
