import { Outlet } from "react-router-dom";
import DepartmentCard from "./DepartmentCard";

function Departments() {

    const departments = [
        {
            id: 1,
            name: "Cardiology",
            path: "cardiology",
            description:
                "Diagnosis and treatment of heart and cardiovascular conditions.",
            services: [
                "ECG",
                "Echocardiogram",
                "Cardiac Consultation"
            ]
        },
        {
            id: 2,
            name: "Neurology",
            path: "neurology",
            description:
                "Specialized care for disorders of the brain and nervous system.",
            services: [
                "EEG",
                "Neurological Consultation",
                "Migraine Treatment"
            ]
        },
        {
            id: 3,
            name: "Orthopedics",
            path: "orthopedics",
            description:
                "Treatment of bones, joints, muscles, and mobility conditions.",
            services: [
                "Fracture Treatment",
                "Joint Replacement",
                "Physiotherapy"
            ]
        },
        {
            id: 4,
            name: "Pediatrics",
            path: "pediatrics",
            description:
                "Healthcare for infants, children, and adolescents.",
            services: [
                "Child Wellness",
                "Vaccinations",
                "Growth Monitoring"
            ]
        }
    ];

    return (
        <section className="page">
            <h1>Our Departments</h1>
            <p className="page-description">Explore the medical departments available at our hospital.</p>

            <div className="department-grid">
                {departments.map((dept) => (
                    <DepartmentCard key={dept.id} dept={dept} />
                ))}
            </div>

            <Outlet />
        </section>
    );
}

export default Departments;