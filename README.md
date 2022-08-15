# addFarmers
A short app which writes to collections in Cassandra to help answer this question on Stack Overflow:
https://stackoverflow.com/questions/73331316/invalid-string-constant-or-mismatched-input-expecting-cassandra-db

# Cassandra Schema
Code works with this schema:

```sql
CREATE TABLE stackoverflow.farmers (
    farmer_id int PRIMARY KEY,
    delivery list<text>,
    the_farmer map<text, text>
);
```
