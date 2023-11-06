<%--
  Created by IntelliJ IDEA.
  User: OS
  Date: 11/3/2023
  Time: 11:52 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.1.2/css/all.min.css">
  <style>
    ul {
      list-style-type: none;
    }
    p {
      font-family: Roboto;
    }
    body.new-design .hero .hero-title .eyebrow {
      font-size: 12px;
      line-height: 16px;
      font-weight: 700;
      letter-spacing: -.05em;
      text-transform: uppercase;
      padding-bottom: 0.5rem;
      margin-bottom: 0;
    }
    .hero .hero-title {
      color: #fff;
      font-size: 66px;
      letter-spacing: 2px;
      font-variant-ligatures: none;
      line-height: 70px;
      margin-bottom: 16px;
      position: relative;
      text-transform: uppercase;
      z-index: 25;
    }
    h1:not([class*=is-title-]), .is-title-xxl {
      font-size: 2.5rem;
      font-weight: 100;
      letter-spacing: -0.05em;
      line-height: 2.5rem;
      text-transform: uppercase;
    }
    .card{
      border: none;
    }
    .cc-announcement {
      background-color: rgb(255, 255, 255);
      color: rgb(255, 255, 255);
      position: relative;
      text-align: center;
      transition: max-height 1s, opacity 0.5s, visibility 0.5s;
    }

    a:-webkit-any-link {
      color: -webkit-link;
      cursor: pointer;
      text-decoration: underline;
    }

    a {
      text-decoration: none !important;
      /*color: inherit;*/
      -webkit-transition: color 150ms, background-color 150ms;
      -ms-transition: color 150ms, background-color 150ms;
      -moz-transition: color 150ms, background-color 150ms;
      -o-transition: color 150ms, background-color 150ms;
      transition: color 150ms, background-color 150ms;
      color: black;
    }

    @media (min-width: 1400px) {
      .site-control.nav-inline-desktop .nav-right-side {
        width: 270px;
      }
    }

    @media (min-width: 1441px) {
      .site-control.nav-inline-desktop .nav-row .nav-columns {
        padding-left: 90px;
        padding-right: 90px;
      }
    }
    .color-text{
      color: black;
    }
    video {
      width: 100%;
    }
    lifestyle-video {
      height: auto;
    }
  </style>
  <title>Title</title>
  <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
  <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p" crossorigin="anonymous"></script>
</head>
<body>

<footer>
  <div style="background: rgb(246,245,243) ">
    <div class="container px-0 py-5">
      <div class="row">
        <div class="col-lg-2 col-md-4 col-sm-6">
          <div class="col d-flex align-items-start">

            <img src="https://i.imgur.com/DcmDJP6.png" height="23" width="23"/>
            <div>
              <h6 class="align-middle px-2">Đổi trả trong 7 ngày</h6>
            </div>
          </div>
        </div>
        <div class="col-lg-2 col-md-4">
          <div class="col d-flex align-items-start">

            <img src="https://i.imgur.com/VAaf2IG.png" height="25" width="25"/>
            <div>
              <h6 class="align-middle px-1">Mọi lúc mọi nơi</h6>
            </div>
          </div>
        </div>
        <div class="col-lg-2 col-md-4">
          <div class="col d-flex align-items-start">
            <img src="https://i.imgur.com/BI541KU.png" height="25" width="25"/>
            <div>
              <h6 class="align-middle px-1">Phục vụ 24/24</h6>
            </div>
          </div>
        </div>
        <div class="col-lg-2 col-md-4">
          <div class="col d-flex align-items-start">

            <img src="https://i.imgur.com/JpO2qnU.png" height="25" width="25"/>
            <div>
              <h6 class="align-middle ">Giao hàng toàn quốc </h6>
            </div>
          </div>
        </div>
        <div class="col-lg-2 col-md-4">
          <div class="col d-flex align-items-start">

            <img src="https://i.imgur.com/fwWwyoR.png" height="25" width="25"/>
            <div>
              <h6 class="align-middle px-1">Bảo mật tuyệt đối</h6>
            </div>
          </div>
        </div>
        <div class="col-lg-2 col-md-4">
          <div class="col d-flex align-items-start">

            <img src="https://i.imgur.com/MqPKZXs.png" height="25" width="25"/>
            <div>
              <h6 class="align-middle px-1">Cam kết chất lượng</h6>
            </div>
          </div>
        </div>
      </div>
    </div>
  </div>
  <div>
    <div class="container mt-lg-5">
      <div class="row justify-content-center">
        <div class="col-5"></div>
        <div class="col-2">
          <p style="font-size: 1.5rem;font-family: Cantarell">
            HAPPY ENDING
          </p>
        </div>
        <div class="col-5"></div>
      </div>
    </div>
  </div>
  <div>
    <div class="container mt-5">
      <div class="row justify-content-center">
        <div class="col-6 ">
          <video autoplay muted loop>
            <source src="https://componentsfront.guccidigital.io/horsebit_loafer_spa_2/static/video/Paul_Mescal_1080x1350.mp4"
                    type="video/mp4">
          </video>
        </div>
        <div class="col-lg-6 ">
          <div class="col-lg-6 ">
            <br>
            <br>
            <br>
            <br>
            <br>
            <br>
            <br>
            <br>
            <div class="container  offset-8">
              <h1> 20 năm của Luna Brothers</h1>
              <p class=" " tabindex="-1"
                 style="opacity: 1;">Nguyễn Quyền và Đại sứ thương hiệu toàn cầu Xiao Zhan tổ chức lễ kỷ niệm
                phong cách mang tính biểu tượng trong một chiến dịch mới. </p>
              <span>Mang tất cả những điều tốt đẹp với tất cả mọi người</span>
            </div>
          </div>
        </div>
      </div>
    </div>
  </div>
  <div>
    <div class="row ps-5 mt-5 pt-5 _footer m-0">
      <table class="table  table-borderless bg-white ">
        <tr>
          <th>What's new</th>
          <th>Microsoft Store</th>
          <th>Education</th>
          <th>Business</th>
          <th>Developer & IT</th>
          <th>Company</th>
        </tr>
        <tr>
          <td><a class="text-dark" href="">Surface Laptop Studio 2</a></td>
          <td><a class="text-dark" href="">Account profile</a></td>
          <td><a class="text-dark" href="">Microsoft in education</a></td>
          <td><a class="text-dark" href="">Microsoft Cloud</a></td>
          <td><a class="text-dark" href="">Azure</a></td>
          <td><a class="text-dark" href="">Careers</a></td>
        </tr>
        <tr>
          <td><a class="text-dark" href="">Surface Laptop Go 3</a></td>
          <td><a class="text-dark" href="">Download Center</a></td>
          <td><a class="text-dark" href="">Devices for education</a></td>
          <td><a class="text-dark" href="">Microsoft Security</a></td>
          <td><a class="text-dark" href="">Developer Center</a></td>
          <td><a class="text-dark" href="">About Microsoft</a></td>
        </tr>
      </table>
      <div class="d-flex flex-row-reverse">
        <ul class="d-flex">
          <li class="m-2">Terms of use</li>
          <li class="m-2">Trademarks</li>
          <li class="m-2">Safety & eco</li>
          <li class="m-2">Recycling</li>
          <li class="m-2">About our ads</li>
          <li class="m-2">© Microsoft 2023</li>
        </ul>
      </div>
    </div>
  </div>

</footer>
</body>
</html>
