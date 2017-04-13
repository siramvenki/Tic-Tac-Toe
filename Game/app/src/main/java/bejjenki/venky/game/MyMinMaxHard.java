package bejjenki.venky.game;

public class MyMinMaxHard
{

	char player = 'x', opponent = 'o';
	char p1 = 'o', p2 = 'x';

	// This function returns true if there are moves
	// remaining on the board. It returns false if
	// there are no moves left to play.
	public boolean isMovesLeft(char board[][])
	{
		for (int i = 0; i<3; i++)
			for (int j = 0; j<3; j++)
				if (board[i][j]=='_')
					return true;
		return false;
	}

	// This is the evaluation function as discussed
	// in the previous article ( http://goo.gl/sJgv68 )
	public int evaluate(char b[][])
	{
		// Checking for Rows for X or O victory.
		for (int row = 0; row<3; row++)
		{
			if (b[row][0]==b[row][1] &&
					b[row][1]==b[row][2])
			{
				if (b[row][0]==player)
					return +10;
				else if (b[row][0]==opponent)
					return -10;
			}
		}

		// Checking for Columns for X or O victory.
		for (int col = 0; col<3; col++)
		{
			if (b[0][col]==b[1][col] &&
					b[1][col]==b[2][col])
			{
				if (b[0][col]==player)
					return +10;

				else if (b[0][col]==opponent)
					return -10;
			}
		}

		// Checking for Diagonals for X or O victory.
		if (b[0][0]==b[1][1] && b[1][1]==b[2][2])
		{
			if (b[0][0]==player)
				return +10;
			else if (b[0][0]==opponent)
				return -10;
		}

		if (b[0][2]==b[1][1] && b[1][1]==b[2][0])
		{
			if (b[0][2]==player)
				return +10;
			else if (b[0][2]==opponent)
				return -10;
		}

		// Else if none of them have won then return 0
		return 0;
	}

	// This is the minimax function. It considers all
	// the possible ways the game can go and returns
	// the value of the board
	public int minimax(char board[][], int depth, boolean isMax)
	{
		int score = evaluate(board)-depth;

		// If Maximizer has won the game return his/her
		// evaluated score
		if (score == 10)
			return score;

		// If Minimizer has won the game return his/her
		// evaluated score
		if (score == -10)
			return score;

		// If there are no more moves and no winner then
		// it is a tie
		if (isMovesLeft(board)==false)
			return 0;

		// If this maximizer's move
		if (isMax)
		{
			int best = -1000;

			// Traverse all cells
			for (int i = 0; i<3; i++)
			{
				for (int j = 0; j<3; j++)
				{
					// Check if cell is empty
					if (board[i][j]=='_')
					{
						// Make the move
						board[i][j] = player;

						// Call minimax recursively and choose
						// the maximum value
						best = max( best,minimax(board, depth+2,!isMax) );

						// Undo the move
						board[i][j] = '_';
					}
				}
			}
			return best;
		}

		// If this minimizer's move
		else
		{
			int best = 1000;

			// Traverse all cells
			for (int i = 0; i<3; i++)
			{
				for (int j = 0; j<3; j++)
				{
					// Check if cell is empty
					if (board[i][j]=='_')
					{
						// Make the move
						board[i][j] = opponent;

						// Call minimax recursively and choose
						// the minimum value
						best = min(best,minimax(board, depth+2, !isMax));

						// Undo the move
						board[i][j] = '_';
					}
				}
			}
			return best;
		}
	}

	// This will return the best possible move for the player
	public Move findBestMove(char board[][])
	{

		Move m=findFirst(board);
		if(m!=null)
		{
			return m;
		}

		m=findLast(board);
		if(m!=null)
		{
			return m;
		}

		int bestVal = -1000;
		Move bestMove=new Move();
		bestMove.row = -1;
		bestMove.col = -1;

		// Traverse all cells, evalutae minimax function for
		// all empty cells. And return the cell with optimal
		// value.
		for (int i = 0; i<3; i++)
		{
			for (int j = 0; j<3; j++)
			{
				// Check if celll is empty
				if (board[i][j]=='_')
				{
					// Make the move
					board[i][j] = player;

					// compute evaluation function for this
					// move.
					int moveVal = minimax(board, 0, false);

					// Undo the move
					board[i][j] = '_';

					// If the value of the current move is
					// more than the best value, then update
					// best/
					if (moveVal > bestVal)
					{
						bestMove.row = i;
						bestMove.col = j;
						bestVal = moveVal;
					}
				}
			}
		}

		System.out.println("The value of the best Move is : "+bestVal);

		return bestMove;
	}

	private Move findLast(char[][] a) {

		for(int i=0;i<3;i++)
		{
			for(int j=0;j<3;j++)
			{
				if(a[i][j]=='_')
				{
					a[i][j]=p2;
					if(check(a,p2)==p2)
					{
						a[i][j]='_';
						Move m=new Move();
						m.row=i;
						m.col=j;
						return m;
					}
					a[i][j]='_';
				}
			}
		}
		return null;
	}

	public char check(char a[][],char c)
	{
		for(int i=0;i<3;i++)
		{
			if(a[i][0]==c && a[i][0]==a[i][1] && a[i][0]==a[i][2])
			{
				return c;
			}
			if(a[0][i]==c && a[0][i]==a[1][i] && a[0][i]==a[2][i])
			{
				return c;
			}
			if(a[0][0]==c && a[0][0]==a[1][1] && a[0][0]==a[2][2])
			{
				return c;
			}
			if(a[0][2]==c && a[0][2]==a[1][1] && a[0][2]==a[2][0])
			{
				return c;
			}
		}
		return 'd';
	}

	private Move findFirst(char[][] a)
	{
		for(int i=0;i<3;i++)
		{
			for(int j=0;j<3;j++)
			{
				if(a[i][j]=='_')
				{
					a[i][j]=p1;
					if(check(a,p1)==p1)
					{
						a[i][j]='_';
						Move m=new Move();
						m.row=i;
						m.col=j;
						return m;
					}
					a[i][j]='_';
				}
			}
		}
		return null;
	}

	public int min(int x,int y)
	{
		if(x<=y)
		{
			return x;
		}
		return y;
	}

	public int max(int x,int y)
	{
		if(x<=y)
		{
			return y;
		}
		return x;
	}

	// Driver code
	public static void main(String[] args)
	{
		MyMinMaxHard m=new MyMinMaxHard();
		char board[][]=new char[3][3];
		board[0][0]='o';board[0][1]='_';board[0][2]='x';
		board[1][0]='x';board[1][1]='_';board[1][2]='x';
		board[2][0]='o';board[2][1]='_';board[2][2]='o';

		Move bestMove = m.findBestMove(board);


		System.out.println("row: "+bestMove.row);
		System.out.println("col: "+bestMove.col);
	}
}