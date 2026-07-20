import Child from "./Child";
import "./App.css";

function App() {
  const agent1 = {
    name: "Phoenix",
    age: "30",
    city: "London",
    mobileNumber: "123",
    email: "phx@val.com",
    occupation: "Duelist",
    address: "90, London, UK",
  };
  const agent2 = {
    name: "Jett",
    age: "27",
    city: "Seoul",
    mobileNumber: "3456",
    email: "jett@val.com",
    occupation: "Duelist",
    address: "55, Seoul, South Korea",
  };
  const agent3 = {
    name: "Harbor",
    age: "35",
    city: "Mumbai",
    mobileNumber: "567",
    email: "hrb@val.com",
    occupation: "Controller",
    address: "123, Mumbai, India",
  };
  const agent4 = {
    name: "Cypher",
    age: "30",
    city: "Rabat",
    mobileNumber: "789",
    email: "Cyph@val.com",
    occupation: "Sentinel",
    address: "23, Rabat, Morocco",
  };
  const agent5 = {
    name: "Fade",
    age: "25",
    city: "Istanbul",
    mobileNumber: "901",
    email: "fade@val.com",
    occupation: "Initiator",
    address: "23, Istanbul, Turkey",
  };

  return (
    <div className="card-container">
      <Child agent={agent1} />
      <Child agent={agent3} />
      <Child agent={agent4} />
      <Child agent={agent5} />
      <Child agent={agent2} />
    </div>
  );
}

export default App;
