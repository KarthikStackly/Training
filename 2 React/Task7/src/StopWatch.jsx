import { useEffect, useState } from "react";
import "./StopWatch.css";
function StopWatch() {
  // ATTEMPT 1
  /*
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

        if (secs > 58) {
          setMins((prev) => prev + 1);
        } else if (mins > 58) {
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
*/

  // ATTEMPT 2
  /*

  // Set up the effect
  useEffect(() => {
    //define the interval ID
    let intervalId;
    // Condition to control start or stop of timer
    if (run) {
      intervalId = setInterval(() => {
        // Removing 0's
        time.secs > 9 ? setSec0("") : setSec0("0");
        time.mins > 9 ? setMin0("") : setMin0("0");
        time.hours > 9 ? setHour0("") : setHour0("0");

        if (time.secs > 59) {
          setTime((prev) => ({ ...prev, secs: 0, mins: prev.mins + 1 }));
        } else if (time.mins > 59) {
          setTime((prev) => ({
            ...prev,
            mins: 0,
            secs: 0,
            hours: prev.hours + 1,
          }));
        } else if (time.hours > 23) {
          setTime((prev) => ({ ...prev, hours: 0, mins: 0, secs: 0 }));
        } else setTime((prev) => ({ ...prev, secs: prev.secs + 1 }));
      }, 1000);
    }

    return () => clearInterval(intervalId);
  }, [time, run]);


 */

  // Final Piece

  const initialTime = {
    hours: 0,
    mins: 0,
    secs: 0,
  };

  const [time, setTime] = useState(initialTime);
  const [running, setRunning] = useState(false);

  useEffect(() => {
    let intervalId;

    if (running) {
      intervalId = setInterval(() => {
        setTime((prev) => {
          const next = { ...prev };

          next.secs++;

          if (next.secs > 59) {
            next.secs = 0;
            next.mins++;
          }

          if (next.mins > 59) {
            next.mins = 0;
            next.hours++;
          }

          return next;
        });
      }, 1000);
    }

    return () => clearInterval(intervalId);
  }, [running]);

  function handleStart() {
    setRunning(true);
    console.log("StopWatch Started");
  }

  function handleStop() {
    setRunning(false);
    console.log("StopWatch Stopped");
  }

  function handleReset() {
    setRunning(false);
    setTime(initialTime);
    console.log("StopWatch Reset");
  }

  return (
    <div className="stopwatch-container">
      <h1>Stopwatch</h1>

      <div className="timer">
        {String(time.hours).padStart(2, "0")} :
        {String(time.mins).padStart(2, "0")} :
        {String(time.secs).padStart(2, "0")}
      </div>

      <div className="button-group">
        <button className="start" onClick={handleStart}>
          Start
        </button>

        <button className="stop" onClick={handleStop}>
          Stop
        </button>

        <button className="reset" onClick={handleReset}>
          Reset
        </button>
      </div>
    </div>
  );
}

export default StopWatch;
