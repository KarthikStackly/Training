import { useReducer, useRef, useContext } from "react";

import HospitalContext from "../HospitalContext";

const initialState = {
    name: "",
    department: "",
    doctor: "",
    date: "",
    time: "",
    reason: "",
    submitted: false,
    errors: {}
};

function reducer(state, action) {
    switch (action.type) {

        case "CHANGE":
            return {
                ...state,
                [action.field]: action.value,
                errors: {
                    ...state.errors,
                    [action.field]: ""
                },
                submitted: false
            };

        case "ERROR":
            return {
                ...state,
                errors: action.errors,
                submitted: false
            };

        case "SUCCESS":
            return {
                ...state,
                submitted: true,
                errors: {}
            };

        case "RESET":
            return initialState;

        default:
            return state;
    }
}

function Appointments() {

    const [state, dispatch] = useReducer(reducer, initialState);
    const { setAppointments } = useContext(HospitalContext);
    const firstInputRef = useRef(null);

    const departments = [
        "Cardiology",
        "Neurology",
        "Orthopedics",
        "Pediatrics"
    ];

    const doctors = [
        "Dr. Ramya Shayana",
        "Dr. Naveen Patil",
        "Dr. Krish Adiga",
        "Dr. Indrajit Taj"
    ];

    function handleChange(e) {
        dispatch({
            type: "CHANGE",
            field: e.target.name,
            value: e.target.value
        });
    }

    function validateForm() {
        const errors = {};
        if (!state.name.trim()) {
            errors.name = "Please enter your name.";
        }

        if (!state.department) {
            errors.department =
                "Please select a department.";
        }

        if (!state.doctor) {
            errors.doctor =
                "Please select a doctor.";
        }

        if (!state.date) {
            errors.date =
                "Please select a date.";
        }

        if (!state.time) {
            errors.time =
                "Please select a time.";
        }

        if (!state.reason.trim()) {
            errors.reason =
                "Please enter the reason for your visit.";
        }

        return errors;
    }

    function handleSubmit(e) {

        e.preventDefault();
        const errors = validateForm();
        if (Object.keys(errors).length > 0) {
            dispatch({
                type: "ERROR",
                errors
            });
            firstInputRef.current.focus();
            return;
        }

        const appointment = {
            name: state.name,
            department: state.department,
            doctor: state.doctor,
            date: state.date,
            time: state.time,
            reason: state.reason
        };

        setAppointments((previous) => [...previous, appointment]);

        dispatch({
            type: "SUCCESS"
        });
    }

    return (
        <section className="page">
            <div className="appointment-container">
                <h1>Book an Appointment</h1>
                <p>Schedule an appointment with one of our healthcare professionals.</p>

                <form onSubmit={handleSubmit}>
                    <div className="form-group">
                        <label htmlFor="name">Your Name</label>

                        <input
                            ref={firstInputRef}
                            id="name"
                            name="name"
                            type="text"
                            value={state.name}
                            onChange={handleChange}
                            placeholder="Enter your name"
                        />

                        {state.errors.name && (
                            <span className="error">{state.errors.name}</span>
                        )}
                    </div>

                    <div className="form-group">
                        <label htmlFor="department">Department</label>
                        <select
                            id="department"
                            name="department"
                            value={state.department}
                            onChange={handleChange}
                        >
                            <option value="">Select Department</option>
                            {departments.map((department) => (
                                <option key={department} value={department}>{department}</option>
                            ))}
                        </select>
                        {state.errors.department && (
                            <span className="error">{state.errors.department}</span>
                        )}
                    </div>
                    <div className="form-group">
                        <label htmlFor="doctor">Doctor</label>

                        <select
                            id="doctor"
                            name="doctor"
                            value={state.doctor}
                            onChange={handleChange}
                        >
                            <option value="">Select Doctor</option>
                            {doctors.map((doctor) => (
                                <option key={doctor} value={doctor}>{doctor}</option>
                            ))}
                        </select>

                        {state.errors.doctor && (
                            <span className="error">{state.errors.doctor}</span>
                        )}
                    </div>
                    <div className="form-row">
                        <div className="form-group">
                            <label htmlFor="date">Date</label>
                            <input
                                id="date"
                                name="date"
                                type="date"
                                value={state.date}
                                onChange={handleChange}
                            />

                            {state.errors.date && (
                                <span className="error">{state.errors.date}</span>
                            )}
                        </div>

                        <div className="form-group">
                            <label htmlFor="time">Time</label>
                            <input
                                id="time"
                                name="time"
                                type="time"
                                value={state.time}
                                onChange={handleChange}
                            />

                            {state.errors.time && (
                                <span className="error">{state.errors.time}</span>
                            )}
                        </div>
                    </div>


                    <div className="form-group">
                        <label htmlFor="reason">Reason for Visit</label>

                        <textarea
                            id="reason"
                            name="reason"
                            value={state.reason}
                            onChange={handleChange}
                            rows="4"
                            placeholder="Briefly describe the reason for your visit"
                        />

                        {state.errors.reason && (
                            <span className="error">{state.errors.reason}</span>
                        )}
                    </div>

                    <button type="submit">
                        Book Appointment
                    </button>
                </form>


                {state.submitted && (
                    <div className="success-message">
                        <h3>Appointment Submitted</h3>
                        <p>Your appointment request has been submitted successfully.</p>
                        <p><strong>{state.department}</strong> - {state.doctor}</p>
                    </div>
                )}
            </div>
        </section>
    );
}

export default Appointments;