# mobile-programming 개인 과제
소프트웨어학부 20213100 홍승현

## 개발 환경

* IDE : Android Studio Dolphin | 2021.3.1 Patch 1
* SDK : Android SDK Platform 33 ( API Level : 33 )
* AVD : Pixel 2 API 30
* OS : Windows


## 화면 구성

#### 첫 번째 화면 ( 앱 접속 페이지 )

로그인 페이지이자 앱 접속 페이지

path : `app/src/main/java/com/example/myapplication/ShopActivity`

![image](https://user-images.githubusercontent.com/81635179/199176862-4160ff0f-9bef-44a6-a5c5-6456de366e51.png)

* 아이디 입력창 : EditText
* 비밀번호 입력창 : EditText
* 로그인 버튼 : AppCompatButton
  클릭 시 로그인 유효성 검사
  유효하면 상품 페이지로 이동
* 회원가입 버튼 : AppCompatButton
  클릭 시 회원가입 페이지로 이동
* 비회원으로 시작하기 : AppCompatButton
  클릭 시 상품 페이지로 
