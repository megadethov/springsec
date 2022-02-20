-- docker run -p 5432:5432 -e POSTGRES_USER=mega -e POSTGRES_PASSWORD=postgres -e POSTGRES_DB=eazybank -d postgres:13.3

-- jdbc:postgresql://localhost:5432/eazybank
-- mega
-- postgres

CREATE EXTENSION IF NOT EXISTS "uuid-ossp";

CREATE TABLE users
(
    id       SERIAL PRIMARY KEY,
    username VARCHAR(50) NOT NULL,
    password VARCHAR(50) NOT NULL,
    enabled  SMALLINT    NOT NULL
);

CREATE TABLE authorities
(
    id        SERIAL PRIMARY KEY,
    username  VARCHAR(50) NOT NULL,
    authority VARCHAR(50) NOT NULL
);

INSERT INTO users (username, password, enabled)
VALUES ('user_login', 'user_password', 1);

INSERT INTO authorities (username, authority)
VALUES ('user_login', 'write');

-- for custom implementation
CREATE TABLE customer
(
    id            SERIAL PRIMARY KEY,
    name          VARCHAR(100) NOT NULL,
    email         VARCHAR(100) NOT NULL,
    mobile_number VARCHAR(20)  NOT NULL,
    pwd           VARCHAR(200) NOT NULL,
    role          VARCHAR(50)  NOT NULL,
    create_dt     DATE DEFAULT NULL
);

INSERT INTO customer (name, email, mobile_number, pwd, role, create_dt)
VALUES ('custom_name', 'custom@email.com', '111-222-333',
        '$2a$12$9PGRfB4QpC0e0P6NDnYNkOhNSlc7Jbjh.PsKsZ0D6.CgIKiwCzcF.', 'admin', CURRENT_DATE);

CREATE TABLE accounts
(
    account_number INTEGER PRIMARY KEY,
    customer_id    INTEGER REFERENCES customer (id) ON DELETE CASCADE,
    account_type   VARCHAR(100) NOT NULL,
    branch_address VARCHAR(200) NOT NULL,
    create_dt      DATE DEFAULT NULL
);

INSERT INTO accounts (account_number, customer_id, account_type, branch_address, create_dt)
VALUES (123456789, 1, 'Savings', '777 Custom Street, Custom City', CURRENT_DATE);

CREATE TABLE account_transactions
(
    transaction_id      VARCHAR(200) PRIMARY KEY,
    account_number      INTEGER REFERENCES accounts (account_number) ON DELETE CASCADE,
    customer_id         INTEGER REFERENCES customer (id) ON DELETE CASCADE,
    transaction_dt      DATE         NOT NULL,
    transaction_summary VARCHAR(200) NOT NULL,
    transaction_type    VARCHAR(100) NOT NULL,
    transaction_amt     INTEGER      NOT NULL,
    closing_balance     INTEGER      NOT NULL,
    create_dt           DATE DEFAULT NULL

);

INSERT INTO account_transactions (transaction_id, account_number, customer_id, transaction_dt, transaction_summary, transaction_type, transaction_amt, closing_balance, create_dt)
VALUES (uuid_generate_v4(), 123456789, 1, CURRENT_DATE - INTERVAL '7 DAY', 'Coffee Shop', 'Withdrawal', 30, 34500, CURRENT_DATE - INTERVAL '7 DAY'),
       (uuid_generate_v4(), 123456789, 1, CURRENT_DATE - INTERVAL '6 DAY', 'Uber', 'Withdrawal', 100, 34400, CURRENT_DATE - INTERVAL '6 DAY'),
       (uuid_generate_v4(), 123456789, 1, CURRENT_DATE - INTERVAL '5 DAY', 'Self Deposit', 'Deposit', 500, 34900, CURRENT_DATE - INTERVAL '5 DAY'),
       (uuid_generate_v4(), 123456789, 1, CURRENT_DATE - INTERVAL '4 DAY', 'Ebay', 'Withdrawal', 600, 34300, CURRENT_DATE - INTERVAL '4 DAY'),
       (uuid_generate_v4(), 123456789, 1, CURRENT_DATE - INTERVAL '2 DAY', 'OnlineTransfer', 'Deposit', 700, 35000, CURRENT_DATE - INTERVAL '2 DAY'),
       (uuid_generate_v4(), 123456789, 1, CURRENT_DATE - INTERVAL '1 DAY', 'Amazon.com', 'Withdrawal', 100, 34900, CURRENT_DATE - INTERVAL '1 DAY');

