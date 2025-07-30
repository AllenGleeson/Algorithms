import java.util.*;

// Question 6 Exceptions
// Base exception class
class InvalidFieldException extends Exception {
    public InvalidFieldException(String message) {
        super(message);
    }
}

// For each field
class InvalidNameException extends InvalidFieldException {
    public InvalidNameException() {
        super("Name cannot be empty or contain only digits. Please enter a valid name.");
    }
}

class InvalidCountryException extends InvalidFieldException {
    public InvalidCountryException() {
        super("Country cannot be empty or contain only digits. Please enter a valid country name.");
    }
}

class InvalidCurrencyException extends InvalidFieldException {
    public InvalidCurrencyException() {
        super("Currency cannot be empty or contain only digits. Please enter a valid currency.");
    }
}

class InvalidIdException extends InvalidFieldException {
    public InvalidIdException() {
        super("ID must be a valid integer.");
    }
}

class InvalidAccountException extends InvalidFieldException {
    public InvalidAccountException() {
        super("Account number must be a valid integer.");
    }
}

class InvalidCvvException extends InvalidFieldException {
    public InvalidCvvException() {
        super("CVV must be a valid long number.");
    }
}
// -------------------------------------------------

// Question 5 Add Record
public class AddRecord {
    // Data types
    Scanner scanner;
    Company newCompany;
    private int iId;
    private String sName;
    private String sCountry;
    private String sCurrency;
    private int iAccount;
    private long lCvv;

    // Constructor
    AddRecord(Scanner scanner) {
        this.scanner = scanner;
    }

    // Gets data from user and creates new company
    public void scanNewCompany() {
        System.out.println("------------------------------------------------");
        System.out.println("Lets add a new record to the array.");
        System.out.println("ID           : Integer (e.g., 101)");
        System.out.println("Name         : String (not empty or just digits)");
        System.out.println("Country      : String (not empty or just digits)");
        System.out.println("Currency     : String (e.g., EUR, USD)");
        System.out.println("Account No.  : Integer (e.g., 123456)");
        System.out.println("CVV          : Long (e.g., 123 or 456789)");
        System.out.println("------------------------------------------------");
        int id = scanId();
        String name = scanName();
        String country = scanCountry();
        String currency = scanCurrency();
        int account = scanAccountNumber();
        long cvv = scanCvv();

        newCompany = new Company(id, name, country, currency, account, cvv);
        System.out.println("Company created: " + newCompany.toString());
    }

    // Gets input for ID and throws InvalidIdException if input is not a valid integer
    public int scanId() {
        while (true) {
            System.out.print("Enter ID: ");
            String input = scanner.nextLine();
            try {
                return Integer.parseInt(input);
            } catch (NumberFormatException e) {
                System.out.println(new InvalidIdException().getMessage());
            }
        }
    }

    // Gets input for Name and throws InvalidNameException if empty or only digits
    public String scanName() {
        while (true) {
            System.out.print("Enter Name: ");
            String name = scanner.nextLine();
            try {
                if (name.trim().isEmpty() || name.matches("\\d+")) {
                    throw new InvalidNameException();
                }
                return name;
            } catch (InvalidNameException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    // Gets input for Country and throws InvalidCountryException if empty or only digits
    public String scanCountry() {
        while (true) {
            System.out.print("Enter Country: ");
            String country = scanner.nextLine();
            try {
                if (country.trim().isEmpty() || country.matches("\\d+")) {
                    throw new InvalidCountryException();
                }
                return country;
            } catch (InvalidCountryException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    // Gets input for Currency and throws InvalidCurrencyException if empty or only digits
    public String scanCurrency() {
        while (true) {
            System.out.print("Enter Currency: ");
            String currency = scanner.nextLine();
            try {
                if (currency.trim().isEmpty() || currency.matches("\\d+")) {
                    throw new InvalidCurrencyException();
                }
                return currency;
            } catch (InvalidCurrencyException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    // Gets input for Account Number and throws InvalidAccountException if not a valid integer
    public int scanAccountNumber() {
        while (true) {
            System.out.print("Enter Account Number: ");
            String input = scanner.nextLine();
            try {
                return Integer.parseInt(input);
            } catch (NumberFormatException e) {
                System.out.println(new InvalidAccountException().getMessage());
            }
        }
    }

    // Gets input for CVV and throws InvalidCvvException if not a valid long
    public long scanCvv() {
        while (true) {
            System.out.print("Enter CVV: ");
            String input = scanner.nextLine();
            try {
                return Long.parseLong(input);
            } catch (NumberFormatException e) {
                System.out.println(new InvalidCvvException().getMessage());
            }
        }
    }

    // getters and setters
    public int getiId() {
        return iId;
    }

    public void setiId(int iId) {
        this.iId = iId;
    }

    public String getsName() {
        return sName;
    }

    public void setsName(String sName) {
        this.sName = sName;
    }

    public String getsCountry() {
        return sCountry;
    }

    public void setsCountry(String sCountry) {
        this.sCountry = sCountry;
    }

    public String getsCurrency() {
        return sCurrency;
    }

    public void setsCurrency(String sCurrency) {
        this.sCurrency = sCurrency;
    }

    public int getiAccount() {
        return iAccount;
    }

    public void setiAccount(int iAccount) {
        this.iAccount = iAccount;
    }

    public long getlCvv() {
        return lCvv;
    }

    public void setlCvv(long lCvv) {
        this.lCvv = lCvv;
    }

    public Company getNewCompany() {
        return newCompany;
    }
}