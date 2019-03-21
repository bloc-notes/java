
public class Eratosthenne {
	static int intTab[] = {2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20,21,22,23,24,25,26,27,28,29,30,31,32,33,34,35,36,37,38,39,40,41};
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int intTabBarre[] = intTab.clone();
		
		for(int q = 0;q<=intTabBarre.length && (Math.pow(intTabBarre[q],2)<= intTabBarre[intTabBarre.length-1]);q++){
			if(intTabBarre[q] != -1){
				for(int w=(q+1);w<intTabBarre.length;w++){
					if((intTabBarre[w] % intTabBarre[q]) == 0){
						intTabBarre[w] = -1;
					}
				}
			}
		}
		System.out.print("Nombre premier: ");
		
		for(int x=0;x<intTabBarre.length;x++){
			if(intTabBarre[x] != -1 ){
				System.out.print(intTabBarre[x] + " , ");
			}
				
		}
	}

}
