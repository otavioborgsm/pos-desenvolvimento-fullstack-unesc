import { useState } from "react";
import Link from "next/link";

export default function Navbar() {
  const [menus, setMenus] = useState<any[]>([]);
  const [showMobile, setShowMobile] = useState(false);

  import("./menus.json").then(({ default: menus }) => {
    setMenus(menus);
  });

  return (
    <nav className="navbar navbar-expand-md bg-light">
      <div className="container-fluid">
        <Link className="navbar-brand" href="/">
          Navbar
        </Link>
        <button
          onClick={() => setShowMobile(!showMobile)}
          onBlur={() => setShowMobile(false)}
          className="navbar-toggler"
          type="button"
        >
          <span className="navbar-toggler-icon"></span>
        </button>
        <div className="collapse navbar-collapse">
          <ul className="navbar-nav me-auto mb-2 mb-lg-0">
            {menus.map((item, index) => (
              <li key={index} className="nav-item">
                <Link className="nav-link" href={item.to}>
                  {item.title}
                </Link>
              </li>
            ))}
          </ul>
        </div>
      </div>
    </nav>
  );
}
