# Invoice Service

This service allows users to create, view, and manage invoices.

# Features
- Create new invoices
- View existing invoices
- Generate PDF versions of invoices


# Getting Started
These instructions will get you a copy of the project up and running on your local machine for development and testing purposes.

# Prerequisites
- java 11


# Installing
- Clone the repository: git clone https://github.com/dilraj-vyas/invoice-service.git
- Navigate to the project directory: cd invoice-service

# Built With
- maven
# Contributing
If you'd like to contribute to this project, please follow these guidelines:

- Fork the repository
- Create a new branch for your feature
- Commit your changes and push to the new branch
- Submit a pull request

# Domain Layer :

- Customer entity
- Product entity
- OrderItem entity
- Order entity
- Invoice value object
- Tax value object
- Discount value object

# Application Layer:

- `EventListener class:` This class listens for "OrderPaid" events on the messaging queue and triggers the generation of an invoice when an event is received.

- `InvoiceService interface:` (defines methods for generating invoices)

- `InvoiceServiceImpl class:`  This class implements the InvoiceService interface and contains the business logic for generating invoices. 

- `OrderRepositoryImpl class:`  This class implements the OrderRepository interface and contains the logic for interacting with the order data store. this is using  JPA or JDBC to persist and retrieve data from the database.

- `InvoiceRenderer interface:`  (defines methods for rendering invoices as PDFs)

- `InvoiceRendererImpl class:`  This class implements the InvoiceRenderer interface and contains the logic for rendering invoices as PDFs using a library PDFBox.

- `InvoiceStorage interface:`  (defines methods for storing invoices)

- `InvoiceStorageImpl class:`  This class implements the InvoiceStorage interface and contains the logic for storing invoices in a file system or cloud storage service.

- `InvoiceNotifier interface:` (defines methods for notifying customers of their invoices)

- `InvoiceNotifierImpl class:` This class implements the InvoiceNotifier interface and contains the logic for sending notifications to customers via email or SMS.


# Infrastructure Layer:

JmsTemplate (used by the EventListener class to listen for events on the messaging queue)

# Create Order
API - http://localhost:7171/frosty-whale/order/create

# Sample Json
```{
"customer": {
"name": "Ankit",
"email": "ankit@gmail.com",
"mobileNo": "7865486751"
},
"items": [
{
"quantity": 1,
"product": {
"name": "OnePlus Nord CE 2 Lite 5G",
"description": "OnePlus Nord CE 2 Lite 5G",
"price": 18999
}
},
{
"quantity": 1,
"product": {
"name": "Atomic Habits",
"description": "Atomic Habits: the life-changing million-copy #1",
"price":160
}
}
],
"discountPercentage": 0.8,
"status": "oderPaid",
"date": "08-01-2023",
"paymentMethod": "credit card"
}```

# Push Event 

API - http://localhost:7171/frosty-whale/order/push
# Sample  json to trigger Event

{
"id": 1,
"type": "orderPaid",
"order": {
"id": 1,
"customer": {
"name": "Ankit",
"email": "ankit@gmail.com",
"mobileNo": "7865486751"
}
}
}




