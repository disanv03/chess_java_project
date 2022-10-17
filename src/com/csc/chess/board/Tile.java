package com.csc.chess.board;

import java.util.HashMap;
import java.util.Map;

import com.csc.chess.pieces.Piece;

public abstract class Tile {
	
	protected final int tileCoordinate;
	
	private static final Map<Integer, EmptyTile> EMPTY_TILES_CACHE = createAllPossibleTiles();
	
	private Tile(int tileCoordinate){
		this.tileCoordinate = tileCoordinate;
	}

	private static Map<Integer, EmptyTile> createAllPossibleTiles() {
		
		final Map<Integer, EmptyTile> emptyTileMap = new HashMap();
		
		for (int i = 0; i < 64; i++) {
			emptyTileMap.put(i, new EmptyTile(i));
		}
		return emptyTileMap;
		//Collections.unmodifiableMap(emptyTileMap);
	}
	
	public static Tile createTile(final int tileCoordinate, final Piece piece) {
		return piece != null ? new OccupiedTile(tileCoordinate, piece) : EMPTY_TILES_CACHE.get(tileCoordinate);
	}

	public abstract boolean isTileOccupied();
	
	public abstract Piece getPiece();

	public int getTileCoordinate(){
		return this.tileCoordinate;
	}
	

	
	public static final class EmptyTile extends Tile{
		
		EmptyTile(final int coordinate){
			super(coordinate);
		}

		@Override
		public String toString(){
			return "-";
		}
		
		@Override
		public boolean isTileOccupied() {
			return false;
		}
		
		@Override
		public Piece getPiece() {
			return null;
		}
	

	}
	
	
	public static final class OccupiedTile extends Tile{
		
		private final Piece pieceOnTile;
		
		OccupiedTile(int tileCoordinate, Piece pieceOnTile) {
			super(tileCoordinate);
			this.pieceOnTile = pieceOnTile;
		}

		@Override
		public String toString(){
			return getPiece().getPieceAlliance().isBlack() ? getPiece().toString().toLowerCase() :
					getPiece().toString();
		}

		@Override
		public boolean isTileOccupied() {
			return true;
		}

		@Override
		public Piece getPiece() {
			return this.pieceOnTile;
		}

		
		
		
	}
}