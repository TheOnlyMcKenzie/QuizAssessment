
import java.util.HashMap; // importing the HashMap class
import ecs100.*; // importing the ecs100 library
/**
 * Driver class
 *
 * @author James McKenzie
 * @version 1.1
 */
public class Quiz
{
    // Set up fields
    private HashMap<Integer, Question> questions;
    private int currentID;
    private Question currentQuestion;

    /**
     * Constructor for objects of class Quiz
     */
    public Quiz()
    {
        // initialise instance variables
        questions = new HashMap<Integer, Question>();
        
        // Create some sample questions (for testing)
        Question q1 = new Question(1, "What band wrote the song 'Fake Plastic Trees'?", "radiohead");
        Question q2 = new Question(2, "What famous astronomer is mentioned in the song 'Bohemian Rhapsody'?", "galileo");
        Question q3 = new Question(3, "Kim Gordon was the bass player and vocalist in what '90's rock band?", "sonic youth");
        Question q4 = new Question(4, "What rapper said the infamous line 'I talk to God everyday, He my bestie' in 2021?", "kanye west");
        Question q5 = new Question(5, "Spencer Elden lodged a lawsuit over the use of his image on the album 'Nevermind' by what band?", "nirvana");
        Question q6 = new Question(6, "What former rapper dropped the second-worst pop-punk album of 2020?", "machine gun kelly");
        Question q7 = new Question(7, "What rapper wore a suit of gold-plated armour to the 2021 Met Gala?", "lil nas x");
        Question q8 = new Question(8, "What band made the hyperpop classic 'money machine'?", "100 gecs");
        Question q9 = new Question(9, "What Beatles song contains the lyric 'I look at all the lonely people'?", "eleanor rigby");
        Question q10 = new Question(10, "What musician created the character known as the 'Thin White Duke'?", "david bowie");
        
        
        // Add the questions
        questions.put(1, q1);
        questions.put(2, q2);
        questions.put(3, q3);
        questions.put(4, q4);
        questions.put(5, q5);
        questions.put(6, q6);
        questions.put(7, q7);
        questions.put(8, q8);
        questions.put(9, q9);
        questions.put(10, q10);
        
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
        String answer;
        UI.println("The Music Quiz");
        for (int question : questions.keySet())
        {
            UI.println(questions.get(question).getQuestion());
            String input = UI.nextLine();
            answer = input.toLowerCase();
            if (answer.equals(questions.get(question).getAnswer()))
            {
                UI.println("Correct!");
                score += 10;
            }
            else
            {
                UI.println("Wrong!");
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
