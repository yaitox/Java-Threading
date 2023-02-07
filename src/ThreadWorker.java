import java.io.IOException;

public class ThreadWorker implements Runnable
{
	public ThreadWorker(String command)
	{
		_command = command;
	}
	
	@Override
	public void run() 
	{
		try 
		{
			Runtime.getRuntime().exec(_command);
		} catch (IOException e) { e.printStackTrace(); }
	}
	
	private String _command;
}
