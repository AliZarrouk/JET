Run `vms.Application.main`

Query examples:

Create voucher:
```avro idl
curl --location --request POST 'localhost:8080/voucher/12292345-0a0b-4682-a62b-35cdbbde2d8d/claim' \
--header 'Content-Type: application/json' \
--data-raw '{
    "amount" : 50,
    "expiresOn": "2023-01-01"
}'
```

Get voucher:
```avro idl
curl --location --request GET 'localhost:8080/voucher/VOUCHER_CODE'
```

Claim voucher:
```avro idl
curl --location --request POST 'localhost:8080/voucher/1a7d6d8f-2360-42ae-ad81-6a065f2ad470/claim' \
--header 'Content-Type: application/json' \
--data-raw '{
    "amount" : 20
}'
```

