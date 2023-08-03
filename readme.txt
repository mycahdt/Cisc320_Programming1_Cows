ReadMe

This program has an average time complexity of O(clog(c)+r), where c is the number
of cows and r is the number of rows of input. 

A Cow class was created which includes the fields: id, lowestWeight, latestWeight,
milk, temp, avgMilkProduction, timestamp, and milkNum. A constructor was created 
in order to create a new Cow instance. The setters and getters for each of the 
field were implemented in the Cow class.

The program starts by creating a HashMap called cows, where the keys are the 
Cow's Id (integer) and the values are the Cow objects. Then, an ArrayList called
cowList is created. 

A while loop is used to read the file line by line, which runs in O(r).
The line is split by spaces in order to get the four pieces of information: 
the id (integer), the letter (which is either W, M, or T), the information (an integer
which either describes the Latest Weight, the Amount of Milk Produced, or the temperature),
and the timestamp. 


The purpose of creating a Hashmap is to be able to access each of the cows
based on their unique id's.
An if statement checks if the Hashmap contains the key that matches the given Id. 
The method .containsKey runs in O(1).

If the given id matches an id found in the Hashmap, this means that this cow has already
been created in the Hashmap, and its data just needs to be adjusted / changed.
So program checks the given letter (the second piece of information). 
If the given letter is "W", "M", or "T" and sets the appropriate data for that cow.

If the given id doesn't match an id found in the Hashmap, this means that this cow
doesn't exist in the Hashmap. The program creates a new Cow object by passing in the
four pieces of information. Then it puts this cow object into the Hashmap, with the 
id as its key and the cow object as the value. This cow object is also added to 
the ArrayList.

Once all of the lines in the file are read, the data must be sorted.
Comparator is used in order to group the ArrayList by the different categories:
first by LowestWeight, then by LatestWight, then by AvgMilkProduction. 
This runs in O(c).

Then Collections.sort is used in order to sort the ArrayList. 
This is done in O(c*log(c)).

Lastly, a for loop goes through the sorted ArrayList and prints out the
appropriate output (Id, LowestWeight, LatestWeight, and AvgMilkProduction).
This is done in O(c);


So we have O(c*log(c)) and O(c) and O(r).
Since Big O is derived by keeping the largest (least efficient) term
in the function and discard the others. 
Since O(c*log(c)) > O(c), this means we can discard of O(c).

This means we are left with a time complexity of O(c*log(c)+r).
		
		


