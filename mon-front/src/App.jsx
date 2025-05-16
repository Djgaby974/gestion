import { useEffect, useState } from 'react';
import './index.css';

function App() {
    const [categories, setCategories] = useState([]);
    const [taches, setTaches] = useState([]);
    const [utilisateurs, setUtilisateurs] = useState([]);
    const [commentaires, setCommentaires] = useState([]);

    useEffect(() => {
        fetch("http://localhost:8080/categories/")
            .then(res => res.json())
            .then(data => Array.isArray(data) ? setCategories(data) : setCategories([]));

        fetch("http://localhost:8080/taches-simples/")
            .then(res => res.json())
            .then(data => Array.isArray(data) ? setTaches(data) : setTaches([]));

        fetch("http://localhost:8080/utilisateurs/")
            .then(res => res.json())
            .then(data => Array.isArray(data) ? setUtilisateurs(data) : setUtilisateurs([]));

        fetch("http://localhost:8080/commentaires/")
            .then(res => res.json())
            .then(data => Array.isArray(data) ? setCommentaires(data) : setCommentaires([]));
    }, []);

    return (
        <div style={styles.container}>
            <h1 style={styles.title}>🏁 Gestion des tâches</h1>

            <section style={styles.section}>
                <h2 style={styles.sectionTitle}>🚦 Catégories</h2>
                <ul style={styles.list}>
                    {categories.map(c => (
                        <li key={c.id} style={styles.item}>🚗 {c.nom}</li>
                    ))}
                </ul>
            </section>

            <section style={styles.section}>
                <h2 style={styles.sectionTitle}>🛠️ Tâches</h2>
                <ul style={styles.list}>
                    {taches.map(t => (
                        <li key={t.id} style={styles.item}>
                            {t.terminee ? "✅ " : "🔧 "} {t.titre}
                        </li>
                    ))}
                </ul>
            </section>

            <section style={styles.section}>
                <h2 style={styles.sectionTitle}>🧑‍🔧 Utilisateurs</h2>
                <ul style={styles.list}>
                    {utilisateurs.map(u => (
                        <li key={u.id} style={styles.item}>
                            🏁 {u.nom} – {u.email}
                        </li>
                    ))}
                </ul>
            </section>

            <section style={styles.commentaireSection}>
                <h2 style={styles.sectionTitle}>💬 Commentaires</h2>
                <ul style={styles.list}>
                    {commentaires.map(c => (
                        <li key={c.id} style={styles.item}>
                            🗨️ {c.contenu}
                        </li>
                    ))}
                </ul>
            </section>
        </div>
    );
}

const styles = {
    container: {
        fontFamily: '"Arial Black", Impact, sans-serif',
        backgroundColor: '#1e1e1e',
        minHeight: '100vh',
        padding: '40px 20px',
        color: '#ffcc00',
        display: 'flex',
        flexDirection: 'column',
        alignItems: 'center',
    },
    title: {
        fontSize: '2.5em',
        textAlign: 'center',
        marginBottom: '30px',
        color: '#ff0000',
        textShadow: '2px 2px #000000'
    },
    section: {
        marginBottom: '40px',
        background: '#2c2c2c',
        padding: '20px',
        borderRadius: '10px',
        boxShadow: '0 0 15px #ff0000',
        width: '100%',
        maxWidth: '600px',
        border: '3px solid #ff0000'
    },
    commentaireSection: {
        marginBottom: '40px',
        background: '#2c2c2c',
        padding: '20px',
        borderRadius: '10px',
        boxShadow: '0 0 15px #ff6600',
        width: '100%',
        maxWidth: '600px',
        border: '3px solid #ff6600'
    },
    sectionTitle: {
        fontSize: '1.6em',
        color: '#ffffff',
        marginBottom: '10px'
    },
    list: {
        listStyle: 'none',
        paddingLeft: 0,
    },
    item: {
        fontSize: '1.2em',
        padding: '6px 0',
        color: '#f5f5f5'
    }
};

export default App;
