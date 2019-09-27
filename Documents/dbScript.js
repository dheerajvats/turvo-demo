// Counters Used
db.Counters.insert({
	"_id":"productid",
	"sequence_number":1
});
	
db.Counters.insert({
	"_id":"registrationid",
	"sequence_number":1
});

db.Counters.insert({
	"_id":"orderid",
	"sequence_number":1
});

// FlashSale Entry
db.FlashSale.insert({
	"_id":"sale1",
	"ProductId": 2,
	"Status":"INACTIVE",
	"Duration":"0",
	"RegistrationOpen":true
})

// Demo Customers
db.Customer.insert({
	"_id":"10001",
	"Name": "Customer1",
	"Address":"Address1",
	"Status":"ACTIVE"
})

db.Customer.insert({
	"_id":"10002",
	"Name": "Customer2",
	"Address":"Address2",
	"Status":"ACTIVE"
})

db.Customer.insert({
	"_id":"10003",
	"Name": "Customer3",
	"Address":"Address3",
	"Status":"ACTIVE"
})

// Inventory for product on sale
db.Inventory.insert({
	"ProductId":2,
	"Quantity":20
});
