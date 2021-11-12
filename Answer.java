
/**
 * Support class for the answers to the quiz
 * An individual answer has an answer statement and a value denoting correct or incorrect
 * 
 *
 * @author James McKenzie
 * @version 4.0 (Final version)
 */
public class Answer
{
    // Set up fields
    private int correct;
    private String statement;
    

    /**
     * Constructor for objects of class Question
     */
    public Answer(String stmnt, int value)
    {
        // initialise instance variables
        this.statement = stmnt;
        this.correct = value;
    }

    
    /**
     * Getter method for the answer statement
     *
     * 
     */
    public String getStatement()
    {
        return this.statement;
    }
    
    /**
     * Getter method for the correct/incorrect value
     *
     * 
     */
    public int getCorrect()
    {
        return this.correct;
    }
}
