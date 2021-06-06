# ContactManager
Spring boot REST application for maintaining contact information.

**Functionalities - **
- List contacts
    URI to fetch list of all contacts -
    GET HTTP method - http://localhost:8080/contacts/

- Add a contact
    URI to add any new contact -
    PUSH HTTP method- http://localhost:8080/contacts/
    Sample request body -
  {
        "firstName": "vivek",
        "lastName": "Namdeo",
        "email": "vkk393@gmail.com",
        "phoneNumber": "7999865369",
        "status": "ACTIVE"
  }

- Edit contact
    URI to edit a particular contact -
    PUT HTTP method- http://localhost:8080/contacts/
    If we want to update last name of contact vivek then below request body needs to be passed in put method-
    Sample request body -
  {
        "firstName": "vivek",
        "lastName": "Kumar Namdeo",
        "email": "vkk393@gmail.com",
        "phoneNumber": "7999865369",
        "status": "ACTIVE"
  }
  
- Delete a contact
    URI to delete any contact 
    DELETE http method call - http://localhost:8080/contacts/<name>
    e.g. http://localhost:8080/contacts/vivek
    Above will delete vivek contact.
    After above, run list contacts api call which will now show deleted record in the list.
  
 - Inactivate a contact
    URI to inactivate any contact -
    PUT http method call to - http://localhost:8080/contacts/<contact name>/<INACTIVE/ACTIVE>
    e.g. http://localhost:8080/contacts/vivek/INACTIVE
    After above, run list contacts api call which will show updated record.
  
  
