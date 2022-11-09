import axios from "axios";
import {useState} from "react";

export default function LoginPage() {

    const [username, setUsername] = useState("");
    const [password, setPassword] = useState("");

    const login = () => {
        axios.get("/api/app-users/login", {
            auth: {
                username,
                password
            }
        })
    }

    return <>
        <br/>
        <label htmlFor="username">Benutzername</label>
        <input type="text" id="username" onChange={event => setUsername(event.target.value)}/>
        <br/>
        <label htmlFor="password">Passwort</label>
        <input type="password" id="password" onChange={event => setPassword(event.target.value)}/>
        <br/>
        <button onClick={() => login()}>Anmelden</button>
    </>
}