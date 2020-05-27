package Rook_pack;
import java.io.*;

import Pieces_pack.*;
import Board_pack.*;
import java.util.*;
import Position_pack.*;
import java.lang.String;

public class Rook extends Piece  implements Serializable
{
	public Rook(Position pos,String clr)
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
		
		int start=0,end=0,i,c=0;
		
					if(sub_y!=0 && sub_x==0)
					{		
						if(sub_y>0 && sub_y==1)
						{
							start=init_pos.y+1;
							end=final_pos.y;
							c=0;
						
							for(i=start;i<=end;i++)
							{
								temp=Board.piece[init_pos.x][i];
								
									if(temp!=null)
									{
										c++;
										break;
									}
									else
									{
										c++;
									}
							}
							System.out.println(c);
						}
						
						else if(sub_y>0 && sub_y>1)
						{
							start=init_pos.y+1;
							end=final_pos.y-1;
							c=0;
						
							for(i=start;i<=end;i++)
							{
								temp=Board.piece[init_pos.x][i];
								
									if(temp!=null)
									{
										break;
									}
									else
									{
										c++;
									}
							}
							System.out.println(c);
							 
						}
						
						else if(sub_y<0 && sub_y==-1)
						{
							start=init_pos.y-1;
							end=final_pos.y;
							c=0;
							
							for(i=start;i>=end;i--)
							{
								temp=Board.piece[init_pos.x][i];
							
									if(temp!=null)
									{
										c++;
										break;
									}	
									else
									{
										c++;
									}
							
							}
							System.out.println(c);
						}
						
						else if(sub_y<0 && sub_y<-1)
						{
							start=init_pos.y-1;
							end=final_pos.y+1;
							c=0;
							
							for(i=start;i>=end;i--)
							{
								temp=Board.piece[init_pos.x][i];
							
									if(temp!=null)
									{
										break;
									}	
									else
									{
										c++;
									}
							
							}
							System.out.println(c);
							
						}
						
							if(c==(end-start)+1 || c==start-end+1)
							{
								res=true;
							
							temp=Board.piece[final_pos.x][final_pos.y];
								
									if(temp!=null)
									{
										if(!temp.team_clr.equals(orig.team_clr))
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
					
					else if(sub_x!=0 && sub_y==0) 
					{
						if(sub_x>0 && sub_x==1)
						{
							start=init_pos.x+1;
							end=final_pos.x;
							c=0;
						
							for(i=start;i<=end;i++)
							{
								temp=Board.piece[i][init_pos.y];
								
									if(temp!=null)
									{
										c++;
										break;
									}
									else
									{
										c++;
									}		
							}
							System.out.println(c);
						}
						
						else if(sub_x>0 && sub_x>1)
						{
							start=init_pos.x+1;
							end=final_pos.x-1;
							c=0;
						
							for(i=start;i<=end;i++)
							{
								temp=Board.piece[i][init_pos.y];
								
									if(temp!=null)
									{
										break;
									}
									else
									{
										c++;
									}		
							}
							System.out.println(c);
							
						}
						
						else if(sub_x<0 && sub_x==-1)
						{
							start=init_pos.x-1;
							end=final_pos.x;	
							c=0;
						
							for(i=start;i<=end;i--)
							{
								temp=Board.piece[i][init_pos.y];
									if(temp!=null)
									{
										c++;
										break;
									}
									else
									{
										c++;
										
									}
									
							}
							System.out.println(c);
						}
						
						else if(sub_x<0 && sub_x<-1)
						{
							start=init_pos.x-1;
							end=final_pos.x+1;	
							c=0;
						
							for(i=start;i<=end;i--)
							{
								temp=Board.piece[i][init_pos.y];
									if(temp!=null)
									{
										break;
									}
									else
									{
										c++;
										
									}
									
							}
							System.out.println(c);
							
						}
						
							if(c==(end-start)+1 || c==start-end+1)
							{
								res=true;
	
								temp=Board.piece[final_pos.x][final_pos.y];
								
									if(temp!=null)
									{
										if(!temp.team_clr.equals(orig.team_clr))
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
			System.out.println(res);
			return res;
	}
}