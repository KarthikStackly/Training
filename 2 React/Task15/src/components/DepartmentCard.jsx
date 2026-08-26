import { Link } from "react-router-dom";

function DepartmentCard({ dept }) {

    return (
        <article className="department-card">
            <h2>{dept.name}</h2>
            <p>{dept.description}</p>
            <h4>Services</h4>
            <ul>
                {dept.services.map((service) => (
                    <li key={service}>{service}</li>
                ))}
            </ul>

            <Link to={dept.path}>Explore Department</Link>
        </article>
    );
}

export default DepartmentCard;