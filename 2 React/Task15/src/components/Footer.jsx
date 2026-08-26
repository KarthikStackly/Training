import { useContext } from "react";
import HospitalContext from "../HospitalContext";

function Footer() {

    const { hospitalInfo } = useContext(HospitalContext);

    return (
        <footer>

            <h3>{hospitalInfo.name}</h3>

            <p>
                {hospitalInfo.address}
            </p>

            <p>
                {hospitalInfo.phone}
            </p>

            <p>
                {hospitalInfo.email}
            </p>

            <p>
                © 2026 MelonMusk Hospital
            </p>

        </footer>
    );
}

export default Footer;