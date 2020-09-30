import React, { useState } from "react";
import axios from "axios";
import "./Login.css";
import { useHistory } from "react-router-dom";

function Login() {
  const [user, setUser] = useState({
    username: "",
  });

  //   const [errorMessage, setErrorMessage] = useState({
  //     message: "",
  //     isError: false,
  //   });
  let history = useHistory();

  async function handleSubmit(event) {
    event.preventDefault();
    axios
      .post("http://localhost:8080/login", user.username)
      .then((response) => {
        console.log(response.data);
        history.push("/main");
      });
  }

  function handleInputChange(event) {
    setUser({ username: event.target.value });
  }

  return (
    <div className="loginPage">
      <div className="title">
        <h1 className="title">COVIDILEMMA</h1>
      </div>
      <div className="form">
        <form onSubmit={handleSubmit} method="post">
          <div>
            <input
              type="text"
              name="nickname"
              value={user.username}
              placeholder="Enter your nickname"
              className="nicknameInput"
              onChange={handleInputChange}
            />
          </div>
          <div className="submit">
            <button type="submit" className="submitButton">
              LOGIN
            </button>
          </div>
        </form>
      </div>
    </div>
  );
}

export default Login;
