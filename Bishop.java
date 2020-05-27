package Bishop_pack;

import java.io.*;
import Pieces_pack.*;
import  Board_pack.*;
import java.util.*;
import Position_pack.*;


public class Bishop extends Piece  implements Serializable
{
	public Bishop(Position pos,String clr)
	{
		init_pos=pos;
		team_clr=clr;
	
	}
	
	public boolean validmove(Position final_pos)
	{
		int sub_x=final_pos.x-init_pos.x;
		int sub_y=final_pos.y-init_pos.y;
		boolean res=false;
		Piece temp;
		Piece orig=Board.piece[init_pos.x][init_pos.y];
		
		int start=0,end=0,start1=0,end1=0;
		int i,j,c=0;
		
			if(sub_x!=0 && sub_y>0) 
			{
					start=init_pos.x;
					end=final_pos.x;
					start1=init_pos.y;
					end1=final_pos.y;
					
				if(sub_x>0 && sub_x==sub_y)
				{
						
							c=0;
					
						for(i=start+1,j=start1+1;(i<end && j<end1);i++,j++)
						{
							
							System.out.println(i+" "+j);
							temp=Board.piece[i][j];
											
							  if(temp!=null)
							  {
								 /* if(orig.equals(temp))
								  {
									c++; 
								  }
								  else if(!orig.team_clr.equals(temp.team_clr))
								  {
								
									  c++;
								  }
								  else if(orig.team_clr.equals(temp.team_clr))
								  {
									  res=false;
									  break;
								  }*/
								  break;
							  }
							  else if(temp==null)
							  {
								 c++; 
								  
							  }

						}
						
				}				
				else if(sub_x<0 && sub_x==-sub_y)
				{	
			
							c=0;
	
					for(i=start-1,j=start1+1;(i>end && j<end1);i--,j++)
					{
						
						System.out.println(i+" "+j);		
							temp=Board.piece[i][j];
							
							  if(temp!=null)
							  {
								  /*if(orig.equals(temp))
								  {
									c++; 
								  }
								   else if(!orig.team_clr.equals(temp.team_clr))
								  {
									  
									  c++;
								  }
								  else if(orig.team_clr.equals(temp.team_clr))
								  {
									  res=false;
									  break;
								  }*/
								  break;
							  }							  
							  else if(temp==null)
							  {
								 c++; 
								  
							  }							
				
					}
					
				}
				
			}
				
			else if(sub_x!=0 && sub_y<0)
			{
				
				start=init_pos.x;
				end=final_pos.x;
				start1=init_pos.y;
				end1=final_pos.y;
					
				if(sub_x>0 && sub_x==-sub_y)
				{		
					
					c=0;
					
					for(i=start+1,j=start1-1;(i<end && j>end1);i++,j--)
					{
						System.out.println(i+" "+j);
							temp=Board.piece[i][j];
							
							  if(temp!=null)
							  {
								  /*if(orig.equals(temp))
								  {
									c++; 
								  }
								  else  if(!orig.team_clr.equals(temp.team_clr))
								  {
									  c++;
								  }
								  else if(orig.team_clr.equals(temp.team_clr))
								  {
									  res=false;
									  break;
								  }*/
								  break;
							  }
							  else if(temp==null)
							  {
								 c++; 								  
							  }

					}
					
				}
				
				else if(sub_x<0 && sub_x==sub_y)
				{
					
						c=0;
					
					for(i=start-1,j=start1-1;i>end && j>end1;i--,j--)
					{
						System.out.println(i+" "+j);
							temp=Board.piece[i][j];
							
							  if(temp!=null)
							  {
								  /*if(orig.equals(temp))
								  {
									c++; 
								  }
								  else if(!orig.team_clr.equals(temp.team_clr))
								  {									 
									 c++;
								  }
								  else if(orig.team_clr.equals(temp.team_clr))
								  {
									  res=false;
									  break;
								  }*/
							  }
							  else if(temp==null)
							  {
								 c++; 							  
							  }							
						
					}
					
				}
				
			}
			System.out.println(c+"     "+(start-end));
			System.out.println(sub_x+"   "+sub_y);
			
			if((c==start-end-1 || c==end-start-1) && (sub_x==sub_y || sub_x==-sub_y))
			{
				temp=Board.piece[final_pos.x][final_pos.y];
				
					if(temp==null)
					{
						res=true;
					}
					else
					{
						if(!temp.team_clr.equals(team_clr))
						{
							res=true;
						}
					}
			}
			
		return res;
	}
}