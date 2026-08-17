import { useReducer } from "react"
import "./ShoppingCart.css"

function ShoppingCart() {

    const initialState = {
        item: false,
        quantity: 0,
    }

    const [state, dispatch] = useReducer(reducer, initialState);

    function reducer(state, action) {
        switch (action.type) {

            case "add":
                if (state.item) return state;
                return { ...state, item: true, quantity: 1 };

            case "remove":
                if (!state.item) return state;
                return initialState;

            case "increase":
                if (state.item)
                    return { ...state, quantity: state.quantity + 1 };
                return state;

            case "decrease":
                if (state.quantity > 1)
                    return { ...state, quantity: state.quantity - 1 };
                return initialState;

            case "clear":
                return initialState;

            default:
                return state;
        }
    }

    return (
        <div className="cart">

            <h1>Shopping Cart</h1>

            <div className="cart-info">
                <h2>{state.item ? "Product Added" : "Cart Empty"}</h2>
                <h3>Quantity: {state.quantity}</h3>
            </div>

            <div className="buttons">
                <button onClick={() => dispatch({ type: "add" })}>
                    Add Item
                </button>
                <button onClick={() => dispatch({ type: "remove" })}>
                    Remove Item
                </button>
                <button onClick={() => dispatch({ type: "increase" })}>
                    Increase Quantity
                </button>
                <button onClick={() => dispatch({ type: "decrease" })}>
                    Decrease Quantity
                </button>
                <button onClick={() => dispatch({ type: "clear" })}>
                    Clear Cart
                </button>
            </div>

        </div>
    )
}

export default ShoppingCart