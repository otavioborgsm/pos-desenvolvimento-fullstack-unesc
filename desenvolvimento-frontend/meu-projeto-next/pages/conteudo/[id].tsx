import { GetStaticProps } from "next"

export async function getServerSideProps( context: { params: {id:number} } ) {
    const { params } = context

    return { props: {id:params.id} }
}

export default function Conteudo({ id }: {id:number}){
    return(
        <>
            <div>Conteudo com id</div>
            <div>Id da página: {id}</div>
        </>
    )
}