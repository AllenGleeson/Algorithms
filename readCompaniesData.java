import java.io.File;
import java.lang.annotation.ElementType;
import java.util.*;

public class readCompaniesData {

    public static void main(String[] args) throws Exception {
        // parsing and reading the CSV file data into the object array
        File directory = new File("./");
        String name = directory.getAbsolutePath() + "//companies.csv";
        // Creating multiple arrays to store different numbers of unsorted records to
        // test time
        Company[] companies10 = new Company[10];
        Company[] companies100 = new Company[100];
        Company[] companies1000 = new Company[1000];
        Company[] companies5000 = new Company[5000];
        Company[] companies10000 = new Company[10000];
        // Quick sort companies
        Company[] companies10000quicksort = new Company[10000];
        // Binary search companies
        Company[] companies10000binarySearch = new Company[10000];
        // Store references in a 2D array
        Company[][] companies = new Company[5][];
        companies[0] = companies10;
        companies[1] = companies100;
        companies[2] = companies1000;
        companies[3] = companies5000;
        companies[4] = companies10000;

        try (Scanner scanner = new Scanner(new File(name))) {
            scanner.nextLine();

            // Load data once into a big list
            int companyIndex = 0;
            List<Company> allCompanies = new ArrayList<>();
            while (scanner.hasNextLine()) {
                String sGetData = scanner.nextLine();
                String[] data = sGetData.split(";");

                Company company = new Company(
                        Integer.parseInt(data[0]), data[1], data[2], data[3],
                        Integer.parseInt(data[4]), Long.parseLong(data[5]));
                // Adding company to allCompanies 2d array
                allCompanies.add(company);
                // Adding companies to companies10000quicksort to apply quick sort on
                companies10000quicksort[companyIndex] = company;
                companies10000binarySearch[companyIndex] = company;
                companyIndex += 1;
            }

            // Fills each array from the list with number of records it can hold
            for (int i = 0; i < companies.length; i++) {
                Company[] array = companies[i];
                for (int j = 0; j < array.length && j < allCompanies.size(); j++) {
                    array[j] = allCompanies.get(j);
                }
            }
        }

        // we can print details due to overridden toString method in the class below
        System.out.println(companies10000[0]);
        System.out.println(companies10000[1]);

        // we can compare objects based on their ID due to overridden CompareTo method
        // in the class below
        System.out.println(companies10000[0] == companies10000[0]);
        System.out.println(companies10000[0] == companies10000[1]);

        // Question 1
        SortSearchClass<Company> SortSearchClass = new SortSearchClass<>();

        System.out.println("First 10 Companies before Bubble Sort");
        for (int i = 0; i < 10; i++) {
            System.out.println(companies10000[i]);
        }
        SortSearchClass.bubbleSort(companies10000);
        System.out.println("First 10 Companies after Bubble Sort");
        for (int i = 0; i < 10; i++) {
            System.out.println(companies10000[i]);
        }

        // Question 2
        for (Company[] companyArray : companies) {
            // Skip empty arrays
            if (companyArray == null || companyArray[0] == null)
                continue;

            System.out.println("Sorting Companies " + companyArray.length + " using Bubble Sort...");

            long startTime = System.nanoTime();
            SortSearchClass.bubbleSort(companyArray);
            long endTime = System.nanoTime();

            long durationMillis = (endTime - startTime) / 1_000_000;
            System.out
                    .println("Bubble Sort on " + companyArray.length + " companies took: " + durationMillis + " ms\n");
        }

        // Question 3
        System.out.println("First 10 Companies before Quick Sort");
        for (int i = 0; i < 10; i++) {
            System.out.println(companies10000quicksort[i]);
        }
        SortSearchClass.quickSort(companies10000quicksort);
        System.out.println("First 10 Companies after Quick Sort");
        for (int i = 0; i < 10; i++) {
            System.out.println(companies10000quicksort[i]);
        }
        // Question 4
        Scanner input = new Scanner(System.in);
        System.out.println("Search by: name, country, or currency?");
        String field = input.nextLine().toLowerCase();
        System.out.println("Enter value to search:");
        String value = input.nextLine();
        Comparator<Company> comparator;
        Company target;

        switch (field) {
            case "name":
                comparator = Comparator.comparing(Company::getsName);
                Arrays.sort(companies10000binarySearch, comparator);
                target = new Company(0, value, "", "", 0, 0);
                break;
            case "country":
                comparator = Comparator.comparing(Company::getsCountry);
                Arrays.sort(companies10000binarySearch, comparator);
                target = new Company(0, "", value, "", 0, 0);
                break;
            case "currency":
                comparator = Comparator.comparing(Company::getsCurrency);
                Arrays.sort(companies10000binarySearch, comparator);
                target = new Company(0, "", "", value, 0, 0);
                break;
            default:
                System.out.println("Invalid field selected.");
                input.close();
                return;
        }

        if (comparator != null) {
            int index = SortSearchClass.binarySearch(companies10000binarySearch, target, comparator);
            if (index != -1) {
                System.out.println("Found: " + companies10000binarySearch[index] + " in companies array");
            } else {
                System.out.println("Not found in companies array");
            }
            input.close();
        }
        // Question 5
        // Instantiate new AddRecord to scan new company from user
        AddRecord addRecord = new AddRecord();
        addRecord.scanNewCompany();
        // create new array from old array, allocate one more element and the new
        // company to the end of array
        companies10000 = Arrays.copyOf(companies10000, companies10000.length + 1);
        companies10000[companies10000.length - 1] = addRecord.getNewCompany();
        // Question 6
        // Go to AddRecord.java
    }
}

class Company implements Comparable<Object> {
    private int iId;
    private String sName;
    private String sCountry;
    private String sCurrency;
    private int iAccount;
    private long lCvv;

    // constructor
    public Company(int iInId, String sInName, String sInCountry, String sInCurrency, int iInAccount, long lInCvv) {
        this.iId = iInId;
        this.sName = sInName;
        this.sCountry = sInCountry;
        this.sCurrency = sInCurrency;
        this.iAccount = iInAccount;
        this.lCvv = lInCvv;
    }

    // the objects can be compared when sorting/searching
    @Override
    public int compareTo(Object obj) {
        Company company = (Company) obj;

        int primary = Long.compare(this.lCvv, company.getlCvv());
        if (primary != 0) {
            return primary;
        }

        // If the CVV is the same for both objects then it will compare by ID
        return Integer.compare(this.iId, company.getiId());
    }

    @Override
    public String toString() {
        return "Company [ID= " + iId + ", Name= " + sName + ", Country= "
                + sCountry + ", Currency= " + sCurrency + ", Account= "
                + iAccount + ", CVV= " + lCvv + "]";
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

}