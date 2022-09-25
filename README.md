# monkkee
Autotest framework for a private and free online diary: https://www.monkkee.com/en

The following test cases are automated:

TC-1.	Create new account.
Step 1.	Follow the link: https://my.monkkee.com/#/	- Expected: Login page is opened. Login form is visible. Clickable 'Register' link is present.
Step 2. Click on 'Register' link.	- Expected: Registration' modal window is opened. 'Email', 'Password', 'Password confirmation', 'Password hint' fields, 'OK' button, Check-boxes 'I have read and agree to the Privacy Policy and Terms of Use.' and 'I am aware that there is no way for monkkee to recover or reset my login password if I forget it and that my data will be irretrievably lost in that case. It is my sole responsibility to remember the password for my account. Learn more about this in the FAQ section.' are present.
Step 3. Fill in the following fields: 'Email' = cab.look.cab@gmail.com; 'Password' = 'Password confirmation' = Password123; 'Password hint' = Password1234. Tick all check-boxes. - Expected:	Listed fields are filled in with test data. Listed check-boxed are ticked.
Step 4. Click on 'OK' button.	- Expected: User is registered. The following text message is present: 'User registered
You will now receive an email with a confirmation link. Please follow the instructions in the email. Please also check your Spam folder!'.
Step 5.	Find the email with a confirmation link in your post client and click on 'Confirm' link.	- Expected: Registration confirmed successfully: User is redirected to monkkee website. The following text message is present: 'Now you can start. Log in here:
https://my.monkkee.com'.

TC-2.	Existing User can log in into the system.
Step 1.	Follow the link: https://my.monkkee.com/#/	Expected: Login page is opened. Login form is visible. 'User' and 'Password' fields, 'Login' button are present.
Step 2.	Fill in the following fields: 'User' = cab.look.cab@gmail.com; 'Password' = Password123. - Expected:	Listed fields are filled in with test data.
Step 3.	Click on 'Login' button. - Expected:	User is redirected to https://my.monkkee.com/#/entries. Active 'Create an entry' button is present on the toolbar.

TC-3.	Logged in into the system User can log out.	
Step 1.	Follow the link: https://my.monkkee.com/#/ - Expected:	Login page is opened. Login form is visible. 'User' and 'Password' fields, 'Login' button are present.
Step 2.	Fill in the following fields: 'User' = cab.look.cab@gmail.com; 'Password' = Password123. - Expected:	Listed fields are filled in with test data.
Step 3.	Click on 'Login' button.	User is redirected to https://my.monkkee.com/#/entries. - Expected: Active 'Logout' button is present on the right corner of the window.
Step 4.	Click on 'Logout' button.	- Expected: User is redirected to https://my.monkkee.com/#/ (Login page). 'Logout' button is absent.

TC-4.	User can create a new entry.	
Step 1.	Follow the link: https://my.monkkee.com/#/ - Expected:	Login page is opened. Login form is visible. 'User' and 'Password' fields, 'Login' button are present.
Step 2.	Fill in the following fields: 'User' = cab.look.cab@gmail.com; 'Password' = Password123. - Expected:	Listed fields are filled in with test data.
Step 3.	Click on 'Login' button. - Expected:	User is redirected to https://my.monkkee.com/#/entries. Active 'Create an entry' button is present on the toolbar.
Step 4.	Click on 'Create an entry' button. - Expected: A modal window with empty text area for input is present.
Step 5.	Input the following text 'Hello, beautiful world!'.	- Expected: Text is input. Button with emoji = diskette is marked as 'saved' and is inactive.
Step 6.	Click on 'Back to overwiev' button.	- Expected: User is redirected to https://my.monkkee.com/#/entries. Post with text message = 'Hello, beautiful world!' is present and is the last one.

TC-5.	User can remove existing entry.	
Step 1.	Follow the link: https://my.monkkee.com/#/ - Expected:	Login page is opened. Login form is visible. 'User' and 'Password' fields, 'Login' button are present.
Step 2.	Fill in the following fields: 'User' = cab.look.cab@gmail.com; 'Password' = Password123.	- Expected:	Listed fields are filled in with test data.
Step 3.	Click on 'Login' button.	- Expected:	User is redirected to https://my.monkkee.com/#/entries. Active 'Create an entry' button is present on the toolbar.
Step 4.	Click on 'Create an entry' button.	- Expected:	A modal window with empty text area for input is present.
Step 5.	Input the following text 'Hello, beautiful world!'.	- Expected:	Text is input. Button with emoji = diskette is marked as 'saved' and is inactive.
Step 6.	Click on 'Back to overwiev' button.	- Expected:	User is redirected to https://my.monkkee.com/#/entries. Post with text message = 'Hello, beautiful world!' is present and is the last one.
Step 7.	Tick the last one post.	- Expected:	The last post is selected.
Step 8.	Click on 'Delete selected entries' button.	- Expected:	Alert 'Do you really want to delete the selected entries?' is shown.
Step 9.	Click 'OK' on the alert.	- Expected:	User remains on https://my.monkkee.com/#/entries. The last post with text 'Hello, beautiful world!' is removed and is absent.

TC-6.	User searches for existing entry.	
1.	Follow the link: https://my.monkkee.com/#/	- Expected:	Login page is opened. Login form is visible. 'User' and 'Password' fields, 'Login' button are present.
2.	Fill in the following fields: 'User' = cab.look.cab@gmail.com; 'Password' = Password123.	- Expected:	Listed fields are filled in with test data.
3.	Click on 'Login' button.	- Expected:	User is redirected to https://my.monkkee.com/#/entries. 'Search' field is present on the right side of the window.
4.	Fill in 'Search' field with 'Welcome' word.	- Expected:	'Welcome' word is input.
5.	Click on 'Search' button.	- Expected:Post with text 'Welcome to monkkee!' is present.
