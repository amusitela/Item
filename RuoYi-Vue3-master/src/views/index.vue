<template>
    <div class="header">
    <h1>欢迎使用达梦物流中台系统</h1>
  </div>
  <div class="container">
    <div class="section">
      <h1>达梦物流数据管理</h1>
      <p>通过达梦物流中台系统，您可以管理物流相关的数据，包括订单、运输、仓储等信息。</p>
      <a class="button" href="#">
        <router-link to="/transport/Customer" >开始管理</router-link></a>
    </div>
    <div class="section">
      <h1>达梦物流服务监控</h1>
      <p>通过达梦物流中台系统，您可以实时监控物流服务的状态和性能，并及时发现和解决问题。</p>
      <a class="button" href="#"><router-link to="/datascreen">查看监控</router-link></a>
    </div>
  </div>
</template>

<style>
 /* CSS样式 */
 body {
      font-family: Arial, sans-serif;
      margin: 0;
      padding: 0;
    }

    .header {
      background-color: #333;
      color: #fff;
      padding: 20px;
      text-align: center;
    }

    .container {
      max-width: 1200px;
      margin: 0 auto;
      padding: 20px;
    }

    .section {
      margin-bottom: 30px;
    }

    h1 {
      font-size: 24px;
    }

    p {
      font-size: 16px;
    }

    .button {
      display: inline-block;
      padding: 10px 20px;
      background-color: #333;
      color: #fff;
      text-decoration: none;
      border-radius: 4px;
      transition: background-color 0.3s ease;
    }

    .button:hover {
      background-color: #555;
    }

</style>