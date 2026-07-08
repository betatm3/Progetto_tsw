package dao;
import java.util.Collection;
import model.Ordine;
import model.Stato; 
import model.Utente;

public interface OrdineDAO {

	void doSave(Ordine ordine) throws Exception;

	void doUpdate(Ordine ordine) throws Exception;

	boolean doDelete(int id) throws Exception;

	Ordine doRetrieveByKey(int id) throws Exception;

	Collection<Ordine> doRetrieveByUtente(Utente utente) throws Exception;

	Collection<Ordine> doRetrieveByStato(Stato stato) throws Exception;

	Collection<Ordine> doRetrieveAll(String order) throws Exception;
	
}

