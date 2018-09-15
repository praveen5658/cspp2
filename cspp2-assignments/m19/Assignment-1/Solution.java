import java.util.Scanner;

/**
 * Solution class for code-eval.
 */
public final class Solution {
    /**
    * Constructs the object.
    */
    private Solution() {
        // leave this blank
    }
    /**
     * main function to execute test cases.
     *
     * @param      args  The arguments
     */
    public static void main(final String[] args) {
        // instantiate this Quiz
        Quiz q = new Quiz();
        // code to read the test cases input file
        Scanner s = new Scanner(System.in);
        // check if there is one more line to process
        while (s.hasNext()) {
            // read the line
            String line = s.nextLine();
            // split the line using space
            String[] tokens = line.split(" ");
            // based on the list operation invoke the corresponding method
            switch (tokens[0]) {
            case "LOAD_QUESTIONS":
                System.out.println("|----------------|");
                System.out.println("| Load Questions |");
                System.out.println("|----------------|");
                loadQuestions(s, q, Integer.parseInt(tokens[1]));
                break;
            case "START_QUIZ":
                System.out.println("|------------|");
                System.out.println("| Start Quiz |");
                System.out.println("|------------|");
                startQuiz(s, q, Integer.parseInt(tokens[1]));
                break;
            case "SCORE_REPORT":
                System.out.println("|--------------|");
                System.out.println("| Score Report |");
                System.out.println("|--------------|");
                displayScore(q);
                break;
            default:
                break;
            }
        }
    }
    /**
     * Loads questions.
     *
     * @param      s              The scanner object for user input
     * @param      quiz           The quiz object
     * @param      questionCount  The question count
     */
    public static void loadQuestions(final Scanner s, final Quiz quiz, final int questionCount) {
        // write your code here to read the questions from the console
        // tokenize the question line and create the question object
        // add the question objects to the quiz class
        if (questionCount != 0) {
            quiz.addQuestions(s, questionCount);
        } else {
            System.out.println("Quiz does not have questions");
        }
    }

    /**
     * Starts a quiz.
     *
     * @param      s            The scanner object for user input
     * @param      quiz         The quiz object
     * @param      answerCount  The answer count
     */
    public static void startQuiz(final Scanner s, final Quiz quiz, final int answerCount) {
        // write your code here to display the quiz questions
        // read the user responses from the console
        // store the user respones in the quiz object
        quiz.readChoice(s, answerCount);
    }

    /**
     * Displays the score report
     *
     * @param      quiz     The quiz object
     */
    public static void displayScore(final Quiz quiz) {
        // write your code here to display the score report
        quiz.report();
    }
}
class Quiz {
    // private String[] questionText;
    // private String[][] questionChoice;
    // private int[] correctAnswer;
    // private int[] maxMarks;
    // private int[] penalityMarks;
    private Question[] questions;
    private int size;
    private int[] score;
    protected Quiz() {
        // questionText = new String();
        questions = new Question[20];
        size = 0;
        score = new int[20];
    }
    public void addQuestions(final Scanner s, final int questionCount) {
        String[] tokens;
        int k = 0;
        String[] choice;
        int correctAnswer;
        int maxMarks;
        int penalityMarks;
        for (int i = 0; i < questionCount; i++) {
            tokens = s.nextLine().split(":");
            // System.out.print(tokens[0]);
            if (tokens.length == 5 && tokens[0] != null) {
                choice = tokens[1].split(",");
                correctAnswer = Integer.parseInt(tokens[2]);
                if (choice.length >= 2) {
                    if (correctAnswer <= tokens.length) {
                        maxMarks = Integer.parseInt(tokens[3]);
                        penalityMarks = Integer.parseInt(tokens[4]);
                        if (penalityMarks <= 0) {
                            questions[size] = new Question();
                            questions[size].addQuestion(tokens[0], choice, correctAnswer, maxMarks, penalityMarks);
                            size ++;
                        }
                        else {
                            System.out.println("Invalid penalty for " + tokens[0]);
                            k++;
                            break;
                        }
                    }
                    else {
                        System.out.println("Error! Correct answer choice number is out of range for question text 1");
                        k++;
                        break;
                    }
                } else {
                    System.out.println("trick question  does not have enough answer choices");
                    k++;
                    break;
                }
            } else {
                System.out.println("Error! Malformed question");
                k++;
                break;
            }
        }
        if (k == 0) {
            System.out.println(String.valueOf(questionCount) + " are added to the quiz");
        }
    }
    public void readChoice(final Scanner s, final int choiceCount) {
        if (size != 0) {
            String choice;
            String t;
            for (int i = 0 ; i < choiceCount; i++) {
                t = s.nextLine();
                choice = t;
                score[i] = questions[i].checkChoice(choice);
            }
            for (int i = 0; i < size; i++) {
                System.out.println(questions[i]);
                System.out.println();
            }
        }
    }
    public void report() {
        if (size != 0) {
            int sc = 0;
            for (int i = 0; i < size; i++) {
                System.out.println(questions[i].getQuestion());
                if (score[i] > 0) {
                    System.out.print(" Correct Answer! - Marks Awarded: ");
                    System.out.print(String.valueOf(questions[i].getmaxMarks()));
                    System.out.println();
                } else {
                    System.out.print(" Wrong Answer! - Penalty: ");
                    System.out.print(String.valueOf(score[i]));
                    System.out.println();
                }
            }
            for (int j = 0; j < score.length; j++) {
                sc += score[j];
            }
            System.out.println("Total Score: " + String.valueOf(sc));
        }
    }
}
class Question {
    private String questionText;
    private String[] choice;
    private int correctAnswer;
    private int maxMarks;
    private int penalityMarks;
    protected Question() {

    }
    public void addQuestion(final String qt, final String[] c, final int ans, final int maxmarks, final int penality) {
        this.questionText = qt;
        this.choice = c;
        this.correctAnswer = ans;
        this.maxMarks = maxmarks;
        this.penalityMarks = penality;
    }
    public int checkChoice(final String choice) {
        if (this.choice[correctAnswer - 1].equals(choice)) {
            return this.maxMarks;
        } else {
            return this.penalityMarks;
        }
    }
    public String toString() {
        String s = questionText;
        s += "(" + String.valueOf(this.maxMarks) + ")";
        s += '\n';
        for (int j = 0; j < choice.length; j++) {
            s += choice[j] + "      ";
        }
        return s;
    }
    public String getQuestion() {
        return this.questionText;
    }
    public int getmaxMarks() {
        return this.maxMarks;
    }
}
