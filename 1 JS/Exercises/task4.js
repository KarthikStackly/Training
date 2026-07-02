// Based on the topics in your uploaded file (Functions, Scope, Hoisting, Generator, Callback, Higher Order Function, Currying, Return, etc.), here are real-time beginner-friendly tasks. They start easy and gradually become more challenging.

/////////////////////////////////////////////////////////////////////////
// 🟢 Task 1 - Company Welcome Function
// Create a function that prints:
// Welcome to Stackly IT
function printStackly() {
  console.log("Welcome to Stackly IT");
}

/////////////////////////////////////////////////////////////////////////
// 🟢 Task 2 - Employee Details
// Create a function that accepts:
// Name
// Department
// Salary
// Print:
// Employee Name : Naveen
// Department : Developer
// Salary : 30000

function EmpDeets(name, dept, salary) {
  console.log(`Employee Name: ${name}\nDepartment: ${dept}\nSalary: ${salary}`);
}
EmpDeets("Karthik", "IT", 40000);

/////////////////////////////////////////////////////////////////////////
// 🟢 Task 3 - Calculate Bonus
// Create a function that accepts:
// Salary = 40000
// Bonus = 5000
// Print:
// Total Salary : 45000
function CalcBonus(salary, bonus) {
  console.log("Total Salary: ", salary + bonus);
}

CalcBonus(40000, 5000);

/////////////////////////////////////////////////////////////////////////
// 🟢 Task 4 - Student Result
// Create a function that accepts marks.
// Rules:
// Marks ≥ 35 → Pass
// Otherwise → Fail
// Example:
// Input : 45
// Output : Pass
function PassFail(marks) {
  if (marks >= 35) console.log("Pass");
  else console.log("Fail");
}
PassFail(35);

/////////////////////////////////////////////////////////////////////////
// 🟢 Task 5 - Return Employee Name
// Create a function that returns
// "Naveen"
// Store it in another variable and print it.
const x = (function () {
  return "Naveen";
})();

console.log(x);

/////////////////////////////////////////////////////////////////////////
// 🟢 Task 6 - Product Price
// Create a function.
// Return
// 25000
// Store it in a variable and calculate
// Price + GST
function ProdPrice() {
  return 25000;
}

const price = ProdPrice();
console.log(price);

/////////////////////////////////////////////////////////////////////////
// 🟢 Task 7 - Scope
// Predict the output.
// function demo(){

//     if(true){

//         var a = 10;
//         let b = 20;
//         const c = 30;

//     }

//     console.log(a);

// }
// Question
// Which variable prints?
// Which variables give an error?
// Why?

function demo() {
  if (true) {
    var a = 10;
    let b = 20;
    const c = 30;
  }

  console.log(a);
}

console.log("Nothing prints. The function is not called.");

/////////////////////////////////////////////////////////////////////////
// 🟢 Task 8 - Hoisting
// Predict the output.
// console.log(a);

// var a = 100;
// Now check
// console.log(b);

// let b = 200;
// Explain the difference.

console.log(
  "The difference is that a is defined using var, which has a global scope. It can be Hoisted, meaning it can be called before it has been declared or defined. Hence the output shows undefined. Meanwhile b is defined using let, which has block scope and cannot be Hoisted. Hence the error.",
);
console.log(a);
var a = 100;
// console.log(b);
let b = 200;

/////////////////////////////////////////////////////////////////////////
// 🟢 Task 9 - Named Function
// Create a named function that prints
// Good Morning

function Wish() {
  console.log("Good Morning");
}
Wish();

/////////////////////////////////////////////////////////////////////////
// 🟢 Task 10 - Anonymous Function
// Store an anonymous function inside a variable.
// Print
// Welcome Employee

const y = function () {
  console.log("Welcome Employee");
};
y();

/////////////////////////////////////////////////////////////////////////
// 🟢 Task 11 - Arrow Function
// Create an arrow function that prints
// JavaScript Training

const z = () => console.log("JavaScript Training");
z();

/////////////////////////////////////////////////////////////////////////
// 🟢 Task 12 - Return Function
// Create a function.
// Return
// "Stackly"
// Store it in another variable.
// Print
// Welcome Stackly
function Stackly() {
  return "Stackly";
}
const s = Stackly();
console.log("Welcome ", s);

/////////////////////////////////////////////////////////////////////////
// 🟢 Task 13 - Higher Order Function
// Create two functions.
// Function 1
// Login Successful
// Function 2
// Dashboard Loaded
// Call Function 2 through Function 1.
// Expected Output
// Login Successful
// Dashboard Loaded
function func1() {
  console.log("Login Successsful");
  func2();
}

function func2() {
  console.log("Dashboard Loaded");
}

func1();

/////////////////////////////////////////////////////////////////////////
// 🟢 Task 14 - Callback Function
// Real-time Scenario
// Order Received

// Preparing Food

// Delivered
// Create three functions.
// Call them using callback style.

function Order() {
  console.log("Order Received");
  Prep();
}

