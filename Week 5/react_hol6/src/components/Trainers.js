import { Link } from "react-router-dom";

const trainers = [

    { id: 1, name: "John" },

    { id: 2, name: "Priya" },

    { id: 3, name: "David" }

];

function Trainers() {

    return (

        <div>

            <h2>Trainer List</h2>

            <ul>

                {

                    trainers.map((trainer) => (

                        <li key={trainer.id}>

                            <Link to={`/trainer/${trainer.id}`}>

                                {trainer.name}

                            </Link>

                        </li>

                    ))

                }

            </ul>

        </div>

    );

}

export default Trainers;