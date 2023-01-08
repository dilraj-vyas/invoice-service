# Create Order
API - http://localhost:7171/frosty-whale/order/create

# Sample Json
{
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
}

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


