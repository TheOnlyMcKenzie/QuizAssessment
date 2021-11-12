
import java.util.HashMap; // importing the HashMap class
import ecs100.*; // importing the ecs100 library
/**
 * Driver class
 *
 * @author James McKenzie
 * @version 4.0 (final version)
 */
public class Quiz
{
    // Set up fields
    private HashMap<Integer, Question> questions;
    private int currentID;
    private Question currentQuestion;
    private int currentAnswer;
    private boolean go;

    /**
     * Constructor for objects of class Quiz
     */
    public Quiz()
    {
        // initialise instance variables
        questions = new HashMap<Integer, Question>();
        
        HashMap<Integer, Answer> answers1 = new HashMap<Integer, Answer>();
        HashMap<Integer, Answer> answers2 = new HashMap<Integer, Answer>();
        HashMap<Integer, Answer> answers3 = new HashMap<Integer, Answer>();
        HashMap<Integer, Answer> answers4 = new HashMap<Integer, Answer>();
        HashMap<Integer, Answer> answers5 = new HashMap<Integer, Answer>();
        HashMap<Integer, Answer> answers6 = new HashMap<Integer, Answer>();
        HashMap<Integer, Answer> answers7 = new HashMap<Integer, Answer>();
        HashMap<Integer, Answer> answers8 = new HashMap<Integer, Answer>();
        HashMap<Integer, Answer> answers9 = new HashMap<Integer, Answer>();
        HashMap<Integer, Answer> answers10 = new HashMap<Integer, Answer>();
        
        // Create the answers
        answers1.put(1, new Answer("A: Coldplay", 0));
        answers1.put(2, new Answer("B: Nirvana", 0));
        answers1.put(3, new Answer("C: Radiohead", 1));
        answers1.put(4, new Answer("D: Muse", 0));
        
        answers2.put(1, new Answer("A: Einstein", 0));
        answers2.put(2, new Answer("B: Galileo", 1));
        answers2.put(3, new Answer("C: Copernicus", 0));
        answers2.put(4, new Answer("D: Newton", 0));
        
        answers3.put(1, new Answer("A: My Chemical Romance", 0));
        answers3.put(2, new Answer("B: Sonic Youth", 0));
        answers3.put(3, new Answer("C: Radiohead", 0));
        answers3.put(4, new Answer("D: My Bloody Valentine", 1));
        
        answers4.put(1, new Answer("A: Kanye West", 1));
        answers4.put(2, new Answer("B: Lil Pump", 0));
        answers4.put(3, new Answer("C: Drake", 0));
        answers4.put(4, new Answer("D: Eminem", 0));
        
        answers5.put(1, new Answer("A: The Beatles", 0));
        answers5.put(2, new Answer("B: Nirvana", 1));
        answers5.put(3, new Answer("C: Foo Fighters", 0));
        answers5.put(4, new Answer("D: U2", 0));
        
        answers6.put(1, new Answer("A: Machine Gun Kelly", 1));
        answers6.put(2, new Answer("B: Eminem", 0));
        answers6.put(3, new Answer("C: Lil Peep", 0));
        answers6.put(4, new Answer("D: Kid Cudi", 0));
        
        answers7.put(1, new Answer("A: Lil Pump", 0));
        answers7.put(2, new Answer("B: Lil Nas X", 1));
        answers7.put(3, new Answer("C: Kanye West", 0));
        answers7.put(4, new Answer("D: Drake", 0));
        
        answers8.put(1, new Answer("A: Led Zeppelin", 0));
        answers8.put(2, new Answer("B: Queen", 0));
        answers8.put(3, new Answer("C: The Smiths", 1));
        answers8.put(4, new Answer("D: Talking Heads", 0));
        
        answers9.put(1, new Answer("A: Hey Jude", 0));
        answers9.put(2, new Answer("B: Lucy In The Sky With Diamonds", 0));
        answers9.put(3, new Answer("C: Come Together", 0));
        answers9.put(4, new Answer("D: Eleanor Rigby", 1));
        
        answers10.put(1, new Answer("A: David Bowie", 1));
        answers10.put(2, new Answer("B: Kurt Cobain", 0));
        answers10.put(3, new Answer("C: Kanye West", 0));
        answers10.put(4, new Answer("D: Tyler, the Creator", 0));
        
        
        // Create some sample questions (for testing)
        Question q1 = new Question(1, "What band wrote the song 'Fake Plastic Trees'?", answers1, "image_1.jpg");
        Question q2 = new Question(2, "What famous astronomer is mentioned in the song 'Bohemian Rhapsody'?", answers2, "image_2.jpg");
        Question q3 = new Question(3, "Which of these bands is often credited for pioneering the subgenre known as shoegaze?", answers3, "image_3.jpg");
        Question q4 = new Question(4, "What rapper said the infamous line 'I talk to God everyday, He my bestie' in 2021?", answers4, "image_4.jfif");
        Question q5 = new Question(5, "Spencer Elden lodged a lawsuit over the use of his image on the album 'Nevermind' by what band?", answers5, "image_5.jpeg");
        Question q6 = new Question(6, "What former rapper dropped the second-worst pop-punk album of 2020?", answers6, "image_6.png");
        Question q7 = new Question(7, "What rapper wore a suit of gold-plated armour to the 2021 Met Gala?", answers7, "image_7.jpg");
        Question q8 = new Question(8, "Which of the following bands were NOT active during the 1970s?", answers8, "image_8.png");
        Question q9 = new Question(9, "What Beatles song contains the lyric 'I look at all the lonely people'?", answers9, "image_9.jpg");
        Question q10 = new Question(10, "What musician created the character known as the 'Thin White Duke'?", answers10, "image_10.jpg");
        
        
        //Add the questions
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
        
        this.currentID = 1;
    }

    
    
    /**
     * Checks the answer
     */
    public boolean checkAnswer()
    {
        Question currentQuestion = questions.get(this.currentID);
        HashMap<Integer, Answer> answers = currentQuestion.getAnswers();
        Answer answer = answers.get(this.currentAnswer);
        if (answer.getCorrect() == 1)
        {
            return true;
        }
        
        return false;
    }
    
    /**
     * public 
     */
    public void answerA()
    {
        this.currentAnswer = 1;
        this.go = true;
        
    }
    
    /**
     * public 
     */
    public void answerB()
    {
        this.currentAnswer = 2;
        this.go = true;
        
    }
    
    /**
     * public 
     */
    public void answerC()
    {
        this.currentAnswer = 3;
        this.go = true;
        
    }
    
    /**
     * public 
     */
    public void answerD()
    {
        this.currentAnswer = 4;
        this.go = true;
        
    }
    
    public HashMap getQuestions()
    {
        return this.questions;
    }
    
    public void setId(int id)
    {
        this.currentID = id;
    }
    
    public boolean getStatus()
    {
        return this.go;
    }
    
    public void setStatus(boolean status)
    {
        this.go = status;
    }
}
