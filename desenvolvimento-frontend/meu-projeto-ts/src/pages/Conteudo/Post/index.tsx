import { IPost } from "../../../types"

interface Prop {
    post: IPost
}

export default function Post({ post }: Prop){
    return(
        <li>
            <div>
                <img className="img-fluid" src={post.cover} alt={post.title}></img>
            </div>
            <h2>{ post.title }</h2>
            <p>{ post.body }</p>
        </li>
    )
}