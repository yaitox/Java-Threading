import java.io.IOException;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class MainMenu 
{
	static final public void ConstructMenu() throws IOException
	{
		final Scanner scanner = new Scanner(System.in);
		System.out.println("Ingrese las URLs");
		
		// URL input system
		Queue<MyFile> urls = new LinkedList<MyFile>();
		String url;
		while ((url = scanner.nextLine()) != "") // TODO: find a better way to do this
		{
			String[] split = url.split(" ");
			MyFile fileSplitted = new MyFile(split[0], split[1]);
			urls.add(fileSplitted);
		}

		ThreadMgr threadMgr = new ThreadMgr(urls);
		threadMgr.Parse("C:\\ParsedFiles");
		
		System.out.println("Finished the parsing.");
		
		scanner.close();
	}
}
