/////////////////////////////////////////////////////
// 🟢 Task 1 - Employee Login Eligibility
// Concepts
// Variables
// Comparison Operators
// Logical Operators
// if else
// Scenario
// HR wants to verify whether an employee can access the office.
// Requirements
// Take employee age.
// Take employee ID availability (true/false).
// Take employee attendance percentage.
// Allow entry only if:
// Age >= 18
// ID available
// Attendance >= 75
// Expected Output
// Access Granted
// or
// Access Denied

const employeeAge = prompt("Enter employee age: ");
const employeeIDAvail = confirm("Do you have your ID? ");

if (employeeAge >= 18 && employeeIDAvail) {
  const employeeAttendance = Number(
    prompt("Enter your attendance in percentage: "),
  );
  if (employeeAttendance >= 75) {
    console.log("Access Granted");
  } else {
    console.log("Access Denied");
  }
} else {
  console.log("Access Denied");
}

/////////////////////////////////////////////////////
// 🟢 Task 2 - Student Grade System
// Concepts
// if else if
// Input
// Marks = 87
// Output
// Grade A
// Rules
// 90-100 -> A+
// 80-89  -> A
// 70-79  -> B
// 60-69  -> C
// Below 60 -> Fail

const marks = Number(prompt("Enter your marks from 0 to 100: "));
if (marks >= 90 && marks <= 100) {
  console.log("A+");
} else if (marks >= 80 && marks <= 89) {
  console.log("A");
} else if (marks >= 70 && marks <= 79) {
  console.log("B");
} else if (marks >= 60 && marks <= 69) {
  console.log("C");
} else {
  console.log("Fail");
}

/////////////////////////////////////////////////////
// 🟢 Task 3 - ATM Withdrawal
// Concepts
// Arithmetic
// if else
// Variables
// Balance = 5000
// Withdraw = 3000
// Conditions
// Enough balance
// Withdraw amount should be multiple of 100
// Output
// Transaction Successful
// Remaining Balance : 2000

const balance = 5000;
const withdraw = 3000;
if (withdraw % 100 === 0 && withdraw <= balance) {
  console.log("Transaction Successful. \nRemaining Balance: 2000");
}

/////////////////////////////////////////////////////
// 🟢 Task 4 - Food Ordering App
// Concepts
// switch
// Menu
// 1 Pizza
// 2 Burger
// 3 Shawarma
// 4 Biryani
// 5 Juice
// Input
// choice = 4
// Output
// You Ordered Biryani

/*
const menu = {
    1: "Pizza",
    2: "Burger",
    3: "Shawarma",
    4: "Biryani",
    5: "Juice",
};
*/

const foodChoice = prompt(
  "1. Pizza\n2. Burger\n3. Shawarma\n4. Biryani\n5. Juice\nEnter your order number from 1 to 5: ",
);
switch (Number(foodChoice)) {
  case 1:
    console.log("You Ordered Pizza");
    break;
  case 2:
    console.log("You Ordered Burger");
    break;
  case 3:
    console.log("You Ordered Shawarma");
    break;
  case 4:
    console.log("You Ordered Biryani");
    break;
  case 5:
    console.log("You Ordered Juice");
    break;

  default:
    console.log("Please enter only between 1 & 5");
}

/////////////////////////////////////////////////////
// 🟢 Task 5 - E-Commerce Discount
// Concepts
// Operators
// if else
// Rules
// Purchase > 5000

// Premium User

// ↓

// 20% Discount

// Otherwise

// 10% Discount
// Display
// Original Price
// Discount
// Final Price

const purchaseAmount = prompt("Enter Purchase Amount");
let discount;
if (purchaseAmount > 5000) {
  discount = 20 / 100;
} else {
  discount = 10 / 100;
}

console.log(
  `Original Price: ${purchaseAmount}\nDiscount: ${discount * 100}%\nFinal Price: ${purchaseAmount - purchaseAmount * discount}`,
);

/////////////////////////////////////////////////////
// 🟢 Task 6 - Attendance Report
// Concepts
// for loop
// Print
// Day 1 Present
// Day 2 Present
// ...
// Day 30 Present

for (let day = 1; day <= 30; day++) {
  console.log(`Day ${day} Present`);
}

