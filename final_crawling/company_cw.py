# -*- coding:utf-8 -*-
import requests
from bs4 import BeautifulSoup
from selenium import webdriver
#from selenium.webdriver.firefox.options import Options      # 파이어 폭스용
import mariaDB_company as mariaDB
import time
import re




def getRequest(url):
    return requests.get(url)

def getParser(request):
    return BeautifulSoup(request.content, "html.parser")


def getParserANDdriver(url):
    # 파이어 폭스
    # options = Options()
    # options.add_argument("--headless")
    # path = "C:\chromDriver\geckodriver.exe"    사용할 브라우져 > 파이어폭스 
    # driver = webdriver.Firefox(firefox_options=options, executable_path=path)
    
    # 구글
    options = webdriver.ChromeOptions() 
    options.add_argument('headless')            # 브라우져를 렌더링 하지않고 메모리상에서 작업시킨다. 
    path = "C:\chromDriver\chromedriver.exe"     # 사용할 브라우져 > 크롬 
    driver = webdriver.Chrome(executable_path=path, options=options)
    #driver = webdriver.Chrome(path, options=options)
    #driver = webdriver.Chrome(path)

    driver.get(url)     # 브라우져를 동작 시킨다

    '''
    driver.find_element_by_class_name("ui.facebook.button").click()
    
    elem_login = driver.find_element_by_id("email")
    elem_login.send_keys("01099740068")
    elem_login = driver.find_element_by_id("pass")
    elem_login.send_keys("Final1234@@")

    driver.find_element_by_id('loginbutton').click() 
    '''
    #if driver.find_element_by_id("company-list").is_displayed():
    time.sleep(5)  

    return BeautifulSoup(driver.page_source, "html.parser")         # driver에서 페이지 소스를 얻어온다. 


# 기본정보(basics) : [회사이름, 이미지, 한 줄 소개]
def getBasics_front(parser):
    
    main_div = parser.find("div", {"class" : "ui text container"})
    
    # 이미지
    imgUrl = main_div.find("img", {"class" : "ui image"})["src"]

    # 회사이름
    companyname = main_div.find("div", {"id" : "company-name"})
    companyname = companyname.find("h1").text

    # 한 줄 소개
    oneintro = main_div.find("h3", {"id" : "company-description"}).text

    return {"companyname": companyname, "imgurl": imgUrl, "oneintro": oneintro} 


# 기본정보(basics) : [dict * 진행 중인 채용정보 개수 ]
# 모집대상(a), 주요업무(a-b), 채용상세(a-b), 연봉(a), 경력(a), 언어특기(a), 마감일(a)

def getBasics_center(parser):
    resList = []

    # 진행 중인 채용 정보가 있으면 아래 형식으로 무조건 있음 
    section = parser.find("section", {"id" : "company-jobs"})

    if section == None:   # 디폴트
        return [{
            "business" : "None",
            "mainbusiness" : "None",
            "jobdetail" : "None",
            "salary" : "None",
            "target" : "None",
            "languages" : "None",
            "enddata" : "None"
        }]

    divList = section.findAll("div", {"class" : "ui segment items"}) #ui segment items
    url = "https://www.rocketpunch.com"

    for div in divList:
        resDict={}
        #모집분야(business)
        business = div.find("div", {"class" : "ui job-title header"})
        a = business.find("a")
        business = a.text.strip()

        back_url = a["href"]

        newParser = getParser(getRequest(url + back_url))
        # 주요업무 
        mainbusiness = newParser.find("div", {"class":"duty break"})
        mainbusiness = mainbusiness.find("span")
        if(mainbusiness != None):
            mainbusiness = mainbusiness.text.strip()            


        # 채용상세(jobdetail)
        jobdetail = newParser.find("div", {"class":"content break"})
        jobdetail = jobdetail.find("span")
        if jobdetail != None:
            jobdetail = jobdetail.text.strip()
            
        
        pList = div.find("p", {"class":"nowrap job-stat-info"})
        if(re.search("/", pList.text) == None):   # 문자열에 / 가 없으면 '연봉'없음
            # 연봉(salary)
            salary = "협상후 책정"
            # 경력(target)
            target = pList.text.strip()
        else:
            temp = pList.text.split("/")
            salary = temp[0].strip()    # 연봉
            target = temp[1].strip()    # 경력
        
        #언어특기
        languages = div.find("p", {"class" : "nowrap job-specialties"}).text.strip()
        
        #마감 : 마감일 or 상시채용
        enddate = div.find("div", {"class" : "job-dates"})
        enddate = enddate.find("span").text.strip()

        resDict = {"business": business, "mainbusiness": mainbusiness, "jobdetail": jobdetail, "salary": salary, "target": target, "languages":languages, "enddate": enddate}
        resList.append(resDict)

    return resList


#기업소개(intro)
def getBasics_back(parser):
    intro = parser.find("div", {"id": "company-overview"})
    intro = intro.find("span", {"class":"short-text"})
    
    if intro != None:       # 디폴트
        intro = intro.text
        return {"intro" : intro}
    else:
        return {"intro" : "None"}



