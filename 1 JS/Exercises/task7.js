// Based on your uploaded JavaScript code (Functions, Spread/Rest, Destructuring, Array Methods, String Methods), here are 5 real-time tasks for your team.

/////////////////////////////////////////////////////////////////////////
// Task 1: Employee Salary Dashboard
// Concepts: map(), filter(), reduce(), find()
// Scenario:
// A company has employee details.
// Requirements:
// Display all employee names using map().
// Show employees with salary greater than ₹50,000 using filter().
// Find the first employee whose salary is above ₹1,00,000 using find().
// Calculate the total salary expense using reduce().

const employees = [
  {
    id: 101,
    name: "Rahul",
    department: "HR",
    salary: 45000,
  },
  {
    id: 102,
    name: "Priya",
    department: "Finance",
    salary: 82000,
  },
  {
    id: 103,
    name: "Karan",
    department: "IT",
    salary: 120000,
  },
  {
    id: 104,
    name: "Sneha",
    department: "Marketing",
    salary: 67000,
  },
  {
    id: 105,
    name: "Amit",
    department: "Sales",
    salary: 38000,
  },
];

employees.map((e) => {
  console.log(e.name);
});

employees.filter((e) => {
  if (e.salary > 50000) console.log(e.salary);
});

employees.find((e) => {
  if (e.salary > 100000)
    console.log(`${e.name}'s salary is greater than 100000`);
});

console.log(
  employees.reduce((acc, e) => {
    return acc + e.salary;
  }, 0),
);

/////////////////////////////////////////////////////////////////////////
// Task 2: E-Commerce Cart Management
// Concepts: Spread Operator, Rest Operator
// Scenario:
// A customer adds products to their shopping cart.
// Requirements:
// Merge two product arrays using the spread operator.
// Add a new product while keeping the original array unchanged.
// Create a function checkout(...products) using the rest operator.
// Print total number of products received.

const electronics = ["Laptop", "Mouse", "Keyboard"];

const accessories = ["USB Cable", "Headphones", "Webcam"];

const cart = [...electronics, ...accessories];
console.log(cart);
console.log([...cart, "Charger"]);
function checkout(...products) {
  console.log(products);
}
checkout("puchuk", "chapak");

/////////////////////////////////////////////////////////////////////////
// Task 3: Student Report Card
// Concepts: Object Destructuring, Array Destructuring
// Scenario:
// A school stores student details.
// Requirements:
// Extract name, department, and marks using object destructuring.
// Extract the first three subject marks using array destructuring.
// Print:
// Student Name
// Department
// Total Marks
// Average Marks

const student = {
  id: 1,
  name: "Anjali",
  department: "Computer Science",
  marks: [85, 91, 78, 88, 95],
};
const { id, name, department, marks } = { ...student };
console.log("Name: ", name);
console.log("Department: ", department);
console.log(
  "Total Marks: ",
  marks.reduce((acc, el) => {
    return acc + el;
  }, 0),
);
console.log(
  "Average Marks: ",
  marks.reduce((acc, el) => {
    return acc + el;
  }, 0) / marks.length,
);

/////////////////////////////////////////////////////////////////////////
// Task 4: Product Search System
// Concepts: String Methods
// Scenario:
// Users search for products on an online shopping website.
// Requirements:
// Remove extra spaces using trim().
// Convert search text to lowercase.
// Check whether the product contains the search keyword using includes().
// Highlight the searched word using replace().
const products = [
  "Apple iPhone 16 ",
  "Samsung  Galaxy   S25    ",
  " OnePlus  14",
  "Sony    Headphones ",
  "  Apple Watch",
  " Dell  Laptop   ",
  "  HP Laptop",
];

const trimmedProducts = products.map((e) => e.trim());
console.log(trimmedProducts);
console.log(trimmedProducts.map((e) => e.toLowerCase()));
let search = "Apple iPhone 16";
if (trimmedProducts.includes(search))
  console.log("Found the search item ", search);
else console.log("Sorry, couldn't find ", search);

/////////////////////////////////////////////////////////////////////////
// Task 5: Movie Collection Manager
// Concepts: Array Methods
// Scenario:
// A movie streaming platform manages its movie list.
// Requirements:
// Add new movies using push().
// Remove the last movie using pop().
// Remove the first movie using shift().
// Add a featured movie at the beginning using unshift().
// Replace one movie using splice().
// Sort movie ratings in descending order.
// Check whether a movie exists using includes().
let movies = [
  "Interstellar",
  "Inception",
  "The Dark Knight",
  "Avengers: Endgame",
  "Joker",
];

let ratings = [8.7, 9.2, 8.4, 9.0, 8.8];
console.log(movies);
movies.push("Dunkirk");
movies.push("Oppenheimer");
movies.push("The Odessey");
console.log(movies);
movies.pop();
console.log(movies);
movies.shift();
console.log(movies);
movies.unshift("Memento");
console.log(movies);
movies.splice(3, 2, "The Odyssey");
console.log(movies);
console.log(
  "Movie Ratings in descending Order: ",
  ratings.sort((a, b) => {
    return b - a;
  }),
);
let search = "Oppenheimer";
if (movies.includes(search)) console.log("Found the movie: ", search);
else console.log("Sorry, couldn't find the movie: ", search);
