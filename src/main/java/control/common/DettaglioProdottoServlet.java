package control.common;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Collection;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

import dao.OcchialeDAOImpl;
import dao.VersioneOcchialeDAOImpl;
import dao.DisponibileDAOImpl;
import dao.ColoreDAOImpl;

import model.Occhiale;
import model.VersioneOcchiale;
import model.Disponibile;
import model.Colore;

@WebServlet("/dettaglio")
public class DettaglioProdottoServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    @jakarta.annotation.Resource(name = "jdbc/ecommerce_db")
    private DataSource ds;

    protected void doGet(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {
        
        String idStr = request.getParameter("id");
        if (idStr == null || idStr.trim().isEmpty()) {
            response.sendRedirect(request.getContextPath() + "/catalogo");
            return;
        }

        int id;
        try {
            id = Integer.parseInt(idStr);
        } catch (NumberFormatException e) {
            response.sendRedirect(request.getContextPath() + "/catalogo");
            return;
        }

        OcchialeDAOImpl occhialeDAO = new OcchialeDAOImpl(ds);
        VersioneOcchialeDAOImpl versioneDAO = new VersioneOcchialeDAOImpl(ds);
        DisponibileDAOImpl disponibileDAO = new DisponibileDAOImpl(ds);
        ColoreDAOImpl coloreDAO = new ColoreDAOImpl(ds);

        try {
            Occhiale occhiale = occhialeDAO.doRetrieveByKey(id);
            
            if (occhiale != null && occhiale.isAttivo()) {
                // Recupera versione commerciale corrente
                VersioneOcchiale versioneCorrente = versioneDAO.doRetrieveCorrenteByOcchiale(id);
                occhiale.setVersioneCorrente(versioneCorrente);

                // Recupera le disponibilità colore/quantità
                Collection<Disponibile> listaDisponibilita = disponibileDAO.doRetrieveByOcchiale(id);
                
                // Popoliamo il nome del colore per ciascuna disponibilità
                if (listaDisponibilita != null) {
                    for (Disponibile disp : listaDisponibilita) {
                        if (disp.getColore() != null && disp.getColore().getCodice() != null) {
                            Colore coloreCompleto = coloreDAO.doRetrieveByKey(disp.getColore().getCodice());
                            if (coloreCompleto != null) {
                                disp.setColore(coloreCompleto);
                            }
                        }
                    }
                }
                
                occhiale.setDisponibilita(listaDisponibilita);

                // Passiamo l'oggetto completo di dettagli alla JSP
                request.setAttribute("prodotto", occhiale);

                RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/view/common/dettaglioProdotto.jsp");
                dispatcher.forward(request, response);
            } else {
                // Prodotto inesistente o non attivo, torniamo al catalogo
                response.sendRedirect(request.getContextPath() + "/catalogo");
            }
        } catch (SQLException e) {
            e.printStackTrace();
            response.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, "Errore nel caricamento del prodotto dal database.");
        }
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {
        doGet(request, response);
    }
}
