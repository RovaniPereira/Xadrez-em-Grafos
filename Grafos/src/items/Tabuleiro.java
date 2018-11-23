package items;

import java.util.ArrayList;

import javax.swing.JOptionPane;

public class Tabuleiro {
	private Jogador players[]= new Jogador[2];
	private Peca pBranca[]= new Peca [16] ;
	private Peca pPreta[]= new Peca [16] ;
	private Casa tab[][]= new Casa [8][8];
	ArrayList<Aresta>art=new ArrayList<>();
	
	public void iniciar(){
		players[0]=new Jogador();
		players[1]=new Jogador();
		players[0].setNome(JOptionPane.showInputDialog("Insira seu nome"));
		players[1].setNome(JOptionPane.showInputDialog("Insira o nome do oponente"));
		players[0].setLife(1000);
		players[1].setLife(1000);
		players[0].setPecacor("Branca");;
		players[1].setPecacor("Preta");;
		
		for (int i=0;i<8;i++){
			for (int a=0;a<8;a++){
				int q=-1;
				if (i%2==0&&a%2==0||i%2==1&&a%2==1){
					tab[i][a].setCor("Preta");
				}else{
					tab[i][a].setCor("Branca");
				}
				
				if(i-1>=0){
					tab[i][a].getAdjacente()[q++]=tab[i-1][a];
					if(a+1<=7){
						tab[i][a].getAdjacente()[q++]=tab[i-1][a+1];
						tab[i][a].getAdjacente()[q++]=tab[i][a+1];
						if(a+2<=7){
							tab[i][a].getAdjacente()[q++]=tab[i-1][a+2];
						}
					}
					if(a-1>=0){
						tab[i][a].getAdjacente()[q++]=tab[i-1][a-1];
						tab[i][a].getAdjacente()[q++]=tab[i][a-1];
						if(a-2>=0){
							tab[i][a].getAdjacente()[q++]=tab[i-1][a-2];
						}
					}
				}
				if(i+1<=7){
					tab[i][a].getAdjacente()[q++]=tab[i+1][a];
					if(a+1<=7){
						tab[i][a].getAdjacente()[q++]=tab[i+1][a+1];
						if(a+2<=7){
							tab[i][a].getAdjacente()[q++]=tab[i+1][a+2];
						}
					}
					if(a-1>=0){
						tab[i][a].getAdjacente()[q++]=tab[i+1][a-1];
						if(a-2>=0){
							tab[i][a].getAdjacente()[q++]=tab[i+1][a-2];
						}
					}
				}
				if(i-2>=0){
					if(a-1>=0){
						tab[i][a].getAdjacente()[q++]=tab[i-2][a-1];
					}
					if(a+1<=7){
						tab[i][a].getAdjacente()[q++]=tab[i-2][a+1];
					}
				}
				if(i+2>=0){
					if(a-1>=0){
						tab[i][a].getAdjacente()[q++]=tab[i+2][a-1];
					}
					if(a+1<=7){
						tab[i][a].getAdjacente()[q++]=tab[i+2][a+1];
					}
				}
				
			}
		}
		for (int a=0; a<=1;a++){
			for (int i=0; i<=15; i++){
				if (a==0){
					if (i<=7){
						pBranca[i]=new Peca();
						pBranca[i].setNome("Peão");
						pBranca[i].setCor("Branca");
						pBranca[i].setScore(1);
						tab[1][i].setPeca(pBranca[i]);
					}
					if(i==8||i==15){
						pBranca[i]=new Peca();
						pBranca[i].setNome("Torre");
						pBranca[i].setCor("Branca");
						pBranca[i].setScore(10);
						tab[0][i].setPeca(pBranca[i]);
					}
					if(i==9||i==14){
						pBranca[i]=new Peca();
						pBranca[i].setNome("Cavalo");
						pBranca[i].setCor("Branca");
						pBranca[i].setScore(10);
						tab[0][i].setPeca(pBranca[i]);
					}
					if(i==10||i==13){
						pBranca[i]=new Peca();
						pBranca[i].setNome("Bispo");
						pBranca[i].setCor("Branca");
						pBranca[i].setScore(10);
						tab[0][i].setPeca(pBranca[i]);
					}
					if(i==11){
						pBranca[i]=new Peca();
						pBranca[i].setNome("Rainha");
						pBranca[i].setCor("Branca");
						pBranca[i].setScore(20);
						tab[0][i].setPeca(pBranca[i]);
					}
					if(i==12){
						pBranca[i]=new Peca();
						pBranca[i].setNome("Rei");
						pBranca[i].setCor("Branca");
						pBranca[i].setScore(1000);
						tab[0][i].setPeca(pBranca[i]);
					}
					
				}else{
					if (i<=7){
						pPreta[i]=new Peca();
						pPreta[i].setNome("Peão");
						pPreta[i].setCor("Preta");
						pPreta[i].setScore(1);
						tab[6][i].setPeca(pPreta[i]);
					}
					if(i==8||i==15){
						pPreta[i]=new Peca();
						pPreta[i].setNome("Torre");
						pPreta[i].setCor("Preta");
						pPreta[i].setScore(10);
						tab[7][i].setPeca(pPreta[i]);
					}
					if(i==9||i==14){
						pPreta[i]=new Peca();
						pPreta[i].setNome("Cavalo");
						pPreta[i].setCor("Preta");
						pPreta[i].setScore(10);
						tab[7][i].setPeca(pPreta[i]);
					}
					if(i==10||i==13){
						pPreta[i]=new Peca();
						pPreta[i].setNome("Bispo");
						pPreta[i].setCor("Preta");
						pPreta[i].setScore(10);
						tab[7][i].setPeca(pPreta[i]);
					}
					if(i==12){
						pPreta[i]=new Peca();
						pPreta[i].setNome("Rainha");
						pPreta[i].setCor("Preta");
						pPreta[i].setScore(20);
						tab[7][i].setPeca(pPreta[i]);
					}
					if(i==11){
						pPreta[i]=new Peca();
						pPreta[i].setNome("Rei");
						pPreta[i].setCor("Preta");
						pPreta[i].setScore(1000);
						tab[7][i].setPeca(pPreta[i]);
					}
				}
			}
		}
	}
	
	public Jogador[] getPlayers() {
		return players;
	}
	public void setPlayers(Jogador[] players) {
		this.players = players;
	}
	public Peca[] getpBranca() {
		return pBranca;
	}
	public void setpBranca(Peca[] pBranca) {
		this.pBranca = pBranca;
	}
	public Peca[] getpPreta() {
		return pPreta;
	}
	public void setpPreta(Peca[] pPreta) {
		this.pPreta = pPreta;
	}

	public Casa[][] getTab() {
		return tab;
	}

	public void setTab(Casa[][] tab) {
		this.tab = tab;
	}

}
