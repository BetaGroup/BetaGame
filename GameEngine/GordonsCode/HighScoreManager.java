package GordonsCode;
import java.awt.Frame;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
/**
 * @author Prativa Kafley
 */
public class HighScoreManager{
    // An arraylist of the type "scorBoard" we will use to work with the scores inside the class
    public Frame myFrame;
    private ArrayList<ScoreBoard> scores;
    // The name of the file where the highscores will be saved. It will be created in the project folder
    //private static final String HIGHSCORE_FILE = "scores.txt";
    //Initialization of INPUT and OUTPUT Stream to work with file cerated above
    ObjectOutputStream outputStream = null;
    ObjectInputStream inputStream = null;
    InputName IN = new InputName();

    public HighScoreManager() {
        //Initialization the scores-arraylist
        scores = new ArrayList<ScoreBoard>();
    }
    

}
