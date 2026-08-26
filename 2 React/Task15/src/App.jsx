import { BrowserRouter, Routes, Route } from "react-router-dom";
import { useState } from "react";
import Navbar from "./components/Navbar";
import Footer from "./components/Footer";
import Home from "./components/Home";
import About from "./components/About";
import Doctors from "./components/Doctors";
import DoctorDetails from "./components/DoctorDetails";
import Departments from "./components/Departments";
import Cardiology from "./components/Cardiology";
import Neurology from "./components/Neurology";
import Orthopedics from "./components/Orthopedics";
import Pediatrics from "./components/Pediatrics";
import Appointments from "./components/Appointments";
import Contact from "./components/Contact";
import NotFound from "./components/NotFound";
import HospitalContext from "./HospitalContext";

function App() {

  const [appointments, setAppointments] = useState([]);

  const hospitalInfo = {
    name: "MelonMusk Hospital",
    phone: "+91 98765 43210",
    email: "info@MelonMusk.com",
    address: "Hyderabad, Telangana"
  };

  return (
    <HospitalContext.Provider value={{ hospitalInfo, appointments, setAppointments }}>

      <BrowserRouter>
        <Navbar />

        <main>
          <Routes>
            <Route path="/" element={<Home />} />
            <Route path="/about" element={<About />} />
            <Route path="/doctors" element={<Doctors />} />
            <Route path="/doctors/:id" element={<DoctorDetails />} />
            <Route path="/departments" element={<Departments />}>
              <Route path="cardiology" element={<Cardiology />} />
              <Route path="neurology" element={<Neurology />} />
              <Route path="orthopedics" element={<Orthopedics />} />
              <Route path="pediatrics" element={<Pediatrics />} />
            </Route>
            <Route path="/appointments" element={<Appointments />} />
            <Route path="/contact" element={<Contact />} />
            <Route path="*" element={<NotFound />} />
          </Routes>
        </main>
        <Footer />
      </BrowserRouter>
    </HospitalContext.Provider>
  );
}

export default App;