import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;


public class MainFrame extends JFrame implements ActionListener {
	public JPanel panel;
	public JLabel label;
	public JButton startButton, pauseButton;
	public JTextField textField;
	public static int countValue = 1;
	public static boolean stop;
	
	public MainFrame() {
		this.setTitle("UnresponsiveUI");
		this.setSize(300,120);
		this.setVisible(true);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		panel = new JPanel();
		label = new JLabel("Number counter:");
		textField = new JTextField(12);
		startButton = new JButton("Start");
		pauseButton = new JButton("Pause");
		
		panel.setLayout(new FlowLayout(FlowLayout.CENTER, 10, 10));
		
		this.add(panel);
		panel.add(label);
		panel.add(textField);
		panel.add(startButton);
		panel.add(pauseButton);
		
		startButton.addActionListener(this);
		pauseButton.addActionListener(this);
	}


	
	@Override
	public void actionPerformed(ActionEvent event) {
		JButton btn = (JButton) event.getSource();
		stop = false;
//		MyThread myThread = new MyThread(textField);
		Thread thread = new Thread(new Runnable() {
			
			@Override
			public void run() {
				if (MainFrame.countValue > 10000) {
				MainFrame.countValue = 1;
			}
			for (int i = 0; i < 10000; i++) {
				if (MainFrame.stop)break;
				
				textField.setText(""+MainFrame.countValue);
				MainFrame.countValue++;			
				try {
					Thread.sleep(100);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			}
		});
		if (btn == startButton) {
			
			thread.start();
			
		}
		if (btn == pauseButton) {
			stop = true;
		}
	}
	
	
	
}

//class MyThread implements Runnable {
//
//	JTextField textField;
//	public MyThread(JTextField textField) {
//		this.textField = textField;
//	}
//	@Override
//	public void run() {
//		if (MainFrame.countValue > 10000) {
//		MainFrame.countValue = 1;
//	}
//	for (int i = 0; i < 10000; i++) {
//		if (MainFrame.stop)break;
//		
//		textField.setText(""+MainFrame.countValue);
//		MainFrame.countValue++;			
//		try {
//			Thread.sleep(100);
//		} catch (InterruptedException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//	}
//	}
//	
//}

//class MyThread extends Thread {
//	
//	JTextField textField;
//	public MyThread(JTextField textField) {
//		
//		this.textField = textField;
//	}
//	@Override
//	public void run() {
//		if (MainFrame.countValue > 10000) {
//			MainFrame.countValue = 1;
//		}
//		for (int i = 0; i < 10000; i++) {
//			if (MainFrame.stop)break;
//			
//			textField.setText(""+MainFrame.countValue);
//			MainFrame.countValue++;			
//			try {
//				MyThread.sleep(100);
//			} catch (InterruptedException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
//		}
//	}
//}