	public static void main(String[] args) {
		// Start of implementation by Ludvig at 2016-09-05 11:05
		System.out.println("+***************************************************+"
				+ "\n+                                                   +"
				+ "\n+        Welcome to the DIT948 Calculator           +"
				+ "\n+                                                   +"
				+ "\n+***************************************************+"
				+ "\n\nPlease enter the operator to use (’+’, ’-’, ’x’, ’/’) or press ’q’ to quit:");
		Scanner input = new Scanner(System.in);
		// The operator to be used is scanned by the user
		String string = input.nextLine();
		char operator = string.charAt(0);

		// The two values to be used are scanned by the user
		System.out.println("Please enter the first value:");
		int firstvalue = input.nextInt();
		System.out.println("Please enter the second value:");
		int secondvalue = input.nextInt();
		// End of implementation by Ludvig at 2016-09-05 11:05
	}

}
