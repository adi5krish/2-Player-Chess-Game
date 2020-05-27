package Knight_pack;
import java.io.*;

import Pieces_pack.*;
import  Board_pack.*;
import java.util.*;
import Position_pack.*;

public class  Knight extends Piece  implements Serializable
{
	public Knight(Position pos,String clr)
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
		int i,c;
		
			if(sub_x ==2 || sub_x==-2)
			{
				if(sub_y==1 || sub_y==-1)
				{
					temp=Board.piece[(init_pos.x)+sub_x][(init_pos.y)+sub_y];
					
						if(temp!=null)
						{
							if(!orig.team_clr.equals(temp.team_clr))
							{
							res=true;
							}
							else 
							{
							res=false;
							}
						}
						else
						{
							res=true;
						}
					
				}
			}
			
			else if(sub_x==1 || sub_x==-1)
			{
				if(sub_y==2 || sub_y==-2)
				{
					temp=Board.piece[(init_pos.x)+sub_x][(init_pos.y)+sub_y];
					
					if(temp!=null)
					{
						if(!orig.team_clr.equals(temp.team_clr))
						{
						res=true;
						}
						else 
						{
						res=false;
						}
					}
					else
					{		
					res=true;
					}
				}
			}
		return res;
	}
}