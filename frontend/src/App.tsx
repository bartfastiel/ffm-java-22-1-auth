import React, {useEffect, useState} from 'react';
import './App.css';
import LoginPage from "./LoginPage";
import SecuredPage from "./SecuredPage";
import axios from "axios";

function App() {

    const [username, setUsername] = useState<string>();

    const fetchUsername = () => {
        axios.get('/api/app-users/me')
            .then(response => response.data)
            .then(setUsername)
    }

    useEffect(fetchUsername, [])

    if (username === undefined) {
        return <>Bitte haben Sie einen Augenblick Geduld...</>
    }
    if (username === 'anonymousUser') {
        return <LoginPage onLogin={fetchUsername}></LoginPage>
    }
    return <SecuredPage username={username}></SecuredPage>
}

export default App;
