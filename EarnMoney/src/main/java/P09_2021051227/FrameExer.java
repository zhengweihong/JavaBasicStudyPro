package P09_2021051227;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.*;

public class FrameExer extends JFrame implements Comparator<Person> {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	//public Vector<Person> vp = new Vector<Person>();
	//public ArrayList<Person> arrp = new ArrayList<Person>();
	public ArrayList<Person> shuzup = new ArrayList(10);
	protected int cnt = 0;

	/**
	 * Create the frame.
	 */
	public FrameExer() {
		
		//setPreferredSize(new Dimension(800, 400));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 604, 403);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(10, 10, 232, 125);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel Label1 = new JLabel("name");
		Label1.setBounds(10, 10, 58, 15);
		panel.add(Label1);
		
		JLabel Label2 = new JLabel("gender");
		Label2.setBounds(10, 46, 58, 15);
		panel.add(Label2);
		
		textField = new JTextField();
		textField.setBounds(78, 7, 132, 21);
		panel.add(textField);
		textField.setColumns(10);
		
		JRadioButton RadioButton1 = new JRadioButton("man");
		RadioButton1.setBounds(74, 42, 58, 23);
		panel.add(RadioButton1);
		
		JRadioButton RadioButton2 = new JRadioButton("woman");
		RadioButton2.setBounds(134, 42, 127, 23);
		panel.add(RadioButton2);
		
		JLabel Label3 = new JLabel("age");
		Label3.setBounds(10, 86, 58, 15);
		panel.add(Label3);
		
		textField_1 = new JTextField();
		textField_1.setBounds(78, 83, 132, 21);
		panel.add(textField_1);
		textField_1.setColumns(10);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(Color.LIGHT_GRAY);
		panel_1.setBounds(266, 10, 223, 125);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		JLabel Label21 = new JLabel("relation");
		Label21.setBounds(10, 10, 58, 15);
		panel_1.add(Label21);
		
		JRadioButton RadioButton3 = new JRadioButton("1");
		RadioButton3.setBounds(90, 6, 127, 23);
		panel_1.add(RadioButton3);
		
		JRadioButton RadioButton4 = new JRadioButton("2");
		RadioButton4.setBounds(90, 47, 127, 23);
		panel_1.add(RadioButton4);
		
		JRadioButton RadioButton5 = new JRadioButton("3");
		RadioButton5.setBounds(90, 84, 127, 23);
		panel_1.add(RadioButton5);
		
		JTextArea textArea = new JTextArea();
		textArea.setBounds(10, 145, 479, 211);
		contentPane.add(textArea);
		
		//add������ӣ�������
		JButton addButton = new JButton("add");
		addButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String name = textField.getText();
				String gender = RadioButton1.isSelected() ? "man":"woman";
				int age = Integer.parseInt(textField_1.getText());
				int relation = 0 ;
				if(RadioButton3.isSelected())	relation=1;
				if(RadioButton4.isSelected())	relation=2;
				if(RadioButton5.isSelected())	relation=3;
				
				Person p = new Person(name,gender,age,relation);
				shuzup.add(p);
				
				if(cnt==0) {
					textArea.setText("name\t gender\t relation\t age\t ");
				}
				String before = textArea.getText();
				textArea.setText(before+"\n"+name+"\t"+gender+"\t"+relation+"\t"+age );
				cnt++;
			}
		});
		addButton.setBounds(504, 112, 61, 23);
		contentPane.add(addButton);
		
		/***********
		*bg ����  ˵��ֻ�� ѡ��һ��
		*******/
		ButtonGroup bg1 = new ButtonGroup();
		bg1.add(RadioButton1);
		bg1.add(RadioButton2);
		
		ButtonGroup bg2 = new ButtonGroup();
		bg2.add(RadioButton3);
		bg2.add(RadioButton4);
		bg2.add(RadioButton5);
		
		/**
		 * SORT�������ڳ�����������������������
		 */
		JButton ButtonSort = new JButton("Sort");
		ButtonSort.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				shuzup.sort(new FrameExer());
				for(int i=0;i<shuzup.size();i++) {
					if(i==0) {
						textArea.setText("name\t gender\t relation\t age\t  *new*");
					}
					String before = textArea.getText();
					textArea.setText(before+"\n"+shuzup.get(i).getName()+"\t"+shuzup.get(i).getGender()+"\t"+shuzup.get(i).getRelation()+"\t"+shuzup.get(i).getAge() );
				}
			}
		});
		ButtonSort.setBounds(504, 333, 61, 23);
		contentPane.add(ButtonSort);
	}

	@Override
	public int compare(Person o1, Person o2) {
		if(o1.getAge() > o2.getAge()) {
			return -1;
		} else if(o1.getAge() < o2.getAge()) {
			return 1;
		} else {
			return 0;
		}
	}

}
 

