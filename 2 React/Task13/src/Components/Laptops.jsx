function Laptops() {
    return (
        <div className="product-grid">
            <div className="product-card">
                <img
                    src="https://images.unsplash.com/photo-1496181133206-80ce9b88a853"
                    alt="MacBook"
                />
                <div className="product-info">
                    <h2>MacBook Pro</h2>
                    <p className="price">₹1,50,000</p>
                    <p>
                        A powerful laptop designed for professionals,
                        creators, and developers.
                    </p>
                    <button>View Details</button>
                </div>
            </div>

            <div className="product-card">
                <img
                    src="https://images.unsplash.com/photo-1603302576837-37561b2e2302"
                    alt="Gaming Laptop"
                />
                <div className="product-info">
                    <h2>Gaming Laptop</h2>
                    <p className="price">₹1,20,000</p>
                    <p>
                        A high-performance laptop built for gaming,
                        entertainment, and demanding applications.
                    </p>
                    <button>View Details</button>
                </div>
            </div>
        </div>
    )
}

export default Laptops