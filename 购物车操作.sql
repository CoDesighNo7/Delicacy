use delicacy;

desc cartinfo;
desc warehouseInfo;
select * from cartinfo;
select * from warehouseInfo;
delete from cartinfo where cartID=4;

select userID,cartinfo.commodityID,commodityCount,cartID
from cartinfo join commodityinfo on cartinfo.commodityID=commodityinfo.commodityID where userID='1001';

#添加到购物车
select commodityCount from cartinfo where userID='1001' and commodityID=1;
insert into cartinfo(userID,commodityID,commodityCount,commodityPrice) values(?,?,?,?);

#验证添加到购物车的数量
select inventory from warehouseInfo join commodityinfo on warehouseInfo.commodityID=commodityinfo.commodityID where warehouseInfo.commodityID=1;

delete from cartinfo where userID='1001' and commodityID=1;

#修改购物车数量
select commodityCount from cartinfo where userID='1001' and commodityID=1;
update cartinfo set commodityCount=3 where cartID=?;
update warehouseInfo set inventory=? where warehouseID=?;
#删除购物车
select commodityCount from cartinfo where cartID=?;
delete from cartinfo where commodityID=1 and userID='1001';
update warehouseInfo set inventory=20 where warehouseID=2;
