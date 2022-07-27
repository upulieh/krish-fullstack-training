--data.sql should be renamed into data.txt the second time its run (to stop Spring Boot from trying to run them again) (cuz the primary key is unique) 

--inserting a client record (client is a mobile, password is "pin" encrypted using the bycrypt algorithm (which can be found online))
INSERT INTO oauth_client_details (client_id, client_secret, web_server_redirect_uri, scope, access_token_validity, refresh_token_validity, resource_ids, authorized_grant_types, additional_information) 
VALUES ('mobile', '{bcrypt}$2a$10$gPhlXZfms0EpNHX0.HHptOhoFD1AoxSr/yUIdTqA8vtjeP4zi0DDu', 'http://localhost:8080/login', 'READ,WRITE', '3600', '10000', 'inventory,payment', 'authorization_code,password,refresh_token,implicit', '{}');

INSERT INTO permission (NAME) VALUES
 ('create_profile'), --1
 ('read_profile'), --2
 ('update_profile'), --3
 ('delete_profile'); --4

--the _ is used in Spring 
INSERT INTO role (name) VALUES
		('ROLE_admin'), --1
		('ROLE_editor'), --2
		('ROLE_operator'); --3

--mapping permission to role
INSERT INTO permission_role (permission_id, role_id) VALUES
     (1,1), /*create admin */
     (2,1), /* read admin */
     (3,1), /* update admin */
     (4,1), /* delete admin */
     (2,2),  /* read editor */
     (3,2), /* update editor */
     (2,3); /* read operator */

--3 users
-- krish - pkrish
-- suranga - psuranga
-- nuwan - pnuwan
insert into user (id, username,password, email, enabled, accountNonExpired, credentialsNonExpired, accountNonLocked) VALUES ('1', 'krish','{bcrypt}$2a$10$98LMSuUIHjKtapZlntuanOKXpAz3rTWQNfaN/NX2Np4A1ajOHJda.', 'k@krishantha.com', '1', '1', '1', '1');
insert into user (id, username,password, email, enabled, accountNonExpired, credentialsNonExpired, accountNonLocked) VALUES ('2', 'suranga', '{bcrypt}$2a$10$Q5cTxZWLhFo5lrxA9P7M9eUO3o0zD/JKQxi8qEaZ.IFO/YgjYCZeS','s@suranga.com', '1', '1', '1', '1');
insert into user (id, username,password, email, enabled, accountNonExpired, credentialsNonExpired, accountNonLocked) VALUES ('3', 'nuwan', '{bcrypt}$2a$10$RtXHlGF70crl/NQzu4aoBe8tGrmIi9pgwzZZc1BABd3kxsxrfsHHG','n@nuwan.com', '1', '1', '1', '1');


INSERT INTO role_user (role_id, user_id)
    VALUES
    (1,1), /* krish-admin */
    (2,2), /* suranga-operator */ 
    (3,3); /* nuwan-operator*/