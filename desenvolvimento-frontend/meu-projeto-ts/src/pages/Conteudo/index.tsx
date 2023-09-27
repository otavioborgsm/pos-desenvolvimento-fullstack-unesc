import axios from "axios";
import { useEffect, useState } from "react";
import { IPost } from "../../types";
import classNames from "classnames";
import { FaSpinner } from 'react-icons/fa'

export default function Conteudo(){

    const [posts, setPosts] = useState<IPost[]>([]);
    const [loading, setLoading] = useState(true)

    useEffect(() => {
        axios.get('https://mockend.com/api/mockend/demo/posts?limit=10&skip=20')
            .then(({ data })=>{
                setPosts(data)
                setLoading(false)
            })
            .catch(console.error)
    }, [])


    return (
        <>
            <h2>Nossos Conteúdos</h2>
            <div>
                <ul>
                    {
                        posts.map((item, index) => (
                            <li key={index}>
                                <div>
                                    <img className="img-fluid" src={item.cover} alt={item.title}></img>
                                </div>
                                <h3>{item.title}</h3>
                                <p>{item.body}</p>
                            </li>
                        ))
                    }
                    <li></li>
                </ul>
            </div>
            <div className={classNames({
                'd-none': !loading
            })}>
                <FaSpinner />
            </div>
            <div>
                <button onClick={() => {setLoading(true)}} className="btn btn-success">Carregar mais itens</button>
            </div>
        </>
    )
}