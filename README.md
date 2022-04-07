# Isaac character generator 
## About The Project
This project is a random generator customized to match "The Binding of Isaac" domain.
The generator additionally has a weighting system that can affect the probability of drawing a specific result.  
What's more, providing specified data can automatically increase a character's weight

 **The whole application was developed following best practices of Clean Code, SOLID and FIRST with addition of Unit and 
Integration Tests written in TDD approach to check proper functionality, performance and prevent regression in project.**

## Built with
* Java 11
* JUnit 5
* AssertJ
* Google Guava

## Usage
![](https://github.com/Rybaczek/isaac-character-generator-application/blob/master/Animation.gif)

The user is typing the character's name, the weight (after a comma) and if it has any, defeated bosses (separated with commas) after --c .     
After characters are added to the pool program is picking one of them based on provided data and outputting the result.
## Roadmap
- [ ] Add duplicate protection option
- [ ] Add option to collect data for generation from file
- [ ] Add support for Spring Framework
