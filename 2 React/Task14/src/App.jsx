import { useMemo } from "react";
import useCounter from "./useCounter";
import "./App.css";

function App() {
  const { count, increase, decrease } = useCounter();

  const square = useMemo(() => {
    return count * count;
  }, [count]);

  return (
    <div className="container">
      <h1>Counter</h1>

      <p>Count: {count}</p>
      <p>Square: {square}</p>

      <div className="buttons">
        <button onClick={decrease}>Decrease</button>
        <button onClick={increase}>Increase</button>
      </div>
    </div>
  );
}

export default App;