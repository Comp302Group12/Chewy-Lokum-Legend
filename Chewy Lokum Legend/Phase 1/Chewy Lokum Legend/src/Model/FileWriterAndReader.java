package Model;

import java.awt.Color;
import java.io.File;
import java.io.IOException;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;

public class FileWriterAndReader {

	final static String FILE_NAME = "savedGame.xml";


	public void saveGameToTheFile(GamePlay game) {
		DocumentBuilderFactory builderFactory = DocumentBuilderFactory.newInstance();
		try {
			DocumentBuilder dBuilder = builderFactory.newDocumentBuilder();
			Document document = dBuilder.newDocument();
			Element savedGameElement = document.createElement("savedGame");
			savedGameElement.setAttribute("level", ""+game.getLevel());
			//savedGameElement.setAttribute("score", ""+game.getScore());
			//savedGameElement.setAttribute("numOfRemainingMoves", ""+game.getNumOfRemainingMoves());
			savedGameElement.setAttribute("score", ""+game.getBoard().sco);
			savedGameElement.setAttribute("numOfRemainingMoves", ""+game.getBoard().movesLeft);
			Element boardElement = document.createElement("board");
			boardElement.setAttribute("numOfLokumsInAColumn", ""+game.getBoard().getNumOfLokumsInAColumn());
			boardElement.setAttribute("numOfLokumsInARow", ""+game.getBoard().getNumOfLokumsInARow());
			Element lokumsElement = document.createElement("lokums");
			for(int i=0; i<game.getBoard().getLokumArray().length; i++) {
				for(int j=0; j<game.getBoard().getLokumArray()[0].length; j++) {
					Lokum lokum = game.getBoard().getLokumArray()[i][j];
					String typeOfLokum = lokum.getClass().getName();
					typeOfLokum = typeOfLokum.substring(typeOfLokum.lastIndexOf('.')+1);
					Element lokumElement = document.createElement("lokum");
					lokumElement.setAttribute("typeOfLokum", typeOfLokum);
					Element colorOfLokumElement = document.createElement("colorOfLokum");
					colorOfLokumElement.setAttribute("r", ""+lokum.getColorOfLokum().getRed());
					colorOfLokumElement.setAttribute("g", ""+lokum.getColorOfLokum().getGreen());
					colorOfLokumElement.setAttribute("b", ""+lokum.getColorOfLokum().getBlue());
					lokumElement.appendChild(colorOfLokumElement);
					lokumsElement.appendChild(lokumElement);
				}
			}

			boardElement.appendChild(lokumsElement);
			savedGameElement.appendChild(boardElement);
			document.appendChild(savedGameElement);
			TransformerFactory transformerFactory = TransformerFactory.newInstance();
			try {
				Transformer transformer = transformerFactory.newTransformer();
				transformer.setOutputProperty(OutputKeys.INDENT, "yes");
				DOMSource source = new DOMSource(document);
				StreamResult result = new StreamResult(new File(FILE_NAME));
				transformer.transform(source, result);
			} catch (TransformerException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} catch (ParserConfigurationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public GamePlay loadGameFromTheFile() {
		DocumentBuilderFactory builderFactory = DocumentBuilderFactory.newInstance();
		try {
			DocumentBuilder dBuilder = builderFactory.newDocumentBuilder();
			Document document = dBuilder.parse(new InputSource(FILE_NAME));
			document.normalize();
			NodeList listOfSavedGames = document.getElementsByTagName("savedGame");
			Node savedGameNode = listOfSavedGames.item(0);
			Element savedGameElement = (Element) savedGameNode;
			int level = Integer.parseInt(savedGameElement.getAttribute("level"));
			int score = Integer.parseInt(savedGameElement.getAttribute("score"));
			int numOfRemainingMoves = Integer.parseInt(savedGameElement.getAttribute("numOfRemainingMoves"));
			return createGame(level, score, numOfRemainingMoves, savedGameElement);
		} catch (ParserConfigurationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SAXException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	public GamePlay createGame(int level, int score, int numOfRemainingMoves, Element savedGameElement) {
		GamePlay game = new GamePlay();
		Element boardElement = (Element) savedGameElement.getElementsByTagName("board").item(0);
		int numOfLokumsInAColumn = Integer.parseInt(boardElement.getAttribute("numOfLokumsInAColumn"));
		int numOfLokumsInARow = Integer.parseInt(boardElement.getAttribute("numOfLokumsInARow"));
		game.setBoard(createBoard(numOfLokumsInAColumn, numOfLokumsInARow, boardElement));
		game.setLevel(level);
		game.setScore(score);
		game.board.sco = score;
		game.setNumOfRemainingMoves(numOfRemainingMoves);
		game.board.movesLeft = numOfRemainingMoves;
		return game;
	}

	public Board createBoard(int numOfLokumsInAColumn, int numOfLokumsInARow, Element boardElement){
		Board board = new Board(numOfLokumsInAColumn, numOfLokumsInARow);
		NodeList listOfLokums = ((Element) boardElement.getElementsByTagName("lokums").item(0)).getElementsByTagName("lokum");
		board.setLokumArray(createLokumArray(numOfLokumsInAColumn, numOfLokumsInARow, listOfLokums));
		return board;

	}

	public Lokum[][] createLokumArray(int numOfLokumsInAColumn, int numOfLokumsInARow, NodeList listOfLokums) {
		Lokum[][] lokumArray = new Lokum[numOfLokumsInAColumn][numOfLokumsInARow];
		for(int i=0; i<numOfLokumsInAColumn; i++) {
			for(int j=0; j<numOfLokumsInARow; j++){
				try {
					Element lokumElement = (Element) listOfLokums.item(i*numOfLokumsInAColumn+j);
					String typeOfLokum = lokumElement.getAttribute("typeOfLokum");
					Lokum lokum = (Lokum) Class.forName("Model."+typeOfLokum).newInstance();
					Element colorOfLokumElement = (Element) lokumElement.getElementsByTagName("colorOfLokum").item(0);
					Color colorOfLokum = new Color(Integer.parseInt(colorOfLokumElement.getAttribute("r")), 
							Integer.parseInt(colorOfLokumElement.getAttribute("g")), 
							Integer.parseInt(colorOfLokumElement.getAttribute("b")));
					lokum.setColorOfLokum(colorOfLokum);
					lokumArray[i][j] = lokum;
				} catch (InstantiationException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IllegalAccessException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (ClassNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		return lokumArray;
	}
	/*public static void main(String[] args) {
		FileWriterAndReader x1 = new FileWriterAndReader();
		x1.saveGameToTheFile(new GamePlay());
		System.out.println(x1.loadGameFromTheFile().getBoard().toString());
	}*/
}
