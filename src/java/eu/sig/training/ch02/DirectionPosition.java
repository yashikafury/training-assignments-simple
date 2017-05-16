package eu.sig.training.ch02;

public class DirectionPosition {
	public Direction dir;
	public PositionVolume positionVolume;
	public int dirPosX;
	public int dirPosY;

	public DirectionPosition(Direction dir, PositionVolume positionVolume) {
		this.dir = dir;
		this.positionVolume = positionVolume;
		this.dirPosX = (positionVolume.width + positionVolume.x + dir.getDeltaX()) % positionVolume.width;
		this.dirPosY = (positionVolume.height + positionVolume.y + dir.getDeltaY()) % positionVolume.height;
	}
}