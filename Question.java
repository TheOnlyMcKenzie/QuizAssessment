
/**
 * Support class for the questions in the quiz
 * An individual question has a number (ID), a statement and an answer
 * Will try something to make having multiple answers work in the future
 *
 * @author James McKenzie
 * @version 1.1
 */
public class Question
{
    // Set up fields
    private int questionID;
    private String statement;
    private String answer;

    /**
     * Constructor for objects of class Question
     */
    public Question(int id, String stmnt, String ans)
    {
        // initialise instance variables
        this.questionID = id;
        this.statement = stmnt;
        this.answer = ans;
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
     * Getter method for the answer
     *
     * 
     */
    public String getAnswer()
    {
        return this.answer;
    }
}
