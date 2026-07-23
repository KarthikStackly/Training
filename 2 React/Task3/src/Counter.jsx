import { useState } from "react";

function Counter() {
  let [count, setCount] = useState(0);
  return (
    <div style={{ marginTop: "250px" }}>
      <h1 style={{ marginBottom: "50px", fontFamily: "cursive" }}>
        Count: {count}
      </h1>
      <button
        onClick={() => setCount(count + 1)}
        style={{
          margin: "10px",
          fontSize: "20px",
          cursor: "pointer",
          padding: "10px",
          borderRadius: "30px",
          backgroundColor: "white",
        }}
      >
        ➕
      </button>
      <button
        onClick={() => setCount(0)}
        style={{
          margin: "10px",
          fontSize: "20px",
          cursor: "pointer",
          padding: "10px",
          borderRadius: "30px",
          backgroundColor: "white",
        }}
      >
        🔄️
      </button>
      <button
        onClick={() => setCount(count - 1)}
        style={{
          margin: "10px",
          fontSize: "20px",
          cursor: "pointer",
          padding: "10px",
          borderRadius: "30px",
          backgroundColor: "white",
        }}
      >
        ➖
      </button>
    </div>
  );
}

export default Counter;
