package com.fire.quiz2;// This class must have the code in the run() method, sub-program/routain to slove the maze;
//   seraches for the Java logo based on the provided path/direction algorithm

import java.util.LinkedList;

public class Direction extends Thread{

	Maze maze;
	Position location;
	int[][] mark;
	//使用LinkedList记录操作顺序，进行死角回退
	LinkedList<String> map = new LinkedList<String>();

	Direction(Maze maze, Position location) {
		
		this.maze = maze;
		this.location = location;
		//使用二维数组mark[][]进行标记
		mark = new int[maze.getHeight()][maze.getWidth()];
	}

	public boolean checkDown(){
		if (maze.getCurrRow()+1<maze.getHeight() && mark[maze.getCurrRow()+1][maze.getCurrCol()]==0){
			return true;
		}
		return false;
	}

	public boolean checkUp(){
		if (maze.getCurrRow()-1>=0 && mark[maze.getCurrRow()-1][maze.getCurrCol()]==0){
			return true;
		}
		return false;
	}

	public boolean checkLeft(){
		if (maze.getCurrCol()-1>=0 && mark[maze.getCurrRow()][maze.getCurrCol()-1]==0){
			return true;
		}
		return false;
	}

	public boolean checkRight(){
		if (maze.getCurrCol()+1<maze.getWidth() && mark[maze.getCurrRow()][maze.getCurrCol()+1]==0){
			return true;
		}
		return false;
	}

	// this is the code part that needs to be programmed by students to solve the maze 
	// using the provided path/direction algorithm
	public void run(){

		// this is a SAMPLE code of moving the student image in the maze,
		// and updates the information in Position.jav GUI class, append text into the JTextArea object
		// you should delete this code and start your solution, you may just keep the part of updating the information
		// in the Position.java class, appending information into the JTextArea object

		while(!maze.isDone()) {
            if(checkDown()&&this.maze.moveDown()){
            	map.push("down");
            	mark[maze.getCurrRow()][maze.getCurrCol()]=1;
                location.textArea.append("Moved to row " + maze.getCurrRow() + ", column " + maze.getCurrCol() + "\n");
            }else if(checkLeft()&&this.maze.moveLeft()){
            	map.push("left");
				mark[maze.getCurrRow()][maze.getCurrCol()]=1;
				location.textArea.append("Moved to row " + maze.getCurrRow() + ", column " + maze.getCurrCol() + "\n");
			}else if(checkUp()&&this.maze.moveUp()){
            	map.push("up");
				mark[maze.getCurrRow()][maze.getCurrCol()]=1;
				location.textArea.append("Moved to row " + maze.getCurrRow() + ", column " + maze.getCurrCol() + "\n");
			}else if(checkRight()&&this.maze.moveRight()){
				map.push("right");
				mark[maze.getCurrRow()][maze.getCurrCol()]=1;
				location.textArea.append("Moved to row " + maze.getCurrRow() + ", column " + maze.getCurrCol() + "\n");
			}else {
				String lastStr = map.pop();
				if(lastStr.equals("down")){
					this.maze.moveUp();
				}else if (lastStr.equals("left")){
					this.maze.moveRight();
				}else if(lastStr.equals("up")){
					this.maze.moveDown();
				}else {
					this.maze.moveLeft();
				}
			}

		}	
		
		location.textArea.append("Logo Found \n");
		
	}
   
	
}
