package model;

import java.time.LocalDateTime;

public class Ordine implements Cloneable{
	private int id;
	private String metodoPagamento;
	private LocalDateTime dataOrdine;
	private Stato stato;
	private double totale;
	private String emailUtente;
	
	
	public Ordine(int id, String metodoPagamento, LocalDateTime dataOrdine, Stato stato, double totale,
			String emailUtente) {
		this.id = id;
		this.metodoPagamento = metodoPagamento;
		this.dataOrdine = dataOrdine;
		this.stato = stato;
		this.totale = totale;
		this.emailUtente = emailUtente;
	}
	
	public Ordine() {
	}
	
	public int getId() {
		return id;
	}
	public String getMetodoPagamento() {
		return metodoPagamento;
	}
	public LocalDateTime getDataOrdine() {
		return dataOrdine;
	}
	public Stato getStato() {
		return stato;
	}
	public double getTotale() {
		return totale;
	}
	public String getEmailUtente() {
		return emailUtente;
	}
	public void setId(int id) {
		this.id = id;
	}
	public void setMetodoPagamento(String metodoPagamento) {
		this.metodoPagamento = metodoPagamento;
	}
	public void setDataOrdine(LocalDateTime dataOrdine) {
		this.dataOrdine = dataOrdine;
	}
	public void setStato(Stato stato) {
		this.stato = stato;
	}
	public void setTotale(double totale) {
		this.totale = totale;
	}
	public void setEmailUtente(String emailUtente) {
		this.emailUtente = emailUtente;
	}

    @Override
    public Ordine clone(){
        try{
            return (Ordine) super.clone();
        } catch (CloneNotSupportedException e) {
            return null;
        }
    }

	@Override
	public String toString() {
		return getClass().getName()+"[id=" + id + ", metodoPagamento=" + metodoPagamento + ", dataOrdine=" + dataOrdine + ", stato="
				+ stato + ", totale=" + totale + ", emailUtente=" + emailUtente + "]";
	}

}
