import { BrowserRouter as Router, Routes, Route } from "react-router-dom";
import Home from "./pages/Home";
import Sobre from "./pages/Sobre";
import Conteudo from "./pages/Conteudo";
import Navbar from "./components/Navbar";

export default function AppRoutes() {
    return (
        <div>
            <Router>
                <Navbar />
                <Routes>
                    <Route path="/" element={<Home />} />
                    <Route path="/conteudo" element={<Conteudo />} />
                    <Route path="/sobre" element={<Sobre />} />
                </Routes>
            </Router>
        </div>
    )
}