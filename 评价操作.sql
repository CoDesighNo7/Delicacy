use delicacy;
desc commodityEvaluate;

select commodityEvaluate.commodityID,commodityName,userID,describeMark,qualityMark,delivarMark,evaluate,addevaluate,evaluateTime,sourceID
from commodityEvaluate join commodityinfo on commodityEvaluate.commodityID=commodityinfo.commodityID
where commodityEvaluate.commodityID=1;

insert into commodityEvaluate(commodityID,userID,describeMark,qualityMark,delivarMark,evaluate,evaluateTime)
values(1,'1001',4.5,5,5,'没想到吧.jpg',now());

delete from commodityEvaluate where c_evaluateID=1;