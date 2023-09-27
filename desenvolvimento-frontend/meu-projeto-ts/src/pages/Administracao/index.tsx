import {default as React, useState} from "react";

export default function Administracao() {
    const [title, setTitle] = useState('')
    const [body, setBody] = useState('')

    function submit (e: React.SyntheticEvent) {
        e.preventDefault()
        console.log(title)
        console.log(body)
    }

    return (
        <form onSubmit={submit}>
            <div className="py-2">
                <label htmlFor="title">Titulo</label>
                <input type="text" id="title" value={title} onChange={(e)=>{setTitle(e.target.value)}} />
            </div>
            <div>
                <label htmlFor="body">Conteúdo:</label>
                <textarea onChange={(e)=> { setBody(e.target.value) }} id="body" cols={30} rows={10} />
            </div>
            <button type="submit" className="btn btn-primary">Enviar</button>
        </form>
    )
}