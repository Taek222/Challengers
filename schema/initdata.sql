--========================================================================================================================================
--공통코드 TB_COMN_CD
INSERT INTO devchallegers.tb_comn_cd(COM_GRP_CD, COM_CD, CD_NM, CD_DESC, DEFAULT_YN, SORT, DEL_YN, CRE_DT, REG_USER, MOD_DT, MOD_USER)
VALUES('NOTIFICATIONTYPE', 'ZZ', '알림 타입', '알림 타입', 'N', 0, 'N', CURRENT_TIMESTAMP, 'Admin', CURRENT_TIMESTAMP, 'Admin');
INSERT INTO devchallegers.tb_comn_cd(COM_GRP_CD, COM_CD, CD_NM, CD_DESC, DEFAULT_YN, SORT, DEL_YN, CRE_DT, REG_USER, MOD_DT, MOD_USER)
VALUES('NOTIFICATIONTYPE', 'CHALLENGE', '챌린지', '챌린지', 'N', 1, 'N', CURRENT_TIMESTAMP, 'Admin', CURRENT_TIMESTAMP, 'Admin');
INSERT INTO devchallegers.tb_comn_cd(COM_GRP_CD, COM_CD, CD_NM, CD_DESC, DEFAULT_YN, SORT, DEL_YN, CRE_DT, REG_USER, MOD_DT, MOD_USER)
VALUES('NOTIFICATIONTYPE', 'SNS', 'SNS', 'SNS', 'N', 2, 'N', CURRENT_TIMESTAMP, 'Admin', CURRENT_TIMESTAMP, 'Admin');
INSERT INTO devchallegers.tb_comn_cd(COM_GRP_CD, COM_CD, CD_NM, CD_DESC, DEFAULT_YN, SORT, DEL_YN, CRE_DT, REG_USER, MOD_DT, MOD_USER)
VALUES('NOTIFICATIONTYPE', 'TODO', 'TO-DO', 'TO-DO', 'N', 3, 'N', CURRENT_TIMESTAMP, 'Admin', CURRENT_TIMESTAMP, 'Admin');
INSERT INTO devchallegers.tb_comn_cd(COM_GRP_CD, COM_CD, CD_NM, CD_DESC, DEFAULT_YN, SORT, DEL_YN, CRE_DT, REG_USER, MOD_DT, MOD_USER)
VALUES('NOTIFICATIONTYPE', 'FRIEND', '친구 관리', '친구 관리', 'N', 4, 'N', CURRENT_TIMESTAMP, 'Admin', CURRENT_TIMESTAMP, 'Admin');

--게시글 공개 구분(전체, 친구, 비공개, 임시저장)
INSERT INTO `devchallegers`.`TB_COMN_CD` (`COM_GRP_CD`, `COM_CD`, `CD_NM`, `CD_DESC`, `DEFAULT_YN`, `SORT`, `DEL_YN`, `CRE_DT`, `REG_USER`, `MOD_DT`, `MOD_USER`) VALUES ('OPENTYPE', '1', '전체 공개', '전체 공개', 'Y', '1', 'N', CURRENT_TIMESTAMP, 'Admin', CURRENT_TIMESTAMP, 'Admin');
INSERT INTO `devchallegers`.`TB_COMN_CD` (`COM_GRP_CD`, `COM_CD`, `CD_NM`, `CD_DESC`, `DEFAULT_YN`, `SORT`, `DEL_YN`, `CRE_DT`, `REG_USER`, `MOD_DT`, `MOD_USER`) VALUES ('OPENTYPE', '2', '친구 공개', '친구 공개', 'N', '2', 'N', CURRENT_TIMESTAMP, 'Admin', CURRENT_TIMESTAMP, 'Admin');
INSERT INTO `devchallegers`.`TB_COMN_CD` (`COM_GRP_CD`, `COM_CD`, `CD_NM`, `CD_DESC`, `DEFAULT_YN`, `SORT`, `DEL_YN`, `CRE_DT`, `REG_USER`, `MOD_DT`, `MOD_USER`) VALUES ('OPENTYPE', '3', '비공개', '비공개', 'N', '3', 'N', CURRENT_TIMESTAMP, 'Admin', CURRENT_TIMESTAMP, 'Admin');
INSERT INTO `devchallegers`.`TB_COMN_CD` (`COM_GRP_CD`, `COM_CD`, `CD_NM`, `CD_DESC`, `DEFAULT_YN`, `SORT`, `DEL_YN`, `CRE_DT`, `REG_USER`, `MOD_DT`, `MOD_USER`) VALUES ('OPENTYPE', '4', '임시저장', '임시저장', 'N', '4', 'N', CURRENT_TIMESTAMP, 'Admin', CURRENT_TIMESTAMP, 'Admin');

