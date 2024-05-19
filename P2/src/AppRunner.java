public class AppRunner{

	public static void main(String[]args){
		GradeDatabaseFrontend frontend=	new GradeDatabaseFrontend(new GradeDatabaseBackend());
		frontend.runApp();	

	}
}
