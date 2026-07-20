<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.Collection" %>
<%
  int cartCountHeader = 0;
  HttpSession sessionHeader = request.getSession(false);
  if (sessionHeader != null) {
      Collection<?> carrelloHeader = (Collection<?>) sessionHeader.getAttribute("carrello");
      if (carrelloHeader != null) {
          cartCountHeader = carrelloHeader.size();
      }
  }
%>
<style>
  @import url('https://fonts.googleapis.com/css2?family=Outfit:wght@300;400;500;600;700;800&display=swap');

  header.site-header {
    background: #FFFFFF !important;
    font-family: 'Outfit', sans-serif !important;
  }
  
  header.site-header .header-inner {
    max-width: 1200px !important;
    margin: 0 auto !important;
    padding: 0 32px !important;
    height: 84px !important;
  }
  
  header.site-header nav.main-nav {
    display: flex !important;
    gap: 36px !important;
    align-items: center !important;
    height: 100% !important;
  }
  
  header.site-header nav.main-nav a {
    font-family: 'Outfit', sans-serif !important;
    font-size: 14px !important;
    font-weight: 500 !important;
    letter-spacing: 0.06em !important;
    text-transform: uppercase !important;
    color: #2B2B2B !important;
    text-decoration: none !important;
    display: flex !important;
    align-items: center !important;
    height: 100% !important;
  }

  header.site-header nav.main-nav a.outlet {
    color: #C86A55 !important;
  }

  header.site-header nav.main-nav a.nav-home {
    font-weight: 600 !important;
  }
</style>
<header class="site-header">
  <div class="header-inner">
    <a href="<%= request.getContextPath() %>/home" class="logo"><span class="mark">GG<em>.</em></span><span class="sub">Eyewear</span></a>

    <nav class="main-nav">
      <a href="<%= request.getContextPath() %>/home" class="nav-home">Home</a>
      <a href="<%= request.getContextPath() %>/catalogo?tipo=sole">Occhiali da sole</a>
      <a href="<%= request.getContextPath() %>/catalogo?tipo=vista">Occhiali da vista</a>
      <a href="<%= request.getContextPath() %>/catalogo?outlet=true" class="outlet">Outlet</a>
    </nav>

    <div class="header-actions">
      <a href="<%= request.getContextPath() %>/area-utente" class="icon-btn" aria-label="Area utente">
        <img src="<%= request.getContextPath() %>/images/icons8-user-24.png" alt="Area Utente" style="width: 20px; height: 20px; object-fit: contain;" />
      </a>
      <a href="<%= request.getContextPath() %>/carrello" class="icon-btn" aria-label="Carrello">
        <img src="<%= request.getContextPath() %>/images/icons8-cart-24.png" alt="Carrello" style="width: 20px; height: 20px; object-fit: contain;" />
        <% if (cartCountHeader > 0) { %>
          <span class="cart-count" id="headerCartCount"><%= cartCountHeader %></span>
        <% } %>
      </a>
    </div>
  </div>
</header>
