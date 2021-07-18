<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page session="false"%>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<html>
<head>
<meta charset="utf-8" />
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no" />
<meta name="description" content="" />
<meta name="author" content="" />
<title>한동대학교 총동아리연합회</title>
<!-- Favicon-->
<link rel="icon" type="image/x-icon"
	href="./resources/assets/img/favicon.ico" />
<!-- Bootstrap Icons-->
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.5.0/font/bootstrap-icons.css"
	rel="stylesheet" />
<!-- Google fonts-->
<link
	href="https://fonts.googleapis.com/css?family=Merriweather+Sans:400,700"
	rel="stylesheet" />
<link
	href="https://fonts.googleapis.com/css?family=Merriweather:400,300,300italic,400italic,700,700italic"
	rel="stylesheet" type="text/css" />
<!-- SimpleLightbox plugin CSS-->
<link
	href="https://cdnjs.cloudflare.com/ajax/libs/SimpleLightbox/2.1.0/simpleLightbox.min.css"
	rel="stylesheet" />
<link href="https://cdn.jsdelivr.net/npm/@fortawesome/fontawesome-free@5.15.3/css/fontawesome.min.css" rel="stylesheet">
<!-- Core theme CSS (includes Bootstrap)-->
<link href="./resources/css/styles.css" rel="stylesheet" />
<link href="./resources/css/home.css" rel="stylesheet" />
<link href="./resources/css/reservation.css" rel="stylesheet" />
<link href="./resources/css/calendar.css" rel="stylesheet"/>

<!-- calendar를 위한 라이브러리 -->
<link href="./resources/css/fullcalendar.css" rel="stylesheet"/>
<script src="./resources/js/fullcalendar.js"></script>
<script src="./resources/js/daygrid.js"></script>

</head>
<jsp:include page="/WEB-INF/views/inc/header.jsp"/>
<script src="https://kit.fontawesome.com/6333a60c65.js"
	crossorigin="anonymous"></script>

<body id="page-top">
	<!-- Masthead-->
        <div class="R_container h-100">
      		<div class="side_bar">	
       			<div class="reservation" style="background-color:gray"><a href="./reservation">
                	<div>
                		<i class="fa fa-home fa-3x white" aria-hidden="true"></i><br><div class="side_text">조회 및 예약하기</div>
                	</div></a>
               </div>   
	           <div class="reservation" style="background-color:gray"><a href="./myReservation">
	           	<div>
	           	<i class="fa fa-user fa-3x" aria-hidden="true"></i><br><div class="side_text">내 예약</div>
	           	</div></a>
	           </div>
	            
            </div>
           
        	<div class="content">
        	<div>
        		<table class="table" style="text-align:left;">
				  <tbody>
				    <tr>
				      <th scope="row">장소</th>
				      <td>CCR - 대형</td>
				    </tr>
				    <tr>
				      <th scope="row">이름</th>
				      <td>홍길동</td>
				    </tr>
				    <tr>
				      <th scope="row">이메일</th>
				      <td>12345678@handong.edu</td>
				    </tr>
				    <tr>
				      <th scope="row">예약 가능한 시간</th>
				      <td>2021-07-19 ~ 2021-07-25</td>
				    </tr>
				    <tr>
				      <th scope="row">날짜 *</th>
				      <td><input class="input-resize" id="date" type="date" name="date"
						value=2021-07-19						min=2021-07-19						max=2021-07-25						></td>
				    </tr>
				    <tr>
				      <th scope="row">시작 시간</th>
				      <td><select id='startTimeSelect' class="input-resize">
						</select></td>
				    </tr>
				    <tr>
				      <th scope="row">종료 시간</th>
				      <td><select id='endTimeSelect' class="input-resize">
						</select>
					  </td>
				    </tr>
				    <tr>
				      <th scope="row">목적 *</th>
				      <td>
						<input type="text" class="input-resize" name="purpose"></input>
					  </td>
				    </tr>
				    <tr>
				      <th scope="row">추가사항</th>
				      <td>
						<textarea id="memo" name="memo" style="height: 90%; width: 99%" placeholder="예상 인원, 구체적인 활동 내용 등"></textarea>
					  </td>
				    </tr>
				  </tbody>
				</table>
				<br>
				</div>
				<form onsubmit="saveReservation();">
				<div>
			<h3><font size="4">개인정보 수집·이용·제공 동의</font></h3>
			<textarea readonly="readonly" style="width:100%;height:100px;">
