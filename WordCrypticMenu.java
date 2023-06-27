import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

import javax.imageio.ImageIO;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;

public class WordCrypticMenu extends JPanel
{
    private Image imageBackground;
    private Image imageBackground2;
    private Image imageBackground3;
    WordCryptic gg;
    WordCrypticMainGame wcmg;
    public WordCrypticMenu(WordCryptic ggIn, WordCrypticMainGame in)
    {
        wcmg = in;
        gg = ggIn;
       setLayout(null);
       setBackground(Color.BLUE);
       getBlueCloudBackground();
       getTitleBackground();
       getBlackTitleBackground();
       scoreButton();
    }

    public void getBlueCloudBackground()
    {
        File imageFile = new File("BlueBackground.png");
		try
		{
			imageBackground = ImageIO.read(imageFile);
		}
		catch(IOException e)
		{
			System.err.println("\n\n" + "BlueBackground.png" + " can't be found.\n\n");
		}
    }
     public void getTitleBackground()
    {
        File imageFile = new File("WordHunt.png");
		try
		{
			imageBackground2 = ImageIO.read(imageFile);
		}
		catch(IOException e)
		{
			System.err.println("\n\n" + "BlueBackground.png" + " can't be found.\n\n");
		}
    }

    public void getBlackTitleBackground()
    {
        File imageFile = new File("blackWord.jpeg");
		try
		{
			imageBackground3 = ImageIO.read(imageFile);
		}
		catch(IOException e)
		{
			System.err.println("\n\n" + "BlueBackground.png" + " can't be found.\n\n");
		}
    }

    public void paintComponent(Graphics g)
    {
        super.paintComponent(g);
        g.drawImage(imageBackground,0,0,this);
        g.drawImage(imageBackground2, 70,50,674,292,this);
        
        playButton();
        quitButton();
    }

    public void playButton()
    {
        JButton playButton;
         ImageIcon imageB = null;
         try 
         {
            imageB = new ImageIcon("playButton.png");
         }
         catch (Exception ex) 
        {
             System.out.println(ex);
        }
        playButton = new JButton(imageB);
        playButton.setOpaque(false);
        playButton.setBorderPainted(false); 
        PlayHandler ph = new PlayHandler();
        playButton.addActionListener(ph);
        playButton.setContentAreaFilled(false); 
        playButton.setFocusPainted(false); 
        playButton.setBounds(300,350,199,60);
        this.add(playButton);
    }
      class PlayHandler implements ActionListener 
	{
		public void actionPerformed(ActionEvent evt) 
		{
            gg.cards.show(gg.cardPanel,"WordCrypticMainGame");
            playMusic("buttonClick.wav");

            
            
		}
	}	

    class QuitHandler implements ActionListener 
	{
		public void actionPerformed(ActionEvent evt) 
		{
            playMusic("buttonClick.wav");
            System.exit(0);
            
		}
	}	
     class ScoreHandler implements ActionListener 
	{
		public void actionPerformed(ActionEvent evt) 
		{
            gg.cards.show(gg.cardPanel,"scoreBoard");
            playMusic("buttonClick.wav");
            
            
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
        playButton = new JButton(imageB);
        playButton.setOpaque(false);
        QuitHandler qh = new QuitHandler();
        playButton.addActionListener(qh);
        playButton.setBorderPainted(false); 
        playButton.setContentAreaFilled(false); 
        playButton.setFocusPainted(false); 
        playButton.setBounds(300,490,200,60);
        this.add(playButton);
    }

    public void playMusic(String filepath)
    {
       try
       {
         File musicPath = new File(filepath);
         if(musicPath.exists())
         {
            AudioInputStream audioInput = AudioSystem.getAudioInputStream(musicPath);
            Clip clip = AudioSystem.getClip();
            clip.open(audioInput);
            clip.start();
         }
         else
         {
            System.out.println("faield");
         }
       }
       catch(Exception e)
       {
        
       }

    }

     public void scoreButton()
    {
        JButton playButton;
         ImageIcon imageB = null;
         try 
         {
            imageB = new ImageIcon("scoreButton.png");
         }
         catch (Exception ex) 
        {
             System.out.println(ex);
        }
        playButton = new JButton(imageB);
        playButton.setOpaque(false);
        playButton.setBorderPainted(false); 
        playButton.setContentAreaFilled(false); 
        playButton.setFocusPainted(false); 
        ScoreHandler sh = new ScoreHandler();
        playButton.addActionListener(sh);
        playButton.setBounds(300,420,200,65);
        this.add(playButton);
    }

  
}