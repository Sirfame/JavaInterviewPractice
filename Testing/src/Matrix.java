public class Matrix {
  
  static final int SIZE = 5;
    
  public static void initial (int [][] array) {
    System.out.println ("initial");
    for (int i = 0; i < SIZE; i++)
      for (int j = 0; j < SIZE; j++)
        array [i][j] = (i+1)*10 + (j+1);
  }
  
  public static void print (int [][] array) {
    for (int r = 0; r < SIZE; r++) {
      for (int c = 0; c < SIZE; c++) 
        System.out.print ("[" + array[r][c] +"] ");
      System.out.println ();
    }
    System.out.println ();
  }
  
  public static void printDiagonalR2L (int [][] array) {
//	  int count = 1;
//	  int times = 1;
//	  int x = 0;
//	  int y = 0;
//	  for (int r = 0; r >= x; r--) {
//		  int y = 0;
//		  while(count > 0) {
//			  //print array
//			  count--;
//		  }
//		  count = times + 1;
//		  times++;
//	      System.out.println ();
//	  }
      for (int count = 0; count < SIZE; count++)
      {
          int row = 0;
          int col = count;
          while (col >= 0) {
        	  System.out.print(array[row][col] + " ");
        	  row++;
        	  col--;
          }
          System.out.println();
      }
      for (int count = 1; count < SIZE; count++)
      {
          int col = SIZE - 1;
          int row = count;
          while (row <= SIZE - 1) {
        	  System.out.print(array[row][col] + " ");
        	  row++;
        	  col--;
          }
          System.out.println();
      }
  }
  
  public static void printDiagonalL2R (int [][] array) {
	  int countY = SIZE - 1;
	  for (int count = 0; count < SIZE; count++)
      {
          int row = 0;
          int col = countY - count;
          while (col <= SIZE - 1) {
        	  System.out.print(array[row][col] + " ");
        	  row++;
        	  col++;
          }
          System.out.println();
      }

	  for (int count = 1; count < SIZE; count++)
      {
          int row = count;
          int col = 0;
          while (row <= SIZE - 1) {
        	  System.out.print(array[row][col] + " ");
        	  row++;
        	  col++;
          }
          System.out.println();
      }
  }
  
  
  public static void left (int [][] array) {
//	  initial
//	  [11] [12] [13] [14] [15] 
//	  [21] [22] [23] [24] [25] 
//	  [31] [32] [33] [34] [35] 
//	  [41] [42] [43] [44] [45] 
//	  [51] [52] [53] [54] [55] 
//
//	  left
//	  [15] [25] [35] [45] [55] 
//	  [14] [24] [34] [44] [54] 
//	  [13] [23] [33] [43] [53] 
//	  [12] [22] [32] [42] [52] 
//	  [11] [21] [31] [41] [51] 
	  
	      
	  
    System.out.println ("left");
    int x = SIZE - 1;
	for (int i = 0; i < SIZE; i++) {
		for (int j = 0; j < SIZE; j++) {
			array [x][j] = (j+1)*10 + (i+1);
		}
		x--;
	}
  }
  
  public static void right (int [][] array) {
//	  initial
//	  [11] [12] [13] [14] [15] 
//	  [21] [22] [23] [24] [25] 
//	  [31] [32] [33] [34] [35] 
//	  [41] [42] [43] [44] [45] 
//	  [51] [52] [53] [54] [55] 
//
//	  right
//	  [51] [41] [31] [21] [11] 
//	  [52] [42] [32] [22] [12] 
//	  [53] [43] [33] [23] [13] 
//	  [54] [44] [34] [24] [14] 
//	  [55] [45] [35] [25] [15] 
	  
	  
	  
    System.out.println ("right");
    for (int i = 0; i < SIZE; i++) {
    	int x = SIZE - 1;
		for (int j = 0; j < SIZE; j++) {
			array [i][x] = (j+1)*10 + (i+1);
			x--;
		}
	 }
  }
  
 public static void horizontal (int [][] array) {
//	 initial
//	 [11] [12] [13] [14] [15] 
//	 [21] [22] [23] [24] [25] 
//	 [31] [32] [33] [34] [35] 
//	 [41] [42] [43] [44] [45] 
//	 [51] [52] [53] [54] [55] 
//
//	 horizontal
//	 [15] [14] [13] [12] [11] 
//	 [25] [24] [23] [22] [21] 
//	 [35] [34] [33] [32] [31] 
//	 [45] [44] [43] [42] [41] 
//	 [55] [54] [53] [52] [51]

    System.out.println ("horizontal");
    int countX = 0;
	for (int i = 0; i < SIZE; i++) {
		int countY = SIZE - 1;
	    for (int j = 0; j < SIZE; j++) {
	    	array [i][j] = (countX+1)*10 + (countY+1);
	    	countY--;
	    }
	      countX++;
	}
  }
  
  

               
  public static void vertical (int [][] array) {
//	  initial
//	  [11] [12] [13] [14] [15] 
//	  [21] [22] [23] [24] [25] 
//	  [31] [32] [33] [34] [35] 
//	  [41] [42] [43] [44] [45] 
//	  [51] [52] [53] [54] [55] 
//
//	  vertical
//	  [51] [52] [53] [54] [55] 
//	  [41] [42] [43] [44] [45] 
//	  [31] [32] [33] [34] [35] 
//	  [21] [22] [23] [24] [25] 
//	  [11] [12] [13] [14] [15] 

    System.out.println ("vertical");
    int countX = SIZE - 1;
	for (int i = 0; i < SIZE; i++) {
		int countY = 0;
	    for (int j = 0; j < SIZE; j++) {
	    	array [i][j] = (countX+1)*10 + (countY+1);
	    	countY++;
	    }
	      countX--;
	}
  }
                
  
  public static void diagonalULLR (int [][] array) {
//	  initial
//	  [11] [12] [13] [14] [15] 
//	  [21] [22] [23] [24] [25] 
//	  [31] [32] [33] [34] [35] 
//	  [41] [42] [43] [44] [45] 
//	  [51] [52] [53] [54] [55] 
//
//	  diagonalULLR
//	  [11] [21] [31] [41] [51] 
//	  [12] [22] [32] [42] [52] 
//	  [13] [23] [33] [43] [53] 
//	  [14] [24] [34] [44] [54] 
//	  [15] [25] [35] [45] [55] 
    System.out.println ("diagonalULLR");
    for (int i = 0; i < SIZE; i++)
        for (int j = 0; j < SIZE; j++)
          array [i][j] = (j+1)*10 + (i+1);
  }
  
  public static void diagonalURLL (int [][] array) {
//	  initial
//	  [11] [12] [13] [14] [15] 
//	  [21] [22] [23] [24] [25] 
//	  [31] [32] [33] [34] [35] 
//	  [41] [42] [43] [44] [45] 
//	  [51] [52] [53] [54] [55] 
//
//	  diagonalURLL
//	  [55] [45] [35] [25] [15] 
//	  [54] [44] [34] [24] [14] 
//	  [53] [43] [33] [23] [13] 
//	  [52] [42] [32] [22] [12] 
//	  [51] [41] [31] [21] [11] 
    System.out.println ("diagonalURLL");
    int x = SIZE - 1;
    for (int i = 0; i < SIZE; i++) {
    	int y = SIZE - 1;
    	for (int j = 0; j < SIZE; j++) {
    		array [x][y] = (j+1)*10 + (i+1);
    		y--;
    	}
    	x--;
    }
  }
        

  public static void main( String [ ] args )
  {
    int [][] array = new int [SIZE][SIZE];
    initial (array);
    print (array);
    left (array);
    print(array);
    initial (array);
    print(array);
    right (array);
    print (array);
    initial (array);
    print(array);
    vertical(array);
    print(array);
    initial (array);
    print(array);
    horizontal(array);
    print(array);
    initial (array);
    print(array);
    diagonalULLR(array);
    print(array);
    initial (array);
    print(array);
    diagonalURLL(array);
    print(array);
    initial (array);
    print(array);
    printDiagonalR2L(array);
    print(array);
    printDiagonalL2R(array);

  }
}

