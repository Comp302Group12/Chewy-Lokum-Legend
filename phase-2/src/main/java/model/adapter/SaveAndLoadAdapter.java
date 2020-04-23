package model.adapter;

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

import model.Board;
import model.GamePlay;
import model.level.Level;
import model.lokum.Lokum;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;

public class SaveAndLoadAdapter {
	final static String FILE_NAME = "savedGame.xml";


	public void saveGameToTheFile(GamePlay gamePlay) {
		DocumentBuilderFactory builderFactory = DocumentBuilderFactory.newInstance();
		try {
			DocumentBuilder dBuilder = builderFactory.newDocumentBuilder();
			Document document = dBuilder.newDocument();
			Element savedGameElement = document.createElement("savedGame");
			String level = ""+gamePlay.getLevel().getClass().getName().charAt(gamePlay.getLevel().getClass().getName().length()-1);
			savedGameElement.setAttribute("level", ""+ level);
			//savedGameElement.setAttribute("score", ""+game.getScore());
			//savedGameElement.setAttribute("numOfRemainingMoves", ""+game.getNumOfRemainingMoves());
			savedGameElement.setAttribute("score", ""+gamePlay.getScore());
			savedGameElement.setAttribute("numOfRemainingMoves", ""+gamePlay.getLevel().getRemainingQuantity());
			Element boardElement = document.createElement("board");
			boardElement.setAttribute("numOfLokumsInAColumn", ""+gamePlay.getBoard().getNumOfLokumsInAColumn());
			boardElement.setAttribute("numOfLokumsInARow", ""+gamePlay.getBoard().getNumOfLokumsInARow());
			Element lokumsElement = document.createElement("lokums");
			for(int i=0; i<gamePlay.getBoard().getLokumArray().length; i++) {
				for(int j=0; j<gamePlay.getBoard().getLokumArray()[0].length; j++) {
					Lokum lokum = gamePlay.getBoard().getLokumArray()[i][j];
					String typeOfLokum = lokum.getClass().getName();
					typeOfLokum = typeOfLokum.substring(typeOfLokum.lastIndexOf('.')+1);
					Element lokumElement = document.createElement("lokum");
					lokumElement.setAttribute("typeOfLokum", typeOfLokum);
					Element positionOflokumElement = document.createElement("positionOfLokum");
					positionOflokumElement.setAttribute("x", ""+lokum.getX());
					positionOflokumElement.setAttribute("y", ""+lokum.getY());
					Element sizeOflokumElement = document.createElement("sizeOfLokum");
					sizeOflokumElement.setAttribute("width", ""+lokum.getWidth());
					sizeOflokumElement.setAttribute("height", ""+lokum.getHeight());
					Element colorOfLokumElement = document.createElement("colorOfLokum");
					colorOfLokumElement.setAttribute("r", ""+lokum.getColor().getRed());
					colorOfLokumElement.setAttribute("g", ""+lokum.getColor().getGreen());
					colorOfLokumElement.setAttribute("b", ""+lokum.getColor().getBlue());
					lokumElement.appendChild(positionOflokumElement);
					lokumElement.appendChild(sizeOflokumElement);
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

	public GamePlay createGame(int levelNumber, int score, int remainingQuantity, Element savedGameElement) {

		Element boardElement = (Element) savedGameElement.getElementsByTagName("board").item(0);
		String levelClassName = "model.level.Level"+levelNumber;
		GamePlay gamePlay = new GamePlay(null, null);
		try {
			Level level = (Level)Class.forName(levelClassName).newInstance();
			gamePlay = new GamePlay(createBoard(level.getGamePlay().getBoard(), boardElement), level);
			gamePlay.setScore(score);
			gamePlay.setRemainingQuantity(remainingQuantity);

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
		return gamePlay;

	}

	public Board createBoard(Board boardOfLevel, Element boardElement){
		NodeList listOfLokums = ((Element) boardElement.getElementsByTagName("lokums").item(0)).getElementsByTagName("lokum");
		boardOfLevel.lokumArray = createLokumArray(boardOfLevel.getNumOfLokumsInAColumn(), boardOfLevel.getNumOfLokumsInARow(), listOfLokums);
		return boardOfLevel;

	}

	public Lokum[][] createLokumArray(int numOfLokumsInAColumn, int numOfLokumsInARow, NodeList listOfLokums) {
		Lokum[][] lokumArray = new Lokum[numOfLokumsInAColumn][numOfLokumsInARow];
		for(int i=0; i<numOfLokumsInAColumn; i++) {
			for(int j=0; j<numOfLokumsInARow; j++){
				try {
					Element lokumElement = (Element) listOfLokums.item(i*numOfLokumsInAColumn+j);
					String typeOfLokum = lokumElement.getAttribute("typeOfLokum");
					Lokum lokum = (Lokum) Class.forName("model.lokum."+typeOfLokum).newInstance();
					Element positionOfLokumElement = (Element) lokumElement.getElementsByTagName("positionOfLokum").item(0);
					lokum.setX(Integer.parseInt(positionOfLokumElement.getAttribute("x")));
					lokum.setY(Integer.parseInt(positionOfLokumElement.getAttribute("y")));
					Element colorOfLokumElement = (Element) lokumElement.getElementsByTagName("colorOfLokum").item(0);
					Color colorOfLokum = new Color(Integer.parseInt(colorOfLokumElement.getAttribute("r")), 
							Integer.parseInt(colorOfLokumElement.getAttribute("g")), 
							Integer.parseInt(colorOfLokumElement.getAttribute("b")));
					lokum.setColor(colorOfLokum);
					Element sizeOfLokumElement = (Element) lokumElement.getElementsByTagName("sizeOfLokum").item(0);
					lokum.setWidth(Integer.parseInt(sizeOfLokumElement.getAttribute("width")));
					lokum.setHeight(Integer.parseInt(sizeOfLokumElement.getAttribute("height")));
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
}
