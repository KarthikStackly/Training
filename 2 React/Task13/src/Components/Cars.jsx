function Cars() {
    return (
        <div className="product-grid">
            <div className="product-card">
                <img
                    src="https://images.unsplash.com/photo-1494976388531-d1058494cdd8"
                    alt="Sports Car"
                />
                <div className="product-info">
                    <h2>Ford Mustang</h2>
                    <p className="price">₹45,00,000</p>
                    <p>
                        A powerful sports car with a stylish design
                        and excellent performance.
                    </p>
                    <button>View Details</button>
                </div>
            </div>

            <div className="product-card">
                <img
                    src="https://images.unsplash.com/photo-1555215695-3004980ad54e"
                    alt="BMW Car"
                />
                <div className="product-info">
                    <h2>BMW M4</h2>
                    <p className="price">₹75,00,000</p>
                    <p>
                        A premium performance car combining luxury
                        with thrilling driving dynamics.
                    </p>
                    <button>View Details</button>
                </div>
            </div>
        </div>
    )
}
export default Cars