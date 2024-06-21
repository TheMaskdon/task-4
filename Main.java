public class Main {
    public static void main(String[] args) {
        QuizQuestion[] questions = {
            new QuizQuestion("What is the capital of France?", new String[]{"Paris", "London", "Berlin", "Madrid"}, 'A'),
            new QuizQuestion("What is 2 + 2?", new String[]{"3", "4", "5", "6"}, 'B'),
            new QuizQuestion("What is the color of the sky?", new String[]{"Blue", "Green", "Red", "Yellow"}, 'A')
        };

        Quiz quiz = new Quiz(questions);
        quiz.start();
    }
}
