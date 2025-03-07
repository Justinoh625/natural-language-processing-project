import java.util.ArrayList;
import java.util.Scanner;

/**
 * SpamCatcher is a Natural Language Processing (NLP) program that detects spam words 
 * in an email based on a list of spam word
 * It analyzes both example and user-input emails.
 */
public class SpamCatcher {

    private ArrayList<String> spamWords; // List of spam words from SpamWords.txt
    private ArrayList<String> email1; // Example spam email from Email1.txt

    /**
     *Initializes spamWords and email1 by reading from text files.
     */
    public SpamCatcher() {
        spamWords = FileReader.toStringList("SpamWords.txt");
        email1 = FileReader.toStringList("Email1.txt");
    }

    /**
     * Checks if a given email content contains any spam words
     * @param content The email text to be analyzed
     * @return true if at least one spam word is found and false otherwise
     */
    public boolean containsSpamWord(String content) {
        for (String spamWord : spamWords) {
            if (content.toLowerCase().contains(spamWord.toLowerCase())) { 
                return true; // Spam detected
            }
        }
        return false; // No spam words found
    }

    /**
     * Counts the number of spam words found in a given email content
     * @param content The email text to be analyzed
     * @return The total count of spam words in the email
     */
    public int countSpamWords(String content) {
        int spamCount = 0;
        for (String spamWord : spamWords) {
            if (content.toLowerCase().contains(spamWord.toLowerCase())) {
                spamCount++; 
            }
        }
        return spamCount;
    }

    /**
     * Displays all spam words from SpamWords.txt to warn users.
     */
    public void displaySpamWords() {
        System.out.println("Be aware of these common spam words in your emails:");
        for (String word : spamWords) {
            System.out.print(word + ", "); // Print all spam words in a single line
        }
        System.out.println("\n"); 
    }

    /**
     * Displays an example of a spam email and highlights detected spam words.
     */
    public void exampleEmail1() {
        System.out.println("Example of a spam email:\n");

        // Display the email content
        for (String emailLine : email1) {
            System.out.println(emailLine);
        }

        System.out.println("\nAnalyzing spam content...\n");
        int spamCount = 0;

        // Check each line of the example email for spam words
        for (String line : email1) {
            int count = countSpamWords(line);
            spamCount += count;

            // If spam words are found display them
            if (count > 0) {
                System.out.println("Spam found: " + line + " (" + count + " spam words detected)");
            }
        }
        
        // Summary
        System.out.println("\nSummary: This example email contains " + spamCount + " spam words.\n");
    }

    /**
     * Allows the user to input an email and checks if it contains spam words.
     */
    public void checkUserEmail() {
        Scanner scanner = new Scanner(System.in);

        // ask the user for email input
        System.out.println("\nEnter your email message:");
        String userInput = scanner.nextLine();

        // Analyze the user email for spam words
        int spamCount = countSpamWords(userInput);
        if (spamCount > 0) {
            System.out.println("Summary: This email is likely spam! It contains " + spamCount + " spam words.");
        } else {
            System.out.println("Summary: This email looks safe. There are no spam words.");
        }

        scanner.close();
    }
}