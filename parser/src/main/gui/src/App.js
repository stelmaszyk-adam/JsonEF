import React from 'react';
import {BrowserRouter as Router, Switch, Route} from 'react-router-dom'
import Layout from './components/layout';
import Home from './Home.js'
import About from './About.js'

function App() {
  return (
    <Router>
    <Layout>
    <Switch>
      <Route exact path='/'>
        <Home />
      </Route>
      <Route path='/about'>
        <About />
      </Route>
    </Switch>
    </Layout>
    </Router>
  )
}

export default App;
