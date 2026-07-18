import React, { Component } from "react";

class ComplaintRegister extends Component {

  constructor(props) {
    super(props);

    this.state = {
      ename: "",
      complaint: ""
    };
  }

  handleChange = (event) => {

    this.setState({
      [event.target.name]: event.target.value
    });

  };

  handleSubmit = (event) => {

    event.preventDefault();

    const refId = Math.floor(Math.random() * 100000);

    alert(
      `Thanks ${this.state.ename}\n\nYour Complaint was Submitted.\nReference Number: ${refId}`
    );

  };

  render() {

    return (

      <div style={{ textAlign: "center", marginTop: "60px" }}>

        <h2 style={{ color: "red" }}>
          Register your complaints here!!!
        </h2>

        <form onSubmit={this.handleSubmit}>

          <div style={{ margin: "15px" }}>
            <label>Name : </label>

            <input
              type="text"
              name="ename"
              value={this.state.ename}
              onChange={this.handleChange}
            />
          </div>

          <div style={{ margin: "15px" }}>
            <label>Complaint : </label>

            <textarea
              name="complaint"
              value={this.state.complaint}
              onChange={this.handleChange}
            />
          </div>

          <button type="submit">
            Submit
          </button>

        </form>

      </div>

    );

  }

}

export default ComplaintRegister;