# Refactoring
## Book "Refactoring" by Martin Fowler
- one of __the__ sources for the topic
- "Refactoring is the process of changing a software system in such a way that it does not alter the external behavior of the code yet improves its internal structure. It is a disciplined way to clean up code that minimizes the chances of introducing bugs. In essence when you refactor you are improving the design of the code after it has been written."
- book written in 1999, when agile methods have not become that popular. Hence: improving existing code step by step new thing
- today: Refactoring = fundamental skill of every developer + part of many methods, such as TDD ("Red - Green - Refactor")
- Refactoring = part of developer's everyday life: first refactor, then add new functionality
- also: refactoring steps in book described in detail what today's IDEs can do automated. Some errors author made are impossible to do now, except when ignoring capabilities of IDEs and doing everything by hand.
 
## Simple Refactorings in Chapter 1
- Following examples from the book plus [tobyweston/Refactoring-Chapter-1](https://github.com/tobyweston/Refactoring-Chapter-1) (attention: some minor naming and syntax changes in comparison to the book)
- each commit is a refactoring from the book
- first step of refactoring: add a solid test base, for example via behavior tests (record given behavior of a method / class without thinking about what it really should do too much) - not done in the book however

### Refactoring: extract method
- switch-statement in class Customer ugly
- done with modern IDE: method gets extracted without problems with two parameters rental and amount
- because amount is set to 0 in for-loop, change it to return parameter 
- [extract method](https://github.com/tobyweston/Refactoring-Chapter-1/commit/8e249c8954d92aebabf304d875ac6f597977b307)

### Refactoring: Renaming
- (not covered in Github-repo)
- renaming = one of the 
    - most basic refactorings; very easy to do while just reading the code
    - hardest things to do in software development; always take your time to find a great name
 - very important to do with IDE support, even when just renaming a variable used a few lines below - errors will creep in!
- also: __don't__ rename using search + replace all. Use proper IDE functionality.
- antipatterns (especially in Java):
    - XYManager
    - XYUtil
    - XYHelper

### Refactoring: Move Method
- new method amountFor in Customer uses information from Rental, but not from Customer = encapsulation error
- IntelliJ IDEA proposes class Rental intelligently when "move method" refactoring is called 
- [move method](https://github.com/tobyweston/Refactoring-Chapter-1/commit/15c340ea73ac30b6fb41f607e6328ec48b87e849)

### Refactoring: Replace Temporary Variables with Query
- [Replace Temp with Query](https://github.com/tobyweston/Refactoring-Chapter-1/commit/98a38bcdb9b6eba987a31c939e5d04a9d13ad3de)

### Refactoring: extract method 
- [Extract method to isolate frequent renter points](https://github.com/tobyweston/Refactoring-Chapter-1/commit/74b34ba9ae870c6d5e4a5d0b8538dda043b77846)
- resulting method bad name: no getter!
- extracted method ugly, can be simplified. However: when refactoring, go step by step!
- simplification done in the [next step](https://github.com/tobyweston/Refactoring-Chapter-1/commit/8f9b81021aa71caf6f48c837e56eb135258a2d5f)

### Refactoring: replace temp with query
- [first step](https://github.com/tobyweston/Refactoring-Chapter-1/commit/9f57c1cea43af7742e76945c27535c1ab01437bc), [second step](https://github.com/tobyweston/Refactoring-Chapter-1/commit/a90a5ff957fb9064cd01377a1fcdb59866f0abda)
- possible issues with this refactoring:
    1. adds code => but improves readability. Always a good trade!
    1. goes through loop multiple times instead of just one time, so possible performance issue => don't optimize until profiled and proofed that this is really slow!

### Refactoring: extract and move methods to create consistent classes
- goal: less calls to other classes in calculations == move methods to where they belong
- [first step](https://github.com/tobyweston/Refactoring-Chapter-1/commit/69859dd14a232e00264afef3caa396988f0873cf)
- [second step](https://github.com/tobyweston/Refactoring-Chapter-1/commit/e69a71e29b7e1d556afd932c9264479a37c1a80f)     

### Refactoring: Introduce inheritance
- each type of movie (regular, children's, new release) has different price that is computed in Movie.getCharge()
- can be solved with subclasses: (new) classes RegularMovie, ChildrensMovie, NewReleaseMovie all extend class Movie
- BAD IDEA: movies will switch from NewReleaseMovie to some other category
- alternative: (new) classes RegularPrice, ChildrensPrice, NewReleasePrice all extend Price, which is used by Movie. That way, category of movie can be changed by simply switching to a new price.

![alt text](usingInheritanceOnMovie.png)
![alt text](usingTheStatePatternOnMovie.png)
  
- [create new price classes](https://github.com/tobyweston/Refactoring-Chapter-1/commit/a0d35118b90c8a2ec2a4dd601d2dd73f9ae727ad)
- [use new inheritance in calculation](https://github.com/tobyweston/Refactoring-Chapter-1/commit/c6e70880eae6c0867044b60e016ee0277fafcf8d)
- replace condition with inheritance: [1](https://github.com/tobyweston/Refactoring-Chapter-1/commit/4511529ce748aae80ee1cf2896bc581b991271a8), [2](https://github.com/tobyweston/Refactoring-Chapter-1/commit/445fd49c955d977f5225b8a0f6bfc48cbfd1c8c4)
- change can be viewed as a [state pattern](https://en.wikipedia.org/wiki/State_pattern) or a [strategy pattern](https://en.wikipedia.org/wiki/Strategy_pattern)

## Chapter 2: Principles in Refactoring
### General thoughts 
- refactoring != adding functions. You should be aware of which of these you are doing right now.
- refactoring ensures changeability
- the less code, the better
- most important aspect of code: should be readable because it gets read much more than it gets written
- also, refactoring can help understand unfamiliar code. Kind of "active reading".
- refactoring helps writing good code more quickly - on the long run! In the short run, it takes more time.
- Don't plan a "refactoring sprint", but refactor after every couple of commits, all the time!
- Refactoring code from others doesn't mean they are not able to write great code, just that you see things differently and can improve the code because of this outsiders position.
- hard decision: tell or don't tell the customer about refactoring issues? Depends.
- limitations to refactoring: refactoring already published interfaces will cause problems in code you can't reach. Especially important in framework- and toolkit-code. Can happen with simple refactorings like change method name. Solution: Keep old interface around for a while, mark it with @Deprecated (with a short explanation!). Don't copy method body, but let old implementation call the new one.
- refactoring and design: instead of big upfront-design, design thoughts should be made to a specific degree (upfront), but the rest should be done via refactoring. Do not find __the__ design solution, but __a__ reasonable one.
- very interesting story on page 58/59: about speculation in optimization of systems: "The lesson is: Even if you know exactly what is going on in your system, measure performance, don't speculate. You'll learn something, and nine times out of ten, it won't be that you were right!"     

## Chapter 3: Bad smells in code
- "bad smell" = code that somehow got bad over time in one aspect or another
- no precise criteria, informed human intuition is still the best

### Duplicated Code
- most often simply solved by extract method
- in inheritance hierarchies: extract method + move method to parent => dangerous, may break inheritance!
- duplication in two completely unrelated classes: extract class => may be time to write a static final util-class with pure functions!

### Long method
- short methods often confusing - "Where are things done? I only see delegations to delegations ...". However, on the long run, short methods better.
- "If you have a good name for a method you don't need to look at the body"
- metric: "whenever we feel the need to comment something, we write a method instead"
- OK if resulting code longer than before
- signs for extractions:
    - blocks of code that have comments
    - for-loops
    
### Large Class
- many instance variables, long methods, many methods
- solutions:
    - extract class / subclass (be careful to build a "real" inheritance structure!). Decide new structure by having a look how the class is used by its customers.
    - (if existing) reduce duplications

### Long parameter list
- inconsistent and difficult to use
- parameter objects can encapsulate a number of arguments, so that there are fewer arguments which are queried to get the relevant data

### Divergent Change
- occurs when one class or method changes often for different reasons
- solution: separate concerns by creating new classes (refactoring "extract to class")

### Shotgun Surgery
- to implement a change request, necessary to change a lot of files with only very small changes
- similar to divergent change, but opposite: divergent change = one class, many changes. Shotgun surgery = multiple classes, small changes
- solution: move method, move field

### Feature Envy
-  = class more interested in another class than it should be = a lot of getter-calls (or similar)
- move method to the place the method really wants to be

### Data Clumps
- = data items that hang together all the time while being implemented in separate classes
- solution: extract class to hold rogue data items + introduce parameter object
- quick win: parameter lists shrink

### Primitive Obsession
- don't use primitives where value objects can be used
- especially small objects like ZIP codes or telephone numbers

### Switch Statements
- problem with switches: duplication (because new case forces changes in every switch all over the code)
- solution: polymorphism  

### Parallel Inheritance Hierarchies
- creating subclasses of one class forces creation of subclasses of another type
- solution: use move method and move field to get rid of dependency between the two hierarchies

### Lazy Class
- too small classes should be deleted

### Speculative Generality
- adding hooks and special cases to handle possible future requirements that may never be implemented
- make code hard to understand and change

### Temporary Field
- = using fields to store data globally that should have been stored locally via parameter or normal variables
- solution: extract class for the code that actually uses the variables

### Message Chains
- = long line of getter-calls
- solution: extract and move method

### Middle Man
- = classes that have very similar interfaces to the classes they refer calls to
- solution: remove middle man

### Inappropriate Intimacy
- = several classes doing too much with each other
- solution: move method and field, change bidirectional association to unidirectional, extract class

### Alternative Classes with Different Interfaces
- = classes doing the same thing but with different interfaces
- solution: move method, extract superclass

### Refused Bequest
- = subclasses that don't use all methods from parent class
- solution: Replace Inheritance with Delegation

### Comments
- for itself not a bad smell, but indicators for such
- solutions: remove real bad smell, then remove comments because they aren't needed anymore  

## Chapter 4: Building Tests
- "solid tests" = precondition for refactoring
- tests can be fun to write!
- foundations of TDD
- obsolete example code for JUnit - ignore that
- very useful thought: When fixing a bug, first write at least one test that exposes the bug 
- writing test should be risk-driven: Write test for code that most likely spawns bugs in the future
- test method for boundaries in their arguments and special conditions = "playing the enemy"
- also test exceptions

## Chapter 5: Toward a catalog of refactorings
- explanation of structure of refactorings
- "finding references" = completely obsolete
- weiter: S. 87

## Sources
- Refactoring - Improving the design of existing code. Martin Fowler, Kent Beck

## TODO
- read and add "Refactoring"
- add content from "Refactoring to Patterns"