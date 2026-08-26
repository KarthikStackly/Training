import { useSearchParams } from "react-router-dom";
import DoctorCard from "./DoctorCard";
import Loader from "./Loader";
import ErrorMessage from "./ErrorMessage";
import useFetch from "../useFetch";

function Doctors() {

    const [searchParams, setSearchParams] =
        useSearchParams();

    const search = searchParams.get("search") || "";

    const { data, loading, error } = useFetch("https://dummyjson.com/users");

    if (loading) {
        return <Loader />;
    }

    if (error) {
        return <ErrorMessage message={error} />;
    }

    const doctors = data?.users || [];
    const filteredDoctors = doctors.filter((doctor) => {
        const fullName =
            `${doctor.firstName} ${doctor.lastName}`
                .toLowerCase();
        return fullName.includes(search.toLowerCase());
    });

    function handleSearch(e) {
        const value = e.target.value;
        if (value) {
            setSearchParams({ search: value });
        } else {
            setSearchParams({});
        }
    }

    return (
        <section className="page">
            <h1>Our Doctors</h1>
            <div className="search-box">
                <input type="text" placeholder="Search doctors..." value={search} onChange={handleSearch} />
            </div>
            <div className="doctor-grid">
                {filteredDoctors.map((doctor) => (
                    <DoctorCard key={doctor.id} doc={doctor} />
                ))}
            </div>

            {filteredDoctors.length === 0 && (<p>No doctors found.</p>)}
        </section>
    );
}

export default Doctors;