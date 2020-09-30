import React, { useState } from "react";
import "./Quiz.css";

function Quiz(props) {
  const [score, setScore] = useState(0);
  function clickHandle(event) {
    console.log(event.target.value);
  }

  return (
    <div>
      <>
        {props.questions.map((question, i) => (
          <div key={question.id}>
            <div className="question-section">
              <div className="question-count">
                <span>{question.id}</span>/{props.questions.length}
              </div>
              <div className="question-text">{question.question} </div>
            </div>
            {question.answers.map((answer, i) => (
              <div className="buttons">
                <button
                  key={answer}
                  value={answer.correct}
                  className="answerButton"
                  onClick={clickHandle}
                >
                  {answer.answer}
                </button>
              </div>
            ))}
          </div>
        ))}
      </>
    </div>
  );
}

export default Quiz;
