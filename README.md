# Currency-Calculator
Currency calculator created in Java, using JavaFX. It allows user to select one of the exchange rates from the list.

The easiest way to run the program is to download the whole project from Github, open it in any Java IDE like Netbeans (in my case) or Eclipse and then run it.

Currently program reads data from NBP Web API using json file format, but reading from the other sources and file formats can be implemented easily by inheriting ExchangeRateRecord and overriding saveData and readData abstract methods.
Adding another exchange rates from NBP Web API is even more simple. 
To do this we should add another enum type in JsonNBPEnum with correct link, add a new if statement to the constructor (or just inherit ReadJsonNBP class, add new exchange rates to its constructor and then call the constructor of the ReadJsonNBP class).
At the end you have to add the new exchange rates to ObservableList in MainMenuFXMLController allowing user to select it.

Project contains a few tests, mostly for important calculation methods.
Project goal was to implement working calculator for multiple exchange rates, professional GUI was not that important.


Main menu of the project:

![obraz](https://user-images.githubusercontent.com/72347189/222138622-3da09b36-86a9-44f1-81a8-e568ef9fc99d.png)

After selecting "GBP/PLN" and pressing "Calculate" button:

![obraz](https://user-images.githubusercontent.com/72347189/222145388-76596862-8cdb-41bd-b479-1aefbfe4daf5.png)

After typing 100 to GBP text field:

![obraz](https://user-images.githubusercontent.com/72347189/222145577-8929c2cb-37c0-4d03-a91b-53fe414becdf.png)

It is also possible to use PLN text field (round is set for 4 decimal places, but can be change easily in CalculateValues class):

![obraz](https://user-images.githubusercontent.com/72347189/222146048-4c1bfdff-f77b-4ba1-aee6-c9cfc145bddc.png)

In case of incorrect input the second field is just empty:

![obraz](https://user-images.githubusercontent.com/72347189/222146238-8bb73cc0-e16b-47d5-9c93-c1634e4adbcd.png)