CREATE TABLE loans
(
    loan_number        SERIAL PRIMARY KEY,
    customer_id        INTEGER REFERENCES customer (id) ON DELETE CASCADE,
    start_dt           DATE         NOT NULL,
    loan_type          VARCHAR(100) NOT NULL,
    total_loan         INTEGER      NOT NULL,
    amount_paid        INTEGER      NOT NULL,
    outstanding_amount INTEGER      NOT NULL,
    create_dt          DATE DEFAULT NULL
);

INSERT INTO loans (customer_id, start_dt, loan_type, total_loan, amount_paid, outstanding_amount, create_dt)
VALUES (1, '2020-10-13', 'Home', 200000, 50000, 150000, '2020-10-13'),
       (1, '2020-06-06', 'Vehicle', 40000, 10000, 30000, '2020-06-06'),
       (1, '2018-02-14', 'Home', 50000, 10000, 40000, '2018-02-14'),
       (1, '2018-02-14', 'Personal', 10000, 3500, 6500, '2018-02-14');

CREATE TABLE cards
(
    card_id          SERIAL PRIMARY KEY,
    card_number      VARCHAR(100) NOT NULL,
    customer_id      INTEGER REFERENCES customer (id) ON DELETE CASCADE,
    card_type        VARCHAR(100) NOT NULL,
    total_limit      INTEGER      NOT NULL,
    amount_used      INTEGER      NOT NULL,
    available_amount INTEGER      NOT NULL,
    create_dt        DATE DEFAULT NULL
);

INSERT INTO cards (card_number, customer_id, card_type, total_limit, amount_used, available_amount, create_dt)
VALUES ('4565XXXX4656', 1, 'Credit', 10000, 500, 9500, CURRENT_DATE),
       ('3455XXXX8673', 1, 'Credit', 7500, 600, 6900, CURRENT_DATE),
       ('2359XXXX9346', 1, 'Credit', 20000, 4000, 16000, CURRENT_DATE);

CREATE TABLE notice_details
(
    notice_id      SERIAL PRIMARY KEY,
    notice_summary VARCHAR(200) NOT NULL,
    notice_details VARCHAR(500) NOT NULL,
    notice_beg_dt  DATE         NOT NULL,
    notice_end_dt  DATE DEFAULT NULL,
    create_dt      DATE DEFAULT NULL,
    update_dt      DATE DEFAULT NULL
);

INSERT INTO notice_details (notice_summary, notice_details, notice_beg_dt, notice_end_dt, create_dt, update_dt)
VALUES ('Home Loan Interest rates reduced', 'Home loan interest rates are reduced as per the goverment guidelines. The updated rates will be effective immediately', '2020-10-14', '2020-11-30', CURRENT_DATE, null),
       ('Net Banking Offers', 'Customers who will opt for Internet banking while opening a saving account will get a $50 amazon voucher', '2020-10-14', '2020-12-05', CURRENT_DATE, null),
       ('Mobile App Downtime', 'The mobile application of the EazyBank will be down from 2AM-5AM on 12/05/2020 due to maintenance activities', '2020-10-14', '2020-12-01', CURRENT_DATE, null),
       ('E Auction notice', 'There will be a e-auction on 12/08/2020 on the Bank website for all the stubborn arrears.Interested parties can participate in the e-auction', '2020-10-14', '2020-12-08', CURRENT_DATE, null),
       ('Launch of Millennia Cards', 'Millennia Credit Cards are launched for the premium customers of EazyBank. With these cards, you will get 5% cashback for each purchase', '2020-10-14', '2020-11-28', CURRENT_DATE, null),
       ('COVID-19 Insurance', 'EazyBank launched an insurance policy which will cover COVID-19 expenses. Please reach out to the branch for more details', '2020-10-14', '2020-12-31', CURRENT_DATE, null);

CREATE TABLE contact_messages
(
    contact_id    VARCHAR(50) PRIMARY KEY,
    contact_name  VARCHAR(50)   NOT NULL,
    contact_email VARCHAR(100)  NOT NULL,
    subject       VARCHAR(500)  NOT NULL,
    message       VARCHAR(2000) NOT NULL,
    create_dt     date DEFAULT NULL
);
