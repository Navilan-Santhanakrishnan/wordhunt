import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.CardLayout;

public class WordCryptic
{
	 CardLayout cards; // this is the CardLayout cards
	 JPanel cardPanel; // this is the JPanel that contains the cardLayout and is added to the JFrame
	 static WordCryptic gg;
	
	public static void main (String [] args)
	{
		gg = new WordCryptic(); // creating an instance of GameHolder
		gg.runIt(); // calling runIt
	}
	
	public void runIt()
	{
		cards = new CardLayout();  // creating the cardlayout
		cardPanel = new JPanel();  // creating the JPanel
		cardPanel.setLayout(cards);

		JFrame frame = new JFrame("WordCryptic"); // setting the name of the JFrame
		frame.setLayout(cards);
		frame.setSize(800,700);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLocation(10, 10);
		frame.setResizable(false);
		frame.add(cardPanel);
		WordCrypticMainGame wcmg = new WordCrypticMainGame(gg);
		ScoreBoard sb = new ScoreBoard(gg,wcmg);
		WordCrypticMenu wcm = new WordCrypticMenu(gg,wcmg);
        cardPanel.add(wcmg,"WordCrypticMainGame");
		cardPanel.add(sb,"scoreBoard");
		cardPanel.add(wcm,"WordCrypticMenu");
		cards.show(cardPanel,"WordCrypticMenu");
		frame.setVisible(true);

	}

}
