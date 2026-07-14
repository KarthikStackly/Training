let apiLink = "https://fakestoreapi.com/products/";
let producsts = [];
fetch(apiLink)
  .then((response) => {
    // console.log(response);
    return response.json();
  })
  .then((data) => {
    producsts = data;
    // console.log(data);
    // console.log(producsts);

    Display(producsts);
  });

/////////////////////////////////////////////////////////////////////////
// Task 1: Product Search (Easy)
// Requirement:
// Add a search input.
// Search by product title.
// Display matching products only.
// If no product is found, show "No Products Found".
// Skills:
// filter()
// includes()
// DOM Rendering

let api = document.querySelector(".api");
// api.innerHTML = `<input type = "text" id = "searchInp" placeholder = "Search Product..." />`;
// const search = "Laptops";
const search = document.getElementById("searchInp");

function Display(prods) {
  // console.log("Task1 args:", prods);
  api.innerHTML = "";
  if (prods.length === 0) {
    api.innerHTML = "<h2>No Products Found</h2>";
    return;
  }

  prods.forEach((el) => {
    api.innerHTML += `
    <div class="product">
    <h3>${el.title}</h3>

    <img
        src="${el.image}"
        data-id="${el.id}"
        class="productImg"
        height="80"
        style = "cursor: pointer;"
    >

    <p>$${el.price}</p>

    <button class="cartBtn" data-id="${el.id}">
    Add To Cart
    </button>

</div>
`;
  });
}

search.addEventListener("input", function () {
  const searchText = this.value.toLowerCase();

  const filteredProds = producsts.filter((product) =>
    product.title.toLowerCase().includes(searchText),
  );

  Display(filteredProds);
});

/////////////////////////////////////////////////////////////////////////
// Task 2: Category Filter (Medium)
// Requirement:
// Create category buttons:
// All
// Men's Clothing
// Women's Clothing
// Jewelery
// Electronics
// Clicking a button should display only that category.
// Skills:
// filter()
// Event Listeners
// Dynamic Rendering

const allBtn = document.getElementById("allBtn");
const mensBtn = document.getElementById("mensBtn");
const womensBtn = document.getElementById("womensBtn");
const jeweleryBtn = document.getElementById("jeweleryBtn");
const electronicsBtn = document.getElementById("electronicsBtn");

allBtn.addEventListener("click", function () {
  search.value = "";
  Display(producsts);
});

mensBtn.addEventListener("click", function () {
  search.value = "";

  const filteredProds = producsts.filter(
    (product) => product.category === "men's clothing",
  );
  Display(filteredProds);
});

womensBtn.addEventListener("click", function () {
  search.value = "";

  const filteredProds = producsts.filter(
    (product) => product.category === "women's clothing",
  );
  Display(filteredProds);
});

jeweleryBtn.addEventListener("click", function () {
  search.value = "";

  const filteredProds = producsts.filter(
    (product) => product.category === "jewelery",
  );
  Display(filteredProds);
});

electronicsBtn.addEventListener("click", function () {
  search.value = "";

  const filteredProds = producsts.filter(
    (product) => product.category === "electronics",
  );
  Display(filteredProds);
});

/////////////////////////////////////////////////////////////////////////
// Task 3: Price Sorting (Medium)
// Requirement:
// Add two buttons:
// Low → High
// High → Low
// Sort the products based on price without calling the API again.
// Skills:
// sort()
// Arrow Functions
// Array Copy ([...array])
let sortAscBtn = document.getElementById("sortAscBtn");
let sortDescBtn = document.getElementById("sortDescBtn");

sortAscBtn.addEventListener("click", function () {
  let prodCopy = [...producsts];
  const sortedProds = prodCopy.sort((a, b) => a.price - b.price);
  Display(sortedProds);
});
sortDescBtn.addEventListener("click", function () {
  let prodCopy = [...producsts];
  const sortedProds = prodCopy.sort((a, b) => b.price - a.price);
  Display(sortedProds);
});

/////////////////////////////////////////////////////////////////////////
// Task 4: Product Details Popup (Medium-Hard)
// Requirement:
// When the user clicks on a product image,
// Open a modal.
// Show:
// Full Image
// Title
// Full Description
// Price
// Rating
// Category
// Skills:
// Modal
// Event Delegation
// Dynamic DOM

const modal = document.getElementById("modal");
const closeModal = document.getElementById("closeModal");

api.addEventListener("click", function (e) {
  if (e.target.classList.contains("productImg")) {
    const id = Number(e.target.dataset.id);
    const product = producsts.find((p) => p.id === id);
    document.getElementById("modalImg").src = product.image;
    document.getElementById("modalTitle").textContent = product.title;
    document.getElementById("modalDesc").textContent = product.description;
    document.getElementById("modalCategory").textContent = product.category;
    document.getElementById("modalRating").textContent = product.rating.rate;
    document.getElementById("modalPrice").textContent = "$" + product.price;

    modal.style.display = "block";
  }
});

closeModal.addEventListener("click", function () {
  modal.style.display = "none";
});

/////////////////////////////////////////////////////////////////////////
// Task 5: Shopping Cart (Company-Level)
// Requirement:
// Add an Add to Cart button.
// Cart icon should display the item count.
// Clicking Add to Cart multiple times should increase the quantity instead of creating duplicate items.
// Display:
// Product Name
// Quantity
// Total Price
// Grand Total
// Skills:
// Arrays
// Objects
// find()
// findIndex()
// reduce()

let cart = [];

function Cart() {
  cartDiv.innerHTML = "";
  cartCount.textContent = cart.length;
  cart.forEach((item) => {
    cartDiv.innerHTML += `
      <div class="cart-item">
        <h3>${item.title}</h3>
        <p>Price: $${item.price}</p>
        <p>Quantity: ${item.qty}</p>
        <p>Total: $${(item.price * item.qty).toFixed(2)}</p>
        <hr>
      </div>
    `;
  });

  const grandTotal = cart.reduce((total, item) => {
    return total + item.price * item.qty;
  }, 0);

  cartDiv.innerHTML += `
    <h2>Grand Total: $${grandTotal.toFixed(2)}</h2>
  `;
}

const cartDiv = document.getElementById("cart");
const cartCount = document.getElementById("cartCount");

api.addEventListener("click", function (e) {
  if (!e.target.classList.contains("cartBtn")) return;

  const id = Number(e.target.dataset.id);
  const product = producsts.find((p) => p.id === id);
  const index = cart.findIndex((item) => item.id === id);

  if (index === -1) {
    cart.push({
      id: product.id,
      title: product.title,
      price: product.price,
      qty: 1,
    });
  } else {
    cart[index].qty++;
  }

  Cart();
});
