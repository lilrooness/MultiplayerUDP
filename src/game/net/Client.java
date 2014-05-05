package game.net;

import game.Game;
import game.PlayerMoveObserver;
import game.sync.GameUpdateTimerTask;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.util.Timer;

public class Client implements Runnable{
	private Game game;
	private PlayerMoveObserver moveObserver;
	
	private DatagramSocket socket;
	private Timer timer;
	private GameUpdateTimerTask gameUpdateTask;
	
	private int ups = 60;//updates per second
	
	int serverPort;
	InetAddress serverAddress;
	
	
	public Client() {
		game = new Game();
		moveObserver = new PlayerMoveObserver();
		game.addObserver(moveObserver);
		
		gameUpdateTask = new GameUpdateTimerTask(game);
		timer = new Timer();
		timer.schedule(gameUpdateTask, 0, 1000 / ups);
		
		try {
			socket = new DatagramSocket(9021);
		} catch (SocketException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void run() {
		//TODO change to game.isRunning
		while(true) {
			byte[] data = new byte[1024];
			DatagramPacket receivePacket = new DatagramPacket(data, data.length);
			
		}			
	}
	
	public void sendLoop() {
		
		//TODO change to game.isRunning
		while(true) {
			if(moveObserver.isHasMoved()) {
				//TODO send move packet
			}
		}
	}
	
	public boolean sendPacket(Packet packet) {
		DatagramPacket dataPacket = new DatagramPacket(packet.getData(), packet.getData().length, packet.getAddress(), packet.getPort());
		try {
			socket.send(dataPacket);
			return true;
		} catch (IOException e) {
			e.printStackTrace();
			return false;
		}
	}
}
