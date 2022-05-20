// Team Physical :: Weichen Liu, Anjini Katari, Yat long Chan 
// APCS pd08
// HW70 – Thinkers of the Corn / MazeSolver class
// 2022-03-03r
// time spent: 0.8 hours

/***
 * SKEELTON for
 * class MazeSolver
 * Implements a blind depth-first exit-finding algorithm.
 * Displays probing in terminal.
 * 
 * USAGE: 
 * $ java Maze [path/to/mazefile]
 * (mazefile is ASCII representation of a maze, using symbols below)
 *
 * ALGORITHM for finding exit from starting position:
 *  From the given position:
 *  If the hero is at the end, the maze is solved. (primary base case)
 *  If the cell that the hero is on has been traveled to or is a wall, the move is invalid. (other base case)
 *  Otherwise, Recursively travel in all directions (up, down, left, right). If a move is invalid, undo move and back up. 
 *
 *
 * DISCO
 * Use System.exit() to exit the animation instead of just return when exit has been found
 *  
 * QCC
 * How to optimize if maze has more than 1 exit or more than a path to exit?
 ***/

//enable file I/O
import java.io.*;
import java.util.*;


class MazeSolver
{
  final private int FRAME_DELAY = 50;

  private char[][] _maze;
  private int h, w; // height, width of maze
  private boolean _solved;

  //~~~~~~~~~~~~~  L E G E N D  ~~~~~~~~~~~~~
  final private char HERO =           '@';
  final private char PATH =           '#';
  final private char WALL =           ' ';
  final private char EXIT =           '$';
  final private char VISITED_PATH =   '.';
  //~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

  public MazeSolver( String inputFile )
  {
    // init 2D array to represent maze
    // (80x25 is default terminal window size)
    _maze = new char[80][25];
    h = 0;
    w = 0;

    //transcribe maze from file into memory
    try {
      Scanner sc = new Scanner( new File(inputFile) );

      System.out.println( "reading in file..." );

      int row = 0;

      while( sc.hasNext() ) {

        String line = sc.nextLine();

        if ( w < line.length() )
          w = line.length();

        for( int i=0; i<line.length(); i++ )
          _maze[i][row] = line.charAt( i );

        h++;
        row++;
      }

      for( int i=0; i<w; i++ )
        _maze[i][row] = WALL;
      h++;
      row++;

    } catch( Exception e ) { System.out.println( "Error reading file" ); }

    //at init time, maze has not been solved:
    _solved = false;
  }//end constructor


  /**
   * "stringify" the board
   **/
  public String toString()
  {
    //send ANSI code "ESC[0;0H" to place cursor in upper left
    String retStr = "[0;0H";
    //emacs shortcut: C-q, ESC
    //emacs shortcut: M-x quoted-insert, ESC

    int i, j;
    for( i=0; i<h; i++ ) {
      for( j=0; j<w; j++ )
        retStr = retStr + _maze[j][i];
      retStr = retStr + "\n";
    }
    return retStr;
  }


  /**
   * helper method to keep try/catch clutter out of main flow
   * @param n      delay in ms
   **/
  private void delay( int n )
  {
    try {
      Thread.sleep(n);
    } catch( InterruptedException e ) {
      System.exit(0);
    }
  }


  /**
   * void solve(int x,int y) -- recursively finds maze exit (depth-first)
   * @param x starting x-coord, measured from left
   * @param y starting y-coord, measured from top
   **/
  public void solve( int x, int y )
  {
    delay( FRAME_DELAY ); //slow it down enough to be followable

    // stop animation if maze is solved
    if (_solved) {
      System.exit(0);
    }

    //primary base case
    if ( _maze[x][y] == EXIT ) {
      _solved = true;
      System.out.println(this); //refresh screen
      return;
    }

    //other base cases
    else if ( _maze[x][y] != PATH  ) {
      return;
    }
    //otherwise, recursively solve maze from next pos over,
    //after marking current location
    else {
      _maze[x][y] = HERO;
      System.out.println( this ); //refresh screen
	    solve(x, y - 1); // move up
      solve(x, y + 1); // move down
      solve(x - 1, y); // move left
      solve(x + 1, y); // move right

      // back up b/c path did not lead to solution
      _maze[x][y] = VISITED_PATH;
      System.out.println( this ); //refresh screen
    }
  }

  //accessor method to help with randomized drop-in location
  public boolean onPath( int x, int y) {
      return _maze[x][y] == PATH;
  }

  public int getH() {
    return h;
  }

  public int getW() {
    return w;
  }

}//end class MazeSolver


public class Maze
{
  public static void main( String[] args )
  {
    String mazeInputFile = null;

    try {
      mazeInputFile = args[0];
    } catch( Exception e ) {
      System.out.println( "Error reading input file." );
      System.out.println( "USAGE:\n $ java Maze path/to/filename" );
    }

    if (mazeInputFile==null) { System.exit(0); }

    MazeSolver ms = new MazeSolver( mazeInputFile );

    //clear screen
    System.out.println( "[2J" );

    //display maze
    System.out.println( ms );

    //drop hero into the maze (coords must be on path)
    // ThinkerTODO: comment next line out when ready to randomize startpos
    // ms.solve( 4, 3 );

    //drop our hero into maze at random location on path
    int startX = (int) (Math.random() * ms.getW());
    int startY = (int) (Math.random() * ms.getH());
    while (!ms.onPath(startX, startY)) {
       startX = (int) (Math.random() * ms.getW());
       startY = (int) (Math.random() * ms.getH());
    }
    ms.solve( startX, startY );
    /*~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
      ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*/
  }//end main()

}//end class Maze
