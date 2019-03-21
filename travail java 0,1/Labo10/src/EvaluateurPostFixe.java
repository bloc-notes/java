import java.util.Stack;

public class EvaluateurPostFixe {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String strExpressionPostF = "7 10 + 50 * 4 5 / +";

		Stack<Double> stPostFixe = new Stack<Double>();

		char[] tabExpPostF = strExpressionPostF.toCharArray();


		for (int i = 0; i < tabExpPostF.length; i++) {
			char charTableau = tabExpPostF[i];

			if (charTableau == '*' || charTableau == '/' || charTableau == '+' || charTableau == '-') {

				switch (charTableau) {
				case '+':
					stPostFixe.push(stPostFixe.pop() + stPostFixe.pop());
					//System.out.println(stPostFixe);
					break;
				case '-':
					stPostFixe.push(-stPostFixe.pop() + stPostFixe.pop());
					//System.out.println(stPostFixe);
					break;
				case '*':
					stPostFixe.push(stPostFixe.pop() * stPostFixe.pop());
					//System.out.println(stPostFixe);
					break;
				case '/':
					stPostFixe.push(1 / stPostFixe.pop() * stPostFixe.pop());
					//System.out.println(stPostFixe);
					break;
				}
			}
			else if (Character.isDigit(charTableau)) {
				stPostFixe.push(0.0);
				while (Character.isDigit(tabExpPostF[i]))
					stPostFixe.push(10.0 * stPostFixe.pop() + (tabExpPostF[i++] - '0'));
			}

		}

		System.out.println(stPostFixe);

		//System.out.println("Stack: " + stPostFixe + "\n");
	}

}
