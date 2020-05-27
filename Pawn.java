package Pawn_pack;
import java.io.*;

import Pieces_pack.*;
import Board_pack.*;
import java.util.*;
import Position_pack.*;
import Queen_pack.*;
import Knight_pack.*;
import Rook_pack.*;
import Bishop_pack.*;


public class Pawn extends Piece implements Serializable
{
	
	public Pawn(Position pos,String clr)			//constructor for pawn class
	{
		init_pos=pos;
		team_clr=clr;		
	}
	
	public boolean validmove(Position final_pos)		//check whether the move made is valid or not
	{
		int sub_x=final_pos.x-init_pos.x;
		int sub_y=final_pos.y-init_pos.y;
		
		Scanner scan=new Scanner(System.in);
		boolean res=false;
		Piece temp=null;
		int i;
		int c;
		/*System.out.println(sub_x+" "+sub_y);*/
		
			if(sub_y>0 && team_clr.equals("white"))
			{
				
				if((sub_x==-1 || sub_x==1) && (sub_y==1))	// pawn can move only one step forward slantly if the other piece is of opposite colour
				{				
					temp=Board.piece[final_pos.x][final_pos.y];
					
					if(temp!=null)		// checking if the piece at the final pos is empty of filled, and if it is not filled 
					{
						if((temp.team_clr).equals("black"))	// if the colour is of opposite type
						{
							res=true;	// retuning boolean value true
						}
					}
				}
				
				else if(sub_x==0)	// if it is moving forward, if it is at the starting position,	it can make 2 steps 
 				{
					
					if(sub_y==1)	// if it is making one step independent of the starting position
					{
						temp=Board.piece[final_pos.x][final_pos.y];
						
						if(temp==null)
						{
							res=true;
						}
					}
					
					else if(sub_y==2 && init_pos.y==1)// if it is making 2 positions,checking whether the starting position is 1 or not 
					{
							i=1;
							c=0;
							
								while(i<=2)
								{
									temp=Board.piece[init_pos.x][init_pos.y+i];
									
										if(temp!=null)
										{
											break;
										}
										else
										{
											c++;
										}
									i++;
								}
								
								if(c==2)
								{
									res=true;
								}
					}
							
				}
			}
				
			else if(sub_y<0 && team_clr.equals("black"))	// same as above follows if the player_clr is black
			{
				if((sub_x==-1 || sub_x==1) && (sub_y==-1))
				{		
					/*System.out.println(sub_x+" "+sub_y);*/
					temp=Board.piece[final_pos.x][final_pos.y];
		
					if(temp!=null)
					{
						if((temp.team_clr).equals("white"))
						{
							res=true;
						}
					}
				}
				
				else if(sub_x==0)
				{
					if(sub_y==-1 )
					{
						temp=Board.piece[final_pos.x][final_pos.y];
						
						if(temp==null)
						{
							res=true;
						}
					}
					else if(sub_y==-2 && init_pos.y==6)
					{
						i=1;
						c=0;
							
							while(i<=2)
							{
								temp=Board.piece[init_pos.x][init_pos.y-i];
								
									if(temp!=null)
									{
										break;
									}
									else
									{
										c++;
									}
								i++;
							}
								
							if(c==2)
							{
								res=true;
							}
										
					}
				}
			}
			return res;
		
	}

	public void re_entry(Position final_pos,String again)	// if the player's pawn reaches the opposite end line , he will get a chance to re-enter the killed pieces 
	{
		Scanner scan=new Scanner(System.in);
		
		
				switch(again)		// switch case for choosing which piece to re-enter on the board
								{
								
									case "Queen":
											if(again.equals("Queen"))
										{
												Queen queen=new Queen(new Position(final_pos.x,final_pos.y),team_clr);
												Board.piece[final_pos.x][final_pos.y]=queen;
												break;
											
										}
									case "Bishop":
											if(again.equals("Bishop"))
										{
												Bishop bishop=new Bishop(new Position(final_pos.x,final_pos.y),team_clr);
												Board.piece[final_pos.x][final_pos.y]=bishop;
												break;
											
										}
									case  "Rook":
											if(again.equals("Rook"))
										{
												Rook rook=new Rook(new Position(final_pos.x,final_pos.y),team_clr);
												Board.piece[final_pos.x][final_pos.y]=rook;
												break;
											
										}
									case  "Knight":
											if(again.equals("Knight"))
										{
												Knight knight=new Knight(new Position(final_pos.x,final_pos.y),team_clr);
												Board.piece[final_pos.x][final_pos.y]=knight;
												break;
												
										}
									
									default:
												System.out.println("you have entered an invalid input");	// if it is not the above pieces this will ask for a valid input
												String 	returns=scan.nextLine();
												re_entry(final_pos,returns);
												
								}
		
	}
}		