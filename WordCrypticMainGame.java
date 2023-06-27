import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Collections;
import java.util.HashSet;
import java.util.Random;
import java.util.Scanner;
import java.util.Set;

import javax.imageio.ImageIO;
import javax.lang.model.util.ElementScanner14;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.Timer;
import javax.swing.text.SimpleAttributeSet;
import javax.swing.text.StyleConstants;
import javax.swing.text.StyledDocument;
//https://chat.openai.com/share/b9cad73f-568a-481d-9914-15c8393c725b
public class WordCrypticMainGame extends JPanel implements MouseListener, KeyListener
{
    private Image imageBackground;
    Timer timer;
    String [] word = {"","","","",""};
    JTextArea inputArea ; 
    int globalCount = 0;
    char [] letters = new char[5];
    String [] threeArray = new String[3];
    String [] fourArray = new String[2];
    String [] fiveArray = new String[1];
    boolean flag2 = true;
    Image imageBackgroundImg;
    boolean flag3 = true;
    boolean flag4 = true;
    boolean flag5 = true;
    JButton playButtonNo;
    JButton playButtonYes;
    boolean flag6 = true;
    JButton playButtonU;
    JButton playButtonM;
    JButton playButtonEN;
    JButton playButtonT;
    boolean flag7 = true;
    boolean flag = false;
    boolean yesPrompt = false;
     boolean flag8 = true;
    boolean [] threeArrayB = new boolean[3];
    boolean [] fourArrayB = new boolean[2];
    boolean [] fiveArrayB = new boolean[1];
    Image imageBackground2;
    int secCount = 59;
    boolean flag9 = true;
    JButton playButtonE;
    JButton playButtonE2;
    Image imageBackgroundNext2 = null;
    boolean roundOver = false;
    int globalLevel = 1;
    JButton playButtonA;
    int minCount=2;
    boolean menu = false;     
    JTextArea inputArea2;  
    Timer timer2;
    int moveX = 0;
    int scoreCount = 0;
    boolean timerFlag = false;
    Image imageBackgroundNext = null;
    int pos = 0;
    private boolean instruct;
    private boolean page;
    private Set<String> wordsSet;
    WordCryptic gg;
    private PrintWriter printWriter;
    private boolean bonus;
   boolean menuPanel =false;
    public WordCrypticMainGame(WordCryptic in)
    {
        gg = in;
        setLayout(null);
        setBackground(Color.WHITE);
        getBlueCloudBackground();
        getStuff();
        addMouseListener(this);
        addKeyListener(this);
        getNextLevel();
        requestFocusInWindow();
        enterButton2();
        createJTextArea();
        playAnim();
         instruct = true;
        getNextLevel2();
        enterButton3();
        arrowButton();
        createJTextArea2();
        playMusic("bgmusic.wav");
        noButton();
        yesButton();
        instruct = false;

        
    }

    public void createJTextArea()
    {
        inputArea = new JTextArea(10,10);
        inputArea.setBounds(215,405,355,48);
        inputArea.setLineWrap(true);  // goes to the next line when printing the text.
        inputArea.setWrapStyleWord(true); // prevents a word from being split 
        Color blue = new Color(25, 152, 209);
        Font font = new Font("serif",Font.BOLD,50);
        inputArea.setForeground(Color.WHITE);
        inputArea.setFont(font);
        inputArea.setBackground(blue);
        inputArea.setEditable(false);
        add(inputArea);
        inputArea.setText("");
    }
   

    public void minTimer()
    {
        Anim anim = new Anim();
        timer = new Timer(1000,anim);
        timer.start();
        
    }
    class Anim implements ActionListener 
	{
		public void actionPerformed( ActionEvent evt ) 
		{
            secCount--;
            if(minCount==0&&secCount==0)
            {

            }
           else if(secCount==0)
            {
                secCount=60;
                minCount--;
            }
            repaint();
            
		
		}


	}
    public void getStuff()
    {
       int randomNum = (int)(Math.random()*5+0);
       int line = (randomNum*5)+1;
       Scanner read = null;
          try 
            {
                File myObj = new File("words.txt"); // opens up the file
                read= new Scanner(myObj);    // creates a Scanner object
            } 
            catch (FileNotFoundException e) 
            {
                System.out.println("An error occurred."); // prints error if file doesnt exist
                e.printStackTrace(); 
            }
        int count = 1;
        while(count<line)
        {
            read.nextLine();
            count++;
        }
        //Random Letters: Y E R A D
         
        String line2 = read.nextLine();
        line2 = line2.substring(16);
        count = 0;
        int count2 = 0;
        while(count<5)
        {
            letters[count] = line2.charAt(count2);
            
            count++;
            count2+=2;
        }
        
        String threeWord = read.nextLine();
        threeWord = threeWord.substring(3);
        threeArray[0] = threeWord.substring(0,3);
        threeArray[1] = threeWord.substring(5,8);
        threeArray[2] = threeWord.substring(10);
        String fourWord = read.nextLine();
        fourWord = fourWord.substring(3);
        fourArray[0] = fourWord.substring(0,4);
        fourArray[1] = fourWord.substring(6);
        String fiveWord = read.nextLine();
        fiveWord = fiveWord.substring(3);
        fiveArray[0]= fiveWord.substring(0,5);
        read.close();

        

    }

