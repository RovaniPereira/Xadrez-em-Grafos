package items;

public class Casa {
	private String cor;
	private Peca peca;
	
	private Casa adjacente[]=new Casa[16];
	
	public String getCor() {
		return cor;
	}
	public void setCor(String cor) {
		this.cor = cor;
	}
	public Peca getPeca() {
		return peca;
	}
	public void setPeca(Peca peca) {
		this.peca = peca;
	}
	public Casa[] getAdjacente() {
		return adjacente;
	}
	public void setAdjacente(Casa[] adjacente) {
		this.adjacente = adjacente;
	}

}
