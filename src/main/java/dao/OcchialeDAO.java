package dao;
import java.util.Collection;
import model.Occhiale;

public interface OcchialeDAO {

	void doSave(Occhiale occhiale) throws Exception;

	void doUpdate(Occhiale occhiale) throws Exception;

    boolean doDelete(int id) throws Exception;

    Occhiale doRetrieveByKey(int id) throws Exception;

    Collection<Occhiale> doRetrieveByAttivo(boolean attivo) throws Exception;

    Collection<Occhiale> doRetrieveAll(String order) throws Exception;

}
