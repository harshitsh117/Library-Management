import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.LayoutStyle.ComponentPlacement;

public class AdminOperations extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AdminOperations frame = new AdminOperations();
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
	public AdminOperations() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 469);
		contentPane = new JPanel();
		setLocationRelativeTo(this);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JButton btnAddLibrarian = new JButton("Add Librarian");
		btnAddLibrarian.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			// If Adding Librarian  button is pressed than AddingLibrarian window will appear.
			 new AddingLibrarian().setVisible(true);
			 dispose();
			
			}
		});
		
		JButton btnRemoveLibrarian = new JButton("Remove Librarian");
		btnRemoveLibrarian.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// If RemoveLibrarian button is pressed than RemoveLibrarian window will appear.
				
				new RemoveLibrarian().setVisible(true);
				dispose();
			}
		});
		
		JButton btnAddStudent = new JButton("Add Student");
		btnAddStudent.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// if Adding Student button is clicked then AddingStudent WIndow will appear.
				new AddingStudent().setVisible(true);
				dispose();}
		});
		
		JButton btnRemoveLibrarian_1 = new JButton("Remove Student");
		btnRemoveLibrarian_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// If RemoveStudent button is clicked then RemoveStudent window will appear.
				new RemoveStudent().setVisible(true);
				
				dispose();}
		});
		
		JButton btnAddFaculty = new JButton("Add Faculty");
		btnAddFaculty.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// If AddingFaculty button is clicked than AddingFaculty() window will appear.
				new AddingFaculty().setVisible(true);
				dispose();}
		});
		
		JButton btnRemoveFaculty = new JButton("Remove Faculty");
		btnRemoveFaculty.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				// If Remove Faculty button is clicked than Remove Faculty window will appear.
				new RemoveFaculty().setVisible(true);
				dispose();}
		});
		
		JButton btnBack = new JButton("Back");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			// If Back button is clicked than previous window will appear.
			new AdminLogin().setVisible(true);
			dispose();
			}
		});
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(141)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(btnBack)
						.addComponent(btnAddLibrarian)
						.addComponent(btnRemoveFaculty)
						.addComponent(btnAddFaculty)
						.addComponent(btnRemoveLibrarian_1)
						.addComponent(btnAddStudent)
						.addComponent(btnRemoveLibrarian))
					.addContainerGap(142, Short.MAX_VALUE))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(39)
					.addComponent(btnAddLibrarian)
					.addGap(18)
					.addComponent(btnRemoveLibrarian)
					.addGap(37)
					.addComponent(btnAddStudent)
					.addGap(18)
					.addComponent(btnRemoveLibrarian_1)
					.addGap(34)
					.addComponent(btnAddFaculty)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(btnRemoveFaculty)
					.addPreferredGap(ComponentPlacement.RELATED, 59, Short.MAX_VALUE)
					.addComponent(btnBack)
					.addGap(37))
		);
		contentPane.setLayout(gl_contentPane);
	}
}
