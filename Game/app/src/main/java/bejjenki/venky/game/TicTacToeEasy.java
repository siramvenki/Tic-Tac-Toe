package bejjenki.venky.game;

import java.util.*;

class TicTacToeEasy
{
	char p1 = 'o', p2 = 'x';
	int flag,count=0;
	String in="";
	String systemMove="";
	char a[][];

	public TicTacToeEasy()
	{
		a=new char[3][3];
	}


	public void initialize()
	{
		for(int i=0;i<3;i++)
		{
			for(int j=0;j<3;j++)
			{
				a[i][j]='_';
			}
		}
	}

	public void initSystem()
	{
		Random rn = new Random();
		int i = rn.nextInt(3);
		int j = rn.nextInt(3);
		systemMove=""+i+j;
		a[i][j]=p1;
		count++;
	}

	public void startGame()
	{
		initialize();
	}
	public String move()
	{
		System.out.println("iam looped with flag: "+flag+" and in value as: "+in);
		char c[]=in.toCharArray();
		int i=Integer.parseInt(c[0]+"");
		int j=Integer.parseInt(c[1]+"");
		a[i][j]=p2;
//				display();
		char ch=check(p2);
		if(ch==p2)
		{
//					System.out.println("player 2 win");
			return "p2";
		}
		else if(ch=='d')
		{
//					System.out.println("Game draw");
			return "draw";
		}



//				System.out.print("player 1: ");
		MyMinMaxMedium m=new MyMinMaxMedium();
		Move mo=m.findBestMove(a);
		i=mo.row;
		j=mo.col;
		systemMove=""+i+j;
		a[i][j]=p1;
//				display();
		ch=check(p1);
		if(ch==p1)
		{
//					System.out.println("player 1 win");
			return "p1";
		}
		else if(ch=='d')
		{
//					System.out.println("Game Draw");
			return "draw";
		}

		return "continue";
	}
//	}

	public char check(char c)
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
		for(int i=0;i<3;i++)
		{
			for(int j=0;j<3;j++)
			{
				if(a[i][j]=='_')
				{
					return '*';
				}
			}
		}
		return 'd';
	}

	public int insert(String s)

	{
		if(!(a[Integer.parseInt(s.charAt(0)+"")][Integer.parseInt(s.charAt(1)+"")]=='_'))
		{
			return 1;
		}
		in=s;
		return 0;
	}

	public char[][] getArray()
	{
		return a;
	}
}