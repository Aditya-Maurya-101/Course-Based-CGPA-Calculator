<p align="center">
  <img src="https://raw.githubusercontent.com/github/explore/main/topics/java/java.png" width="120" alt="Java Logo" />
</p>
<p align="center">
  <a href="https://www.java.com/">
    <img src="https://img.shields.io/badge/Language-Java-007396?logo=java&logoColor=white" alt="Java" />
  </a>
  <img src="https://img.shields.io/badge/Platform-Console-brightgreen" alt="Console App" />
</p>

# CGPA Calculator

A simple Java console application that calculates a student's CGPA based on semester SGPA values and shows the current performance.

## Features

- ☕ Java console application for calculating CGPA
- 📚 Select course and semester count from a predefined list
- ⏳ Enter SGPA values with support for pending results (0 or -1)
- 🔢 CGPA calculation skips semesters that are pending or incomplete
- 🏅 Performance classification based on CGPA thresholds
- 📝 Clear formatted report card output with student details
- ✅ Input validation for SGPA values between 0 and 10

## Technologies Used

- ☕ Java SE (console application)
- 🔍 `Scanner` for user input
- 📦 `ArrayList` for storing semester SGPA values
- 🧱 Object-oriented design with `Course`, `Student`, and `CGPACalculator`
- 🖨️ String formatting for structured console report output

## How to run

1. Compile the Java file:
   ```bash
   javac Calc.java
   ```
2. Run the program:
   ```bash
   java Calc
   ```

## Example Input

```
Enter Student Name : Aditya
Enter Roll Number  : 12345

Available Courses:
1. BCA (6 Semesters)
2. B.Tech (8 Semesters)
... 

Select Course (1-15): 1

Selected Course : BCA
Total Semesters : 6

Enter SGPA
(0 or -1 = Result Pending)

Semester 1 SGPA : 8.5
Semester 2 SGPA : 9.0
Semester 3 SGPA : -1
Semester 4 SGPA : 7.8
Semester 5 SGPA : 0
Semester 6 SGPA : 8.2
```

## Example Output

```
+------------------------------------------------------+
|                 STUDENT REPORT CARD                  |
+------------------------------------------------------+
| Name            : Aditya                             |
| Roll Number     : 12345                              |
| Course          : BCA                                |
+------------------------------------------------------+
|                 SEMESTER DETAILS                     |
+------------------------------------------------------+
| Semester 1      : 8.50                               |
| Semester 2      : 9.00                               |
| Semester 3      : Result Pending                     |
| Semester 4      : 7.80                               |
| Semester 5      : Result Pending                     |
| Semester 6      : 8.20                               |
+------------------------------------------------------+
| Current CGPA    : 8.38                               |
| Performance     : Distinction                        |
+------------------------------------------------------+ 
```

## OOP Concepts Used

- **Classes and Objects**: `Course`, `Student`, and `CGPACalculator` are separate classes that model the program's domain.
- **Encapsulation**: Class fields are `private` and accessed through public methods like `getCourseName()` and `addSGPA()`.
- **Abstraction**: `CGPACalculator` hides CGPA logic behind static methods such as `calculateCGPA()` and `getPerformance()`.
- **Composition**: A `Student` object contains a `Course` object and a list of semester SGPA values.

## Notes

- Enter `-1` or `0` for semesters where results are pending.
- Only valid SGPA values between `0` and `10` are accepted.
