CREATE TABLE T_XBBNHFN_ADMIN(CUSTOMER_ID NUMBER,SERVICE_PROVIDER_ID NUMBER,SERVICE_TYPE NUMBER,TIME VARCHAR(10),DATE1 VARCHAR(15),status varchar(10),feedback varchar(20));
INSERT INTO T_XBBNHFN_ADMIN values(20,10,1,'10AM','PENDING','0');
INSERT INTO T_XBBNHFN_ADMIN values(30,10,1,'10AM','PENDING','0');
select * from t_xbbnhfn_Admin;
SELECT a.customer_id,c.customer_name,c.customer_location,a.time FROM T_XBBNHFN_ADMIN a inner join T_XBBNHFN_CUSTOMERDETAILS c
on a.customer_id=c.customer_id WHERE a.SERVICE_PROVIDER_ID=10 and a.status='PENDING';
drop table T_XBBNHFN_ADMIN;
