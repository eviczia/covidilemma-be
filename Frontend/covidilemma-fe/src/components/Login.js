import React, { useState } from "react";
import axios from "axios";
import "./Login.css";

function Login() {
  const [user, setUser] = useState({
    name: "",
  });

  //   const [errorMessage, setErrorMessage] = useState({
  //     message: "",
  //     isError: false,
  //   });

  async function handleSubmit(event) {
    event.preventDefault();

    axios
      .post("http://localhost:8080/login", {
        nickname: user.name,
      })
      .then((response) => {
        //   if (response.status === 400) {
        //   } else if (response.status === 200) {
        //     setUser(user.nickName);
        //     response.redirect("/");
        //     //store token
        //   }
      });
  }

  function handleInputChange(event) {
    setUser({ name: event.target.value });
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
              value={user.name}
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
