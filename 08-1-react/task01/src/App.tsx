import { useState } from 'react'
import './App.css'
import Header from './Components/Header/Header.tsx'
import Section from './Components/Section/Section.tsx'
import Main from './Components/Main/Main.tsx'
import Footer from './Components/Footer/Footer.tsx'

function App() {
  return (
    <>
      <Header></Header>
      <Section></Section>
      <Main></Main>
      <Footer></Footer>
    </>
  )
}

export default App