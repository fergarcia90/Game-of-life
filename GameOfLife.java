import javax.swing.JComboBox;
import javax.swing.JOptionPane;


public class GameOfLife{
	int xsize;
	int ysize;
	char board[][];
	boolean ban;
	Visual vis;
	
	public GameOfLife(){
		board=new char[xsize][ysize];
		xsize=200;
		ysize=35;
		ban=true;
	}
	
	public char[][] initBoard(int xsize,int ysize){
		char board[][]=new char[xsize][ysize];
		for(int y=0;y<ysize;y++){
			for(int x=0;x<xsize;x++){
				board[x][y]='-';
			}
		}
		return board;
	}
	
	public void showBoard(char board[][],int xsize,int ysize){
		for(int y=1;y<ysize;y++){
			for(int x=1;x<xsize;x++){
				vis.textArea.append(""+board[x][y]);
			}
			vis.textArea.append("\n");
		}
		vis.textArea.append("\n\n");
	}
	
	public boolean isAlive(char cell){
		if(cell=='*')
			return true;
		else
			return false;
	}
	
	public int countNeighbors(char board[][],int x,int y){
		int nc=0;
		if(board[x-1][y-1]=='*')
			nc++;
		if(board[x][y-1]=='*')
			nc++;
		if(board[x+1][y-1]=='*')
			nc++;
		if(board[x-1][y]=='*')
			nc++;
		if(board[x+1][y]=='*')
			nc++;
		if(board[x-1][y+1]=='*')
			nc++;
		if(board[x][y+1]=='*')
			nc++;
		if(board[x+1][y+1]=='*')
			nc++;
		return nc;
	}
	
