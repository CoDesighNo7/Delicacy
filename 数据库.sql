create database delicacy;
use delicacy;

CREATE TABLE employeeinfo(
	employeeID VARCHAR(20) PRIMARY KEY,
    employeeName VARCHAR(50) NOT NULL,
    employeeAge INT NOT NULL,
    employeePhone VARCHAR(11) NOT NULL,
    employeePost VARCHAR(50) NOT NULL,
    employeePosition VARCHAR(50) NOT NULL,
    employeeEntry INT NOT NULL    
);

CREATE TABLE userinfo(
	userID VARCHAR(20) PRIMARY KEY,
    userName VARCHAR(20) NOT NULL,
    userAge INT NOT NULL,
    userPhone VARCHAR(11) NOT NULL,
    userMail VARCHAR(50),
    invitation VARCHAR(10),
    ownInvitation VARCHAR(10) NOT NULL
);

CREATE TABLE useracceptinfo(
	user_acceptID VARCHAR(20) PRIMARY KEY,
    userID VARCHAR(20) NOT NULL,
    acceptName VARCHAR(50) NOT NULL,
    acceptNumber VARCHAR(11) NOT NULL,
    acceptAddress VARCHAR(200) NOT NULL,
    FOREIGN KEY (userID) REFERENCES userinfo(userID) ON DELETE CASCADE
);
drop table useracceptinfo;
alter table useracceptinfo add constraint foreign key (userID) references userinfo(userID) on delete cascade;

CREATE TABLE logininfo(
	id VARCHAR(20) PRIMARY KEY,
    password VARCHAR(20) NOT NULL,
    identity INT NOT NULL,
    FOREIGN KEY (id) REFERENCES employeeinfo(employeeID) ON DELETE CASCADE,
    FOREIGN KEY (id) REFERENCES userinfo(userID) ON DELETE CASCADE
);
alter table logininfo add constraint foreign key (id) references employeeinfo(employeeID) on delete cascade;
alter table logininfo add constraint foreign key (id) references userinfo(userID) on delete cascade;

CREATE TABLE cartinfo(
	cartID VARCHAR(50) PRIMARY KEY,
    userID VARCHAR(20) NOT NULL,
    commodityID VARCHAR(20) NOT NULL,
    commodityCount FLOAT NOT NULL,
    commodityPrice FLOAT NOT NULL,
    FOREIGN KEY (userID) REFERENCES userinfo(userID) ON DELETE CASCADE,
    FOREIGN KEY (commodityID) REFERENCES commodityinfo(commodityID) ON DELETE CASCADE
);
alter table cartinfo add constraint foreign key (userID) references userinfo(userID) on delete cascade;
alter table cartinfo add constraint foreign key (commodityID) references commodityinfo(commodityID) on delete cascade;

CREATE TABLE userOrder(
	u_orderID VARCHAR(20) PRIMARY KEY,
    userID VARCHAR(50) NOT NULL,
    acceptinfoID VARCHAR(20) NOT NULL,
    createTime DATETIME NOT NULL,
    paymentAmont FLOAT NOT NULL,
    deliveryID VARCHAR(50) NOT NULL,
    u_orderState INT NOT NULL,
    paiedAmont FLOAT,
    paiedTime DATETIME,
    FOREIGN KEY (userID) REFERENCES userinfo(userID) ON DELETE CASCADE,
    FOREIGN KEY (acceptinfoID) REFERENCES useracceptinfo(user_acceptID),
    FOREIGN KEY (deliveryID) REFERENCES deliveryForm(deliveryID)
);
alter table userOrder add constraint foreign key (userID) references userinfo(userID) on delete cascade;
alter table userOrder add constraint foreign key (acceptinfoID) references useracceptinfo(user_acceptID);
alter table userOrder add constraint foreign key (deliveryID) references deliveryForm(deliveryID);

CREATE TABLE orderCommodity(
	o_commodityID VARCHAR(20) PRIMARY KEY,
    orderID VARCHAR(20) NOT NULL,
    commodityID VARCHAR(20) NOT NULL,
    commodityCount FLOAT NOT NULL,
    commodityPrice FLOAT NOT NULL,
    commodityAmont FLOAT NOT NULL,
    FOREIGN KEY (orderID) REFERENCES userinfo(userID) ON DELETE CASCADE,
    FOREIGN KEY (commodityID) REFERENCES commodityinfo(commodityID) ON DELETE CASCADE
);
alter table orderCommodity add constraint foreign key (orderID) references userOrder(u_orderID) on delete cascade;
alter table orderCommodity add constraint foreign key (commodityID) references commodityinfo(commodityID) on delete cascade;


CREATE TABLE commodityinfo(
	commodityID VARCHAR(20) PRIMARY KEY,
    commodityName VARCHAR(50) ,
    sourceID VARCHAR(20) NOT NULL,
    pictureURL VARCHAR(100),
    commodityKind VARCHAR(50),
    commodityPrice fLOAT,
    commodityInfo VARCHAR(100)
);

