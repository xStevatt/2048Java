package my2048;

/**
 *
 * @author Stefano Valloncini & Matteo Botti
 */

public class Score
{
    private Integer score; 
    private String name; 
    private String date; 

    public Score(int score, String name, String date) {
        this.score = score;
        this.name = name;
        this.date = date;
    }

    public Score() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
    
    
    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
