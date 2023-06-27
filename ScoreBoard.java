import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

import javax.imageio.ImageIO;
import javax.swing.Action;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;

public class ScoreBoard extends JPanel implements MouseListener
{
    private Image imageBackground;
    WordCryptic gg;
    WordCrypticMainGame wcmg;
    public ScoreBoard(WordCryptic in, WordCrypticMainGame in2)
    {
        gg = in;
        wcmg = in2;
       getBlueCloudBackground();
       addMouseListener(this);
       setLayout(null);
       quitButton();
      
    }
    public void paintComponent(Graphics g)
    {
        super.paintComponent(g);
        g.drawImage(imageBackground,0,0,800,675,this);
        readScores(g);
        
       
    }

    public void getBlueCloudBackground()
    {
        File imageFile = new File("leaderBoard.png");
		try
		{
			imageBackground = ImageIO.read(imageFile);
		}
		catch(IOException e)
		{
			System.err.println("\n\n" + "BlueBackground.png" + " can't be found.\n\n");
		}
    }

    public void readScores(Graphics g)
    {
         
       Scanner read = null;
          try 
            {
                File myObj = new File("scores.txt"); // opens up the file
                read= new Scanner(myObj);    // creates a Scanner object
            } 
            catch (FileNotFoundException e) 
            {
                System.out.println("An error occurred."); // prints error if file doesnt exist
                e.printStackTrace(); 
            }


        class LeaderBoard {
            String name;
            int score;
        }
        ArrayList<LeaderBoard> leaderBoards = new ArrayList<>();

        while(read.hasNext())
        {
           LeaderBoard leaderBoard = new LeaderBoard();
           leaderBoard.name = read.next();
           leaderBoard.score = Integer.parseInt(read.next());
           leaderBoards.add(leaderBoard);
        }
        leaderBoards.sort( new Comparator<LeaderBoard>() {
            public int compare(LeaderBoard a, LeaderBoard b) {
                return b.score - a.score;
            }
            
        });
        read.close();

        // print values
        for (LeaderBoard leaderBoard : leaderBoards) {
           // System.out.println(leaderBoard.name + "  " + leaderBoard.score);
        }

        int count = 0;
        Font font = new Font("serifPlain",Font.BOLD,40);
        g.setFont(font);
        while(count < 9 && count < leaderBoards.size())
        {
            g.drawString(leaderBoards.get(count).name,250,162+(count*56));
            g.drawString(""+leaderBoards.get(count).score,500,162+(count*57));
            count++;
        }
    }
     public void quitButton()
    {
        JButton playButton;
         ImageIcon imageB = null;
         try 
         {
            imageB = new ImageIcon("quitButton.png");
         }
         catch (Exception ex) 
        {
             System.out.println(ex);
        }
        Font font = new Font("serifPlain",Font.BOLD,20);
      
        playButton = new JButton("X");
          playButton.setFont(font);
        playButton.setOpaque(false);
        playButton.setBorderPainted(false); 
        ScoreHandler sh = new ScoreHandler();
        playButton.addActionListener(sh);
        playButton.setContentAreaFilled(false); 
        playButton.setFocusPainted(false); 
        playButton.setBounds(567,25,72,72);
        this.add(playButton);
    }
   class ScoreHandler implements ActionListener 
	{
		public void actionPerformed(ActionEvent evt) 
		{
            gg.cards.show(gg.cardPanel,"WordCrypticMenu"); 
		}
	}	
    @Override
    public void mouseClicked(MouseEvent e) {
        // TODO Auto-generated method stub
      
    }
    @Override
    public void mousePressed(MouseEvent e) {
        // TODO Auto-generated method stub
       
        
    }
    @Override
    public void mouseReleased(MouseEvent e) {
        
    }
    @Override
    public void mouseEntered(MouseEvent e) {
        // TODO Auto-generated method stub
       
    }
    @Override
    public void mouseExited(MouseEvent e) {
        // TODO Auto-generated method stub
       
    }

    
}