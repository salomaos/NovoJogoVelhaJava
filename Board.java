package Main;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;

public class Board extends JFrame{
	
	boolean firstPlayer = true;
	
	int contadorX = 0;
	int contadorY = 0;
	int playsCounter = 0;
	String[] board = {"0", "0", "0", "0", "0", "0", "0", "0", "0"};
	
	Integer possiblePlays[][] = {
			//Horizontal
			{0, 1, 2},
			{3, 4, 5},
			{6, 7, 8},
			
			//Vertical
			{0, 3, 6},
			{1, 4, 7},
			{2, 5, 8},
			
			//Diagonal
			{0, 4, 8},
			{2, 4, 6}
	};
	
	public Board(){		
		setLayout(null);		
		setSize(316, 340);		
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		setResizable(false);
		getContentPane().setBackground(Color.BLACK);
		init();
		setVisible(true);
	}

	private void init() {
		createButton();
		
	}
	
	private void createButton(){
		for (int i = 0; i < 315; i += 105) {
			for (int j = 0; j < 315; j += 105) {
				JButton button = new JButton();
				
				button.setBounds(i, j, 100, 100);
				button.setBackground(Color.WHITE);
				button.setFont(new Font("SansSerif", Font.BOLD, 80));
				button.setBorder(BorderFactory.createEmptyBorder());
				
				button.addActionListener(new ActionListener() {					
					@Override
					public void actionPerformed(ActionEvent arg0) {
						if(button.getText().equals("")){
							play(button);
						}						
					}
				});
				add(button);
			}
		}		
	}
	
	private void play(JButton button){
		if(firstPlayer){
			button.setText("X");
			board[playsCounter] = "X";
			playsCounter++;
			winnerVerifier();
		}else{
			button.setText("O");
			board[playsCounter] = "O";
			playsCounter++;
			winnerVerifier();
		}
		firstPlayer = !firstPlayer;
	}
	
	private void winnerVerifier(){
		for (int i = 0; i < possiblePlays.length; i++) {
			for (int j = 0; j < 3; j++) {
				if (board[possiblePlays[i][j]].equals("X")){
					System.out.println(board[possiblePlays[i][j]]);
					contadorX++;
				} else if (board[possiblePlays[i][j]].equals("O")) {
					System.out.println(board[possiblePlays[i][j]]);
					contadorY++;
				}
			}
			
		}
		if(contadorX == 3){
			System.out.println("X GANHOU");
		} else if (contadorY == 3){
			System.out.println("O GANHOU");
		}
	}
}
