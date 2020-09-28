const { default: Axios } = require("axios");

const validateNickname = (nickname) => {
  Axios.post("http://localhost:8080/login", ("nickname": nickname));
  return { message: "This nickname is already taken" };
};
