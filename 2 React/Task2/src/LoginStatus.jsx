import "./LoginStatus.css";

function LoginStatus() {
  const isLoggedIn = false;
  return (
    <div className="container">
      <div className={`card ${isLoggedIn ? "success" : "danger"}`}>
        <h1>{isLoggedIn ? "Welcome Back!" : "Please Login"}</h1>
        <p>
          {isLoggedIn
            ? "You have successfully Logged in to your account."
            : "Please Login to continue."}
        </p>
        <button> {isLoggedIn ? "Go to Dashboard" : "Login"} </button>
      </div>
    </div>
  );
}

export default LoginStatus;
