/*
Ruochong Wu
APCS1 Pd10
HW45 -- Come Together
2015-12-09
*/
public class SuperArray{
 
    //~~~~~INSTANCE VARS~~~~~
    //underlying container, or "core" of this data structure:
    private Comparable[] _data;

    //position of last meaningful value
    private int _lastPos;

    //size of this instance of SuperArray
    private int _size;

		
    //~~~~~METHODS~~~~~
    //default constructor - initializes 10-item array
    public SuperArray() 
    { 
	_data = new Comparable[10];
	_lastPos = -1; //flag to indicate no lastpos yet
	_size = 0;	
    }

		
    //output array in [a,b,c] format, eg
    // {1,2,3}.toString() -> "[1,2,3]"
    public String toString() 
    { 
	String foo = "[";
	for( int i = 0; i < _size; i++ ) {
	    foo += _data[i] + ",";
	}
	//shave off trailing comma
	if ( foo.length() > 1 )
	    foo = foo.substring( 0, foo.length()-1 );
	foo += "]";
	return foo;
    }

		
    //double capacity of this SuperArray
    private void expand() 
    { 
	Comparable[] temp = new Comparable[ _data.length * 2 ];
	for( int i = 0; i < _data.length; i++ )
	    temp[i] = _data[i];
	_data = temp;
    }

		
    //accessor -- return value at specified index
    public Comparable get( int index ) { return _data[index]; }

		
    //mutator -- set value at index to newVal, 
    //           return old value at index
    public Comparable set( int index, Comparable newVal ) 
    { 
 	Comparable temp = _data[index];
	_data[index] = newVal;
	return temp;
    }


    // ~~~~~~~~~~~~~~ PHASE II ~~~~~~~~~~~~~~
    //adds an item after the last item
    public void add( Comparable newVal ) {
	_size += 1;
	_data[_lastPos+1] = newVal;  //slot right after last meaningfull slot is filled
	_lastPos+=1;
    }

    //inserts an item at index
    //shifts existing elements to the right
    public void add( int index, Comparable newVal ) {
	_size += 1;
	_lastPos += 1;
	for ( int x = _lastPos ; x > index ; x--){ //shifts everything between index and _lastpos
	    _data[x] = _data[x-1];
	}
	_data[index] = newVal;
    }    

    //removes the item at index
    //shifts elements left to fill in newly-empted slot
    public void remove( int index ) {
	Comparable[] new_data = new Comparable[_data.length-1];
	for (int count = 0 ; count < index ; count++){  //copy everything before target
	    new_data[count] = _data[count];
	}
	for (int count = index ; count<new_data.length ; count++){ //copy everything after target, skipping the target, effectively removing it
	    new_data[count] = _data[count + 1];
	}
	_lastPos -=1;
	_size -=1;
	_data = new_data;
    }
   
    //return number of meaningful items in _data
    public int size() {
	return _size;
    }

    public int linSearch(Comparable y){
	for (int count = 0; count < _size ; count++){
	    if (_data[count].compareTo(y) == 0){
		return count;
	    }
	}
	return -1;
    }

    public boolean isSorted(){
	for (int count = 0; count <_size -1; count++){
	    if (!(_data[count].compareTo(_data[count+1]) >= 0)){
		return false;
	    }
	}
	return true;
    }

    //main method for testing
    public static void main( String[] args ) 
    {
	/*	SuperArray curtis = new SuperArray();
	System.out.println("Printing empty SuperArray curtis...");
	System.out.println(curtis);

	for( int i = 0; i < curtis._data.length; i++ ) {
	    curtis.set(i,i*2);
	    curtis._size++; //necessary bc no add() method yet
	}

	System.out.println("Printing populated SuperArray curtis...");
	System.out.println(curtis);

	System.out.println("testing get()...");
	for( int i = 0; i < curtis._size; i++ ) {
	    System.out.print( "item at index" + i + ":\t" );
	    System.out.println( curtis.get(i) );
	}

	System.out.println("Expanded SuperArray curtis:");
	curtis.expand();
	System.out.println(curtis);


	SuperArray mayfield = new SuperArray();
	System.out.println("Printing empty SuperArray mayfield...");
	System.out.println(mayfield);

	mayfield.add(5);
	mayfield.add(4);
	mayfield.add(3);
	mayfield.add(2);
	mayfield.add(1);

	System.out.println("Printing populated SuperArray mayfield...");
	System.out.println(mayfield);

	mayfield.remove(3);
	System.out.println("Printing SuperArray mayfield post-remove...");
	System.out.println(mayfield);
	mayfield.remove(3);
	System.out.println("Printing SuperArray mayfield post-remove...");
	System.out.println(mayfield);
	System.out.println(mayfield._lastPos);

	mayfield.add(3,99);
	System.out.println("Printing SuperArray mayfield post-insert...");
	System.out.println(mayfield);
	mayfield.add(2,88);
	System.out.println("Printing SuperArray mayfield post-insert...");
	System.out.println(mayfield);
	mayfield.add(1,77);
	System.out.println("Printing SuperArray mayfield post-insert...");
	System.out.println(mayfield);

	System.out.println(mayfield.size());
	*/

	SuperArray test = new SuperArray();
	System.out.println(test);
	test.add(new Rational(6,1));
	test.add(new Binary (6));
	test.add(new Hexadecimal (4));
	test.add( new Rational (3,1));
	test.add(new Binary (2));
	test.add(new Binary (1));
	System.out.println(test);
	System.out.println(test.linSearch(new Hexadecimal(0)));
	System.out.println(test.isSorted());
    }//end main
		
}//end class
