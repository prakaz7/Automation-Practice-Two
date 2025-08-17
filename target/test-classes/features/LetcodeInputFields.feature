Feature: Let code input fields 
@test1
Scenario Outline: Practice input files let code
Given User can launch the letcode site
When user clicks on the edit option in Input field
Then enter "<fullname>" and append a "<text>" and press tab
And get the text value
Then clear the text
And confirm edit is disabled
Then confirm the text is readonly

Examples:
|fullname|text|
|Prakash|A good tester|