import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.HashMap;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class LunchPlanning {
	static HashMap<Date, Urna> urnas = new HashMap<Date, Urna>();
	static Urna urna1 = null;
	public static void main(String[] args) {	
		if(urnas.containsKey(new Date())) {
			urna1 = urnas.get(new Date());
		}else urnas.put(new Date(), urna1 = new Urna());
		//Tests
		System.out.println(addVoto(urna1,"Willian","Qoppa"));
		urna1.voteDate = addDays(new Date(),-2);
		urnas.put(addDays(new Date(),-2),urna1);
		System.out.println(addVoto(urna1,"TT","Qoppa"));
		System.out.println(urna1.apuracaoVotos());
		
		
		
		
		//ScreenTest
		javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                createAndShowGUI();
            }
        });
		
	}
	
	static String addVoto(Urna urnaHoje,String votante,String voto) {
		if(verificaVotadoSemana(voto)) {
			return voto+" já ganhou esta semana!";
		}
		String msg = urnaHoje.addVoto(votante, voto);
		urnas.put(new Date(), urnaHoje);
		return msg;
	}
	
	static boolean verificaVotadoSemana(String voto) {
		for(int i = 1;i<=7;i++) {
			if(urnas.containsKey(addDays(new Date(),-i))) {
				if(urnas.get(addDays(new Date(),-i)).getGanhador().equals(voto)) {
					return true;
				}
			}
		}
		
		return false;
	}
	
	public static Date addDays(Date date, int days) {
		GregorianCalendar cal = new GregorianCalendar();
		cal.setTime(date);
		cal.add(Calendar.DATE, days);
				
		return cal.getTime();
	}
	
	private static void createAndShowGUI() {
		JFrame f=new JFrame("LunchPlanning!"); 
		//submit button
		JButton b=new JButton("Votar");    
		b.setBounds(100,150,140, 40);    
				//enter name label
		JLabel profLabel = new JLabel();		
		profLabel.setText("Profissional :");
		profLabel.setBounds(10, 10, 100, 100);
		JTextField profField= new JTextField();
		profField.setBounds(110, 50, 130, 30);
				//empty label which will show event after button clicked
		JLabel label1 = new JLabel();
		label1.setBounds(10, 180, 200, 100);
				//textfield to enter name
		JLabel restLabel = new JLabel();
		restLabel.setText("Restaurante :");
		restLabel.setBounds(10, 50, 100, 100);
		JTextField restField= new JTextField();
		restField.setBounds(110, 90, 130, 30);
				//add to frame
		f.add(label1);
		f.add(profField);
		f.add(profLabel);
		f.add(restLabel);
		f.add(restField);
		f.add(b);    
		f.setSize(300,300);    
		f.setLayout(null);    
		f.setVisible(true);    
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);   
		
						//action listener
		b.addActionListener(new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent arg0) {
			String msg = addVoto(urna1,profField.getText(), restField.getText());
			label1.setText(msg);
			System.out.println(urna1.apuracaoVotos());
								
		}          
		});
		
    }

}
