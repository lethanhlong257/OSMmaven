create table osmdb1.place (
   id INT NOT NULL auto_increment,
   name VARCHAR(50) default NULL,
   description  VARCHAR(2000) default NULL,
   street1  VARCHAR(100) default NULL,
   street2  VARCHAR(100) default NULL,
   ward  VARCHAR(20) default NULL,
   district  VARCHAR(20) default NULL,
   city  VARCHAR(30) default NULL,
   state  VARCHAR(20) default NULL,
   country VARCHAR(50) default NULL,
   zipCode INT  default NULL,
   active  BOOLEAN default NULL,
   latitude_second FLOAT  default NULL,
   longtitude_second FLOAT  default NULL,
   phone BIGINT  default NULL,
   img  VARCHAR(200) default NULL,

   PRIMARY KEY (id)
);
