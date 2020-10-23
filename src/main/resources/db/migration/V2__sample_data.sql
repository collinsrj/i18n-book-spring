insert into person(family_name,given_name,phone_number,resource_id, created) values ('Collins', 'Robert', '+353872925806', random_uuid(), now());

insert into job (amount,currency,resource_id, start_date_time,type,customer_id, created) values (100.0, 'EUR', random_uuid(), now(), 1, 1, now());