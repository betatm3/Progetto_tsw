package model;

public class ProdottoAcquistato implements Cloneable{
    private int numero;
    private int ordineId;
    private int quantita;
    private int coloreCodice;
    private int versioneCodice;
    private int occhialeId;

    public ProdottoAcquistato(int numero, int occhialeId, int versioneCodice, int coloreCodice, int quantita, int ordineId) {
        this.numero = numero;
        this.occhialeId = occhialeId;
        this.versioneCodice = versioneCodice;
        this.coloreCodice = coloreCodice;
        this.quantita = quantita;
        this.ordineId = ordineId;
    }

    public ProdottoAcquistato() {
    }

    public int getNumero() {
        return numero;
    }

    public int getOcchialeId() {
        return occhialeId;
    }

    public int getVersioneCodice() {
        return versioneCodice;
    }

    public int getColoreCodice() {
        return coloreCodice;
    }

    public int getQuantita() {
        return quantita;
    }

    public int getOrdineId() {
        return ordineId;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public void setOcchialeId(int occhialeId) {
        this.occhialeId = occhialeId;
    }

    public void setQuantita(int quantita) {
        this.quantita = quantita;
    }

    public void setOrdineId(int ordineId) {
        this.ordineId = ordineId;
    }

    public void setColoreCodice(int coloreCodice) {
        this.coloreCodice = coloreCodice;
    }

    public void setVersioneCodice(int versioneCodice) {
        this.versioneCodice = versioneCodice;
    }

    @Override
    public ProdottoAcquistato clone(){
        try{
            return (ProdottoAcquistato) super.clone();
        } catch (CloneNotSupportedException e) {
            return null;
        }
    }

    @Override
    public String toString() {
        return getClass().getName()+"[" +
                "numero=" + numero +
                ", ordineId=" + ordineId +
                ", quantita=" + quantita +
                ", coloreCodice=" + coloreCodice +
                ", versioneCodice=" + versioneCodice +
                ", occhialeId=" + occhialeId +
                ']';
    }
}
