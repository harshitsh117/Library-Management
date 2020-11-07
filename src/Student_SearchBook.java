import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

//import com.sun.org.apache.xalan.internal.xsltc.compiler.util.ErrorMessages;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.awt.event.ActionEvent;

public class Student_SearchBook extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	String quantity="";
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Student_SearchBook frame = new Student_SearchBook();
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
	public Student_SearchBook() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 450);
		setLocationRelativeTo(this);
		contentPane = new JPanel();
		setTitle("Search Book");
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JPanel contentPane_1 = new JPanel();
		contentPane_1.setBorder(new EmptyBorder(5, 5, 5, 5));
		
		JButton btnSearch = new JButton("Search");
		btnSearch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
				// to Search the details of the book of given ID
				
				
				// if textField is left empty than this message will pop-up.
				if (textField.getText().equals(""))
				{
					JOptionPane.showMessageDialog(getParent(), "Please enter BookID");
				}
				else {
					
					//This algorithm will find book details and insert them in respective  textfields.  
					Connection con=DBInfo.con;
					String query="select * from BookData where BookID=?";
					try {
						PreparedStatement ps=con.prepareStatement(query);
						ps.setString(1, textField.getText());
						
						ResultSet rs=ps.executeQuery();
						
						while(rs.next()) {
							
							textField.setText(rs.getString(1));
							textField_1.setText(rs.getString(2));
							quantity = rs.getString(3);		
						}
						
						
						 int num_of_books=Integer.parseInt(quantity);
						
						 //If the books are present in the database then it will show Available.
						if (num_of_books>0) {
							textField_2.setText("Available");
						}
						
						//If the books are present in the database then it will show Available.
						else {
							textField_2.setText("Not Available");
						}
						
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					
					
					
				}
			}
		});
		
		JLabel lblAvailability = new JLabel("Availability");
		
		JLabel lblEnterBookId = new JLabel("Enter Book ID");
		
		JLabel lblEnterBookName = new JLabel("Book Name");
		
		JLabel label = new JLabel("");
		
		textField = new JTextField();
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		
		textField_2 = new JTextField();
		textField_2.setEditable(false);
		textField_2.setColumns(10);
		
		JButton btnIssue = new JButton("Issue");
		btnIssue.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				// After clicking on Issue Button book will be issued
				//And quantity of the book will be reduced to one.
				
				int num_of_books = 0;

				Connection con=DBInfo.con;
				String query="select * from BookData where BookID=?";
				try {
					PreparedStatement ps=con.prepareStatement(query);
					ps.setString(1, textField.getText());
					
					ResultSet rs=ps.executeQuery();
					
					while(rs.next()) {
						
						quantity = rs.getString(3);
						
					}
					
					num_of_books=Integer.parseInt(quantity);
					
				
					
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
				int i=0;
				
				if (num_of_books==0) {
					JOptionPane.showMessageDialog(getParent(), "Book not available");
				}
				else {
					
						String query1="update BookData set Quantity=? where BookId=?";
						try {
							
							PreparedStatement ps1=con.prepareStatement(query1);
							ps1.setLong(1, num_of_books-1);
							ps1.setString(2, textField.getText());
							i=ps1.executeUpdate();
							
							if (i==0) {
								JOptionPane.showMessageDialog(getParent(), "Book not Issued.");
							}
							if (i==1) {
								
								JOptionPane.showMessageDialog(getParent(), "Book issued Successfully");
							}
							
						
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					
				}
			}
		});
		
		JButton btnSubmit = new JButton("Submit");
		btnSubmit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				int num_of_books = 0;
				

				Connection con=DBInfo.con;
				String query="select * from BookData where BookID=?";
				try {
					PreparedStatement ps=con.prepareStatement(query);
					ps.setString(1, textField.getText());
					
					ResultSet rs=ps.executeQuery();
					
					while(rs.next()) {
						
						quantity = rs.getString(3);
						
					}
					
					num_of_books=Integer.parseInt(quantity);
					
				
					
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
				int i=0;
				
				String query1="update BookData set Quantity=? where BookID = ?";
				
				try {
					
					PreparedStatement ps = con.prepareStatement(query1);
					ps.setLong(1, num_of_books+1);
					ps.setString(2, textField.getText());
					i=ps.executeUpdate();
					
					if (i==1) {
						
						JOptionPane.showMessageDialog(getParent(), "Book submitted successfully.");
					}
					if (i==0) {
						
						JOptionPane.showMessageDialog(getParent(), "Book not submitted!!!");
					}
							
					
					
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
				
				
			}
		});
		
		JButton btnBack = new JButton("Back");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			
				new StudentLogin().setVisible(true);
				dispose();
			
			}
		});
		GroupLayout gl_contentPane_1 = new GroupLayout(contentPane_1);
		gl_contentPane_1.setHorizontalGroup(
			gl_contentPane_1.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane_1.createSequentialGroup()
					.addGap(40)
					.addGroup(gl_contentPane_1.createParallelGroup(Alignment.LEADING)
						.addComponent(lblEnterBookId)
						.addComponent(label)
						.addGroup(gl_contentPane_1.createParallelGroup(Alignment.TRAILING)
							.addComponent(lblAvailability, GroupLayout.PREFERRED_SIZE, 77, GroupLayout.PREFERRED_SIZE)
							.addComponent(lblEnterBookName)
							.addComponent(btnSearch)))
					.addGroup(gl_contentPane_1.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane_1.createSequentialGroup()
							.addGap(83)
							.addGroup(gl_contentPane_1.createParallelGroup(Alignment.LEADING)
								.addComponent(textField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(textField_1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(textField_2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
						.addGroup(gl_contentPane_1.createSequentialGroup()
							.addGap(43)
							.addGroup(gl_contentPane_1.createParallelGroup(Alignment.TRAILING)
								.addComponent(btnBack)
								.addComponent(btnIssue))
							.addGap(60)
							.addComponent(btnSubmit)))
					.addContainerGap(47, Short.MAX_VALUE))
		);
		gl_contentPane_1.setVerticalGroup(
			gl_contentPane_1.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane_1.createSequentialGroup()
					.addGap(59)
					.addGroup(gl_contentPane_1.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblEnterBookId)
						.addComponent(textField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(42)
					.addGroup(gl_contentPane_1.createParallelGroup(Alignment.LEADING)
						.addComponent(label)
						.addGroup(gl_contentPane_1.createSequentialGroup()
							.addGap(9)
							.addComponent(lblEnterBookName))
						.addComponent(textField_1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(69)
					.addGroup(gl_contentPane_1.createParallelGroup(Alignment.BASELINE)
						.addComponent(textField_2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblAvailability))
					.addPreferredGap(ComponentPlacement.RELATED, 64, Short.MAX_VALUE)
					.addGroup(gl_contentPane_1.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnSearch)
						.addComponent(btnIssue)
						.addComponent(btnSubmit))
					.addGap(37)
					.addComponent(btnBack)
					.addContainerGap())
		);
		contentPane_1.setLayout(gl_contentPane_1);
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(Alignment.TRAILING, gl_contentPane.createSequentialGroup()
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
					.addComponent(contentPane_1, GroupLayout.PREFERRED_SIZE, 450, GroupLayout.PREFERRED_SIZE)
					.addContainerGap())
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.TRAILING)
				.addGroup(Alignment.LEADING, gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addComponent(contentPane_1, GroupLayout.PREFERRED_SIZE, 405, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(29, Short.MAX_VALUE))
		);
		contentPane.setLayout(gl_contentPane);
	}

}
