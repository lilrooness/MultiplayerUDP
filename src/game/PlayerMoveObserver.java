package game;

public class PlayerMoveObserver extends Observer {

	private boolean hasMoved;
	
	@Override
	public void onNotify(Event event) {
		if(event == Event.PLAYER_MOVE) {
			hasMoved = true;
		}
	}

	/**
	 * @return the hasMoved
	 */
	public boolean isHasMoved() {
		return hasMoved;
	}

	/**
	 * @param hasMoved the hasMoved to set
	 */
	public void setHasMoved(boolean hasMoved) {
		this.hasMoved = hasMoved;
	}
}
