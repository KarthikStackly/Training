import { BrowserRouter, Routes, Route } from "react-router-dom"
import Navbar from "./Components/Navbar";
import Home from "./Components/Home";
import Contact from "./Components/Contact";
import Products from "./Components/Products";
import Cars from "./Components/Cars";
import Bikes from "./Components/Bikes";
import Laptops from "./Components/Laptops";

import "./App.css"

function App() {
  return (
    <BrowserRouter>

      <Navbar />
      <Routes>
        <Route path="/" element={<Home />} />
        <Route path="/products" element={<Products />}>
          <Route path="cars" element={<Cars />} />
          <Route path="bikes" element={<Bikes />} />
          <Route path="laptops" element={<Laptops />} />
        </Route>
        <Route path="/contact" element={<Contact />} />
      </Routes>
    </BrowserRouter >
  )
}

export default App
