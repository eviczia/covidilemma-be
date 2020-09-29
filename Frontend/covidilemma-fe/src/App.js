import React from "react";

import Login from "./components/Login";
import { BrowserRouter as Router, Switch, Route } from "react-router-dom";
import Main from "./components/Main";
import "./App.css";

function App() {
  return (
    <Router>
      <Switch>
        <div className="App">
          <Route path="/login">
            <Login />
          </Route>
          <Route exact path="/">
            <Main />
          </Route>
        </div>
      </Switch>
    </Router>
  );
}

export default App;
