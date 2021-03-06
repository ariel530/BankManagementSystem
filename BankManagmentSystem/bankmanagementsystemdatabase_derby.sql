
CREATE TABLE LOGIN (
  USERNAME varchar(300) NOT NULL primary key,
  PASSWORD varchar(300) NOT NULL ,
  FIRSTNAME varchar(300) NOT NULL,
  LASTNAME varchar(300) NOT NULL,
  USERTYPE varchar(100) NOT NULL
);



INSERT INTO LOGIN  VALUES
('admin1', 'admin1', 'Ali', 'Ahmad',  'ADMIN'),
('admin', 'admin', 'Usman', 'Ali', 'ADMIN');






CREATE TABLE ACCOUNT (
ACCOUNTNUMBER varchar(300) NOT NULL primary key,
CLIENTUSERNAME  varchar(300) NOT NULL ,
CREATEDATE date NOT NULL,
ACCOUNTTYPEID int NOT NULL,
BALANCE double default 0,
TRANSFERLIMIT double default 10000,
WITHDRAMLIMIT double default 10000,
STATUS varchar(100) default 'ACTIVE'

);




CREATE TABLE ACCOUNTTYPE (
ID int  NOT NULL primary key
        GENERATED ALWAYS AS IDENTITY
        (START WITH 1, INCREMENT BY 1),
"NAME" varchar(100) NOT NULL

);

insert into ACCOUNTTYPE ("NAME") values('Current Account'),('Saving Account');





CREATE TABLE TRANSACTIONS (
ID int NOT NULL primary key
        GENERATED ALWAYS AS IDENTITY
        (START WITH 1, INCREMENT BY 1),
SENDERACCOUNTNUMBER varchar(300) NOT NULL,
RECIVERACCOUNTNUMBER varchar(300)  ,

SENDINGDATE date NOT NULL,
SENDINGTIME timestamp  NOT NULL,
TRANSACTIONTYPE varchar(40) NOT NULL,
TRANSACTIONAMOUNT double NOT NULL

);




CREATE TABLE TRANSACTIONTYPE (

"NAME" varchar(100) NOT NULL primary key

);

insert into TRANSACTIONTYPE ("NAME") values('DEPOSIT'),('WITHDRAW'),('TRANSFER');





CREATE TABLE COMPLAINS (
ID int NOT NULL primary key
        GENERATED ALWAYS AS IDENTITY
        (START WITH 1, INCREMENT BY 1),
CLIENTUSERNAME varchar(300) NOT NULL  ,
QUESTION varchar(1000) NOT NULL,
ASKEDDATE Date NOT NULL,
ASKEDTIME timestamp NOT NULL, 
ADMINUSERNAME varchar(300) NOT NULL  ,
ANSWER varchar(1000) NOT NULL,
ANSWERDATE Date NOT NULL,
ANSWERTIME timestamp NOT NULL, 
ISANSWER boolean default false
);

