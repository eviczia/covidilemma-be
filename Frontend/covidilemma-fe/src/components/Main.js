import React, { useState } from "react";
import axios from "axios";
import Quiz from "./Quiz";
import "./Main.css";

function Main() {
  const [questions, setQuestions] = useState([]);

  const [isPlaying, setIsPlaying] = useState(false);

  function renderQuiz() {
    setIsPlaying(true);

    axios.get("http://localhost:8080/quiz").then((response) => {
      setQuestions(response.data);
      console.log(response.data);
      //   setQuestions()
    });
  }

  return (
    <div className="main">
      <h2 className="title">COVIDILEMMA</h2>
      {isPlaying ? (
        <Quiz questions={questions}></Quiz>
      ) : (
        <div>
          {" "}
          <div>
            If you want to check your knowledge of Covid-19 than press 'play'
            button
          </div>
          <button type="submit" className="playButton" onClick={renderQuiz}>
            PLAY
          </button>
        </div>
      )}
    </div>
  );
}

export default Main;
