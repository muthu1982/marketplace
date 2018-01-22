insert into project(id,budget,code,Description,Last_date,name,status) values(1,1000,'P1','Project1',sysdate,'Project1','OPEN');
insert into project(id,budget,code,Description,Last_date,name,status) values(2,1000,'P2','Project2',sysdate+2,'Project2','OPEN');
insert into project(id,budget,code,Description,Last_date,name,status) values(3,1000,'P3','Project3',sysdate+3,'Project3','OPEN');
insert into project(id,budget,code,Description,Last_date,name,status) values(4,1000,'P4','Project4',sysdate,'Project4','OPEN');
insert into project(id,budget,code,Description,Last_date,name,status) values(5,1000,'P5','Project5',sysdate+2,'Project5','OPEN');
commit;

insert into user(id,email_id,name) values(1,'john@gmail.com','John');
insert into user(id,email_id,name) values(2,'Jane@gmail.com','Jane');
insert into user(id,email_id,name) values(3,'David@gmail.com','David');
commit;

insert into bid(id,bid_amount,bid_date,project_id,user_id) values (2,'1000',sysdate,'1','2');
insert into bid(id,bid_amount,bid_date,project_id,user_id) values (1,'100',sysdate,'1','1');
insert into bid(id,bid_amount,bid_date,project_id,user_id) values (3,'400',sysdate,'1','3');

insert into bid(id,bid_amount,bid_date,project_id,user_id) values (4,'900',sysdate,'2','1');
insert into bid(id,bid_amount,bid_date,project_id,user_id) values (5,'100',sysdate,'2','2');
insert into bid(id,bid_amount,bid_date,project_id,user_id) values (6,'200',sysdate,'2','3');

insert into bid(id,bid_amount,bid_date,project_id,user_id) values (8,'100',sysdate,'3','2');
insert into bid(id,bid_amount,bid_date,project_id,user_id) values (7,'400',sysdate,'3','1');

insert into bid(id,bid_amount,bid_date,project_id,user_id) values (9,'100',sysdate,'4','1');
insert into bid(id,bid_amount,bid_date,project_id,user_id) values (10,'500',sysdate,'4','2');

commit;
