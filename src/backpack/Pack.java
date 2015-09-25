package backpack;


public class Pack {
	
	public Pack(Goods[] goods, int volumn) throws InstantiationException {
		this.goods = goods;
		this.volumn = volumn;
	}
	
	public int maxValue(){
		return packResolution( goods.length-1, volumn );
	}
	
	private int packResolution(int i, int j){
		int value;
		if(i == -1 || j == 0){
			value = 0;
		} else if(j-goods[i].getWeight() < 0){
			//goods[i] excluded
			value = packResolution(i-1, j);
		} else {
			//goods[i] included
			int taken = packResolution(i-1, j-goods[i].getWeight()) + goods[i].getValue();
			int notTaken = packResolution(i-1, j);
			value = notTaken > taken ? 
							notTaken : taken;
		}
		return value;
	}
	
	public static void main( String[] args ) throws InstantiationException {
		Goods goods[] = {
				/*new Goods( 3, 4 ),
				new Goods( 4, 5 ),
				new Goods( 5, 6 )*/
				new Goods( 10,60 ),
				new Goods( 20,100 ),
				new Goods( 30,120 )
				
		};
		Pack pack = new Pack( goods, 50 );
		System.out.println(pack.maxValue());
	}
	
	private Goods[]									goods;
	private int											volumn;
}

