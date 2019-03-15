/*
 
 Emmanuel Idehen
 04/03/2018
 
 Program:
 Using any of the buttons to your choosing on the EV3 brick, write program that increments, decrements, and resets a number that is displayed on the screen based a button pressed.
 Also program button that exits the program.
 *******************************
 Algorithm:
 
 1 while button is pressed
 2 check which button is pressed
 3 enter the button presssed function and increment or decrement as possible
   using the left to decrement and right to increment
 4 escape button exits the program.
 */
package com.domain;

import lejos.nxt.Button;

public class buttons
{

	public static void main(String[] args)
    {
		int x=0;
        //loop while true
		while(true)	
		{   //while button is pressed, call function
			Button.waitForAnyPress();
            //Reset when Enter is pressed
			if(Button.ENTER.isDown())
			{
				//reset to 0 when enter is pressed
				x=x*0;
                //ouput to screen
				System.out.print(x);
				
			}
			//decrement when left button is pressed
			if(Button.LEFT.isDown()&& x>=1)
			{
				//decemment x
				x--;
                //print to screen
				System.out.print(x);
				
			}
			//increment if right button is pressed
			if(Button.RIGHT.isDown())
			{
                //increment x
				x++;
				//output to screen
				System.out.print(x);
			}
            //if excape buttonis pressed exit 
			if(Button.ESCAPE.isDown())
			{
				System.exit(0);
				
            }
        }

    }
	
}

 
