package model;

public class Occhiale implements Cloneable{
	private int id;
	private boolean attivo;
	private byte[] immagine; // <-- NUOVO ATTRIBUTO PER IL BLOB

   	public Occhiale(int id, boolean attivo) {
		this.id = id;
		this.attivo = attivo;
	}
	
	public Occhiale() {
	}
	
	public int getId() {
		return id;
	}
	public boolean isAttivo() {
		return attivo;
	}
	public void setId(int id) {
		this.id = id;
	}
	public void setAttivo(boolean attivo) {
		this.attivo = attivo;
	}
	
    public byte[] getImmagine() {
        return immagine != null ? immagine.clone() : null;
    }

    public void setImmagine(byte[] immagine) {
        this.immagine = immagine != null ? immagine.clone() : null;
    }
    

    @Override
    public Occhiale clone(){
    	try {
            Occhiale cloned = (Occhiale) super.clone();
            if (this.immagine != null) {
                cloned.immagine = this.immagine.clone();
            }
             return cloned;
        } catch (CloneNotSupportedException e) {
            return null;
        }
    }

	@Override
	public String toString() {
		return getClass().getName()+" [id=" + id + ", attivo=" + attivo + "]";
	}
	
}
