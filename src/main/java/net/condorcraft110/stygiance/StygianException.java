package net.condorcraft110.stygiance;

public class StygianException extends RuntimeException
{
	StygianException(String message)
	{
		super(message);
	}
	
	StygianException(Throwable t)
	{
		super(t.getMessage(), t);
	}
}
