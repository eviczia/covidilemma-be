# Covidilemma

A fun interactive educational tool. 
Our aim is to provide a surface to check your knowledge about the current COVID-19 pandemic.
All the stages of the game (count down, new question, right answer, wrong answer etc.) are supported by colorful coordinated remote RGB leds.

## Getting Started

### Prerequisites

 * JDK 8
 * Intellij IDEA
 * MySQL 8
 * React
 * JavaScript
 * Node.JS
 
 ### Dependencies
 
  * Retrofit2
  * Gson Converter
  * Spring Boot	
  
 ### Deployed version
  
  - Heroku server: DEPLOYOLT LINK
 
 
### Run the app locally

#### Clone this repository

```
> git clone https://github.com/NemethJohanna/Covidilemma.git
```
 
#### Environment variables

**General**
 
| Key | Value |
| --- | ----- | 
|ACESS_KEY | *the given API key you have* |

**Database connection**

| Key | Value |
| --- | ----- |
|DATABASE_URL | jdbc:mysql://localhost:8080/covidilemma|
|COVIDILEMMA_DB_USERNAME | *your local mysql username* |
|COVIDILEMMA_DB_PASSWORD | *your local mysql password* |

**Authentication**

| Key | Value |
| --- | ----- | 
|SECRET_KEY | this will be used for token generation, you can use any random string |
 

#### (Optional) Add datasource to Intellij IDEA

Open `View > Tool Windows > Database` and connect to your previously created database

#### Start the application

Our launcher class is `CovidilemmaApplication`

After successful launching you can access the application in `localhost:8080`

#### [GET /questions]
- get questions for playing

#### [POST /question]
- post questions for store new questions

#### [POST /login]
- login players to the quiz

#### [POST /stop]
- stops the connection with the third API controlling the led panel