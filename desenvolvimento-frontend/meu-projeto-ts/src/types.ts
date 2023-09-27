export interface IPost {
    body: string,
    cover: string,
    createdAt: string,
    id: number,
    idDraft: boolean,
    tag: string,
    title: string
}

export interface IMenu {
    title: string,
    to: string
}