/////////////////////////////////////////////////////
// 🟢 Task 7 - Even Number Generator
// Concepts
// Loop
// Modulus
// Print
// 2
// 4
// 6
// 8
// 10
// ...
// 100

for (let i = 1; i <= 100; i++) {
  if (i % 2 === 0) {
    console.log(i);
  }
}

/////////////////////////////////////////////////////
// 🟢 Task 8 - Mobile Number Validation
// Concepts
// if
// Logical Operator
// Conditions
// Length = 10

// Starts with

// 6
// 7
// 8
// 9
// Output
// Valid Mobile Number
// or
// Invalid Mobile Number

const mobileNumber = prompt("Enter your Mobile Number");
if ((mobileNumber.length = 10)) {
  if (
    mobileNumber.at(0) === "6" ||
    mobileNumber.at(0) === "7" ||
    mobileNumber.at(0) === "8" ||
    mobileNumber.at(0) === "9"
  ) {
    console.log("Valid Mobile Number");
  } else {
    console.log("Invalid Mobile Number");
  }
} else {
  console.log("Invalid Mobile Number");
}

/////////////////////////////////////////////////////
// 🟢 Task 9 - Shopping Cart
// Concepts
// Array
// cart = [
// "Milk",
// "Bread",
// "Egg",
// "Rice",
// "Oil"
// ]
// Print
// First Item

// Last Item

// Total Items

const cart = ["Milk", "Bread", "Egg", "Rice", "Oil"];
console.log(cart[0]);
console.log(cart[cart.length - 1]);
console.log(cart.length);

/////////////////////////////////////////////////////
// 🟢 Task 10 - Employee Database
// Concepts
// Object
// employee = {

// name

// salary

// department

// experience

// }
// Print
// Employee Name

// Department

// Experience

const employee = {
  name: "Karthik",
  dept: "IT",
  salary: 40000,
  exp: "8 years but fresher in Tech",
};

console.log("Employee Name: " + employee.name);
console.log("Department: " + employee.dept);
console.log("Experience: " + employee.exp);

/////////////////////////////////////////////////////
// 🟢 Task 11 - Company ID Generator
// Concepts
// Template Literal
// Input
// Name = Naveen

// ID = 1045

// Department = Development
// Output
// Welcome Naveen

// Your Employee ID is EMP1045

// Department : Development
const id = prompt("What is your Empoyee ID?");
const dept = prompt("Which Department do you belong to?");
console.log(`Your Employee ID is EMP${id}\nDepartment: ${dept}`);

/////////////////////////////////////////////////////
// 🟢 Task 12 - User Registration
// Concepts
// prompt()
// confirm()
// alert()
// Flow
// Enter Name

// Enter Age

// Do you accept Terms?

// ↓

// Registered Successfully

const name = prompt("Enter your Name");
const age = prompt("Enter your age");
const acceptTerms = confirm("Do you accept Terms?");
if (acceptTerms) {
  alert("Registered Successfully");
} else {
  alert("Something's wrong.");
}

/////////////////////////////////////////////////////
// 🟢 Task 13 - Salary Increment Calculator
// Concepts
// Arithmetic Operators
// Input
// Salary = 35000

// Increment = 15%
// Output
// Old Salary

// Increment Amount

// New Salary

const salary = 35000;
const increment = 15 / 100;
console.log(
  `Old Salary: ${salary}\nIncrement Amount: ${salary * increment}\nNew Salary: ${salary * increment + salary}`,
);

/////////////////////////////////////////////////////
// 🟢 Task 14 - Restaurant Bill Generator
// Concepts
// Variables
// Operators
// Input
// Burger = 150

// Pizza = 300

// Juice = 80
// Calculate
// Subtotal

// GST 18%

// Grand Total

const burger = Number(prompt("Enter Burger Price"));
const pizza = Number(prompt("Enter Pizza Price"));
const juice = Number(prompt("Enter Juice Price"));
const subtotal = burger + pizza + juice;
const gst = 18 / 100;

const grandtotal = subtotal * gst + subtotal;
console.log(`Your grandtotal is: ${grandtotal}`);

/////////////////////////////////////////////////////
// 🟢 Task 15 - Company Attendance Dashboard
// Concepts
// Loop
// Object
// if else
// Employees
// Rahul - Present

// Arun - Absent

// Kamal - Present

// Priya - Present

// Divya - Absent
// Print
// Present Employees