한동대학교 총동아리연합회는 귀하께서 한동대학교 총동아리연합회 예약 사이트의 이용약관의 내용에 대해 「동의한다」버튼 또는 「동의하지 않는다」버튼을 클릭할 수 있는 절차를 마련하여, 「동의한다」버튼을 클릭하면 개인정보 수집에 대해 동의한 것으로 간주합니다.

※ 본 서비스(사이트)는 만 14세 미만의 아동에 대한 개인정보를 수집하고 있지 않으며, 홈페이지에 아동에게 유해한 정보를 게시하거나 제공하고 있지 않습니다.

한동대학교 총동아리연합회 예약 사이트는 회원가입 시 서비스 이용을 위해 필요한 최소한의 개인정보만을 수집합니다.
귀하가 한동대학교 총동아리연합회 공간 예약 사이트의 서비스를 이용하기 위해서는 회원가입 시 (이름, 휴대폰번호, E-mail 주소, 학번, 학부)를 필수적으로 입력하셔야 합니다.
개인정보 항목별 구체적인 수집목적 및 이용목적은 다음과 같습니다.
- 성명, 이메일주소 : 회원제 서비스 이용에 따른 본인 식별 절차에 이용
- 이메일주소, 전화번호 : 고지사항 전달, 불만처리 등을 위한 원활한 의사소통 경로의 확보, 새로운 서비스 및 뉴스, 이벤트 정보 등의 안내
- 휴대폰번호 : 뉴스 및 이벤트 정보 전달을 위한 확보
- 기타 선택항목 : 개인맞춤 서비스를 제공하기 위한 자료

□ 수집하는 개인정보 항목
① 필수 개인정보 항목
이름, 휴대폰번호,  E-mail 주소, 학번, 학부

□ 개인정보의 보유기간 및 이용기간
한동대학교 총동아리연합회 공간 예약 사이트는 수집된 개인정의 보유기간은 회원가입 하신후 해지(탈퇴신청등)시까지 입니다. 또한 해지시 한동대학교 총동아리연합회 공간 예약 사이트는 회원님의 개인정보를 재생이 불가능한 방법으로 즉시 파기하며 (개인정보가 제3자에게 제공된 경우에는 제3자에게도 파기하도록 지시합니다.) 다만 다음 각호의 경우에는 각 호에 명시한 기간동안 개인정보를 보유합니다.

① 상법 등 법령의 규정에 의하여 보존할 필요성이 있는 경우에는 법령에서 규정한 보존기간 동안 거래내역과 최소한의 기본정보를 보유함
② 보유기간을 회원님에게 미리 고지하고 그 보유기간이 경과하지 아니한 경우와 개별적으로 회원님의 동의를 받을 경우에는 약속한 보유기간 동안 보유함

□ 동의 거부 권리 및 동의 거부 시 불이익 내용
귀하는 개인정보의 수집목적 및 이용목적에 대한 동의를 거부할 수 있으며, 동의 거부시 한동대학교 총동아리연합회 공간 예약 사이트에 회원가입이 되지 않으며, 한동대학교 총동아리연합회 공간 예약 사이트에서 제공하는 제한적인 서비스를 이용할 수 없습니다.

				 </textarea>
		</div>

		<input type="checkbox" name="ch" onclick="clause();">

		약관에 동의하시겠습니까?<br>

		<br/>
			<div class="buttonContainer w3-right">
			<input type="button" id="reserve_button" class="w3-button w3-blue" name="btn" disabled="disabled" value="예약하기" onclick="saveReservation();">
			<input type="button" id="cancle_button" class="w3-button w3-red" value="취소하기" onclick="location.href='./reservation'">
                        
         	</div>
	
	</div>   
         	
	<!-- Footer-->
	<footer class="bg-light py-5">
		<div class="container px-4 px-lg-5">
			<div class="small text-center text-muted">Copyright &copy; 2021
				- 한동대학교 총동아리연합회</div>
		</div>
	</footer>


         
            
            
            

		
	

	<!-- Bootstrap core JS-->
	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js"></script>
	<!-- SimpleLightbox plugin JS-->
	<script
		src="https://cdnjs.cloudflare.com/ajax/libs/SimpleLightbox/2.1.0/simpleLightbox.min.js"></script>
	<!-- Core theme JS-->
	<script src="js/scripts.js"></script>
	<!-- * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *-->
	<!-- * *                               SB Forms JS                               * *-->
	<!-- * * Activate your form at https://startbootstrap.com/solution/contact-forms * *-->
	<!-- * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *-->
	<script src="https://cdn.startbootstrap.com/sb-forms-latest.js"></script>
</body>
</html>