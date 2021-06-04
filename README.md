# Online-Voting-System
Basic Online Voting System made in Java. Concepts used to build this system: Abstraction, Object Oriented Programming and File Handling.


# Explanation
 Initially importing all required packages to implement necessary methods.
Abstract class voting machine which has abstract method vote that is to be used to increase number of votes for all parties defined differently in all classes of parties to achieve abstraction as a voting system requires so.
The first class BJP that extends abstract class to use its method which whenever invoked opens the file BJP.txt and writes the number 1 and then writes a new line. This block is inside the try catch block since when dealing with files an exception can occur at any time so it’s better to deal with it then and there.

Since the voting procedure is same for all parties therefore all other party classes (INC,AAP,BSP,NCP,CPI) have the same definition as above.


Class voter_check has a method called check of integer return-type which has takes in two parameters that is the name of the person and his/her Voter id and checks in the file “people_who_voted.txt” where all the names of people who voted are written. If both parameters match for any voter who already voted then integer 1 is returned else 0.

Class admin has a method called admin_check of integer return-type which has takes in two parameters that is the UserId of the admin and his/her password and checks in the file “admin.txt” where all the credentials of existing admins are stored. If both parameters are verified for the person logging in then integer 1 is returned else 0.

Class voter_count has a method named count of integer return-type which is used to count the number of voters who have voted till now. It first initializes a counter to 0 which increments for every line read. Since in the file “people_who_voted.txt” for any given person it has 2 details(name and Voter id) which occupy 2 lines therefore to get the total number of people the counter at the end has to be divided by 2. The counter is then returned. 

Class max has the method max_method of integer return-type which is used to calculate the maximum votes of all the parties using the Math.max() method and then that integer is returned.

Class Test containing main
Initializing all counters which counts the number of votes to 0 then reading the file “previous_votes” using Buffered reader. This file contains the votes of all parties if this system had been previously used and updates each counter to that value by parsing the value from string to int.
	This feature makes this system more robust as even if the voting keeps on going for like 2-3 in the real world, it holds the capability to update the count of votes from the previous day in the present counter. Therefor all the counters get the total number of votes after each execution of the program without any manual labour.
After successfully assigning counters their value a do-while loop is implemented to keep the voting system on for multiple users. The user is given two option:
 1. Admin login 
 2. Voter login
//                                                  Admin Part                                                  //
When pressed 1 the credentials of the admin are asked (User ID and Password). The credentials entered by the user are sent as parameters to the admin_check method of admin class. The object of admin class is created there and the admin_check method is called. The admin_check method returns an integer(0 or 1) which is stored into a variable named ad_chk_res using which the conditional statements work. If the admin is verified(i.e. ad_chk_res =1) he/she can use his/her admin privileges else a statement is printed i.e. “Invalid User ID and Password!”.


When admin is verified he/she has 2 privileges from which they can select upon:

1.	Check on which party is winning
2.	Check number of voters who’ve voted until now
When the admin selects 1, an object of max class is created and using that object the max_method is called with parameters that are vote counters of all parties. Now the max_method returns the integer which is the maximum out of all the parameters which is then assigned to the “most” variable. To now know which party had the value that now the “most” variable contains, consecutive if statements are used to check each counter with the most variable.  
In the case where there is no draw we could have printed it then and there after checking. But to add features where the program would even show if there is a draw and between whom the following logic is implemented:
So the idea that I thought behind this is that whenever there is a positive check on any of the consecutive “if’s” the counter which had the positive check, in that if statement I would add that counters party name to an ArrayList which would make printing easier later on.
Now checking the ArrayList size, printing statements are written accordingly in consecutive if statements. The size here determines number of people with the maximum votes. For a single winner size is 1, for a draw between 3 the size is three and so on.

When the admin selects 2, an object of voter_count is created and using that object the count method is called. The count method returns the number of voters which is received in variable voters and then printed.
//                                              End of Admin Part                                                 //

//                                               Voter Part                                               //

This section of code starts by taking in the User’s name and Voter ID. An object of class voter_check is created and using that object the check method is called with parameters that are the user’s name and Voter ID. The method will check and return 1 in case the user has already voted and 0 in the case when the user is going to vote for the first time. The returned integer is stored in the variable “result” which is used for the conditional statement that follow which will allow the user to vote or not.
In the case when it is a New Voter, messages are printed as to which integer to input to vote for a particular party (eg. 1 for BJP, 2 for INC, etc.). The input from the user is received in the variable “choice” which is then used to run the switch case that follows.

In the case the user presses 1 to vote for BJP then in the “case 1” of the switch case an object of class BJP is created which is then used to call the abstract method “vote” which was defined in the BJP class to increase the votes for BJP by 1. The counter that keeps track of the votes is then incremented by 1.
Since the voter has successfully voted now therefore now his/her name is appended in “people_who_voted.txt” file so that he/she wouldn’t be able to vote again and the file is closed.

Since the voting process is same for all the parties therefore the same process is implemented for other parties in their respective “Switch Cases”.

If it’s a Voter who has already voted then a message is displayed “You can’t vote more than once!” and the loop continues.

Now at the end of the loop all the counters have Increased values as people have voted. Therefor to obtain the feature of using the same program for multiple days of voting and keeping a track of the total votes for all parties with all votes from all the days the voting continues for, then we have to store these values in a different file from which whenever the program is run again the counters can be re-initialized with those values.
Hence all the counters are converted to from Int type String type and written in the file “previous_votes.txt”. and the file is closed.
Exception handling is used thoroughly throughout the program wherever necessary to avoid runtime Exceptions stopping the Voting the process.


SCOPE:
1.	It can check whether a voter has previously voted or not which is an important feature for implementing a voting system.
2.	It can even show all the parties who have the same votes in the case of a draw.
3.	The voting process uses abstract classes which help in abstraction of the program.
4.	To add features an admin login system is created where in the admin has privileges to check on the status of the voting process.
5.	Only existing admins can check on the status of the voting process so that important information doesn’t get leaked to the public.
6.	Admin’s can check on the number of voters who have voted until now.
7.	Admin’s can also check onto who’s winning/leading with maximum votes.
8.	This program can even be used for multiple days of the voting process, where all votes and voters who voted list would be updated each time the program finishes executing to calculate and preserve data without any manual labour.
9.	Handle Runtime-exceptions without any difficulty.
10.	File handling is used which helps in storing and preserving data for future use.

Limitations:
1.	This program can be made online but due to lack of knowledge of GUI’s and javascript couldn’t be implemented that way.
2.	Multiple voters can’t vote simultaneously.
3.	Large number of voters aren’t supported as the number of votes would exceed the range of int.
