import java.util.Scanner;
 
public class Main {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
        
		int a = in.nextInt();
 
		for (int i = 2; i <= Math.sqrt(a); i++) {	// 또는 i * i <= a
			while (a % i == 0) {
				System.out.println(i);
				a /= i;
			}
		}
		if (a != 1) {
			System.out.println(a);
		}
	}
}