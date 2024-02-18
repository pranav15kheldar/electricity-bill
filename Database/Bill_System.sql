use Bill_system;
select * from Signup;
Insert into Signup (meter_no , username , name , password , usertype)
values(2039568 , 'pranav' , 'Pranav' , 'pranav123' , 'Admin');

create table New_Coustomer(name varchar(20) , meter_no varchar(20) ,  address varchar(30) , city varchar(30) , state varchar(20) , email varchar(20), mobile_no varchar(12) );
select * from New_Coustomer;

create table meter_info (meter_num varchar(30) , meter_loc varchar(30), meter_type varchar(30) , phase_code varchar(30) , bill_type varchar(30), days varchar(30));
select * from meter_info;

create table tax(cost_per_unit varchar(20) , meter_rent varchar(20) , service_charge varchar(20) , service_tax varchar(20) , swach_bharat varchar(20) , fixed_tax varchar(20) );
select * from tax;
insert into tax values('9' , '47' , '20' , '58' ,'5','18');

create table bill (meter_num varchar(20) , month varchar(20) , unit varchar(20) , total_bill varchar(20), status varchar(20));
select * from bill;