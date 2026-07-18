import UserContext from "./UserContext";
import Home from "./components/Home";

function App() {

  const username = "Lashmini A D";

  return (

    <UserContext.Provider value={username}>

      <Home />

    </UserContext.Provider>

  );
}

export default App;