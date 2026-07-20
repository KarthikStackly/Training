import Greeting from "./Greeting";

function App() {
  const name1 = "Karthik";
  const name2 = "Sai";
  return (
    <div
      style={{
        fontFamily: "cursive",
        justifySelf: "center",
        margin: "200px auto",
        display: "flex",
        flexDirection: "column",
        gap: "50px",
      }}
    >
      <h1>App Component</h1>
      <Greeting name={name1} />
      <Greeting name={name2} />
    </div>
  );
}

export default App;
