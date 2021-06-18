# Elderly_People_Kiosk_Project

고령층 친화 영화 예매 키오스크

1) 기획 의도
-키오스크를 활용하는 서비스는 인건비 절약, 한결같은 서비스 보장 등을 이유로 점점 늘어나다가 최근에는 코로나로 인한 비대면 서비스 선호를 이유로 더욱 빠르게 증가하는 추세를 보이고 있음
-이런 변화속에서 소외된 계층이 있는데, 대표적으로 고령층(노인 계층)이 키오스크 사용에 어려움을 겪고 있음
-고령층은 키오스크 사용에 어려움을 겪어 구매 포기  사회적 재화로부터 소외되는 결과 발생

 고령층이 사용에 어려움을 겪지 않을 수 있는 키오스크의 화면을 구상해보자! 



2) 포인트
1. 안내 음성 자동 재생 : 무엇을 해야 할지 모르는 사람을 위한 가이드 라인. 기게를 마주하는 것보다 사람의 안내 음성을 듣는 것이 편한 고령층의 친숙함 증대.
2. 영어, 한문 표현을 친숙한 우리말로 : 클릭  선택하기 / 티켓  영화표 // 좌석  자리
3. 화면 상단 ‘이전’ 버튼 배치 : 잘못 선택 시 돌아갈 수 있게
4. 한 화면 노출 정보 최소화, 그림과 글씨는 크게 
5. 버튼 경계 뚜렷하게
6. 도움말 기능 : 따로 키오스크에 대한 교육을 받지 않아도 '튜토리얼'처럼 도움말을 읽고 키오스크 화면을 다룰 수 있게.



3) 클래스 관계
 사용된 클래스 : MovieFirst, Poster, MovieMiddle, SelectSeats, MovieLast, PlayAudio, Main
![image](https://user-images.githubusercontent.com/76686872/122487708-d6691180-d016-11eb-82f5-947c0bf3c9a0.png)
![image](https://user-images.githubusercontent.com/76686872/122487764-f7c9fd80-d016-11eb-83fe-a45b18ae4b6c.png)
각각 back/next로 직전/직후 클래스 참고
MovieMiddle은 Poster 클래스의 static 변수 moviePhoto 참조.
MovieLast는 Poster 클래스의 static 변수 moviePhoto, movieName, movieTime 참조 & SelectSeats 클래스의 static 변수 seatname 참조



4) 기능 설명
![image](https://user-images.githubusercontent.com/76686872/122488186-e9301600-d017-11eb-8868-77a9931f221f.png)
MovieFirst. 왼쪽의 예매하기 버튼은 다음 클래스인 Poster 클래스로 연결. 도움말 버튼은 다음 사진과 연결.
![image](https://user-images.githubusercontent.com/76686872/122488300-25fc0d00-d018-11eb-8549-af479bb2f73d.png)
직관적으로 보이도록 각 순서에 번호 배치, 그림보다 글씨를 크게 함.

![image](https://user-images.githubusercontent.com/76686872/122488207-ef25f700-d017-11eb-8f38-db492063a341.png)
Poster. 글을 안 읽고 포스터만 보고 고를 수 있도록 영화 제목 글씨보다는 포스터 위주로 배치. 원하는 영화를 찾아야 하는 불편함을 덜기 위하여 예매율 높은 순으로 배치.

![image](https://user-images.githubusercontent.com/76686872/122488214-f1885100-d017-11eb-90d4-da29f7522e5a.png)
Poster의 영화를 누르면 뜨는 팝업창. 잦은 화면 전환에 혼란과 피곤함을 느끼는 고령층을 고려하여 팝업 형태로 기존 창이 밑에 남아있게 함. 우측 상단의 X를 누르면 닫히는 직관적 구조. 
왼쪽에 영화 포스터가 떠 자신의 영화 선택을 되돌아볼 수 있음. 시간 선택을 하면 선택한 버튼이 하늘색으로 활성화됨. 인원 선택하기 버튼을 누르면 다음 창으로 넘어감.

![image](https://user-images.githubusercontent.com/76686872/122488218-f3eaab00-d017-11eb-94af-bc7705363a8a.png)
MovieMiddle. 상단에 영화 포스터가 나와 연속된 단계라는 인식을 심어줌. 우대 / 성인 / 청소년에 따라 선택 가능
![image](https://user-images.githubusercontent.com/76686872/122488702-fd284780-d018-11eb-8767-bb95ad870150.png)
'인원을 선택해주세요' 팝업
![image](https://user-images.githubusercontent.com/76686872/122488756-16c98f00-d019-11eb-8054-f58e7840bb8b.png)
도움말 버튼

![image](https://user-images.githubusercontent.com/76686872/122488222-f64d0500-d017-11eb-9f13-5267f965e7f6.png)
SelectSeats
![image](https://user-images.githubusercontent.com/76686872/122488785-2648d800-d019-11eb-84b5-c505fd3847a0.png)
인원수만큼 선택하지 않았을 때
![image](https://user-images.githubusercontent.com/76686872/122488809-32349a00-d019-11eb-9aec-872666c93a95.png)
인원수를 초과해서 선택했을 때

![image](https://user-images.githubusercontent.com/76686872/122488224-f816c880-d017-11eb-9d0d-d2150a6afacb.png)
MovieLast




