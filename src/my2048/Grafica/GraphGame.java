package my2048.Grafica;

import java.awt.*; 
import java.util.Vector;
import javax.swing.*;
import my2048.*; 

/**
 *
 * @author Stefano Valloncini & Matteo Botti
 */

@SuppressWarnings("")
public class GraphGame extends JFrame
{

        
    public static Vector <String> leaderboard = new Vector<String>(1, 1); 
    
	public GraphGame(String nomePlayer, boolean cheats) 
        {
            setTitle("2048");
            setSize(400, 400);
            setLocation(500, 200);
            setResizable(false);
            setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
            getContentPane().setLayout(new GridLayout(4, 4, 5, 5));
            new GameManager(this, nomePlayer, cheats);
            this.setVisible(true);
	}

	public static void main(String args[])
        {
            new GraphMenu(); 
	}
}
