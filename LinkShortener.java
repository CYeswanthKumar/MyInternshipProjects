import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class LinkShortener {
    private Map<String, String> urlMap;

    public LinkShortener() {
        this.urlMap = new HashMap<>();
    }

    public String shortenURL(String longURL) {
        String shortURL = generateShortURL(longURL);
        if (urlMap.containsValue(shortURL)) {
            System.out.println("Error: Duplicate short URL. Try again.");
            return null;
        }

        urlMap.put(shortURL, longURL);
        return shortURL;
    }

    public String expandURL(String shortURL) {
        if (!urlMap.containsKey(shortURL)) {
            System.out.println("Error: Invalid short URL. Please check and try again.");
            return null;
        }

        return urlMap.get(shortURL);
    }

    private String generateShortURL(String longURL) {
        return String.valueOf(longURL.hashCode());
    }

    public static void main(String[] args) {
        LinkShortener linkShortener = new LinkShortener();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("1. Shorten URL");
            System.out.println("2. Expand URL");
            System.out.println("3. Exit");
            System.out.print("Choose an option: ");

            int choice = scanner.nextInt();
            scanner.nextLine(); 

            switch (choice) {
                case 1:
                    System.out.print("Enter the long URL: ");
                    String longURL = scanner.nextLine();
                    String shortURL = linkShortener.shortenURL(longURL);
                    if (shortURL != null) {
                        System.out.println("Shortened URL: " + shortURL);
                    }
                    break;
                case 2:
                    System.out.print("Enter the short URL: ");
                    String inputShortURL = scanner.nextLine();
                    String expandedURL = linkShortener.expandURL(inputShortURL);
                    if (expandedURL != null) {
                        System.out.println("Expanded URL: " + expandedURL);
                    }
                    break;
                case 3:
                    System.out.println("Exiting the program. Goodbye!");
                    System.exit(0);
                default:
                    System.out.println("Invalid option. Please try again.");
            }
        }
    }
}
