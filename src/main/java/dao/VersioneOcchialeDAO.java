package dao;
import java.util.Collection;
import model.VersioneOcchiale;
import model.Genere;
import model.Occhiale;

public interface VersioneOcchialeDAO {

	void doSave(VersioneOcchiale versione) throws Exception;

    void doUpdate(VersioneOcchiale versione) throws Exception;

    boolean doDelete(int codice) throws Exception;

    VersioneOcchiale doRetrieveByKey(int codice) throws Exception;

    Collection<VersioneOcchiale> doRetrieveByOcchiale(Occhiale occhiale) throws Exception;

    Collection<VersioneOcchiale> doRetrieveByGenere(Genere genere) throws Exception;

    Collection<VersioneOcchiale> doRetrieveByTaglia(String taglia) throws Exception;

    Collection<VersioneOcchiale> doRetrieveByMontatura(String montatura) throws Exception;

    Collection<VersioneOcchiale> doRetrieveByForma(String forma) throws Exception;

    Collection<VersioneOcchiale> doRetrieveByMateriale(String materiale) throws Exception;

    Collection<VersioneOcchiale> doRetrieveByPrezzo(double prezzo) throws Exception;

    Collection<VersioneOcchiale> doRetrieveByFasciaPrezzo(double prezzoMin, double prezzoMax) throws Exception;

    Collection<VersioneOcchiale> doRetrieveByCorrente(boolean corrente) throws Exception;

    Collection<VersioneOcchiale> doRetrieveAll(String order) throws Exception;

}
