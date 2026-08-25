import { Link } from "react-router-dom";
function Navbar() {
    return (
        <nav>
            <Link to="/">Home</Link>
            <Link to="/about">About Us</Link>
            <Link to="/departments">Departments</Link>
            <Link to="/doctors">Doctors</Link>
            <Link to="/appointments">Appointments</Link>
            <Link to="/contact">Contact Us</Link>
        </nav>
    )
}

export default Navbar
