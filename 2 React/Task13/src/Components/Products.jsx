import { Link, Outlet } from "react-router-dom"

function Products() {
    return (
        <div className="products-page">

            <h1>Products</h1>
            <p className="products-subtitle">
                Browse our collection of products
            </p>
            <nav className="category-nav">
                <Link to="cars">Cars</Link>
                <Link to="bikes">Bikes</Link>
                <Link to="laptops">Laptops</Link>
            </nav>

            <Outlet />

        </div>
    )
}

export default Products