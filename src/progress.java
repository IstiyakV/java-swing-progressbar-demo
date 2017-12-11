import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JProgressBar;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.SwingWorker;

import java.awt.Font;

public class progress extends JFrame {

	private JPanel contentPane;
	JProgressBar progressBar;
	private JLabel label;
	JLabel lblLoading;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					progress frame = new progress();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public progress() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		progressBar = new JProgressBar();
		progressBar.setValue(0);
		progressBar.setBounds(88, 93, 273, 14);
		contentPane.add(progressBar);
		
		 lblLoading = new JLabel("Loading...");
		lblLoading.setFont(new Font("Tw Cen MT", Font.BOLD, 20));
		lblLoading.setHorizontalAlignment(SwingConstants.CENTER);
		lblLoading.setBounds(119, 139, 192, 59);
		contentPane.add(lblLoading);
		
		label = new JLabel("");
		label.setBounds(196, 53, 46, 14);
		contentPane.add(label);
		updateProgessBarInBackground loading = new updateProgessBarInBackground();
		loading.execute();
		
		
	}
	
	
	public void updateProgessBar(){
		
		for(int i=0;i<=100;i++){
			progressBar.setValue(i);
			label.setText(i+"%");
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			if(i==100){
				lblLoading.setText("Done");
			}
		}
		
		
	}
	
	public class updateProgessBarInBackground extends SwingWorker<Void, Void>{

		@Override
		protected Void doInBackground() throws Exception {
			// TODO Auto-generated method stub
			updateProgessBar();
			return null;
		}
		
		
	}
}
