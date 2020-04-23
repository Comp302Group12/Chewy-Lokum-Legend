package Model;

import java.awt.Color;
import java.util.Arrays;
import java.util.Random;

public class Board {

	int numOfLokumsInAColumn;
	int numOfLokumsInARow;
	public int movesLeft;
	public int sco;
	Lokum[][] lokumArray;
	String strippedClassName = "class Model.StripedLokum";
	String wrappedClassName = "class Model.WrappedLokum";
	String colorbombClassName = "class Model.ColorBombLokum";
	int[][] willbeDestroyed;

	public Board(int numOfLokumsInAColumn, int numOfLokumsInARow) {
		// TODO Auto-generated constructor stub
		this.numOfLokumsInARow = numOfLokumsInARow;
		this.numOfLokumsInAColumn = numOfLokumsInAColumn;
		lokumArray = new Lokum[numOfLokumsInAColumn][numOfLokumsInARow];
		willbeDestroyed =new int[numOfLokumsInAColumn][numOfLokumsInARow];
		movesLeft = 15;
		sco = 0;
	}

	public int getNumOfLokumsInARow() {
		return numOfLokumsInARow;
	}

	public void setNumOfLokumsInARow(int numOfLokumsInARow) {
		this.numOfLokumsInARow = numOfLokumsInARow;
	}

	public int getNumOfLokumsInAColumn() {
		return numOfLokumsInAColumn;
	}

	public void setNumOfLokumsInAColumn(int numOfLokumsInAColumn) {
		this.numOfLokumsInAColumn = numOfLokumsInAColumn;
	}

	public Lokum[][] getLokumArray() {
		return lokumArray;
	}

	public void setLokumArray(Lokum[][] lokumArray) {
		this.lokumArray = lokumArray;
	}

	public void fillBoardRandomly() {
		for(int i=0; i<lokumArray.length; i++){
			for(int j=0; j<lokumArray[0].length; j++){ 
				lokumArray[i][j] = new NormalLokum();
			}
		}
		boolean a = true;
		while(a){
			specialStart(willbeDestroyed);
			fallLokumsInBoard();
			checkBoard();
			a = isThereAny();
		}
		checkBoard();
		for(int i=0; i<willbeDestroyed.length; i++){
			for(int j=0; j<willbeDestroyed.length; j++){
				System.out.print(willbeDestroyed[i][j]);
			}
			System.out.println();
		}

		//willbeDestroyed[5][5] = new StripedLokum(true, Color.RED);




	}

	public void swapLokumsInBoard(int x1, int y1, int x2, int y2){
		Lokum lokumTemporary = lokumArray[x1][y1];
		lokumArray[x1][y1] = lokumArray[x2][y2];
		lokumArray[x2][y2] = lokumTemporary;

	}	

	public void fallLokumsInBoard(){
		while(fallingNeeded()){
			Lokum fall= new EmptySpace();		
			for(int column=0; column<lokumArray.length; column++){
				for(int row=lokumArray[0].length-1; row>=0; row--){
					if (lokumArray[row][column].getColorOfLokum() == fall.getColorOfLokum()){
						if(row==0){ 
							Random rgen = new Random();
							Color randomColor = Lokum.lokumColors[rgen.nextInt(Lokum.lokumColors.length-2)];
							lokumArray[row][column] =  new NormalLokum(randomColor);	
						} else{
							if(lokumArray[row][column].getColorOfLokum() != lokumArray[row-1][column].getColorOfLokum()){
								swapLokumsInBoard(row, column, row-1, column);
							}
						}
					}
				}
			}
		}
	}

	public boolean fallingNeeded(){
		for(int i=0; i<lokumArray.length; i++){
			for(int j=0; j<lokumArray.length; j++){
				if(lokumArray[i][j].getColorOfLokum()==Color.WHITE){
					return true;
				}
			}
		}
		return false;
	}

	// in an array all elements are 0 if it will be destroyed it will be 1 if it will be converged to special lokum
	//it will take accordingly 2 for wrapped, 3 for horizantal lokum, 4 for vertical, 5 for chocobomb
	public void checkBoard(){
		checkDestroyableCol();
		checkDestroyableRow();
	}

