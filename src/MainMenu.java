import java.io.IOException;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class MainMenu 
{
	static final public void ConstructMenu() throws IOException
	{
		System.out.println("Ingrese los archivos a parsear de la siguiente manera: URL PDF");
		
		// URL input system
		final Scanner scanner = new Scanner(System.in);
		Queue<MyFile> urls = new LinkedList<MyFile>();
		String url;
		while ((url = scanner.nextLine()) != "") // TODO: find a better way to do this
		{
			String[] split = url.split(" ");
			MyFile fileSplitted = new MyFile(split[0], split[1]);
			urls.add(fileSplitted);
		}
		scanner.close();

		ThreadMgr threadMgr = new ThreadMgr(urls);
		threadMgr.Parse("C:\\ParsedFiles");
		
		
	}
}
