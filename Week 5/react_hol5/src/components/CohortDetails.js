import styles from "./CohortDetails.module.css";

const cohorts = [
  {
    name: "INTADMDF10 - .NET FSD",
    startedOn: "22-Feb-2022",
    status: "Scheduled",
    coach: "Lashhh",
    trainer: "Jo Tamil"
  },
  {
    name: "ADM21JF014 - Java FSD",
    startedOn: "10-Sep-2021",
    status: "Ongoing",
    coach: "Ammu",
    trainer: "selvan"
  },
  {
    name: "CDBJF21025 - Java FSD",
    startedOn: "24-Dec-2021",
    status: "Ongoing",
    coach: "lachu",
    trainer: "silkesm"
  }
];

function CohortDetails() {
  return (
    <div>
      <h1>Cohorts Details</h1>

      {cohorts.map((cohort, index) => (
        <div className={styles.box} key={index}>

          <h3
            style={{
              color: cohort.status === "Ongoing" ? "green" : "blue"
            }}
          >
            {cohort.name}
          </h3>

          <dl>
            <dt>Started On</dt>
            <dd>{cohort.startedOn}</dd>

            <dt>Current Status</dt>
            <dd>{cohort.status}</dd>

            <dt>Coach</dt>
            <dd>{cohort.coach}</dd>

            <dt>Trainer</dt>
            <dd>{cohort.trainer}</dd>
          </dl>

        </div>
      ))}
    </div>
  );
}

export default CohortDetails;