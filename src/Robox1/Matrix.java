package Robox1;

import interfaces.Estado;

public class Matrix implements Estado{
	private Celula[][] celula;
	private int posRobo[] = new int[2]; 
	
	public Matrix(int x, int y) {
		this.celula = new Celula[x][y];
	}

	public Celula getCelula(int x, int y) {
		return celula[x][y];
	}
	
	public Celula[][] getCelulas() {
		return celula;
	}
	
	public void setCelula(Celula celula, int x, int y) {
		if (celula.getItem() instanceof Robo) {
			posRobo[0] = x;
			posRobo[1] = y;
		}
		this.celula[x][y] = celula;
	}
	
	public String getTamanho()
	{
		return this.celula.length +","+ this.celula[celula.length-1].length;
	}
	
	public Robo getRobo(){
		return (Robo) this.getCelula(posRobo[0], posRobo[1]).getItem();
	}
	
	public int[] getPosicaoRobo() {
		return posRobo;
	}

	@Override
	public boolean estadoValido() {
		int xLength = this.celula.length;
		int yLength = this.celula[celula.length-1].length;
		
		boolean assert1 = (xLength > 0 && yLength > 0);
		return assert1;
	}

	@Override
	public boolean igual(Estado e) {
		boolean assert1 = e.estadoValido();
		if (assert1) {
			
		}
		return false;
	}

}
