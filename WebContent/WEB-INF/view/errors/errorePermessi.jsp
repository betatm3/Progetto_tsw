<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="it">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Accesso Negato - GG Eyewear</title>
    
    <!-- Font Premium da Google Fonts -->
    <link rel="preconnect" href="https://fonts.googleapis.com">
    <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
    <link href="https://fonts.googleapis.com/css2?family=Outfit:wght@300;400;600;700;800&display=swap" rel="stylesheet">
    
    <link rel="stylesheet" href="<%= request.getContextPath() %>/styles/comune.css">
    <link rel="stylesheet" href="<%= request.getContextPath() %>/styles/errorePermessi.css">
</head>
<body>
<%@ include file="../partials/header.jsp" %>
<div class="error-card">
    <div class="error-icon">
        <!-- Icona Lucchetto Chiuso Premium -->
        <svg viewBox="0 0 24 24">
            <path d="M18 8h-1V6c0-2.76-2.24-5-5-5S7 3.24 7 6v2H6c-1.1 0-2 .9-2 2v10c0 1.1.9 2 2 2h12c1.1 0 2-.9 2-2V10c0-1.1-.9-2-2-2zm-6 9c-1.1 0-2-.9-2-2s.9-2 2-2 2 .9 2 2-.9 2-2 2zm3.1-9H8.9V6c0-1.71 1.39-3.1 3.1-3.1 1.71 0 3.1 1.39 3.1 3.1v2z"/>
        </svg>
    </div>

    <h1>Accesso Negato</h1>
    
    <div class="error-message">
        <% 
            String msg = (String) request.getAttribute("messaggioErrore");
            if (msg == null || msg.trim().isEmpty()) {
                msg = "Non hai le autorizzazioni necessarie per visualizzare questa pagina.";
            }
        %>
        <%= msg %>
    </div>

    <div class="actions">
        <a href="${pageContext.request.contextPath}/home" class="btn-home">Torna alla Home</a>
        <a href="${pageContext.request.contextPath}/login" class="btn-login">Effettua il Login</a>
    </div>
</div>
<%@ include file="../partials/footer.jsp" %>
</body>
</html>
