import { Link, Outlet } from "react-router-dom"

function Departments() {
    return (
        <div>
            <h1>Departments</h1>
            <Link to="cardiology">Cardiology</Link>
            <Link to="neurology">Neurology</Link>
            <Link to="orthopedics">Orthopedics</Link>
            <Link to="pediatrics">Pediatrics</Link>

            <Outlet />
        </div>
    )
}

export default Departments
