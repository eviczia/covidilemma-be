import React from "react";

function Main() {
  function renderQuiz() {}
  return (
    <div>
      <h2>COVIDILEMMA</h2>
      <div>
        If you want to check your knowledge of Covid-19 than press 'play' button
      </div>
      <div>
        <button type="submit" className="playButton" onChange={renderQuiz}>
          PLAY
        </button>
      </div>
    </div>
  );
}

export default Main;
