package Player_pack;
import java.io.*;

import Position_pack.*;
import Pieces_pack.*;
import Board_pack.*;
import Bishop_pack.*;
import Pawn_pack.*;
import Rook_pack.*;
import King_pack.*;
import Queen_pack.*;
import Knight_pack.*;
import java.util.*;


public class Player  implements Serializable
{
	String team_clr;	
	King king;
	Pawn pawn;
	
		public Player(String clr)
		{
		
			team_clr=clr;
			int fst_row=0,sec_row=0;
			
			if(clr.equals("white"))
			{
				fst_row=0;
				sec_row=1;
			}
			else if(clr.equals("black"))
			{
				fst_row=7;
				sec_row=6;
			}
			
			Rook rook_left=new Rook(new Position(0,fst_row),clr);
			Board.piece[0][fst_row]=rook_left;
			
			Knight horse_left=new Knight(new Position(1,fst_row),clr);
			Board.piece[1][fst_row]=horse_left;
			
			Bishop bishop_left=new Bishop(new Position(2,fst_row),clr);
			Board.piece[2][fst_row]=bishop_left;
			
			Queen queen=new Queen(new Position(3,fst_row),clr);
			Board.piece[3][fst_row]=queen;
			
			king=new King(new Position(4,fst_row),clr);
			Board.piece[4][fst_row]=king;
			
			Bishop bishop_right=new Bishop(new Position(5,fst_row),clr);
			Board.piece[5][fst_row]=bishop_right;

			Knight horse_right=new Knight(new Position(6,fst_row),clr);
			Board.piece[6][fst_row]=horse_right;
	
			
			Rook rook_right=new Rook(new Position(7,fst_row),clr);
			Board.piece[7][fst_row]=rook_right;
			
		
			
			int i;
			
			for(i=0;i<8;i++)
			{
				 pawn=new Pawn(new Position(i,sec_row),clr);
				Board.piece[i][sec_row]=pawn;

			}
		}
		
		public Position validentry()
		{
			Position move=new Position(0,0);
			Scanner scan=new Scanner(System.in);
			System.out.println("Enter the x-coordinate");
			int x=scan.nextInt();
			
				while(x>7 || x<0)
				{
					System.out.println("Enter a valid coordinate");
					x=scan.nextInt();
				}
				
			move.x=x;
			System.out.println("Enter the y-coordinate");
			int y=scan.nextInt();
			
				while(y>7 || y<0)
				{
					System.out.println("Enter a valid coordinate");
					y=scan.nextInt();
				}
			move.y=y;
			
			return move;	
			
		}
		
		public void update(Position init_pos,Position final_pos)
		{
			Board.piece[init_pos.x][init_pos.y].init_pos=final_pos;
			Board.piece[final_pos.x][final_pos.y]=Board.piece[init_pos.x][init_pos.y];
			Board.piece[init_pos.x][init_pos.y]=null;
			
		}
		
		public void chance()
		{
			Scanner scan=new Scanner(System.in);
			Piece temp;
			
			System.out.println("Enter the "+team_clr+" player's co-ordinates");
			System.out.println();
			
				System.out.println("Enter the initial Position");
				Position init_pos=validentry();	
				System.out.println();
				temp=Board.piece[init_pos.x][init_pos.y];
				/*System.out.println(temp.getName());*/
				
				while(temp==null)
				{
					System.out.println("you have entered a null position");
					System.out.println("Enter a valid position");
					init_pos=validentry();
					System.out.println();
					temp=Board.piece[init_pos.x][init_pos.y];					
				}
				
				while(!temp.team_clr.equals(team_clr))
				{
					System.out.println("you have made an invalid move");
					init_pos=validentry();
					temp=Board.piece[init_pos.x][init_pos.y];
					
							while(temp==null)
							{
								System.out.println("you have entered a null position");
								System.out.println("Enter a valid position");
								init_pos=validentry();
								System.out.println();
								temp=Board.piece[init_pos.x][init_pos.y];					
							}
				}
				
				
			System.out.println("Enter the final position");
			Position final_pos=validentry();
			System.out.println();
			System.out.println();
			
			boolean possible=temp.validmove(final_pos);
				int ch;
				
				if(possible==false)
				{
					
					System.out.println("you have made an invalid move");
					System.out.println();
					System.out.println("Enter 1- to change the initial position");
					System.out.println("Enter 2-to make a valid move");
					System.out.println("Enter u r choice");
					ch=scan.nextInt();
					
					if(ch==2)
					{
						while(possible==false)
						{
						System.out.println("you have entered an invalid move");
						final_pos=validentry();
						possible=temp.validmove(final_pos);
						}
					}
					
					else if(ch==1)
					{
						
						chance();
					}
					  
				}
				
				if(possible==true)
				{
					
					  Piece orig=Board.piece[init_pos.x][init_pos.y];
					  
					  temp=Board.piece[final_pos.x][final_pos.y];
					   
				      update(init_pos,final_pos);
					  
					if(temp!=null)
					{
						 System.out.println(temp.getName());
						 
						if(final_pos.y==7 && temp.getName().equals("Pawn"))
						{
							System.out.println("Choose the piece you want to be back on board");
							String again=scan.nextLine();
							pawn.re_entry(final_pos,again);
							
						}
						
						if(final_pos.y==0 && temp.getName().equals("Pawn"))
						{
							System.out.println("Choose the piece you want to be back on board");
							String again=scan.nextLine();
							pawn.re_entry(final_pos,again);
						}
					  
						if(orig.getName().equals("King"))
						{
							king.init_pos=final_pos;
							
						}
					  
					    if(king.check())
						{
							Board.piece[init_pos.x][init_pos.y]=orig;
							Board.piece[final_pos.x][final_pos.y]=temp;
								
								if(orig.getName().equals("King"))
								{
									king.init_pos=init_pos;
							
								}
								
							System.out.println("you have made an invalid move ");
							System.out.println("your king is in check");
							System.out.println("Enter 1- to change the initial position");
							System.out.println("Enter 2-to make a valid move");
							System.out.println("Enter u r choice");
							ch=scan.nextInt();
							
							if(ch==2)
							{

							final_pos=validentry();
							possible=temp.validmove(final_pos);
							
							}
							
							else if(ch==1)
							{
								chance();
								
							}
							
							else
							{
								System.exit(0);
								
							}
						}
					}
					
					else if(temp==null)
					{
						if(orig.getName().equals("King"))
						{
							king.init_pos=final_pos;
							
						}
					  
					    if(king.check())
						{
							Board.piece[init_pos.x][init_pos.y]=orig;
							Board.piece[final_pos.x][final_pos.y]=temp;
								
								if(orig.getName().equals("King"))
								{
									king.init_pos=init_pos;
							
								}
								
							System.out.println("you have made an invalid move ");
							System.out.println("your king is in check");
							System.out.println("Enter 1- to change the initial position");
							System.out.println("Enter 2-to make a valid move");
							System.out.println("Enter u r choice");
							ch=scan.nextInt();
							
							if(ch==2)
							{

							final_pos=validentry();
							possible=temp.validmove(final_pos);
							
							}
							
							else if(ch==1)
							{
								chance();
								
							}
							
							else
							{
								System.exit(0);
								
							}
						}
						
					}
				}
		}
		
		boolean res=false,res1=false;
		
		public boolean posible()
		{
			res=king.movepossible();
			return res;
			
		}
		
		public boolean kingcheck()
		{
			res1=king.check();
					
				/*if(res1==true )
				{
					Piece reason=Board.piece[final_pos.x][final_pos.y];
					System.out.println(reason.getName());
					
				}*/
			return res1;
			
		}
}