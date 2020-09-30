import React, { useState } from "react";
import axios from "axios";
import "./Login.css";
import { useHistory } from "react-router-dom";

function Login() {
  const [player, setPlayer] = useState({
    username: "",
  });

  //   const [errorMessage, setErrorMessage] = useState({
  //     message: "",
  //     isError: false,
  //   });
  let history = useHistory();

  async function handleSubmit(event) {
    event.preventDefault();
    console.log(player);
    axios({
      method: "post",
      url: "http://localhost:8080/login",
      data: {
        username: player.username,
      },
    }).then((response) => {
      console.log(response);
      history.push("/main");
    });

    // axios
    //   .post("http://localhost:8080/login", {
    //     username: player.username,
    //   })
    //   .then((response) => {
    //     console.log(response);
    //     history.push("/main");
    //     //   if (response.status === 400) {
    //     //   } else if (response.status === 200) {
    //     //     setUser(user.nickName);
    //     //     response.redirect("/");
    //     //     //store token
    //     //   }
    //   });
  }

  function handleInputChange(event) {
    setPlayer({ [event.target.name]: event.target.value });
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
              name="username"
              value={player.username}
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
