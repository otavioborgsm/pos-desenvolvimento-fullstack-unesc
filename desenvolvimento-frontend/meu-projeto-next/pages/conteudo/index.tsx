import Post from "@/components/Post"
import { IPost } from "@/types"
import axios from "axios"

export async function getServerSideProps(): Promise<{ props: { posts: IPost[] }; } > {
    const { data } = await axios.get('https://mockend.com/api/mockend/demo/posts?limit=10&skip=20')
    return { props: {posts:data} }
}

export default function Conteudo({ posts }: { posts: IPost[] }){
    return(
        <>
            <div>Conteúdo</div>
            {
                posts.map((item, index) => (
                    <Post post={item} key={index}/>
                ))
            }
        </>
    
    )
}