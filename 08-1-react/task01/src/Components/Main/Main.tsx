import Card from '../Card/Card'
import { CARD_TEXT1 } from '../Card/cardText'
import { CARD_TEXT2 } from '../Card/cardText'

import './Main.css'


const Main = () => {
    return (
        <>
            <main>
                <div className="container">

                    <div className="text">
                        <h3>Destaques</h3>
                        <p id="typed">Frete grátis e chinelo de brinde é aqui, aproveite por tempo limitado.</p>
                    </div>

                    <div className="images">
                        {CARD_TEXT1.map((info) => <Card {...info} />)}
                    </div>

                    <div className="images">
                        {CARD_TEXT2.map((info) => <Card {...info} />)}
                    </div>
                </div>
            </main>
        </>

    )
}

export default Main