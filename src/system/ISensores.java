package system;

public class ISensores {
	int id;
	int numSerie;

	public ISensores(int id, int numSerie) {
		this.id = id;
		this.numSerie = numSerie;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getNumSerie() {
		return numSerie;
	}

	public void setNumSerie(int numSerie) {
		this.numSerie = numSerie;
	};
	
}
