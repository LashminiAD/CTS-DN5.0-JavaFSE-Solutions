import Student from "./components/Student";
import "./App.css";

function App() {

  return (
    <div className="App">
      <Student
        name="Lashmini A D"
        school="Sairam Engineering College"
        total={284}
      />
    </div>
  );

}

export default App;