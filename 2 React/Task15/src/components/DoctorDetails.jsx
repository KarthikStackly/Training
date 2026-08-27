import { useParams, Link } from "react-router-dom";
import Loader from "./Loader";
import ErrorMessage from "./ErrorMessage";
import useFetch from "../useFetch";

function DoctorDetails() {
    const { id } = useParams();
    const { data, loading, error } = useFetch("https://randomuser.me/api/?results=12&nat=in&seed=60f9679805a0dc1e");

    // console.log(data);
    const doctor = data?.find(
        (doc) => doc.login.uuid === id
    ) || [];
    // console.log(doctor)

    if (loading) {
        return <Loader />;
    }

    if (error) {
        return <ErrorMessage message={error} />;
    }

    if (!doctor) {
        return <p>Doctor not found.</p>;
    }

    return (
        <section className="page doctor-profile">
            {doctor && (
                <>
                    <img src={doctor.picture.large} alt={`${doctor.name.first} ${doctor.name.last}`} />
                    <div>
                        <h1>Dr. {doctor.name.first} {doctor.name.last}</h1>
                        <p><strong>Email: </strong>{doctor.email}</p>
                        <p><strong>Phone: </strong>{doctor.phone}</p>
                        <p><strong>Age: </strong>{doctor.dob.age}</p>
                        <p><strong>Gender: </strong>{doctor.gender}</p>
                        <Link to="/doctors">Back to Doctors</Link>

                    </div>
                </>
            )}
        </section>
    );
}

export default DoctorDetails;