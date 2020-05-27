package Pieces_pack;
import java.io.*;

import Position_pack.*;
import java.lang.String;

abstract public class Piece implements Serializable
{
	 public Position init_pos;
	 public String team_clr;
	 
	 public abstract boolean validmove(Position final_pos);
	 
	 /*public static void move(Position init_pos,Position final_pos);*/
	 
	 public String getName()
	 {
		 Class c=this.getClass();
		 return c.getSimpleName();	// returns the class name 		 
	 }
	 
	 public String toString()
	 {
		 Class c=this.getClass();
		 
		 if(c.getSimpleName().equals("King"))
		 {
			 return team_clr.charAt(0)+c.getSimpleName();	//if it is a king,display it on the screen
			 
		 }
		 else
		 {
			 
			return " "+team_clr.charAt(0)+" "+c.getSimpleName().charAt(0)+" ";	//displaying the pieces on the screen
		 }
	 }
	 
}
