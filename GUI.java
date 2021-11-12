import java.util.HashMap;
import ecs100.*; // importing the ecs100 library
import java.awt.Color;
/**
 * Class to handle all GUI functionality (user inputs and outputs)
 *
 * @author James McKenzie
 * @version 4.0 (final version)
 */
public class GUI
{
    // Fields
    private Quiz quiz;
    private boolean skip = false;
    private boolean restart = false;
  
    private double locX;
    private double locY;
   
    private final double POSITION = 200;
    private final double DIMENSIONS = 100;
    private final int FONTSIZE = 16;

    /**
     * Constructor for objects of class GUI
     */
    public GUI()
    {
        // initialise instance variables

        UI.initialise();

        quiz = new Quiz();

        // Add buttons  on creation
        UI.addButton("Restart Quiz", this::restartQuiz);
        UI.addButton("A", quiz::answerA);
        UI.addButton("B", quiz::answerB);
        UI.addButton("C", quiz::answerC);
        UI.addButton("D", quiz::answerD);
        UI.addButton("Skip", this::doSkip);
        UI.addButton("Quit", UI::quit);
        
        intro();
    }
    
    /**
     * An example of a method - replace this comment with your own
     *
     * 
     */
    public void runQuiz()
    {
        int score = 0;
        int id = 1;
        String answer;
        HashMap<Integer, Question> questions = quiz.getQuestions();
        boolean go = false;
        boolean check;
        int number = 0;
        
        UI.clearGraphics();
        
        while (id <= questions.size())
        {
            UI.setColor(Color.black);
            quiz.setId(id);
            quiz.setStatus(go);
            Question question = questions.get(id);
            question.displayImage();
            question.displayQuestion();
            question.displayAnswers();
            go = quiz.getStatus();
            
            if (restart == true)
            {
                UI.clearGraphics();
                id = 1;
                score = 0;
                this.restart = false;
            }
            if (go == true)
            {
                check = quiz.checkAnswer();
                if (check == true)
                {
                    number = 0;
                    question.displayStatus(number);
                    wait(1500);
                    score += 10;
                    id++;
                    go = false;
                    UI.clearGraphics();
                }
            
                else if (check == false)
                {
                    number = 1;
                    question.displayStatus(number);
                    wait(1500);
                    id++;
                    go = false;
                    UI.clearGraphics();
                }
            }
            if (skip == true)
            {
                UI.clearGraphics();
                id++;
                this.skip = false;
            }
        }
        // Print the score
        UI.setColor(Color.black);
        displayScore(score, questions);
        
    }
    
    public void restartQuiz()
    {
        UI.clearGraphics();
        this.restart = true;
    }
    
    public void doSkip()
    {
        this.skip = true;
    }
    
    
    /**
     * Display the score at the end of the quiz
     */
    public void displayScore(int score, HashMap<Integer, Question> questions)
    {
        // Set the position
        
        this.locX = POSITION;
        this.locY = POSITION;
        int total = questions.size() * 10;
        String message = "";
        
        String scoreString = "Score: " + score + "/" + total;
        if (score <= (total * 0.25))
        {
           message = "Do you live under a rock?"; 
        }
        if (score <= (total * 0.5) && score > (total * 0.25))
        {
           message = "Not terrible, but your should probably try again"; 
        }
        if (score > (total * 0.5) && score <= (total * 0.8))
        {
           message = "Pretty good! Keep trying and you could get a perfect score!"; 
        }
        if (score > (total * 0.8) && score < total)
        {
           message = "Very good! You know your stuff"; 
        }
        if (score == total)
        {
           message = "Perfect Score!"; 
        }
        
        UI.setFontSize(FONTSIZE); // Set the font size
        
        // Draw the string
        UI.drawString(scoreString, this.locX, (this.locY + FONTSIZE));
        UI.drawString(message, this.locX, (this.locY + (FONTSIZE + 40)));
    }
    
    public void intro()
    {
        double locX = 100;
        double locY = 200;
        final int FONTSIZE = 16;
       
        
        String desc1 = "Welcome to James McKenzie’s Simple Music Quiz. Here, you will be presented with questions on all kinds of popular music trivia.";
        String desc2 = "Find out how well-versed you are in today’s musical culture using these 10 questions.";
        String inst = "The quiz will begin in 10 seconds. You can skip questions, and you can restart the quiz if you feel like it. Have fun!";
        UI.setFontSize(FONTSIZE); // Set the font size
        
        // Draw the string
        UI.drawString(desc1, locX, (locY + FONTSIZE));
        UI.drawString(desc2, locX, (locY + (FONTSIZE * 2)));
        UI.drawString(inst, locX, (locY + (FONTSIZE + 50)));
        
        wait(10000);
        runQuiz();
    }
    
    public static void wait(int ms)
    {
        try
        {
            Thread.sleep(ms);
        }
        catch(InterruptedException ex)
        {
            Thread.currentThread().interrupt();
        }
    }
   
}
