import './Card.css'



const Card = ({ title, img }: { title: string; img: string; }) => {
    return (
        <>
            <div className="card">
                <img src={img} alt={`tenis ${title}`} />
                <p className="p">{title}</p>
            </div>
        </>
    )
}

export default Card