# [복지해택] : {"givetool" : value01, "selfgrowth" : valer02 ... "welfareDict": value06}
def getWelfare(parser):
    givetool = "개인 장비"
    selfgrowth = "자기 계발"
    mealtime = "식사, 간식"
    holiday = "연차, 휴가"
    workinghour = "근무 형태"
    insurance = "보험, 의료"
    welfareDict = {
        "givetool" : "None",
        "selfgrowth" : "None",
        "mealtime" : "None",
        "holiday" : "None",
        "workinghour" : "None",
        "insurance" : "None"
    }
    
    #  .keys()로 키만 받아와서 해당 키가 있으면 db에 추가

    container = parser.find("div", {"class" : "ui divided company info items"})
    
    if container == None:  # 디폴트
        return welfareDict

    itemList = container.findAll("div", {"class" : "item"})
    for item in itemList:
        div = item.find("div", {"class" : "title"})
        title = div.find("span").text.strip()
        
        # 개인장비
        if title == givetool:
            givetool = item.find("div", {"class" : "content"}).text
            welfareDict["givetool"] = givetool
        # 자기개발
        elif title == selfgrowth:
            selfgrowth = item.find("div", {"class" : "content"}).text
            welfareDict["selfgrowth"] = selfgrowth
        # 식사시간
        elif title == mealtime:
            mealtime = item.find("div", {"class" : "content"}).text
            welfareDict["mealtime"] = mealtime
        # 연차휴가
        elif title == holiday:
            holiday = item.find("div", {"class" : "content"}).text
            welfareDict["holiday"] = holiday
        # 근무형태
        elif title == workinghour:
            workinghour = item.find("div", {"class" : "content"}).text 
            welfareDict["workinghour"] = workinghour
        # 보험의료
        elif title == insurance:
            insurance = item.find("div", {"class" : "content"}).text
            welfareDict["insurance"] = insurance    
    
    return welfareDict


#[기업정보] = {"incorporation" : value01 , "totalmember": value02, "homepage": 홈페이지, ...}

def getInfor(parser):
    incorporation = "설립일"
    totalmember = "구성원"
    homepage = "홈페이지"
    location = "사무실"
    mainfield = "산업 분야"
   
    inforDict = {
        "incorporation" : "None",
        "totalmember" : "None",
        "homepage" : "None",
        "location" : "None",
        "mainfield" : "None",
    }

    div = parser.find("div", {"class":"ui company info items"})
    if div == None:         
        return inforDict    # 디폴트

    itemList = div.findAll("div", {"class" : "item"})

    for item in itemList: 
        title = item.find("div", {"class" : "title"})
        if title != None:
            title = title.text.strip()
            # 설립일 
            if title == incorporation:
                incorporation = item.find("div", {"class" : "content"}).text.strip() 
                inforDict["incorporation"] = incorporation[:10] 
            # 구성원
            elif title == totalmember:
                totalmember = item.find("div", {"class" : "content"}).text.strip() 
                char = totalmember.find("명")
                inforDict["totalmember"] = totalmember[:char+1]
            # 홈페이지
            elif title == homepage:
                homepage = item.find("div", {"class" : "content"}).text.strip()
                inforDict["homepage"] = homepage
            # 사무실
            elif title == location:
                location = item.find("div", {"class" : "content"}).text.strip()
                inforDict["location"] = location
            # 산업분야
            elif title == mainfield:
                mainfield = item.find("div", {"class" : "content"}).text.strip()
                mainfield = mainfield.replace('\xa0', ' ')
                inforDict["mainfield"] = mainfield

    return inforDict


def DateInsert(res, groupno):
            basicsDict_front = res[0]
            basicsDict_center = res[1]
            basicsDict_back = res[2]
            welfareDict = res[3]
            inforDict = res[4]

            mariaDB.insertOne(
                str(groupno), basicsDict_front["companyname"], basicsDict_front["imgurl"], basicsDict_front["oneintro"],
                basicsDict_center["business"], basicsDict_center["mainbusiness"], basicsDict_center["jobdetail"], basicsDict_center["salary"], basicsDict_center["target"], basicsDict_center["languages"], basicsDict_center["enddate"],
                basicsDict_back["intro"],
                welfareDict["givetool"], welfareDict["selfgrowth"], welfareDict["mealtime"], welfareDict["holiday"], welfareDict["workinghour"], welfareDict["insurance"], 
                inforDict["incorporation"], inforDict["totalmember"], inforDict["homepage"], inforDict["location"], inforDict["mainfield"]
                )
               


def Run():
    page = 1
    newUrl = "https://www.rocketpunch.com"
    
    #url = "https://www.rocketpunch.com/login?next_ul=/jobs"

    while page < 56:    # 55page 까지
        groupno = 1
        url = "https://www.rocketpunch.com/jobs?page=" + str(page)
        # selenium 실행 후 파서 된 페이지 리턴 
        parser = getParserANDdriver(url) 

        divList = parser.findAll("div", {"class":"company item"}) 
        for div in divList:
            div = div.find("div", {"class" : "company-name"})
        
            url_back = div.find("a")["href"]
            par = getParser(getRequest(newUrl + url_back))

            # 회사이름, 이미지url, 한 줄 소개
            basicsDict_front = getBasics_front(par)
            # 진행 중인 채용정보 List
            basicsDict_center = getBasics_center(par)
            # 기업소개
            basicsDict_back = getBasics_back(par)
            # 복지해택
            welfareDict = getWelfare(par)
            # 기업정보
            inforDict = getInfor(par)

            #print(basicsDict_center)

            for i in range(len(basicsDict_center)):
                res = [basicsDict_front, basicsDict_center[i], basicsDict_back, welfareDict, inforDict]
                DateInsert(res, groupno)
                time.sleep(2)
                
            groupno += 1 
            print("======================================[", groupno, "]=======================================")            
        print(page)
        page += 1


'''
 params = (groupno, companyname, imgurl, oneintro, 
              business, mainbusiness, jobdetail, salary, target, languages, enddata, 
              intro,
              givetool, selfgrowth, mealtime, holiday, workinghour, insurance, 
              incorporation, totalmember, homepage, location, mainfield)
'''


if __name__ == '__main__':
    Run()
    
   
    


