package dao;


import java.sql.SQLException;
import java.util.Collection;
import model.Utente;
import model.Ruolo;

public interface UtenteDAO {
    
    public boolean doSave(Utente utente) throws SQLException;
    
    public boolean doUpdate(Utente utente) throws SQLException;
    
    public boolean doDelete(String email) throws SQLException;
    
    public Utente doRetrieveByKey(String email) throws SQLException;
    
    public Collection<Utente> doRetrieveByRuolo(Ruolo ruoloScelto) throws SQLException;
    
    public Collection<Utente> doRetrieveAll(String order) throws SQLException;
}
