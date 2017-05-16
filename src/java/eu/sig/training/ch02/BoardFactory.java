package eu.sig.training.ch02;

public class BoardFactory {
    // tag::createBoard[]
    public Board createBoard(Square[][] grid) {
        assert grid != null;

        Board board = new Board(grid);

        int width = board.getWidth();
        int height = board.getHeight();
        for (int x = 0; x < width; x++) {
            for (int y = 0; y < height; y++) {
                Square square = grid[x][y];
                for (Direction dir : Direction.values()) {
                	setLink(square, new DirectionPosition(dir, new PositionVolume(x, y, width, height)), grid);
                }
            }
        }

        return board;
    }
    // end::createBoard[]
    
    private void setLink(Square square, DirectionPosition dirPosition, Square[][] grid) {
    	int dirX = dirPosition.dirPosX;
        int dirY = dirPosition.dirPosY;
        Square neighbour = grid[dirX][dirY];
        square.link(neighbour, dirPosition.dir);
    }
}

class Board {
    @SuppressWarnings("unused")
    public Board(Square[][] grid) {}

    public int getWidth() {
        return 0;
    }

    public int getHeight() {
        return 0;
    }
}

class Square {
    @SuppressWarnings("unused")
    public void link(Square neighbour, Direction dir) {}
}

class Direction {

    public static Direction[] values() {
        return null;
    }

    public int getDeltaY() {
        return 0;
    }

    public int getDeltaX() {
        return 0;
    }
}
