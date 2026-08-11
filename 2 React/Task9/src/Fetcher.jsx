import { useEffect, useState } from "react";
import Loader from "./Loader";
import Error from "./Error";
import "./Fetcher.css";

function Fetcher() {
    const [data, setData] = useState([]);
    const [loading, setLoading] = useState(true);
    const [error, setError] = useState("");

    const api = "https://jsonplaceholder.typicode.com/users";

    useEffect(() => {
        fetch(api)
            .then((res) => {
                if (!res.ok) {
                    throw new Error("Failed to fetch users");
                }
                return res.json();
            })
            .then((data) => {
                setData(data);
            })
            .catch((err) => {
                setError(err.message);
                console.warn(err.message)
            })
            .finally(() => {
                setLoading(false);
            });
    }, []);

    if (loading) {
        return <Loader />;
    }

    if (error) {
        return <Error />;
    }

    return (
        <div className="users-container">
            <h1>Users</h1>

            <div className="users-list">
                {data.map((user) => (
                    <div className="user-card" key={user.id}>
                        <h2>{user.name}</h2>

                        <p>
                            <strong>Email:</strong> {user.email}
                        </p>

                        <p>
                            <strong>Phone:</strong> {user.phone}
                        </p>

                        <p>
                            <strong>City:</strong> {user.address.city}
                        </p>
                    </div>
                ))}
            </div>
        </div>
    );
}

export default Fetcher;