import { useState } from "react";
import LoginStatus from "./LoginStatus";
import "./App.css";

function App() {
  const [dark, setDark] = useState(false);
  const [isLoggedIn, setIsLoggedIn] = useState(false);
  return (
    <div className={dark ? "" : "lightTheme"}>
      <button
        className={dark ? "" : "darkBtn"}
        onClick={() => setDark(!dark)}
        style={{ marginTop: "50px" }}
      >
        Switch for {dark ? "Light" : "Dark"} Theme
      </button>
      <LoginStatus isLoggedIn={isLoggedIn} setIsLoggedIn={setIsLoggedIn} />
    </div>
  );
}

export default App;
