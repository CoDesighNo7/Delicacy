use delicacy;

desc userOrder;
desc orderCommodity;

select * from userOrder;
select * from useracceptinfo;

select u_orderID,userOrder.userID,userinfo.userName,orderCommodity.commodityID,commodityinfo.commodityName,commodityCount,commodityAmont
from userOrder join orderCommodity on userOrder.u_orderID=orderCommodity.orderID,userinfo,commodityinfo
where orderCommodity.commodityID=commodityinfo.commodityID and userOrder.userID=userinfo.userID;