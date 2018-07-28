package GordonsCode;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import java.awt.Frame;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.File;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;
import java.util.List;
/**
 * @author itspr
 */
public class InputName {
    public static JTextField UserText;
    //HighScoreManager HSM = new HighScoreManager();
       // An arraylist of the type "scorBoard" we will use to work with the scores inside the class
    public Frame myFrame;
    private ArrayList<ScoreBoard> scores;
    // The name of the file where the highscores will be saved. It will be created in the project folder
    private static final String HIGHSCORE_FILE = "scores.txt";
    //Initialization of INPUT and OUTPUT Stream to work with file cerated above
    ObjectOutputStream outputStream = null;
    ObjectInputStream inputStream = null;
    
    public InputName() {
        //Initialization the scores-arraylist
        scores = new ArrayList<ScoreBoard>();
    }
    
    //Function to addd score to the file in Disk
    void addScoreBoard(String name, int score) throws IOException {
        loadScoreFile(); //Caling load file function
        //name = UserText.getText();
        scores.add(new ScoreBoard(name, score)); //Add new score to file
        updateScoreFile(name, score); //Calling function to update score file
    }
    
         //Function to load a score file from disk
        public void loadScoreFile() {
        java.io.File file = new java.io.File(HIGHSCORE_FILE); //Initalization of score file to a file
        boolean empty = !file.exists() || file.length() == 0; //Check if file exists or file have no content
        int count = 0;
        List<String> NL = new ArrayList<String>(); //Create an Array to store contents read from file
        try {//Try Block for actions
            Scanner input = new Scanner(file); //Use of Java Scanner function to scan the file in disk
            while (input.hasNext()) { //Scan until there is next line in file
                String num = input.nextLine();
                count++; //Finding total number of line in score file
                NL.add(num); //Adding contents to a Array created above
            }
            //Need output in sorted order of score
            //Since we have a (name,score) pair,  first comparing name
            Collections.sort(NL, new Comparator<String>() {
                public int compare(String o1, String o2) {
                    return extractInt(o2) - extractInt(o1);
                }
                //Considering Score (Digits)
                int extractInt(String s) {
                    String num = s.replaceAll("\\D", "");
                     //If no digits/score (empty or null), return value 0
                    return num.isEmpty() ? 0 : Integer.parseInt(num);
                }
            });
            input.close(); //Close input scanner
            //System.out.println("NUMBER OF RECORDS IN OUTPUT FILE : " + count); //Display number of lines in input score file
            System.out.println("---- TOP 10 SCORES. ----"); 
            if (empty) { //If file is empty, display empty message
                System.out.println("Nobody");
            } 
            else if (count <= 9) { //If file has less than 10 (name,score) pair
                String[] out1 = new String[count];
                System.out.println("Rank"+ "\t" + "Name" + "\t" + "Score");
                for (int j = 0; j <= count-1; j++) { // For Less Than 10
                out1[j] = NL.get(j);
                System.out.println((j+1)+ ".\t" + out1[j]); //But diaplay only top 10 pairs
                }              
            } 
            else { //If file has more than 10 lines sort in descending order of score 
                String[] out1 = new String[10];
                System.out.println("Rank"+ "\t" + "Name" + "\t" + "Score");
                for (int j = 0; j <= 9; j++) { // For Top 10
                    out1[j] = NL.get(j);
                    System.out.println((j+1)+ ".\t" + out1[j]); //But diaplay only top 10 pairs
                }
            }

        } catch (FileNotFoundException e) { //Exception handeling when file do not exist
            System.err.format("File does not exist\n");
        }
    }
    //Function to update score text file in disk with updates from the program
    public void updateScoreFile(String name, int score) throws IOException {
        File file = new File(HIGHSCORE_FILE); //Initialize instance of file
        if(!file.exists()){
            //Try to create a new high scores file
            try{
                file.createNewFile();
            }catch(Exception e){
                System.out.println("Error creating file " + HIGHSCORE_FILE);
                System.out.println(e);
                return;
            }
             }else{
        try { //Try Bloack for action
            FileWriter output = new FileWriter(file, true); //Set file writer to TRUE
            output.write(name + "\t" + score + System.getProperty("line.separator")); //Format on which we write (name,score) pair to file
            output.close(); //Close opened file writer connection
            if(score > 500){
                InpName();
            }
            
        } catch (FileNotFoundException e) { //Catch File Not Found Exception
            System.out.println("[Update] FNF Error: " + e.getMessage() + ",the program will try and make a new file");
        } catch (IOException e) { //Catch Input/Output Exception
            System.out.println("[Update] IO Error: " + e.getMessage());
        } finally {
            try { //
                if (outputStream != null) {
                    outputStream.flush();
                    outputStream.close();
                }
            } catch (IOException e) { //Catch Update Error Exception
                System.out.println("[Update] Error: " + e.getMessage());
            }
        }
    }
}       
 public void InpName(){
     JFrame frame = new JFrame("ENTER YOUR NAME");
     frame.setSize(300, 150);
     frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
     JPanel panel = new JPanel();
     frame.add(panel);
     panel.setLayout(null);
     JLabel userLabel = new JLabel("User Name");
     userLabel.setBounds(10, 10, 190, 35);
     panel.add(userLabel);
     UserText = new JTextField(20);
     UserText.setBounds(10, 35, 250, 25);
     UserText.setFont(new java.awt.Font("Arial", Font.ITALIC | Font.BOLD , 12));
     UserText.setForeground(Color.BLUE);
     UserText.setBackground(Color.YELLOW);
     frame.setLocationRelativeTo(null);
     panel.add(UserText);
     JButton OkButton = new JButton("OK");
     OkButton.setBounds(60, 70, 75, 25);
     panel.add(OkButton);
     JButton cancelButton = new JButton("Cancel");
     cancelButton.setBounds(140, 70, 75, 25);
     panel.add(cancelButton);
     //ActionListener myButtonListener = d.new OkButtonListener(str);
     
     OkButton.addActionListener(new ActionListener(){
         @Override
         public void actionPerformed(ActionEvent ae) {
             if(UserText.getText().length()<=0){
                 String message = "\"Invalid!\"\n"
                         +"USER NAME IS EMPTY";
                  JOptionPane.showMessageDialog(new JFrame(), message, "Dialog",
        JOptionPane.ERROR_MESSAGE);
             }else{
                 int input = JOptionPane.showConfirmDialog(null, "Confirmend!","Confirm Dialog", JOptionPane.YES_NO_CANCEL_OPTION);
                 switch (input) {
         case JOptionPane.YES_OPTION:
                 {
                     try {
                         addScoreBoard(UserText.getText(),5000);
                     } catch (IOException ex) {
                         Logger.getLogger(InputName.class.getName()).log(Level.SEVERE, null, ex);
                     }
                 }
              frame.setVisible(false);
             //System.out.println("You clicked YES");
             JOptionPane.showMessageDialog(null, "Congratulations!\n"
                     +"YOU ARE IN TOP 10 POSITION",
            "Congratualtions!", JOptionPane.PLAIN_MESSAGE);
             break;
             case JOptionPane.NO_OPTION:
             break;
            case JOptionPane.CANCEL_OPTION:
            frame.setVisible(false);
            break;
             }
         }
      }
     });
     cancelButton.addActionListener(new ActionListener() {
         @Override
         public void actionPerformed(ActionEvent arg0) {
          frame.setVisible(false);
         }
     });
     
    frame.setVisible(true);
     }
  }

