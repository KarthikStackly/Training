import "./InputArea.css";

function InputArea({ typeMsg, setTypeMsg, handleClick }) {
  function handleMsg(e) {
    setTypeMsg(e.target.value);
  }

  return (
    <div className="input-area">
      <textarea id={0} value={typeMsg} onChange={handleMsg}></textarea>
      <button className="send-btn" onClick={handleClick}>
        Send Message
      </button>
    </div>
  );
}

export default InputArea;