CREATE TABLE commodityEvaluate(
	c_evaluateID VARCHAR(50) PRIMARY KEY,
    commodityID VARCHAR(20) NOT NULL,
    userID VARCHAR(20) NOT NULL,
    describeMark FLOAT NOT NULL,
    qualityMark FLOAT NOT NULL,
    delivarMark FLOAT NOT NULL,
    evaluate VARCHAR(200),
    addevaluate VARCHAR(200),
    evaluateTime DATETIME NOT NULL,
    FOREIGN KEY (commodityID) REFERENCES commodityinfo(commodityID) ON DELETE CASCADE,
    FOREIGN KEY (userID) REFERENCES userinfo(userID) ON DELETE CASCADE
);
alter table commodityEvaluate add constraint foreign key (commodityID) references commodityinfo(commodityID) on delete cascade;
alter table commodityEvaluate add constraint foreign key (userID) references userinfo(userID) on delete cascade;

CREATE TABLE sourceinfo(
	sourceID INT PRIMARY KEY,
    sourceName VARCHAR(100) NOT NULL,
    sourceAddress VARCHAR(100) NOT NULL,
    describeMark FLOAT NOT NULL,
    qualityMark FLOAT NOT NULL
);

CREATE TABLE sourcePicture(
	s_pictureID VARCHAR(20) PRIMARY KEY,
    sourceID INT NOT NULL,
    pictureURL VARCHAR(100) NOT NULL,
    pictureInfo VARCHAR(100) NOT NULL,
    FOREIGN KEY (sourceID) REFERENCES sourceinfo(sourceID) ON DELETE CASCADE
);	
alter table sourcePicture add constraint foreign key (sourceID) references sourceinfo(sourceID) on delete cascade;

CREATE TABLE warehouseSite(
	wh_siteID VARCHAR(20) PRIMARY KEY,
    area VARCHAR(20) NOT NULL,
    shelf VARCHAR(20) NOT NULL,
    storey VARCHAR(20) NOT NULL,
    cell VARCHAR(20) NOT NULL,
    siteState INT NOT NULL
);

CREATE TABLE warehouseInfo(
	warehouseID VARCHAR(20) PRIMARY KEY,
	commodityID VARCHAR(20) NOT NULL,
    siteID VARCHAR(20) NOT NULL,
    inventory FLOAT NOT NULL,
    inTime DATETIME NOT NULL,
    expirationDate varchar(50) NOT NULL,
    dropTime DATETIME NOT NULL,
    FOREIGN KEY (siteID) REFERENCES warehouseSite(wh_siteID) ON DELETE CASCADE ON UPDATE CASCADE
);
alter table warehouseInfo add constraint foreign key (siteID) references warehouseSite(wh_siteID) ON DELETE CASCADE ON UPDATE CASCADE;

CREATE TABLE wareHouseInForm(
	wh_informID VARCHAR(20) PRIMARY KEY,
    intime DATETIME NOT NULL,
    adminID VARCHAR(20) NOT NULL,
    FOREIGN KEY (adminID) REFERENCES employeeinfo(employeeID)
);
alter table wareHouseInForm add constraint foreign key (adminID) references employeeinfo(employeeID);

CREATE TABLE wareHouseIn(
	wh_inID VARCHAR(20) PRIMARY KEY,
    informID VARCHAR(20) NOT NULL,
    commodityID VARCHAR(50) NOT NULL,
    commodityKind VARCHAR(50) NOT NULL,
    commodityCount FLOAT NOT NULL,
    siteID VARCHAR(100) NOT NULL,
    FOREIGN KEY (informID) REFERENCES wareHouseInForm(wh_informID) ON UPDATE CASCADE,
    FOREIGN KEY (siteID) REFERENCES warehouseSite(wh_siteID)
);
alter table wareHouseIn add constraint foreign key (informID) references wareHouseInForm(wh_informID) ON UPDATE CASCADE;
alter table wareHouseIn add constraint foreign key (siteID) references warehouseSite(wh_siteID);

CREATE TABLE wareHouseOut(
	wh_outID VARCHAR(50) PRIMARY KEY,
    outformID VARCHAR(20) NOT NULL,
    commodityID VARCHAR(50) NOT NULL,
    commodityCount float NOT NULL,
    siteID VARCHAR(20),
    FOREIGN KEY (outformID) REFERENCES wareHouseOutForm(wh_outformID),
    FOREIGN KEY (siteID) REFERENCES warehouseSite(wh_siteID)
);
alter table wareHouseOut add constraint foreign key (outformID) references wareHouseOutForm(wh_outformID);
alter table wareHouseOut add constraint foreign key (siteID) references warehouseSite(wh_siteID);

CREATE TABLE wareHouseOutForm(
	wh_outformID VARCHAR(20) PRIMARY KEY,
    outtime DATETIME NOT NULL,
    adminID VARCHAR(20) NOT NULL,
    outreason INT NOT NULL,
    FOREIGN KEY (adminID) REFERENCES employeeinfo(employeeID) 
);
alter table wareHouseOutForm add constraint foreign key (adminID) references employeeinfo(employeeID);

CREATE TABLE deliveryForm(
	deliveryID VARCHAR(50) PRIMARY KEY,
    sendoutTime	DATETIME NOT NULL,
    commodities VARCHAR(200) NOT NULL,
    weight FLOAT NOT NULL,
    deliverMan VARCHAR(50) NOT NULL,
    phoneNumber VARCHAR(11) NOT NULL,
    acceptinfoID VARCHAR(20) NOT NULL,
    acceptTime DATETIME,
    cost FLOAT NOT NULL,
    FOREIGN KEY (acceptinfoID) REFERENCES useracceptinfo(user_acceptID)
);
alter table deliveryForm add constraint foreign key (acceptinfoID) references useracceptinfo(user_acceptID);