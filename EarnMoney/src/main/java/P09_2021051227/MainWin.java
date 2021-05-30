package P09_2021051227;

import java.awt.EventQueue;

public class MainWin {
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		//HashMap<K, V>
		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FrameExer frame = new FrameExer();
					frame.setVisible(true);
					frame.setSize(600, 400);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

}
