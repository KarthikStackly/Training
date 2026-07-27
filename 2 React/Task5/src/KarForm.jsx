import { useState } from "react";
import "./KarForm.css";

function KarForm() {
  const initialState = {
    firstName: "",
    lastName: "",
    email: "",
    mobile: "",
    password: "",
    confirmPassword: "",
    dob: "",
    gender: "",
    address: "",
    city: "",
    acceptedTerms: false,
  };
  const [formData, setFormData] = useState(initialState);
  const [error, setError] = useState("");

  function handleChange(e) {
    setError("");
    setFormData({
      ...formData,
      [e.target.name]:
        e.target.type === "checkbox" ? e.target.checked : e.target.value,
    });
  }

  function handleSubmit(e) {
    e.preventDefault();

    if (!formData.firstName.trim()) {
      setError("First Name is required");
      return;
    }

    if (formData.firstName.length < 3) {
      setError("First Name must contain at least 3 characters");
      return;
    }

    if (!formData.email.includes("@")) {
      setError("Invalid email");
      return;
    }

    if (!/^\d{10}$/.test(formData.mobile)) {
      setError("Invalid mobile number");
      return;
    }

    if (formData.password.length < 8) {
      setError("Password should be at least 8 characters");
      return;
    }

    if (formData.password !== formData.confirmPassword) {
      setError("Passwords do not match");
      return;
    }

    if (!formData.acceptedTerms) {
      setError("Please accept T&C to proceed.");
      return;
    }

    setError("");
    console.log("Thank you for submitting details");
    console.log(formData);
  }

  return (
    <div className="form-container">
      <form className="kar-form" onSubmit={handleSubmit}>
        {error && <h4>{error}</h4>}
        <h2>First Name: </h2>
        <input
          type="text"
          name="firstName"
          value={formData.firstName}
          onChange={handleChange}
          placeholder="Enter your Name"
        />
        <h2>Last Name: </h2>
        <input
          type="text"
          name="lastName"
          value={formData.lastName}
          onChange={handleChange}
          placeholder="Enter your Last Name"
        />
        <h2>Email: </h2>
        <input
          type="email"
          name="email"
          value={formData.email}
          onChange={handleChange}
          placeholder="Enter your Email ID"
        />
        <h2>Mobile Number: </h2>
        <input
          type="tel"
          name="mobile"
          value={formData.mobile}
          onChange={handleChange}
          placeholder="Enter your Mobile Number"
        />
        <h2>Password: </h2>
        <input
          type="password"
          name="password"
          value={formData.password}
          onChange={handleChange}
          placeholder="Enter Password"
        />
        <h2>Confirm Password: </h2>
        <input
          type="password"
          name="confirmPassword"
          value={formData.confirmPassword}
          onChange={handleChange}
          placeholder="Confirm Password"
        />
        <h2>Date of Birth: </h2>
        <input
          type="date"
          name="dob"
          value={formData.dob}
          onChange={handleChange}
        />
        <h2>Gender: </h2>
        <input
          type="text"
          name="gender"
          value={formData.gender}
          onChange={handleChange}
          placeholder="Enter your Gender"
        />
        <h2>Address: </h2>
        <input
          type="text"
          name="address"
          value={formData.address}
          onChange={handleChange}
          placeholder="Enter your Address"
        />
        <h2>City: </h2>
        <input
          type="text"
          name="city"
          value={formData.city}
          onChange={handleChange}
          placeholder="Enter your City"
        />
        <span>Accept T&C: </span>
        <input
          type="checkbox"
          name="acceptedTerms"
          checked={formData.acceptedTerms}
          onChange={handleChange}
        />

        {error && <h4>{error}</h4>}

        <button type="submit">Submit</button>
      </form>
    </div>
  );
}

export default KarForm;
