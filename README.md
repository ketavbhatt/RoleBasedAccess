To implement the code please run the Main method class present in com.role.access.main.Main class.

The code is built for mainly 2 kind of users ie **ADMIN** and **Normal USER**


**Main** class: Used for initializing the admin user and start the processing.

**Model** package contains 3 class and is mainly used for defining the schema

1. Resources is for defining resourceName, and their action type.
2. Role class is for defining role name and list of Resource class
3. User class is for defining userName and list of Role class.

**Service** class contains main logic of the code
Access control is a parent class and contains common method used by both users ie to login as different user
AdminService is where the logic for ADMIN user resides.
NormalUserService is where the logic for Normal user resides.

Please find the sample result:

```bash
hi! you are logged in as admin
press 1 for login as another user
press 2 for create user
press 3 for edit role
press * for exit
2
Please Enter New UserName: 
user1
Please Enter Resource name and their action type space separated eg. A READ press * to exit:
A READ
Press Enter for more entries to exit press * 
B WRITE
Press Enter for more entries to exit press * 
*
Press Enter for more entries to exit press * 
User: user1 created successfully!
hi! you are logged in as admin
press 1 for login as another user
press 2 for create user
press 3 for edit role
press * for exit
3
Enter userName whose role is to be edited: 
user1
Current Role: 
Role Name: user1
Resource name and action type: A [READ]
Resource name and action type: B [WRITE]
Please enter resource name, old action type and new action type to be edited for eg. A READ WRITE press * to exit: 
A READ WRITE
Edited role successfully!
hi! you are logged in as admin
press 1 for login as another user
press 2 for create user
press 3 for edit role
press * for exit
1
Following is the user list please select appropriate username: 
Use Name: user1
Use Name: admin
user1
hi! you are logged in as user1
press 1 for login as another user
press 2 for view roles
press 3 for access resource
press * for exit
2
Following are the roles applicable on user: user1
Role Name: user1
Resource name: A Action Type: [WRITE]
Resource name: B Action Type: [WRITE]
hi! you are logged in as user1
press 1 for login as another user
press 2 for view roles
press 3 for access resource
press * for exit
3
Please enter the resource name and action type of resource space separated: 
A READ
Resource not accessible!
hi! you are logged in as user1
press 1 for login as another user
press 2 for view roles
press 3 for access resource
press * for exit
3
Please enter the resource name and action type of resource space separated: 
B WRITE
Resource accessible!
```


