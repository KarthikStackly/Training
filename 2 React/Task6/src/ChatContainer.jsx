import Message from "./Message";
import "./ChatContainer.css";

function ChatContainer({ showMsg }) {
  return (
    <div className="chat-container">
      {showMsg.map((msg, index) => {
        return <Message key={index} msg={msg} />;
      })}
    </div>
  );
}

export default ChatContainer;
