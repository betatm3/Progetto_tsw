package model;

import java.util.ArrayList;
import java.util.Collection;

public class Occhiale implements Cloneable{
	private int id;
	private boolean attivo;
	private Tipologia tipo;
	private ArrayList<String> immagini;
	private VersioneOcchiale versioneCorrente; 
	private Collection<Disponibile> disponibilita; 

	
   	public Occhiale(int id, boolean attivo, Tipologia tipo, ArrayList<String> immagini, VersioneOcchiale versioneCorrente,
			Collection<Disponibile> disponibilita) {
		this.id = id;
		this.attivo = attivo;
		this.tipo = tipo;
		this.immagini = immagini;
		this.versioneCorrente = versioneCorrente.clone();
		this.disponibilita = disponibilita;
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
	
    public String getImmagine(int i) {
    	if (immagini != null && i >= 0 && i < immagini.size()) {
            return immagini.get(i);
        }
        return null;
    }

    public void addImmagine(String img) {
    	if (this.immagini == null) {
            this.immagini = new ArrayList<>();
        }
        if (img != null && !img.trim().isEmpty()) {
            this.immagini.add(img);
        }
    }
    
    public ArrayList<String> getImmagini(){
    	return this.immagini;
    }

    public void setImmagini(ArrayList<String> immagini) {
    	this.immagini = immagini;
    }
    
    public Tipologia getTipo() {
		return tipo;
	}

	public void setTipo(Tipologia tipo) {
		this.tipo = tipo;
	}

	public VersioneOcchiale getVersioneCorrente() {
		return versioneCorrente.clone();
	}

	public Collection<Disponibile> getDisponibilita() {
		if (this.disponibilita == null) {
	        return null;
	    }
	    
	    Collection<Disponibile> copia = new java.util.ArrayList<>();
	    for (Disponibile disp : this.disponibilita) {
	        if (disp != null) {
	            copia.add((Disponibile) disp.clone());
	        } else {
	            copia.add(null);
	        }
	    }
	    return copia;
	}

	public void setVersioneCorrente(VersioneOcchiale versioneCorrente) {
	    if (versioneCorrente != null) {
	        this.versioneCorrente = (VersioneOcchiale) versioneCorrente.clone();
	    } else {
	        this.versioneCorrente = null;
	    }
	}

	public void setDisponibilita(Collection<Disponibile> disponibilita) {
			if (disponibilita == null) {
		        this.disponibilita = null;
		        return;
		    }
		    
		    Collection<Disponibile> copia = new java.util.ArrayList<>();
		    for (Disponibile disp : disponibilita) {
		        if (disp != null) {
		            copia.add((Disponibile) disp.clone()); 
		        } else {
		            copia.add(null);
		        }
		    }
		    this.disponibilita = copia;
	}

	@Override
    public Occhiale clone(){
    	try {
            Occhiale cloned = (Occhiale) super.clone();
            if (this.immagini != null) {
                cloned.immagini = new ArrayList<>(this.immagini);
            }

            if (this.versioneCorrente != null) {
                cloned.versioneCorrente = this.versioneCorrente.clone();
            }
            
            if (this.disponibilita != null) {
                ArrayList<Disponibile> clonedDisp = new ArrayList<>();
                for (Disponibile disp : this.disponibilita) {
                    if (disp != null) {
                        clonedDisp.add((Disponibile) disp.clone());
                    } else {
                        clonedDisp.add(null);
                    }
                }
                cloned.disponibilita = clonedDisp;
            }
            return cloned;
        } catch (CloneNotSupportedException e) {
            return null;
        }
    }

	@Override
	public String toString() {
		return getClass().getName()+" [id = " + id + ", attivo = " + attivo + ", tipo = "+tipo+ ",immagini = " + immagini+ ", versioneCorrente = "+versioneCorrente+", disponibilita = " + disponibilita+ "]";
	}
	
}
