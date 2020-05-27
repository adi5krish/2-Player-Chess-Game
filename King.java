package King_pack;
import java.io.*;

import Pieces_pack.*;
import Board_pack.*;
import java.util.*;
import Position_pack.*;
import Player_pack.*;

public class King extends Piece  implements Serializable
{
	boolean res=false;
	
	public King(Position pos,String clr)
	{
		init_pos=pos;
		team_clr=clr;
	
	}
	
	public boolean validmove(Position final_pos)
	{
		
		
		int sub_x=final_pos.x-init_pos.x;
		int sub_y=final_pos.y-init_pos.y;
		Piece temp;
		Piece orig=Board.piece[init_pos.x][init_pos.y];
		
			if(sub_x==0 || sub_x==1 || sub_x==-1)
			{
				if(sub_y==0 || sub_y==1 || sub_y==-1)
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


	public boolean check()
	{
		int x=init_pos.x;
		int y=init_pos.y;
		/*System.out.println(x+"   "+y);*/
		
		int sub_x=0,sub_y=0;
	
		Piece temp;
		int i,j,count=0,k=0;
		
		for(i=x+1;i<8;i++)
		{
			temp=Board.piece[i][y];
			
				if(temp!=null)
				{	 
					if(!team_clr.equals(temp.team_clr))
					{
				
						if(temp.getName().equals("Rook") || temp.getName().equals("Queen"))
						{
								count++;
						break;
						}
					}
					
					else if(team_clr.equals(temp.team_clr))
					{
						res=false;
						break;
						
					}
				}		
		}
		
		for(i=x-1;i>=0;i--)
		{
		   temp=Board.piece[i][y];
				
				if(temp!=null)
				{
					if(!team_clr.equals(temp.team_clr))
					{
							if(temp.getName().equals("Rook") || temp.getName().equals("Queen"))
						{
		
						count++;
						break;
						}
						
					}
					else if(team_clr.equals(temp.team_clr))
					{
						res=false;
						break;
						
					}
					
				}
		}
		
		for(i=y+1;i<8;i++)
		{
			temp=Board.piece[x][i];
				
				if(temp!=null)
				{
					if(!team_clr.equals(temp.team_clr))
					{
						if(temp.getName().equals("Rook") || temp.getName().equals("Queen"))
						{
		
						count++;
						break;
						}
					}
					else if(team_clr.equals(temp.team_clr))
					{
						res=false;
						break;
					
					}
					
				}
		}
		
		for(i=y-1;i>=0;i--)
		{
			temp=Board.piece[x][i];
				
				if(temp!=null)
				{
					if(!team_clr.equals(temp.team_clr))
					{
						if(temp.getName().equals("Rook") || temp.getName().equals("Queen"))
						{
		
						count++;
						break;
						}
					}
					else if(team_clr.equals(temp.team_clr))
					{
						res=false;
						break;
						
					}
					
				}
		}
		
		for(i=x+1,j=y+1;(i<8 && j<8);i++,j++)
		{
			temp=Board.piece[i][j];
			sub_x=i-x;
			sub_y=j-y;
				
				if(temp!=null)
				{
					if(!team_clr.equals(temp.team_clr))
					{
						if(temp.getName().equals("Bishop") || temp.getName().equals("Queen"))
						{
							count++;
							break;
						}
						else if(temp.getName().equals("Pawn"))
						{
							if(temp.team_clr.equals("black") && sub_y==1 && sub_x==1)
							{
		
								count++;
								break;
								
							}
							
						}
					}
					else if(team_clr.equals(temp.team_clr))
					{
						res=false;
						break;
						
					}
					
				}
		}
		
		for(i=x+1,j=y-1;(i<8 && j>=0);i++,j--)
		{
			temp=Board.piece[i][j];
			sub_x=i-x;
			sub_y=j-y;
				
				if(temp!=null)
				{
					System.out.println(temp);
					
					if(!team_clr.equals(temp.team_clr))
					{
						if(temp.getName().equals("Bishop") || temp.getName().equals("Queen"))
						{
						count++;
						/*System.out.println(count);*/
						
						break;
						}

						else if(temp.getName().equals("Pawn"))
						{	
							if(temp.team_clr.equals("white") && sub_y==-1 && sub_x==1)
							{
								count++;
							break;	
							}
						}
						
					}
					else if(team_clr.equals(temp.team_clr))
					{
						res=false;
						break;
					}
					
				}
			
		}
		
		for(i=x-1,j=y+1;(i>=0 && j<8);i--,j++)
		{
			temp=Board.piece[i][j];
				sub_x=i-x;
			sub_y=j-y;
				if(temp!=null)
				{
					if(!team_clr.equals(temp.team_clr))
					{
						if(temp.getName().equals("Bishop") || temp.getName().equals("Queen"))
						{
						count++;
						break;
						}
						
						else if(temp.getName().equals("Pawn"))
						{ 
							if(temp.team_clr.equals("black") && sub_y==1 && sub_x==-1)
							{
			
								count++;
								break;
								
							}
							
						}
					}
					else if(team_clr.equals(temp.team_clr))
					{
						res=false;
						break;
						
					}
					
				}
			
		}
		
		for(i=x-1,j=y-1;(i>=0 && j>=0);i--,j--)
		{
			temp=Board.piece[i][j];
			
			sub_x=i-x;
			sub_y=j-y;
			
				if(temp!=null)
				{
					if(!team_clr.equals(temp.team_clr))
					{
						if(temp.getName().equals("Bishop") || temp.getName().equals("Queen"))
						{
						count++;
						break;
						}
						else if(temp.getName().equals("Pawn"))
						{
							if(temp.team_clr.equals("white") && sub_y==-1 && sub_x==-1)
							{
				
								count++;
								break;
								
							}
							
						}
					}
					else if(team_clr.equals(temp.team_clr))
					{
						res=false;
						break;
						
					}
				break;
					
				}
			
		}
		
		int index[]={1,-1,2,-2};
		
			for(i=0;i<=1;i++)
			{
				for(j=2;j<=3;j++)
				{
					
					int x_pos=x+index[i];
					int y_pos=y+index[j];
					
						if(x_pos>=0 && x_pos<8 && y_pos>=0 && y_pos<8)
						{
							
							temp=Board.piece[x_pos][y_pos];
							
								if(temp!=null)
								{
									if(temp.getName().equals("Knight"))
									{
										if(!team_clr.equals(temp.team_clr))
										{
											count++;
											break;
											
										}
										
									}
								}
						}
				}
			}
			
			
			for(i=2;i<=3;i++)
			{
				for(j=0;j<=1;j++)
				{
					
					int x_pos=x+index[i];
					int y_pos=y+index[j];
					
						if(x_pos>=0 && x_pos<8 && y_pos>=0 && y_pos<8)
						{
							
							temp=Board.piece[x_pos][y_pos];
							
								if(temp!=null)
								{
									if(temp.getName().equals("Knight"))
									{
										if(!team_clr.equals(temp.team_clr))
										{
											count++;
											break;
											
										}
										
										
									}
								}
						}
				}
			}
			
			
		if(count==1)
		{
		count=0;
		 res=true;
		 
		}
	return res;
		
	}
	
	public boolean movepossible()
	{
		int i,j;
		boolean result=false;
		Position fin_pos=new Position(0,0);

			for(i=-1;i<=1;i++)
			{
				fin_pos.x=init_pos.x+i;
				
				if(fin_pos.x>=0 && fin_pos.x<=7)
				{
					for(j=-1;j<=1;j++)
					{	
			
							fin_pos.y=init_pos.y+j;
						
									if(fin_pos.y>=0 && fin_pos.y<=7)
									{
											
											Piece orig=Board.piece[init_pos.x][init_pos.y];
											Piece temp=Board.piece[fin_pos.x][fin_pos.y];
											
											if(temp!=null)
											{
					
												if(!team_clr.equals(temp.team_clr))
												{
									
												Board.piece[init_pos.x][init_pos.y].init_pos=fin_pos;
												Board.piece[fin_pos.x][fin_pos.y]=Board.piece[init_pos.x][init_pos.y];
												Board.piece[init_pos.x][init_pos.y]=null;
												
													if(check())	
													{
													result=false;
													Board.piece[init_pos.x][init_pos.y]=orig;
													Board.piece[fin_pos.x][fin_pos.y]=temp;
													/*this.init_pos=orig.init_pos;*/
													}
													
													else	
													{
													result=true;
													Board.piece[init_pos.x][init_pos.y]=orig;
													Board.piece[fin_pos.x][fin_pos.y]=temp;
													/*this.init_pos=orig.init_pos;*/
													break;
													
													}
													
												}
										
												else if(team_clr.equals(temp.team_clr))
												{
												result=false;
											
												}
											}								
											
											else if(temp==null)
											{
												
												/*Board.piece[init_pos.x][init_pos.y].init_pos=fin_pos;*/
												Board.piece[fin_pos.x][fin_pos.y]=Board.piece[init_pos.x][init_pos.y];
												Board.piece[init_pos.x][init_pos.y]=null;
												
													if(check())
													{
														Board.piece[init_pos.x][init_pos.y]=orig;
														Board.piece[fin_pos.x][fin_pos.y]=temp;
														/*this.init_pos=orig.init_pos;*/	
														result=false;
													}
									
									
													else	
													{
														Board.piece[init_pos.x][init_pos.y]=orig;
														Board.piece[fin_pos.x][fin_pos.y]=temp;
														/*this.init_pos=orig.init_pos;*/	
														result=true;
														
													break;				
													}
										
											}
											
									}
							}
				
				}
				
			}
		return result;
	}
}