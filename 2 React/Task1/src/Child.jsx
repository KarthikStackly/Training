import "./Child.css";

function Child({ agent }) {
  return (
    <div className="child-card">
      <h2>{agent.name}</h2>

      <h3>Age</h3>
      <p>{agent.age}</p>

      <h3>City</h3>
      <p>{agent.city}</p>

      <h3>Mobile Number</h3>
      <p>{agent.mobileNumber}</p>

      <h3>Email</h3>
      <p>{agent.email}</p>

      <h3>Occupation</h3>
      <p>{agent.occupation}</p>

      <h3>Address</h3>
      <p>{agent.address}</p>
    </div>
  );
}

export default Child;
