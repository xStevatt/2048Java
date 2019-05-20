package my2048;

import java.awt.*; 
import static java.awt.Frame.NORMAL;
import java.awt.event.*; 
import java.io.*; 
import java.text.SimpleDateFormat;
import java.util.*; 
import javax.swing.*;

/**
 *
 * @author Stefano Valloncini & Matteo Botti
 */

public class GameManager implements KeyListener
{
    Tile[] blocchi;
    JPanel panel;
    int moveFlag;
    boolean numFlag;
        
    public int controllo = 1; 
    public int controllo2 = 1; 
        
    public int score = 0; 
    public String dateString = null; 
    public String nomePlayer = null; 
        
    private int numeriSpawn1 = 2; 
    private int numeriSpawn2 = 4; 
    private boolean cheats = false; 
        
    public static ArrayList<Score> listaPlayers = new ArrayList<>(); 
        
	
    public GameManager(JFrame frame, String nomePlayer, boolean cheats)
    {   
        this.panel = (JPanel)frame.getContentPane();
        blocchi = new Tile[16];
        
        numFlag = true;
        moveFlag = 0;
        
        this.cheats = cheats; 
        this.nomePlayer = nomePlayer; 
        this.centraFinestra(frame);
        aggiungiBlocchi();
            
        if(cheats)
        {
            this.numeriSpawn1 = 2048; // seleziona i numeri da spawnare in caso 
            this.numeriSpawn2 = 4096; 
        }
            
        for(int i = 0; i < 2; i++)
            mostraBlocchi();
		
        frame.addKeyListener(this);
    }
        
        
    public void centraFinestra(JFrame frame) 
    {
        Dimension dimension = Toolkit.getDefaultToolkit().getScreenSize();
        int x = (int) ((dimension.getWidth() - frame.getWidth()) / 2);
        int y = (int) ((dimension.getHeight() - frame.getHeight()) / 2);
        frame.setLocation(x, y);
    }
        
    private void aggiungiBlocchi()
    {   
        for (int i = 0; i < 16; i++) 
        {
            blocchi[i] = new Tile();
            blocchi[i].setHorizontalAlignment(JLabel.CENTER);
            blocchi[i].setOpaque(true);
            panel.add(blocchi[i]);
        }
    }

	
    public void mostraBlocchi()
    {   
        while (numFlag) 
        {
            controllo2 = 1; 
            // Genera numero casuale (2 - 4)
            int index = (int) (Math.random() * 16);
            if (blocchi[index].getValue() == 0) 
            {
                if (Math.random() < 0.5)
                    blocchi[index].setValue(numeriSpawn1);
                else
                    blocchi[index].setValue(numeriSpawn1);
                break;
            }
        }
    }

	
    public void controllaBlocchi() 
    {
        int sum = 0;
                
        for (int i = 0; i < 16; i++) 
        {
            if (blocchi[i].getValue() != 0)
            {
                sum++;
                score += blocchi[i].getValue(); 
            }
        }
            
        if (sum == 16)
            numFlag = false;
    }

    // Sposta verso l'alto le caselle, itera e le somma
    public void spostaSopra()
    {
        for (int i = 12; i < 16; i++) 
        {
            int index = i;
            for (int j = i - 4; j >= i - 12; j -= 4)
            {
                int valoreI = blocchi[index].getValue(), valoreJ = blocchi[j].getValue();
                
                if (valoreJ == 0) 
                {
                    blocchi[index].setValue(0);
                    blocchi[j].setValue(valoreI);
                } 
                
                else 
                {
                    if (valoreI == valoreJ) 
                    {
                        blocchi[index].setValue(0);
                        blocchi[j].setValue(valoreI + valoreJ);
                        
                        if (valoreI + valoreJ == 4096)
                            win();
                        
                        numFlag = true;
                        moveFlag = 0;
                        
                        if(j > (i - 12))
                            if(blocchi[j-4].getValue()==(valoreI+valoreJ))
                                break;
                    } 
                    
                    else if (numFlag == false)
                        moveFlag += 1;
                }
                index = j;	
            }
        }
    }

// Sposta verso il basso le caselle, itera e le somma
    public void spostaSotto() 
    {
        for (int i = 0; i < 4; i++) 
        {
            int index = i;
            
            for (int j = i + 4; j <= i + 12; j += 4)
            {
                int valoreI = blocchi[index].getValue();
                int valoreJ = blocchi[j].getValue();
                
                if (valoreJ == 0) 
                {
                    blocchi[index].setValue(0);
                    blocchi[j].setValue(valoreI);
                } 
                
                else 
                {
                    if (valoreI == valoreJ) 
                    {
                        blocchi[index].setValue(0);
                        blocchi[j].setValue(valoreI + valoreJ);
                        
                        if (valoreI + valoreJ == 4096)
                            win();
						
                        numFlag = true;
                        moveFlag = 0;
                        
                        if(j < (i + 12))
                            if(blocchi[j + 4].getValue()==(valoreI + valoreJ))
                                break;
                    } 
                    else if (numFlag == false)
                        moveFlag += 1;
                }
                index = j;
            }
        }
    }
	
