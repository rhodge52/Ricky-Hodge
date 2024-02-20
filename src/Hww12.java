import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
public class Hww12 {
        
        public static boolean validatePassword(String password) {
            
            if (password.length() < 8 || password.length() > 16) {
                return false;
            }
            
            
            int categoriesCount = 0;
            
            
            if (password.matches(".*[a-z].*")) {
                categoriesCount++;
            }
            
           
            if (password.matches(".*[A-Z].*")) {
                categoriesCount++;
            }
            
            
            if (password.matches(".*[0-9].*")) {
                categoriesCount++;
            }
            
            
            Pattern specialSymbolsPattern = Pattern.compile("[~!@#$%^&*()-=+_]");
            Matcher matcher = specialSymbolsPattern.matcher(password);
            if (matcher.find()) {
                categoriesCount++;
            }
            
            return categoriesCount >= 3;
        }
        
        public static void main(String[] args) {
            
            Scanner scanner = new Scanner(System.in);
            
            
            System.out.print("Enter a password: ");
            String password = scanner.nextLine();
            
            
            boolean isValid = validatePassword(password);
            
            
            if (isValid) {
                System.out.println("Password is valid.");
            } else {
                System.out.println("Password is not valid.");
            }
            
            
            scanner.close();
            
            
            String[] testPasswords = {"Abcd1234", "Abcd123@", "abcd1234", "ABCD1234", "abcdABCD", "12345678", "~!@#$%^&*()-=+_Abc"};
            System.out.println("\nRunning additional tests:");
            for (String testPassword : testPasswords) {
                System.out.println("Password: " + testPassword + " - Valid: " + validatePassword(testPassword));
            }
        }
    }
    

