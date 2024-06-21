import java.util.Scanner;
import java.util.Timer;
import java.util.TimerTask;

public class Quiz {
    private QuizQuestion[] questions;
    private int score;
    private int questionIndex;
    private Timer timer;
    private boolean timeUp;

    public Quiz(QuizQuestion[] questions) {
        this.questions = questions;
        this.score = 0;
        this.questionIndex = 0;
        this.timer = new Timer();
        this.timeUp = false;
    }

    public void start() {
        Scanner scanner = new Scanner(System.in);

        while (questionIndex < questions.length) {
            QuizQuestion currentQuestion = questions[questionIndex];
            System.out.println("Question " + (questionIndex + 1) + ": " + currentQuestion.getQuestion());
            String[] options = currentQuestion.getOptions();
            for (int i = 0; i < options.length; i++) {
                System.out.println((char) ('A' + i) + ": " + options[i]);
            }

            timer.schedule(new TimerTask() {
                public void run() {
                    timeUp = true;
                }
            }, 10000);  // 10 seconds for each question

            System.out.print("Enter your answer (A/B/C/D): ");
            char answer = scanner.next().charAt(0);

            if (timeUp) {
                System.out.println("Time's up!");
                timeUp = false;
            } else if (answer == currentQuestion.getCorrectAnswer()) {
                System.out.println("Correct!");
                score++;
            } else {
                System.out.println("Wrong! The correct answer is: " + currentQuestion.getCorrectAnswer());
            }

            questionIndex++;
            timer.purge();
        }

        displayResults();
        scanner.close();
    }

    private void displayResults() {
        System.out.println("\nQuiz Over!");
        System.out.println("Your score: " + score + "/" + questions.length);
        System.out.println("Summary:");

        for (int i = 0; i < questions.length; i++) {
            QuizQuestion question = questions[i];
            System.out.println("Q" + (i + 1) + ": " + question.getQuestion());
            System.out.println("Correct answer: " + question.getCorrectAnswer());
        }
    }
}
