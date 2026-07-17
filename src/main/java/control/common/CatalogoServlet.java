package control.common;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Collection;
import java.util.ArrayList;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

import dao.VersioneOcchialeDAOImpl;
import dao.DisponibileDAOImpl;

import model.Disponibile;
import model.Occhiale;
import model.VersioneOcchiale;
import model.Tipologia;
import model.Genere;

// URL della servlet
@WebServlet("/catalogo")
public class CatalogoServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    @jakarta.annotation.Resource(name = "jdbc/ecommerce_db")
    private DataSource ds;
    
    
    protected void doGet(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {
        
        // 1. Istanziamo tutti i DAO che ci servono
        VersioneOcchialeDAOImpl versioneDAO = new VersioneOcchialeDAOImpl(ds);
        DisponibileDAOImpl disponibileDAO = new DisponibileDAOImpl(ds);
        
        // 2. Recupero dei parametri stringa inviati dal form di ricerca
        String genereStr = request.getParameter("genere");
        String materiale = request.getParameter("materiale");
        String forma = request.getParameter("forma");
        String marca = request.getParameter("marca");
        String colore = request.getParameter("colore");
        String taglia = request.getParameter("taglia");
        
        String prezzoMinStr = request.getParameter("prezzoMin");
        String prezzoMaxStr = request.getParameter("prezzoMax");

        // 3. Sanificazione delle stringhe: se vuote o composte solo da spazi, diventano null
        if (materiale != null && materiale.trim().isEmpty()) materiale = null;
        if (forma != null && forma.trim().isEmpty()) forma = null;
        if (marca != null && marca.trim().isEmpty()) marca = null;
        if (colore != null && colore.trim().isEmpty()) colore = null;
        if (taglia != null && taglia.trim().isEmpty()) taglia = null;

        // 4. Conversione del parametro Genere in Enum (se presente)
        Genere genere = null;
        if (genereStr != null && !genereStr.trim().isEmpty()) {
            try {
                genere = Genere.valueOf(genereStr.toUpperCase().trim());
            } catch (IllegalArgumentException e) {
                genere = null;
            }
        }

        // 5. Parsing sicuro dei prezzi Double (se inseriti)
        Double prezzoMin = null;
        if (prezzoMinStr != null && !prezzoMinStr.trim().isEmpty()) {
            try {
                prezzoMin = Double.parseDouble(prezzoMinStr);
            } catch (NumberFormatException e) {
                prezzoMin = null;
            }
        }

        Double prezzoMax = null;
        if (prezzoMaxStr != null && !prezzoMaxStr.trim().isEmpty()) {
            try {
                prezzoMax = Double.parseDouble(prezzoMaxStr);
            } catch (NumberFormatException e) {
                prezzoMax = null;
            }
        }

        try {
            // 6. Eseguiamo la ricerca avanzata passando tutti i parametri processati
            Collection<VersioneOcchiale> versioniFiltrate = versioneDAO.doRetrieveByFiltri(
                genere, materiale, forma, marca, colore, taglia, prezzoMin, prezzoMax);
            
            // 7. Costruiamo la lista di Occhiale da passare alla JSP
            Collection<Occhiale> listaOcchiali = new ArrayList<>();
            for (VersioneOcchiale versione : versioniFiltrate) {
                Occhiale occhiale = versione.getOcchiale();
                if (occhiale != null) {
                    occhiale.setVersioneCorrente(versione);
                    
                    // Cerca tutte le disponibilità di colore/quantità
                    Collection<Disponibile> listaDisponibilita = disponibileDAO.doRetrieveByOcchiale(occhiale.getId());
                    occhiale.setDisponibilita(listaDisponibilita);
                    
                    listaOcchiali.add(occhiale);
                }
            }

            // 8. Filtro categoriale per tipologia (DA_SOLE / DA_VISTA)
            String tipo = request.getParameter("tipo");
            if (tipo != null && !tipo.trim().isEmpty()) {
                Tipologia targetTipo = null;
                if (tipo.equalsIgnoreCase("sole")) {
                    targetTipo = Tipologia.DA_SOLE;
                } else if (tipo.equalsIgnoreCase("vista")) {
                    targetTipo = Tipologia.DA_VISTA;
                }
                
                if (targetTipo != null) {
                    final Tipologia finalTarget = targetTipo;
                    listaOcchiali.removeIf(occhiale -> occhiale.getTipo() != finalTarget);
                }
            }
            
            request.setAttribute("prodotti", listaOcchiali);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        
        // 9. Inoltro dei risultati alla pagina del catalogo
        RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/view/common/catalogo.jsp");
        dispatcher.forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {
        // Se qualcuno fa una richiesta POST su /catalogo, lo rimandiamo al GET
        doGet(request, response);
    }
}