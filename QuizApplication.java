import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Question {
    private String questionText;
    private List<String> options;
    private int correctAnswerIndex;

    public Question(String questionText, List<String> options, int correctAnswerIndex) {
        this.questionText = questionText;
        this.options = options;
        this.correctAnswerIndex = correctAnswerIndex;
    }

    public String getQuestionText() {
        return questionText;
    }

    public List<String> getOptions() {
        return options;
    }

    public int getCorrectAnswerIndex() {
        return correctAnswerIndex;
    }
}

class Quiz {
    private List<Question> questions;

    public Quiz(List<Question> questions) {
        this.questions = questions;
    }

    public int getNumberOfQuestions() {
        return questions.size();
    }

    public Question getQuestion(int index) {
        return questions.get(index);
    }
}

public class QuizApplication {
    public static void main(String[] args) {
        List<Question> questions = new ArrayList<>();
        questions.add(new Question("What is the capital of France?",
                List.of("Berlin", "Paris", "Madrid", "Rome"), 1));
        questions.add(new Question("Which planet is known as the Red Planet?",
                List.of("Earth", "Mars", "Venus", "Jupiter"), 1));
        // Add more questions as needed

        Quiz quiz = new Quiz(questions);

        Scanner scanner = new Scanner(System.in);
        int score = 0;

        System.out.println("Welcome to the Quiz!");
        System.out.println("There are " + quiz.getNumberOfQuestions() + " questions.\n");

        for (int i = 0; i < quiz.getNumberOfQuestions(); i++) {
            Question currentQuestion = quiz.getQuestion(i);

            System.out.println("Question " + (i + 1) + ": " + currentQuestion.getQuestionText());

            List<String> options = currentQuestion.getOptions();
            for (int j = 0; j < options.size(); j++) {
                System.out.println((j + 1) + ". " + options.get(j));
            }

            System.out.print("Your answer (1-" + options.size() + "): ");
            int userAnswer = getUserInput(scanner, 1, options.size());

            if (userAnswer - 1 == currentQuestion.getCorrectAnswerIndex()) {
                System.out.println("Correct!\n");
                score++;
            } else {
                System.out.println("Incorrect. The correct answer is: " +
                        options.get(currentQuestion.getCorrectAnswerIndex()) + "\n");
            }
        }

        System.out.println("Quiz complete! Your score is: " + score + " out of " + quiz.getNumberOfQuestions());
    }

    private static int getUserInput(Scanner scanner, int min, int max) {
        int input;
        while (true) {
            try {
                input = Integer.parseInt(scanner.nextLine());
                if (input >= min && input <= max) {
                    break;
                } else {
                    System.out.print("Invalid input. Please enter a number between " + min + " and " + max + ": ");
                }
            } catch (NumberFormatException e) {
                System.out.print("Invalid input. Please enter a number: ");
            }
        }
        return input;
    }
}
