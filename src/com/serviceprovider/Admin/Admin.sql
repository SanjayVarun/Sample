CREATE TABLE T_XBBNHFN_ADMIN(CUSTOMER_ID NUMBER,SERVICE_PROVIDER_ID NUMBER,SERVICE_TYPE NUMBER,TIME VARCHAR(10),status varchar(10),feedback varchar(20));
INSERT INTO T_XBBNHFN_ADMIN values(1,20,1,'10AM','Pending');
delete from t_xbbnhfn_Admin;
SELECT a.customer_id,c.customer_name,c.customer_location,a.time FROM T_XBBNHFN_ADMIN1 a inner join T_XBBNHFN_CUSTOMERDETAILS c
on a.customer_id=c.customer_id WHERE a.SERVICE_PROVIDER_ID=30 and a.status='PENDING';
drop table T_XBBNHFN_ADMIN;