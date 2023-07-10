<template>
    <div class="app-container">
      <h2 class="title">全部数据展示
              <el-button type="primary" class="but">一键治理</el-button>
          </h2>
  
      <el-row :gutter="10" class="mb8">
        <el-col :span="1.5">
          <el-button
            type="primary"
            plain
            icon="el-icon-plus"
            size="mini"
            @click="handleAdd"
            v-hasPermi="['system:Conditions:add']"
          >新增</el-button>
        </el-col>
        <el-col :span="1.5">
          <el-button
            type="success"
            plain
            icon="el-icon-edit"
            size="mini"
            :disabled="single"
            @click="handleUpdate"
            v-hasPermi="['system:Conditions:edit']"
          >修改</el-button>
        </el-col>
        <el-col :span="1.5">
          <el-button
            type="danger"
            plain
            icon="el-icon-delete"
            size="mini"
            :disabled="multiple"
            @click="handleDelete"
            v-hasPermi="['system:Conditions:remove']"
          >删除</el-button>
        </el-col>
        <el-col :span="1.5">
          <el-button
            type="warning"
            plain
            icon="el-icon-download"
            size="mini"
            @click="handleExport"
            v-hasPermi="['system:Conditions:export']"
          >导出</el-button>
        </el-col>
        <right-toolbar :showSearch.sync="showSearch" @queryTable="getList"></right-toolbar>
      </el-row>
  
      <el-table v-loading="loading" :data="ConditionsList" @selection-change="handleSelectionChange" :row-class-name="tableRowClassName">
        <el-table-column type="selection" width="55" align="center" />
        <el-table-column label="用户编号" align="center" prop="num" />
        <el-table-column label="用户姓名" align="center" prop="ConditionsName" />
        <el-table-column label="用户电话" align="center" prop="customerName" />
        <el-table-column label="用户地址" align="center" prop="personName" />
        <el-table-column label="用户地址" align="center" prop="phone" />
        <el-table-column label="用户地址" align="center" prop="place" />
        <el-table-column label="用户地址" align="center" prop="error" />

        <el-table-column label="操作" align="center" class-name="small-padding fixed-width">
          <template #default="scope">
            <el-button
              type="primary"
              icon="el-icon-edit"
              @click="handleUpdate(scope.row)"
              v-hasPermi="['system:Conditions:edit']"
            >修改</el-button>
            <el-button
              type="primary"
              icon="el-icon-delete"
              @click="handleDelete(scope.row)"
              v-hasPermi="['system:Conditions:remove']"
            >删除</el-button>
          </template>
        </el-table-column>
      </el-table>
      
      <pagination
        v-show="total>0"
        :total="total"
        :page.sync="queryParams.pageNum"
        :limit.sync="queryParams.pageSize"
        @pagination="getList"
      />
  
      <!-- 添加或修改111对话框 -->
      <el-dialog :title="title" v-model="updateopen" width="680px" append-to-body>
           <el-form ref="ConditionsRef" :model="form" :rules="rules" label-width="100px">
  
          <el-form-item label="用户姓名" prop="shipCompany">
            <el-input v-model="form.shipCompany" placeholder="请输入用户姓名" />
          </el-form-item>
          <el-form-item label="手机号" prop="shipName">
            <el-input v-model="form.shipName" placeholder="请输入手机号" />
          </el-form-item>
          <el-form-item label="地址" prop="ws">
            <el-input v-model="form.ws" placeholder="请输入地址" />
          </el-form-item>
          <el-form-item label="地址" prop="we">
            <el-input v-model="form.we" placeholder="请输入地址" />
          </el-form-item>
          <el-form-item label="地址" prop="start">
            <el-input v-model="form.start" placeholder="请输入地址" />
          </el-form-item>
          <el-form-item label="地址" prop="end">
            <el-input v-model="form.end" placeholder="请输入地址" />
          </el-form-item>
          <el-form-item label="地址" prop="port">
            <el-input v-model="form.port" placeholder="请输入地址" />
          </el-form-item>
          <el-form-item label="地址" prop="tNum">
            <el-input v-model="form.tNum" placeholder="请输入地址" />
          </el-form-item>
          <el-form-item label="地址" prop="containerNum">
            <el-input v-model="form.containerNum" placeholder="请输入地址" />
          </el-form-item>
          <el-form-item label="地址" prop="splace">
            <el-input v-model="form.splace" placeholder="请输入地址" />
          </el-form-item>
          <el-form-item label="地址" prop="eplace">
            <el-input v-model="form.eplace" placeholder="请输入地址" />
          </el-form-item>
          <el-form-item label="地址" prop="goods">
            <el-input v-model="form.goods" placeholder="请输入地址" />
          </el-form-item>
          <el-form-item label="地址" prop="status">
            <el-input v-model="form.status" placeholder="请输入地址" />
          </el-form-item>
        </el-form>
        <div slot="footer" class="dialog-footer">
          <el-button type="primary" @click="updateForm">确 定</el-button>
          <el-button @click="updatecancel">取 消</el-button>
        </div>
      </el-dialog>
      <el-dialog :title="title" v-model="addopen" width="680px" append-to-body>
           <el-form ref="ConditionsRef" :model="form" :rules="rules" label-width="100px">
  
          <el-form-item label="用户姓名" prop="shipCompany">
            <el-input v-model="form.shipCompany" placeholder="请输入用户姓名" />
          </el-form-item>
          <el-form-item label="手机号" prop="shipName">
            <el-input v-model="form.shipName" placeholder="请输入手机号" />
          </el-form-item>
          <el-form-item label="地址" prop="ws">
            <el-input v-model="form.ws" placeholder="请输入地址" />
          </el-form-item>
          <el-form-item label="地址" prop="we">
            <el-input v-model="form.we" placeholder="请输入地址" />
          </el-form-item>
          <el-form-item label="地址" prop="start">
            <el-input v-model="form.start" placeholder="请输入地址" />
          </el-form-item>
          <el-form-item label="地址" prop="end">
            <el-input v-model="form.end" placeholder="请输入地址" />
          </el-form-item>
          <el-form-item label="地址" prop="port">
            <el-input v-model="form.port" placeholder="请输入地址" />
          </el-form-item>
          <el-form-item label="地址" prop="tNum">
            <el-input v-model="form.tNum" placeholder="请输入地址" />
          </el-form-item>
          <el-form-item label="地址" prop="containerNum">
            <el-input v-model="form.containerNum" placeholder="请输入地址" />
          </el-form-item>
          <el-form-item label="地址" prop="splace">
            <el-input v-model="form.splace" placeholder="请输入地址" />
          </el-form-item>
          <el-form-item label="地址" prop="eplace">
            <el-input v-model="form.eplace" placeholder="请输入地址" />
          </el-form-item>
          <el-form-item label="地址" prop="goods">
            <el-input v-model="form.goods" placeholder="请输入地址" />
          </el-form-item>
          <el-form-item label="地址" prop="status">
            <el-input v-model="form.status" placeholder="请输入地址" />
          </el-form-item>
        </el-form>
        <div slot="footer" class="dialog-footer">
          <el-button type="primary" @click="addForm">确 定</el-button>
          <el-button @click="addcancel">取 消</el-button>
        </div>
      </el-dialog>
    </div>
  </template>
  
  
  <script setup name="Conditions">
  import { addConditions, delConditions, getConditions, listConditions, updateConditions } from "@/api/system/Conditions";
  import { ref, reactive } from "vue";
  const { proxy } = getCurrentInstance();
  const { sys_show_hide, sys_normal_disable } = proxy.useDict("sys_show_hide", "sys_normal_disable");
  
  const ConditionsList = ref([]);
  const ids = ref([]);
  
  const updateopen = ref(false);
  const addopen = ref(false);
  const loading = ref(true);
  const showSearch = ref(true);
  const title = ref("");
  const total = ref("");
  const single = ref(true);
  const multiple = ref(true);
  
  const data = reactive({
    form: {},
    queryParams: {
      pageNum: 1,
          pageSize: 10,
          num: null,
          ConditionsName: null,
          customerName: null,
          personName: null,
          phone:null,
          place:null
    },
    rules: {
     
    },
  });
  //判断样式
  const regex = /(^\d{15}$)|(^\d{18}$)|(^\d{17}(\d|X|x)$)/;
  const tableRowClassName = ({
  row,
  rowIndex,
  }) => {
  if (regex.test(row.id)) {
  return 'success-row'
  } else{
  return 'warning-row'
  }
  }
  const { queryParams, form, rules } = toRefs(data);
  function handleSelectionChange(selection) {
        ids = selection.map(item => item.id)
        single.value = selection.length!==1
        multiple.value = !selection.length
      }
  /** 查询菜单列表 */
  function getList() {
    loading.value = true;
    listConditions(queryParams.value).then(response => {
      ConditionsList.value = response.rows;
        total.value = response.total;
        loading.value = false;
    });
  }
  /** 取消按钮 */
  function addcancel() {
    addopen.value = false;
    reset();
  }
  function updatecancel() {
    updateopen.value = false;
    reset();
  }
  /** 表单重置 */
  function reset() {
    form.value = {
      id: null,
          name: null,
          phone: null,
          address: null
    };
    proxy.resetForm("form");
  }
  
  
  /** 新增按钮操作 */
  function handleAdd(row) {
    reset();
    addopen.value = true;
    title.value = "添加客户";
  }
  /** 修改按钮操作 */
  async function handleUpdate(row) {
    reset();
    const Conditionsid = row.id || this.ids
    getConditions(Conditionsid).then(response => {
      form.value = response.data;
      updateopen.value = true;
      title.value = "修改客户";
    });
  }
  /** 提交按钮 */
  function updateForm() {
    proxy.$refs["ConditionsRef"].validate(valid => {
      if (valid) {
        
          updateConditions(form.value).then(response => {
            proxy.$modal.msgSuccess("修改成功");
            updateopen.value = false;
            getList();
          });
      
        
      }
    });
  }
  function addForm() {
    proxy.$refs["ConditionsRef"].validate(valid => {
      if (valid) {
       
          addConditions(form.value).then(response => {
            proxy.$modal.msgSuccess("新增成功");
            addopen.value = false;
            getList();
          });
        
      }
    });
  }
  /** 删除按钮操作 */
  function handleDelete(row) {
    const Conditionsids = row.id || ids;
    proxy.$modal.confirm('是否确认删除名称为"' + ids + '"的数据项?').then(function() {
      return delConditions(Conditionsids);
    }).then(() => {
      getList();
      proxy.$modal.msgSuccess("删除成功");
    }).catch(() => {});
  }
  
  getList();
  </script>
  
  <style>
  .content{
      margin: 0 auto;
  }
  .title{
      text-align: center;
  }
  .table{
      width: 100%;
      margin: 0 15%;
  }
  .el-table .warning-row {
    --el-table-tr-bg-color: var(--el-color-warning-light-9);
  }
  .el-table .success-row {
    --el-table-tr-bg-color: var(--el-color-success-light-9);
  }
  .but{
      float: right;
      margin-right: 15%;
  }
  .tableRowClassName{
    --el-table-tr-bg-color: var(--el-color-warning-light-9);
  }
  </style>
  