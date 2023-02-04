import java.io.IOException;
import java.util.Queue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ThreadMgr 
{
	static final public int MAX_THREADS = 8;
	
	ThreadMgr(Queue<MyFile> urls) 
	{
		_urls = urls;
		_threadPool = Executors.newFixedThreadPool(MAX_THREADS);
	}
	
	public void Parse(String dir) throws IOException
	{
		Runtime.getRuntime().exec("cmd /c mkdir " + dir);
		String command = "C:\\Program Files (x86)\\Google\\Chrome\\Application\\chrome --headless --print-to-pdf=\"" + dir + "\\";
		
		while (!_urls.isEmpty())
		{
			MyFile file = _urls.poll();
			Runnable worker = new ThreadWorker(command + file.GetPDFName() + ".pdf\" " + file.GetURL());
			_threadPool.execute(worker);
		}
		
		_threadPool.shutdown();
	}

	private ExecutorService _threadPool;
	private Queue<MyFile> _urls;
}
