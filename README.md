# mobile-programming 개인 과제
소프트웨어학부 20213100 홍승현

## 개발 환경

* IDE : Android Studio Dolphin | 2021.3.1 Patch 1
* SDK : Android SDK Platform 33 ( API Level : 33 )
* AVD : Pixel 2 API 30
* OS : Windows
* Language : Java


## 화면 구성

### 첫 번째 화면 ( 앱 접속 페이지 )

로그인 페이지이자 앱 접속 페이지

path : `app/src/main/java/com/example/myapplication/ShopActivity`

![image](https://user-images.githubusercontent.com/81635179/199176862-4160ff0f-9bef-44a6-a5c5-6456de366e51.png)

* 아이디 입력창 : EditText
* 비밀번호 입력창 : EditText
* 로그인 버튼 : AppCompatButton
  <br>클릭 시 로그인 유효성 검사
  
* 저장되지 않은 회원일 경우 toast 메시지 출력

![image](https://user-images.githubusercontent.com/81635179/199209474-1a5c4838-75ce-446a-806e-47ef3b963fb9.png)

* 유효하면 상품 페이지로 이동

![image](https://user-images.githubusercontent.com/81635179/199211132-3be509e3-1440-49a7-8517-4ea126420e34.png)

* 회원가입 버튼 : AppCompatButton
  <br>클릭 시 회원가입 페이지로 이동
* 비회원으로 시작하기 : AppCompatButton
  <br>클릭 시 상품 페이지로 이동




### 두 번째 화면 ( 회원가입 페이지 )

회원가입 페이지 가입 시 회원 정보 저장

path : `app/src/main/java/com/example/myapplication/SignUpActivity`

![image](https://user-images.githubusercontent.com/81635179/199180605-8f77a6c3-179e-4b2a-a272-5cb288dd538f.png)

* 이름 입력창 : EditText
* 전화번호 입력창 : EditText
* 주소 입력창 : EditText
* 아이디 입력창 : EditText
* 비밀번호 입력창 : EditText
* 개인정보 수집 및 이용 동의 : RadioGroup, RadioButton
* 완료 버튼 : AppCompatButton
  <br>모든 입력이 유효하면 완료버튼 활성화
  <br>클릭 시 로그인 페이지로 이동
  
* 모든 값을 입력하지 않거나, 개인정보 수집에 동의하지 않으면 toast 메시지 출력
![image](https://user-images.githubusercontent.com/81635179/199209960-21501751-6a47-4b47-ace5-f169ca4452f4.png)

* 모든 값 입력 후, 개인정보 수집에 동의하면 완료 버튼 활성화
![image](https://user-images.githubusercontent.com/81635179/199210901-afca3650-3627-4d2a-ae27-7d35de982845.png)

### 세 번째 화면 ( 상품 페이지 )

path : `app/src/main/java/com/example/myapplication/ShopActivity`

![image](https://user-images.githubusercontent.com/81635179/199181428-54814ede-4c96-4367-843a-f26b7d227ac6.png)

* 각각의 상품 : LinearLayout, ImageView, TextView
* 회원 정보 버튼 : AppCompatButton
  <br>클릭 시 회원이라면 회원 정보를 AlertDialog를 띄움
  
![image](https://user-images.githubusercontent.com/81635179/199211653-fd3de5a5-ab93-4ed5-9ab2-613479ce6649.png)

  <br>비회원이라면 회원가입 하겠냐는 메시지를 띄우고 "예"를 누르면 회원가입 페이지로 이동
  <br>"아니오"를 누르면 AlertDialog 창을 닫음
  
![image](https://user-images.githubusercontent.com/81635179/199212229-efdc8ec2-f036-4e37-a9ef-e81376c61e58.png)
  
* 상품 등록 버튼 : AppCompatButton

## 기능

### 회원 관리

* 회원가입시 각각의 회원을 고유한 번호와 함께 preference를 사용하여 저장
* 로그인 시 ShopActivity로 사용자의 고유한 userId를 intent시 putExtra로 함께 전달

```
Intent intent = new Intent(MainActivity.this, ShopActivity.class);
intent.putExtra("userId", userId);
startActivity(intent);
```

* ShopActivity에서 userId을 바탕으로 유저 정보를 불러옴
( 비회원으로 시작했다면 userId에 -1을 저장하고 따로 분기하여 처리)
