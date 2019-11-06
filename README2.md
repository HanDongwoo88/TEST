# ASP.NET Core를 사용하여 Microservices 만들기
---
<br><br>
1Visual Studio IDE를 열고 새 웹 응용 프로그램 프로젝트를 만듭니다. 프로젝트 프레임 워크 템플릿, 즉 C # 언어와의 크로스 플랫폼을 지원하는 DotNet Core 2.x or 3.0로 “ASP.NET Core Web Application”을 선택하십시오.
<br>
![프로젝트추가](https://wiki.jobkorea.co.kr/download/attachments/30528687/image2019-11-4_13-25-3.png?version=1&modificationDate=1572841504353&api=v2)
 <br><br>
2“API”옵션을 선택하고 Advance 섹션에서“Doker Support 활성화”,“HTTPS 구성”을 인증없이 선택하여 각 파일과 Docker 파일을 프로젝트에 생성하십시오. (Restful HTTP 서비스를 작성해야하기 때문에)
<br>
![API서비스추가](https://wiki.jobkorea.co.kr/download/attachments/30528687/image2019-11-4_13-36-47.png?version=1&modificationDate=1572842208360&api=v2)
<br><br> 
3Docker 파일 확인 및 Entity Framework Core 포함
<br>
![EFCORE포함](https://wiki.jobkorea.co.kr/download/attachments/30528687/image2019-11-4_13-30-57.png?version=1&modificationDate=1572841858410&api=v2)
<br><br>
4개발은 아래 섹션으로 나뉩니다.
<br>  
*모델 만들기 
Models 폴더를 만들고 Product와 Cateogry 모델 클래스 추가
<br>
*컨텍스트 클래스 (해당 프로젝트에서는 생략)
<br>
*데이터 베이스 연결 설정 (해당 프로젝트에서는 생략)
<br>
*리포지토리 디자인 패턴 로직 
Repository 폴더를 만들고 IProductRepository 인터페이스를 정의하고 CRUD 기능의 메서드를 선언합니다. IProductRepository를 메서드를 구현하는 ProductRepository 클래스를 작성합니다. 데이터 접근은 해당 메서드에서만 이루어 집니다. startup 클래스에서 해당 리파지토리 클래스의 종속성을 주입 합니다.
<br><br>
*컨트롤러 구현 
Controllers 폴더를 만들고 ProductController 클래스를 작성합니다. 엔드포인트에 맞는 메서드를 작성합니다.
<br><br>
*Docker File, Image 생성 및 컨테이너화 된 서비스 실행
VisualStudio에서 작성한 서비스 오른쪽 클릭 > add > Container Orchestrator Support 메뉴를 통해 Docker Compose를 사용합니다. 관련 파일들이 자동생성 됩니다.
Docker를 통해 서비스를 실행하여 생성된 docker image와 컨테이너를 확인합니다.
<br>
![DOCKERCOMPOSE](https://wiki.jobkorea.co.kr/download/attachments/30528687/image2019-11-6_14-50-18.png?version=1&modificationDate=1573019419337&api=v2)
<br><br><br>
[참고]:https://wiki.jobkorea.co.kr/display/MSA/Microservices+using+ASP.NET+Core
