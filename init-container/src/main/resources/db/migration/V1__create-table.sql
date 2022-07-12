CREATE TABLE article (
    id integer PRIMARY KEY ,
    description varchar(255),
    barcode varchar(255)
);

create index barcode_idx on article(barcode);