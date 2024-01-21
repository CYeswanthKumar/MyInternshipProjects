import java.util.Scanner;

public class TextAdventureGame {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Welcome to the Quest for the Magical Artifact!");
        System.out.println("You find yourself in a mysterious forest. Your goal is to find the legendary artifact.");

        int choice;

        do {
            System.out.println("\nChoose your next move:");
            System.out.println("1. Go deeper into the forest.");
            System.out.println("2. Take a hidden path to the right.");
            System.out.println("3. Climb a tree to get a better view.");

            System.out.print("Enter your choice (1, 2, or 3): ");
            try {
                choice = Integer.parseInt(scanner.nextLine());

                switch (choice) {
                    case 1:
                        System.out.println("As you go deeper into the forest, you encounter a mystical creature.");
                        System.out.println("What will you do?");
                        System.out.println("1. Try to communicate with the creature.");
                        System.out.println("2. Attack the creature.");

                        int creatureChoice = Integer.parseInt(scanner.nextLine());

                        if (creatureChoice == 1) {
                            System.out.println("The creature turns out to be friendly and guides you to the artifact.");
                            System.out.println("Congratulations! You found the magical artifact!");
                        } else if (creatureChoice == 2) {
                            System.out.println("The creature retaliates and you are defeated. Game over!");
                        } else {
                            System.out.println("Invalid choice. Game over!");
                        }
                        break;

                    case 2:
                        System.out.println("You discover a hidden path with traps. What will you do?");
                        System.out.println("1. Proceed carefully, trying to avoid the traps.");
                        System.out.println("2. Turn back and choose a different path.");

                        int trapChoice = Integer.parseInt(scanner.nextLine());

                        if (trapChoice == 1) {
                            System.out.println("You successfully navigate the traps and find the artifact.");
                            System.out.println("Congratulations! You found the magical artifact!");
                        } else if (trapChoice == 2) {
                            System.out.println("You decide to turn back and explore another path. Good choice!");
                        } else {
                            System.out.println("Invalid choice. Game over!");
                        }
                        break;

                    case 3:
                        System.out.println("From the top of the tree, you see two paths. Which one will you take?");
                        System.out.println("1. Take the left path.");
                        System.out.println("2. Take the right path.");

                        int treeChoice = Integer.parseInt(scanner.nextLine());

                        if (treeChoice == 1) {
                            System.out.println("You encounter a friendly group of forest creatures who guide you to the artifact.");
                            System.out.println("Congratulations! You found the magical artifact!");
                        } else if (treeChoice == 2) {
                            System.out.println("You accidentally disturb a nest of dangerous birds. Game over!");
                        } else {
                            System.out.println("Invalid choice. Game over!");
                        }
                        break;

                    default:
                        System.out.println("Invalid choice. Please enter 1, 2, or 3.");
                        break;
                }

            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a number.");
                choice = 0;
            }

        } while (choice < 1 || choice > 3);

        scanner.close();
    }
}
