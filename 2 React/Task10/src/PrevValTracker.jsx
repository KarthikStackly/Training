import { useRef, useState } from "react";
import "./PrevValTracker.css";

function PrevValTracker() {
    const [input, setInput] = useState(""); //only for input element to be a controlled input
    const [curNum, setCurNum] = useState("");
    const [prevNum, setPrevNum] = useState("");

    const prevRef = useRef("");

    function handleInput(e) {
        setInput(e.target.value);
    }

    function handleUpdate() {
        prevRef.current = curNum;

        setPrevNum(prevRef.current);

        setCurNum(input);
    }

    return (
        <div className="container">
            <h1>Current Value: {curNum}</h1>

            <h2>Previous Value: {prevNum}</h2>

            <input
                name="input"
                value={input}
                onChange={handleInput}
                type="number"
                placeholder="Enter a number"
            />

            <button onClick={handleUpdate}>
                Update
            </button>
        </div>
    );
}

export default PrevValTracker;