	public void checkDestroyableCol(){
		int pieceCounter =1;
		int currentPoint =0;
		int y=0;	//y
		while(y<lokumArray.length){

			Lokum a = lokumArray[y][0];

			for(int k =0; k<lokumArray.length-1; k++){

				if( a.getColorOfLokum() != lokumArray[y][k+1].getColorOfLokum()){
					a = lokumArray[y][k+1];
					///// 5 li comb bombo convert
					if(pieceCounter > 4) {
						int midToconvert = pieceCounter/2;
						currentPoint = k;
						for(int t= pieceCounter; t>0; t--){
							willbeDestroyed[y][currentPoint] = 1;
							if(midToconvert == k- currentPoint){willbeDestroyed[y][currentPoint]=5;}
							currentPoint--;
						}
					}
					///// 4 li strip bomba convert
					else if (pieceCounter > 3) {
						int midToconvert = pieceCounter/2;
						currentPoint = k;
						for(int t= pieceCounter; t>0; t--){
							willbeDestroyed[y][currentPoint] = 1;
							if(midToconvert == k-currentPoint){willbeDestroyed[y][currentPoint]=4;}
							currentPoint--;
						}
					}				 
					///// normal lokum to destroy
					else if(pieceCounter > 2) {
						currentPoint = k;
						for(int t= pieceCounter; t>0; t--){
							willbeDestroyed[y][currentPoint] = 1;
							currentPoint--;
						}
					}
					pieceCounter=1;  
				}else{
					pieceCounter++;
				}	
			}
			//////// for last element  in array
			int k= lokumArray.length -1;
			if(pieceCounter > 4) {
				int midToconvert = pieceCounter/2;
				currentPoint = lokumArray.length-1;
				for(int t= pieceCounter; t>0; t--){
					willbeDestroyed[y][currentPoint] = 1;
					if(midToconvert == k-currentPoint){willbeDestroyed[y][currentPoint]=5;}
					currentPoint--;
				}
			}
			else if(pieceCounter > 3) {
				int midToconvert = pieceCounter/2;
				currentPoint = lokumArray.length-1;
				for(int t= pieceCounter; t>0; t--){
					willbeDestroyed[y][currentPoint] = 1;
					if(midToconvert ==k- currentPoint){willbeDestroyed[y][currentPoint]=4;}
					currentPoint--;
				}
			}
			else if(pieceCounter > 2) {
				currentPoint = lokumArray.length-1;
				for(int t= pieceCounter; t>0; t--){
					willbeDestroyed[y][currentPoint] = 1;
					currentPoint--;
				}
			}
			y++;
			pieceCounter =1;
		}
	}

