import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.TitledBorder;

public class SelectCourseVeiw extends JFrame{
	private JComboBox<String> box;
	private JButton btn;
	private JLabel label;
	private JLabel name;
	private JLabel lastName;
	private boolean isSelect = false;
	private SelectCourseController scc;
	
	public SelectCourseVeiw(){
		setLayout(new BorderLayout());
		add(setUpName() , BorderLayout.NORTH);
		add(setUp());
		setUpComplete();
		setSize(600, 200);
		setLocationRelativeTo(null);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	public JPanel setUp(){
		JPanel panel = new JPanel();
		panel.setLayout(new FlowLayout());
		box = new JComboBox<>();
		btn = new JButton("Select");
		btn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				FillScoreView fsv = new FillScoreView((String)box.getSelectedItem());
			}
		});
		label = new JLabel("please select your course ");
		panel.add(label);
		panel.add(box);
		panel.add(btn);
		return panel;
	}
	public JPanel setUpName(){
		JPanel panel = new JPanel();
		JPanel panel1 = new JPanel();
		panel1.setLayout(new FlowLayout());
		panel.setLayout(new BorderLayout());
		name = new JLabel("name ");
		lastName = new JLabel("lastName");
		panel1.add(name);
		panel1.add(lastName);
		panel1.setBorder(new TitledBorder("USER"));
		panel.add(panel1, BorderLayout.EAST);
		return panel;
	}
	public void addCourseToBox(String input){
		box.addItem(input);
	}
	public void reStart(){
		box.removeAll();
		isSelect = false;
		name.setText("name ");
		lastName.setText("lastName");
	}
	public String getCourseSelect(){
		return (String) box.getSelectedItem();
	}
	public boolean getIsSelect(){
		return isSelect;
	}
	public void setIsSelect(boolean input){
		isSelect = input;
	}
	public void setNameAndLast(String name, String lastName){
		this.name.setText(name+" ");
		this.lastName.setText(lastName);
	}
	public void setUpComplete(){
		scc = new SelectCourseController("Tanadoon");
		scc.find();
		setNameAndLast(scc.getName(), scc.getLastName());
		ArrayList<String> courseId = scc.getAllCourseId();
		for(String g: courseId){
			addCourseToBox(g);
		}
	}
	public static void main(String[] args){
		SelectCourseVeiw scv = new SelectCourseVeiw();
	}
}
