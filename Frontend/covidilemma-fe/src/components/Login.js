import React, { useState } from "react";
import validateNickname from "../services/validateNickname";
import axios from "axios";

function Login() {
  const [nickName, setNickName] = useState({});
  const [errorMessage, setErrorMessage] = useState({
    message: "",
    isError: false,
  });

  async function handleSubmit(event) {
    event.preventDefault();

    if (validateNickname.response === 400) {
      setErrorMessage(validateNickname.message);
    } else {
      axios.post("http://localhost:8080/login").then((response) => {
        setNickName(response.data);
      });
    }
  }

  return (
    <div>
      <div>
        <h1>COVIDILEMMA</h1>
      </div>
      <div className="form">
        <form onSubmit={handleSubmit} method="post">
          <div>
            <input
              type="text"
              name="nickname"
              //   value={nickName}
              placeholder="Enter your nickname"
              className="nicknameInput"
              //   onChange={handleInputChange}
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
