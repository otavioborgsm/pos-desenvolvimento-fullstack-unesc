import axios from "axios";
import { useState } from "react";
import { IPost } from "../../types";

export default function Conteudo(){

    const [posts, setPosts] = useState<IPost[]>([]);

    return (
        <div>Conteúdo</div>
    )
}