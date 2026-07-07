package model;
public class VersioneOcchiale implements Cloneable{
    private int codVersione;
    private Genere genere;
    private String taglia;
    private String montatura;
    private String forma;
    private String materiale;
    private double prezzo;
    private boolean corrente;
    private int occhialeId;

    public VersioneOcchiale(int codVersione, Genere genere, String taglia, String montatura, String forma, String materiale, double prezzo, int occhialeId) {
        this.codVersione = codVersione;
        this.genere = genere;
        this.taglia = taglia;
        this.montatura = montatura;
        this.forma = forma;
        this.materiale = materiale;
        this.prezzo = prezzo;
        this.corrente = true;
        this.occhialeId = occhialeId;
    }

    public VersioneOcchiale() {
    }

    public void setCodVersione(int codVersione) {
        this.codVersione = codVersione;
    }

    public void setGenere(Genere genere) {
        this.genere = genere;
    }

    public void setTaglia(String taglia) {
        this.taglia = taglia;
    }

    public void setMontatura(String montatura) {
        this.montatura = montatura;
    }

    public void setForma(String forma) {
        this.forma = forma;
    }

    public void setPrezzo(double prezzo) {
        this.prezzo = prezzo;
    }

    public void setCorrente(boolean corrente) {
        this.corrente = corrente;
    }

    public void setMateriale(String materiale) {
        this.materiale = materiale;
    }

    public void setOcchialeId(int occhialeId) {
        this.occhialeId = occhialeId;
    }

    public Genere getGenere() {
        return genere;
    }

    public int getCodVersione() {
        return codVersione;
    }

    public String getTaglia() {
        return taglia;
    }

    public String getMontatura() {
        return montatura;
    }

    public String getForma() {
        return forma;
    }

    public String getMateriale() {
        return materiale;
    }

    public double getPrezzo() {
        return prezzo;
    }

    public boolean isCorrente() {
        return corrente;
    }

    public int getOcchialeId() {
        return occhialeId;
    }

    @Override
    public VersioneOcchiale clone(){
        try{
            return (VersioneOcchiale) super.clone();
        } catch (CloneNotSupportedException e) {
            return null;
        }
    }

    @Override
    public String toString() {
        return getClass().getName()+"[" +
                "codVersione=" + codVersione +
                ", genere=" + genere +
                ", taglia='" + taglia  +
                ", montatura='" + montatura  +
                ", forma='" + forma +
                ", materiale='" + materiale +
                ", prezzo=" + prezzo +
                ", corrente=" + corrente +
                ", occhialeId=" + occhialeId +
                ']';
    }
}
