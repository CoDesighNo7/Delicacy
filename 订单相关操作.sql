use delicacy;

desc userOrder;
desc orderCommodity;

select * from userOrder;
select * from useracceptinfo;
select * from cartinfo;
select * from commodityinfo;


select u_orderID,userOrder.userID,userinfo.userName,orderCommodity.commodityID,commodityinfo.commodityName,commodityCount,commodityAmont
from userOrder join orderCommodity on userOrder.u_orderID=orderCommodity.orderID,userinfo,commodityinfo
where orderCommodity.commodityID=commodityinfo.commodityID and userOrder.userID=userinfo.userID;

#生成订单
insert into userOrder(u_orderID,userID,acceptinfoID,createTime,paymentAmont,u_orderState)
values('1001001','1001',1,now(),100,0);
insert into orderCommodity(orderID,commodityID,commodityCount,commodityPrice,commodityAmont)
values('1001001',1,3,7,21);

#查询订单
select *
from userOrder join orderCommodity on userOrder.u_orderID=orderCommodity.orderID
where userID='1001';