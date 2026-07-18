import { useParams } from "react-router-dom";

function TrainerDetails() {

    const { id } = useParams();

    return (

        <div>

            <h2>Trainer Details</h2>

            <p>Trainer ID : {id}</p>

        </div>

    );

}

export default TrainerDetails;