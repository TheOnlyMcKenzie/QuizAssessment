import java.util.HashMap;
import ecs100.*;
/**
 * Support class for the questions in the quiz
 * An individual question has a number (ID), a statement and a HashMap of answers
 * Will try something to make having multiple answers work in the future
 *
 * @author James McKenzie
 * @version 2.0
 */
public class Question
{
    // Set up fields
    private int questionID;
    private String statement;
    private String answer;
    private HashMap<Integer, Answer> answers;
    private double locX;
    private double locY;
    private final double POSITION = 200;
    private final double WIDTH = 100;
    private final double HEIGHT = 100;
    private final int FONTSIZE = 16; // Set the font size to 16

    /**
     * Constructor for objects of class Question
     */
    public Question(int id, String stmnt, HashMap<Integer, Answer> ans)
    {
        // initialise instance variables
        this.questionID = id;
        this.statement = stmnt;
        this.answers = ans;
    }

    /**
     * Getter method for the question number
     *
     * 
     */
    public int getID()
    {
        return this.questionID;
    }
    
    /**
     * Getter method for the question statement
     *
     * 
     */
    public String getQuestion()
    {
        return this.statement;
    }
    
    /**
     * Getter method for the answers
     *
     * 
     */
    public HashMap getAnswers()
    {
        return this.answers;
    }
    
    /**
     * Display the question in the GUI
     */
    public void displayQuestion()
    {
        // Set the position
        
        this.locX = POSITION;
        this.locY = POSITION;
        
        String question = this.statement;
        
        UI.setFontSize(FONTSIZE); // Set the font size
        
        // Draw the string
        UI.drawString(question, this.locX, (this.locY + FONTSIZE));
    }
    
    /**
     * Display the question's answers in the GUI
     */
    public void displayAnswers()
    {
        // Set the position
        this.locX = POSITION;
        this.locY = POSITION + HEIGHT;
        int counter = 1;
        
        for (int answer : this.answers.keySet())
        {
            String a = this.answers.get(answer).getStatement();
            UI.setFontSize(FONTSIZE);
            UI.drawString(a, this.locX, (this.locY + FONTSIZE * counter));
            counter++;
        }
        
  
    }
}
