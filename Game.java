package Game;

import Board_pack.*;
import Pieces_pack.*;
import Player_pack.*;
import java.util.*;
import King_pack.*;
import java.io.*;

public class Game  implements Serializable
{

	public static void print()
	{
		int i,j;
		for(i=7;i>=0;i--)
		{
			for(j=0;j<8;j++)
			{
				
				Piece temp=Board.piece[j][i];
					if(temp==null)
					{
						System.out.print(" --- ");
					}
					else
					{
						System.out.print(temp);
					}
			}
			System.out.println();
		}
		
	}
	
	public static void main(String args[]) throws Exception 
	{
		
		Scanner scan=new Scanner(System.in);
		Player white_player=new Player("white");
		Player black_player=new Player("black");
		
		System.out.println("Enter 1-continue the previous game");
		System.out.println("      2-start a new game");
		int choice=scan.nextInt();
		int chance=0;
		
		int ch=0;
		
		if(choice==1)
		{
			FileInputStream fin=new FileInputStream("aditya.txt");		// to continue with the previous game
			ObjectInputStream ois=new ObjectInputStream(fin);
			
			chance=ois.readInt();
			white_player=(Player)ois.readObject();
			black_player=(Player)ois.readObject();
			Board.piece=(Piece[][])ois.readObject();
			ois.close();
			
		}
		
		
		while(ch!=2)
		{
			
			if(chance<=1)
			{
			
					System.out.println("Enter 1 - print and continue");
					System.out.println("Enter any other number  - save & exit");
	
					System.out.println("Enter ur choice");
					ch=scan.nextInt();
		
					if(ch==1)
					{
						print();
				
					}
					else if(ch==2)
					{
						FileOutputStream fos=new FileOutputStream("aditya.txt");		// if want to save the game and play again in the future
						ObjectOutputStream oos=new ObjectOutputStream(fos);
						
						oos.writeInt(1);
						oos.writeObject(white_player);
						oos.writeObject(black_player);
						oos.writeObject(Board.piece);
						oos.close();
						System.exit(0);
						
					}
					
					else
					{
						System.exit(0);
					}
		
					white_player.chance();
			
					if(black_player.kingcheck())
					{
						System.out.println("the black_player king has a check");
				
						if(!black_player.posible())
						{
						System.out.println("the black_player king cannot make a  move ");
					
						}
						else
						{
							System.out.println("the black_player king has a move to make");
							
						}
				
					}
			chance--;
			}
			
			if(chance<=2)
			{
				
					
					System.out.println("Enter 1 - print and continue");
					System.out.println("Enter any other number - save & exit");
			
					System.out.println("Enter ur choice");
					ch=scan.nextInt();
		
					if(ch==1)
					{
						print();
				
					}
					
					else if(ch==2)
					{
						FileOutputStream fos=new FileOutputStream("aditya.txt");
						ObjectOutputStream oos=new ObjectOutputStream(fos);
						
						oos.writeInt(1);
						oos.writeObject(white_player);
						oos.writeObject(black_player);
						oos.writeObject(Board.piece);
						oos.close();
						System.exit(0);
						
					}
					black_player.chance();
			
					if(white_player.kingcheck())
					{
						System.out.println("the white_player king is in check");
				
						if(!white_player.posible())
						{
							System.out.println("the white_player king cannot make a move ");
					
						}
						else 
						{
							System.out.println("the white_player king has a make to move");
							
						}
					}
				chance--;
					
			}	
							
		}	
	}
}	
	