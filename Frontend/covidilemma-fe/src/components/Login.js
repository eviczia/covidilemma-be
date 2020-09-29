import React, { useState } from "react";
import axios from "axios";
import "./Login.css";

function Login() {
  const [nickName, setNickName] = useState({});
  const [errorMessage, setErrorMessage] = useState({
    message: "",
    isError: false,
  });

  async function handleSubmit(event) {
    event.preventDefault();
    axios({
      method: "post",
      url: "http://localhost:8080/login",
      headers: {},
      data: {
        nickName: { nickName },
      },
    }).then((response) => {
      if (response.status === 400) {
      } else {
        setNickName(nickName);
      }
    });
  }

  return (
    <div className="loginPage">
      <div className="bg.image"></div>
      <div className="title">
        <h1 className="title">COVIDILEMMA</h1>
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
