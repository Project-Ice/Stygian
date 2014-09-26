package net.condorcraft110.stygian.util;

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
