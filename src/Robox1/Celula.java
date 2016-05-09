package Robox1;

public class Celula {
	private Item item;
	private int posicao[] = new int[2];
	
	public Item getItem() {
		return item;
	}
	public void setItem(Item item) {
		this.item = item;
	}
	public int[] getPosicao() {
		return posicao;
	}
	public void setPosicao(int x, int y) {
		this.posicao[0] = x;
		this.posicao[1] = y;
	}
	

}
