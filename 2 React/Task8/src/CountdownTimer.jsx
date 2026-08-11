import { useEffect, useState } from "react";
import "./CountdownTimer.css";

function CountdownTimer() {
    const [timer, setTimer] = useState(10);
    const [running, setRunning] = useState(false);

    useEffect(() => {
        if (!running) return;

        const intervalId = setInterval(() => {
            setTimer((prev) => {
                const next = prev - 1;
                // I am checking ahead, instead of checking current state before the render (or previous state after the render)
                if (next === 0) {
                    setRunning(false);
                    return 0;
                }

                return next;
            });
        }, 1000);

        return () => clearInterval(intervalId);
    }, [running]);

    function handleStart() {
        setRunning(true);
    }

    function handleReset() {
        setRunning(false);
        setTimer(10);
    }

    return (
        <div className="countdown">
            <h1>
                {timer > 0
                    ? `Time Remaining: ${timer}s`
                    : "Time's Up!"}
            </h1>

            <div className="buttons">
                <button onClick={handleStart} disabled={running || timer === 0}>
                    Start Timer
                </button>

                <button onClick={handleReset}>
                    Reset
                </button>
            </div>
        </div>
    );
}

export default CountdownTimer;