import classNames from 'classnames';
import { useState } from 'react';


export default function Navbar(){

    const [showMobile, setShowMobile] = useState(false)
   
    return(
        <nav className="navbar navbar-expand-lg bg-body-tertiary">
            <div className="container-fluid">
                <a className="navbar-brand" href="#">Navbar</a>
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
                        <a className="nav-link active" aria-current="page" href="#">Home</a>
                        </li>
                        <li className="nav-item">
                        <a className="nav-link" href="#">Link</a>
                        </li>
                    </ul>
                </div>
            </div>
        </nav>
    )
    
}