// Absent Employees

// Total Present

// Total Absent

const employeesAttendance = {
  Rahul: "Present",
  Kamal: "Present",
  Arun: "Absent",
  Divya: "Absent",
  Priya: "Present",
};

let present = [];
let absent = [];

for (const [key, value] of Object.entries(employeesAttendance)) {
  if (value === "Present") present.push(key);
  if (value === "Absent") absent.push(key);
}
console.log("Present Employees: ");
for (each in present) console.log(present[each]);
console.log("Absent Employees: ");
for (each in absent) console.log(absent[each]);
console.log(`Total Present: ${present.length}\nTotal Absent: ${absent.length}`);

/////////////////////////////////////////////////////
// ⭐ Mini Project (Team Assignment)
// Employee Management System (Console Version)
// Concepts Covered:
// Variables
// Arrays
// Objects
// if else
// switch
// Loops
// Operators
// Template Literals
// Features
// Add Employee
// View All Employees
// Search Employee by ID
// Calculate Salary with Bonus
// Check Experience Level
// Delete Employee
// Exit

const employees = [
  {
    id: 1,
    name: "Aarav Sharma",
    dept: "Engineering",
    salary: 65000,
    exp: 4,
  },
  {
    id: 2,
    name: "Priya Reddy",
    dept: "HR",
    salary: 48000,
    exp: 2,
  },
  {
    id: 3,
    name: "Rahul Mehta",
    dept: "Finance",
    salary: 72000,
    exp: 7,
  },
  {
    id: 4,
    name: "Sneha Iyer",
    dept: "Marketing",
    salary: 55000,
    exp: 3,
  },
  {
    id: 5,
    name: "Vikram Singh",
    dept: "Engineering",
    salary: 90000,
    exp: 10,
  },
  {
    id: 6,
    name: "Neha Gupta",
    dept: "Sales",
    salary: 50000,
    exp: 1,
  },
  {
    id: 7,
    name: "Aditya Rao",
    dept: "Support",
    salary: 43000,
    exp: 5,
  },
  {
    id: 8,
    name: "Kavya Nair",
    dept: "Engineering",
    salary: 78000,
    exp: 8,
  },
];

const choice = prompt(
  "1. Add Employee\n2. View All Employees\n3. Search Employee by ID\n4. Calculate Salary with Bonus\n5. Check Experience Level\n6. Delete Employee\n7. Exit",
);

console.log("You picked: " + choice);

switch (Number(choice)) {
  case 1:
    {
      const newName = prompt("Enter new employee Name");
      const newSalary = prompt("Enter new employee Salary");
      const newDept = prompt("Enter new employee Department");
      const newExp = prompt("Enter new employee Experience");

      employees.push({
        id: employees.length + 1,
        name: newName,
        dept: newDept,
        salary: newSalary,
        exp: newExp,
      });

      console.log(
        "Here's the added employee: ",
        employees[employees.length - 1],
      );
    }
    break;

  case 2:
    {
      for (each in employees) {
        console.log(employees[each].name);
      }
    }
    break;
  case 3:
    {
      const empid = prompt(
        "Who would you like to check out, enter id number from 1 to 8: ",
      );
      // for (const [key, value] of Object.entries(employees[empid - 1])) {
      //     console.log(`${key}: ${value}`);
      //   }

      console.log(employees[empid - 1]);
    }
    break;
  case 4:
    {
      const empid = prompt("Enter employee id from 1 to 8");
      const bonus = prompt("Enter bonus amount");
      console.log(
        `${employees[empid - 1].name}'s salary is INR ${employees[empid - 1].salary}. Add your bonus and it becomes INR ${employees[empid - 1].salary + Number(bonus)}`,
      );
    }
    break;
  case 5:
    {
      const empid = prompt(
        "Which employee experience would you like to check, enter id number from 1 to 8: ",
      );
      console.log(
        `${employees[empid - 1].name} has ${employees[empid - 1].exp} years of experience`,
      );
    }
    break;
  case 6:
    {
      const empid = prompt(
        "Which employee would you like to delete, enter id number from 1 to 8: ",
      );
      console.log(`${employees[empid - 1].name} has been deleted...`);
    }
    break;
  case 7:
    alert("Thank you for visiting");
    break;

  default:
    console.log("Please Pick between 1 & 8");
}
