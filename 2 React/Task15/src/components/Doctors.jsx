import DoctorCard from "./DoctorCard"
import { useEffect, useState } from "react"
import Loader from "./Loader"
import Error from "./Error"

function Doctors() {

    const [data, setData] = useState([]);
    const [loading, setLoading] = useState(true);
    const [error, setError] = useState("")

    const api = "https://dummyjson.com/users";

    useEffect(() => {
        fetch(api).then((res) => {
            if (!res.ok) {
                throw new Error("Failed to fetch users");
            }
            return res.json();
        })
            .then((data) => {
                console.log(data.users)
                setData(data.users);
            })
            .catch((err) => {
                setError(err.message)
            })
            .finally(() => {
                setLoading(false);
            });
    }, []);

    if (loading) return <Loader />;
    if (error) return <Error />

    return (
        <div>
            <h1>Our Doctors</h1>
            {data && (data.filter(c => c.id <= 2).map(doc => (<DoctorCard key={doc.id} doc={doc} />)))}
        </div>
    )
}

export default Doctors
