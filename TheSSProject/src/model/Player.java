package model;

import java.net.Socket;

public abstract class Player {
	
	// <------ Instance variables ------>	
	
	public final String name;
	public final PlayerID playerID;
	
	// <------ Constructor ------>
	
	/** 
	 * Creates a new player with given name and ID. 
	 * 
	 * @param name Name of the player
	 * @param id Player ID of the player
	 */
	//@ requires name != null;
	//@ requires id == PlayerID.X || id == PlayerID.O;
	//@ ensures this.name == name && this.playerID == id;
	public Player(String name, PlayerID id) {
		this.name = name;
		this.playerID = id;
	}

	// <------ Queries ------>
	
//	/**
//	 * Returns the name of the player.
//	 * 
//	 * @return name of the player
//	 */
//	/*@ pure */ public String getName() {
//		return this.name;
//	}
//	
//	/**
//	 * Returns the ID of the player.
//	 * 
//	 * @return ID of the player.
//	 */
//	/*@ pure */ public PlayerID getPlayerID() {
//		return this.playerID;
//	}
	
	/**
	 * Determines the coordinates of the tower for the next move.
	 * 
	 * @param board current board the game is played on.
	 * @return Coordinates of the tower for the next move.
	 */
	//@ requires board != null && !board.isFull();
	//@ ensures board.checkMove(\result.getX(),\result.getY());
//	public abstract TowerCoordinates determineMove(Board board);
	
	// <------ Commands ------>

	/**
	 * Makes a move on the given board.
	 * 
	 * @param board current board, the game is played on.
	 * @param coord Coordinates of the tower to play
	 */
    //@ requires board != null & !board.isFull();
	//@ requires board.checkMove(coord.getX(),coord.getY());
    public void makeMove(Board board, TowerCoordinates coord) {

    }
}
