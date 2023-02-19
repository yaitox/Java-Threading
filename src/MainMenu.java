import java.util.ArrayList;
import java.util.Scanner;

public class MainMenu 
{
	static final public void ConstructMenu()
	{
		System.out.println("Ingresa los archivos a parsear de la siguiente manera sin los brackets:\n[Tipo (1: local 0: url)] [URL u origen] [Nombre del PDF si la opción fue por url]");
		
		// URL input system
		final Scanner scanner = new Scanner(System.in);
		ArrayList<MyFile> files = new ArrayList<MyFile>();
		
		String url;
		while ((url = scanner.nextLine()) != "")
		{
			String[] split = url.split(" ");
			
			int localFile = -1;
			try 
			{
				localFile = Integer.parseInt(split[0]);
			} 
			catch (Exception e) 
			{ 
				System.out.println("Has ingresado un valor no numerico. Ignorando...");
				continue;
			}
			
			if (localFile < 0 || localFile > 1)
			{
				System.out.println("Has ingresado un valor incorrecto: " + localFile + ". ignorando...");
				continue;
			}
			
			if (split.length < 2)
			{
				System.out.println("Datos ingresados insuficientes. Ignorando...");
				continue;
			}
			
			if (localFile == 0 && split.length == 2)
			{
				System.out.println("No has ingresado como se va a llamar el PDF. Ignorando...");
				continue;
			}
			
			MyFile file = null;
			if (localFile == 0)
				file = new MyFile(false, split[1], split[2]);
			else
				file = new MyFile(true, split[1], null);

			files.add(file);
		}
		scanner.close();

		ThreadMgr.Parse(files);
	}
}
