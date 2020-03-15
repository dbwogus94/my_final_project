import pymysql

# coverletter테이블

# Connect to MySQL
# 1) pymysql.connect()를 사용해 mariaDB에 connect 한다. == Connection객체 생성
def getConnection():
    conn = pymysql.connect(            
        host='localhost',
        # port=3306, 
        user='root',
        password='admin1234',
        db="nlpdb",
        charset='utf8'
    )
    return conn


# 쿼리 실행 함수(추가, 수정, 삭제)
def db_query(sql, params): 
    print("1) connection 객체 생성")
    conn = getConnection()   # connection 객체 생성
    
    try:
        # create Dictionary Cursor
        # 2) Connection 객체로 부터 cursor()메서드를 호출한다. (cursor 객체가 CRUD에 필요한 함수를 가지고 있음)
        print("2) cursor 생성")
        with conn.cursor() as cursor:           # close() 해준다.
            sql_query = sql                     # sql문 가져오기  
            # excute SQL
            print("쿼리 전달 및 리턴");
            cursor.execute(sql_query, params)   # sql문의 파라미터(값) 가져오기 >>> 쿼리 날린다.
        # commit data
        conn.commit()                           # 저장(성공 실패 유무 처리?)
    except:
        print("[Error] 추가, 수정, 삭제 중에 에러!")
        conn.rollback();


# db생성
def create_db():                                
    # CREATE school DB
    sql = 'CREATE DATABASE school'
    db_query(db=None, sql=sql, params=None)

# seq 생성
def create_seq():
    sql = "create sequence coverletterseq;"
    db_query(sql=sql, params=None)

# table 생성
def create_table():
    # CREATE student table
    sql = '''
        create table coverletter(
            seqno INT primary key,  			# number == int 시퀀스
            groupno INT not null,				# 그룹번호
            company varchar(1000) not null, 	# 회사
            period varchar(1000) not null,		# 분류
            spec varchar(1000)	not null,		# 스팩
            question varchar(2000) not null,	# 질문 	
            context varchar(4000) not null 		# 답
        );
    '''
    db_query(sql=sql, params=None)

'''
-- a : 채용중인 정보 페이지에서 가져옴
-- a-b : 채용분야에서 url타고 들어가서 '채용상세' 가져왔음
-- 기본정보 (not null): 시퀀스, 그룹번호, 회사명, 이미지url, 한줄 소개, 모집대상(a), 채용상세(a-b), 연봉(a), 경력(a), 언어특기(a), 마감일(a), 기업소개글
-- 복지해택(all null) : 개인장비, 자기개발, 식사시간, 연차휴가, 근무형태, 보험의료  
-- 기업정보 (all null): 설립일, 구성원, 홈페이지, 사무실위치, 산업분야
'''
# 추가
def insertOne(groupno, companyname, imgurl, oneintro, 
              business, mainbusiness, jobdetail, salary, target, languages, enddate, 
              intro,
              givetool, selfgrowth, mealtime, holiday, workinghour, insurance, 
              incorporation, totalmember, homepage, location, mainfield):    
    sql = 'INSERT INTO company VALUES (NEXT VALUE for companyseq, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s)'  # sql / seqno 스트링으로 전달 해야함
    params = (groupno, companyname, imgurl, oneintro, 
              business, mainbusiness, jobdetail, salary, target, languages, enddate, 
              intro,
              givetool, selfgrowth, mealtime, holiday, workinghour, insurance, 
              incorporation, totalmember, homepage, location, mainfield)          # 파라미터        
    print("insert 쿼리 전달")
    db_query(sql=sql, params=params)        # db값 전달 > 쿼리실행 > commit


# 번호로 하나 선택 
def selectOne(seqno):
    
    conn = getConnection()   # connection 객체생성 

    sql = 'SELECT * FROM company WHERE seqno = %s'
    params = (seqno,)         # 뒤에, 를 하는 이유는?

    try:
        with conn.cursor() as cursor:       # connection객체의 쿼리실행 객체 cursor을 생성
            cursor.execute(sql, params)     # 쿼리전달 
            result = cursor.fetchone()      # .fetchone() 함수로 결과 하나 받아오기
            #print(result)
    except:
        print("[Error] selectOne 에러!")
  
    return result


    # 전체 선택 
def selectAll():
    
    conn = getConnection()   # connection 객체생성 

    sql = 'SELECT * FROM coverletter'
    params = ()         # 뒤에, 를 하는 이유는?

    try:
        with conn.cursor() as cursor:       # connection객체의 쿼리실행 객체 cursor을 생성
            cursor.execute(sql, params)     # 쿼리전달 
            result = cursor.fetchall()      # .fetchone() 함수로 결과 하나 받아오기
            #print(result)
    except:
        print("[Error] selectOne 에러!")
    
    return result

# 그룹번호 출력 
def selectGroupList(groupno):
    conn = getConnection()   # connection 객체생성 

    sql = 'SELECT * FROM coverletter WHERE groupno = %s'
    params = (groupno,)         # 뒤에, 를 하는 이유는?

    try:
        with conn.cursor() as cursor:       # connection객체의 쿼리실행 객체 cursor을 생성
            cursor.execute(sql, params)     # 쿼리전달 
            result = cursor.fetchall()      # .fetchone() 함수로 결과 하나 받아오기
            #print(result)
    except:
        print("[Error] selectOne 에러!")

    return result



# 업데이트
def updateOne():
    sql = 'UPDATE coverletter SET  = %s WHERE seqno = %s'
    params = ()
    db_query(sql=sql, params=params)

# 삭제
def deleteOne(seqno):
    sql = 'DELETE FROM coverletter WHERE seqno = %d'
    params = (seqno,)
    db_query(sql=sql, params=params)


# 드랍 시퀀스

# 드랍 테이블 

