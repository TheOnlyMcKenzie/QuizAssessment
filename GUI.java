import java.util.HashMap;
import ecs100.*; // importing the ecs100 library
/**
 * Class to handle all GUI functionality (user inputs and outputs)
 *
 * @author James McKenzie
 * @version 1/07/2021
 */
public class GUI
{
    // Fields
    private Quiz quiz;
  
    private double locX;
    private double locY;
    private final double POSITION = 200;
    private final double DIMENSIONS = 100;

    /**
     * Constructor for objects of class GUI
     */
    public GUI()
    {
        // initialise instance variables

        UI.initialise();

        quiz = new Quiz();

        // Add buttons  on creation
        UI.addButton("Quit", UI::quit);
        UI.addButton("A", quiz::answerA);
        UI.addButton("B", quiz::answerB);
        UI.addButton("C", quiz::answerC);
        UI.addButton("D", quiz::answerD);
        
        runQuiz();
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
        
        
        while (id <= questions.size())
        {
            quiz.setId(id);
            quiz.setStatus(go);
            Question question = questions.get(id);
            question.displayQuestion();
            question.displayAnswers();
            go = quiz.getStatus();
            if (go == true)
            {
                check = quiz.checkAnswer();
                if (check == true)
                {
                    UI.println("Correct!");
                    score += 10;
                    id++;
                    go = false;
                    UI.clearGraphics();
                }
            
                else if (check == false)
                {
                    UI.println("Wrong!");
                    id++;
                    go = false;
                    UI.clearGraphics();
                }
            }
        }
        // Print the score
        UI.println("Score: " + score +"/100");
        
        if (score < 10)
        {
            UI.println("Hah noob");
        }
    }
}