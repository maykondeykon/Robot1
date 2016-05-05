package Robox1;

public class Main {

	public static void main(String[] args) {
		Matrix matrix = new Matrix(5,5);
		
		Celula c1 = new Celula();
		c1.setItem(new Robo());
		matrix.setCelula(c1,2,2);
		
		Celula c2 = new Celula();
		c2.setItem(new Caixa());
		matrix.setCelula(c2, 1, 2);
		
		int x = 2;
		int y = 2;
		
		if(matrix.getCelula(x, y) != null){
//			System.out.println(matrix.getCelula(x, y).getItem());
		}else{
			System.out.println("vazio");
		}
		
//		System.out.println(matrix.getPosicaoRobo()[1]);
		
		Matrix m2 = new Matrix(5, 5);
		
		Celula c3 = new Celula();
		c3.setItem(new Caixa());
		m2.setCelula(c3, 1, 2);
		
		Celula c4 = new Celula();
		c4.setItem(new Robo());
//		m2.setCelula(c4,2,2);
		
		System.out.println(matrix.igual(m2));
		

	}

}
