package model;

public class Disponibile implements Cloneable{
	private Colore colore;
	private Occhiale occhiale;
	private int quantita;
	
	public Disponibile(Colore colore, Occhiale occhiale, int quantita) {
		this.colore = colore;
		this.occhiale = occhiale;
		this.quantita = quantita;
	}
	
	public Disponibile() {
	}

	public Colore getColore() {
		return colore.clone();
	}

	public Occhiale getOcchiale() {
		return occhiale.clone();
	}

	public int getQuantita() {
		return quantita;
	}

	public void setColore(Colore colore) {
		this.colore = colore.clone();
	}

	public void setOcchiale(Occhiale occhiale) {
		this.occhiale = occhiale.clone();
	}

	public void setQuantita(int quantita) {
		this.quantita = quantita;
	}

	
	
	@Override
	protected Object clone(){
		try{
        	Disponibile cloned = (Disponibile) super.clone();
        	if(colore!=null)   		cloned.colore = colore.clone();
        	else	cloned.colore=null;
        	
        	if(occhiale!=null)	cloned.occhiale = occhiale.clone();
        	else	cloned.occhiale = null;
        	
        	return cloned;
        } catch (CloneNotSupportedException e) {
            return null;
        }
	}

	@Override
	public String toString() {
		return getClass().getName()+"[colore=" + colore + ", occhiale=" + occhiale + ", quantita=" + quantita + "]";
	}

}