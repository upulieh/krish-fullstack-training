# Singleton

* Singleton for microservices is - One instance per container
* You shouldn't contain arguments when creating an instance

# Factory method pattern

* You use arguments to determine which instance you want to return 
* However, there can be a default type of instance 
* You don't see the instantiation logic
* Uses a higher level of a framework

# Prototype 
* Helping avoid creating instances by cloning existing objects
* This is because creating new objects is expensive
* You create an instance and register it so the next time it is needed, it is cloned
* Used in creating instances new item objects in shopping pages. (to stop creating many instances per each user over the whole system)
* avoids the use of "new" keyword.
* Implements the clonable interface
* Rethink whether to shallow copy or deep copy

# Builder
* helps create instances according to a selection
* helps to avoid the need of multiple contructors by using telescopic contructors (a contructor inside a contructor)

# Chain of Responsibility 
* a behavioural pattern
* a scenario - having to control the visibility/permission level based on the user level (CEO, director, manager)
* Eg in java - logger API (info, debug, warning, server, critical). If you set the log level to info. Java won't print anything below info level.
* Advantages - loosing coupled architecture (sending and receiver have no idea about their internal work)
* also, able to change the internal order without disrupting the output

# Memento 
* Used to undo something done
* Has three pillars (originator, caretaker, memento)
* originator - keeps the status
* caretaker - keeps track of the originator
* memento - 
* originator + memento = passes the state to the caretaker 
* when we need to go to the previous state, 1) we request the caretaker 2) check previous state 3) move there
* scenario - shopping cart item adding
* if you want to go back one step and remove the previous add. (rollback to the previous state)




 





