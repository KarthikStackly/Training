import { Link } from "react-router-dom";

function DoctorCard({ doc }) {

    return (
        <article className="doctor-card">
            <img src={doc.image} alt={`${doc.firstName} ${doc.lastName}`} />
            <h2>Dr. {doc.firstName} {doc.lastName}</h2>
            <p>{doc.email}</p>
            <Link to={`/doctors/${doc.id}`}>View Profile</Link>
        </article>
    );
}

export default DoctorCard;