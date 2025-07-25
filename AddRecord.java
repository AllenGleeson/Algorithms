import java.util.*;

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
    AddRecord() {
        scanner = new Scanner(System.in);
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