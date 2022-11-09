type Props = {
    username: string,
}
export default function SecuredPage(props: Props) {
    return <>
        <section><h1>Secured</h1></section>
        <h1>Willkommen {props.username}</h1>
    </>
}