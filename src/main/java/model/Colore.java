package model;

public class Colore implements  Cloneable{
	private String codice;
	private String nome;
	
	public Colore(String codice, String nome) {
		this.codice = codice;
		this.nome = nome;
	}
	
	public Colore() {
	}
	
	public String getCodice() {
		return codice;
	}
	public String getNome() {
		return nome;
	}
	public void setCodice(String codice) {
		this.codice = codice;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}

    @Override
    public Colore clone(){
        try{
            return (Colore) super.clone();
        } catch (CloneNotSupportedException e) {
            return null;
        }
    }

	@Override
	public String toString() {
		return getClass().getName()+"[codice=" + codice + ", nome=" + nome + "]";
	}

}
