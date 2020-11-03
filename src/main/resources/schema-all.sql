DROP TABLE transaction IF EXISTS;

CREATE TABLE transaction (
    transaction_id BIGINT IDENTITY NOT NULL PRIMARY KEY,
    amount BIGINT,
    account_id VARCHAR(255),
    timestamp_transaction VARCHAR(50),
    transaction_type VARCHAR(25)
);