# monkkee
Autotest framework for a private and free online diary: https://www.monkkee.com/en

Test cases can be found also [here](https://docs.google.com/spreadsheets/d/12-o_v64ACtwI-LjNc8Y4LB88U4RED3b_jyrR3LzDqQQ/edit#gid=0)

:woman_technologist: The following test cases are automated:

## :yellow_circle: *TC-1.	Create new account.*
1.	Follow the link: [Login Page](https://my.monkkee.com/#/)	- ***Expected:*** Login page is opened. Login form is visible. Clickable 'Register' link is present.
2. Click on 'Register' link.	- ***Expected:*** 'Registration' modal window is opened. 'Email', 'Password', 'Password confirmation', 'Password hint' fields, 'OK' button, Check-boxes 'I have read and agree to the Privacy Policy and Terms of Use.' and 'I am aware that there is no way for monkkee to recover or reset my login password if I forget it and that my data will be irretrievably lost in that case. It is my sole responsibility to remember the password for my account. Learn more about this in the FAQ section.' are present.
3. Fill in the following fields: 'Email' = cab.look.cab@gmail.com; 'Password' = 'Password confirmation' = Password123; 'Password hint' = Password1234. Tick all check-boxes. - ***Expected:***	Listed fields are filled in with test data. Listed check-boxed are ticked.
4. Click on 'OK' button.	- ***Expected:*** User is registered. The following text message is present: 'User registered


## :yellow_circle: *TC-2.	Existing User can log in into the system.*
1. Follow the link: [Login Page](https://my.monkkee.com/#/)	***Expected:*** Login page is opened. Login form is visible. 'User' and 'Password' fields, 'Login' button are present.
2. Fill in the following fields: 'User' = cab.look.cab@gmail.com; 'Password' = Password123. - ***Expected:***	Listed fields are filled in with test data. 
3. Click on 'Login' button. - ***Expected:***	In case no modal window is appeared - User is redirected to [Entries Page](https://my.monkkee.com/#/entries). Active 'Create an entry' button is present on the toolbar.
4. In case a modal window is appeared - close it by clicking 'Cancel'. - ***Expected:*** User is redirected to https://my.monkkee.com/#/entries. Active 'Create an entry' button is present on the toolbar.

## :yellow_circle: *TC-3.	Logged in into the system User can log out.*
1. Follow the link: [Login Page](https://my.monkkee.com/#/)	***Expected:*** Login page is opened. Login form is visible. 'User' and 'Password' fields, 'Login' button are present.
2. Fill in the following fields: 'User' = cab.look.cab@gmail.com; 'Password' = Password123. - ***Expected:***	Listed fields are filled in with test data. 
3. Click on 'Login' button. - ***Expected:***	In case no modal window is appeared - User is redirected to [Entries Page](https://my.monkkee.com/#/entries). Active 'Create an entry' button is present on the toolbar.
4. In case a modal window is appeared - close it by clicking 'Cancel'. - ***Expected:*** User is redirected to https://my.monkkee.com/#/entries. Active 'Create an entry' button is present on the toolbar.
5.	Click on 'Logout' button.	- ***Expected:*** User is redirected to https://my.monkkee.com/#/ (Login page). 'Logout' button is absent.
6. In case a modal window is appeared - close it by clicking 'Logout'. - ***Expected:*** User is redirected to https://my.monkkee.com/#/ (Login page). 'Logout' button is absent.

## :yellow_circle: *TC-4.	User can create a new entry.*
1. Follow the link: [Login Page](https://my.monkkee.com/#/)	***Expected:*** Login page is opened. Login form is visible. 'User' and 'Password' fields, 'Login' button are present.
2. Fill in the following fields: 'User' = cab.look.cab@gmail.com; 'Password' = Password123. - ***Expected:***	Listed fields are filled in with test data. 
3. Click on 'Login' button. - ***Expected:***	In case no modal window is appeared - User is redirected to [Entries Page](https://my.monkkee.com/#/entries). Active 'Create an entry' button is present on the toolbar.
4. In case a modal window is appeared - close it by clicking 'Cancel'. - ***Expected:*** User is redirected to https://my.monkkee.com/#/entries. Active 'Create an entry' button is present on the toolbar.
5.	Click on 'Create an entry' button. - ***Expected:*** A modal window with empty text area for input is present.
6.	Input random text (example: 'Hello, beautiful world!'.).	- ***Expected:*** Text is input. Button with emoji = diskette is marked as 'saved' and is inactive. Input text after creation of new entry equals to generated text input.

## :yellow_circle: *TC-5.	User can remove existing entry.*	
1.	Follow the link: [Login Page](https://my.monkkee.com/#/) - ***Expected:***	Login page is opened. Login form is visible. 'User' and 'Password' fields, 'Login' button are present.
2.	Fill in the following fields: 'User' = cab.look.cab@gmail.com; 'Password' = Password123.	- ***Expected:***	Listed fields are filled in with test data.
3.	Click on 'Login' button.	- Expected:	User is redirected to [Entries Page](https://my.monkkee.com/#/entries). Active 'Create an entry' button is present on the toolbar.
4. In case a modal window is appeared - close it by clicking 'Cancel'. - ***Expected:*** User is redirected to https://my.monkkee.com/#/entries. Active 'Create an entry' button is present on the toolbar.
5.	Click on 'Create an entry' button.	- ***Expected:***	A modal window with empty text area for input is present.
6.	Input random text (example: 'Hello, beautiful world!').	- ***Expected:***	Text is input. Button with emoji = diskette is marked as 'saved' and is inactive.
7.	Click on 'Back to overwiev' button.	- ***Expected:***	User is redirected to [Entries Page](https://my.monkkee.com/#/entries). Post with text message from step 6 is present and is the last one.
8.	Tick the last one post.	- ***Expected:***	The last post is selected.
9.	Click on 'Delete selected entries' button.	- ***Expected:***	Popup 'Do you really want to delete the selected entries?' is shown.
9.	Click 'OK' on the popup.	- ***Expected:***	User remains on [Entries Page](https://my.monkkee.com/#/entries). The last post with text from step 6 is removed and is absent.

## :yellow_circle: *TC-6.	User searches for existing entry.*
1.	Follow the link: [Login Page](https://my.monkkee.com/#/)	- ***Expected:***	Login page is opened. Login form is visible. 'User' and 'Password' fields, 'Login' button are present.
2.	Fill in the following fields: 'User' = cab.look.cab@gmail.com; 'Password' = Password123.	- ***Expected:***	Listed fields are filled in with test data.
3.	Click on 'Login' button.	- ***Expected:***	User is redirected to [Entries Page](https://my.monkkee.com/#/entries). 'Search' field is present on the right side of the window.
4. In case a modal window is appeared - close it by clicking 'Cancel'. - ***Expected:*** User is redirected to https://my.monkkee.com/#/entries. Active 'Create an entry' button is present on the toolbar.
5.	Click on 'Create an entry' button.	- ***Expected:***	A modal window with empty text area for input is present.
6.	Input random text (example: 'Hello, beautiful world!'.) - ***Expected:***	Text is input. Button with emoji = diskette is marked as 'saved' and is inactive.
7.	Click on 'Back to overwiev' button.	- ***Expected:***	User is redirected to [Entries Page](https://my.monkkee.com/#/entries). Post with text message from step 6 is present and is the last one.
8.	Fill in 'Search' field with text input in step 6.	- ***Expected:***	Text from step 6 is input.
9.	Click on 'Search' button.	- ***Expected:*** Post with text from step 6 is present.

## :yellow_circle: *TC-7.	Existing entries can be filtered by the date.*	
1.	Follow the link: [Login Page](https://my.monkkee.com/#/) - ***Expected:***	Login page is opened. Login form is visible. 'User' and 'Password' fields, 'Login' button are present.
2.	Fill in the following fields: 'User' = cab.look.cab@gmail.com; 'Password' = Password123. - ***Expected:*** Listed fields are filled in with test data.
3.	Click on 'Login' button. - ***Expected:***	User is redirected to [Entries Page](https://my.monkkee.com/#/entries). Active 'Create an entry' button is present on the toolbar.
4. In case a modal window is appeared - close it by clicking 'Cancel'. - ***Expected:*** User is redirected to https://my.monkkee.com/#/entries. Active 'Create an entry' button is present on the toolbar.
5.	Click on 'Create an entry' button. - ***Expected:***	A modal window with empty text area for input is present.
6.	Input random text (example: 'There's a time for all things.'). - ***Expected:***	Text is input. Button with emoji = diskette is marked as 'saved' and is inactive.
7.	Click on 'Change date/time' button. Make sure the following date is set: current year and month and day = 10. Click on 'OK' button next to the date. - ***Expected:***	Date: current year and month and day = 10.
8.	Click on the text area for text input. - ***Expected:***	Text is ready to be input.
9.	Input random text (example: 'To be, or not to be, that is the question.'). - ***Expected:***	Text is input. Button with emoji = diskette is marked as 'saved' and is inactive.
10.	Click on 'Back to overwiev' button. - ***Expected:***	User is redirected to [Entries Page](https://my.monkkee.com/#/entries). Post with text message from step 9 is present. 'Calendar' field is present.
11.	Navigate to 'Calendar' field and click on 'Select date' text. - ***Expected:***	Calendar with current month displayed is appeared.
12.	Select the following date: current year and month and day = 10. - ***Expected:***	Only posts with date = 10 current year and month and day = 10 are present.

## :yellow_circle: *TC-8.	Tags can be managed.*
1.	Follow the link: [Login Page](https://my.monkkee.com/#/) - ***Expected:***	Login page is opened. Login form is visible. 'User' and 'Password' fields, 'Login' button are present.
2.	Fill in the following fields: 'User' = cab.look.cab@gmail.com; 'Password' = Password123. - Expected:	Listed fields are filled in with test data.
3.	Click on 'Login' button. - Expected:	User is redirected to [Entries Page](https://my.monkkee.com/#/entries). - ***Expected:*** 'Manage tags' button is present.
4. In case a modal window is appeared - close it by clicking 'Cancel'. - ***Expected:*** User is redirected to https://my.monkkee.com/#/entries. Active 'Create an entry' button is present on the toolbar.
5.	Click on the last entry. Navigate to 'Tags' area. - ***Expected:*** 'Create new tag' field is empty and present.
6.	Fill in 'Create new tag' field with random text. - ***Expected:***	'Create new tag' field is filled in with input text.
7.	Click on 'OK' button next to 'Create new tag' field. - ***Expected:***	There is created in step 6 tag in 'Assigned tags' area.

## :yellow_circle: *TC-9.	Image can be inserted into the entry.*
1.	Follow the link: [Login Page](https://my.monkkee.com/#/) - ***Expected:***	Login page is opened. Login form is visible. 'User' and 'Password' fields, 'Login' button are present.
2.	Fill in the following fields: 'User' = cab.look.cab@gmail.com; 'Password' = Password123. - Expected:	Listed fields are filled in with test data.
3.	Click on 'Login' button. - ***Expected:***	User is redirected to [Entries Page](https://my.monkkee.com/#/entries). Active 'Create an entry' button is present on the toolbar.
4. In case a modal window is appeared - close it by clicking 'Cancel'. - ***Expected:*** User is redirected to https://my.monkkee.com/#/entries. Active 'Create an entry' button is present on the toolbar.
5.	Click on 'Create an entry' button. - ***Expected:***	A modal window with empty text area for input is present.
6.	Input any text (example: 'Jobs fill your pockets, adventures fill your soul.'). - ***Expected:***	Text is input. Button with emoji = diskette is marked as 'saved' and is inactive.
7.	Click on 'Image' button. - ***Expected:***	'Image Properties' modal window is opened. 'Choose File' button is present.
8.	Click on 'Choose File' button. Choose any image (.jpeg format).	 - ***Expected:*** URL with the path to the selected image is present in URL field.
9.	Click on 'OK' button (green highlighted). - ***Expected:***	Text is input. Button with emoji = diskette is marked as 'saved' and is inactive. Selected in step 8 image is displayed.

## :yellow_circle: *TC-10.	User can format existing entry.*
1.	Follow the link: [Login Page](https://my.monkkee.com/#/) - ***Expected:***	Login page is opened. Login form is visible. 'User' and 'Password' fields, 'Login' button are present.
2.	Fill in the following fields: 'User' = cab.look.cab@gmail.com; 'Password' = Password123. - ***Expected:***	Listed fields are filled in with test data.
3.	Click on 'Login' button. - ***Expected:***	User is redirected to [Entries Page](https://my.monkkee.com/#/entries). Active 'Create an entry' button is present on the toolbar.
4. In case a modal window is appeared - close it by clicking 'Cancel'. - ***Expected:*** User is redirected to https://my.monkkee.com/#/entries. Active 'Create an entry' button is present on the toolbar.
5.	Click on 'Create an entry' button. - ***Expected:***	A modal window with empty text area for input is present.
6.	Input any text (example: 'In the cookie of life, friends are the chocolate chips.'). - ***Expected:***	Text is input. Button with emoji = diskette is marked as 'saved' and is inactive.
7.	Click on 'Back to overwiev' button. - ***Expected:***	User is redirected to [Entries Page](https://my.monkkee.com/#/entries). Post with text message = 'In the cookie of life, friends are the chocolate chips.' is present and is the last one.
8.	Click on entry which contains text input in step 6. - ***Expected:***	Entry which contains text input in step 6 only is displayed.
9.	Click on the text of entry. - ***Expected:***	Toolbar manu for formatting is displayed.
10.	Select the whole text message. Click on 'Bold' button. - ***Expected:***  Text Entry is in bold.
