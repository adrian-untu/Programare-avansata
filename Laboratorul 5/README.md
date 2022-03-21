For the compulsory part of the 5th laboratory, I implemented the requested things required by the task.
I created multiple classes, including:
1. Main - the main class
2. NameException - as it is in the name, this class ensures that the id's are unique(the exception is implemented in another class)
3. InvalidCatalogException - exception for the JSON file
4. Item - abstract class, which has Article and Book type data
5. Article and Book - made kind of the same, they just handle the add of the items
6. Catalog - stores the catalog in a JSON file
7. ServiceCatalog - at the moment, it handles the add, toString, load, save functions
8. Serializable - handles the item being serializable (ensures it can be listed as JSON)