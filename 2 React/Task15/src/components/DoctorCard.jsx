import { Link } from "react-router-dom";

function DoctorCard({ doc }) {

    return (
        <article className="doctor-card">
            <img src={doc.picture.medium} alt={`${doc.name.first} ${doc.name.last}`} />
            <h2>Dr. {doc.name.first} {doc.name.last}</h2>
            <p>{doc.email}</p>
            <Link to={`/doctors/${doc.login.uuid}`}>View Profile</Link>
        </article>
    );
}

export default DoctorCard;