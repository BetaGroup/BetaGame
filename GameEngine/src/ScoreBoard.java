package Engine;
import java.io.Serializable;
//import javax.swing.JFrame;
/**
 * @author Prativa Kafley
 */
public class ScoreBoard implements Serializable {
  //  private int rank;
    private int score;
    private String name;
    
    public ScoreBoard(String name, int score) {
        this.score = score;
        this.name = name;
        //this.rank = rank;
    }

   
    public int getScore() {
        return score;
    }
    public String getName() {
        return name;
    }
    /*public int getRank(){
        return rank;
    }*/
}
