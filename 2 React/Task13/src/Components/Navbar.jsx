import { Link } from "react-router-dom"

function Navbar() {
    return (
        <div className="navbar">
            <Link to="/">Home</Link>
            <Link to="/products">Products</Link>
            <Link to="/contact">Contact</Link>
        </div>
    )
}

export default Navbar
