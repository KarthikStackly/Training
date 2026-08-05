import { useEffect, useState } from "react";

function Timer() {
  const [secs, setSecs] = useState(55);
  const [mins, setMins] = useState(59);
  const [hours, setHours] = useState(23);
  const [run, setRun] = useState(false);

  const [sec0, setSec0] = useState("0");
  const [min0, setMin0] = useState("0");
  const [hour0, setHour0] = useState("0");

  // Set up the effect
  useEffect(() => {
    //define the interval ID
    let intervalId;
    // Condition to control start or stop of timer
    if (run) {
      intervalId = setInterval(() => {
        secs > 9 ? setSec0("") : setSec0("0");
        mins > 9 ? setMin0("") : setMin0("0");
        hours > 9 ? setHour0("") : setHour0("0");

        if (secs > 59) {
          setMins((prev) => prev + 1);
          setSecs(0);
        } else if (mins > 59) {
          setHours((prev) => prev + 1);
          setMins(0);
          setSecs(0);
        } else if (hours > 23) {
          setHours(0);
          setMins(0);
          setSecs(0);
        } else setSecs((prev) => prev + 1);
      }, 1000);
    }

    return () => clearInterval(intervalId);
  }, [secs, mins, hours, run]);

  function handleStart() {
    setRun(true);
  }
  function handleStop() {
    setRun(false);
  }
  function handleReset() {
    setRun(false);
    setSecs(0);
    setMins(0);
    setHours(0);
  }

  return (
    <div>
      <h1>Timer</h1>
      <h3>{`${sec0}${hours}:${min0}${mins}:${hour0}${secs}`}</h3>
      <button onClick={handleStart}>Start</button>
      <button onClick={handleStop}>Stop</button>
      <button onClick={handleReset}>Reset</button>
    </div>
  );
}

export default Timer;
