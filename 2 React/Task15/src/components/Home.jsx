import { Link } from "react-router-dom";

function Home() {

    return (
        <section className="hero">
            <div className="hero-content">
                <h1>Quality Healthcare,
                    <br />
                    When You Need It
                </h1>

                <p>MelonMusk Hospital provides trusted medical care through experienced doctors and modern healthcare facilities.</p>

                <div className="hero-buttons">
                    <Link to="/appointments">Book Appointment</Link>
                    <Link to="/doctors">Meet Our Doctors</Link>
                </div>
            </div>
        </section>
    );
}

export default Home;