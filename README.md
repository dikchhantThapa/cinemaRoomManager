# Cinema Room Manager 

A program for Cinema ticket booking system.                                       

## Objectives                         
The objective of this program is to first read two positive integer numbers that represent the number of rows and seats in each row of a cinema. Then, it prints a Menu with the following three items:                                     
- **1. Show the seats** - print the current seating arrangement. The empty seats are be marked with an **S** symbol, and taken seats are marked with a **B** symbol.                                              
- **2. Buy a ticket** - read the seat coordinates from the input and print the ticket price like in the previous stage. After that, the chosen seat is marked with a **B** when the item **Show the seats** is called.   
- **3. Statistics** - Print the following information:
    - The number of purchased tickets
    - The number of purchased tickets represented as a percentage. Percentages should be rounded to 2 decimal places;
    - Current income
    - The total income that shows how much money the theatre will get if all the tickets are sold.                    
- **0. Exit** - exit the program 


 ### Extras
 - **Buy a ticket** shouldn't allow a user to buy a ticket that has already been purchased.
 - If a user chooses an already taken seat, print **That ticket has already been purchased!** and ask them to enter different seat coordinates until they pick an available seat. 
 - If coordinates out of bounds are picked, print **Wrong input!** and ask to enter different seat coordinates until the user picks an available seat.

## Example 
The greater-than symbol followed by a space (> )  represents user input. It's not a part of the input. 
<pre>
Enter the number of rows:
> 6
Enter the number of seats in each row:
> 6

1. Show the seats
2. Buy a ticket
3. Statistics
0. Exit
> 3

Number of purchased tickets: 0
Percentage: 0.00%
Current income: $0
Total income: $360

1. Show the seats
2. Buy a ticket
3. Statistics
0. Exit
> 2

Enter a row number:
> 1
Enter a seat number in that row:
> 1

Ticket price: $10

1. Show the seats
2. Buy a ticket
3. Statistics
0. Exit
> 3

Number of purchased tickets: 1
Percentage: 2.78%
Current income: $10
Total income: $360

1. Show the seats
2. Buy a ticket
3. Statistics
0. Exit
> 2

Enter a row number:
> 1
Enter a seat number in that row:
> 1

That ticket has already been purchased!

Enter a row number:
> 10
Enter a seat number in that row:
> 20

Wrong input!

Enter a row number:
> 4
Enter a seat number in that row:
> 4

Ticket price: $10

1. Show the seats
2. Buy a ticket
3. Statistics
0. Exit
> 1

Cinema:
  1 2 3 4 5 6
1 B S S S S S
2 S S S S S S
3 S S S S S S
4 S S S B S S
5 S S S S S S
6 S S S S S S

1. Show the seats
2. Buy a ticket
3. Statistics
0. Exit
> 3

Number of purchased tickets: 2
Percentage: 5.56%
Current income: $20
Total income: $360

1. Show the seats
2. Buy a ticket
3. Statistics
0. Exit
> 0                                                                                     
     
</pre>
