// Task 1 - Employee Name
// Ask the employee for their name using prompt().
const employeeName = prompt("Enter Employee's Name.");
// Print the employee name in the console.
console.log("Employee's Name: ", employeeName);
// Display "Welcome <Employee Name>" on the webpage using document.writeln().
document.writeln("Welcome ", employeeName);

// Task 2 - Company Entry Confirmation
// Show a confirm box:
// "Are you ready to join today's JavaScript training?"
const ready = confirm("Are you ready to join today's JavaScript training?");
// Print the user's answer (true/false) in the console.
console.log("Ready or Not: ", ready);

// Task 3 - Customer Greeting
// Show an alert saying:
// "Welcome to Stackly Solutions!"
alert("welcome to Stackly Solutions!");
// Then print "Customer entered the website." in the console.
console.log("Customer entered the website.");

// Task 4 - Student Details
// Ask the student for:
// 1. Name
// 2. Age
// Print both values in the console.
const studentName = prompt("Enter Student's Name");
console.log("Student's Name is: ", studentName);
const studentAge = prompt("Enter Student's Age.");
console.log("Student's Age is: ", studentAge);

// Task 5 - Product Price
// Create a variable using let to store a product price.
let productPrice;
// Update the price with a new value.
productPrice = 499;
// Print the updated price using console.log().
console.log("Product Price", productPrice);

// Task 6 - Login Validation
// Ask the user to enter their username.
const username = prompt("Enter username.");
// If the username is empty,
// show a warning using console.warn().
if (username === "") console.warn("Warning: Username is empty.");
// Otherwise print:
// "Login Successful: <username>"
else console.log("Login Successful: ", username);

/*
Example Output:

Login Successful: Naveen
OR

Warning: Username is empty.
*/

// Task 7 - Website Maintenance
// Display an alert:
// "Website is under maintenance."
alert("Website is under maintenance.");
// After that print an error message in the console using console.error().
console.error("Website is currently unavailable.");

// Expected:
// Error: Website is currently unavailable.

// Task 8 - Feedback Collection
// Ask the user:
// "How was today's JavaScript session?"
const q1 = prompt("How was today's JavaScript session?");
// Print the feedback in the console.
console.log(q1);
// Display:
// "Thank you for your feedback!"
// on the webpage.
document.writeln("\n");
document.writeln("Thank you for your feedback!");

// Task 9 - Profile Information
// Ask the user for:
// Name
// City
// Favorite Programming Language
// Print all three values in the console.
const usersName = prompt("What is your Name?");
console.log("Name: ", usersName);
const usersCity = prompt("Which city are you from?");
console.log("City: ", usersCity);
const usersLang = prompt("What is your favourite programming language?");
console.log("Favourite Programming Language: ", usersLang);

// Task 10 - Mini Registration Form
// Ask the user for:
// Full Name
// Email
// Mobile Number

const fullName = prompt("Enter Your Full Name");
const email = prompt("Enter Your Email");
const mobileNumber = prompt("Enter Your Mobile Number");

//
// Print all details in the console like:
//
// ===== Registration Details =====
// Name   :
// Email  :
// Mobile :

console.log("===== Registration Details =====");
console.log("Name   :", fullName);
console.log("Email   :", email);
console.log("Mobile   :", mobileNumber);
//
// Finally show:
// alert("Registration Successful!");
alert("Registration Successful");
