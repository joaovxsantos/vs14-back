import './Footer.css'
import { FaInstagram, FaTwitter, FaFacebook } from 'react-icons/fa';
import { MdMail } from 'react-icons/md';

const Footer = () => {
    return (
        <>
            <footer>
                Todos os direitos reservados.
                <div className="icons">
                    <FaInstagram />
                    <FaTwitter />
                    <FaFacebook />
                    <MdMail />
                </div>
            </footer>


        </>
    )
}

export default Footer