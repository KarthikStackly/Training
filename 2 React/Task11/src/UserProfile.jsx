import { useContext, useEffect, useRef, useState } from "react";
import { UserContext } from "./App";
import "./UserProfile.css"

function UserProfile() {
    const [name, setName] = useState("");
    const [email, setEmail] = useState("");
    const [submittedUser, setSubmittedUser] = useState(null);

    const nameFocus = useRef(null);
    const message = useContext(UserContext);

    function handleClick() {
        setSubmittedUser({
            name,
            email
        });
    }

    useEffect(() => {
        console.log("Welcome User");
        nameFocus.current.focus();
    }, []);

    return (
        <div className="profile-card">
            <h1>{message}</h1>

            <input
                ref={nameFocus}
                name="name"
                type="text"
                value={name}
                onChange={(e) => setName(e.target.value)}
                placeholder="Please enter your name"
            />

            <input
                name="email"
                type="email"
                value={email}
                onChange={(e) => setEmail(e.target.value)}
                placeholder="Please enter your email"
            />

            <button onClick={handleClick}>
                Submit
            </button>

            {submittedUser && (
                <div className="submitted-user">
                    <h2>Profile Details</h2>
                    <p>
                        <strong>Name:</strong> {submittedUser.name}
                    </p>
                    <p>
                        <strong>Email:</strong> {submittedUser.email}
                    </p>
                </div>
            )}
        </div>
    );
}

export default UserProfile;