package my2048.Grafica;

import java.awt.*; 
import static java.awt.Frame.NORMAL;
import java.io.*; 
import java.util.Scanner;
import javax.swing.*; 
import static my2048.GameManager.listaPlayers;
import static my2048.Grafica.GraphMenu.clearSans;
import my2048.Score;

/**
 *
 * @author Stefano Valloncini & Matteo Botti
 */

@SuppressWarnings("")
public class GraphLeaderboard extends javax.swing.JFrame
{   
    
    int indexTableX = 0; 
    public static JTable jTable1 = new JTable(); 
    String parts[]; 
            
    public GraphLeaderboard() throws FileNotFoundException, FontFormatException, IOException
    {   
        centreWindow();
                
        this.setTitle("2048 - Leaderboard");
        this.setResizable(false);
        this.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        
        initComponents();
        
        readFile(); 
        //bubbleSort();
        changeTable();
        
        jTable1.setFont(Font.createFont(NORMAL, new FileInputStream(new File("Files\\Fonts\\ClearSansFont.ttf"))).deriveFont(Font.PLAIN, 12));
        
        
        this.setVisible(true);
    }

    public void readFile() throws FileNotFoundException
    {   
        try
        {
            File leaderboard = new File("Files\\textfiles\\leaderboard.txt"); 
            Scanner scReader = new Scanner(leaderboard);
            
            while(scReader.hasNextLine())
            {    
                                    
                boolean check = false; 
                Score sc = null; 
                // score name date
                try
                {
                    parts = scReader.nextLine().split(" - ", 0); 

                    sc = new Score(Integer.parseInt(parts[1]), parts[2], parts[0]); 

                    for(int i = 0; i < listaPlayers.size(); i++)
                    {   
                        if(listaPlayers.get(i).getDate().equalsIgnoreCase(parts[0]))
                            check = true; 
                    }

                    if(check == false)
                    {
                        listaPlayers.add(sc); 
                    }   
                }
                catch(Exception e)
                {}
 
            }
        }
        catch(Exception e)
        {}
    }
        
    public void centreWindow() 
    {
        Dimension dimension = Toolkit.getDefaultToolkit().getScreenSize();
        int x = (int) ((dimension.getWidth() - this.getWidth()) / 2);
        int y = (int) ((dimension.getHeight() - this.getHeight()) / 2);
        this.setLocation(x, y);
    }
    
    public void changeTable() 
    {   
        indexTableX = 0; 
        
        for(int i = 0; i < 14; i++)
        {
            try
            {   
                jTable1.getModel().setValueAt(listaPlayers.get(i).getName(), indexTableX, 3);
                jTable1.getModel().setValueAt(listaPlayers.get(i).getScore(), indexTableX, 2);
                jTable1.getModel().setValueAt(listaPlayers.get(i).getDate(), indexTableX, 1);
                indexTableX++; 
            }
            catch(Exception e)
            {
                
            }
        }
    }

        private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel1.setBackground(new Color(186, 172, 159));

        jLabel1.setFont(clearSans);
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Leaderboard");
        
        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {"> 1", null, null, null},
                {"> 2", null, null, null},
                {"> 3", null, null, null},
                {"> 4", null, null, null},
                {"> 5", null, null, null},
                {"> 6", null, null, null},
                {"> 7", null, null, null},
                {"> 8", null, null, null},
                {"> 9", null, null, null},
                {"> 10", null, null, null},
                {"> 11", null, null, null},
                {"> 12", null, null, null},
                {"> 13", null, null, null},
                {"> 14", null, null, null}
            },
            new String [] {
                "Position", "Nickname", "Score", "Date"
            }
        ));
        jTable1.setBackground(new Color(186, 172, 159));
        jTable1.setEnabled(false);
        jScrollPane1.setViewportView(jTable1);
        
        
javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 575, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 251, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(7, 7, 7))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0))
        );

        pack();
    }
    
        
    /*
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel1.setBackground(new Color(186, 172, 159));

        jLabel1.setFont(clearSans);
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Leaderboard");

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {"> 1st", null, null, null},
                {"> 2nd", null, null, null},
                {"> 3rd", null, null, null},
                {"> 4", null, null, null},
                {"> 5", null, null, null},
                {"> 6", null, null, null},
                {"> 7", null, null, null},
                {"> 8", null, null, null},
                {"> 9", null, null, null},
                {"> 10", null, null, null},
                {"> 11", null, null, null},
                {"> 12", null, null, null},
                {"> 13", null, null, null},
                {"> 14", null, null, null}
            },
            new String [] {
                "Position", "Nickname", "Score", "Date"
            }
        ));
        jTable1.setBackground(new Color(186, 172, 159));
        jTable1.setEnabled(false);
        jScrollPane1.setViewportView(jTable1);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 575, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 251, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(7, 7, 7))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    */ 
        
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    
    
    /*
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    // End of variables declaration//GEN-END:variables
    */
}
 

