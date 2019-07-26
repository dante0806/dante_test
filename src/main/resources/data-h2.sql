insert into user (id, user_id, user_pw, user_nm, use_yn, user_zip, user_addr, user_phone) 
		  values ('1', 'dante0806', '$2a$10$CjAMTVdW6Op9ePKvNUA9.eCoXk6ZWkv/fpwBp57Xmon4sGeyPWx3u', '김시은', ' Y'
		  			  '703064', '구로구오류동 217-38', '01095892875' );
insert into user_role (user_id, role_id) values ('1','2');
insert into user_role (user_id, role_id) values ('1','1');
insert into role (id, name) values ('1','ADMIN');
insert into role (id, name) values ('2','USER');