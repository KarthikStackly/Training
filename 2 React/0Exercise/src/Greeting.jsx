import Hellow from "./Hellow";

function Greeting(props) {
  const name = "Mallu";
  return (
    <div>
      <button
        style={{
          padding: "10px",
          backgroundColor: "limegreen",
          cursor: "pointer",
          fontWeight: "bold",
          fontFamily: "inherit",
        }}
      >
        Greeting Component for {name} {props.name}
      </button>
      <Hellow myName={props.name} />
    </div>
  );
}

export default Greeting;
