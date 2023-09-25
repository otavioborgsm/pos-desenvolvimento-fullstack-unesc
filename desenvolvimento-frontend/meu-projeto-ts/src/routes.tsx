import { BrowserRouter as Router, Routes, Route } from "react-router-dom";
import Home from "./pages/Home";
import Sobre from "./pages/Sobre";
import Conteudo from "./pages/Conteudo";
import Navbar from "./components/Navbar";
import Footer from "./components/Footer";

export default function AppRoutes() {
    return (
        <div className="container-fluid px-0">
            <Router>
                <Navbar />
                <Routes>
                    <Route path="/" element={<Home />} />
                    <Route path="/conteudo" element={<Conteudo />} />
                    <Route path="/sobre" element={<Sobre />} />
                </Routes>
                <Footer />
            </Router>
        </div>
    )
}