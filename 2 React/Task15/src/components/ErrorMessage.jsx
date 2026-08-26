function ErrorMessage({ message }) {

    return (
        <div className="error-page">

            <h2>Something went wrong</h2>

            <p>
                {message}
            </p>

        </div>
    );
}

export default ErrorMessage;