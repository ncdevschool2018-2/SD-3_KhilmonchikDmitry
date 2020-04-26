select * from billing_account;
select * from backend.productOffering left outer join subscription_unit on productOffering.id=subscription_unit.subscriptionId;
select subscription_unit.userId, count(*) as q from subscription_unit where subscription_unit.status=1 group by subscription_unit.userId;
select * from user_account;