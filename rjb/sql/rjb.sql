
CREATE TABLE ship (
    ship_id varchar(20) PRIMARY KEY,
    ship_name VARCHAR(255),
    ship_company VARCHAR(255) 
);

CREATE TABLE gangkou(
      port_id varchar(20) PRIMARY KEY,
	  port_name VARCHAR(255)
);

CREATE TABLE zuoye (
    ship_id varchar(20),
    port_id varchar(20),
    start_date DATETIME,
    end_date DATETIME,
    departure_date DATETIME,
    arrival_date DATETIME,
    origin VARCHAR(255),
    destination VARCHAR(255),
    status INT,
    PRIMARY KEY (ship_id, port_id),
    FOREIGN KEY (ship_id) REFERENCES ship(ship_id),
    FOREIGN KEY (port_id) REFERENCES gangkou(port_id)
);

CREATE TABLE boxs (
    box_id varchar(20) PRIMARY KEY,
    box_size VARCHAR(255),
    box_location VARCHAR(255),
    operation VARCHAR(255),
    port_id varchar(20),
    FOREIGN KEY (port_id) REFERENCES gangkou(port_id)
);

CREATE TABLE box_ship (
  box_id varchar(20) NOT NULL,
  ship_id varchar(20) NOT NULL,
  PRIMARY KEY (box_id, ship_id),
  FOREIGN KEY (box_id) REFERENCES boxs(box_id),
  FOREIGN KEY (ship_id) REFERENCES ship(ship_id)
);

CREATE TABLE companys (
    company_id varchar(10) NOT NULL PRIMARY KEY,
    company_name varchar(50) NOT NULL
);

CREATE TABLE customers (
  customer_id varchar(20)  PRIMARY KEY,
  customer_name VARCHAR(50),
  tel CHAR(11),
  addresss VARCHAR(50),
  company_id varchar(10),
  FOREIGN KEY (company_id) REFERENCES companys (company_id)
);

CREATE TABLE orders (
  bol_id varchar(20)  PRIMARY KEY,
  customer_id varchar(20),
  company_id varchar(20),
  FOREIGN KEY (customer_id) REFERENCES customers (customer_id),
  FOREIGN KEY (company_id) REFERENCES companys (company_id)
);

CREATE TABLE order_box (
  bol_id varchar(20),
  box_id varchar(20),
  PRIMARY KEY (bol_id, box_id),
  FOREIGN KEY (bol_id) REFERENCES orders (bol_id),
  FOREIGN KEY (box_id) REFERENCES boxs (box_id)
);

CREATE TABLE goods (
    goods_id varchar(10) NOT NULL PRIMARY KEY,
    goods_name varchar(50) NOT NULL,
    goods_weight decimal(10, 2) NOT NULL
);

CREATE TABLE goods_order (
    goods_id varchar(10) NOT NULL,
    bol_id varchar(20) NOT NULL,
    sum int,
    PRIMARY KEY (goods_id, bol_id),
    FOREIGN KEY (goods_id) REFERENCES goods (goods_id),
    FOREIGN KEY (bol_id) REFERENCES orders (bol_id)
);