--친구 요청 상태(요청, 친구, 차단)
INSERT INTO `devchallegers`.`TB_COMN_CD` (`COM_GRP_CD`, `COM_CD`, `CD_NM`, `CD_DESC`, `DEFAULT_YN`, `SORT`, `DEL_YN`, `CRE_DT`, `REG_USER`, `MOD_DT`, `MOD_USER`) VALUES ('RELATIONTYPE', 'REQ', '요청', '요청', 'N', '1', 'N', CURRENT_TIMESTAMP, 'Admin', CURRENT_TIMESTAMP, 'Admin');
INSERT INTO `devchallegers`.`TB_COMN_CD` (`COM_GRP_CD`, `COM_CD`, `CD_NM`, `CD_DESC`, `DEFAULT_YN`, `SORT`, `DEL_YN`, `CRE_DT`, `REG_USER`, `MOD_DT`, `MOD_USER`) VALUES ('RELATIONTYPE', 'FLW', '친구', '친구', 'N', '2', 'N', CURRENT_TIMESTAMP, 'Admin', CURRENT_TIMESTAMP, 'Admin');
INSERT INTO `devchallegers`.`TB_COMN_CD` (`COM_GRP_CD`, `COM_CD`, `CD_NM`, `CD_DESC`, `DEFAULT_YN`, `SORT`, `DEL_YN`, `CRE_DT`, `REG_USER`, `MOD_DT`, `MOD_USER`) VALUES ('RELATIONTYPE', 'BLK', '차단', '차단', 'N', '3', 'N', CURRENT_TIMESTAMP, 'Admin', CURRENT_TIMESTAMP, 'Admin');

--카테고리
INSERT INTO devchallegers.tb_comn_cd(COM_GRP_CD, COM_CD, CD_NM, CD_DESC, DEFAULT_YN, SORT, DEL_YN, CRE_DT, REG_USER, MOD_DT, MOD_USER)
VALUES('CATEGORY', 'WORKOUT', '운동', '운동', 'N', 1, 'N', CURRENT_TIMESTAMP, 'Admin', CURRENT_TIMESTAMP, 'Admin');
INSERT INTO devchallegers.tb_comn_cd(COM_GRP_CD, COM_CD, CD_NM, CD_DESC, DEFAULT_YN, SORT, DEL_YN, CRE_DT, REG_USER, MOD_DT, MOD_USER)
VALUES('CATEGORY', 'LIFE', '규칙적인 생활', '규칙적인 생활', 'N', 2, 'N', CURRENT_TIMESTAMP, 'Admin', CURRENT_TIMESTAMP, 'Admin');
INSERT INTO devchallegers.tb_comn_cd(COM_GRP_CD, COM_CD, CD_NM, CD_DESC, DEFAULT_YN, SORT, DEL_YN, CRE_DT, REG_USER, MOD_DT, MOD_USER)
VALUES('CATEGORY', 'HABITS', '습관', '습관', 'N', 3, 'N', CURRENT_TIMESTAMP, 'Admin', CURRENT_TIMESTAMP, 'Admin');
INSERT INTO devchallegers.tb_comn_cd(COM_GRP_CD, COM_CD, CD_NM, CD_DESC, DEFAULT_YN, SORT, DEL_YN, CRE_DT, REG_USER, MOD_DT, MOD_USER)
VALUES('CATEGORY', 'DIET', '식단', '식단', 'N', 4, 'N', CURRENT_TIMESTAMP, 'Admin', CURRENT_TIMESTAMP, 'Admin');
INSERT INTO devchallegers.tb_comn_cd(COM_GRP_CD, COM_CD, CD_NM, CD_DESC, DEFAULT_YN, SORT, DEL_YN, CRE_DT, REG_USER, MOD_DT, MOD_USER)
VALUES('CATEGORY', 'MENTAL', '마음관리', '마음관리', 'N', 5, 'N', CURRENT_TIMESTAMP, 'Admin', CURRENT_TIMESTAMP, 'Admin');
INSERT INTO devchallegers.tb_comn_cd(COM_GRP_CD, COM_CD, CD_NM, CD_DESC, DEFAULT_YN, SORT, DEL_YN, CRE_DT, REG_USER, MOD_DT, MOD_USER)
VALUES('CATEGORY', 'HOBBY', '취미', '취미', 'N', 6, 'N', CURRENT_TIMESTAMP, 'Admin', CURRENT_TIMESTAMP, 'Admin');
INSERT INTO devchallegers.tb_comn_cd(COM_GRP_CD, COM_CD, CD_NM, CD_DESC, DEFAULT_YN, SORT, DEL_YN, CRE_DT, REG_USER, MOD_DT, MOD_USER)
VALUES('CATEGORY', 'ECO', '친환경', '친환경', 'N', 7, 'N', CURRENT_TIMESTAMP, 'Admin', CURRENT_TIMESTAMP, 'Admin');





--========================================================================================================================================
--사용자 TB_USER_MGMT
INSERT INTO `devchallegers`.`TB_USER_MGMT` (`USER_ID`, `DOMAIN`, `USER_NM`, `PASSWORD`, `LEVEL_OPEN`, `CELL`, `DEL_YN`, `REG_USER`, `MOD_USER`) VALUES ('PSJ', 'naver.com', '박수진', 'psj', 'Y', '010-0000-0000', 'N', 'Admin', 'Admin');
INSERT INTO `devchallegers`.`TB_USER_MGMT` (`USER_ID`, `DOMAIN`, `USER_NM`, `PASSWORD`, `LEVEL_OPEN`, `CELL`, `DEL_YN`, `REG_USER`, `MOD_USER`) VALUES ('NHB', 'gmail.com', '나하빈', 'nhb', 'Y', '010-0000-0000', 'N', 'Admin', 'Admin');
INSERT INTO `devchallegers`.`TB_USER_MGMT` (`USER_ID`, `DOMAIN`, `USER_NM`, `PASSWORD`, `LEVEL_OPEN`, `CELL`, `DEL_YN`, `REG_USER`, `MOD_USER`) VALUES ('YSY', 'gmail.com', '양소연', 'ysy', 'Y', '010-0000-0000', 'N', 'Admin', 'Admin');
