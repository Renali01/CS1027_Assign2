/**
 * Class ArrayStack, which implements a stack using an arra
 * @author Rena Li 
 * @date July 21, 2020 
 */
public class ArrayStack<T> implements ArrayStackADT<T>
{
	private T[] stack;
	private int top;  // stores position of last data item
	private int initialCapacity;
	private int sizeIncrease; //when array is full and new item must be added to it
								// array will increase by this size
	private int sizeDecrease; // if after removing data item, number of items is less than 1/4 of size of array
								// and array size larger than initial, it will decrease (pop)
	
	
	public ArrayStack(int initialCap, int sizeInc, int sizeDec)
	{
		initialCapacity = initialCap;
		sizeIncrease = sizeInc;
		sizeDecrease = sizeDec;
		
		stack = (T[]) new Object[initialCapacity];
		
		top = -1;
	}
	public void push (T dataItem)
	{
		if (top == stack.length - 1)
		{
			T[] bigger = (T[]) new Object[stack.length + sizeIncrease]; // new length is current capacity + additional
			for (int i = 0; i < stack.length ; i++)
		    {
		        bigger[i] = stack[i];   
		    }
			stack = bigger;
		}
		
		top++;
		stack[top] = dataItem;	
	}
	
	public T pop() throws EmptyStackException
	{
		if (isEmpty())
		{
			throw new EmptyStackException("stack is empty"); // forgot to check isEmpty - throw "new" exception
		}
		
		T temp = stack[top];
		stack[top] = null; // remove data item from top
		top--;
		
		if (((top + 1) < (0.25 * stack.length)) && (stack.length > initialCapacity)) // top+1 for number of items, 0.25 NOT 1/4!!!!, be careful of operand uses
		{
			T[] smaller = (T[]) new Object[stack.length - sizeDecrease];
			for (int i = 0; i <= top ; i++) //!!!!!! i = 0 goes to i = top because we are transferring data items from original to smaller array; and data items do not take up entire stack capacity, so not i = stack.length
		    {
		        smaller[i] = stack[i];   
		    }
			stack = smaller;
		}
		return temp;
	}
	
	public T peek() throws EmptyStackException
	{
		if (isEmpty())
		{
			throw new EmptyStackException("stack is empty"); // forgot to check isEmpty - throw "new" exception
		}
		return stack[top];
	}
	
	public boolean isEmpty()
	{
		return (top == -1); // will return true if statement is true, false otherwise
	}
	
	public int size()
	{
		return top + 1;
	}
	
	public int length()
	{
		return stack.length;
	}
	
	public String toString()
	{
		String message = "Stack: ";
		
		for (int i = 0; i <= top; i++) // silly mistake: i = 0 to i = top
		{
			if (i == top)
			{
				message += stack[i].toString();
			}
			else
			{
				message += stack[i].toString() + ", "; // spacing after comma
			}
		}
		return message;		
	}
}
	