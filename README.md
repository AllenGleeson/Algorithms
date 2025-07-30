# Companies Data Processing System

##### Language:
[![Java](https://img.shields.io/badge/Java-007396?logo=java&logoColor=white)](#)

A Java application that processes company data from CSV files, implements various sorting algorithms (Bubble Sort and Quick Sort), performs binary search operations, and allows users to add new records to the dataset.

## Features

### Data Processing
- **CSV File Reading**: Reads company data from `companies.csv` file
- **Multiple Dataset Sizes**: Processes data in different array sizes (10, 100, 1000, 5000, 10000 records)
- **Company Information**: Each record contains ID, Name, Country, Currency, Account Number, and CVV

### Sorting Algorithms
- **Bubble Sort**: Implements O(n²) bubble sort algorithm with performance timing
- **Quick Sort**: Implements O(n log n) quick sort algorithm for efficient sorting
- **Performance Comparison**: Measures and displays execution time for different dataset sizes

### Search Functionality
- **Binary Search**: Implements O(log n) binary search algorithm
- **Multiple Search Fields**: Search by company name, country, or currency
- **Flexible Comparators**: Uses custom comparators for different search criteria

### Record Management
- **Add New Records**: Interactive interface to add new company records
- **Input Validation**: Comprehensive exception handling for data validation
- **Dynamic Array Expansion**: Automatically expands arrays when adding new records

## Project Structure

```
Algorithms/
├── readCompaniesData.java    # Main application entry point
├── SortSearchClass.java      # Generic sorting and searching algorithms
├── AddRecord.java           # Record addition functionality with validation
├── companies.csv            # Input data file (10,000+ records)
└── README.md               # This documentation file
```

## Data Format

The CSV file contains company records with the following structure:
```
id;name;country;currency;account;cvv
1;Collins Inc;Svalbard & Jan Mayen Islands;Tanzanian Shilling;62479319;626
```

Each record includes:
- **ID**: Integer identifier
- **Name**: Company name (string)
- **Country**: Country name (string)
- **Currency**: Currency type (string)
- **Account**: Account number (integer)
- **CVV**: CVV code (long integer)

## Algorithms Implemented

### Bubble Sort
- **Time Complexity**: O(n²)
- **Space Complexity**: O(1)
- **Features**: Early termination when no swaps occur
- **Usage**: Sorts arrays of different sizes (10, 100, 1000, 5000, 10000 records)

### Quick Sort
- **Time Complexity**: O(n log n) average case
- **Space Complexity**: O(log n) due to recursion
- **Features**: Uses last element as pivot, in-place sorting
- **Usage**: Efficient sorting for large datasets

### Binary Search
- **Time Complexity**: O(log n)
- **Space Complexity**: O(1)
- **Features**: Requires sorted array, supports custom comparators
- **Usage**: Fast searching by name, country, or currency

## Exception Handling

The application includes comprehensive exception handling for data validation:

- `InvalidNameException`: Validates company names (non-empty, not just digits)
- `InvalidCountryException`: Validates country names (non-empty, not just digits)
- `InvalidCurrencyException`: Validates currency codes (non-empty, not just digits)
- `InvalidIdException`: Validates ID as integer
- `InvalidAccountException`: Validates account numbers as integers
- `InvalidCvvException`: Validates CVV as long integer

## Usage Instructions

### Running the Application

1. **Compile the Java files**:
   ```bash
   javac *.java
   ```

2. **Run the main application**:
   ```bash
   java readCompaniesData
   ```

### Program Flow

1. **Data Loading**: The application loads company data from `companies.csv`
2. **Bubble Sort Performance**: Sorts datasets of different sizes and displays timing
3. **Quick Sort Demonstration**: Shows before/after sorting of 10,000 records
4. **Binary Search**: Interactive search by name, country, or currency
5. **Add Record**: Interactive interface to add new company records
6. **Input Validation**: Comprehensive validation with user-friendly error messages

### Example Output

```
First 10 Companies in 10000 array before Bubble Sort
Company [ID= 1, Name= Collins Inc, Country= Svalbard & Jan Mayen Islands, Currency= Tanzanian Shilling, Account= 62479319, CVV= 626]
...

Sorting Companies 10 using Bubble Sort...
Bubble Sort on 10 companies took: 2 ms

Sorting Companies 100 using Bubble Sort...
Bubble Sort on 100 companies took: 15 ms

...

Search by: name, country, or currency?
Enter value to search:
Found:
Company [ID= 123, Name= Example Corp, Country= USA, Currency= USD, Account= 12345678, CVV= 123]
```

## Technical Details

### Class Structure

- **`Company`**: Data model class with compareTo method for sorting
- **`SortSearchClass<T>`**: Generic class implementing sorting and searching algorithms
- **`AddRecord`**: Handles user input and record creation with validation
- **`readCompaniesData`**: Main application class orchestrating all operations

### Performance Considerations

- **Memory Management**: Uses arrays for efficient memory usage
- **Algorithm Selection**: Quick sort for large datasets, bubble sort for demonstration
- **Search Optimization**: Binary search requires pre-sorted data
- **Input Validation**: Prevents invalid data from corrupting the dataset

## Requirements

- **Java**: JDK 8 or higher
- **File System**: Read access to `companies.csv` file
- **Console**: Interactive console for user input

## Error Handling

The application handles:
- File not found errors
- Invalid CSV format
- User input validation errors
- Array bounds exceptions
- Number format exceptions

All errors are caught and displayed with helpful messages to guide the user.