    public void paintComponent(Graphics g)
    {
        super.paintComponent(g);
        // this super.paintcomponet uses multiple different
        // the limit
        // links the minumum output with the maxiumum because the interverls are not the same
        
        g.drawImage(imageBackground2,0,0,this);
        //row 1 (3)
        Color blue = new Color(25, 152, 209);
        g.setColor(Color.BLACK);
        if(threeArrayB[0]==true)
        {
            
        if(flag2 == true)
        {
            playMusic("correctWord.wav");
            scoreCount = (scoreCount+25)+(((minCount*60)+secCount)/5);
            flag2 = false;
        }
            getA(threeArray[0].charAt(0)+"s");
            g.drawImage(imageBackground,80,110,60,60,this);
            getA(threeArray[0].charAt(1)+"s");
            g.drawImage(imageBackground,160,110,60,60,this);
            getA(threeArray[0].charAt(2)+"s");
            g.drawImage(imageBackground,240,110,60,60,this);
        }
        else
        {
             g.fillRoundRect(80,110,60,60,30,30);
             g.fillRoundRect(160,110,60,60,30,30);
             g.fillRoundRect(240,110,60,60,30,30);
             g.setColor(blue);
             g.fillRoundRect(85,115,50,50,30,30);
             g.fillRoundRect(165,115,50,50,30,30);
             g.fillRoundRect(245,115,50,50,30,30);
             g.setColor(Color.BLACK);
        }

        if(threeArrayB[1]==true)
        {
             if(flag3 == true)
        {
            playMusic("correctWord.wav");
            scoreCount = (scoreCount+2)+(((minCount*60)+secCount)/7);
            flag3 = false;
        }
            getA(threeArray[1].charAt(0)+"s");
            g.drawImage(imageBackground,80,190,60,60,this);
            getA(threeArray[1].charAt(1)+"s");
            g.drawImage(imageBackground,160,190,60,60,this);
            getA(threeArray[1].charAt(2)+"s");
            g.drawImage(imageBackground,240,190,60,60,this);
        }
        else
        {
             g.fillRoundRect(80,190,60,60,30,30);
             g.fillRoundRect(160,190,60,60,30,30);
             g.fillRoundRect(240,190,60,60,30,30);
             g.setColor(blue);
             g.fillRoundRect(85,195,50,50,30,30);
             g.fillRoundRect(165,195,50,50,30,30);
             g.fillRoundRect(245,195,50,50,30,30);
             g.setColor(Color.BLACK);
        }

        if(threeArrayB[2]==true)
        {
             if(flag4 == true)
        {
            playMusic("correctWord.wav");
            scoreCount = (scoreCount+2)+(((minCount*60)+secCount)/7);
            flag4 = false;
        }
            getA(threeArray[2].charAt(0)+"s");
            g.drawImage(imageBackground,80,270,60,60,this);
            getA(threeArray[2].charAt(1)+"s");
            g.drawImage(imageBackground,160,270,60,60,this);
            getA(threeArray[2].charAt(2)+"s");
            g.drawImage(imageBackground,240,270,60,60,this);
        }
        else
        {
             g.fillRoundRect(80,270,60,60,30,30);
             g.fillRoundRect(160,270,60,60,30,30);
             g.fillRoundRect(240,270,60,60,30,30);
             g.setColor(blue);
             g.fillRoundRect(85,275,50,50,30,30);
             g.fillRoundRect(165,275,50,50,30,30);
             g.fillRoundRect(245,275,50,50,30,30);
             g.setColor(Color.BLACK);
        }
        if(fourArrayB[0]==true)
        {
             if(flag5 == true)
        {
            playMusic("correctWord.wav");
            scoreCount = (scoreCount+5)+(((minCount*60)+secCount)/7);
            flag5 = false;
        }
            getA(fourArray[0].charAt(0)+"s");
            g.drawImage(imageBackground,350,110,60,60,this);
            getA(fourArray[0].charAt(1)+"s");
            g.drawImage(imageBackground,430,110,60,60,this);
            getA(fourArray[0].charAt(2)+"s");
            g.drawImage(imageBackground,510,110,60,60,this);
            getA(fourArray[0].charAt(3)+"s");
            g.drawImage(imageBackground,590,110,60,60,this);
        }
        else
        {
             g.fillRoundRect(350,110,60,60,30,30);
             g.fillRoundRect(430,110,60,60,30,30);
             g.fillRoundRect(510,110,60,60,30,30);
             g.fillRoundRect(590,110,60,60,30,30);
             g.setColor(blue);
              g.fillRoundRect(355,115,50,50,30,30);
               g.fillRoundRect(435,115,50,50,30,30);
              g.fillRoundRect(515,115,50,50,30,30);
             g.fillRoundRect(595,115,50,50,30,30);
             g.setColor(Color.BLACK);
        }
        if(fourArrayB[1]==true)
        {
             if(flag6 == true)
        {
            playMusic("correctWord.wav");
            scoreCount = (scoreCount+5)+(((minCount*60)+secCount)/7);
            flag6 = false;
        }
            getA(fourArray[1].charAt(0)+"s");
            g.drawImage(imageBackground,350,190,60,60,this);
            getA(fourArray[1].charAt(1)+"s");
            g.drawImage(imageBackground,430,190,60,60,this);
            getA(fourArray[1].charAt(2)+"s");
            g.drawImage(imageBackground,510,190,60,60,this);
            getA(fourArray[1].charAt(3)+"s");
            g.drawImage(imageBackground,590,190,60,60,this);
        }
        else
        {
              g.fillRoundRect(350,190,60,60,30,30);
        g.fillRoundRect(430,190,60,60,30,30);
        g.fillRoundRect(510,190,60,60,30,30);
        g.fillRoundRect(590,190,60,60,30,30);
             g.setColor(blue);
              g.fillRoundRect(355,195,50,50,30,30);
        g.fillRoundRect(435,195,50,50,30,30);
        g.fillRoundRect(515,195,50,50,30,30);
        g.fillRoundRect(595,195,50,50,30,30);
             g.setColor(Color.BLACK);

        }
        //row2 (3)`
       
        //row2 (4)
        //row3 (4)
        //row4(4)w
        if(fiveArrayB[0]==false)
        {

        }
        //row4(5)
        if(fiveArrayB[0]==true)
        {
             if(flag7 == true)
        {
            playMusic("correctWord.wav");
            scoreCount = (scoreCount+10)+(((minCount*60)+secCount)/5);
            flag7 = false;
        }
            getA(fiveArray[0].charAt(0)+"s");
            g.drawImage(imageBackground,350,270,60,60,this);
            getA(fiveArray[0].charAt(1)+"s");
            g.drawImage(imageBackground,430,270,60,60,this);
            getA(fiveArray[0].charAt(2)+"s");
            g.drawImage(imageBackground,510,270,60,60,this);
            getA(fiveArray[0].charAt(3)+"s");
            g.drawImage(imageBackground,590,270,60,60,this);
            getA(fiveArray[0].charAt(4)+"s");
            g.drawImage(imageBackground,670,270,60,60,this);
        }
        else
        {
             g.fillRoundRect(350,270,60,60,30,30);
             g.fillRoundRect(430,270,60,60,30,30);
             g.fillRoundRect(510,270,60,60,30,30);
             g.fillRoundRect(590,270,60,60,30,30);
             g.fillRoundRect(670,270,60,60,30,30);
             g.setColor(blue);

              g.fillRoundRect(355,275,50,50,30,30);
        g.fillRoundRect(435,275,50,50,30,30);
        g.fillRoundRect(515,275,50,50,30,30);
        g.fillRoundRect(595,275,50,50,30,30);
        g.fillRoundRect(675,275,50,50,30,30);
             g.setColor(Color.BLACK);
        }

        
        
        



        g.setColor(blue);
        //row2 (3)
        //row2 (4)
        //row3 (4)
        //row4(4)w
        //row4(5)

        //menu top bar
        g.setColor(Color.BLACK);

        //bottem
        //textarea
        int x = 10;
        g.fillRoundRect(207-x,400,390,60,30,30);
        g.setColor(blue);
        g.fillRoundRect(212-x,405,380,50,30,30);
        g.setColor(Color.BLACK);

        //where the shapes go

        if(flag == true)
        {
            if(inputArea.getText().contains(""+letters[0]))
            {
             getG(""+letters[0]);
             g.drawImage(imageBackground,207-x,480,70,70,this);
            }
            else
           {
             getA(""+letters[0]);
             g.drawImage(imageBackground,207-x,480,70,70,this);
             
            }
        }
        else
        {
             getA(""+letters[0]);
             g.drawImage(imageBackground,207-x,480,70,70,this);
        }
        if(flag == true)
        {
            if(inputArea.getText().contains(""+letters[1]))
            {
              getG(""+letters[1]);
              g.drawImage(imageBackground,287-x,480,70,70,this);            }
            else
           {
             getA(""+letters[1]);
            g.drawImage(imageBackground,287-x,480,70,70,this);
            }
        }
        else
        {
            getA(""+letters[1]);
             g.drawImage(imageBackground,287-x,480,70,70,this);
            
        }
        if(flag == true)
        {
            if(inputArea.getText().contains(""+letters[2]))
            {
             getG(""+letters[2]);
        g.drawImage(imageBackground,367-x,480,70,70,this);

            }
            else
           {
            getA(""+letters[2]);
        g.drawImage(imageBackground,367-x,480,70,70,this);
            }
        }
        else
        {
          getA(""+letters[2]);
        g.drawImage(imageBackground,367-x,480,70,70,this);
        }
        if(flag == true)
        {
            if(inputArea.getText().contains(""+letters[3]))
            {
             getG(""+letters[3]);
        g.drawImage(imageBackground,447-x,480,70,70,this);
            }
            else
           {
            getA(""+letters[3]);
        g.drawImage(imageBackground,447-x,480,70,70,this);
            }
        }
        else
        {
          getA(""+letters[3]);
        g.drawImage(imageBackground,447-x,480,70,70,this);
        }
        if(flag == true)
        {
            if(inputArea.getText().contains(""+letters[4]))
            {
            getG(""+letters[4]);
        g.drawImage(imageBackground,527-x,480,70,70,this);
            }
            else
           {
          getA(""+letters[4]);
        g.drawImage(imageBackground,527-x,480,70,70,this);
            }
        }
        else
        {
          getA(""+letters[4]);
        g.drawImage(imageBackground,527-x,480,70,70,this);
        }
        Font font = new Font("serif",Font.BOLD,40);
        g.setFont(font);
        if(secCount<=9 && secCount>=0)
        {
            g.drawString("Time: " + minCount+":0"+secCount ,600,55);
        }
        else
        {
             g.drawString("Time: " + minCount+":"+secCount ,600,55);
        }
        g.drawString("Level: "+globalLevel,250,55);
        if(scoreCount<10)
        {
            g.drawString("Score: " +scoreCount,425,55);
        }
        else if(scoreCount>10&&scoreCount<100)
        {
            g.drawString("Score: " +scoreCount,415,55);
        }
        else
        {
            g.drawString("Score: " +scoreCount,405,55);
        }
        quitButton();
        trashButton();
        menuButton();
        undoButton();
        if(threeArrayB[0]==true && threeArrayB[1]==true && threeArrayB[2]==true && fourArrayB[0]==true && fourArrayB[1]==true && fiveArrayB[0]==true)
        {
            inputArea.setVisible(false);
            timer.stop();
            //110 y stand
            Font font3 = new Font("serifPlain",Font.BOLD,30);
        g.setFont(font3);
            playButtonE.setVisible(true);
            g.drawImage(imageBackgroundNext,220,700-moveX,340,442,this);
            playButtonE.setBounds(277,-140+moveX,230,59);
            g.drawString(" "+minCount+":"+secCount ,400,822-moveX);
            g.drawString(" " +scoreCount ,400,872-moveX);
            g.drawString(" " + threeArray[1],440,915-moveX);
            g.drawString(" " + fiveArray[0],440,965-moveX);
            g.drawString(" " + globalLevel,410,1010-moveX); 
            roundOver = true;
            timer2.start();
            inputArea.setVisible(false);
        }
        
      
   
        if(minCount==0 && secCount==0)
        {
            timer.stop();
            //110 y stand
            playButtonE2.setVisible(true);

            inputArea2.setVisible(true);
            g.drawImage(imageBackgroundNext2,220,700-moveX,340,442,this);
            playButtonE2.setBounds(277,-140+moveX,230,59);
          //  g.drawRoundRect()
            Color color = new Color(191, 101, 4);
            g.setColor(color);
            g.fillRoundRect(277,980-moveX,230,59,30,30);
            inputArea2.setBounds(307,980-moveX,170,59);
            g.setColor(Color.BLACK);
            g.drawString(" "+globalLevel,400,822-moveX); 
            g.drawString(" " +scoreCount ,400,872-moveX);
            g.drawString(" " + fourArray[1],440,915-moveX);
            timer2.start();
            roundOver = true;
            inputArea.setVisible(false);
        }
       
        
        
       
       playButtonA.setVisible(false);
       if(yesPrompt==false)
            {
                  getImage("view.png");
                 
                  g.drawImage(imageBackgroundImg,225,250,350,200,this);
                  playButtonNo.setVisible(true);
                   playButtonYes.setVisible(true);
                    playButtonEN.setVisible(false);
            playButtonM.setVisible(false);
            playButtonU.setVisible(false);
            playButtonT.setVisible(false);
                  inputArea.setVisible(false);
                getImage("undoButton.png");
                 g.drawImage(imageBackgroundImg,607,400,90,60,this);
                 getImage("trashButton.png");
                 g.drawImage(imageBackgroundImg,90,400,90,60,this);
                  getImage("enterButton.png");
                 g.drawImage(imageBackgroundImg,277,570,230,59,this);
                 getImage("quitButton.png");
                 g.drawImage(imageBackgroundImg, 15,15,200,60,this);
                

            }
            else 
            {
                 playButtonNo.setVisible(false);
                 playButtonYes.setVisible(false);
                 

            }
            
            
        if(instruct==true)
        {
            Color color = new Color(255, 179, 73,230);
            g.setColor(color);
            g.fillRoundRect(30,30,740,610,30,30);
            inputArea.setVisible(false);
            playButtonEN.setVisible(false);
            playButtonM.setVisible(false);
            playButtonU.setVisible(false);
            playButtonT.setVisible(false);
            playButtonNo.setVisible(false);
          playButtonYes.setVisible(false);
            Font font2 = new Font("serifPlain",Font.BOLD,30);
            g.setFont(font2);
            g.setColor(Color.BLACK);
            g.drawString("Playing The Game",280,90);
            Font font4 = new Font("serifPlain",Font.BOLD,25);
            g.setFont(font4);
             playButtonA.setVisible(true);
            if(pos==0)
            {
                g.drawString("The goal of the game is to",50,140);
                g.drawString("finish the crossword ",50,170);
                g.drawString("by unscrambling the words",50,200);
                g.drawString("the words are provided",50,230);
                g.drawString("at the bottem of the",50,260);
                g.drawString("screen. Using all 5 letters",50,290);
                g.drawString("You must form words.",50,320);
                g.drawString("You need to form a",50,350);
                g.drawString("(3) 3 letter words, (2)",50,380);
                g.drawString("4 and 5 letter words",50,410);
                g.drawString("You can type the words",50,440);
                g.drawString("or you can click on them",50,470);
                g.drawString("Press enter key or button",50,500);
                g.drawString("to sumbit your answers",50,530);
                g.drawString("The trash button clears",50,560);
                g.drawString("Your input, the undo button",50,590);
                g.drawString("deletes a word (delete key too)",50,620);
                g.drawString("The Cross Word Above",430,300);
                g.drawString("Trash Can To Left",460,490);
                g.drawString("Undo to the Right",460,530);
                g.drawString("Enter To The Bottem",450,570);
                getImage("crossWord.png");
                g.drawImage(imageBackgroundImg,410,130,339,138,this);
                getImage("keyArea.png");
                g.drawImage(imageBackgroundImg,410,320,339,138,this);
            }
            else if(pos==1)
            {
                g.drawString("However keep an eye on the",50,140);
                g.drawString("time! You will have 2:30",50,170);
                g.drawString("minutes to complete the ",50,200);
                g.drawString("cross word. If you fail",50,230);
                g.drawString("to complete it in time",50,260);
                g.drawString("You will lose the game,",50,290);
                g.drawString("and can write your name",50,320);
                g.drawString("on the score board to be",50,350);
                g.drawString("displayed. If you beat",50,380);
                g.drawString("the level withn time",50,410);
                g.drawString("You will continue to the",50,440);
                g.drawString("next level. Each level",50,470);
                g.drawString("has reduced time. There",50,500);
                g.drawString("is also a score system",50,530);
                g.drawString("The faster you answer the word",50,560);
                g.drawString("The higher your score.",50,590);
                g.drawString("Good Luck Word Hunters!",50,620);
                playButtonNo.setVisible(false);
          playButtonYes.setVisible(false);
                getImage("TimeSS.png");
                g.drawImage(imageBackgroundImg,410,150,320,92,this);
                getImage("LevelSS.png");
                g.drawImage(imageBackgroundImg,410,270,320,102,this);
                getImage("ScoreSS.png");
                g.drawImage(imageBackgroundImg,410,410,320,92,this);
                
            }
            else 
            {
               instruct = false;
               inputArea.setVisible(true);
               minTimer(); 
            }

            
           


        }
        Font font5 = new Font("serifPlain", Font.BOLD,30);
        g.setFont(font5);

        if(bonus == true)
        {

             g.drawString("Bonus Word! Increased Score Points!",112,375);
        }
         if(menuPanel==true)
        {
           getImage("menuFinal.png");
           g.drawImage(imageBackgroundImg,220,110,340,442,this);
        }
        
    
        
        
          
        
       
    }
     public void createJTextArea2()
    {
        inputArea2 = new JTextArea(10,10);
        inputArea2.setBounds(277,980,230,59);
        inputArea2.setLineWrap(true);  // goes to the next line when printing the text.
        inputArea2.setWrapStyleWord(true); // prevents a word from being split 
        Color blue = new Color(191, 101, 4);
        Font font = new Font("serif",Font.BOLD,50);
        inputArea2.setForeground(Color.WHITE);
        inputArea2.setFont(font);
        inputArea2.setBackground(blue);
        add(inputArea2);
        inputArea2.setText("");
    }
    
