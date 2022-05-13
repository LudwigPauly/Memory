package memory;

import java.util.Random;

public class GameLogic
{
	protected int[] playground;
	protected boolean[] hits;

	public GameLogic(int gridsize)
	{
		this.playground = new int[gridsize*gridsize];
		hits = new boolean[gridsize*gridsize];
	}

	public void init(){
		int playgroundSize = playground.length;
		for (int i=0;i<playgroundSize/2;i++){
			playground[i]=i;
			playground[i+playgroundSize/2] = i;
		}


		for (int i=0;i<playgroundSize;i++) hits[i] = false;

		//for (int i=0;i<playgroundSize;i++) System.out.print(playground[i]);

		int iterations = 40; //shuffle iterations

		Random random = new Random();
		for (int k=0;k<iterations;k++){
			int acc1 = random.nextInt(playgroundSize);
			int acc2 = random.nextInt(playgroundSize);

			int tmp = playground[acc1];
			playground[acc1] = playground[acc2];
			playground[acc2] = tmp;
		}

		//System.out.print("\n");

		//for (int i=0;i<playgroundSize;i++) System.out.print(playground[i]);
	}

	public boolean move(int first, int second){
		if (playground[first] == playground[second]){
			hits[first] = true;
			hits[second]= true;
			return true;
		}
		return false;
	}

	public boolean checkForWin(){
		int i = 0;
		while (hits[i]){
			if(i== hits.length-1) return true;
			i++;
		}
		return false;
	}

	public int getCardValue(int index){
		return playground[index];
	}
}