    public void spostaDestra()
    {
        for (int i = 0; i <= 12; i += 4) 
        {
            int index = i;
            
            for (int j = i + 1; j <= i + 3; j++)
            {
                int valoreI = blocchi[index].getValue(), valoreJ = blocchi[j].getValue();
                    
                if (valoreJ == 0)
                {
                            
                    blocchi[index].setValue(0);
                    blocchi[j].setValue(valoreI);
                } 
                    
                else 
                {
                    if (valoreI == valoreJ) 
                    {
                        blocchi[index].setValue(0);
                        blocchi[j].setValue(valoreI + valoreJ);
                                
                        if (valoreI + valoreJ == 4096)
                            win();
                               
                        numFlag = true;
                        moveFlag = 0;
                            
                        if(j < (i + 3))
                            if(blocchi[j + 1].getValue()==(valoreI + valoreJ))
                                break;
                        
                    } 
                    else if (numFlag == false)
                        moveFlag += 1;
                }
                index = j;
            }
        }
    }
	
    public void spostaSinistra()
    {
        for (int i = 3; i <= 15; i += 4)
        {
            int index = i;
            for (int j = i - 1; j >= i - 3; j--)
            {
                int valoreI = blocchi[index].getValue(); 
                int valoreJ  = blocchi[j].getValue();
                
                if (valoreJ == 0) 
                {
                    blocchi[index].setValue(0);
                    blocchi[j].setValue(valoreI);
                } 
                
                else 
                {
                    if (valoreI == valoreJ) 
                    {
                        blocchi[index].setValue(0);
                        blocchi[j].setValue(valoreI + valoreJ);
			
                        if (valoreI + valoreJ == 4096)
                            win();
                        
                        numFlag = true;
                        moveFlag = 0;
			
                        if(j < (i - 3))
                            if(blocchi[j-1].getValue() == (valoreI + valoreJ))
                                break;
                    } 
                    
                    else if (numFlag == false)
                        moveFlag += 1;
                }
                index = j;
            }
        }
    }
    
    
        
    public void saveScore(String nomePlayer, int score)
    {   
        try
        {
            File fileLeader = new File("Files\\textfiles\\leaderboard.txt"); 
            FileWriter tempWriter = new FileWriter(fileLeader, true); 
               
            BufferedWriter writer = new BufferedWriter(tempWriter); 
            SimpleDateFormat format = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
               
            dateString = format.format(new Date());
            Score sc = new Score(score, nomePlayer, dateString); 
                
            writer.append(nomePlayer + " - " + score + " - " + dateString); 
            writer.newLine();
            writer.close(); 
                
            System.out.println("New Score Added: " + nomePlayer + " - " + score + " - " + dateString);
        }
            
        catch(Exception e)
        {
            e.printStackTrace();
        }
    }
        
	
    public void fine()
    {   
        controllo = 1; 
            
        if (!numFlag && moveFlag >= 36) 
        {   
            try
            {
                blocchi[4].setFont(Font.createFont(NORMAL, new FileInputStream(new File("Files\\Fonts\\ClearSansFont.ttf"))).deriveFont(Font.PLAIN, 40));
                blocchi[4].setText("G");
                blocchi[5].setFont(Font.createFont(NORMAL, new FileInputStream(new File("Files\\Fonts\\ClearSansFont.ttf"))).deriveFont(Font.PLAIN, 40));
                blocchi[5].setText("A");
                blocchi[6].setFont(Font.createFont(NORMAL, new FileInputStream(new File("Files\\Fonts\\ClearSansFont.ttf"))).deriveFont(Font.PLAIN, 40));
                blocchi[6].setText("M");
                blocchi[7].setFont(Font.createFont(NORMAL, new FileInputStream(new File("Files\\Fonts\\ClearSansFont.ttf"))).deriveFont(Font.PLAIN, 40));
                blocchi[7].setText("E");
                blocchi[8].setFont(Font.createFont(NORMAL, new FileInputStream(new File("Files\\Fonts\\ClearSansFont.ttf"))).deriveFont(Font.PLAIN, 40));
                blocchi[8].setText("O");
                blocchi[9].setFont(Font.createFont(NORMAL, new FileInputStream(new File("Files\\Fonts\\ClearSansFont.ttf"))).deriveFont(Font.PLAIN, 40));
                blocchi[9].setText("V");
                blocchi[10].setFont(Font.createFont(NORMAL, new FileInputStream(new File("Files\\Fonts\\ClearSansFont.ttf"))).deriveFont(Font.PLAIN, 40));
                blocchi[10].setText("E");
                blocchi[11].setFont(Font.createFont(NORMAL, new FileInputStream(new File("Files\\Fonts\\ClearSansFont.ttf"))).deriveFont(Font.PLAIN, 40));
                blocchi[11].setText("R");
            }
                
            catch(Exception e)
            {
                System.err.println("Font not found!");
            }
                
            blocchi[12].setText("");
            blocchi[12].setIcon(new ImageIcon(new ImageIcon("Files\\pictures\\exit.png").getImage().getScaledInstance(50, 50, Image.SCALE_DEFAULT)));
            
            while(controllo2 == 1)
            {
                controllo2++; 
                saveScore(nomePlayer, score);
            }
            
                 
            blocchi[12].addMouseListener(new MouseAdapter() {
                    
            @Override
                
            public void mousePressed(MouseEvent e)
            {      
                while(controllo == 1)
                {
                    controllo++; 
                    ImageIcon icon = new ImageIcon((new ImageIcon("Files\\pictures\\2048.png").getImage().getScaledInstance(50, 50, Image.SCALE_DEFAULT)));
                    
                    int input = JOptionPane.showConfirmDialog(null, "Do you really want to close the game?", "U sure brah?",    
                    JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.INFORMATION_MESSAGE, icon); 

                    if(input == 0)
                    {
                        System.exit(0);
                    }
                            
                    else
                    {   
                        blocchi[12].setIcon(null);
                        blocchi[15].setIcon(null);
                            
                        reStart();
                    }
                }
            }
            });
                
                
            blocchi[15].setText("");
		
            blocchi[15].setIcon(new ImageIcon(new ImageIcon("Files\\pictures\\restart.png").getImage().getScaledInstance(50, 50, Image.SCALE_DEFAULT)));	
                
                
            blocchi[15].addMouseListener(new MouseAdapter() {
                @Override
                    
                public void mousePressed(MouseEvent e)
                {
                    reStart();
                    blocchi[12].setIcon(null);
                    blocchi[15].setIcon(null);
                }
            });
        }
    }
    