    public void playAnim()
    {
      
      Anim2 anim = new Anim2();
      timer2 = new Timer(1,anim);
    }
     class Anim2 implements ActionListener 
	{
	

        public void actionPerformed( ActionEvent evt ) 
		{
            if(minCount==0&&secCount==0&&flag9==true)
            {
             playMusic("gameOv.wav");
             flag9 = false;
            }
            if(flag8 == true)
           {
           playMusic("levelWin.wav");
           flag8 = false;
           }
            if(moveX<590)
            { 
                moveX+=7;
            }
            else
            {
                timer2.stop();
            }
            repaint();
		
		}


	}


    public void nextLevel()
    {
         getStuff();
         flag = false;
         threeArrayB[0] =false;
         threeArrayB[1] =false;
         threeArrayB[2] =false;
         inputArea.setText("");
         fourArrayB[0] = false;
         fourArrayB[1] = false;
         fiveArrayB[0] =false;
         moveX=0;
         flag2 = true;
         flag3 = true;
         flag4 = true;
         flag5 = true;
         flag6 = true;
         flag7 = true;
         flag8 = true;
         globalLevel++;
         if(globalLevel==1)
         {
            minCount=2;
            secCount=45;
         }
         if(globalLevel==2)
         {
            minCount=2;
            secCount=30;
         }
         if(globalLevel==3)
         {
            minCount=2;
            secCount=15;
         }
         if(globalLevel==4)
         {
            minCount=1;
            secCount=59;
         }
         if(globalLevel==5)
         {
            minCount=1;
            secCount=45;
         }
         if(globalLevel==6)
         {
            minCount=1;
            secCount=30;
         }
         if(globalLevel==7)
         {
            minCount=1;
            secCount=15;
         }
         if(globalLevel==8)
         {
            minCount=0;
            secCount=59;
         }
         if(globalLevel==9)
         {
            minCount=0;
            secCount=45;
         }
         if(globalLevel>=10)
         {
            minCount=0;
            secCount=30;
         }

         flag9 = true;
        
         roundOver = false;
         timer2.stop();
         inputArea.setVisible(true);
         playButtonE.setVisible(false);
         timer.start();
         repaint();
     }
    //google people ah
    // ive seen so much models and they just disgust me how perfect they are
    public void getBlueCloudBackground()
    {
        File imageFile = new File("BlueBackground.png");
		try
		{
			imageBackground2 = ImageIO.read(imageFile);
		}
		catch(IOException e) 
		{
			System.err.println("\n\n" + "BlueBackground.png" + " can't be found.\n\n");
		}
    }
    public void getNextLevel()
    {
        File imageFile = new File("nextLevel2.png");
		try
		{
			imageBackgroundNext = ImageIO.read(imageFile);
		}
		catch(IOException e)
		{
			System.err.println("\n\n" + "BlueBackground.png" + " can't be found.\n\n");
		}
    }
    public void getNextLevel2()
    {
        File imageFile = new File("levelFailed.png");
		try
		{
			imageBackgroundNext2 = ImageIO.read(imageFile);
		}
		catch(IOException e)
		{
			System.err.println("\n\n" + "BlueBackground.png" + " can't be found.\n\n");
		}
    }
    public void getImage(String in)
    {
        File imageFile = new File(in);
		try
		{
			imageBackgroundImg = ImageIO.read(imageFile);
		}
		catch(IOException e)
		{
			System.err.println("\n\n" + "BlueBackground.png" + " can't be found.\n\n");
		}
    }
    public void getA(String letterIn)
    {
        File imageFile = new File(letterIn+ ".png"); 
		try
		{ 
			imageBackground = ImageIO.read(imageFile);
		}
		catch(IOException e)
		{
			System.err.println("\n\n" + "BlueBackground.png" + " can't be found.\n\n");
		}
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
            
         }
       }
       catch(Exception e)
       {
        
       }

    }


    public void getG(String letterIn)
    {
        File imageFile = new File(letterIn+ "g.png");
		try
		{
			imageBackground = ImageIO.read(imageFile);
		}
		catch(IOException e)
		{
			System.err.println("\n\n" + "BlueBackground.png" + " can't be found.\n\n");
		}
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        requestFocusInWindow();
        // TODO Auto-generated method stub
        int x = e.getX();
        // g.drawImage(imageBackground,287-x,480,70,70,this);
           //  g.drawImage(imageBackground,207-x,480,70,70,this);
        int y = e.getY();
        if(x>207&&x<277&&y>480&&y<550)
        {
           
            playMusic("mouseClick.wav");
            flag = true;
            String word = inputArea.getText();
            char word2 = letters[0];
            String word4 = "" + word2;
            String word5 = word4.toUpperCase();
            if(word.contains(word5))
            {

            }
            else
            {
             String word3 = word+""+word2;
             inputArea.setText(word3.toUpperCase()); // i have bipolar discorder
            }
         
            repaint();
        }
        if(x>277&&x<347&&y>480&&y<550)
        {
             playMusic("mouseClick.wav");
            flag = true;
            String word = inputArea.getText();
            char word2 = letters[1];
            String word4 = "" + word2;
            String word5 = word4.toUpperCase();
            if(word.contains(word5))
            {

            }
            else
            {
             String word3 = word+""+word2;
             inputArea.setText(word3.toUpperCase()); // i have bipolar discorder
            }
            repaint();
        }
        if(x>347&&x<424&&y>480&&y<550)
        {
           playMusic("mouseClick.wav");
            flag = true;
            String word = inputArea.getText();
            char word2 = letters[2];
            String word4 = "" + word2;
            String word5 = word4.toUpperCase();
            if(word.contains(word5))
            {

            }
            else
            {
             String word3 = word+""+word2;
             inputArea.setText(word3.toUpperCase()); // i have bipolar discorder
            }
            repaint();
        }
        if(x>424&&x<494&&y>480&&y<550)
        {
           playMusic("mouseClick.wav");
            flag = true;
            String word = inputArea.getText();
            char word2 = letters[3];
            String word4 = "" + word2;
            String word5 = word4.toUpperCase();
            if(word.contains(word5))
            {

            }
            else
            {
             String word3 = word+""+word2;
             inputArea.setText(word3.toUpperCase()); // i have bipolar discorder
            }
            repaint();
        }
        if(x>494&&x<564&&y>480&&y<550)
        {
            playMusic("mouseClick.wav");
            flag = true;
            String word = inputArea.getText();
            char word2 = letters[4];
            String word4 = "" + word2;
            String word5 = word4.toUpperCase();
            if(word.contains(word5))
            {

            }
            else
            {
             String word3 = word+""+word2;
             inputArea.setText(word3.toUpperCase()); // i have bipolar discorder
            }
            repaint();
        }
         
       
    }

    @Override
    public void mousePressed(MouseEvent e) {
        // TODO Auto-generated method stub
        JComponent comp = (JComponent) e.getSource();
        comp.requestFocusInWindow();
    }

    public void resetNextLevel()
    {

    }

    @Override
    public void mouseReleased(MouseEvent e) {
        // TODO Auto-generated method stub
       
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        // TODO Auto-generated method stub
        
        
        
        
    }

    @Override
    public void mouseExited(MouseEvent e) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void keyTyped(KeyEvent e) {
        // TODO Auto-generated method stub
        requestFocusInWindow();
        if(e.getKeyChar()-32 == letters[0] || e.getKeyChar()-32== letters[1]|| e.getKeyChar()-32== letters[2]|| e.getKeyChar()-32== letters[3]|| e.getKeyChar()-32== letters[4])
        {
           playMusic("mouseClick.wav");
           flag = true;
           String word = inputArea.getText();
           char word2 = e.getKeyChar();
           String word4 = "" + word2;
           String word5 = word4.toUpperCase();
           if(word.contains(word5))
           {

           }
           else
           {
             String word3 = word+""+word2;
             inputArea.setText(word3.toUpperCase()); // i have bipolar discorder
           }
           
           repaint();

        }
      
    }

    @Override
    public void keyPressed(KeyEvent e) {
        // TODO Auto-generated method stub

        if (e.getKeyCode() == KeyEvent.VK_BACK_SPACE)
        {
            String word = inputArea.getText();
          
            if(word.isEmpty()==false)
            {
                String word2 = word.substring(0,word.length()-1);
               
                inputArea.removeAll();
                 inputArea.setText(word2.toUpperCase());
                 inputArea.getDocument();
                 playMusic("deleteKey.wav");
            }
            repaint();
            
        }
        
        if(e.getKeyCode() == KeyEvent.VK_ENTER)
        {
           bonus = false;
           boolean inflag = true;
            
           if(inputArea.getText().length()==3)
            {
                if(inputArea.getText().equalsIgnoreCase(threeArray[0]))
                {
                     threeArrayB[0]=true;
                     repaint();
                     inputArea.setText("");
                     inflag = false;
                }
            if(inputArea.getText().equalsIgnoreCase(threeArray[1]))
            {
                 threeArrayB[1]=true;
                 repaint();
                 inputArea.setText("");
                 inflag = false;
            }
             if(inputArea.getText().equalsIgnoreCase(threeArray[2]))
            {
                threeArrayB[2]=true;
                repaint();
                inputArea.setText("");
                inflag = false;
            }

            }
            if(inputArea.getText().length()==4)
            {
               if(inputArea.getText().equalsIgnoreCase(fourArray[0]))
                {
                     fourArrayB[0]=true;
                     repaint();
                     inputArea.setText("");
                     inflag = false;
                }
                if(inputArea.getText().equalsIgnoreCase(fourArray[1]))
                {
                     fourArrayB[1]=true;
                     repaint();
                     inputArea.setText("");
                     inflag = false;
                }
            }
            if(inputArea.getText().length()==5)
            {
                if(inputArea.getText().equalsIgnoreCase(fiveArray[0]))
                {
                     fiveArrayB[0]=true;
                     repaint();
                     inputArea.setText("");
                     inflag = false;
                }
            }
    
            if(inflag == true)
            {
                boolean ans = check_for_word(inputArea.getText());
                
                inflag = false;
                if(ans ==true&&inputArea.getText().length()>=3)
                {
                   scoreCount+=5;   
                   System.out.println("realword");
                   bonus = true;    
                   inputArea.setText("");
                   repaint();
                }
              //  playBonus();
            }
           
            
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        // TODO Auto-generated method stub
       
    }

     public void trashButton()
    {
        JButton playButton;
         ImageIcon imageB5 = null;
         try 
         {
            imageB5 =  new ImageIcon("trashButton.png");
         }
         catch (Exception ex) 
        {
             System.out.println(ex);
        }
        playButtonT = new JButton(imageB5);
        playButtonT.setOpaque(false);
        TrashHandler th = new TrashHandler();
        playButtonT.addActionListener(th);
        playButtonT.setBorderPainted(false); 
        playButtonT.setContentAreaFilled(false); 
        playButtonT.setFocusPainted(false); 
        playButtonT.setBounds(90,400,90,60);
        this.add(playButtonT);
    }
    public void enterButton2()
    {
        
         ImageIcon imageB5 = null;
         try 
         {
            imageB5 =  new ImageIcon("enterButton.png");
         }
         catch (Exception ex) 
        {
             System.out.println(ex);
        }
        playButtonE = new JButton(imageB5);
        playButtonE.setOpaque(false);
        playButtonE.setBorderPainted(false); 
        playButtonE.setContentAreaFilled(false); 
        playButtonE.setFocusPainted(false); 
        playButtonE.setBounds(277,-140,230,59);
        Enter2Handler e2h = new Enter2Handler();
        playButtonE.addActionListener(e2h);
        this.add(playButtonE);
    }
     public void arrowButton()
    {
        
         ImageIcon imageB5 = null;
         try 
         {
            imageB5 =  new ImageIcon("arrow.png");
         }
         catch (Exception ex) 
        {
             System.out.println(ex);
        }
        playButtonA = new JButton(imageB5);
        playButtonA.setOpaque(false);
        playButtonA.setBorderPainted(false); 
        playButtonA.setContentAreaFilled(false); 
        ArrowHandler ah = new ArrowHandler();
        playButtonA.addActionListener(ah);
        playButtonA.setFocusPainted(false); 
        playButtonA.setBounds(675,575,70,50);
        this.add(playButtonA);
    }
    public void enterButton3()
    {
        
         ImageIcon imageB5 = null;
         try 
         {
            imageB5 =  new ImageIcon("enterButton.png");
         }
         catch (Exception ex) 
        {
             System.out.println(ex);
        }
        playButtonE2 = new JButton(imageB5);
        playButtonE2.setOpaque(false);
        playButtonE2.setBorderPainted(false); 
        playButtonE2.setContentAreaFilled(false); 
        playButtonE2.setFocusPainted(false); 
        playButtonE2.setBounds(277,-140,230,59);
       Enter3Handler e2h = new Enter3Handler();
        playButtonE2.addActionListener(e2h);
        this.add(playButtonE2);
    }
 class Enter2Handler implements ActionListener 
	{
		public void actionPerformed(ActionEvent evt) 
		{
          nextLevel();
          playMusic("buttonClick.wav");

		}
	}	
    class Enter3Handler implements ActionListener 
	{
		public void actionPerformed(ActionEvent evt) 
		{
         
          getScore();
           nextLevel();
          gg.cards.show(gg.cardPanel,"scoreBoard"); 
          playButtonE2.setVisible(false);
          scoreCount = 0;
          inputArea2.setVisible(false);
          playMusic("buttonClick.wav");
          

		}
	}	
    class TrashHandler implements ActionListener 
	{
		public void actionPerformed(ActionEvent evt) 
		{
          inputArea.setText("");
          playMusic("buttonClick.wav");
		}
	}
    class NoHandler implements ActionListener 
	{
		public void actionPerformed(ActionEvent evt) 
		{
          minTimer();
          yesPrompt = true;
          inputArea.setVisible(true);
          playMusic("buttonClick.wav");
          repaint();
		}
	}
     class YesHandler implements ActionListener 
	{
		public void actionPerformed(ActionEvent evt) 
		{
          instruct = true;
          playButtonNo.setVisible(false);
          yesPrompt = true;
          playButtonYes.setVisible(false);
          playMusic("buttonClick.wav");
          repaint();
		}
	}
    class ArrowHandler implements ActionListener 
	{

        public void actionPerformed(ActionEvent evt) 
		{
           pos+=1;
           repaint();
           playMusic("buttonClick.wav");
           
		}
	}	
     class UndoHandler implements ActionListener 
	{
		public void actionPerformed(ActionEvent evt) 
		{
          String word = inputArea.getText();
          
            if(word.isEmpty()==false)
            {
                String word2 = word.substring(0,word.length()-1);
               
                inputArea.removeAll();
                 inputArea.setText(word2.toUpperCase());
                 inputArea.getDocument();
                 playMusic("buttonClick.wav");
            }
            repaint();
		}
	}	
    /*
     * Checks to see if the player has clicked the enter button or pressed the enter key
     * If so, it runs actions in order to display the words on our screen.
     */
    class EnterHandler implements ActionListener 
	{
		public void actionPerformed(ActionEvent evt) 
		{
            /* These series of if blocks check if 
             * the entered word is a 3 letter word, 
             * If so it checks to see if its equal to the word
             * thats supposed to be in that spot. If that is also
             * true it resets the input spot and sets the word
             * to true, calling repaint which displays the word to
             * our eyes. This also applys to the 4 letter words
             * and the 5 letter words
             */
            boolean inflag = true;
           if(inputArea.getText().length()==3)
            {
                if(inputArea.getText().equalsIgnoreCase(threeArray[0]))
                {
                     threeArrayB[0]=true;
                     repaint();
                     inputArea.setText("");
                     inflag = false; 
                }
            if(inputArea.getText().equalsIgnoreCase(threeArray[1]))
            {
                 threeArrayB[1]=true;
                 repaint();
                 inputArea.setText("");
                  inflag = false; 
            }
             if(inputArea.getText().equalsIgnoreCase(threeArray[2]))
            {
                threeArrayB[2]=true;
                repaint();
                inputArea.setText("");
                 inflag = false;
            }

            }
            /*
             * The 4 letter words
             */
            if(inputArea.getText().length()==4)
            {
               if(inputArea.getText().equalsIgnoreCase(fourArray[0]))
                {
                     fourArrayB[0]=true;
                     repaint();
                     inputArea.setText("");
                      inflag = false;
                }
                if(inputArea.getText().equalsIgnoreCase(fourArray[1]))
                {
                     fourArrayB[1]=true;
                     repaint();
                     inputArea.setText("");
                      inflag = false;
                }
            }
            /*
             * Finally the 5 letter words
             */
            if(inputArea.getText().length()==5)
            {
                if(inputArea.getText().equalsIgnoreCase(fiveArray[0]))
                {
                     fiveArrayB[0]=true;
                     repaint();
                     inputArea.setText("");
                     inflag = false;
                }
            }

            if(inflag == true)
            {
                boolean ans = check_for_word(inputArea.getText());
                inflag = false;
                scoreCount+=25; 
            }
            
		}
	}	
    public boolean check_for_word(String word)  {
        // System.out.println(word);
        
       try {
            BufferedReader in = new BufferedReader(new FileReader(
                "words2.txt"));
            String str;
            while ((str = in.readLine()) != null) {
                if (str.indexOf(word) != -1) {
                    return true;
                }
            }
            in.close();
        } catch (IOException e) {
        }

        return false;
    
    }
    public void undoButton()
    {
        
         ImageIcon imageB4 = null;
         try 
         {
            imageB4= new ImageIcon("undoButton.png");
         }
         catch (Exception ex) 
        {
             System.out.println(ex);
        }
        playButtonU = new JButton(imageB4);
        UndoHandler uh = new UndoHandler();
        playButtonU.addActionListener(uh);
        playButtonU.setOpaque(false);
        playButtonU.setBorderPainted(false); 
        playButtonU.setContentAreaFilled(false); 
        playButtonU.setFocusPainted(false); 
        playButtonU.setBounds(607,400,90,60);
        this.add(playButtonU);
    }
    public void noButton()
    {
        
         ImageIcon imageB4 = null;
         try 
         {
            imageB4= new ImageIcon("noButton.png");
         }
         catch (Exception ex) 
        {
             System.out.println(ex);
        }
        playButtonNo = new JButton(imageB4);
        NoHandler uh = new NoHandler();
        playButtonNo.addActionListener(uh);
        playButtonNo.setOpaque(false);
        playButtonNo.setBorderPainted(false); 
        playButtonNo.setContentAreaFilled(false); 
        playButtonNo.setFocusPainted(false); 
        playButtonNo.setBounds(275,360,100,60);
        this.add(playButtonNo);
    }
    public void yesButton()
    {
        
         ImageIcon imageB4 = null;
         try 
         {
            imageB4= new ImageIcon("yesButton.png");
         }
         catch (Exception ex) 
        {
             System.out.println(ex);
        }
        playButtonYes = new JButton(imageB4);
       YesHandler uh = new YesHandler();
    
        playButtonYes.addActionListener(uh);
        playButtonYes.setOpaque(false);
        playButtonYes.setBorderPainted(false); 
        playButtonYes.setContentAreaFilled(false); 
        playButtonYes.setFocusPainted(false); 
        playButtonYes.setBounds(425,360,100,60);
        this.add(playButtonYes);
    }

    public void quitButton()
    {
        JButton playButton;
         ImageIcon imageB2 = null;
         try 
         {
            imageB2= new ImageIcon("enterButton.png");
         }
         catch (Exception ex) 
        {
             System.out.println(ex);
        }
        playButtonEN = new JButton(imageB2);
        playButtonEN.setOpaque(false);
        EnterHandler eh = new EnterHandler();
        playButtonEN.addActionListener(eh);
        playButtonEN.setBorderPainted(false); 
        playButtonEN.setContentAreaFilled(false); 
        playButtonEN.setFocusPainted(false); 
        playButtonEN.setBounds(277,570,230,59);
        this.add(playButtonEN);
    }
    public void getScore()
    {
        try
            {
                FileWriter fileWriter = new FileWriter("scores.txt",true);
                printWriter = new PrintWriter(fileWriter); //   opens the printwriter to that file
            }
            catch(IOException e)
            {
                e.printStackTrace();
            }
            printWriter.println(inputArea2.getText()+" " + scoreCount); // prints the players score into the text file
            printWriter.close();

    }
    public void menuButton()
    {
       
         ImageIcon imageB2 = null;
         try 
         {
            imageB2= new ImageIcon("quitButton.png");
         }
         catch (Exception ex) 
        {
             System.out.println(ex);
        }
        playButtonM = new JButton(imageB2);
        playButtonM.setOpaque(false);
        MenuHandler mh = new MenuHandler();
        playButtonM.addActionListener(mh);
        playButtonM.setBorderPainted(false); 
        playButtonM.setContentAreaFilled(false); 
        playButtonM.setFocusPainted(false); 
        playButtonM.setBounds(15,15,200,60);
        this.add(playButtonM); 
    }
    class MenuHandler implements ActionListener 
	{
		public void actionPerformed(ActionEvent evt) 
		{
            gg.cards.show(gg.cardPanel,"WordCrypticMenu");
            timer.stop();
            playMusic("buttonClick.wav");
            roundOver = true;
            yesPrompt = false;
            minCount =2;
            scoreCount = 0;
            secCount = 59;
		}

	}	
}