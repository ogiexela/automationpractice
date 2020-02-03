### Tests for account registration form

Given I am on the registration page  
Then I see the following fields marked as required  
1. Your personal information:  
    first name  
    last name  
    email  
    password  
 1. Your address:  
    first name  
    last name  
    address line 1  
    city  
    state  
    zip code  
    country  
    mobile phone  
    
When I submit a form with missing required fields  
Then my requirest is rejected  
And I am informed about which fields must be filled out.  
___
Given I am on the registration page  
And I fill out all required fields with valid values  
Then my registration is accepted when I submit the form  
___
The following test can be repeated for any field which has format validation  

Given I am on the registration page  
And I am entering my <field>  
Then my input is validated for valid <field> format   
@TODO define valid <field> format  

Example:  

Given I am on the registration page  
And I am entering my email  
Then my input is validated for valid email format  
@TODO define valid email format  

___

Given I am on the registration page  
And I am on mobile device  
And I am entering my home or mobile numbers  
Then I am presented with teletephon keyboard  
___

Given I am on the registration page  
And I am on mobile device  
And I am entering my email  
Then I am presented with email keyboard  
___

Given I am on the registration page  
And I fill out all required fields with valid ata  
And I fill out all options fields with valid ata  
When I submit my registration  
Then all filled out fields are submitted  
___

Given I am on the registration page  
And I came from Sign in page  
And I will out the form with valid data  
When I submit my registration  
And my registration is accepted  
Then I am logged in to the site  
And I am taken to My account Page  

___

Given I am on the registration page  
And I came from Checkout page  
And I will out the form with valid data  
When I submit my registration  
And my registration is accepted  
Then I am logged in to the site  
And I am taken to the next step in the checkout flow  
