
public class Checkpoint {
	public static void main(String[] args) {
		int ran = (int) (Math.random() * 5);
		System.out.println("int: " + ran);
		
		switch (ran) {
		case 0:
			System.out.println("wow it was 0");
			break;
		case 1:
			System.out.println("wow it was 1");
			break;
		case 2:
			System.out.println("wow it was 2");
			break;
		case 3:
			System.out.println("wow it was 3");
			break;
		case 4:
			System.out.println("wow it was 4");
			break;
		default:
			System.out.println("wow you messed it up somehow");
		}
	}
}