function Prep() {
  console.log("Preparing Food");
  Deliver();
}

function Deliver() {
  console.log("Delivered");
}

Order();

/////////////////////////////////////////////////////////////////////////
// 🟢 Task 15 - Generator Function
// Create a coupon system.
// Coupons
// 10% Discount
// 20% Discount
// 30% Discount
// Better Luck Next Time
// Every
// next()
// should return the next coupon.
function* Coupons() {
  yield "10% Discount";
  yield "20% Discount";
  yield "30% Discount";
  yield "Better Luck Next Time";
}

/*
let coupons = Coupons();
// for (discount of Coupons()) {
for (discount of coupons) {
  console.log(discount);
}*/

const coupon = Coupons();

let result;

do {
  result = coupon.next();

  // if (!result.done) {
  if (!result.done && result.value !== "Better Luck Next Time") {
    console.log(result.value);
  }
} while (!result.done);

/////////////////////////////////////////////////////////////////////////
// 🟢 Task 16 - Return + Generator
// Create a generator that returns
// Apple

// Orange

// Banana
// Print each value using
// next()
function* Fruit() {
  yield "Apple";
  yield "Orange";
  yield "Banana";
}

const fruit = Fruit();
console.log(fruit.next().value);
console.log(fruit.next().value);
console.log(fruit.next().value);

/////////////////////////////////////////////////////////////////////////
// 🟢 Task 17 - Currying
// Create
// discount(1000)(10)
// Output
// Final Price : 900
function discount(price) {
  return function (discount) {
    console.log(`Final Price: ${price - (price * discount) / 100}`);
  };
}
discount(1000)(10);

/////////////////////////////////////////////////////////////////////////
// 🟢 Task 18 - Company Salary
// Create
// salary(30000)(5000)(2000)
// Meaning
// Salary

// Bonus

// Allowance
// Output
// 37000

function salary(sal) {
  return function (bonus) {
    return function (allowance) {
      console.log(sal + bonus + allowance);
    };
  };
}
salary(30000)(5000)(2000);

/////////////////////////////////////////////////////////////////////////
// 🟢 Task 19 - Real-Time Login System
// Create functions for
// Enter Username

// ↓

// Verify Password

// ↓

// Login Successful

// ↓

// Load Dashboard
// Use function calling to simulate the process.

function enterUsername() {
  console.log("Enter Username");
  verifyPassword();
}

function verifyPassword() {
  console.log("Verify Password");
  loginSuccessful();
}

function loginSuccessful() {
  console.log("Login Successful");
  loadDashboard();
}

function loadDashboard() {
  console.log("Load Dashboard");
}

enterUsername();

/////////////////////////////////////////////////////////////////////////
// ⭐ Mini Project (Based on Your Syllabus)
// Employee Salary Management System
// Create a console-based program that includes:
// Display employee details.
// Calculate salary + bonus using a function.
// Return the final salary.
// Use an arrow function to print a welcome message.
// Use an anonymous function to print the department.
// Use a higher-order function to simulate login.
// Use a callback function to load the employee dashboard.
// Generate monthly bonus coupons using a generator function.
// Apply tax calculation using currying.
// Print the final employee report.

const employees = {
  name: "Karthik",
  sal: 40000,
  dept: "IT",
  bonus: 5000,
};

function DisplayDetails(obj) {
  console.log(`Name: ${obj.name}\nDepartment: ${obj.dept}\nSalary: ${obj.sal}`);
}
DisplayDetails(employees);

function CalcBonus(obj) {
  return obj.sal + obj.bonus;
}
const calcBonus = CalcBonus(employees);
console.log("Bonus:", calcBonus);

const k = (obj) => console.log("Welcome!", obj.name);
k(employees);

const printDept = function (obj) {
  return obj.dept;
};
console.log("Department:", printDept(employees));

function Verify() {
  console.log("Verifying details, Please wait... ");
  Login();
}

function Login() {
  console.log("Logged in Successfully!");
  Dashboard();
}

function Dashboard() {
  console.log("=>Dashboard Loaded<=");
}
Verify();

function* BonusCoupons() {
  yield "5% Bonus Coupon!! Use before this month ends...";
  yield "20% Bonus Coupon!! Use before this month ends...";
  yield "40% Bonus Coupon!! Use before this month ends...";
}

const monthlyCoupon = BonusCoupons();
let res;

do {
  res = monthlyCoupon.next();

  if (!res.done && res.value !== "Better Luck Next Time") {
    console.log(res.value);
  }
} while (!res.done);

function tax(rate) {
  return function (salary) {
    return salary - (salary * rate) / 100;
  };
}
const finalSalary = CalcBonus(employees);
const deductTax = tax(10);
const salaryAfterTax = deductTax(finalSalary);

console.log("\n----- Final Employee Report -----");
console.log("Employee:", employees.name);
console.log("Base Salary:", employees.sal);
console.log("Bonus:", employees.bonus);
console.log("Salary After Bonus:", finalSalary);
console.log("Salary After Tax:", salaryAfterTax);
