package my2048;

import java.awt.*; 
import static java.awt.Frame.*; 
import java.io.*; 
import javax.swing.*; 


/**
 *
 * @author Stefano Valloncini & Matteo Botti
 */

@SuppressWarnings("serial")
public class Tile extends JLabel {
	private int value;
        
        Font clearSans = null; 
        
	public Tile() 
        {
            
            try
            {
                clearSans = Font.createFont(NORMAL, new FileInputStream(new File("Files\\Fonts\\ClearSansFont.ttf"))).deriveFont(Font.PLAIN, 40);
            }
            catch(Exception e)
            {
                e.printStackTrace();
            }
            
            value = 0;
            setFont(clearSans);
            setBackground(Color.gray);
	}

	public int getValue()
        {
            return value;
	}
               
	public void setValue(int value) 
        {
            this.value = value;
            String text = String.valueOf(value);
                
            if (value != 0)
                setText(text);
            else
                setText("");
            
            changeFont(); 
            setColor();
	}
        
        public void changeFont() 
        {   
            if(value >= 16384)
            {
                try
                {
                    setFont(Font.createFont(NORMAL, new FileInputStream(new File("Files\\Fonts\\ClearSansFont.ttf"))).deriveFont(Font.PLAIN, 15));
                }
                catch(Exception e)
                {
                    System.err.println("Font not found!");
                }
            }
            
            if(value >= 1024)
            {
                try
                {
                    setFont(Font.createFont(NORMAL, new FileInputStream(new File("Files\\Fonts\\ClearSansFont.ttf"))).deriveFont(Font.PLAIN, 20));
                }
                catch(Exception e)
                {
                    System.err.println("Font not found!");
                }
            }
            else
            {
                try
                {
                    setFont(Font.createFont(NORMAL, new FileInputStream(new File("Files\\Fonts\\ClearSansFont.ttf"))).deriveFont(Font.PLAIN, 40));
                }
                catch(Exception e)
                {
                    System.err.println("Font not found!");
                }
            }
        }
        
	public void setColor() {

		switch (value) {
		case 0:
			setBackground(Color.gray);
			break;
		case 2:
			setBackground(new Color(238, 228, 218));
			break;
		case 4:
			setBackground(new Color(238, 224, 198));
			break;
		case 8:
			setBackground(new Color(243, 177, 116));
			break;
		case 16:
			setBackground(new Color(243, 177, 116));
			break;
		case 32:
			setBackground(new Color(248, 149, 90));
			break;
		case 64:
			setBackground(new Color(249, 94, 50));
			break;
		case 128:
			setBackground(new Color(239, 207, 108));
			break;
		case 256:
			setBackground(new Color(239, 207, 99));
			break;
		case 512:
			setBackground(new Color(239, 203, 82));
			break;
		case 1024:
			setBackground(new Color(239, 199, 57));
			break;
		case 2048:
			setBackground(new Color(239, 195, 41));
			break;
		case 4096:
			setBackground(new Color(255, 60, 57));
			break;
                case 8192:
			setBackground(new Color(0, 232, 231));
			break;
                case 16384:
			setBackground(new Color(255, 255, 3));
			break;
                case 32768:
			setBackground(new Color(99, 222, 43));
			break;
                case 65536:
			setBackground(new Color(123, 60, 57));
			break;   
                case 65536 * 2: 
                        setBackground(new Color(123, 123, 12)); 
                        break; 
                case (65536 * 2) * 2: 
                        setBackground(new Color(2, 233, 123)); 
                        break; 
                default:
                        setBackground(new Color(0, 0, 0)); 
		}
	}
}
