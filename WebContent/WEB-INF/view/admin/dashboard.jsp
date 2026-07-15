<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="it">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Dashboard Admin - GG Eyewear</title>
    
    <!-- Font Premium da Google Fonts -->
    <link rel="preconnect" href="https://fonts.googleapis.com">
    <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
    <link href="https://fonts.googleapis.com/css2?family=Outfit:wght@300;400;600;700;800&display=swap" rel="stylesheet">
    
    <link rel="stylesheet" href="<%= request.getContextPath() %>/styles/comune.css">
    <link rel="stylesheet" href="<%= request.getContextPath() %>/styles/dashboard.css">
</head>
<body>
<%@ include file="../partials/header.jsp" %>
<div class="container">
    <h1>GG Eyewear — Area Admin</h1>
    <div class="subtitle">Benvenuto nella dashboard di controllo del tuo negozio</div>

    <!-- Sezione Statistiche -->
    <div class="stats-grid">
        <div class="stat-card">
            <div class="stat-label">Ricavi Totali</div>
            <div class="stat-value highlight">€ <%= String.format("%.2f", (Double) request.getAttribute("totaleGuadagni")) %></div>
        </div>
        <div class="stat-card">
            <div class="stat-label">Ordini Totali</div>
            <div class="stat-value"><%= request.getAttribute("totaleOrdini") %></div>
        </div>
        <div class="stat-card">
            <div class="stat-label">Utenti Registrati</div>
            <div class="stat-value"><%= request.getAttribute("totaleUtenti") %></div>
        </div>
        <div class="stat-card">
            <div class="stat-label">Prodotti in Catalogo</div>
            <div class="stat-value"><%= request.getAttribute("totaleProdotti") %></div>
        </div>
    </div>

    <!-- Pulsanti Azioni Rapide -->
    <div class="actions-grid">
        <!-- Azione: Gestione Prodotti -->
        <a href="${pageContext.request.contextPath}/admin/GestioneProdotti" class="action-card">
            <div class="action-icon">
                <svg viewBox="0 0 24 24">
                    <path d="M19 13H5v-2h14v2zM12 5L5 12h14L12 5zm0 14l7-7H5l7 7z"/>
                </svg>
            </div>
            <div class="action-title">Gestione Prodotti</div>
            <div class="action-desc">Inserisci nuovi occhiali, modifica le informazioni commerciali, i prezzi e gestisci le varianti di colore a magazzino.</div>
        </a>

        <!-- Azione: Gestione Ordini -->
        <a href="${pageContext.request.contextPath}/admin/VisualizzaOrdini" class="action-card">
            <div class="action-icon">
                <svg viewBox="0 0 24 24">
                    <path d="M19 3H5c-1.1 0-2 .9-2 2v14c0 1.1.9 2 2 2h14c1.1 0 2-.9 2-2V5c0-1.1-.9-2-2-2zm-5 14H7v-2h7v2zm3-4H7v-2h10v2zm0-4H7V7h10v2z"/>
                </svg>
            </div>
            <div class="action-title">Gestione Ordini</div>
            <div class="action-desc">Visualizza gli ordini effettuati dai clienti, applica filtri avanzati e aggiorna lo stato degli ordini in tempo reale.</div>
        </a>

        <!-- Azione: Torna al Negozio -->
        <a href="${pageContext.request.contextPath}/home" class="action-card">
            <div class="action-icon">
                <svg viewBox="0 0 24 24">
                    <path d="M10 20v-6h4v6h5v-8h3L12 3 2 12h3v8z"/>
                </svg>
            </div>
            <div class="action-title">Torna al Negozio</div>
            <div class="action-desc">Esci dall'area di amministrazione e torna alla home page pubblica dell'e-commerce per verificare i cambiamenti.</div>
        </a>
    </div>
</div>
<%@ include file="../partials/footer.jsp" %>
</body>
</html>
