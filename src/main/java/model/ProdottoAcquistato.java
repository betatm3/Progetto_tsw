package model;

public class ProdottoAcquistato implements Cloneable{
    private int numero;
    private Ordine ordine;
    private int quantita;
    private Colore colore;
    private VersioneOcchiale versioneOcchiale;
    private Occhiale occhiale;

    public ProdottoAcquistato(int numero, Occhiale occhiale, VersioneOcchiale versioneOcchiale, Colore colore, int quantita, Ordine ordine) {
        this.numero = numero;
        this.occhiale = occhiale.clone();
        this.versioneOcchiale = versioneOcchiale.clone();
        this.colore = colore.clone();
        this.quantita = quantita;
        this.ordine = ordine.clone();
    }

    public ProdottoAcquistato() {
    }

    public int getNumero() {
        return numero;
    }

    public Occhiale getOcchiale() {
        return occhiale.clone();
    }

    public VersioneOcchiale getVersioneOcchiale() {
        return versioneOcchiale.clone();
    }

    public Colore getColore() {
        return colore.clone();
    }

    public int getQuantita() {
        return quantita;
    }

    public Ordine getOrdine() {
        return ordine.clone();
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public void setOcchiale(Occhiale occhiale) {
        this.occhiale = occhiale.clone();
    }

    public void setQuantita(int quantita) {
        this.quantita = quantita;
    }

    public void setOrdine(Ordine ordine) {
        this.ordine = ordine.clone();
    }

    public void setColore(Colore colore) {
        this.colore = colore.clone();
    }

    public void setVersioneOcchiale(VersioneOcchiale versioneOcchiale) {
        this.versioneOcchiale = versioneOcchiale.clone();
    }

    @Override
    public ProdottoAcquistato clone(){
        try{
        	ProdottoAcquistato cloned = (ProdottoAcquistato) super.clone();
        	if(occhiale!=null)	cloned.occhiale=occhiale.clone();
        	else	cloned.occhiale = null;
        	
        	if(ordine!=null)	cloned.ordine=ordine.clone();
        	else	cloned.ordine = null;
        	
        	if(colore!=null)	cloned.colore=colore.clone();
        	else	cloned.colore = null;
        	
        	if(versioneOcchiale!=null)	cloned.versioneOcchiale=versioneOcchiale.clone();
        	else	cloned.versioneOcchiale = null;
        	
        	return cloned;
        } catch (CloneNotSupportedException e) {
            return null;
        }
    }

    @Override
    public String toString() {
        return getClass().getName()+"[" +
                "numero=" + numero +
                ", ordine=" + ordine +
                ", quantita=" + quantita +
                ", colore=" + colore +
                ", versioneOcchiale=" + versioneOcchiale +
                ", occhiale=" + occhiale +
                ']';
    }
}
