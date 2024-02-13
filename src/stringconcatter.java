// Eddie Hart
// Feb 13th, 2024
// CSC 1060

// imports da scanner
import java.util.Scanner;

public class stringconcatter {
    // this method right here just checks if there is a substring saved in its respective variable
    public static void subChecker(String sub) {
        if (sub.equals("")) {
            System.out.println("No Substring Found.");
        } else {
            System.out.println("Substring: " + sub);
        }
    }

    // this method checks for a substring in between a prefix and suffix using some math and indexes
    public static String subInBetween(String uS, String pF, String sF) {
        return uS.substring(uS.indexOf(pF) + stringLength(pF), uS.indexOf(sF));
    }

    // this method checks for a substring before a suffix, starting with index 0 up unto the index of the suffix
    public static String subBeforeSuf(String uS, String sF) {
        return uS.substring(0, uS.indexOf(sF));
    }

    // this method checks for a substring after a prefix, starting with index of the length of the prefix up unto the length of the original string
    public static String subAfterPre(String uS, String pF) {
        return uS.substring(uS.indexOf(pF) + pF.length(), stringLength(uS));
    }

    // this method is kinda useless cus it basically renames the built in .length() method to stringLength()
    public static int stringLength(String uS) {
        return uS.length();
    }

    // this method concatenates string to the original string
    public static String addContent(String uS, String additive) {
        return uS + additive;
    }

    // here's the meat of the program with a couple of declared variables for later on
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int optionPick = 0;
        String substring = "";
        System.out.println("Enter your string: ");
        String userString = input.nextLine();

        // this while loop executes until user inputs 7 which is exit
        while (optionPick != 7) {
            System.out.println("\nPick an option: ");
            System.out.println("1. Add Content");
            System.out.println("2. Check If String Contains Substring");
            System.out.println("3. Output Length");
            System.out.println("4. Output Substring After Prefix");
            System.out.println("5. Output Substring Before Suffix");
            System.out.println("6. Output Substring Between Prefix and Suffix");
            System.out.println("7. Exit");
            optionPick = input.nextInt();

            // i found the opportunity to use a switch instead of an else if chain so i did that
            // for each case i use the respective method to do what the user expects
            // they usually either input a suffix or prefix and get their desired substring
            switch (optionPick) {
                case 1:
                    String additive = input.next();
                    userString = addContent(userString, additive);
                    System.out.println("New string: " + userString);
                    break;
                /* i wasnt sure what it meant by "check if string contains substring" so i just made it to where
                 * if the user didnt use the substring functions there is no substring stored so there would be
                 * no substring found and vice versa. */
                case 2:
                    subChecker(substring);
                    break;
                case 3:
                    System.out.println("Length: " + stringLength(userString));
                    break;
                case 4:
                    System.out.println("Prefix: ");
                    String prefix = input.next();
                    substring = subAfterPre(userString, prefix);
                    System.out.println("Substring: " + substring);
                    break;
                case 5:
                    System.out.println("Suffix: ");
                    String suffix = input.next();
                    substring = subBeforeSuf(userString, suffix);
                    System.out.println("Substring: " + substring);
                    break;
                case 6:
                    System.out.println("Prefix: ");
                    prefix = input.next();
                    System.out.println("Suffix: ");
                    suffix = input.next();
                    substring = subInBetween(userString, prefix, suffix);
                    System.out.println("Substring: " + substring);
            }
        }


    }
}