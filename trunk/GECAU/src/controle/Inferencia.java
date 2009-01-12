package controle;

import javax.swing.JOptionPane;

import jess.JessException;
import jess.Rete;

public class Inferencia {

	Rete rete = new Rete();
		
	public Inferencia()
	{
	  // Read in the rules
	  rete = new Rete();
	  try
	  {
	    rete.executeCommand("(batch GECAU.clp)");
	    rete.executeCommand("(reset)");
	    rete.executeCommand("(run)");
	  }
	  catch (JessException je)
	  {
		  JOptionPane.showMessageDialog(null, je);
	  }
	 
	}
}