	public void checkDestroyableRow(){
		int pieceCounter =1;
		int currentPoint =0;
		int y=0;	//y
		while(y<lokumArray.length){
			Lokum a = lokumArray[0][y];
			for(int k =0; k<lokumArray.length-1; k++){
				if( a.getColorOfLokum() != lokumArray[k+1][y].getColorOfLokum()){
					a = lokumArray[k+1][y];
					///// 5 li comb bombo convert
					if(pieceCounter > 4) {
						int midToconvert = pieceCounter/2;
						currentPoint = k;
						for(int t= pieceCounter; t>0; t--){
							willbeDestroyed[currentPoint][y] = 1;
							if(midToconvert == k- currentPoint){willbeDestroyed[currentPoint][y]=5;}
							currentPoint--;
						}
					}
					///// 4 li strip bomba convert
					else if (pieceCounter > 3) {
						int midToconvert = pieceCounter/2;
						currentPoint = k;
						for(int t= pieceCounter; t>0; t--){
							willbeDestroyed[currentPoint][y] = 1;
							if(midToconvert == k-currentPoint){willbeDestroyed[currentPoint][y]=3;}
							currentPoint--;
						}
					}				 
					///// normal lokum to destroy
					else if(pieceCounter > 2) {
						currentPoint = k;
						for(int t= pieceCounter; t>0; t--){
							willbeDestroyed[currentPoint][y] = 1;
							currentPoint--;
						}
					}
					pieceCounter=1;  
				}else{
					pieceCounter++;
				}	
			}
			//////// for last element  in array
			int k=lokumArray.length -1;
			if(pieceCounter > 4) {
				int midToconvert = pieceCounter/2;
				currentPoint = lokumArray.length-1;
				for(int t= pieceCounter; t>0; t--){
					willbeDestroyed[currentPoint][y] = 1;
					if(midToconvert == k-currentPoint){willbeDestroyed[currentPoint][y]=5;}
					currentPoint--;
				}
			}
			else if(pieceCounter > 3) {
				int midToconvert = pieceCounter/2;
				currentPoint = lokumArray.length-1;
				for(int t= pieceCounter; t>0; t--){
					willbeDestroyed[currentPoint][y] = 1;
					if(midToconvert == k-currentPoint){willbeDestroyed[currentPoint][y]=3;}
					currentPoint--;
				}
			}

			else if(pieceCounter > 2) {
				currentPoint = lokumArray.length-1;
				for(int t= pieceCounter; t>0; t--){
					willbeDestroyed[currentPoint][y] = 1;
					currentPoint--;
				}
			}
			y++;
			pieceCounter =1;
		}
	}

