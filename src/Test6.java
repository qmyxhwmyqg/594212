import java.util.Scanner;
public class Test6 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		double a=scanner.nextInt();
		String c=scanner.next();
		double b=scanner.nextInt();
		jisuan(a,c,b);
		}
		public static void jisuan(double a , String c , double b) {
			if(c.equals("+")) {
				System.out.println(a+b);
			}else if(c.equals("-")) {
				System.out.println(a-b);
			}else if(c.equals("*")) {
				System.out.println(a*b);
			}else if(c.equals("/")) {
				System.out.println(a/b);
			}
		}
}
