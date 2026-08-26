import { useParams, Link } from "react-router-dom";
import Loader from "./Loader";
import ErrorMessage from "./ErrorMessage";
import useFetch from "../useFetch";

function DoctorDetails() {
    const { id } = useParams();
    const { data: doctor, loading, error } = useFetch(`https://dummyjson.com/users/${id}`);

    if (loading) {
        return <Loader />;
    }

    if (error) {
        return <ErrorMessage message={error} />;
    }

    return (
        <section className="page doctor-profile">
            <img src={doctor.image} alt={`${doctor.firstName} ${doctor.lastName}`} />
            <div>
                <h1>Dr. {doctor.firstName} {doctor.lastName}</h1>
                <p><strong>Email:</strong>{doctor.email}</p>
                <p><strong>Phone:</strong>{doctor.phone}</p>
                <p><strong>Age:</strong>{doctor.age}</p>
                <p><strong>Gender:</strong>{doctor.gender}</p>
                <Link to="/doctors">Back to Doctors</Link>
            </div>
        </section>
    );
}

export default DoctorDetails;