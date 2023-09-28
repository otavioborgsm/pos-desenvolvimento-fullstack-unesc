import { IPost } from "@/types";
import Image from "next/image";

interface Props {
    post: IPost
}

export default function Post({ post }:Props){
    return(
        <li>
            <Image src={post.cover} alt={post.title} width={800} height={200}/>
            <h2>{ post.title }</h2>
            <p>{ post.body }</p>
        </li>
    )
}