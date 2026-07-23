import "./RenderList.css";
import "./App.css";

function RenderList() {
  const agents = [
    {
      name: "Phoenix",
      age: "30",
      city: "London",
      mobileNumber: "123",
      email: "phx@val.com",
      occupation: "Duelist",
      address: "90, London, UK",
    },
    {
      name: "Jett",
      age: "27",
      city: "Seoul",
      mobileNumber: "3456",
      email: "jett@val.com",
      occupation: "Duelist",
      address: "55, Seoul, South Korea",
    },
    {
      name: "Harbor",
      age: "35",
      city: "Mumbai",
      mobileNumber: "567",
      email: "hrb@val.com",
      occupation: "Controller",
      address: "123, Mumbai, India",
    },
    {
      name: "Cypher",
      age: "30",
      city: "Rabat",
      mobileNumber: "789",
      email: "Cyph@val.com",
      occupation: "Sentinel",
      address: "23, Rabat, Morocco",
    },
    {
      name: "Fade",
      age: "25",
      city: "Istanbul",
      mobileNumber: "901",
      email: "fade@val.com",
      occupation: "Initiator",
      address: "23, Istanbul, Turkey",
    },
  ];

  return (
    <div className="card-container">
      {agents.map((agent, index) => {
        return (
          <div className="child-card" key={index}>
            <h2>{agent.name}</h2>

            <h3>Age</h3>
            <p>{agent.age}</p>

            <h3>City</h3>
            <p>{agent.city}</p>

            <h3>Email</h3>
            <p>{agent.email}</p>

            <h3>Occupation</h3>
            <p>{agent.occupation}</p>
          </div>
        );
      })}
    </div>
  );
}

export default RenderList;
