import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class ThreadMgr 
{
	static final public int MAX_THREADS = 3;
	
	final static public void Parse(ArrayList<MyFile> files)
	{
		try 
		{
			Runtime.getRuntime().exec("cmd /c mkdir C:\\ParsedFiles");
		} 
		catch (IOException ioe) { ioe.printStackTrace(); }
		
		final String commandChrome = "C:\\Program Files (x86)\\Google\\Chrome\\Application\\chrome --headless --print-to-pdf=\"C:\\ParsedFiles\\";
		final String commandSoffice = "C:\\Program Files\\LibreOffice\\program\\soffice --convert-to pdf --outdir \"C:\\ParsedFiles\" \"";
		
		_threadPool = Executors.newFixedThreadPool(MAX_THREADS);
		
		List<Future<?>> futures = new ArrayList<>();
		for (MyFile file : files)
		{
			String command = "";
			if (file.IsLocal())
				command += commandSoffice + file.GetOrigin() + "\" --headless";
			else
				command += commandChrome + file.GetPDFName() + ".pdf\" " + file.GetOrigin();
			
			Runnable worker = new ThreadWorker(command);
			Future<?> future = _threadPool.submit(worker);
			futures.add(future);
		}
		
		_threadPool.shutdown();
		
		try 
		{
			for (Future<?> future : futures)
				future.get();	
		}
		catch (ExecutionException | InterruptedException e) { e.printStackTrace(); }
		
		System.out.println("Los archivos han terminado de ejecutarse. La ruta de acceso es las siguiente: C:\\ParsedFiles");
	}

	static private ExecutorService _threadPool;
}
