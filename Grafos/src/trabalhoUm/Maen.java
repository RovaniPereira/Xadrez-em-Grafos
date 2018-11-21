package trabalhoUm;

import java.util.ArrayList;

import javax.swing.JOptionPane;

public class Maen {
	public static String listarLista(ArrayList <Aresta> ar, ArrayList<Integer> vl){
		String s="";
		for(int i=0;i<=ar.size();i++){
			s+="("+ar.get(i).src.id+"),"+ar.get(i).dst.id+")|"+vl.get(i)+"|\n";
		}
		JOptionPane.showMessageDialog(null, s);
		return s;
	}
	public static String listarMtzAdj(int mat[][], int v){
		String s="";
		for(int i=0;i<v;i++){
			for(int j=0;j<v;j++){
				if(j!=(v-1)){
					s+=mat[i][j]+".";
				}else
					s+=mat[i][j]+"\n";
			}
		}
		System.out.println(s);
		JOptionPane.showMessageDialog(null, s);
		return s;
	}
	
	public static String listarMtzArs(int mat[][], int a, int v){
		String s="";
		for(int i=0;i<v;i++){
			for(int j=0;j<a;j++){
				if(j!=(a-1)){
					s+=mat[i][j]+".";
				}else
					s+=mat[i][j]+"\n";
			}
		}
		System.out.println(s);
		JOptionPane.showMessageDialog(null, s);
		return s;
	}

	public static void main(String[] args) {
		
		boolean valorado=false;
		boolean direcionado=false;
		ArrayList<Vertice> vertices = new ArrayList<Vertice>();
		ArrayList<Aresta> arestas = new ArrayList<Aresta>();
		ArrayList<Integer> listaValores = new ArrayList<Integer>();

		String V="";
		String E="";
		
		int a = Integer.parseInt(JOptionPane.showInputDialog("Eh um grafo valorado?"));
		if (a==2)
			valorado=true;
		
		a = Integer.parseInt(JOptionPane.showInputDialog("Eh um grafo Direcionado?"));
		if (a==2)
			direcionado=true;
		
		int v= Integer.parseInt(JOptionPane.showInputDialog("Numero de vertices"));
		ArrayList<ArrayList<Vertice>>listliga=new ArrayList<>();
		for(int b=0;b<v;b++){
			Vertice ve = new Vertice();
			ve.id=b+1;
			vertices.add(ve);
			
			V+=ve.id+",";
			
			listliga.add(new ArrayList<>());
		}
		
		int matAdj[][]=new int [v][v];
		
		V="{"+V+"}";
		
		String listagem="";
		for(int b=1;b<=v;b++){
			listagem+="("+b+") \n";
		}
		
		
		if((!valorado&&!direcionado)||(!valorado&&direcionado)){
			int vsel1=1;
			
			while(vsel1!=0){
				boolean haaresta=false;
				vsel1=Integer.parseInt(JOptionPane.showInputDialog("Selecione o vertice que deseja ligar a um "
						+ "vertice posterior\n\n"+listagem+"(0) Para SAIR"));
				if(vsel1!=0){
					int vsel2=Integer.parseInt(JOptionPane.showInputDialog("Selecione o vertice que deseja ligar "
							+ "com uma aresta\n\n"+listagem+"(0) Para Voltar"));
					
						if(vsel2!=0){
							
							Aresta ar = new Aresta();
							ar.src=vertices.get((vsel1-1));
							ar.dst=vertices.get((vsel2-1));
							arestas.add(ar);
							E+="{"+ar.src.id+","+ar.dst.id+"}";
							
							matAdj[vsel1-1][vsel2-1]++;
							listaValores.add(1);
						}
				}
				
			}
			E="{"+E+"}";
			JOptionPane.showMessageDialog(null, "E:"+E+"\n"+"V:"+V);

		}
		if((valorado&&!direcionado)||(valorado&&direcionado)){
			int vsel1=1;
			int valor=0;
			boolean haaresta=false;
			
			while(vsel1!=0){
				vsel1=Integer.parseInt(JOptionPane.showInputDialog("Selecione o vertice que deseja ligar a um "
						+ "vertice posterior\n\n"+listagem+"(0) Para SAIR"));
				if(vsel1!=0){
					int vsel2=Integer.parseInt(JOptionPane.showInputDialog("Selecione o vertice que deseja ligar "
							+ "com uma aresta\n\n"+listagem+"(0) Para Voltar"));
					if(vsel2!=0){
						if(!direcionado){
							for(int b=0;b<arestas.size();b++){
								if(arestas.get(b).src.id==vsel1&&arestas.get(b).dst.id==vsel2
										|| arestas.get(b).src.id==vsel2&&arestas.get(b).dst.id==vsel1)
									haaresta=true;
								if(haaresta)
									JOptionPane.showMessageDialog(null, "Não é possivel criar grafo Valorado e multigrafo simultaneamente");
							}
						}else{
							for(int b=0;b<arestas.size();b++){
								if(arestas.get(b).src.id==vsel1&&arestas.get(b).dst.id==vsel2)
									haaresta=true;
								if(haaresta)
									JOptionPane.showMessageDialog(null, "Não é possivel criar grafo Valorado e multigrafo simultaneamente");
							}
							
						}
						if(!haaresta){
							valor=Integer.parseInt(JOptionPane.showInputDialog("Valor dessa Aresta"));
							Aresta ar = new Aresta();
							ar.src=vertices.get((vsel1-1));
							ar.dst=vertices.get((vsel2-1));
							ar.valor=valor;
							arestas.add(ar);
							E+="{"+ar.src.id+","+ar.dst.id+"}";
							
							matAdj[vsel1-1][vsel2-1]=valor;
							if(direcionado){
								matAdj[vsel1-1][vsel2-1]=0-valor;
							}else{
								matAdj[vsel2-1][vsel1-1]=valor;
							}
							
							listaValores.add(valor);
						}
					}
					haaresta=false;
					System.out.println(arestas.get(0).valor);
				}
			}
			E="{"+E+"}";
			
			int matAr[][]=new int[arestas.size()][v];
			for(int t=0; t<v;t++){
				for(int r=0; r<arestas.size();r++){
					if(arestas.get(r).src.id==(t+1))
						matAr[t][r]=+1;
					if(direcionado){
						if(arestas.get(r).dst.id==(t+1))
							matAr[t][r]=-1;
					}
					
					
				}
			}
			JOptionPane.showMessageDialog(null,listarLista(arestas, listaValores));
			JOptionPane.showMessageDialog(null,listarMtzAdj(matAdj, v));
			JOptionPane.showMessageDialog(null,listarMtzArs(matAr, arestas.size(), v));
			JOptionPane.showMessageDialog(null, "E:"+E+"\n"+"V:"+V);
		}
		
	}
}
