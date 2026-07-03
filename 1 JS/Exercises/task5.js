/////////////////////////////////////////////////////////////////////////
// 1. Employee Login (Scope)
// Create a function where:
// var companyName = "Stackly IT" should be accessible outside the if block.
// let employeeId and const password should only be accessible inside the block.
// Print all variables and identify which one throws an error.

function Stackly() {
  {
    var companyName = "Stackly IT";
    let employeeId = "STK123";
    const password = "puchuk67";
  }
  console.log(
    "let and const variables throw an error because they have block scope, while var can be accessed outside the scope, within the same function definition",
  );
  console.log(companyName);
  //   console.log(employeeId);
  //   console.log(password);
}
Stackly();

/////////////////////////////////////////////////////////////////////////
// 2. ATM Machine (Hoisting)
// Create a program where:
// Try printing accountBalance before declaring it with var.
// Try the same using let.
// Try the same using const.
// Explain the different outputs.

console.log(
  "var being of global scope, can be Hoisted, meaning it can be called before it is declared. Although the variable type is still undefined at this point.",
);
// console.log(bal1);
// console.log(bal2);
console.log(bal3);

const bal1 = 500;
let bal2 = 900;
var bal3 = 200;

/////////////////////////////////////////////////////////////////////////
// 3. Food Delivery App (Named Function)
// Create a named function:
// orderFood(foodName)
// When called:
// orderFood("Chicken Biryani")
// Output:
// Order Placed : Chicken Biryani
function orderFood(order) {
  console.log("Order Placed:", order);
}
orderFood("Chicken Biryani");

/////////////////////////////////////////////////////////////////////////
// 4. WhatsApp Status (Anonymous Function)
// Store an anonymous function inside a variable.
// Input:
// "Busy in Meeting"
// Output:
// Status Updated : Busy in Meeting

const x = function (inp) {
  return "Busy in Meeting";
};
console.log(x());

/////////////////////////////////////////////////////////////////////////
// 5. Weather App (Arrow Function)
// Create an arrow function that accepts:
// City
// Temperature
// Output:
// Chennai Temperature is 36°C
const y = (city, temp) => console.log(`${city} temperature is ${temp}°C`);
y("Chennai", 36);

/////////////////////////////////////////////////////////////////////////
// 6. Flipkart Offer (IIFE)
// Immediately display:
// Today's Offer
// Flat 60% Discount
// using an IIFE.
(function () {
  console.log("Today's Offer\nFLAT 60% Discount!");
})();

/////////////////////////////////////////////////////////////////////////
// 7. Online Payment (Higher Order + Callback)
// Create:
// makePayment()
// paymentSuccess()
// Requirement:
// After payment,
// Payment Processing...
// Payment Successful
function makePayment() {
  console.log("Payment Processing...");
  paymentSuccess();
}
function paymentSuccess() {
  console.log("Payment Successful");
}
makePayment();

/////////////////////////////////////////////////////////////////////////
// 8. YouTube Playlist (Generator Function)
// Create a generator that returns:
// Video 1
// Video 2
// Video 3
// Video 4
// After all videos are finished:
// Playlist Completed
function* Playlist() {
  yield "Video 1";
  yield "Video 2";
  yield "Video 3";
  yield "Video 4";
}

const play = Playlist();
let vid;
do {
  vid = play.next();

  if (!vid.done) console.log(vid.value);
  else console.log("Playist Completed");
} while (!vid.done);

/////////////////////////////////////////////////////////////////////////
// 9. Student Result (Return)
// Create a function:
// calculateTotal()
// Return the total marks.
// Store it in a variable and print:
// Total Marks : 485
function calculateTotal(total) {
  return total;
}
const tot = calculateTotal(485);
console.log("Total Marks:", tot);

/////////////////////////////////////////////////////////////////////////
// 10. Shopping Cart (Return)
// Create:
// cartTotal(price1, price2, price3)
// Return:
// Total Amount
function cartTotal(price1, price2, price3) {
  return price1 + price2 + price3;
}
const cartot = cartTotal(299, 499, 999);
console.log("Total Amount:", cartot);

/////////////////////////////////////////////////////////////////////////
// 11. Salary Calculator (Uncurrying)
// Create:
// salary(basic, hra, bonus)
// Output:
// Total Salary : 58000
function Salary(basic, hra, bonus) {
  console.log("Total Salary:", basic + hra + bonus);
}
Salary(40000, 8000, 10000);

/////////////////////////////////////////////////////////////////////////
// 12. Food Bill (Currying)
// Convert this:
// foodBill(food, drinks, dessert)
// into a curried function.
// Call like:
// foodBill(200)(100)(80)
// Output:
// 380
function foodBill(food) {
  return function (drinks) {
    return function (dessert) {
      return food + drinks + dessert;
    };
  };
}
console.log(foodBill(200)(100)(80));

/////////////////////////////////////////////////////////////////////////
// 13. E-commerce Coupon Generator
// Using a generator function, return coupons one by one:
// WELCOME10
// SAVE20
// SUPER30
// MEGA50
// After all coupons:
// No More Coupons
function* ECCouponGen() {
  yield "WELCOME10";
  yield "SAVE20";
  yield "SUPER30";
  yield "MEGA50";
}

const coupon = ECCouponGen();
let curCoupon;

do {
  curCoupon = coupon.next();

  if (!curCoupon.done) console.log(curCoupon.value);
  else console.log("No More Coupons");
} while (!curCoupon.done);

/////////////////////////////////////////////////////////////////////////
// 14. Bank Transaction (Higher Order + Callback)
// Create:
// withdraw(callback)
// Callback should print:
// Transaction Successful
// Expected Output:
// Processing...
// Transaction Successful
function withdraw() {
  console.log("Processing...");
  callback();
}
function callback() {
  console.log("Transaction Successful");
}
withdraw();

/////////////////////////////////////////////////////////////////////////
// 15. Employee Profile (Scope)
// Inside a function:
// if(true){
//    var company = "Stackly";
//    let designation = "MERN Developer";
//    const salary = 50000;
// }
// Task:
// Print company.
// Try printing designation.
// Try printing salary.
// Explain why some variables work and others don't.
// These tasks are strictly based on the concepts present in your uploaded code and are designed as real-world interview-style practice without introducing new JavaScript topics.

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
