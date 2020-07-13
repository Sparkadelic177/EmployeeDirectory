# Employee Directory Take Home Project

## Your Focus Areas. What area(s) did you focus on when working on the project? The architecture and data flow? The UI? Something else? Please note what you think best exhibits your skills and areas of expertise.
I wanted to challenge myself and decided to work on the architecture and data flow for this project.
I created two folders, one called models and the other one called adapters.

## Copied-in code or copied-in dependencies. We’re obviously looking to evaluate your skills as an engineer! As such, please tell us which code you’ve copied into your project so we can distinguish between code written for this project, versus code written at another time, or by others.

#### Models Folder
In the models folder I have an Employee class that parses and stores the information of each employee in a list via the  dataFromJSONArray function. To sort the list by name I copied in some code in the “sort names” function found on stack overflow.
The other class in the models folder is the EmployeeValidation class, this class is used within the constructor of the Employee class to verify that every required employee data is present and throws a JSONException if one fo the required fields are missing. Missing fields which are not required are given a default value of an empty string.

#### Adapter Folder
In the adapter folder I have code that I have reused from a project to recreate a social media feed which binds the data from the API to the Recycler view.

## Tablet / phone focus. If you focused on one or the other of tablet or phone
I focused more on the phone layout but I had also created landscape views just in case the orientation was changed

## Coding Time
In total this project took me about 4 1/2 - 5 hours.