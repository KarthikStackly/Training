function Bikes() {
    return (
        <div className="product-grid">
            <div className="product-card">
                <img
                    src="https://images.unsplash.com/photo-1558981806-ec527fa84c39"
                    alt="Sports Bike"
                />
                <div className="product-info">
                    <h2>Yamaha R15</h2>
                    <p className="price">₹2,00,000</p>
                    <p>
                        A sporty motorcycle offering excellent
                        handling and performance.
                    </p>
                    <button>View Details</button>
                </div>
            </div>

            <div className="product-card">
                <img
                    src="https://images.unsplash.com/photo-1558981852-426c6c22a060"
                    alt="Motorcycle"
                />
                <div className="product-info">
                    <h2>Kawasaki Ninja</h2>
                    <p className="price">₹5,50,000</p>
                    <p>
                        A powerful sports bike designed for speed,
                        comfort, and performance.
                    </p>
                    <button>View Details</button>
                </div>
            </div>
        </div>
    )
}

export default Bikes