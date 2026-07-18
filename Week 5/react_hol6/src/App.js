import {

BrowserRouter,

Routes,

Route,

Link

} from "react-router-dom";

import Home from "./components/Home";

import Trainers from "./components/Trainers";

import TrainerDetails from "./components/TrainerDetails";

import "./App.css";

function App() {

return (

<BrowserRouter>

<div>

<nav>

<Link to="/">Home</Link>

{" | "}

<Link to="/trainers">Trainers</Link>

</nav>

<hr />

<Routes>

<Route path="/" element={<Home />} />

<Route path="/trainers" element={<Trainers />} />

<Route path="/trainer/:id" element={<TrainerDetails />} />

</Routes>

</div>

</BrowserRouter>

);

}

export default App;