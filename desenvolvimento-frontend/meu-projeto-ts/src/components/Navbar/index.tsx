import classNames from 'classnames';
import { useState } from 'react';
import { Link, NavLink } from 'react-router-dom';


export default function Navbar(){

    const [showMobile, setShowMobile] = useState(false)
   
    return(
        <nav className="navbar navbar-expand-lg bg-body-tertiary">
            <div className="container-fluid">
            <Link className="navbar-brand" to="/">Navbar</Link>
                <button
                    onClick={() => setShowMobile(!showMobile)}
                    onBlur={() => setShowMobile(false)}
                    className="navbar-toggler"
                    type="button"
                >                        
                <span className="navbar-toggler-icon"></span>
                </button>
                <div className={classNames(
                    "collapse navbar-collapse",
                    { 'show': showMobile },
                )}>
                    <ul className="navbar-nav me-auto mb-2 mb-lg-0">
                        <li className="nav-item">
                            <NavLink
                                className={({ isActive }) => {
                                return classNames('nav-link', { 'active': isActive }) 
                                }}
                                to='/conteudo'
                            >Conteudo</NavLink>              
                        </li>
                        <li className="nav-item">
                            <NavLink
                                className={({ isActive }) => {
                                return classNames('nav-link', { 'active': isActive }) 
                                }}
                                to='/sobre'
                            >Sobre</NavLink>                       
                        </li>
                    </ul>
                </div>
            </div>
        </nav>
    )
    
}