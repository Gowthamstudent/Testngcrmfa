Feature: Validating Website

Scenario: Verify website is working


Given user launch the browser and website 
When user enter username and password
|username|password|
|DemoSalesManager|crmsfa |
Then user mainpage and enter in create lead page
And user fill company name
And user exit browser


