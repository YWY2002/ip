# Tommy User Guide

Tommy is an task management program to store important task for the user to refer at their convenience. User do not have to remember what task needs to be done.

## Adding To Do tasks
Use command todo followed by task name. 

For example: `todo house chore`

Task name can have numbers
Expected Program Output:

```
Got it. I've added this task:
  [T][ ] house chore
Now you have 1 task in the list.
```
## Adding deadlines
Use command deadline followed by /by with user-defined deadline to create deadline task. 

For example: `deadline assignment 1 /by 5 May 2359`

Expected output: 
```
Got it. I've added this task:
  [D][ ] assignment 1 (by: 5 May 2359)
Now you have 2 tasks in the list.
```

## Adding event
Use command event followed by /from to state starting date and /to to state ending date. 

For example: `event camping /from 8 May /to 10 May`

Expected output: 
```
Got it. I've added this task:
  [E][ ] camping (from: 8 May to: 10 May)
Now you have 3 tasks in the list.
```

## Deleting task
Use command delete followed by index of task to remove task from the storage. 

For example: `delete 1`

Expected output: 
```
The following task has been removed:
1.[T][ ] house chore
```

## Listing tasks
Use command list to list all events stored.

For example: `list`

Expected output: 
```
Here are the tasks in your list:
1.[T][ ] house chore
2.[D][ ] assignment 1 (by: 5 May 2359)
3.[E][ ] camping (from: 8 May to: 10 May)
```

## Finding event
Use command find to search for task name.

For example: `find assignment`

Expected output: 
```
Here are the matching tasks in your list:
1.[D][ ] assignment 1 (by: 5 May 2359)
```

## Marking/unmarking task
Use command mark/unmark followed by index of task to mark/unmark task as done.

For example: `mark 1`

Expected output: 
```
Nice! I have marked this task as done:
[D][X] assignment 1 (by: 5 May 2359)
```

For example: `unmark 1`

Expected output: 
```
Nice! I have marked this task as not done yet:
[D][ ] assignment 1 (by: 5 May 2359)
```

## Exit program
Use command bye to exit the program

For example: `bye`

Expected output: 
```
Bye. Hope to see you again soon!
```

## Feature 1
The program will do exception handling when user enters invalid command, command with no user-defined task or no command at all.


## Feature 2
Use .txt file to store tasks and all its relevant information (e.g. Task type, deadlines, period of event etc)
