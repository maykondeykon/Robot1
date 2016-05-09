package Robox1;

public class Main {

	public static void main(String[] args) {
		Matrix matrix = new Matrix(5, 5);

		Celula c1 = new Celula();
		c1.setItem(new Robo());
		matrix.setCelula(c1, 1, 1);

		Celula c2 = new Celula();
		c2.setItem(new Caixa());
		matrix.setCelula(c2, 1, 2);

		Celula c5 = new Celula();
		c5.setItem(new Caixa());
		matrix.setCelula(c5, 2, 1);

		Celula c6 = new Celula();
		c6.setItem(new Caixa());
		matrix.setCelula(c6, 2, 3);

		Celula c7 = new Celula();
		c7.setItem(new Caixa());
		matrix.setCelula(c7, 3, 2);

		int x = 2;
		int y = 2;

		if (matrix.getCelula(x, y) != null) {
			// System.out.println(matrix.getCelula(x, y).getItem());
		} else {
			System.out.println("vazio");
		}

		// System.out.println(matrix.getPosicaoRobo()[1]);

		Matrix m2 = new Matrix(5, 5);

		Celula c3 = new Celula();
		c3.setItem(new Caixa());
		m2.setCelula(c3, 1, 2);

		Celula c4 = new Celula();
		c4.setItem(new Robo());
		// m2.setCelula(c4,2,2);

		// System.out.println(matrix.igual(m2));

		int[] pRobo = matrix.getPosicaoRobo();

		// Celula cel = matrix.getCelula(pRobo[0]-1, pRobo[1]);
		Celula[] vizinhos = matrix.getVizinhos(pRobo[0], pRobo[1]);
		for (int i = 0; i < vizinhos.length; i++) {
			if (vizinhos[i] != null) {
				// System.out.println(vizinhos[i].getItem()+" - "+
				// vizinhos[i].getPosicao()[0] + "," +
				// vizinhos[i].getPosicao()[1]);
				if (vizinhos[i].getItem() instanceof Caixa) {
					int xC = vizinhos[i].getPosicao()[0];
					int yC = vizinhos[i].getPosicao()[1];
					System.out.println("Caixa na posição " + xC + "," + yC);

					Celula[] vCaixa = matrix.getVizinhos(xC, yC);
					
					for (int j = 0; j < vCaixa.length; j++) {
						if (vCaixa[j] != null) {
							System.out.println(vCaixa[j].getItem() + " - " + vCaixa[j].getPosicao()[0] + ","
									+ vCaixa[j].getPosicao()[1]);
						}
					}
				}
			}
		}

		// System.out.println(matrix.celulaValida(pRobo[0], pRobo[1]));

	}

}
