import java.util.HashMap;
import ecs100.*;
import java.util.*;
import java.io.*;
import java.awt.Color;
/**
 * Support class for the questions in the quiz
 * An individual question has a number (ID), a statement and a HashMap of answers
 * Will try something to make having multiple answers work in the future
 *
 * @author James McKenzie
 * @version 4.0 (final version)
 */
public class Question
{
    // Set up fields
    private int questionID;
    private String statement;
    private String answer;
    private String image;
    private HashMap<Integer, Answer> answers;
    private double locX;
    private double locY;
    private final double POSITION = 200;
    private final double WIDTH = 200;
    private final double HEIGHT = 200;
    private final double Y = POSITION + HEIGHT;
    private final double Y2 = Y + 50;
    private final double Y3 = Y2 + 100;
    private final int FONTSIZE = 16; // Set the font size to 16
    
    static final String DEFAULT_IMAGE = "Default_Image.png";

    /**
     * Constructor for objects of class Question
     */
    public Question(int id, String stmnt, HashMap<Integer, Answer> ans, String img)
    {
        // initialise instance variables
        this.questionID = id;
        this.statement = stmnt;
        this.answers = ans;
        this.image = img;
    }
    
    /**
     * Constructor overload
     * Set the image to the default image if no image has been entered
     */
    public Question(int id, String stmnt, HashMap<Integer, Answer> ans)
    {
        this(id, stmnt, ans, DEFAULT_IMAGE);
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
     * Display the image in the GUI
     */
    public void displayImage()
    {
        // Set the position
        
        this.locX = POSITION;
        this.locY = POSITION;
        
        // Draw the image
        UI.drawImage(this.image, this.locX, this.locY, WIDTH, HEIGHT);
    }
    /**
     * Display the question in the GUI
     */
    public void displayQuestion()
    {
        // Set the position
        
        this.locX = POSITION;
        this.locY = Y;
        
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
        this.locY = Y2;
        int counter = 1;
        
        for (int answer : this.answers.keySet())
        {
            String a = this.answers.get(answer).getStatement();
            UI.setFontSize(FONTSIZE);
            UI.drawString(a, this.locX, (this.locY + FONTSIZE * counter));
            counter++;
        }
        
  
    }
    
    /**
     * Displays if the user's answer was correct or incorrect
     */
    public void displayStatus(int number)
    {
        // Set the position
        this.locX = POSITION;
        this.locY = Y3;
        String status = "";
        
        if (number == 0)
        {
            Color col = new Color(0, 153, 15);
            UI.setColor(col);
            status = "Correct!";
        }
        if (number == 1)
        {
            UI.setColor(Color.red);
            status = "Incorrect!";
        }
        
        UI.setFontSize(FONTSIZE);
        UI.drawString(status, this.locX, (this.locY + FONTSIZE));
    }
}
