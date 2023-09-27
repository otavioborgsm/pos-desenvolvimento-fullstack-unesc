import classNames from 'classnames';
import { useState } from 'react';
import { Link, NavLink } from 'react-router-dom';
import { IMenu } from '../../types';

export default function Navbar(){

    const [menus, setMenus] = useState<IMenu[]>([]);
    const [showMobile, setShowMobile] = useState(false)

    import('./menus.json')
    .then(({ default: menus }) => {
      setMenus(menus)
    })
   
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
                        {
                            menus.map((item, index) => (
                                <li key={index} className="nav-item">
                                <NavLink
                                    className={({ isActive }) => {
                                    return classNames('nav-link', { 'active': isActive }) 
                                    }}
                                    to={item.to}
                                >
                                    {item.title}
                                </NavLink>
                                </li>
                            ))
                        }
                    </ul>
                </div>
            </div>
        </nav>
    )
    
}