package model;

public class Occhiale implements Cloneable{
	private int id;
	private boolean attivo;
	
	
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

    @Override
    public Occhiale clone(){
        try{
            return (Occhiale) super.clone();
        } catch (CloneNotSupportedException e) {
            return null;
        }
    }

	@Override
	public String toString() {
		return getClass().getName()+" [id=" + id + ", attivo=" + attivo + "]";
	}
	
}