	public void win() 
        {   
            /*
            try
            {
                blocchi[0].setFont(Font.createFont(NORMAL, new FileInputStream(new File("Files\\Fonts\\ClearSansFont.ttf"))).deriveFont(Font.PLAIN, 40));
                blocchi[0].setText("Y");
                blocchi[1].setFont(Font.createFont(NORMAL, new FileInputStream(new File("Files\\Fonts\\ClearSansFont.ttf"))).deriveFont(Font.PLAIN, 40));
                blocchi[1].setText("O");
                blocchi[2].setFont(Font.createFont(NORMAL, new FileInputStream(new File("Files\\Fonts\\ClearSansFont.ttf"))).deriveFont(Font.PLAIN, 40));
                blocchi[2].setText("U");
                blocchi[13].setFont(Font.createFont(NORMAL, new FileInputStream(new File("Files\\Fonts\\ClearSansFont.ttf"))).deriveFont(Font.PLAIN, 40));
                blocchi[13].setText("W");
                blocchi[14].setFont(Font.createFont(NORMAL, new FileInputStream(new File("Files\\Fonts\\ClearSansFont.ttf"))).deriveFont(Font.PLAIN, 40));
                blocchi[14].setText("I");
                blocchi[15].setFont(Font.createFont(NORMAL, new FileInputStream(new File("Files\\Fonts\\ClearSansFont.ttf"))).deriveFont(Font.PLAIN, 40));
                blocchi[15].setText("N");
            }
            catch(Exception e)
            {
                System.err.println("Font not found!");
            }
            
            try
            {
                Thread.sleep(10000); 
            }
            catch(Exception e)
            {
                System.err.println("Error!");
            }
            
            blocchi[15].addMouseListener(new MouseAdapter() 
            {
                @Override
                public void mousePressed(MouseEvent e)
                {
                    reStart();
                }
            });
*/    
	}
        
    public void reStart()
    {
    	numFlag = true;
	moveFlag = 0;
        
	for(int i = 0; i < 16; i++)
            blocchi[i].setValue(0);
    	for (int i = 0; i < 2; i++)
            mostraBlocchi();
    }
    @Override
    public void keyPressed(KeyEvent e)
    {
        switch (e.getKeyCode())
        {
            case KeyEvent.VK_UP:
                        spostaSopra();
			controllaBlocchi();
			mostraBlocchi();
			fine();
			break;
            case KeyEvent.VK_DOWN:
			spostaSotto();
			controllaBlocchi();
			mostraBlocchi();
			fine();
			break;
            case KeyEvent.VK_LEFT:
			spostaSinistra();
			controllaBlocchi();
			mostraBlocchi();
			fine();
			break;
            case KeyEvent.VK_RIGHT:
			spostaDestra();
			controllaBlocchi();
			mostraBlocchi();
			fine();
			break;
		}
	}
	
	@Override
	public void keyTyped(KeyEvent e) {
	}

	@Override
	public void keyReleased(KeyEvent e) {
	}    
}
