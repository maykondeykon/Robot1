package Robox1;

import interfaces.Estado;

public class Matrix implements Estado {
	private Celula[][] celula;
	private int posRobo[] = new int[2];

	public Matrix(int x, int y) {
		this.celula = new Celula[x][y];
	}

	public Celula getCelula(int x, int y) {
		if (this.celulaValida(x, y)) {
			if (celula[x][y] != null) {
				return celula[x][y];
			}else{
				Celula c = new Celula();
				c.setPosicao(x, y);
				return c;
			}
			
		}
		return null;
	}

	public Celula[][] getCelulas() {
		return celula;
	}

	public Celula[] getVizinhos(int x, int y) {

		Celula[] cel = new Celula[4];
		cel[0] = this.getCelula(x + 1, y);
		cel[1] = this.getCelula(x - 1, y);
		cel[2] = this.getCelula(x, y + 1);
		cel[3] = this.getCelula(x, y - 1);

		return cel;
	}

	public int getX() {
		return this.celula.length;
	}

	public int getY() {
		return this.celula[celula.length - 1].length;
	}

	public void setCelula(Celula celula, int x, int y) {
		if (this.celulaValida(x, y)) {
			if (celula != null) {
				if (celula.getItem() instanceof Robo) {
					posRobo[0] = x;
					posRobo[1] = y;
				}
				this.celula[x][y] = celula;
				celula.setPosicao(x, y);
			}
		}
	}

	public String getTamanho() {
		return this.getX() + "," + this.getY();
	}

	public Robo getRobo() {
		return (Robo) this.getCelula(posRobo[0], posRobo[1]).getItem();
	}

	public int[] getPosicaoRobo() {
		return posRobo;
	}

	public boolean celulaValida(int x, int y) {
		boolean assert1 = (x > -1) && (x <= this.getX() -1);
		boolean assert2 = (y > -1) && (y <= this.getY() -1);

		if (assert1 && assert2) {
			return true;
		}
		return false;
	}

	@Override
	public boolean estadoValido() {
		int xLength = this.getX();
		int yLength = this.getY();

		boolean assert1 = (xLength > 0 && yLength > 0);
		return assert1;
	}

	@Override
	public boolean igual(Estado e) {
		boolean assert1 = e.estadoValido(); // se é válido
		boolean assert2 = false;
		boolean assert3 = false;
		int totalItens = 0;
		int itensIguais = 0;

		if (assert1) { // se tem o mesmo tamanho
			int xL = ((Matrix) e).getX();
			int yL = ((Matrix) e).getY();
			if ((xL == this.getX()) && (yL == this.getY())) {
				assert2 = true;
			}
		}

		if (assert1 && assert2) { // se possuem os mesmos itens
			// System.out.println("mesmo tamanho");

			for (int i = 0; i < this.getX(); i++) {
				for (int j = 0; j < this.getY(); j++) {
					if (this.getCelula(i, j) != null) {
						totalItens++;
						if (((Matrix) e).getCelula(i, j) != null) {
							if (this.getCelula(i, j).getItem()
									.getClass() == (((Matrix) e).getCelula(i, j).getItem().getClass())) {
								// System.out.println(this.getCelula(i,
								// j).getItem() + " - posição ["+ i +","+
								// j+"]");
								itensIguais++;
							}
						}
					}
				}
			}

			assert3 = (totalItens == itensIguais);

		} else {
			assert3 = false;
		}

		// System.out.println("Total itens = "+totalItens+" itens iguais =
		// "+itensIguais);
		// System.out.println(assert3);

		if (assert1 && assert2 && assert3) {
			return true;
		}

		return false;
	}

}
