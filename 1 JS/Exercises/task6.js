/////////////////////////////////////////////////////////////////////////
// Task 1 - Employee Bonus (Spread Operator)
// let employee = {
//     name: "Naveen",
//     salary: 35000
// }
// Task
// Create another object using the spread operator and add
// bonus : 5000
// department : "Developer"
// Print the new object.

let employee = {
  name: "Naveen",
  salary: 45000,
};

let employeeNew = { ...employee, bonus: 5000, department: "Developer" };
console.log(employeeNew);

/////////////////////////////////////////////////////////////////////////
// Task 2 - Shopping Cart (Rest Operator)
// Create a function
// calculateBill(...)
// Accept any number of product prices.
// Print
// Total items
// Total price
// Example
// 10 20 30 40

// Output

// Items : 4
// Total : 100

function calculateBill(...price) {
  let total = 0;
  for (each of price) {
    total += each;
  }
  console.log("Total items: ", price.length);
  console.log("Total price: ", total);
}
calculateBill(20, 99, 129, 2);

/////////////////////////////////////////////////////////////////////////
// Task 3 - Student Details (Object Destructuring)
// let student = {
//     name:"Rahul",
//     age:22,
//     course:"MERN",
//     city:"Chennai"
// }
// Print
// Rahul
// 22
// MERN
// Chennai
// using destructuring only.
let student = {
  name: "Rahul",
  age: 22,
  course: "MERN",
  city: "Chennai",
};
let { name, age, course, city } = { ...student };

console.log(`${name}\n${age}\n${course}\n${city}`);

/////////////////////////////////////////////////////////////////////////
// Task 4 - Online Food Order
// let foods=[
// "Pizza",
// "Burger",
// "Fries"
// ]
// Add
// Coke
// Ice Cream
// using push().
// Remove Fries.
// Print final array.

let foods = ["Pizza", "Burger", "Fries"];
foods.pop();
foods.push("Coke");
foods.push("Ice Cream");
console.log(foods);

/////////////////////////////////////////////////////////////////////////
// Task 5 - Bank Transactions
// let transactions=[1000,2000,3000,4000]
// Remove first transaction.
// Add
// 500
// at beginning.
let transacions = [1000, 2000, 3000, 400];
transacions.shift();
transacions.unshift(500);
console.log(transacions);

/////////////////////////////////////////////////////////////////////////
// Task 6 - Company Departments
// let dept1=["HR","Sales"]
// let dept2=["Developer","Testing"]
// Merge them using
// concat()
let dept1 = ["HR", "Sales"];
let dept2 = ["Developer", "Testing"];
let dept3 = dept2.concat(dept1);
console.log(dept3);

/////////////////////////////////////////////////////////////////////////
// Task 7 - Product Search
// let products=[
// "Laptop",
// "Mouse",
// "Keyboard",
// "Monitor"
// ]
// Check whether
// Keyboard
// exists.
// Print
// Available
// or
// Not Available

let products = ["Laptop", "Mouse", "Monitor"];
if (products.includes("Keyboard")) console.log("Keyboard Available");
else console.log("Keyboard Not Available");

/////////////////////////////////////////////////////////////////////////
// Task 8 - User Login (Callback Function)
// Create
// login()
// dashboard()
// When login completes,
// dashboard should execute using callback.
// Output
// Login Success
// Dashboard Opened
function login() {
  console.log("Login Success");
  dashboard();
}
function dashboard() {
  console.log("Dashboard Opened");
}
login();

/////////////////////////////////////////////////////////////////////////
// Task 9 - Coupon Generator (Generator Function)
// Generate coupons
// WELCOME10
// SAVE20
// MEGA50
// FREE100
// Print each one using
// next()
function* Coupons() {
  yield "WELCOME10";
  yield "SAVE20";
  yield "MEGA50";
  yield "FREE100";
}
let coupon = Coupons();
console.log(coupon.next().value);
console.log(coupon.next().value);
console.log(coupon.next().value);
console.log(coupon.next().value);

/////////////////////////////////////////////////////////////////////////
// Task 10 - Course Registration (Currying)
// Create
// course("JavaScript")("Morning")("Batch-36")
// Output
// Course : JavaScript
// Batch : Morning
// Room : Batch-36
function Course(course) {
  console.log("Course :", course);
  return function (batch) {
    console.log("Batch :", batch);
    return function (room) {
      console.log("Room :", room);
    };
  };
}
Course("Javascript")("Morning")("Batch-36");

