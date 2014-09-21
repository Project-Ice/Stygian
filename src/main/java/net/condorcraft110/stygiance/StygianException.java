package net.condorcraft110.stygiance;

public class StygianException extends RuntimeException
{
	StygianException(Throwable t)
	{
		super(t.getMessage(), t);
	}
}
