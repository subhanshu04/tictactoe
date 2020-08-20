import java.util.*;

public class TicTac {
	static ArrayList<Integer> playerPos = new ArrayList<>();
	static ArrayList<Integer> cpuPos=new ArrayList<>();
	public static void createBoard(char gameboard[][])
	{
		for( char[] row:gameboard)
		{
			for(char c:row)
			{
				System.out.print(c);;
			}
			System.out.println();
		}
	}
	public static void placement(int pos,char gameboard[][],String player)
	{
		char c=' ';
		if(player=="Player")
		{
			c='X';
			playerPos.add(pos);
		}
		else if(player=="Cpu")
		{
			c='O';
			cpuPos.add(pos);
			//System.out.println(cpuPos+" "+cpuPos.size());
		}
		switch(pos) {
		case 1: 
			gameboard[0][0]=c;
			break;
		case 2: 
			gameboard[0][2]=c;
			break;
		case 3: 
			gameboard[0][4]=c;
			break;
		case 4: 
			gameboard[2][0]=c;
			break;
		case 5: 
			gameboard[2][2]=c;
			break;
		case 6: 
			gameboard[2][4]=c;
			break;
		case 7: 
			gameboard[4][0]=c;
			break;
		case 8: 
			gameboard[4][2]=c;
			break;
		case 9: 
			gameboard[4][4]=c;
			break;
			default :
			break;
		}
	}
	public static String winner()
	{
		List top=Arrays.asList(1,2,3);
		List mid=Arrays.asList(4,5,6);
		List bottom=Arrays.asList(7,8,9);
		List first=Arrays.asList(1,4,7);
		List second=Arrays.asList(2,5,8);
		List third=Arrays.asList(3,6,9);
		List cross1=Arrays.asList(1,5,9);
		List cross2=Arrays.asList(3,5,7);
		
		List<List> winners=new ArrayList<List>();
		
		winners.add(top);
		winners.add(mid);
		winners.add(bottom);
		winners.add(first);
		winners.add(second);
		winners.add(third);
		winners.add(cross1);
		winners.add(cross2);
		
		for(List l : winners)
		{
			if(playerPos.containsAll(l))
			{
				return  "Congrats Player won !!";
			}
			else if(cpuPos.containsAll(l))
			{
				return "CPU won :( ";
			}
			else if(cpuPos.size() + playerPos.size() == 9)
			{
				return "Match Tied";
			}
		}

		return "";
		
		
	}

	public static void main(String[] args) {
		char [][] gameboard= {{' ','|',' ','|',' '},
				{'-','+','-','+','-'},
				{' ','|',' ','|',' '},
				{'-','+','-','+','-'},
				{' ','|',' ','|',' '},};
		while(true)
		{
			Scanner x=new Scanner(System.in);
			System.out.println("Enter your placement : (1-9)");
			int pos=x.nextInt();
			while(playerPos.contains(pos) || cpuPos.contains(pos))
			{
				System.out.println("Incorrect POsition");
				pos=x.nextInt();
			}
			placement(pos,gameboard,"Player");
			String win=winner();
			if(win.length()>0)
			{
				System.out.println(win);
				break;
			}
			Random rand=new Random();
			int random=rand.nextInt(9)+1;
			while(cpuPos.contains(random) || playerPos.contains(random))
			{
				//stem.out.println("Incorrect Position");
				random=rand.nextInt(9)+1;
			}
			placement(random,gameboard,"Cpu");
			createBoard(gameboard);
			 win=winner();
			if(win.length()>0)
			{
				System.out.println(win);
				break;
			}
		}
	}

}
