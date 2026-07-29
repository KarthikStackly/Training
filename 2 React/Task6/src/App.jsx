import { useState } from "react";
import "./App.css";
import ChatContainer from "./ChatContainer";
import InputArea from "./InputArea";
function App() {
  const [typeMsg, setTypeMsg] = useState("");
  const [showMsg, setShowMsg] = useState([]);

  function handleClick() {
    if (typeMsg != "") setShowMsg([...showMsg, typeMsg]);
    setTypeMsg("");
    console.log(showMsg);
  }
  return (
    <div className="app-container">
      <h1>Mini Chat Application</h1>
      <InputArea
        typeMsg={typeMsg}
        setTypeMsg={setTypeMsg}
        handleClick={handleClick}
      />
      <ChatContainer showMsg={showMsg} />
    </div>
  );
}

export default App;
