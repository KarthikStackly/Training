////////////////////////////////////////////////////////////
// 🥉 Level 1 (Beginner)
// Task 1 - User Introduction
// Ask the user:
// Name
// Age
// Print:
// My name is Naveen
// I am 18 years old
// Use:
// prompt()
// console.log()

const userName = prompt("What is your Name?");
const userAge = prompt("What is your Age?");

console.log("My name is ", userName);
console.log(`I am ${userAge} years old`);

////////////////////////////////////////////////////////////
// Task 2 - Degree Confirmation
// Ask:
// Did you complete degree?
// using:
// confirm()
// If true:
// Degree Completed
// Else:
// Degree Not Completed
// Print in console.

const degreeFin = confirm("Did you complete your degree?");

if (degreeFin) {
  console.log("Degree Completed");
} else console.log("Degree Not Completed");

////////////////////////////////////////////////////////////
// Task 3 - Mobile Price
// Create variables:
// mobilePrice = 15000
// discount = 2000
// Find final price.
// Output:
// Final Price : 13000

const mobilePrice = 15000;
const discount = 2000;

console.log(`Final Price: ${mobilePrice - discount}`);

////////////////////////////////////////////////////////////
// 🥈 Level 2 (Intermediate)
// Task 4 - Age Eligibility
// Ask age using prompt.
// Check:
// 18 or above
// Output:
// Eligible for Vote
// otherwise:
// Not Eligible
// Use comparison operator.

const askAge = prompt("What is your age?");
if (askAge >= 18) {
  console.log("You are eligible to vote");
} else console.log("You are NOT eligible to vote");

////////////////////////////////////////////////////////////
// Task 5 - Shopping Cart
// Create array:
// let cart = [
//   "Rice",
//   "Milk",
//   "Sugar",
//   "Tea Powder"
// ]
// Print:
// First Product
// Last Product
// Total Products

let cart = ["Rice", "Milk", "Sugar", "Tea Powder"];
console.log(cart[0]);
console.log(cart[cart.length - 1]);
console.log(cart.length);

////////////////////////////////////////////////////////////
// Task 6 - Student Details
// Create object:
// let student = {
//     name : "Naveen",
//     age : 18,
//     course : "MERN"
// }
// Print:
// Student Name
// Student Course

let student = {
  name: "Naveen",
  age: 18,
  course: "MERN",
};
console.log("Student Name: ", student.name);
console.log("Student Course: ", student.course);

////////////////////////////////////////////////////////////
// 🥇 Level 3 (Real-Time Office Tasks)
// Task 7 - Employee Salary Calculator
// Create:
// salary = 25000
// bonus = 5000
// Find total salary.
// Output:
// Total Salary : 30000

const salary = 25000;
const bonus = 5000;
console.log(`Total Salary: ${salary + bonus}`);

////////////////////////////////////////////////////////////
// Task 8 - Website Login Check
// Create:
// let username = "admin"
// let password = "1234"
// Ask user through prompt.
// If both match:
// Login Successful
// Else:
// Invalid Credentials
// Use:
// &&

let username = "admin";
let password = "1234";
const userUsername = prompt("Enter username");
const userPassword = prompt("Enter Password");
if (username === userUsername && password === userPassword) {
  console.log("Login Successful");
} else console.log("Invalid Credentials");

////////////////////////////////////////////////////////////
// Task 9 - Food Delivery App
// Create:
// foodPrice = 350
// deliveryCharge = 50
// Calculate:
// Total Bill
// GST 5%
// Grand Total

const foodPrice = 350;
const deliveryCharge = 50;
const gst = 0.05;
let totalBill = foodPrice + deliveryCharge;

console.log(`Your Total Bill is: ${totalBill}`);
console.log(`Your Grand Total will be ${totalBill * gst + totalBill}`);

////////////////////////////////////////////////////////////
// 🏆 Level 4 (Company Interview Style)
// Task 10 - E-Commerce Product Details
// Create object:
// let product = {
//    name : "Laptop",
//    price : 50000,
//    brand : "ASUS",
//    stock : true
// }
// Print:
// Product Name
// Brand
// Price
// Stock Available

////////////////////////////////////////////////////////////
// Task 11 - Attendance System
// Ask:
// Present?
// using:
// confirm()
// Output:
// Attendance Marked
// or
// Absent

const attendance = confirm("Are you Present in the class?");

if (attendance) {
  console.log("Attendance Marked");
} else console.log("Absent");

////////////////////////////////////////////////////////////
// Task 12 - Banking Application
// Ask user:
// Current Balance
// Withdraw Amount
// Check:
// withdraw <= balance
// Output:
// Transaction Successful
// Remaining Balance : xxx
// otherwise:
// Insufficient Balance

const currentBalance = prompt("Please enter your Current Balance");
const withdrawAmount = prompt("Please enter the Withdrawal Amount");

if (withdrawAmount <= currentBalance) {
  console.log("Transaction Successful");
  console.log(`Remaining Balance: ${currentBalance - withdrawAmount}`);
} else console.log("Insufficient Balance");

////////////////////////////////////////////////////////////
// 🔥 Challenge Task (Mix Everything)
// Build a Mini Employee Management System
// Store in object:
// {
//    name,
//    age,
//    department,
//    salary
// }
// Print:
// Employee Name
// Employee Age
// Department
// Annual Salary
// Then check:
// salary > 30000
// Output:
// Senior Employee
// or
// Junior Employee

let employee = {
  name: prompt("Name?"),
  age: prompt("Age?"),
  dept: prompt("Department?"),
  salary: prompt("Annual Salary?"),
};

// employee.name = prompt("Name?");
// employee.age = prompt("Age?");
// employee.dept = prompt("Department?");
// employee.salary = prompt("Annual Salary?");

if (employee.salary > 30000) {
  console.log(`${employee.name} is a Senior Employee`);
} else console.log(`${employee.name} is a Junior Employee`);
// console.log(employee.salary);
