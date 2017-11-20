import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.JFrame;


public class LoginFrameView extends JFrame{
	private boolean check;

	public LoginFrameView() throws IOException  {
	
		LoginPanelView view = new LoginPanelView();
        add(view, BorderLayout.CENTER);
		setPreferredSize(new Dimension(700, 400));
		setVisible(true);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		pack();
	}
	public static void main(String[] args) throws IOException {
		new LoginFrameView();
	}
}