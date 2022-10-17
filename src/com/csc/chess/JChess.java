package com.csc.chess;

import com.csc.chess.board.Board;

import com.csc.chess.gui.Table;

public class JChess {

    public static void main(String [] args){

        Board board = Board.createStandardBoard();
        System.out.println(board);

        Table table = new Table();

    }
}
