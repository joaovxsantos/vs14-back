import './Section.css'

const Section = () => {
    return (
        <>
            <section>
                <div className="sec-head">
                    <div className="infos">
                        <h2>A melhor loja de Jordan</h2>
                        <div className="infos-text">
                            <p>O tênis Jordan é fruto de uma velha e forte parceria </p>
                        </div>

                        <div className="text2">
                            <p>entre a Nike e o
                                jogador Michael Jordan.</p>
                        </div>
                    </div>
                    <div className="img">
                        <img src="./image/wallpaper.jpeg" alt="tenis jordan wallpaper" />
                    </div>
                </div>
            </section>
        </>
    )
}

export default Section