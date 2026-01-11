package HW;

public class snakeToCamelAppl {

	public static void main(String[] args) {
		System.out.println("Homework 5: snake to camel string transformation\n");
		
		String snakeExample = "asv_fgh_iop";
		System.out.println("Example snake string: " + snakeExample);
		System.out.println("Append method result: " + snakeToCamelAppendMethod(snakeExample));
		System.out.println("Delete method result: " + snakeToCamelDeleteMethod(snakeExample));
		System.out.println("-------------------------------------------");
		System.out.println("Perfomance test Append VS Delete\n");
		snakeToCamelAppendVsDelete();
	}

	public static String snakeToCamelAppendMethod(String snake) {
		boolean flag_ = false;
		if (snake == null || snake.isBlank())
			return "";
		StringBuilder camel = new StringBuilder();
		for (int i = 0; i < snake.length(); i++) {
			if (Character.isLetter(snake.charAt(i))) {
				if (i != 0 && camel.length() != 0 && flag_) {
					camel.append(Character.toUpperCase(snake.charAt(i)));
				} else {
					camel.append(Character.toLowerCase(snake.charAt(i)));
				}
				flag_ = false;
			} else if (snake.charAt(i) == '_')
				flag_ = true;
		}

		return camel.toString();
	}

	public static String snakeToCamelDeleteMethod(String snake) {
		if (snake == null || snake.isBlank())
			return "";
		StringBuilder camel = new StringBuilder(snake);
		for (int i = 0; i < camel.length(); i++) {
			if (Character.isLetter(camel.charAt(i)) || camel.charAt(i) == '_') {
				if (Character.isLetter(camel.charAt(i)))
					camel.setCharAt(i, Character.toLowerCase(camel.charAt(i)));
				if (camel.charAt(i) == '_')
					if (i != camel.length() - 1) {
						if (i == 0) {
							camel.deleteCharAt(i);
							i--;
							continue;
						}
						if (Character.isLetter(camel.charAt(i + 1))) {
							camel.setCharAt(i + 1, Character.toUpperCase(camel.charAt(i + 1)));
							camel.deleteCharAt(i);
						} else {
							camel.deleteCharAt(i + 1);
							i--;
						}
					} else
						camel.deleteCharAt(i);
			} else {
				camel.deleteCharAt(i);
				i--;
			}
		}
		return camel.toString();
	}

	public static void snakeToCamelAppendVsDelete(){
		final String snakeBase = "asv_fgh_iop_";
		int COUNT = 100_000;
		StringBuilder sb = new StringBuilder();
		
		for (int i = 0; i < COUNT; i++) {
			sb.append(snakeBase);
		}
		
		long start2 = System.nanoTime();
		sb.setCharAt(50_000, ' ');
		System.out.println("One append operation time: " + (System.nanoTime() - start2)/1000);
		start2 = System.nanoTime();
		sb.deleteCharAt(50_000);
		System.out.println("One delete operation time: " + (System.nanoTime() - start2)/1000);
		
		String snake = sb.toString();
		long start = System.nanoTime();
		snakeToCamelAppendMethod(snake);
		System.out.println("Append method time: " + (System.nanoTime() - start)/1000);
		start = System.nanoTime();
		snakeToCamelDeleteMethod(snake);
		System.out.println("Delete method time: " + (System.nanoTime() - start)/1000);
	}
}
