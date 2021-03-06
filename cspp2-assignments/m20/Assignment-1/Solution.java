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
    public static void loadQuestions(
        final Scanner s, final Quiz quiz, final int questionCount) {
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
    public static void startQuiz(
        final Scanner s, final Quiz quiz, final int answerCount) {
        // write your code here to display the quiz questions
        // read the user responses from the console
        // store the user respones in the quiz object
        quiz.readChoice(s, answerCount);
    }

    /**
     * Displays the score report.
     *
     * @param      quiz     The quiz object.
     */
    public static void displayScore(final Quiz quiz) {
        // write your code here to display the score report
        quiz.report();
    }
}
/**
 * Class for quiz.
 */
class Quiz {
    // private String[] questionText;
    // private String[][] questionChoice;
    // private int[] correctAnswer;
    // private int[] maxMarks;
    // private int[] penalityMarks;
    /**
    Private Value.
    */
    private Question[] questions;
    /**
    Private Value.
    */
    private int size;
    /**
    Private Value.
    */
    private int[] score;
    /**
     * Constructs the object.
     */
    protected Quiz() {
        // questionText = new String();
        final int twenty = 20;
        questions = new Question[twenty];
        size = 0;
        score = new int[twenty];
    }
    /**
     * Adds questions.
     *
     * @param      s              { Scanner object }.
     * @param      questionCount  The question count
     */
    public void addQuestions(
        final Scanner s, final int questionCount) {
        String[] tokens;
        final int five = 5;
        final int two = 2;
        final int zero = 0;
        final int three = 3;
        final int four = 4;
        String st;
        char[] star;
        int k = 0;
        String[] choice;
        int correctAnswer;
        int maxMarks;
        int penalityMarks;
        for (int i = 0; i < questionCount; i++) {
            st = s.nextLine();
            star = st.toCharArray();
            tokens = st.split(":");
            // System.out.print(tokens[0]);
            if (tokens.length == five && star[0] != ':') {
                choice = tokens[1].split(",");
                correctAnswer = Integer.parseInt(tokens[2]);
                if (choice.length >= two) {
                    if (correctAnswer <= tokens.length) {
                        maxMarks = Integer.parseInt(tokens[three]);
                        if (maxMarks >= zero) {
                            penalityMarks = Integer.parseInt(tokens[four]);
                            if (penalityMarks <= zero) {
                                questions[size] = new Question();
                                questions[size].addQuestion(
                                    tokens[0], choice, correctAnswer,
                                    maxMarks, penalityMarks);
                                size++;
                            } else {
                                System.out.println(
                                    "Invalid penalty for " + tokens[0]);
                                k++;
                                break;
                            }
                        } else {
                            System.out.println(
                                "Invalid max marks for " + tokens[0]);
                            k++;
                            break;
                        }
                    } else {
                        System.out.println(
                            "Error! Correct answer choice number is out of"
                            + " range for question text 1");
                        k++;
                        break;
                    }
                } else {
                    System.out.println(
                        "trick question  does not have enough answer choices");
                    k++;
                    break;
                }
            } else {
                System.out.println("Error! Malformed question");
                k++;
                break;
            }
        }
        if (k == zero) {
            System.out.println(
                String.valueOf(questionCount)
                + " are added to the quiz");
        }
    }
    /**
     * Reads a choice.
     *
     * @param      s            { parameter_description }.
     * @param      choiceCount  The choice count
     */
    public void readChoice(final Scanner s, final int choiceCount) {
        final int zero = 0;
        if (size != zero) {
            String choice;
            String t;
            for (int i = 0; i < choiceCount; i++) {
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
    /**
     * { Printing Report }.
     */
    public void report() {
        final int zero = 0;
        if (size != zero) {
            int sc = 0;
            for (int i = 0; i < size; i++) {
                System.out.println(questions[i].getQuestion());
                if (score[i] > zero) {
                    System.out.print(
                        " Correct Answer! - Marks Awarded: ");
                    System.out.print(String.valueOf(
                        questions[i].getmaxMarks()));
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
            System.out.println("Total Score: " + (String.valueOf(sc)));
        }
    }
}
/**
 * Class for question.
 */
class Question {
    /**
    Private Value.
    */
    private String questionText;
    /**
    Private Value.
    */
    private String[] choice;
    /**
    Private Value.
    */
    private int correctAnswer;
    /**
    Private Value.
    */
    private int maxMarks;
    /**
    Private Value.
    */
    private int penalityMarks;
    /**
     * Constructs the object.
     */
    protected Question() {

    }
    /**
     * Adds a question.
     *
     * @param      qt        { QuestionText }.
     * @param      c         { Choices  }.
     * @param      ans       The ans
     * @param      maxmarks  The maxmarks
     * @param      penality  The penality
     */
    public void addQuestion(
        final String qt, final String[] c, final int ans,
        final int maxmarks, final int penality) {
        this.questionText = qt;
        this.choice = c;
        this.correctAnswer = ans;
        this.maxMarks = maxmarks;
        this.penalityMarks = penality;
    }
    /**
     * { Check for choice }.
     *
     * @param      choice1  The choice
     *
     * @return     { Integer }.
     */
    public int checkChoice(final String choice1) {
        if (this.choice[correctAnswer - 1].equals(choice1)) {
            return this.maxMarks;
        } else {
            return this.penalityMarks;
        }
    }
    /**
     * Returns a string representation of the object.
     *
     * @return     String representation of the object.
     */
    public String toString() {
        String s = questionText;
        s += "(" + (String.valueOf(this.maxMarks)) + ")";
        s += '\n';
        int j = 0;
        for (j = 0; j < choice.length - 1; j++) {
            s += choice[j] + "\t";
        }
        s += choice[j];
        return s;
    }
    /**
     * Gets the question.
     *
     * @return     The question.
     */
    public String getQuestion() {
        return this.questionText;
    }
    /**
     * { Getter }.
     *
     * @return     { Integer }.
     */
    public int getmaxMarks() {
        return this.maxMarks;
    }
}

