# DeveloperQuizzes

A bank account has attributes like owners and their account balance. The owner should be able to
withdraw money from cash machines or initiate money transfers to other users.
In this task, a little class hierarchy should be established that will consider different types of bank accounts.
Think about how you would demonstrate the functionality with test cases.

* Write a Class “Account”, which stores an Owner (bank customer) and his Balance. It should have a senseful constructor and provide methods for adding money to the account at the cashier and a method to withdraw money. Another method would help the user figure out his current account balance. Those methods should return reasonable errors if things go wrong.

* Create a class “SavingsAccount” which supports interest payments to account owners based on a certain interest rate. You may want to store the current interest rate and provide means to change it. Use a method like “payInterestToAllUsers” to calculate and pay the appropriate interest to account owners.

* Create a class “CheckingAccount”. In a checking account, the owner can withdraw more money than the size of his balance, but also restricted by a limit, which is different for each bank customer. From a checking account, money transfers to other bank customers can be initiated using a method “transferMoney”.
