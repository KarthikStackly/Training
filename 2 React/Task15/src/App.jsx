import { BrowserRouter, Routes, Route } from "react-router-dom";
import Home from "./components/Home";
import About from "./components/About";
import Contact from "./components/Contact";
import Doctors from "./components/Doctors";
import Departments from "./components/Departments";
import Cardiology from "./components/Cardiology";
import Neurology from "./components/Neurology";
import Orthopedics from "./components/Orthopedics";
import Pediatrics from "./components/Pediatrics";
import Appointments from "./components/Appointments";
import Navbar from "./components/Navbar";

function App() {
  return (
    <BrowserRouter>
      <Navbar />
      <Routes>
        <Route path="/" element={<Home />} />
        <Route path="/about" element={<About />} />
        <Route path="/doctors" element={<Doctors />} />
        <Route path="/contact" element={<Contact />} />
        <Route path="/departments" element={<Departments />}>
          <Route path="cardiology" element={<Cardiology />} />
          <Route path="neurology" element={<Neurology />} />
          <Route path="orthopedics" element={<Orthopedics />} />
          <Route path="pediatrics" element={<Pediatrics />} />
        </Route>
        <Route path="/appointments" element={<Appointments />} />
      </Routes>
    </BrowserRouter>
  )
}

export default App