/////////////////////////////////////////////////////////////////////////
// Task 11 - Movie Collection
// let movies=[
// "Leo",
// "GOAT",
// "Dragon",
// "Retro",
// "Coolie"
// ]
// Use
// slice()
// Print only
// Dragon
// Retro

let movies = ["Leo", "GOAT", "Dragon", "Retro", "Coolie"];
console.log(movies.slice(2, 4));

/////////////////////////////////////////////////////////////////////////
// Task 12 - Employee IDs
// let ids=[101,102,103,104,105]
// Replace
// 103
// 104
// with
// 501
// 502
// using splice().
let ids = [101, 102, 103, 104, 105];
ids.fill(501, 2, 3);
ids.fill(502, 3, 4);
console.log(ids);

/////////////////////////////////////////////////////////////////////////
// Task 13 - Sort Product Prices
// let price=[
// 5000,
// 250,
// 700,
// 12000,
// 50
// ]
// Sort and print.
let price = [5000, 250, 700, 12000, 50];
console.log(price.sort((a, b) => a - b));

/////////////////////////////////////////////////////////////////////////
// Task 14 - Nested Categories
// let data=[
// "Electronics",
// [
// "Mobiles",
// [
// "Samsung",
// "Apple"
// ]
// ]
// ]
// Use destructuring.
// Print
// Electronics
// Mobiles
// Samsung
// Apple
let data = ["Electronics", ["Mobiles", ["Samsung", "Apple"]]];
console.log(...data.flat(Infinity));

/////////////////////////////////////////////////////////////////////////
// Task 15 - Company Team
// let developers=[
// "John",
// "David"
// ]

// let designers=[
// "Ram",
// "Kiran"
// ]
// Merge both arrays using spread operator.
let developers = ["John", "David"];
let designers = ["Ram", "Kiran"];
let combined = [...developers, ...designers];
console.log(combined);

/////////////////////////////////////////////////////////////////////////
// Task 16 - Return Function
// Create
// calculateSalary()
// Return
// salary + bonus
// Store the returned value in another variable and print it.
function calculateSalary(salary, bonus) {
  return salary + bonus;
}
const totalSal = calculateSalary(55000, 4000);
console.log("Total Salary:", totalSal);

/////////////////////////////////////////////////////////////////////////
// Task 17 - Scope Checking
// Inside an if block declare
// var
// let
// const
// Try accessing them outside.
// Explain
// Which works?
// Which gives an error?
function StacklyIT() {
  if (true) {
    var company = "Stackly";
    let designation = "MERN Developer";
    const salary = 50000;
  }

  console.log(company);
  //   console.log(designation);
  //   console.log(salary);
}
StacklyIT();

console.log(
  "let and const variables throw an error because they have block scope, while var can be accessed outside the scope, within the same function definition",
);

/////////////////////////////////////////////////////////////////////////
// Task 18 - Customer Orders
// let orders=[
// "Pizza",
// "Burger",
// "Pizza",
// "Sandwich",
// "Pizza"
// ]
// Find
// First index of Pizza
// Last index of Pizza
let orders = ["Pizza", "Burger", "Pizza", "Sandwich", "Pizza"];
console.log("First Pizza index: ", orders.indexOf("Pizza"));
console.log("Last Pizza index: ", orders.lastIndexOf("Pizza"));

/////////////////////////////////////////////////////////////////////////
// Task 19 - Flatten Product Categories
// let items=[
// 1,
// 2,
// [
// 3,
// 4,
// [
// 5,
// 6
// ]
// ]
// ]
// Convert into
// [1,2,3,4,5,6]
// using flat().
let items = [1, 2, [3, 4, [5, 6]]];
console.log(items.flat(Infinity));

/////////////////////////////////////////////////////////////////////////
// Task 20 - Mini Shopping Cart Challenge
// let cart=["Mouse","Keyboard"]
// Perform the following:
// Add "Monitor" using push().
// Add "Laptop" at the beginning.
// Remove "Keyboard" using splice().
// Check whether "Mouse" exists.
// Merge with
// let accessories=["Webcam","Speaker"]
// using the spread operator.
// Finally print the completed cart.
let cart = ["Mouse", "Keyboard"];
cart.pop();
cart.push("Monitor");
cart.push("Laptop");
console.log(cart.includes("Mouse"));
let accessories = ["Webcam", "Speaker"];
console.log([...cart, ...accessories]);
