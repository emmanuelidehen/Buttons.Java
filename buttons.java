/*
 Emmanuel Idehen
 3/29/2018
 
 Program Discription : Using the buttons on the EV3 brick, write program that "only" outputs the screen the name of the button when pressed!
 
 Agorithm: while button pressed is true
 - if enter, prints enter button
 - if left, prints left button
 - if rigth, prints right button
 - if escape, prints escape button
 
 */
package com.domain;

import lejos.nxt.Button;

public class buttons
{

	public static void main(String[] args)
    {
		int x=0;
        //while true
		while(true)	
		{
            //Wait for button to be pressed
            //call button pressed function
			Button.waitForAnyPress();
            //Check which button is pressed
            
            //Enter button pressed
			if(Button.ENTER.isDown())
			{
				
				// output the enter button
				System.out.print("The Enter Button is pressed");
				
			}
			//Left button pressed
			if(Button.LEFT.isDown())
			{
				
				//ouput the left button pressed
				System.out.print("The Left Button is Pressed");
				
			}
			//Right Button pressed
			if(Button.RIGHT.isDown())
			{	
				
				//Right button presssed
				System.out.print("The Right Button Is Pressed");
			}
            //Escape button presssed
			if(Button.ESCAPE.isDown())
			{
				// Escape Button Pressed
				System.out.print("The Escape Button is pressed");
            }
            
			}

		}
	
}

 
