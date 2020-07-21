/**
 * Class EmptyStackException, thrown by methods pop and peek when invoked on empty stack
 * @author Rena Li 
 * @date July 21, 2020 
 */

public class EmptyStackException extends Exception
{
	/**
	 * Constructor
	 * @param message
	 */
	public EmptyStackException(String message)
	{
		super(message);
	}
}
