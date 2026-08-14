import { createContext } from "react"
import UserProfile from "./UserProfile"

// eslint-disable-next-line react-refresh/only-export-components
export const UserContext = createContext();

function App() {
  const message = "Welcome to User Profile!"

  return (
    <UserContext.Provider value={message}>
      <UserProfile />
    </UserContext.Provider>
  )
}

export default App
