-- a : 채용중인 정보 페이지에서 가져옴
-- a-b : 채용분야에서 url타고 들어가서 '채용상세' 가져왔음
-- 기본정보 : 시퀀스, 그룹번호, 회사명, 이미지url, 한줄 소개, 모집대상(a), 주요업무(a-b), 채용상세(a-b), 연봉(a), 경력(a), 언어특기(a), 마감일(a), 기업소개글
-- 복지해택 : 개인장비, 자기개발, 식사시간, 연차휴가, 근무형태, 보험의료  
-- 기업정보 : 설립일, 구성원, 홈페이지, 사무실위치, 산업분야

drop sequence companyseq;
drop table company;

create sequence companyseq;

create table company(
	-- 기본정보 : 시퀀스, 그룹번호, 회사명, 이미지url, 한줄 소개, 모집대상(a), 주요업무(a-b), 채용상세(a-b), 연봉(a), 경력(a), 언어특기(a), 마감일(a), 기업소개글
	companyseq int primary key,
	groupno int not null,
	companyname varchar(200) not null,
	imgurl varchar(1000) not null,
	oneintro varchar(2000) not null,
	business varchar(1000) not null,
	mainbusiness varchar(3000) not null,
	jobdetail LONGTEXT not null,
	salary varchar(200) not null, 			
	target varchar(20) not null,
	languages varchar(1000) not null,
	enddate varchar(50) not null,
	intro varchar(3000) not null,
	-- 복지해택 : 개인장비, 자기개발, 식사시간, 연차휴가, 근무형태, 보험의료  
	givetool varchar(1000) not null, 
	selfgrowth varchar(1000) not null,
	mealtime varchar(1000) not null,
	holiday varchar(1000) not null,
	workinghour varchar(1000) not null,
	insurance varchar(1000) not null,
	-- 기업상세정보 : 설립일, 구성원, 홈페이지, 사무실위치, 산업분야
	incorporation varchar(200) not null,
	totalmember varchar(200) not null,
	homepage varchar(50) not null,
	location varchar(500) not null,
	mainfield varchar(1000) not null
);

insert into company values(NEXT VALUE for companyseq02, 0, '회사이름', '이미지 url', '한 줄 회사소개', 
							'모집대상', '주요업무', '채용상세', '연봉', '경력', '언어특기', '마감일(yy/mm/dd)', 
							'기업소개', 
							'개인지급장비', '자기개발 지원', '식시시간', '연차/휴가', '근무형태', '보험의료',
						    '설립일', '구성원(총원)', '홈페이지', '위치', '산업분야'
							);

select * from company order by companyseq desc;

select * from company; 

SELECT COMPANYSEQ,COMPANYNAME,IMGURL,ONEINTRO,BUSINESS
FROM COMPANY02 WHERE BUSINESS LIKE CONCAT('%','백엔드','%')  ORDER BY RAND() LIMIT 4



select
companyseq, groupno, companyname, imgurl, oneintro, 
business, mainbusiness, jobdetail , salary, target, languages, enddate, intro,
givetool, selfgrowth, mealtime, holiday, workinghour, insurance,
incorporation, totalmember, homepage, location, mainfield
FROM company;	


-- 중복된 그룹중 제일 처음것 가져오기
select * from company 
group by GROUPNO ORDER BY COMPANYSEQ desc


-- 그룹번호 별로(회사별로) 내림차순으로  ROWNUM
select R1.* FROM(
SELECT COMPANYSEQ,COMPANYNAME,IMGURL,ONEINTRO,BUSINESS
FROM COMPANY 
group by GROUPNO ORDER BY GROUPNO desc) R1

-- 8개씩 가져오기
select R1.* FROM(
SELECT COMPANYSEQ, GROUPNO, COMPANYNAME,IMGURL,ONEINTRO,BUSINESS
FROM COMPANY 
group by GROUPNO ORDER BY COMPANYSEQ desc) R1
limit 20 OFFSET 0  -- 0 20 40 >>>









--=========================================================================


drop sequence companyseq03;
drop table company03;

create sequence companyseq03;

create table company03(
	-- 기본정보 : 시퀀스, 그룹번호, 회사명, 이미지url, 한줄 소개, 모집대상(a), 주요업무(a-b), 채용상세(a-b), 연봉(a), 경력(a), 언어특기(a), 마감일(a), 기업소개글
	companyseq int primary key,
	groupno int not null,
	companyname varchar(200) not null,
	imgurl varchar(1000) not null,
	oneintro varchar(1000) not null,
	business varchar(1000) not null,
	mainbusiness varchar(3000) not null,
	jobdetail LONGTEXT not null,
	salary varchar(200) not null, 			
	target varchar(20) not null,
	languages varchar(1000) not null,
	enddate varchar(50) not null,
	intro varchar(3000) not null,
	-- 복지해택 : 개인장비, 자기개발, 식사시간, 연차휴가, 근무형태, 보험의료  
	givetool varchar(1000) not null, 
	selfgrowth varchar(1000) not null,
	mealtime varchar(1000) not null,
	holiday varchar(1000) not null,
	workinghour varchar(1000) not null,
	insurance varchar(1000) not null,
	-- 기업상세정보 : 설립일, 구성원, 홈페이지, 사무실위치, 산업분야
	incorporation varchar(200) not null,
	totalmember varchar(200) not null,
	homepage varchar(50) not null,
	location varchar(500) not null,
	mainfield varchar(1000) not null
);

insert into company03 values(NEXT VALUE for companyseq03, 0, '회사이름', '이미지 url', '한 줄 회사소개', 
							'모집대상', '주요업무', '채용상세', '연봉', '경력', '언어특기', '마감일(yy/mm/dd)', 
							'기업소개', 
							'개인지급장비', '자기개발 지원', '식시시간', '연차/휴가', '근무형태', '보험의료',
						    '설립일', '구성원(총원)', '홈페이지', '위치', '산업분야'
							);

select * from company03 order by companyseq desc;

select * from company03; 
