public interface IGradeDatabaseFrontend{
	

		/**
		 *method runs everything for the app to work
		 */
		public void runApp();


		/**
		 *method displays the mainMenu and will take user input
		 */
		public void displayMainMenu();


		/**
		 *method will run the code to add a student
		 */
		public void studentAdder();

		/**
		 *method will run code to outprint mean
		 */
		public void getMean();

		/**
		 *method will run code to outprint standard deviation
		 */
		public void getSD();


		/**
		 *method will run the code to search by student
		 */
		public void searchStudent();
	}
