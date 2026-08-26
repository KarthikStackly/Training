import { Link } from "react-router-dom";

function NotFound() {

    return (
        <section className="page not-found">
            <h1>404</h1>
            <h2>Page Not Found</h2>
            <p>The page you're looking for does not exist.</p>
            <Link to="/">Return Home</Link>
        </section>
    );
}

export default NotFound;