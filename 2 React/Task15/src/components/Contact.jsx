import { useContext } from "react";
import HospitalContext from "../HospitalContext";

function Contact() {

    const { hospitalInfo } = useContext(HospitalContext);
    return (
        <section className="page">
            <h1>Contact Us</h1>
            <div className="contact-card">
                <h2>{hospitalInfo.name}</h2>
                <p><strong>Address:</strong> {hospitalInfo.address}</p>
                <p><strong>Phone:</strong>{hospitalInfo.phone}</p>
                <p><strong>Email:</strong>{hospitalInfo.email}</p>
                <h3>Opening Hours</h3>
                <p>Monday - Saturday: 8:00 AM - 8:00 PM</p>
                <p>Sunday: 9:00 AM - 2:00 PM</p>
            </div>
        </section>
    );
}

export default Contact;