	public char[][] gol(char board[][],int xsize,int ysize){
		int nc;
		char cell[][]=new char[xsize][ysize];
		cell=initBoard(xsize,ysize);
		for(int y=1;y<ysize-1;y++){
			for(int x=1;x<xsize-1;x++){
				nc=countNeighbors(board,x,y);
				if(isAlive(board[x][y])){
					if(nc<2 || nc>3)
						cell[x][y]='-';
					else
						cell[x][y]='*';
				}
				else{
					if(nc==3)
						cell[x][y]='*';
				}
			}
		}
		board=cell;
		showBoard(board,xsize,ysize);
		try {
			Thread.sleep(100);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		return board;
	}
	
	public static void main(String args[]){
		String[] list= {"Statics","Oscillators","Gosper Glider Gun","Acorn"};
		int opc;
		JComboBox<String> jcb=new JComboBox<String>(list);
		GameOfLife gol=new GameOfLife();
		int xsize=200;
		int ysize=40;
		gol.board=gol.initBoard(xsize, ysize);
		gol.vis=new Visual();
		JOptionPane.showMessageDialog(null, jcb, "Selecciona el Patron",JOptionPane.QUESTION_MESSAGE);
		opc=jcb.getSelectedIndex();
		switch(opc){
		case 0: gol.statics();
				break;
		
		case 1: gol.oscillators();
				break;
				
		case 2: gol.gosper();
				break;
				
		case 3: gol.acorn();
				break;
		
		default: System.out.println("Error");
		}
		gol.vis.setVisible(true);
		gol.showBoard(gol.board, xsize, ysize);
		while(gol.ban){
			gol.board=gol.gol(gol.board, xsize, ysize);
			gol.vis.textArea.setText("");
		}
		
	}
	
	public void statics(){
		board[2][2]='*';	//Block
		board[2][3]='*';
		board[3][2]='*';
		board[3][3]='*';
		
		board[2][7]='*';	//Beehive
		board[3][6]='*';
		board[3][8]='*';
		board[4][8]='*';
		board[4][6]='*';
		board[5][7]='*';
		
		board[2][12]='*';	//Loaf
		board[3][11]='*';
		board[3][13]='*';
		board[4][11]='*';
		board[4][14]='*';
		board[5][12]='*';
		board[5][13]='*';
		
		board[2][17]='*';	//boat
		board[2][18]='*';
		board[3][17]='*';
		board[3][19]='*';
		board[4][18]='*';
	}
	
	public void oscillators(){
		board[2][3]='*';	//blinker
		board[3][3]='*';
		board[4][3]='*';
		
		board[2][9]='*';	//Toad
		board[3][8]='*';
		board[3][9]='*';
		board[4][8]='*';
		board[4][9]='*';
		board[5][8]='*';
		
		board[2][13]='*';	//Beacon
		board[2][14]='*';
		board[3][13]='*';
		board[3][14]='*';
		board[4][15]='*';
		board[4][16]='*';
		board[5][15]='*';
		board[5][16]='*';
		
		board[3+3][21+3]='*';	//Pulsar
		board[3+3][22+3]='*';
		board[3+3][23+3]='*';
		board[5+3][19+3]='*';
		board[6+3][19+3]='*';
		board[7+3][19+3]='*';
		board[5+3][24+3]='*';
		board[6+3][24+3]='*';
		board[7+3][24+3]='*';
		board[8+3][23+3]='*';
		board[8+3][22+3]='*';
		board[8+3][21+3]='*';
		board[10+3][23+3]='*';
		board[10+3][22+3]='*';
		board[10+3][21+3]='*';
		board[11+3][24+3]='*';
		board[12+3][24+3]='*';
		board[13+3][24+3]='*';
		board[15+3][23+3]='*';
		board[15+3][22+3]='*';
		board[15+3][21+3]='*';
		board[11+3][19+3]='*';
		board[12+3][19+3]='*';
		board[13+3][19+3]='*';
		board[5+3][26+3]='*';
		board[6+3][26+3]='*';
		board[7+3][26+3]='*';
		board[3+3][27+3]='*';
		board[3+3][28+3]='*';
		board[3+3][29+3]='*';
		board[5+3][31+3]='*';
		board[6+3][31+3]='*';
		board[7+3][31+3]='*';
		board[8+3][27+3]='*';
		board[8+3][28+3]='*';
		board[8+3][29+3]='*';
		board[10+3][27+3]='*';
		board[10+3][28+3]='*';
		board[10+3][29+3]='*';
		board[11+3][26+3]='*';
		board[12+3][26+3]='*';
		board[13+3][26+3]='*';
		board[15+3][27+3]='*';
		board[15+3][28+3]='*';
		board[15+3][29+3]='*';
		board[11+3][31+3]='*';
		board[12+3][31+3]='*';
		board[13+3][31+3]='*';
	}
	
	public void gosper(){
		board[2][6]='*';
		board[2][7]='*';
		board[3][6]='*';
		board[3][7]='*';
		board[12][6]='*';
		board[12][7]='*';
		board[12][8]='*';
		board[13][5]='*';
		board[13][9]='*';
		board[14][4]='*';
		board[14][10]='*';
		board[15][4]='*';
		board[15][10]='*';
		board[16][7]='*';
		board[17][5]='*';
		board[17][9]='*';
		board[18][6]='*';
		board[18][7]='*';
		board[18][8]='*';
		board[19][7]='*';
		board[22][4]='*';
		board[22][5]='*';
		board[22][6]='*';
		board[23][4]='*';
		board[23][5]='*';
		board[23][6]='*';
		board[24][3]='*';
		board[24][7]='*';
		board[26][2]='*';
		board[26][3]='*';
		board[26][7]='*';
		board[26][8]='*';
		board[36][4]='*';
		board[36][5]='*';
		board[37][4]='*';
		board[37][5]='*';
	}
	
	public void acorn(){
		board[100][25]='*';
		board[101][25]='*';
		board[101][23]='*';
		board[103][24]='*';
		board[104][25]='*';
		board[105][25]='*';
		board[106][25]='*';
	}

}
