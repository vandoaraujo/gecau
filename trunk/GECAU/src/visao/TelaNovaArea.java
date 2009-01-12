package visao;

import java.awt.Rectangle;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import modelo.Area;

public class TelaNovaArea extends JDialog {

	private static final long serialVersionUID = 1L;
	private JPanel jContentPane = null;
	private JLabel novaAreaLabel = null;
	private JTextField novaAreaField = null;
	private JLabel info = null;
	private JButton confirmaArea = null;

	/**
	 * This is the default constructor
	 */
	public TelaNovaArea() {
		super();
		initialize();
	}

	/**
	 * This method initializes this
	 * 
	 * @return void
	 */
	private void initialize() {
		this.setSize(547, 229);
		this.setContentPane(getJContentPane());
		this.setTitle("JFrame");
		this.setLocationRelativeTo(null);
	}

	/**
	 * This method initializes jContentPane
	 * 
	 * @return javax.swing.JPanel
	 */
	private JPanel getJContentPane() {
		if (jContentPane == null) {
			info = new JLabel();
			info.setBounds(new Rectangle(165, 10, 187, 22));
			info.setText("Informe o nome da Nova Area");
			novaAreaLabel = new JLabel();
			novaAreaLabel.setBounds(new Rectangle(13, 57, 121, 22));
			novaAreaLabel.setText("Nome Area:");
			jContentPane = new JPanel();
			jContentPane.setLayout(null);
			jContentPane.add(novaAreaLabel, null);
			jContentPane.add(getNovaAreaField(), null);
			jContentPane.add(info, null);
			jContentPane.add(getConfirmaArea(), null);
		}
		return jContentPane;
	}

	/**
	 * This method initializes novaAreaField	
	 * 	
	 * @return javax.swing.JTextField	
	 */
	private JTextField getNovaAreaField() {
		if (novaAreaField == null) {
			novaAreaField = new JTextField();
			novaAreaField.setBounds(new Rectangle(149, 55, 365, 28));
		}
		return novaAreaField;
	}

	/**
	 * This method initializes confirmaArea	
	 * 	
	 * @return javax.swing.JButton	
	 */
	private JButton getConfirmaArea() {
		if (confirmaArea == null) {
			confirmaArea = new JButton();
			confirmaArea.setBounds(new Rectangle(169, 133, 193, 34));
			confirmaArea.setText("OK");
		}
		return confirmaArea;
	}
	
	public void configuraOuvinte(ActionListener ouvinte)
	{
		confirmaArea.addActionListener(ouvinte);
		confirmaArea.setActionCommand("ok");
	}
	
	public void visualizaTela()
	{
		this.setVisible(true);
	}
	
	
	public String novaArea()
	{
		String nomeArea = novaAreaField.getText();
		return nomeArea;
		
	}

}  //  @jve:decl-index=0:visual-constraint="10,10"