	public void destroyMatchedLokums(int[][] array){
		Lokum destroyed = new EmptySpace();
		for(int i=0; i<array.length; i++){
			for(int j=0; j<array.length; j++){
				if(array[i][j]==4){
					Color colorWillBe = lokumArray[i][j].getColorOfLokum();
					Lokum convertStripedYatay = new StripedLokum(true, colorWillBe);
					lokumArray[i][j] = convertStripedYatay;
					sco+= 120;
				}
				else if(array[i][j]==3){
					Color colorWillBe = lokumArray[i][j].getColorOfLokum();
					Lokum convertStripedDikey = new StripedLokum(false, colorWillBe);
					lokumArray[i][j] = convertStripedDikey;
					sco+= 120;
				}
				else if(array[i][j]==5){
					Lokum cb = new ColorBombLokum();
					lokumArray[i][j] = cb;
					sco+= 200;
				}
				else if(array[i][j]==1){
					destroySpecialLokum(lokumArray[i][j], i, j);
					sco+= 20;
				}
				willbeDestroyed[i][j]=0;
			}						
		}
		for(int i=0; i<array.length; i++){
			for(int j=0; j<array.length; j++){
				willbeDestroyed[i][j] = 0;
			}
		}

	}
	public void destroySpecialCombination(Lokum a, Lokum b, int x1, int y1){

		Lokum destroy = new EmptySpace();
		//strip strip
		if (a.getClass().toString().equals(strippedClassName) && b.getClass().toString().equals(strippedClassName) ){
			if( ((StripedLokum)a).isHorizontal()){
				for(int k=0; k<lokumArray.length; k++){
					lokumArray[x1][k] =  destroy;
					sco+= 600;
				}
			}else{
				for(int k=0; k<lokumArray.length; k++){
					lokumArray[k][y1] =  destroy;
					sco+= 20;
				}
			}
			fallLokumsInBoard();
			if( ((StripedLokum)b).isHorizontal()){
				for(int k=0; k<lokumArray.length; k++){
					lokumArray[x1][k] =  destroy;
				}
			}else{
				for(int k=0; k<lokumArray.length; k++){
					lokumArray[k][y1] =  destroy; 
					sco+= 20;
				}
			}
			fallLokumsInBoard();			
		}

		//wrapped strip or strip wrap 
		//if there is comb made at edges of board it will not be destroy since it will go out of bond of the array
		//so less lokum will be destroyed
		if ((a.getClass().toString().equals(wrappedClassName) && b.getClass().toString().equals(strippedClassName) )
				|| (b.getClass().toString().equals(wrappedClassName) && a.getClass().toString().equals(strippedClassName) )	){
			if(x1 == lokumArray.length && y1 ==lokumArray.length){
				for(int k=0; k<lokumArray.length; k++){
					lokumArray[x1][k] =  destroy;
					lokumArray[x1-1][k] =  destroy;
				}for(int k=0; k<lokumArray.length; k++){
					lokumArray[k][y1] =  destroy;
					lokumArray[k][y1-1] =  destroy;
				}
				fallLokumsInBoard();
			}

			if(x1 == 0 && y1 ==lokumArray.length){
				for(int k=0; k<lokumArray.length; k++){
					lokumArray[x1][k] =  destroy;
					lokumArray[x1+1][k] =  destroy;
				}for(int k=0; k<lokumArray.length; k++){
					lokumArray[k][y1] =  destroy;
					lokumArray[k][y1-1] =  destroy;
				}
				fallLokumsInBoard();
			}
			if(x1 == lokumArray.length && y1 ==0){
				for(int k=0; k<lokumArray.length; k++){
					lokumArray[x1][k] =  destroy;
					lokumArray[x1-1][k] =  destroy;
				}for(int k=0; k<lokumArray.length; k++){
					lokumArray[k][y1] =  destroy;
					lokumArray[k][y1+1] =  destroy;
				}
				fallLokumsInBoard();
			}
			if(x1 == 0 && y1 ==0){
				for(int k=0; k<lokumArray.length; k++){
					lokumArray[x1][k] =  destroy;
					lokumArray[x1+1][k] =  destroy;
				}for(int k=0; k<lokumArray.length; k++){
					lokumArray[k][y1] =  destroy;
					lokumArray[k][y1+1] =  destroy;
				}
				fallLokumsInBoard();
			}
			else{
				for(int k=0; k<lokumArray.length; k++){
					lokumArray[x1][k] =  destroy;
					lokumArray[x1-1][k] =  destroy;
					lokumArray[x1+1][k] =  destroy;
				}for(int k=0; k<lokumArray.length; k++){
					lokumArray[k][y1] =  destroy;
					lokumArray[k][y1-1] =  destroy;
					lokumArray[k][y1+1] =  destroy;
				}
				fallLokumsInBoard();
			}
			sco+= 200;



		}	
		//wrapped wrapped
		if (a.getClass().toString().equals(wrappedClassName) && b.getClass().toString().equals(wrappedClassName) ){	
			if(x1 == lokumArray.length && y1 ==lokumArray.length){
				for(int k = x1-1; k < x1+1; k++){
					for(int l=y1-1; l<y1+1; l++){
						lokumArray[k][l] =  destroy;
					}
				}
				fallLokumsInBoard();
				sco+= 3600;
			}

			if(x1 == 0 && y1 ==lokumArray.length){
				for(int k = x1; k < x1+2; k++){
					for(int l=y1-1; l<y1+1; l++){
						lokumArray[k][l] =  destroy;
					}
				}
				fallLokumsInBoard();
			}
			if(x1 == lokumArray.length && y1 ==0){

				for(int k = x1-1; k < x1+1; k++){
					for(int l=y1; l<y1+2; l++){
						lokumArray[k][l] =  destroy;
					}
				}
				fallLokumsInBoard();
			}
			if(x1 == 0 && y1 ==0){

				for(int k = x1; k < x1+2; k++){
					for(int l=y1; l<y1+2; l++){
						lokumArray[k][l] =  destroy;
					}
				}
				fallLokumsInBoard();
			}
			else{
				for(int k = x1-1; k < x1+2; k++){
					for(int l=y1-1; l<y1+2; l++){
						lokumArray[k][l] =  destroy;
					}
				}
				fallLokumsInBoard();
			}


		}
		//wraped chocobomb
		if (a.getClass().toString().equals(wrappedClassName) && b.getClass().toString().equals(colorbombClassName) ){

		}
		//choco strip
		if (a.getClass().toString().equals(strippedClassName) && b.getClass().toString().equals(colorbombClassName) ){
			for(int k = 0; k < lokumArray.length; k++){
				for(int l=0; l<lokumArray.length; l++){
					if(lokumArray[k][l].getColorOfLokum() == a.getColorOfLokum()){

						lokumArray[k][l] = new StripedLokum((Math.random() < 0.5), a.getColorOfLokum());
					}
				}
			}

			for(int k = 0; k < lokumArray.length; k++){
				for(int l=0; l<lokumArray.length; l++){
					if(lokumArray[k][l].getColorOfLokum() == a.getColorOfLokum()){
						destroySpecialLokum(lokumArray[k][l], k, l);
					}
				}
			}
		}

		//strip choco
		if (b.getClass().toString().equals(colorbombClassName) && a.getClass().toString().equals(colorbombClassName) ){


		}

		//choco wrap
		if (a.getClass().toString().equals(colorbombClassName) && b.getClass().toString().equals(colorbombClassName) ){

		}

		//choco choco
		if (a.getClass().toString().equals(colorbombClassName) && b.getClass().toString().equals(colorbombClassName) ){
			for(int k = 0; k < lokumArray.length; k++){
				for(int l=0; l<lokumArray.length; l++){
					lokumArray[k][l] =  destroy;
				}
			}
		}



	}
	//destroys one special in it means
	public void destroySpecialLokum(Lokum specLok, int x1, int y1){
		Lokum destroy = new EmptySpace();
		if (specLok.getClass().toString().equals(strippedClassName)){
			if( ((StripedLokum)specLok).isHorizontal()){
				for(int k=0; k<lokumArray.length; k++){
					lokumArray[x1][k] =  destroy;
				}
			}else{
				for(int k=0; k<lokumArray.length; k++){
					lokumArray[k][y1] =  destroy;
				}
			}
		}
		if (specLok.getClass().toString().equals(wrappedClassName)){
			if(x1 == lokumArray.length && y1 ==lokumArray.length){
				for(int k = x1-1; k < x1+1; k++){
					for(int l=y1-1; l<y1+1; l++){
						lokumArray[k][l] =  destroy;
					}
				}
			}

			if(x1 == 0 && y1 ==lokumArray.length){
				for(int k = x1; k < x1+2; k++){
					for(int l=y1-1; l<y1+1; l++){
						lokumArray[k][l] =  destroy;
					}
				}
			}
			if(x1 == lokumArray.length && y1 ==0){

				for(int k = x1-1; k < x1+1; k++){
					for(int l=y1; l<y1+2; l++){
						lokumArray[k][l] =  destroy;
					}
				}
			}
			if(x1 == 0 && y1 ==0){

				for(int k = x1; k < x1+2; k++){
					for(int l=y1; l<y1+2; l++){
						lokumArray[k][l] =  destroy;
					}
				}
			}
			else{
				for(int k = x1-1; k < x1+2; k++){
					for(int l=y1-1; l<y1+2; l++){
						lokumArray[k][l] =  destroy;
					}
				}
			}
		}

		lokumArray[x1][y1] = destroy; // if normal just destroy

	}


	public boolean isThereAny(){
		for(int i=0; i<willbeDestroyed.length; i++){
			for(int j=0; j<willbeDestroyed.length; j++){
				if(willbeDestroyed[i][j]>0){return true;}
			}
		}	
		return false;
	}

	public void specialStart(int[][] array){
		Lokum destroyed = new EmptySpace();
		for(int i=0; i<array.length; i++){
			for(int j=0; j<array.length; j++){
				if(willbeDestroyed[i][j] > 0){
					willbeDestroyed[i][j]=0;
					lokumArray[i][j] = destroyed;
				}
			}
		}
	}

	public void printWillBe(){
		for(int i=0; i<willbeDestroyed.length; i++){
			for(int j=0; j<willbeDestroyed.length; j++){
				System.out.print(willbeDestroyed[i][j]);
			}
			System.out.println();
		}
	}

	@Override
	public String toString() {
		return "Board [numOfLokumsInAColumn=" + numOfLokumsInAColumn
				+ ", numOfLokumsInARow=" + numOfLokumsInARow + ", lokumArray="
				+ Arrays.toString(lokumArray) + "]";
	}

}
