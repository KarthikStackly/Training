/////////////////////////////////////////////////////////////////////////
// Task 1: Employee Age Calculator
// Scenario:
// An HR portal stores employees' Date of Birth. Display their current age.
// Requirements:
// Create a DOB using new Date()
// Use getFullYear()
// Calculate current age
// Print:
// Employee Age: 24 Years
const dob = new Date("01-Sep-1994 18:27:36");
console.log("Birthday:", dob);
const today = new Date();
console.log("Employee age:", today.getFullYear() - dob.getFullYear(), "years");

/////////////////////////////////////////////////////////////////////////
// Task 2: Online Appointment Scheduler
// Scenario:
// A hospital wants to reschedule an appointment.
// Requirements:
// Create today's date.
// Change the appointment to:
// Year → 2027
// Month → December
// Date → 15
// Time → 10:30 AM
// Print the updated appointment.
// Methods to use
// setFullYear()
// setMonth()
// setDate()
// setHours()
// setMinutes()
console.log("Today is ", today.toLocaleDateString());
const appointment = new Date();
appointment.setFullYear(2027);
appointment.setMonth(11);
appointment.setDate(15);
appointment.setHours(10);
appointment.setMinutes(30);
appointment.setSeconds(0);

console.log("Your appointment has been moved to", appointment.toLocaleString());

/////////////////////////////////////////////////////////////////////////
// Task 3: Multi-Country Meeting Time
// Scenario:
// Your company has meetings with India, USA, and Japan.
// Requirements:
// Display the current time in:
// India
// New York
// Tokyo
// Use:
// toLocaleString()
// timeZone:
// "Asia/Kolkata"
// "America/New_York"
// "Asia/Tokyo"

const curTime = new Date();
console.log(
  "India:",
  curTime.toLocaleString("en-IN", {
    timeZone: "Asia/Kolkata",
  }),
);

console.log(
  "New York:",
  curTime.toLocaleString("en-IN", {
    timeZone: "America/New_York",
  }),
);

console.log(
  "Tokyo:",
  curTime.toLocaleString("en-IN", {
    timeZone: "Asia/Tokyo",
  }),
);

/////////////////////////////////////////////////////////////////////////
// Task 4: Product Warranty Expiry
// Scenario:
// A customer purchased a laptop today. Warranty is valid for 2 years.
// Requirements:
// Get today's date.
// Add 2 years using:
// setFullYear()
// Print:
// Purchase Date :
// Warranty Expiry :

const purchaseDate = new Date();
console.log("Purchase Date:", purchaseDate.toLocaleString());
const warrantyExpire = new Date();
warrantyExpire.setFullYear(purchaseDate.getFullYear() + 2);
console.log("Warranty Expiry:", warrantyExpire.toLocaleString());

/////////////////////////////////////////////////////////////////////////
// Task 5: Digital Clock
// Scenario:
// Create a live digital clock for a website.
// Requirements:
// Use:
// new Date()
// toLocaleTimeString()
// setInterval()
// Update every second.
// Expected Output
// 10:45:01 AM
// 10:45:02 AM
// 10:45:03 AM
// ...

const liveClock = setInterval(() => {
  console.log(new Date().toLocaleTimeString());
}, 1000);

setTimeout(() => {
  clearInterval(liveClock);
  console.log("5 seconds is enough right?");
}, 5000);
