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
